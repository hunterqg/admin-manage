package com.cm.mm.dao.mapper;

import com.cm.mm.model.SmallProgramMaLong;
import com.cm.mm.model.SmallProgramUser;
import org.apache.ibatis.annotations.*;

/**
 * Created by qingao on 2018/1/9.
 */
@Mapper
public interface SmallProgramMaLongMapper {
    @Select("select id,url,md5,prop1, createAt,updateAt from mm_small_program_malong where md5=#{md5}")
    SmallProgramMaLong getSpMaLong(@Param("md5") String md5);

    @Insert("insert into mm_small_program_malong (url,md5,prop1)" +
            " values (#{url},#{md5},#{prop1})")
    int insertSpMaLong(SmallProgramMaLong user);

    @Update("update mm_small_program_malong set " +
            "url=#{url}," +
            "md5=#{md5},"+
            "prop1=#{prop1}" +
            "where md5=#{md5}")
    int updateSpMaLong(SmallProgramMaLong spMaLong);

}
