package com.yunus.spring.swagger.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_address")
public class Address implements Serializable {

    @javax.persistence.Id
    @Id
    @SequenceGenerator(name = "S_USER_ADDRESS",allocationSize = 10)
    @GeneratedValue(generator = "S_USER_ADDRESS" , strategy = GenerationType.SEQUENCE)
    private Long id;

    private String text;
    @Enumerated
    private AddressType addressType;
    private Boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_address_id")
    @ToString.Exclude
    private User user;

    public enum AddressType {
        HOME,WORK,OTHER
    }

}
