package com.app.week8.utils;

import com.app.week8.rest.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

public class RestUtils {
    private static RestTemplate restTemplate = new RestTemplate();

    public static void addUser(String path, UserDto u) throws URISyntaxException {
        URI uri = new URI(path);
        ResponseEntity responseEntity = restTemplate.postForEntity(uri, u, UserDto.class);
        System.out.println(responseEntity.getStatusCode());
    }

    public static List<UserDto> getAllUsersByFactory(String path, String fId) throws URISyntaxException {
        URI uri = new URI(path + "/" + fId);
        ResponseEntity responseEntity = restTemplate.getForEntity(uri, List.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return (List<UserDto>) responseEntity.getBody();
        }
        return Collections.EMPTY_LIST;
    }
}
