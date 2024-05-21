package com.ssafy.tripds.cctv.model.service;

import com.ssafy.tripds.cctv.model.dto.CctvDto;
import com.ssafy.tripds.cctv.model.dto.CctvSearchDto;
import com.ssafy.tripds.cctv.model.dto.CoordinateDto;
import com.ssafy.tripds.cctv.model.mapper.CctvMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CctvServiceImpl implements CctvService {

    private final CctvMapper cctvMapper;

    @Override
    public List<CctvDto> getNearbyCctv(CoordinateDto coordinateDto) {
        try {
            return cctvMapper.getNearbyCctv(coordinateDto);
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CctvDto> getCctvFromMap(CctvSearchDto cctvSearchDto) {
        try{
            return cctvMapper.getCctvFromMap(cctvSearchDto);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
