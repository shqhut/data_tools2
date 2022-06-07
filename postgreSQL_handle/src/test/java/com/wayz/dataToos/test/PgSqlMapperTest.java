package com.wayz.dataToos.test;

import com.wayz.dataTools.PgSqlHandlerApplication;
import com.wayz.dataTools.postgreHandle.dto.PlaceIdGenerateDto;
import com.wayz.dataTools.postgreHandle.dto.TableTypeRelationDto;
import com.wayz.dataTools.postgreHandle.repository.TestMapper;
import com.wayz.dataTools.postgreHandle.service.TableTypeRelationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PgSqlHandlerApplication.class)
public class PgSqlMapperTest {

    @Autowired
    private TestMapper testMapper;

    @Autowired
    private TableTypeRelationService tableTypeRelationService;

    @Test
    public void test(){
        List<PlaceIdGenerateDto> pgSqlResult = testMapper.getPgSqlResult();
        List<Double> collect = pgSqlResult.stream().map(PlaceIdGenerateDto::getCenter_lat).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void getActiveRelationTest(){
        List<TableTypeRelationDto> activeRelation = tableTypeRelationService.getActiveRelation();
        System.out.println(activeRelation);
    }

}
