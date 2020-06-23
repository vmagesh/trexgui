package com.trexgui.spring.web.dto;

import com.trexgui.spring.customAnnotations.ValidRoleName;

import lombok.Data;

@Data
public class RoleDto {
    Long id;
    @ValidRoleName
    String name;
}
