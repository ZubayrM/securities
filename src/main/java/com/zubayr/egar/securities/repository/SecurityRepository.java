package com.zubayr.egar.securities.repository;

import com.zubayr.egar.securities.model.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityRepository extends JpaRepository <Security, Long> {

    @Query(value = "select distinct year(date), price from Security where name = :name order by year(date)")
    Object[] getDateAndPriceByName(@Param("name") String name);

    @Query(value = "select s.name  from Security s group by s.name")
    String[] getAllNameToDiagram();

}
