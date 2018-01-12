package com.cm.mm.dao.mapper;

import com.cm.mm.model.ClothBrand;
import org.apache.ibatis.annotations.*;

/**
 * Created by qingao on 18-1-12.
 */
@Mapper
public interface ClothBrandMapper {

    @Select("select id,name,code,logo_url,createAt,updateAt from mm_cloth_brand where id = #{id}")
    @Results(
            id = "Cloth_Brand", value =
            {
                    @Result(column = "logo_url", property = "logoUrl")
            }
    )
    ClothBrand getClothBrandById(@Param("id") Integer id);
}
