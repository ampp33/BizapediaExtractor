package org.malibu.msu.bizapedia.ws;

public class BizapediaWsClientException extends Exception {

	private static final long serialVersionUID = 1L;

	public BizapediaWsClientException() {
		super();
	}

	public BizapediaWsClientException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BizapediaWsClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public BizapediaWsClientException(String message) {
		super(message);
	}

	public BizapediaWsClientException(Throwable cause) {
		super(cause);
	}
	
}
