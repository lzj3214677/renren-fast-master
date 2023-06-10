package io.renren.modules.app.service.impl;

import io.renren.common.exception.RRException;
import io.renren.common.validator.Assert;
import io.renren.modules.app.form.LoginForm;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.UserDao;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.UserService;
import org.springframework.util.StringUtils;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public UserEntity queryByMobile(String mobile) {
        return baseMapper.selectOne(new QueryWrapper<UserEntity>().eq("mobile", mobile));
    }

    @Override
    public long login(LoginForm form) {
        UserEntity user = queryByMobile(form.getMobile());
        Assert.isNull(user, "手机号或密码错误");

        //密码错误
        if (!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))) {
            throw new RRException("手机号或密码错误");
        }

        return user.getUid();
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<UserEntity>();

        if (null != params.get("realname")) {
            queryWrapper.like("realname", params.get("realname"));
        }

        IPage<UserEntity> page = this.page(
            new Query<UserEntity>().getPage(params),
            queryWrapper
        );

        return new PageUtils(page);
    }

}