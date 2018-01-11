package com.cm.mm.dao.mapper;

import com.cm.mm.model.SmallProgramBanner;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by qingao on 2018/1/9.
 */
@Mapper
public interface SmallProgramBannerMapper {
    @Select("select id,title,url,bg_color,bg_image,`order`,createAt,updateAt from mm_small_program_banner where id=#{id}")
    @Results(
            id="Small_Program_Banner",value =
            {
                    @Result(column = "bg_color",property = "bgColor"),
                    @Result(column = "bg_image",property = "bgImage")
            }
    )
    SmallProgramBanner getSpBanner(@Param("id") Integer id);

    @Select("select id,title,url,bg_color,bg_image,`order`,createAt,updateAt from mm_small_program_banner order by `order` asc")
    @ResultMap("Small_Program_Banner")
    List<SmallProgramBanner> listAllBanners();

    @Insert("insert into mm_small_program_banner (title,url,bg_color,bg_image,`order`)" +
            " values (#{title},#{url},#{bgColor},#{bgImage},#{order})")
    int insertSpBanner(SmallProgramBanner banner);

    @Update("update mm_small_program_banner set " +
            "title=#{title}," +
            "url=#{url},"+
            "bg_color=#{bgColor}," +
            "bg_image=#{bgImage}," +
            "`order`=#{order} " +
            "where id=#{id}")
    int updateSpBanner(SmallProgramBanner banner);

    @Delete("delete from mm_small_program_banner where id=#{id}")
    int deleteSpBanner(@Param("id") Integer id);

}
