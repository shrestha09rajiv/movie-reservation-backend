package com.cotiviti.moviereservation.user.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "url_permission")
@Data
public class UrlPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @Column(name = "title")
    private String title;
    @Column(name = "icon")
    private String icon;
    @Column(name = "link")
    private String link;

}
