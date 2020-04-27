package com.hong.TodoList.repository;

import com.hong.TodoList.domain.MemberEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {
    @PersistenceContext
    private EntityManager em;

    // userName을 통한 검색
    public MemberEntity findByuserName(String userName) {
        return em.find(MemberEntity.class, userName);
    }

    // save
    public Long save(MemberEntity member) {
        em.persist(member);
        return member.getId();
    }
}
