package com.ssafy.tripds.cctv.model.service;

import com.ssafy.tripds.cctv.model.dto.CctvDto;
import com.ssafy.tripds.cctv.model.dto.CctvSearchDto;
import com.ssafy.tripds.cctv.model.dto.CctvCoordinateDto;
import java.util.List;

public interface CctvService {
    List<CctvDto> getNearbyCctv(CctvCoordinateDto cctvCoordinateDto);
    List<CctvDto> getCctvFromMap(CctvSearchDto cctvSearchDto);
}
