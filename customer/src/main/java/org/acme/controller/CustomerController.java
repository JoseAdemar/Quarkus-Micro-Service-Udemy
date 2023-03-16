package org.acme.controller;

import org.acme.dto.CustomerDTO;
import org.acme.service.CustomerService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/customers")
public class CustomerController {
    @Inject
    private CustomerService customerService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerDTO> findAllCustomers() {
        return customerService.findAllCustomer();
    }

    @POST
    @Transactional
    public Response saveCustomer(CustomerDTO customerDTO) {
        try {
            customerService.createNewCustomer(customerDTO);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response changeCustomer(@PathParam("id") Long id, CustomerDTO customerDTO) {
        try {
            customerService.changeCustomer(id, customerDTO);
            return Response.accepted().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }

    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteCustomer(@PathParam("id") Long id){
        try{
            customerService.deleteCustomer(id);
            return Response.noContent().build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

}
