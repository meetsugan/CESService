package org.huit.ces.db;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.couchbase.client.CouchbaseClient;
import com.couchbase.client.CouchbaseConnectionFactory;


public class CouchBaseConnectionProvider {

	private static CouchbaseClient couchbaseClient = null;
	public static CouchBaseConnectionProvider instance = new CouchBaseConnectionProvider();
	
	static{
		List<URI> urls= new ArrayList<URI>();
		
		try {
			urls.add(new URI("http://54.86.140.104:8091"));
			CouchbaseConnectionFactory couchbaseFactory = new CouchbaseConnectionFactory(urls, "default", "");
			couchbaseClient = new CouchbaseClient(couchbaseFactory);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private CouchBaseConnectionProvider(){
		
	}
	
	public CouchbaseClient getClient(){
		return couchbaseClient;
	}

}
