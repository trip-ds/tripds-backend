package com.ssafy.tripds.cctv.model.service;

import com.ssafy.tripds.cctv.model.dto.CctvDto;
import com.ssafy.tripds.cctv.model.dto.CoordinateDto;
import java.util.List;

public interface CctvService {
    List<CctvDto> getNearbyCctv(CoordinateDto coordinateDto);
}
