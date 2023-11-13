package com.example.demo;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import java.util.List;

@Service
public class UserService {
    private RestOperations restTemplate;

    public UserService(RestOperations restTemplate){
        this.restTemplate = restTemplate;
    }

//    "id": 1,
//            "name": "Leanne Graham",
//            "username": "Bret",
//            "email": "Sincere@april.biz",
//            "address": {
//        "street": "Kulas Light",
//                "suite": "Apt. 556",
//                "city": "Gwenborough",
//                "zipcode": "92998-3874",
//                "geo": {
//            "lat": "-37.3159",
//                    "lng": "81.1496"
//        }
//    },
//            "phone": "1-770-736-8031 x56442",
//            "website": "hildegard.org",
//            "company": {
//        "name": "Romaguera-Crona",
//                "catchPhrase": "Multi-layered client-server neural-net",
//                "bs": "harness real-time e-markets"
//    }

//    https://jsonplaceholder.typicode.com/users
    public List<User> fetchData(){
        String url="https://jsonplaceholder.typicode.com/users";
        ResponseEntity<List<Reader>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Reader>>() {
        });

        List<User> userList = response.getBody().stream().map(r-> new User(r.getId(), r.getUsername(), r.getEmail(), r.getAddress().getZipcode())).toList();

       return userList;

    }
}
