package com.ailing.userAuth.data.persistence;

import com.ailing.userAuth.data.persistence.DAO.UserDao;
import com.ailing.userAuth.data.persistence.mapper.UserMapper;
import com.ailing.userAuth.data.persistence.mapper.UserMapperBuilder;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.CqlSessionBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;

@Configuration
public class CassandraConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(CassandraConfiguration.class);

    private static final String KEYSPACE = "userkeyspace";

    @Bean
    public CqlSession cqlSession() throws Exception {
        CqlSessionBuilder builder = CqlSession.builder();
        builder.addContactPoint(new InetSocketAddress("127.0.0.1", 9042));
        builder.withLocalDatacenter("datacenter1");
        final CqlSession retVal = builder.build();
        LOGGER.info("Initialized CqlSession: {}", retVal.toString());
        return retVal;
    }

    @Bean
    public UserMapper userMapper(final CqlSession cqlSession) {
        return new UserMapperBuilder(cqlSession).build();
    }

    @Bean
    public UserDao userDao(final UserMapper itemsMapper) {
        return itemsMapper.userDao(CqlIdentifier.fromCql(KEYSPACE));
    }
}
