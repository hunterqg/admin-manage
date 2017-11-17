package com.cm.mm.dao;

import com.cm.mm.dao.mapper.TagMapper;
import com.cm.mm.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by qingao on 2017/11/16.
 */
@Component
public class TagDao {

    @Autowired
    private TagMapper mapper;


    public List<Tag> getTags(int offset, int limit) {
        return mapper.getTags(offset, limit);
    }

    public Tag getTagById(Integer id) {
        return mapper.getTagById(id);
    }

    public int insertTag(Tag tag) {
        return mapper.insertTag(tag);
    }

    public int deleteTagById(Integer id) {
        return mapper.deleteTagById(id);
    }

    public int updateTag(Tag tag) {
        return mapper.updateTag(tag);
    }
}
