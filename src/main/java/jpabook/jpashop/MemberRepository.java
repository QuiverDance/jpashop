package jpabook.jpashop;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(MyMember myMember){
        em.persist(myMember);
        return myMember.getId();
    }

    public MyMember find(Long id){
        return em.find(MyMember.class, id);
    }
}
