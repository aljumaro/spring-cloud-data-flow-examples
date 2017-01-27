package com.aljumaro.techtest.stream.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeInfoRepository extends JpaRepository<TimeInfo, String> {

}
