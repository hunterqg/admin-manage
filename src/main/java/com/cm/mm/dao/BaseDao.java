package com.cm.mm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Created by qingao on 2017/11/16.
 */
public abstract class BaseDao {
    @Autowired
    @Qualifier("jdbcTemplate")
    protected NamedParameterJdbcTemplate jdbcTemplate;
}
