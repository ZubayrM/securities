package com.zubayr.egar.securities;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityRepository extends PagingAndSortingRepository<Security, Long> {

}
