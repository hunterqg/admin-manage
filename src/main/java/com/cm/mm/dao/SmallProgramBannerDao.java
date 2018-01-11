package com.cm.mm.dao;

import com.cm.mm.dao.mapper.SmallProgramBannerMapper;
import com.cm.mm.dao.mapper.SmallProgramUserMapper;
import com.cm.mm.model.SmallProgramBanner;
import com.cm.mm.model.SmallProgramUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by qingao on 2018/1/9.
 */
@Component
public class SmallProgramBannerDao extends BaseDao{
    @Autowired
    private SmallProgramBannerMapper mapper;

    public SmallProgramBanner getSpUser(Integer id) {
        return mapper.getSpBanner(id);
    }

    public int insertSmallProgramBanner(SmallProgramBanner banner) {
        return mapper.insertSpBanner(banner);
    }
    public int updateSmallProgramBanner(SmallProgramBanner banner) {
        return mapper.updateSpBanner(banner);
    }
    public int deleteSmallProgramBanner(Integer id) {
        return mapper.deleteSpBanner(id);
    }

    public List<SmallProgramBanner> listAllSpBanners() {
        return mapper.listAllBanners();
    }
}
