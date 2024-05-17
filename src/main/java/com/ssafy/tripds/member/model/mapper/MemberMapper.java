package com.ssafy.tripds.member.model.mapper;

import com.ssafy.tripds.member.model.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.Map;

@Mapper
public interface MemberMapper {
    int signup(MemberDto memberDto) throws SQLException;
    MemberDto login(MemberDto memberDto) throws SQLException;
    MemberDto userInfo(String email) throws SQLException;
    int updateMember(MemberDto memberDto) throws SQLException;
    void saveRefreshToken(Map<String, String> map) throws SQLException;
    Object getRefreshToken(String email) throws SQLException;
    void deleteRefreshToken(Map<String, String> map) throws SQLException;
}
