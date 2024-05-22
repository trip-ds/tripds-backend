package com.ssafy.tripds.estateplanner.model.service;

import com.ssafy.tripds.estateplanner.model.dto.EstateDto;
import com.ssafy.tripds.estateplanner.model.dto.EstateInterestDto;
import com.ssafy.tripds.estateplanner.model.mapper.EstateMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional
    @Override
    public List<String> selectEstateInterestByMemberId(Long memberId) {
        try{
            return estateMapper.selectEstateInterestByMemberId(memberId);
        }
        catch (Exception e){
            log.error("exception = {}" ,e);
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public List<EstateDto> getEstateInfoByRegisterNumbers(List<String> registerNumberList) {
        try{
            return estateMapper.getEstateInfoByRegisterNumbers(registerNumberList);
        }
        catch (Exception e){
            log.error("exception = {}" ,e);
            throw new RuntimeException(e);
        }
    }
}
