package com.cm.mm.service;

import com.cm.mm.dao.TypeDao;
import com.cm.mm.model.Tag;
import com.cm.mm.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qingao on 2017/11/16.
 */
@Service
public class TypeService {
    @Autowired
    private TypeDao dao;

    public List<Tag> getTypes(int offset, int limit) {
        return dao.getTypes(offset, limit);
    }

    public Tag getTypeById(Integer id) {
        return dao.getTypeById(id);
    }

    public int addType(Type type) {
        return dao.insertType(type);
    }

    public int modifyType(Type type) {
        return dao.updateType(type);
    }

    public int removeTypeById(Integer id) {
        return dao.deleteTypeById(id);
    }
}
