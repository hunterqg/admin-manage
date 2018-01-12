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
                .SELECT("id,name,model,brand_id,price,type,user_id,url_type,pic_url,description, createAt,updateAt")
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
        if (cloth.getUrlType() != null) {
            sql.WHERE("url_type=#{urlType}");
        }
        if(cloth.getBrand()!=null && cloth.getBrand().getId()!= null) {
            sql.WHERE("brand_id=#{brand.id}");
        }
        if(cloth.getPrice()!= null) {
            sql.WHERE("price=#{price}");
        }
        return sql.toString();
    }
    public String getClothesByIds(Integer[] ids) {
        SQL sql = new SQL()
                .SELECT("id,name,model,brand_id,price,type,user_id,url_type,pic_url,video_url,description,createAt,updateAt")
                .FROM("mm_cloth");

        sql.WHERE("id in ("+ StringUtils.join(ids,',')+")");

        return sql.toString();
    }
}
