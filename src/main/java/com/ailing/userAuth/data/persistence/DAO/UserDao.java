package com.ailing.userAuth.data.persistence.DAO;


import com.ailing.userAuth.data.persistence.model.User;
import com.datastax.oss.driver.api.core.PagingIterable;
import com.datastax.oss.driver.api.mapper.annotations.*;

import java.util.UUID;

@Dao
public interface UserDao {
    @Select
    PagingIterable<User> all();

    @Select
    User findById(UUID userId);

    @Insert
    void save(User user);

    @Update(ifExists = true)
    boolean updateIfExists(User user);

    @Delete
    void delete(User user);
}
