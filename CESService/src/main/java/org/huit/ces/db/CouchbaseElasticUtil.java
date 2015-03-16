package org.huit.ces.db;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.huit.ces.model.BaseModel;

import com.couchbase.client.CouchbaseClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CouchbaseElasticUtil {
	
	CouchbaseClient couchbaseClient = null;
	TransportClient elasticSearchClient = null;
	Gson gson = new GsonBuilder().setDateFormat("EEE, d MMM yyyy HH:mm:ss Z").create();
	
	public CouchbaseElasticUtil(CouchbaseClient couchbaseClient, TransportClient elasticSearchClient) {
		this.couchbaseClient=couchbaseClient;
		this.elasticSearchClient = elasticSearchClient;
	}
	
	public <T extends BaseModel> T save (T obj){
		
		if(obj.getId()==null){
			//Assemble Id...
			obj.setId(UUID.randomUUID().toString());
		}
		couchbaseClient.set(obj.getClass().getSimpleName()+"::"+obj.getId(), gson.toJson(obj));
		
		return obj;
	}
	
	
public <T extends BaseModel> T get (String id,  Class<T> clazz){
		T t = gson.fromJson((String) couchbaseClient.get(clazz.getSimpleName()+"::"+id), clazz);
		return t;
	}

public <T extends BaseModel> T getByFullID (String fullID,  Class<T> clazz){
	T t = gson.fromJson((String) couchbaseClient.get(fullID), clazz);
	return t;
}

public void delete (String id,  Class clazz){
	 couchbaseClient.delete(clazz.getSimpleName()+"::"+id);
}

public void deleteByFullID (String id){
	 couchbaseClient.delete(id);
}
public void delete( BaseModel obj){
	if(obj!=null){
	 couchbaseClient.delete(obj.getClass().getSimpleName()+"::"+obj.getId());
	}
}


public <T extends BaseModel> List<T> findAll(Class<T> clazz){
	
	List<T> list = new ArrayList<T>();
	SearchResponse response = elasticSearchClient.prepareSearch()
	        .setQuery(QueryBuilders.matchQuery("doc.type", clazz.getSimpleName()))            
	        .execute()
	        .actionGet();	
	
	if(response!=null && response.getHits().hits().length>0){
		
		 for(SearchHit hit : response.getHits().hits()){
			 T t = getByFullID(hit.getId().toString(),clazz);
			 if(t!=null){
				 list.add(t);
			 }
		 }
		
	}
	return list;
}
			

}
