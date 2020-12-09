package ru.unclediga.spec.service.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("hello")
public class HelloRS {

    //http://localhost:8080/java_lev3ejb/rest/hello?name=Dear%20Friend
    @GET
    public Response hello(@QueryParam("name") String textName) {
        return Response
                .ok("Hello, " + textName + "!")
                .build();
    }
}
