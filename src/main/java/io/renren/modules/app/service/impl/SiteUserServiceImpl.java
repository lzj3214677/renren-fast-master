package io.renren.modules.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.dao.SiteUserDao;
import io.renren.modules.app.entity.SiteUserEntity;
import io.renren.modules.app.service.SiteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 */
@Service
public class SiteUserServiceImpl extends ServiceImpl<SiteUserDao, SiteUserEntity> implements SiteUserService {

    @Autowired
    private SiteUserDao siteUserDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String p = (String) params.get("page");
        String l = (String) params.get("limit");

        Object duringDate = params.get("duringDate");
        Integer pi = Integer.parseInt(p);
        Integer page = (pi - 1) * 10;
        Integer limit = Integer.parseInt(l);
        List<Map<String, Object>> list = siteUserDao.selectReport(page, limit, duringDate);
        Long totalCount = (Long) list.get(0).get("totalCount");
        return new PageUtils(list, totalCount.intValue(), pi, limit);
    }
}
