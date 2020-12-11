package ru.unclediga.spec.client;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.StringReader;

public class ClientRS {
    public static void main(String[] args) {
        // jersey-client
        final Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/java_lev3ejb/rest/customer");
        final Response response = target.request().get();
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            final String result = response.readEntity(String.class);
            System.out.println("response = " + result);

            // org.glassfish » javax.json
            // JSR 374 (JSON Processing) Default Provider
            // Default provider for JSR 374:Java API for Processing JSON
            final JsonReader jsonReader = Json.createReader(new StringReader(result));
            final JsonArray array = jsonReader.readArray();
            for (JsonValue jsonValue : array) {
                System.out.println("type:" + jsonValue.getValueType() + " str:" + jsonValue.toString());
            }
        }
    }
}
