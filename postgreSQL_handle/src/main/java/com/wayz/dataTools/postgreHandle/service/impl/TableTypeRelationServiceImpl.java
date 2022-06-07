package com.wayz.dataTools.postgreHandle.service.impl;

import com.wayz.dataTools.postgreHandle.dto.TableTypeRelationDto;
import com.wayz.dataTools.postgreHandle.repository.TableTypeRelationMapper;
import com.wayz.dataTools.postgreHandle.service.TableTypeRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableTypeRelationServiceImpl implements TableTypeRelationService {

    @Autowired
    private TableTypeRelationMapper tableTypeRelationMapper;

    @Override
    public List<TableTypeRelationDto> getActiveRelation() {
        return tableTypeRelationMapper.getActiveRelation();
    }
}
