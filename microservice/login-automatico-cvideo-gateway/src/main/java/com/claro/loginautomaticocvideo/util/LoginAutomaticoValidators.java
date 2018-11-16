package com.claro.loginautomaticocvideo.util;

import org.springframework.stereotype.Component;

import com.claro.loginautomaticocvideo.bean.ActivateSubscriptionRequest;
import com.claro.loginautomaticocvideo.bean.QueryCustomerRequest;
import com.claro.loginautomaticocvideo.exception.LoginClaroException;

@Component
public class LoginAutomaticoValidators {

	public void validateActivateSubscription(ActivateSubscriptionRequest request) throws LoginClaroException {
		if (request == null) {
            throw new LoginClaroException("Values are required", ResourceConstants.MISSING_VALUES);
        }
        if (request.getIp() == null || request.getIp().replace(" ", "").equals("")) {
            throw new LoginClaroException("ip is required", ResourceConstants.MISSING_VALUES);
        }
        if (request.getToken() == null || request.getToken().replace(" ", "").equals("")) {
            throw new LoginClaroException("token is required", ResourceConstants.MISSING_VALUES);
        }
	}

	public void validateQueryCustomer(QueryCustomerRequest request) throws LoginClaroException {
		if (request == null) {
            throw new LoginClaroException("Values are required", ResourceConstants.MISSING_VALUES);
        }
        if (request.getIp() == null || request.getIp().replace(" ", "").equals("")) {
            throw new LoginClaroException("ip is required", ResourceConstants.MISSING_VALUES);
        }
	}

}
