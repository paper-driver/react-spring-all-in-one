package com.allinone.reactspring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String email;

    @Column
    private Long income = 0L;

    @Column
    private Long saving = 0L;

    @Column
    private Long debt = 0L;

    @Column
    private Long net_saving = 0L;
}
