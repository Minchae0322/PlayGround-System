package com.example.app0803.repository;

import com.example.app0803.pojo.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {
   Optional<Member> findMemberByUsername(String userName);
}
