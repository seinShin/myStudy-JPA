package hello.jpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        //트랜잭션 시작
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //코드 작성
        try {
           //영속
            Member member = em.find(Member.class, 1L);
            member.setName("aaaa");

//            em.detach(member);                영속상태에서 제외 -> 준영속 상태
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)           jpql
//                            .getResultList();

            //커밋시점에 쿼리를 날림
            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
