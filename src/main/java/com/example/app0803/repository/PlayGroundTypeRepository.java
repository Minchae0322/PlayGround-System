package com.example.app0803.repository;


import com.example.app0803.pojo.PlayGroundType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayGroundTypeRepository extends JpaRepository<PlayGroundType, String> {
    Optional<PlayGroundType> findPlayGroundTypeByName(String name);
}
