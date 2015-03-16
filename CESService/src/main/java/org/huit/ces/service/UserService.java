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
import org.huit.ces.model.User;

@Path("users")
public class UserService {

	private CouchbaseElasticUtil couchbaseElasticUtil = null;

	public UserService() {
		couchbaseElasticUtil = new CouchbaseElasticUtil(
				CouchBaseConnectionProvider.instance.getClient(),
				ElasticSearchConnectionProvider.instance.getClient());
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers() {
		return couchbaseElasticUtil.findAll(User.class);
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User createUser(User reqUser) {
		if (reqUser != null) {
			reqUser = couchbaseElasticUtil.save(reqUser);
		}
		return reqUser;
	}


	@POST
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User updateUser(@PathParam(value = "id") String id, User reqUser) {
		if (reqUser != null) {
			reqUser = couchbaseElasticUtil.save(reqUser);
		}
		return reqUser;
	}

	
	@DELETE
	@Path("/{id}")
	public void deleteUser(@PathParam(value = "id") String id) {
		couchbaseElasticUtil.delete(id, User.class);
	}

}
