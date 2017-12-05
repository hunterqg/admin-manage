package com.cm.mm.dao.mapper;

import com.cm.mm.dao.sqlprovider.ClothTagSqlProvider;
import com.cm.mm.model.ClothTag;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by qingao on 2017/11/23.
 */
@Mapper
public interface ClothTagMapper {

    @SelectProvider(type= ClothTagSqlProvider.class,method = "getClothTagSql")
    @Results (
            id="ClothTag",value =
            {
                    @Result(column = "cloth_id",property = "clothId"),
                    @Result(column = "tag_id",property = "tagId")
            }
    )
    List<ClothTag> getClothTags(@Param("tags") Integer [] tags);

    @Select("select id,cloth_id,tag_id,createAt from mm_cloth_tag where cloth_id=#{clothId}")
    @ResultMap("ClothTag")
    List<ClothTag> getClothTagsByClothId(@Param("clothId") Integer clothId);
}
