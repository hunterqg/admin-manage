package com.cm.mm.dao.sqlprovider;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by qingao on 18-1-23.
 */
public class SmallProgramFavoriteSqlProvider {
    public String getInsertFavoritesSql(String wecahtId,List<Integer> ids) {
        if (ids == null || ids.size() == 0) {
            throw new IllegalArgumentException("ids can't be empty!!");
        }
        StringBuffer sql =new StringBuffer( "insert into mm_small_program_favorite (wechat_id,cloth_id) values ");
        for(Integer id : ids) {
            sql.append(String.format("('%s',%d),",wecahtId,id));
        }
        String sqlStr = sql.toString();
        sqlStr = sqlStr.substring(0,sqlStr.length()-1);

        return sqlStr;
    }

    public String getDeleteFavoritesSql(String wechatId,List<Integer> ids) {
        if (ids == null || ids.size() == 0) {
            throw new IllegalArgumentException("ids can't be empty!!");
        }
        SQL sql = new SQL().DELETE_FROM("mm_small_program_favorite");
        sql.WHERE("wechat_id =  #{wechatId}");
        sql.WHERE("cloth_id in("+ StringUtils.join(ids,",")+")");
        return sql.toString();

    }
}
