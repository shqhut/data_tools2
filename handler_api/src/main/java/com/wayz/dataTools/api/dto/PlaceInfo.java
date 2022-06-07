package com.wayz.dataTools.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceInfo implements Serializable {
    private PointDto point;
    private Integer typeId;
    private String spatialReference;
}
