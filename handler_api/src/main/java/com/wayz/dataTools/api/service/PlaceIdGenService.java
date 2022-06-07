package com.wayz.dataTools.api.service;

import com.wayz.dataTools.postgreHandle.dto.TableTypeRelationDto;

import java.util.List;

public interface PlaceIdGenService {

    void handlePlaceId(List<TableTypeRelationDto> relationDtoList);
}
