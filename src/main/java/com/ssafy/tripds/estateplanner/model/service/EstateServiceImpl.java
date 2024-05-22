package com.ssafy.tripds.estateplanner.model.service;

import com.ssafy.tripds.estateplanner.model.dto.EstateInterestDto;
import com.ssafy.tripds.estateplanner.model.mapper.EstateMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EstateServiceImpl implements EstateService {

    private final EstateMapper estateMapper;

    @Transactional
    @Override
    public int insertEstateInterest(EstateInterestDto estateInterestDto) {
        try{
            return estateMapper.insertEstateInterest(estateInterestDto);
        }
        catch (Exception e){
            log.error("exception = {}" ,e);
            throw new RuntimeException(e);
        }
    }
}
