package com.cm.mm.dao;

import com.cm.mm.dao.mapper.SmallProgramMaLongMapper;
import com.cm.mm.dao.mapper.SmallProgramUserMapper;
import com.cm.mm.model.SmallProgramMaLong;
import com.cm.mm.model.SmallProgramUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by qingao on 2018/1/9.
 */
@Component
public class SmallProgramMaLongDao extends BaseDao{
    @Autowired
    private SmallProgramMaLongMapper mapper;

    public SmallProgramMaLong getSpMaLong(String md5) {
        return mapper.getSpMaLong(md5);
    }

    public int insertSmallProgramMaLong(SmallProgramMaLong maLong) {
        return mapper.insertSpMaLong(maLong);
    }
    public int updateSmallProgramMaLong(SmallProgramMaLong maLong) {
        return mapper.updateSpMaLong(maLong);
    }
}
