package ru.unclediga.spec.service.rs;

import ru.unclediga.spec.model.Customer;
import ru.unclediga.spec.service.CustomerService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Path("/customer")
public class CustomerServiceRS {
    @Inject
    private CustomerService customerService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Customer> customers = new ArrayList<>(customerService.getAll());
        return Response
                .ok(new GenericEntity<List<Customer>>(customers) {
                })
                .build();
    }

    // http://localhost:8080/java_lev3ejb/rest/customer/3
    @GET
    @Path("{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("customerId") Long id) {
        final Customer customer = customerService.getById(id);
        final Response.ResponseBuilder builder;
        if (customer != null) {
            builder = Response
                    .ok(customer);
        } else {
            builder = Response
                    .status(Response.Status.NOT_FOUND);
        }
        return builder.build();
    }

    @DELETE
    @Path("{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("customerId") Long id) {
        final Customer customer = customerService.getById(id);
        final Response.ResponseBuilder builder;
        if (customer != null) {
            builder = Response
                    .ok(customer);
        } else {
            builder = Response
                    .status(Response.Status.NOT_FOUND);
        }
        return builder.build();
    }
}
