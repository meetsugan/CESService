package org.huit.ces.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.huit.ces.db.CouchBaseConnectionProvider;
import org.huit.ces.db.CouchbaseElasticUtil;
import org.huit.ces.db.ElasticSearchConnectionProvider;
import org.huit.ces.model.Answer;

@Path("answers")
public class AnswerService {

	private CouchbaseElasticUtil couchbaseElasticUtil = null;

	public AnswerService() {
		couchbaseElasticUtil = new CouchbaseElasticUtil(
				CouchBaseConnectionProvider.instance.getClient(),
				ElasticSearchConnectionProvider.instance.getClient());
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Answer> getAllAnswers() {
		return couchbaseElasticUtil.findAll(Answer.class);
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Answer createAnswer(Answer reqAnswer) {
		if (reqAnswer != null) {
			reqAnswer = couchbaseElasticUtil.save(reqAnswer);
		}
		return reqAnswer;
	}


	@POST
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Answer updateAnswer(@PathParam(value = "id") String id, Answer reqAnswer) {
		if (reqAnswer != null) {
			reqAnswer = couchbaseElasticUtil.save(reqAnswer);
		}
		return reqAnswer;
	}

	
	@DELETE
	@Path("/{id}")
	public void deleteAnswer(@PathParam(value = "id") String id) {
		couchbaseElasticUtil.delete(id, Answer.class);
	}

}
