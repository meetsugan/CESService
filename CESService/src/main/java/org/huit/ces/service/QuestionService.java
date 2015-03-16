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
import org.huit.ces.model.Question;

@Path("questions")
public class QuestionService {

	private CouchbaseElasticUtil couchbaseElasticUtil = null;

	public QuestionService() {
		couchbaseElasticUtil = new CouchbaseElasticUtil(
				CouchBaseConnectionProvider.instance.getClient(),
				ElasticSearchConnectionProvider.instance.getClient());
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Question> getAllQuestions() {
		return couchbaseElasticUtil.findAll(Question.class);
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Question createQuestion(Question reqQuestion) {
		if (reqQuestion != null) {
			reqQuestion = couchbaseElasticUtil.save(reqQuestion);
		}
		return reqQuestion;
	}


	@POST
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Question updateQuestion(@PathParam(value = "id") String id, Question reqQuestion) {
		if (reqQuestion != null) {
			reqQuestion = couchbaseElasticUtil.save(reqQuestion);
		}
		return reqQuestion;
	}

	
	@DELETE
	@Path("/{id}")
	public void deleteQuestion(@PathParam(value = "id") String id) {
		couchbaseElasticUtil.delete(id, Question.class);
	}

}
