package com.cm.mm.dao.sqlprovider;

import com.cm.mm.model.Cloth;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.util.TextUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by qingao on 2017/11/17.
 */
public class ClothSqlProvider {
    public String getClothesSql(Cloth cloth) {
        SQL sql = new SQL()
                .SELECT("id,name,model,type,user_id,pic_url,createAt,updateAt")
                .FROM("mm_cloth");
        if (!TextUtils.isEmpty(cloth.getName())) {
            sql.WHERE("name=#{name}");
        }
        if (!TextUtils.isEmpty(cloth.getModel())) {
            sql.WHERE("model=#{model}");
        }
        if (!TextUtils.isEmpty(cloth.getUserId())) {
            sql.WHERE("user_id=#{userId}");
        }
        if (cloth.getType() != null) {
            sql.WHERE("type=#{type}");
        }

        return sql.toString();
    }
    public String getClothesByIds(Integer[] ids) {
        SQL sql = new SQL()
                .SELECT("id,name,model,type,user_id,pic_url,createAt,updateAt")
                .FROM("mm_cloth");

        sql.WHERE("id in ("+ StringUtils.join(ids,',')+")");

        return sql.toString();
    }
}
