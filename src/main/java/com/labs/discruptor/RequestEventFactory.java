package com.labs.discruptor;

import com.lmax.disruptor.EventFactory;


/**
 * Created on 7/5/16.
 */
public class RequestEventFactory implements EventFactory<RequestEvent>
{
	@Override
	public RequestEvent newInstance()
	{
		return new RequestEvent();
	}
}
