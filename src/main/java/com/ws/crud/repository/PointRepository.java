package com.ws.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ws.crud.model.Point;

public interface PointRepository extends JpaRepository<Point, Long>{

}
