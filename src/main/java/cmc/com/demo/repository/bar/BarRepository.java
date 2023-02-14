package cmc.com.demo.repository.bar;

import cmc.com.demo.entity.bar.Bar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BarRepository  extends JpaRepository<Bar, Long>{
    Optional<Bar> findById(Long id);
//    @Query(value = "select new cmc.com.demo.entity.Total(bar.id as id,bar.bar as bar, foo.foo as foo) from Bar bar join Foo foo on bar.id = foo.id ")
//    Iterable<Object> findOther();
}
