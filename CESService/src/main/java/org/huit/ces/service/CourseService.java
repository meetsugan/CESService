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
import org.huit.ces.model.Course;

@Path("courses")
public class CourseService {

	private CouchbaseElasticUtil couchbaseElasticUtil = null;

	public CourseService() {
		couchbaseElasticUtil = new CouchbaseElasticUtil(
				CouchBaseConnectionProvider.instance.getClient(),
				ElasticSearchConnectionProvider.instance.getClient());
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getAllCourses() {
		return couchbaseElasticUtil.findAll(Course.class);
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Course createCourse(Course reqCourse) {
		if (reqCourse != null) {
			reqCourse = couchbaseElasticUtil.save(reqCourse);
		}
		return reqCourse;
	}


	@POST
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Course updateCourse(@PathParam(value = "id") String id, Course reqCourse) {
		if (reqCourse != null) {
			reqCourse = couchbaseElasticUtil.save(reqCourse);
		}
		return reqCourse;
	}

	
	@DELETE
	@Path("/{id}")
	public void deleteCourse(@PathParam(value = "id") String id) {
		couchbaseElasticUtil.delete(id, Course.class);
	}

}
