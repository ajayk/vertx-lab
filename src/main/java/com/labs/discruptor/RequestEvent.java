package com.labs.discruptor;

import io.vertx.core.http.HttpServerRequest;


/**
 * Created on 7/5/16.
 */
public class RequestEvent
{
	private HttpServerRequest request;

	public void setRequest(final HttpServerRequest request)
	{
		this.request = request;
	}

	public HttpServerRequest getRequest()
	{
		return request;
	}
}
