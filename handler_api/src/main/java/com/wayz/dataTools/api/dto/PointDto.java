package com.wayz.dataTools.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PointDto implements Serializable {
    private Double longitude;
    private Double latitude;
}
