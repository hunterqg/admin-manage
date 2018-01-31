package com.cm.mm.dao.mapper;

import com.cm.mm.dao.sqlprovider.SmallProgramFavoriteSqlProvider;
import com.cm.mm.model.Cloth;
import com.cm.mm.model.SmallProgramFavorite;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by qingao on 2018/1/9.
 */
@Mapper
public interface SmallProgramFavoriteMapper {
    @Select("select c.id,name,model,brand_id,price,type,user_id,pic_url,url_type,description,c.createAt,c.updateAt from mm_cloth c,mm_small_program_favorite sp where sp.cloth_id = c.id and sp.wechat_id=#{wechatId}")
    @Results(
            id="Cloth",value =
            {
                    @Result(column = "pic_url",property = "picUrl"),
                    @Result(column = "user_id",property = "userId"),
                    @Result(column = "url_type",property = "urlType"),
                    @Result(column = "brand_id",property = "brand",one=@One(select = "com.cm.mm.dao.mapper.ClothBrandMapper.getClothBrandById"))
            }
    )
    List<Cloth> getSpFavorites(@Param("wechatId") String wechatId);

    @InsertProvider(type = SmallProgramFavoriteSqlProvider.class,method = "getInsertFavoritesSql")
    int insertSpFavorites(@Param("wechatId") String wechatId,List<Integer> ids);

    @DeleteProvider(type = SmallProgramFavoriteSqlProvider.class,method = "getDeleteFavoritesSql")
    int deleteSpFavorites(@Param("wechatId") String wechatId,List<Integer> ids);

}
