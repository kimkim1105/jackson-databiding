package cmc.com.demo.entity;

import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.Builder;

import javax.persistence.*;

@Immutable
@Entity
@Table
@Builder
@NamedNativeQueries({
        @NamedNativeQuery(
                name="mappingtotaltest",
                query="select b.ID as id,b.BAR as total, f.FOO as foo, f.FOO as bar from BAR as b join FOO as f on b.ID = f.ID",
                resultSetMapping = "totalMapping"),
        @NamedNativeQuery(
        name="mappingtotalfoo",
        query="select b.ID as id, f.FOO as bar,b.BAR as total from BAR as b join FOO as f on b.ID = f.ID",
//        query="select t.*, f.id as id, f.foo as foo from total t join foo f on f.id = t.id",
        resultSetMapping = "totalMapping")
})
@SqlResultSetMapping(
        name="totalMapping2",
        entities={
                @EntityResult(
                        entityClass = cmc.com.demo.entity.Total.class
//                        fields={
//                                @FieldResult(name="id",column="id"),
//                                @FieldResult(name="bar", column="bar"),
//                                @FieldResult(name="foo", column="foo"),
//                                @FieldResult(name="total", column="total")}
                )})
@SqlResultSetMapping(name = "totalMapping",
        classes = {
        @ConstructorResult(
                targetClass = cmc.com.demo.entity.Response.class
                ,
                columns = { @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "bar", type = String.class),
                        @ColumnResult(name = "total", type = String.class)  }
        ) })

public class Total {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "bar")
    private String bar;
//    @Transient
    @Column(name = "foo")
    private String foo;
    @Column(name = "total")
    private String total;

    public Total() {
    }

    public Total(Long id, String bar, String foo) {
        this.id = id;
        this.bar = bar;
        this.foo = foo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
