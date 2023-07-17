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
            Member findMember = em.find(Member.class, 1L);

//      delete 쿼리      em.remove(findMember);
            findMember.setName("HelloJPA");

//            em.persist(member);
// jpql           List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                            .getResultList();
            tx.commit();

        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
