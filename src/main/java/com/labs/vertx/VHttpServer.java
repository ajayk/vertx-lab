package com.labs.vertx;

import com.labs.Await;
import com.labs.discruptor.RequestEvent;
import com.labs.discruptor.RequestEventFactory;
import com.labs.discruptor.RequestEventHandler;
import com.labs.discruptor.RequestEventProducer;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;


/**
 * Created on 7/4/16.
 */
public class VHttpServer
{
	public static void main(String[] args)
	{
		final ThreadFactory threadFactory = Executors.defaultThreadFactory();

		// create request event factory
		final RequestEventFactory factory = new RequestEventFactory();

		// set buffer size
		int bufferSize = 1024;

		// create disruptor instance.
		final Disruptor<RequestEvent> disruptor = new Disruptor<>(factory, bufferSize, threadFactory);

		// configure event handler
		disruptor.handleEventsWith(new RequestEventHandler());

		// start disruptor
		disruptor.start();

		// get ring buffer
		final RingBuffer<RequestEvent> ringBuffer = disruptor.getRingBuffer();

		// create request event producer
		final RequestEventProducer eventProducer = new RequestEventProducer(ringBuffer);

		// create and initialize http server
		final Vertx vertx = Vertx.vertx();
		final HttpServerOptions options = new HttpServerOptions();
		options.setPort(8080);
		options.setHost("localhost");
		final HttpServer httpServer = vertx.createHttpServer(options);

		httpServer.requestHandler(eventProducer::handleRequest);

		// start listening
		httpServer.listen();

		System.out.println("Started server and waiting for request...");

		Await.await();
	}

	/*private static void handleRequest(final HttpServerRequest request)
	{
		final Future<HttpServerResponse> future = Future.future();
		future.setHandler(async -> {
			if (async.succeeded())
			{
				final HttpServerResponse response = async.result();
				response.end("Hello world (" + counter.incrementAndGet() + ") !!!");
			}
		});

		executor.submit(() -> {
			waitFor(2);
			future.complete(request.response());
		});
	}*/
}
