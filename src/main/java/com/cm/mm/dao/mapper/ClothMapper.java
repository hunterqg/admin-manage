package com.cm.mm.dao.mapper;

import com.cm.mm.model.Cloth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by qingao on 2017/11/16.
 */
@Mapper
public interface ClothMapper {
    String SQL_GET_CLOTH_BY_ID = "select id,name,model,type,pic_url,createAt,updateAt from mm_cloth where id=#{id}";

    String SQL_LIST_CLOTH_LIMITED = "select id,name,model,type,pic_url,createAt,updateAt from mm_cloth  ";

    @Select(SQL_GET_CLOTH_BY_ID)
    Cloth getClothById(@Param("id") Integer id);
}
