package com.cm.mm.dao.mapper;

import com.cm.mm.dao.sqlprovider.ClothSqlProvider;
import com.cm.mm.model.Cloth;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by qingao on 2017/11/16.
 */
@Mapper
public interface ClothMapper {
    String SQL_GET_CLOTH_BY_ID = "select id,name,model,brand_id,price,type,user_id,pic_url,url_type,description,createAt,updateAt from mm_cloth where id=#{id}";

    @Select(SQL_GET_CLOTH_BY_ID)
    @Results(
            id="Cloth",value =
            {
                    @Result(column = "pic_url",property = "picUrl"),
                    @Result(column = "user_id",property = "userId"),
                    @Result(column = "url_type",property = "urlType"),
                    @Result(column = "brand_id",property = "brand",one=@One(select = "com.cm.mm.dao.mapper.ClothBrandMapper.getClothBrandById"))
            }
    )
    Cloth getClothById(@Param("id") Integer id);

    @SelectProvider(type=ClothSqlProvider.class , method = "getClothesByIds")
    @ResultMap("Cloth")
    List<Cloth> getClothByIds(@Param("ids") Integer[] ids);

    @SelectProvider(type= ClothSqlProvider.class,method = "getClothesSql")
    @ResultMap("Cloth")
    List<Cloth> listClothes(Cloth cloth);

    @Insert("insert into mm_cloth (name,model,brand_id,price,type,user_id,pic_url,description) " +
            "values (#{name},#{model},#{brand.id},#{price},#{type},#{userId},#{picUrl},#{description})")
    int insertCloth(Cloth cloth);

    @Delete("delete from mm_cloth where id=#{id}")
    int deleteClothById(@Param("id") Integer id);

    @Update("update mm_cloth " +
            "set name=#{name}," +
            "model=#{model}," +
            "brand_id=#{brand.id}," +
            "price=#{price}," +
            "type=#{type}," +
            "user_id=#{userId}," +
            "pic_url=#{picUrl}, " +
            "description=#{description} " +
            "where id=#{id}")
    int updateCloth(Cloth cloth);

}
