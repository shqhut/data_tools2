package com.wayz.dataTools.postgreHandle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableTypeRelationDto {
    private String parent_type;
    private String table_type;
    private Integer type_id;
    private Integer relation_status;
}
