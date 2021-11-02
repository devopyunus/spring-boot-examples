package com.yunus.spring.event.service;

import com.yunus.spring.event.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface UserService {

    UserDto save(UserDto userDto);

    void delete(Long id);

    List<UserDto> getAll();

    Page<UserDto> getAll(Pageable pageable);

    Slice<UserDto> getSliceAll(Pageable pageable);

}
