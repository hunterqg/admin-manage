package com.cm.mm.dao.sqlprovider;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * Created by qingao on 2017/11/23.
 */
public class ClothTagSqlProvider {

    public String getClothTagSql(Integer[] tags) {
        String condStr = StringUtils.join(tags,',');
        SQL sql = new SQL().SELECT("id,cloth_id,tag_id,createAt")
                .FROM("mm_cloth_tag")
                .WHERE("tag_id in( " +condStr+" )");
        return sql.toString();
    }
}
