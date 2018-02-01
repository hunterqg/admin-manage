package com.cm.mm.dao.mapper;

import com.cm.mm.model.SmallProgramUser;
import org.apache.ibatis.annotations.*;

/**
 * Created by qingao on 2018/1/9.
 */
@Mapper
public interface SmallProgramUserMapper {
    @Select("select id,wechat_id,u_id,age,gender,height,weight,skin_color,preferred,style, createAt,updateAt from mm_small_program_user where wechat_id=#{wechatId}")
    @Results(
            id="Small_Program_User",value =
            {
                    @Result(column = "wechat_id",property = "wechatId"),
                    @Result(column = "u_id",property = "uid"),
                    @Result(column = "skin_color",property = "skinColor")
            }
    )
    SmallProgramUser getSpUser(@Param("wechatId") String wechatId);

    @Select("select id,wechat_id,u_id,age,gender,height,weight,skin_color,preferred,style, createAt,updateAt from mm_small_program_user where u_id=#{uid}")
    @ResultMap("Small_Program_User")
    SmallProgramUser getSpUserByUid(@Param("uid") String uid);

    @Insert("insert into mm_small_program_user (wechat_id,u_id,age,gender,height,weight,skin_color,preferred,style)" +
            " values (#{wechatId},#{uid},#{age},#{gender},#{height},#{weight},#{skinColor},#{preferred},#{style})")
    int insertSpUser(SmallProgramUser user);

    @Update("update mm_small_program_user set " +
            "age=#{age}," +
            "gender=#{gender},"+
            "height=#{height}," +
            "weight=#{weight}," +
            "skin_color=#{skinColor}, " +
            "preferred=#{preferred}, " +
            "style=#{style} " +
            "where wechat_id=#{wechatId}")
    int updateSpUser(SmallProgramUser user);

    @Update("update mm_small_program_user set wechat_id= #{wechatId} where u_id=#{uid}")
    int updateSpUserWechatIdByUid(@Param("wechatId") String wechatId,@Param("uid") String uid);

}
