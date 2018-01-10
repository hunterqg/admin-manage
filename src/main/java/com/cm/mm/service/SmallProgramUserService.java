package com.cm.mm.service;

import com.cm.mm.dao.SmallProgramUserDao;
import com.cm.mm.model.SmallProgramUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by qingao on 2018/1/9.
 */
@Service
public class SmallProgramUserService {
    @Autowired
    private SmallProgramUserDao dao;

    public SmallProgramUser getSpUser(String wechatId) {
        return dao.getSpUser(wechatId);
    }

    public int saveSpUser(SmallProgramUser user) {
        SmallProgramUser u = dao.getSpUser(user.getWechatId());
        if(u != null) {
            return dao.updateSmallProgramUser(user);
        }else {
            return dao.insertSmallProgramUser(user);
        }
    }
}
