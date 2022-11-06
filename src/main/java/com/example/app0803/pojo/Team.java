package com.example.app0803.pojo;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Team")
public class Team {
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    @NotNull
    private String teamName;
    private String image;
    private Integer win;
    private Integer lose;

    @Builder
    public Team(Long id, String teamName, String image, Integer win, Integer lose) {
        this.id = id;
        this.teamName = teamName;
        this.image = image;
        this.win = win;
        this.lose = lose;
    }
}
