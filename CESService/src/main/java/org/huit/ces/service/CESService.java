package org.huit.ces.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.huit.ces.model.User;

@Path("")
public class CESService {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        return "{ \"result\":[ {\"title\":\"Saravanan Krishnaraj\",\"harvardID\":\"1\", \"courseRole\":\"Instructor\",\"courseID\":\"101\"},"
        		+ "{\"title\":\"Sugan Krishnaraj\",\"harvardID\":\"2\", \"courseRole\":\"TF\",\"courseID\":\"102\"}]}";
    }
    
    
    @POST
    @Path("/users/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User updateUser(@PathParam(value = "id") String id, User reqUser) {
    	
    	User user = new User();
    	user.setCourseID("12312");
    	user.setCourseRole("TF");
    	user.setHarvardID("10000");
    	user.setTitle("Saravanan");
    	return user;
        
    }
    
    @POST
    @Path("/users/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User createUser( User reqUser) {
    	
    	if(reqUser!=null){
    		//save
    	}
    	return reqUser;	
    }
    
    
    @DELETE
    @Path("/users/{id}")
    public void deleteUser(@PathParam(value = "id") String  id) {
    	
    }
    
}
