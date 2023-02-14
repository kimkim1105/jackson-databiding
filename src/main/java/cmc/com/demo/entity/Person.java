//package cmc.com.demo.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.data.annotation.Id;
//
//import javax.persistence.*;
//
//@Entity
//@AllArgsConstructor
//@Builder
//@Getter
//@Setter
//@Table(name="PERSONS")
//public class Person {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(nullable = false, updatable = false)
//    private Long id;
//
//    @Column(name="first_name",length = 50)
//    private String firstName;
//
//    @Column(name="last_name",length = 50)
//    private String lastName;
//
//    @Column(length = 50)
//    private String email;
//
//    @Column(name="gender",length = 50)
//    private String gender;
//
//}
