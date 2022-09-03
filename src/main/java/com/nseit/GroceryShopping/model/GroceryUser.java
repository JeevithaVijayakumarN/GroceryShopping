package com.nseit.GroceryShopping.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class GroceryUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String userName;
    private String email;
    private Long phone;
    private String password;
    @JsonIgnore
    @OneToOne(mappedBy = "groceryUser", cascade = CascadeType.ALL)
    private Cart cart;
    @OneToMany(mappedBy = "groceryUser", cascade = CascadeType.ALL)
    private Set<Order> orders;
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
    private Set<Role> roles;

    public GroceryUser(String userName, String password) {
        this.userName = userName;
        this.password = password;

    }
}
