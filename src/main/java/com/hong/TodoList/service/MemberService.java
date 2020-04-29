package com.hong.TodoList.service;

import com.hong.TodoList.domain.Member;
import com.hong.TodoList.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
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

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원가입
    @Transactional
    public Long signUp(Member member) {
        validateDuplicateMember(member);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        memberRepository.save(member);

        return member.getId();
    }

    // 회원 중복 검사
    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByuserName(member.getUserName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 로그인
    public Long login(Member member) {

    }

    // 회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 하나의 회원 검색 (id)
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Member userEntity = memberRepository.findByuserName(username);
//
//        List<GrantedAuthority> authorities = new ArrayList<>();
//
//        if (("admin").equals(username)) {
//            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
//        } else {
//            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
//        }
//
//        return new User(userEntity.getUserName(),userEntity.getPassword(),authorities);
//    }
}
