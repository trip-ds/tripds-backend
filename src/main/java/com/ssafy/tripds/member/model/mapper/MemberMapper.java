package com.ssafy.tripds.member.model.mapper;

import com.ssafy.tripds.member.model.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface MemberMapper {
    MemberDto login(MemberDto memberDto) throws SQLException;
}
