package com.cm.mm.dao.mapper;

import com.cm.mm.model.Tag;
import com.cm.mm.model.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by qingao on 2017/11/16.
 */
@Mapper
public interface TypeMapper {
    String SQL_GET_TYPES_WITH_LIMITED =
            "select id,name,code,description,createAt,updateAt from mm_type order by id ";
    String SQL_GET_TYPE_BY_ID =
            "select id,name,code,description,createAt,updateAt from mm_type where id=#{id}";
    String SQL_INSERT_TYPE= "insert into mm_type (name,code,description) values (#{name},#{code},#{description})";

    String SQL_DELETE_TYPE = "delete from mm_type where id= #{id}";

    String SQL_UPDATE_TYPE = "update mm_type set code=#{code},name=#{name},description=#{description} where id=#{id}";

    @Select(SQL_GET_TYPE_BY_ID)
    Tag getTypeById(@Param("id") int id);

    @Select(SQL_GET_TYPES_WITH_LIMITED)
    List<Tag> getTypes(@Param("offset") int offset, @Param("limit") int limit);

    @Insert(SQL_INSERT_TYPE)
    int insertType(Type type);

    @Delete(SQL_DELETE_TYPE)
    int deleteTypeById(@Param("id") int id);

    @Update(SQL_UPDATE_TYPE)
    int updateType(Type type);

}
