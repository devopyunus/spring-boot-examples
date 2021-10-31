package com.yunus.spring.swagger.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "UserDto",description = "User Model Info")
public class UserDto {

    @ApiModelProperty(value = "User id")
    private Long id;
    @ApiModelProperty(value = "User name")
    private String name;
    @ApiModelProperty(value = "User surname")
    private String surname;
    @ApiModelProperty(value = "User date")
    private Date date;
    @ApiModelProperty(value = "User addressList")
    private List<String> addressList;
}
