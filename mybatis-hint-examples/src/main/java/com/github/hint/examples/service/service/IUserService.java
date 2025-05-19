package com.github.hint.examples.service.service;

import com.github.hint.examples.service.dao.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.hint.examples.service.dto.UserInfoVO;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author wzq
 * @since 2025-05-19
 */
public interface IUserService extends IService<User> {

    UserInfoVO getInfoById(Long id);
}
