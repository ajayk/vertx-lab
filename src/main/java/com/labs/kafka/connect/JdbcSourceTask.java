package com.labs.kafka.connect;

import org.apache.kafka.connect.source.SourceRecord;
import org.apache.kafka.connect.source.SourceTask;
import org.apache.kafka.connect.storage.OffsetStorageReader;

import java.util.List;
import java.util.Map;


/**
 * Created on 7/11/16.
 */
public class JdbcSourceTask extends SourceTask
{
	@Override
	public void start(final Map<String, String> props)
	{

	}

	@Override
	public List<SourceRecord> poll() throws InterruptedException
	{
		final OffsetStorageReader offsetReader = context.offsetStorageReader();

		return null;
	}

	@Override
	public void stop()
	{

	}

	@Override
	public String version()
	{
		return null;
	}
}
