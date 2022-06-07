package com.wayz.dataTools.postgreHandle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceIdGenerateDto {
    private Long id;
    private Double center_log;
    private Double center_lat;
}
