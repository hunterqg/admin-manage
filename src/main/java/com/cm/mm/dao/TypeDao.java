package com.cm.mm.dao;

import com.cm.mm.dao.mapper.TypeMapper;
import com.cm.mm.model.Tag;
import com.cm.mm.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by qingao on 2017/11/16.
 */
@Component
public class TypeDao {

    @Autowired
    private TypeMapper mapper;


    public List<Tag> getTypes(int offset, int limit) {
        return mapper.getTypes(offset, limit);
    }

    public Tag getTypeById(Integer id) {
        return mapper.getTypeById(id);
    }

    public int insertType(Type type) {
        return mapper.insertType(type);
    }

    public int deleteTypeById(Integer id) {
        return mapper.deleteTypeById(id);
    }

    public int updateType(Type type) {
        return mapper.updateType(type);
    }
}
