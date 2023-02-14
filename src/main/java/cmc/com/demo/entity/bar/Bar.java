package cmc.com.demo.entity.bar;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@Table(name = "BAR")
public class Bar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "BAR")
    private String bar;

    public Bar() {
    }

}
