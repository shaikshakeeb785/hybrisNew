/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.threadcontext;

/**
 * The ThreadContextService supports executing code in a thread context and also getting and setting attribute values in
 * the current thread context.
 */
public interface ThreadContextService extends ThreadContext
{
	/**
	 * @return the current {@link ThreadContext}
	 */
	ThreadContext getCurrentContext();

	/**
	 * Execute the wrapper code in the context of the specified user
	 *
	 * @param wrapper
	 *           The code to execute in that context
	 * @param <R>
	 *           The type of the return value
	 * @param <T>
	 *           The type of the exception thrown by the wrapper
	 * @return The result of method being executed
	 * @throws T
	 *            The exception thrown by the wrapper if an error occurs
	 */
	<R, T extends Throwable> R executeInContext(Executor<R, T> wrapper) throws T;

	/**
	 * Interface to implement for the executeInContext method. If no return result is required then set R to Object and
	 * return null. If no exception is expected to be thrown then set T to NothingException.
	 *
	 * @param <R>
	 *           The return type
	 * @param <T>
	 *           The exception type
	 */
	interface Executor<R, T extends Throwable>
	{
		/**
		 * This method is called in the impersonation execution context.
		 *
		 * @return The return value
		 * @throws T
		 *            the exception thrown on error
		 */
		R execute() throws T;
	}

	final class Nothing extends RuntimeException
	{
		// Deliberately private to prevent creation
		private Nothing()
		{
			// Prevent construction
		}
	}
}
