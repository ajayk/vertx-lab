package com.labs.discruptor;

import com.lmax.disruptor.EventHandler;
import io.vertx.core.http.HttpServerRequest;


/**
 * Created on 7/5/16.
 */
public class RequestEventHandler implements EventHandler<RequestEvent>
{
	@Override
	public void onEvent(final RequestEvent event, final long sequence, final boolean endOfBatch) throws Exception
	{
		System.out.println("sequence = " + sequence);
		final HttpServerRequest request = event.getRequest();
		request.response().end("Hello world (sequence = " + sequence + ")");
	}
}
