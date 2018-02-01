package com.cm.mm.dao;

import com.cm.mm.dao.mapper.SmallProgramUserMapper;
import com.cm.mm.model.Base;
import com.cm.mm.model.SmallProgramUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by qingao on 2018/1/9.
 */
@Component
public class SmallProgramUserDao extends BaseDao{
    @Autowired
    private SmallProgramUserMapper mapper;

    public SmallProgramUser getSpUser(String wechatId) {
        return mapper.getSpUser(wechatId);
    }
    public SmallProgramUser getSpUserByUid(String uid) {
        return mapper.getSpUserByUid(uid);
    }

    public int insertSmallProgramUser(SmallProgramUser user) {
        return mapper.insertSpUser(user);
    }
    public int updateSmallProgramUser(SmallProgramUser user) {
        return mapper.updateSpUser(user);
    }

    public int updateSpUserWechatIdByUid(String wechatId,String uid) {
        return mapper.updateSpUserWechatIdByUid(wechatId,uid);
    }
}
