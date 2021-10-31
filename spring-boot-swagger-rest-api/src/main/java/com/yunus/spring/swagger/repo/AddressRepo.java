package com.yunus.spring.swagger.repo;

import com.yunus.spring.swagger.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address,Long> {


}
