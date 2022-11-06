package com.example.app0803.serviceimpl;

import com.example.app0803.Role;
import com.example.app0803.pojo.Member;
import com.example.app0803.pojo.MemberDto;
import com.example.app0803.repository.MemberRepository;
import com.example.app0803.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService, UserDetailsService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository userRepository) {
        this.memberRepository = userRepository;
    }

    @Override
    @Transactional
    public Long signUp(MemberDto memberDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        return memberRepository.save(memberDto.toEntity()).getId();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> memberWrapper = memberRepository.findMemberByUsername(username);
        Member user = memberWrapper.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        System.out.println(user.getUsername() + " " + user.getPassword());

        if (username.equals("ROLE_ADMIN")) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }
        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
