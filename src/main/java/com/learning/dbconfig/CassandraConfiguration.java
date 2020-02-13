package com.learning.dbconfig;

import com.learning.constants.CassandraConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.AbstractSessionConfiguration;

@Configuration
public class CassandraConfiguration extends AbstractSessionConfiguration {

    @Autowired
    private Environment environment;

    @Override
    protected String getContactPoints() {
        return environment.getProperty("cassandra.cluster.contact-points", CassandraConstants.HOSTNAME);
    }

    @Override
    protected int getPort() {
        return environment.getProperty("cassandra.cluster.port", Integer.TYPE, CassandraConstants.DEFAULT_PORT);
    }

    @Override
    protected String getKeyspaceName() {
        return environment.getProperty("cassandra.keyspace", CassandraConstants.KEYSPACE_NAME);
    }
}
