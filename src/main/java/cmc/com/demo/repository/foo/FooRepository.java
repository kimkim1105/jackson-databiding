package cmc.com.demo.repository.foo;

import cmc.com.demo.entity.bar.Bar;
import cmc.com.demo.entity.foo.Foo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FooRepository  extends JpaRepository<Foo, Long> {
    Optional<Foo> findById(Long id);
    @Query(value = "select * from Foo where foo in :name",nativeQuery = true)
    Iterable<Foo> findByName(List<String> name);
}
