package com.page.contact.emailcontact.user;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class EndUser {
    @Id
    @SequenceGenerator(
            name = "enduser_sequence",
            sequenceName = "enduser_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "enduser_sequence"
    )
    private Long id;
    private String name;
    private String email;

    @Transient
    private Integer age;
}
