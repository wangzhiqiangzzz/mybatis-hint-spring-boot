package com.github.hint.examples.service.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author wzq
 * @since 2025-05-19
 */
@Getter
@Setter
@TableName("test_user")

public class User implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String code;

    private String username;

    private String password;


}
