package com.cm.mm.service;

import com.cm.mm.dao.TagDao;
import com.cm.mm.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qingao on 2017/11/16.
 */
@Service
public class TagService {
    @Autowired
    private TagDao tagDao;

    public List<Tag> getTags(int offset,int limit) {
        return tagDao.getTags(offset,limit);
    }

    public Tag getTagById(Integer id) {
        return tagDao.getTagById(id);
    }
    public int addTag(Tag tag) {
        return tagDao.insertTag(tag);
    }
    public int modifyTag(Tag tag) {
        return tagDao.updateTag(tag);
    }
    public int removeTagById(Integer id) {
        return tagDao.deleteTagById(id);
    }
}
