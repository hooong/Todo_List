package com.hong.TodoList.service;

import com.hong.TodoList.domain.Member;
import com.hong.TodoList.dto.MemberDto;
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
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class MemberService {

    private MemberRepository memberRepository;

    // 회원가입
    @Transactional
    public Long signUp(MemberDto memberDto) {
        validateDuplicateMember(memberDto);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));

        return memberRepository.save(memberDto.toEntity()).getId();
    }

    // 회원 중복 검사
    private void validateDuplicateMember(MemberDto memberDto) {
        Optional<Member> findMembers = memberRepository.findByuserName(memberDto.getUserName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 로그인
//    public Long login(Member member) {
//
//    }

    // 회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 하나의 회원 검색 (id)
    public Member findOne(Long memberId) {
        return memberRepository.getOne(memberId);
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
