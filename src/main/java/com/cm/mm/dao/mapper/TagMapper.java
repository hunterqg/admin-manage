package com.cm.mm.dao.mapper;

import com.cm.mm.model.Tag;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by qingao on 2017/11/16.
 */
@Mapper
public interface TagMapper {
    String SQL_GET_TAGS_WITH_LIMITED =
            "select id,name,code,description,createAt from mm_tag order by id ";
    String SQL_GET_TAG_BY_ID =
            "select id,name,code,description,createAt from mm_tag where id=#{id}";
    String SQL_INSERT_TAG = "insert into mm_tag (name,code,description) values (#{name},#{code},#{description})";

    String SQL_DELETE_TAG = "delete from mm_tag where id= #{id}";

    String SQL_UPDATE_TAG = "update mm_tag set code=#{code},name=#{name},description=#{description} where id=#{id}";

    @Select(SQL_GET_TAG_BY_ID)
    Tag getTagById(@Param("id") int id);

    @Select(SQL_GET_TAGS_WITH_LIMITED)
    List<Tag> getTags(@Param("offset") int offset, @Param("limit") int limit);

    @Insert(SQL_INSERT_TAG)
    int insertTag(Tag tag);

    @Delete(SQL_DELETE_TAG)
    int deleteTagById(@Param("id") int id);

    @Update(SQL_UPDATE_TAG)
    int updateTag(Tag tag);

}
