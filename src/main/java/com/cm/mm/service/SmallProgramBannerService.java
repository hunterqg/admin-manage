package com.cm.mm.service;

import com.cm.mm.dao.SmallProgramBannerDao;
import com.cm.mm.model.SmallProgramBanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qingao on 18-1-11.
 */
@Service
public class SmallProgramBannerService {
    @Autowired
    private SmallProgramBannerDao dao;

    public SmallProgramBanner getSpBanner(Integer id) {
        return dao.getSpUser(id);
    }

    public int addSpBanner(SmallProgramBanner banner) {
        return dao.insertSmallProgramBanner(banner);
    }

    public List<SmallProgramBanner> listAllSpBanners() {
        return dao.listAllSpBanners();
    }

    public int modifySpBanner(SmallProgramBanner banner) {
        return dao.updateSmallProgramBanner(banner);
    }

    public int removeSpBanner(Integer id) {
        return dao.deleteSmallProgramBanner(id);
    }
}
