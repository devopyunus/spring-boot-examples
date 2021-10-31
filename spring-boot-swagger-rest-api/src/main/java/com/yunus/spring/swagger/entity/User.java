package com.yunus.spring.swagger.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class User implements Serializable {

    @Id
    @SequenceGenerator(name = "S_USER",allocationSize = 10)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "S_USER"
    )
    private Long id;
    private String name;
    private String surname;

    @OneToMany
    @JoinColumn(name = "user_address_id")
    private List<Address> addressList;
}
