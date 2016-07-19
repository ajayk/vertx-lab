package com.labs;

import java.util.concurrent.atomic.AtomicBoolean;


/**
 * Created on 7/5/16.
 */
public class Await
{
	private final AtomicBoolean waiting = new AtomicBoolean(true);

	private Await()
	{
		// empty
	}

	public static Await await()
	{
		final Await AWait = new Await();
		try
		{
			return AWait;
		}
		finally
		{
			AWait.waitFor();
		}
	}

	public static Await await(int seconds)
	{
		final Await AWait = new Await();
		try
		{
			return AWait;
		}
		finally
		{
			AWait.waitFor(seconds);
		}
	}

	public void stop()
	{
		waiting.set(false);
	}

	private void waitFor(int seconds)
	{
		long t1 = System.currentTimeMillis();
		while (waiting.get())
		{
			if ((System.currentTimeMillis() - t1) / 1000 > seconds)
			{
				break;
			}
		}
	}

	private void waitFor()
	{
		while (waiting.get())
		{
			// do nothing
		}
	}
}
