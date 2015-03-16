package org.huit.ces.db;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;


public class ElasticSearchConnectionProvider {

	private static TransportClient esClient = null;
	public static ElasticSearchConnectionProvider instance = new ElasticSearchConnectionProvider();
	
	static{
			esClient = new TransportClient()
	        .addTransportAddress(new InetSocketTransportAddress("54.86.140.104", 9300));
	}
	
	private ElasticSearchConnectionProvider(){
		
	}
	
	public TransportClient getClient(){
		return esClient;
	}

}
