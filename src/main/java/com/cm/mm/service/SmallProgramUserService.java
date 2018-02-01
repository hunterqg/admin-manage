package com.cm.mm.service;

import com.cm.mm.dao.SmallProgramFavoriteDao;
import com.cm.mm.dao.SmallProgramUserDao;
import com.cm.mm.model.SmallProgramUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by qingao on 2018/1/9.
 */
@Service
public class SmallProgramUserService {
    private static Logger logger = LoggerFactory.getLogger(SmallProgramUserService.class);
    @Autowired
    private SmallProgramUserDao dao;

    @Autowired
    SmallProgramFavoriteDao favoriteDao;

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

    @Transactional
    public void saveSpUserForLogin(SmallProgramUser user)  throws Exception{
        SmallProgramUser u = dao.getSpUserByUid(user.getUid());
        if(u != null) {
            dao.updateSpUserWechatIdByUid(user.getWechatId(),user.getUid());
            logger.info(String.format("For Login UPDATE user wechatId=%s,uid=%s",user.getWechatId(),user.getUid()));

            //update all wechat id in favorite table
            int retVal = favoriteDao.updateFavoirtesForNewLogin(user.getWechatId(),u.getWechatId());
            logger.info(String.format("Updated %d favorites ",retVal));
        }else {
            dao.insertSmallProgramUser(user);
            logger.info(String.format("For Login INSERT user wechatId=%s,uid=%s",user.getWechatId(),user.getUid()));
        }


    }
}
