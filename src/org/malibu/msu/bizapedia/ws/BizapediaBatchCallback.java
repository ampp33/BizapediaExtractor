package org.malibu.msu.bizapedia.ws;

import https.www_bizapedia.Company;
import https.www_bizapedia.Principal;

public interface BizapediaBatchCallback {
	public void handleResult(Company company) throws Exception;
	public void handleResult(Principal principle) throws Exception;
}
