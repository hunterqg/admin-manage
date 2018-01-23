package com.cm.mm.dao.mapper;

import com.cm.mm.dao.sqlprovider.SmallProgramFavoriteSqlProvider;
import com.cm.mm.model.SmallProgramFavorite;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by qingao on 2018/1/9.
 */
@Mapper
public interface SmallProgramFavoriteMapper {
    @Select("select cloth_id from mm_small_program_favorite where wechat_id=#{wechatId}")
   /* @Results(
            id="Small_Program_Favorite",value =
            {
                    @Result(column = "wechat_id",property = "wechatId"),
                    @Result(column = "cloth_id",property = "clothId")
            }
    )*/
    List<Integer> getSpFavorites(@Param("wechatId") String wechatId);

    @InsertProvider(type = SmallProgramFavoriteSqlProvider.class,method = "getInsertFavoritesSql")
    int insertSpFavorites(@Param("wechatId") String wechatId,List<Integer> ids);

    @DeleteProvider(type = SmallProgramFavoriteSqlProvider.class,method = "getDeleteFavoritesSql")
    int deleteSpFavorites(@Param("wechatId") String wechatId,List<Integer> ids);

}
