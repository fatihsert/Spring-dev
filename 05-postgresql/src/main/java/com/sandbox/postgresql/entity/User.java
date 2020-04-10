package com.sandbox.postgresql.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "appUser")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class User {
    @Id
    @SequenceGenerator(name = "seq_user", allocationSize = 1)
    @GeneratedValue(generator = "seq_user", strategy = GenerationType.SEQUENCE)
//id ürenten sequence ler var fonksiyon gibi bunun sonucunuda değere atayan generaterlar var . burada git değeri bu sequence al demiş olduk.
    private long id;

    @Column(name = "name", length = 1000)
    private String name;

    @Column(name = "lastName", length = 100)
    private String lastName;

    @OneToMany
    @JoinColumn(name = "user_address_id")
    private List<UserAddress> addressList;
}
