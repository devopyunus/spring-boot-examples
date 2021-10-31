package com.yunus.spring.swagger.service;

import com.yunus.spring.swagger.dto.UserDto;
import com.yunus.spring.swagger.entity.Address;
import com.yunus.spring.swagger.entity.User;
import com.yunus.spring.swagger.repo.AddressRepo;
import com.yunus.spring.swagger.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final AddressRepo addressRepo;

    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        Assert.notNull(userDto.getName(),"Kullanıcı Adı Boş Olamaz!");

        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        final User dbUser = userRepo.save(user);

        List<Address> addressList = new ArrayList<>();
        userDto.getAddressList().forEach(item -> {
            Address address = new Address();
            address.setText(item);
            address.setAddressType(Address.AddressType.HOME);
            address.setActive(true);
            address.setUser(dbUser);
            addressList.add(address);
        });

        addressRepo.saveAll(addressList);
        userDto.setId(dbUser.getId());
        return userDto;
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepo.findAll();
        List<UserDto> collect = users.stream().map(user -> {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setName(user.getName());
            userDto.setSurname(user.getSurname());
            userDto.setAddressList(user.getAddressList().stream().map(Address::getText).collect(Collectors.toList()));
            return userDto;
        }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return null;
    }
}
