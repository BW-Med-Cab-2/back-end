package com.lambdaschool.foundation.controllers;
import com.lambdaschool.foundation.models.StrainModel;
import com.lambdaschool.foundation.models.TopWhatever;
import com.lambdaschool.foundation.models.User;
import com.lambdaschool.foundation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/otherapis")
public class OtherApis {
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    UserService userService;

    @GetMapping(value = "/strainmodel")
    public ResponseEntity<?> getStrainModel() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        restTemplate.getMessageConverters().add(converter);

        String requestURL = "https://med-cab-1415.herokuapp.com/model";

        ParameterizedTypeReference<StrainModel> responseType = new ParameterizedTypeReference<>(){};

        ResponseEntity<StrainModel> responseEntity = restTemplate.exchange(requestURL,
                HttpMethod.GET,
                null,
                responseType);

        StrainModel strainModel = responseEntity.getBody();

        return new ResponseEntity<>(strainModel, HttpStatus.OK);
    }

    @GetMapping(value = "/toptenrating")
    public ResponseEntity<?> getTopRated() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        restTemplate.getMessageConverters().add(converter);

        String requestURL = "https://greensolx2.herokuapp.com/toptenrating";

        ParameterizedTypeReference<List<TopWhatever>> responseType = new ParameterizedTypeReference<>(){};

        ResponseEntity<List<TopWhatever>> responseEntity = restTemplate.exchange(requestURL,
                HttpMethod.GET,
                null,
                responseType);

        List<TopWhatever> topWhatever = responseEntity.getBody();

        return new ResponseEntity<>(topWhatever, HttpStatus.OK);
    }

    @GetMapping(value = "/toptenflavor")
    public ResponseEntity<?> getTopFlavor() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        restTemplate.getMessageConverters().add(converter);

        String requestURL = "https://greensolx2.herokuapp.com/toptenflavor";

        ParameterizedTypeReference<List<TopWhatever>> responseType = new ParameterizedTypeReference<>(){};

        ResponseEntity<List<TopWhatever>> responseEntity = restTemplate.exchange(requestURL,
                HttpMethod.GET,
                null,
                responseType);

        List<TopWhatever> topWhatever = responseEntity.getBody();

        return new ResponseEntity<>(topWhatever, HttpStatus.OK);
    }

    @PostMapping(value = "/strainmodel/{somestring}")
    public ResponseEntity<?> sendStrainInfo(
            @Valid
            @PathVariable
                String somestring) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        restTemplate.getMessageConverters().add(converter);

        String requestURL = "https://med-cab-1415.herokuapp.com/model/" + somestring;

        ParameterizedTypeReference<StrainModel> responseType = new ParameterizedTypeReference<>(){};

        ResponseEntity<StrainModel> responseEntity = restTemplate.exchange(requestURL,
                HttpMethod.GET,
                null,
                responseType);

        StrainModel strainModel = responseEntity.getBody();

        User currentUser = userService.getCurrentUser();
        currentUser.setCurrentStrain(strainModel);

        return new ResponseEntity<>(currentUser, HttpStatus.OK);
    }
}
