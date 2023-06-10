package io.renren.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.form.LoginForm;

import java.util.Map;

/**
 * 用户表
 *
 * @author admin
 * @email 995760188@qq.com
 * @date 2023-06-02 13:33:38
 */
public interface UserService extends IService<UserEntity> {

    UserEntity queryByMobile(String mobile);

    /**
     * 用户登录
     * @param form    登录表单
     * @return        返回用户ID
     */
    long login(LoginForm form);

    PageUtils queryPage(Map<String, Object> params);
}

