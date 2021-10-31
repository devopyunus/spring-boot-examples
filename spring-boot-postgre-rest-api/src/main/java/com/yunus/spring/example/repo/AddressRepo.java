package com.yunus.spring.example.repo;

import com.yunus.spring.example.entity.Address;
import com.yunus.spring.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address,Long> {


}
