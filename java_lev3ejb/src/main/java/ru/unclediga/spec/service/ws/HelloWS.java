package ru.unclediga.spec.service.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "HelloWS")
public class HelloWS {

    //http://localhost:8080/java_lev3ejb/HelloWS?wsdl
    @WebMethod(operationName = "name")
    public String hello(@WebParam(name = "name") String textName) {
        return "Hello, " + textName + "!";
    }
}
