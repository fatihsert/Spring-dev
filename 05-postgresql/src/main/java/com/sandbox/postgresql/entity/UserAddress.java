package com.sandbox.postgresql.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

import com.sandbox.postgresql.entity.User;

@Entity
@Table(name = "user_address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class UserAddress implements Serializable {

    @SequenceGenerator(name = "seq_user_address", allocationSize = 1)
    @GeneratedValue(generator = "seq_user_address", strategy = GenerationType.SEQUENCE)
    @Id
//id ürenten sequence ler var fonksiyon gibi bunun sonucunuda değere atayan generaterlar var . burada git değeri bu sequence al demiş olduk.
    private long id;

    @Column(name = "Address", length = 1000)
    private String address;

    @Column(name = "AddressName", length = 100)
    private String addressName;

    @Column(name = "IsActive")
    private Boolean isActive;

    @Enumerated
    private AddressType addressType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_address_id")
    private User user;

    public enum AddressType {
        Home,
        Work,
        Other
    }
}

