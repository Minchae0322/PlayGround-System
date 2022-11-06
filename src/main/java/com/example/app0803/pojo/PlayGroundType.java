package com.example.app0803.pojo;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "PlayGround_type")
public class PlayGroundType {
    @Id
    @NotNull
    @Column(name = "PLAYGROUND_TYPENAME", unique = true)
    private String name;
    private String type;

    @Builder
    public PlayGroundType(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
