package com.labs.discruptor;

import com.lmax.disruptor.RingBuffer;
import io.vertx.core.http.HttpServerRequest;


/**
 * Created on 7/5/16.
 */
public class RequestEventProducer
{
	private final RingBuffer<RequestEvent> buffer;

	public RequestEventProducer(final RingBuffer<RequestEvent> buffer)
	{
		this.buffer = buffer;
	}

	public void handleRequest(HttpServerRequest request)
	{
		final long sequence = buffer.next();
		try
		{
			final RequestEvent event = buffer.get(sequence);
			event.setRequest(request);
		}
		finally
		{
			buffer.publish(sequence);
		}
	}
}
