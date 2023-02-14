//package cmc.com.demo.repository.foo;
//
//import cmc.com.demo.entity.Response;
//import cmc.com.demo.entity.Total;
//import cmc.com.demo.entity.bar.Bar;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.transform.ResultTransformer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//
//@Repository
//public interface TotalRepository extends JpaRepository<Total, Long> {
//
//    @Query(name = "mappingtotaltest", nativeQuery = true)
//    List<Response> findOther();
//}
