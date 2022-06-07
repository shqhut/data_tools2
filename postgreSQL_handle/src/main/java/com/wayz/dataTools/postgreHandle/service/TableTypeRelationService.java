package com.wayz.dataTools.postgreHandle.service;

import com.wayz.dataTools.postgreHandle.dto.TableTypeRelationDto;

import java.util.List;

public interface TableTypeRelationService {

    List<TableTypeRelationDto> getActiveRelation();
}
