package com.wayz.dataTools.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceIdGenParamDto implements Serializable {
    private List<PlaceInfo> placeIds;
}
