package com.example.app0803.pojo;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "PlayGround")
public class PlayGround {
    @Id
    @GeneratedValue
    @Column(name = "PLAYGROUND_ID")
    private Long Id;
    @NotNull
    @Column(name = "PLAYGROUND_NAME", unique = true)
    private String name;
    @OneToOne
    @JoinColumn(name = "PLAYGROUND_TYPENAME")
    private PlayGroundType playGroundTypeName;

    @Builder
    public PlayGround(Long id, String name) {
        Id = id;
        this.name = name;
    }
}
