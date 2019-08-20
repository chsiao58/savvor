package savvy.savor.Http;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import savvy.savor.Model.Product;

@Component
public class NixRetriever {
    private RestTemplate restTemplate = new RestTemplate();
    private HttpEntity entity;

    public NixRetriever() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // TODO: Need a better way to store id and key!! actual key not shown for secure reason
        headers.set("x-app-id", "e074132f");
        headers.set("x-app-key", "xxxxxxxxxxx");
        headers.set("x-remote-user-id","0");
        entity = new HttpEntity(headers);

    }

    public <T> ResponseEntity<T> exchange(String destination, HttpMethod method, Class<T> classType) {
        return restTemplate.exchange(
                "https://trackapi.nutritionix.com/" + destination,
                method, entity, classType);

    }
}
