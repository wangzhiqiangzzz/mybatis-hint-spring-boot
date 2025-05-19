package com.github.hint.examples.service.controller;

import com.github.hint.examples.service.dto.Result;
import com.github.hint.examples.service.dto.UserInfoVO;
import com.github.hint.examples.service.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author wzq
 * @since 2025-05-19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/info/{id}")
    public Result<UserInfoVO> getInfo(@PathVariable Long id) {
        UserInfoVO vo = userService.getInfoById(id);
        return Result.success(vo);
    }
}
