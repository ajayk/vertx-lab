package com.labs.kafka.connect;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.source.SourceConnector;

import java.util.List;
import java.util.Map;


/**
 * Created on 7/11/16.
 */
public class JdbcSourceConnector extends SourceConnector
{
	@Override
	public String version()
	{
		return null;
	}

	@Override
	public void start(final Map<String, String> props)
	{

	}

	@Override
	public Class<? extends Task> taskClass()
	{
		return JdbcSourceTask.class;
	}

	@Override
	public List<Map<String, String>> taskConfigs(final int maxTasks)
	{
		return null;
	}

	@Override
	public void stop()
	{

	}

	@Override
	public ConfigDef config()
	{
		return null;
	}
}
