package com.wayz.dataTools.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wayz.dataTools.api.dto.PlaceIdGenParamDto;
import com.wayz.dataTools.api.dto.PlaceIdGenResultDto;
import com.wayz.dataTools.api.dto.PlaceInfo;
import com.wayz.dataTools.api.dto.PointDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PlaceIdHandlerController {

    @Autowired
    private RestTemplate restTemplate;

    private String placeId_url = "http://172.3.0.98:18000/maps/geoforge/placeid/v1/placeids";

    @RequestMapping(value = "/handlePlaceId")
    public String PlaceIdHandlerView(){
        return "handlePlaceId";
    }

    @RequestMapping(value = "/testPlaceId")
    public String testPlaceId(){

        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        PlaceIdGenParamDto placeIdGenParamDto = new PlaceIdGenParamDto();
        List<PlaceInfo> placeIds = new ArrayList<>();
        placeIdGenParamDto.setPlaceIds(placeIds);
        PlaceInfo placeInfo = new PlaceInfo();
        placeInfo.setPoint(new PointDto(113.326967,22.910459));
        placeInfo.setTypeId(325);
        placeInfo.setSpatialReference("GCJ02");
        placeIds.add(placeInfo);
        String content = null;
        try {
            content = new ObjectMapper().writeValueAsString(placeIdGenParamDto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        HttpEntity<String> formEntity = new HttpEntity<>(content, headers);
        ResponseEntity<PlaceIdGenResultDto> responseEntity = restTemplate.exchange(placeId_url, HttpMethod.POST, formEntity, PlaceIdGenResultDto.class);
        PlaceIdGenResultDto placeIdGenResult = responseEntity.getBody();

        return "success";
    }

}
