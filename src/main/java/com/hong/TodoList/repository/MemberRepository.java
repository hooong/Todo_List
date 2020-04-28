package com.hong.TodoList.repository;

import com.hong.TodoList.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    // save
    public void save(Member member) {
        em.persist(member);
    }

    // id을 통한 검색
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    // 회원 모두 검색
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    // userName을 사용해 검색
    public List<Member> findByuserName(String userName) {
        return em.createQuery("select m from Member m where m.userName = :userName", Member.class)
                .setParameter("userName", userName)
                .getResultList();
    }
}
