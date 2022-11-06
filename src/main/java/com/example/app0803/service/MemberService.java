package com.example.app0803.service;

import com.example.app0803.pojo.MemberDto;
import org.springframework.transaction.annotation.Transactional;


public interface MemberService {
    @Transactional
    Long signUp(MemberDto memberDto);
}
