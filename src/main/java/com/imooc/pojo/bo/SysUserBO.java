package com.imooc.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@ToString
public class SysUserBO {
    private String id;
    @NotBlank
    private String name;
    @NotNull
    private Integer sex;
}