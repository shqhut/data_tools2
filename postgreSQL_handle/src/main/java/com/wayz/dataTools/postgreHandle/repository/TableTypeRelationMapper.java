package com.wayz.dataTools.postgreHandle.repository;

import com.wayz.dataTools.postgreHandle.dto.TableTypeRelationDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TableTypeRelationMapper {

    List<TableTypeRelationDto> getActiveRelation();

}
