package com.ailing.userAuth.data.persistence.mapper;

import com.ailing.userAuth.data.persistence.DAO.UserDao;
import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.mapper.annotations.DaoFactory;
import com.datastax.oss.driver.api.mapper.annotations.DaoKeyspace;
import com.datastax.oss.driver.api.mapper.annotations.Mapper;

@Mapper
public interface UserMapper {
    @DaoFactory
    UserDao userDao(@DaoKeyspace CqlIdentifier keyspace);
}
