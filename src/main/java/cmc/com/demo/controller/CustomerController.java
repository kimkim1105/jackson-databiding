package cmc.com.demo.controller;

import cmc.com.demo.entity.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("cus")
    public ResponseEntity<?> getCus() throws JsonProcessingException {
        String cusString = String.valueOf(webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/cus")
                .retrieve()
                .bodyToMono(String.class)
                .block());
        ObjectMapper mapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();
        Customer[] customers = mapper.readValue(cusString,Customer[].class);
        List<Customer> customerList = new ArrayList<>(Arrays.asList(customers));
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

}
