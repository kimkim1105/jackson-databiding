package cmc.com.demo.entity.foo;

import cmc.com.demo.entity.bar.Bar;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@Table(name = "FOO")
@AllArgsConstructor
public class Foo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FOO")
    private String foo;

    @OneToMany
    private List<Bar> bar;

    public Foo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public List<Bar> getBar() {
        return bar;
    }

    public void setBar(List<Bar> bar) {
        this.bar = bar;
    }
}
