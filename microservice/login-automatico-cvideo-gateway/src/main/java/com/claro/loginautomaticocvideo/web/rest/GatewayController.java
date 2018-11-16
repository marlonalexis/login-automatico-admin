package com.claro.loginautomaticocvideo.web.rest;

import java.util.UUID;

import javax.xml.ws.http.HTTPException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.claro.loginautomaticocvideo.bean.ActivateSubscriptionRequest;
import com.claro.loginautomaticocvideo.bean.ActivateSubscriptionResponse;
import com.claro.loginautomaticocvideo.bean.QueryCustomerRequest;
import com.claro.loginautomaticocvideo.bean.QueryCustomerResponse;
import com.claro.loginautomaticocvideo.bean.admin.GenericResponse;
import com.claro.loginautomaticocvideo.exception.LoginClaroException;
import com.claro.loginautomaticocvideo.service.LoginClaroVideoService;
import com.claro.loginautomaticocvideo.util.LogPanelCalidad;
import com.claro.loginautomaticocvideo.util.LoginAutomaticoValidators;
import com.claro.loginautomaticocvideo.util.ResourceConstants;

@Component
@RestController
@RequestMapping("/LoginClaroVideo")
public class GatewayController {

	private static final Logger log = LogManager.getLogger(GatewayController.class);
	
	@Autowired
	LoginClaroVideoService loginClaroVideoService;
	
	@Autowired
	LogPanelCalidad logPanelCalidad;
	
	@Autowired
	LoginAutomaticoValidators loginAutomaticoValidators;
	
	String nombreClase = "GatewayController";
	
    @RequestMapping(path = "/queryCustomer", method = RequestMethod.POST, consumes = {
            MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"})
    public GenericResponse<QueryCustomerResponse> queryCustomer(@RequestBody QueryCustomerRequest request) throws HTTPException {
    	String threadID=UUID.randomUUID().toString();
		ThreadContext.put("sid", threadID);
		logPanelCalidad.logMensaje("queryCustomer: Petición Recibida", nombreClase);
		long startTime = System.nanoTime();
    	GenericResponse<QueryCustomerResponse> response = new GenericResponse<>();
    	try {
    		loginAutomaticoValidators.validateQueryCustomer(request);
    		QueryCustomerResponse queryCustomerResponse = loginClaroVideoService.queryCustomer(request);
    	
    		response.setCode(ResourceConstants.SUCCESS_CODE);
	    	response.setStatus("OK");
    		response.setMessage("Successful transaction");
    		response.setResponse(queryCustomerResponse);
    		long endTime = System.nanoTime();
    		logPanelCalidad.logInfo(startTime, endTime, "queryCustomer", "Successful transaction", nombreClase);
    	} catch(LoginClaroException e) {
    		response.setCode(e.getErrorCode());
    		response.setStatus("ERROR");
    		response.setMessage(e.getMessage());	
    		long endTime = System.nanoTime();
    		logPanelCalidad.logError(startTime, endTime, "queryCustomer", e.getMessage(), nombreClase);
    	}catch(Exception e) {
    		response.setCode(ResourceConstants.UNKNOWN_ERROR);
    		response.setStatus("ERROR");
    		response.setMessage(e.getMessage());
    		long endTime = System.nanoTime();
    		logPanelCalidad.logError(startTime, endTime, "queryCustomer", e.getMessage(), nombreClase);
    	}
    	return response;
    }
    
    @RequestMapping(path = "/activateSubscription", method = RequestMethod.POST, consumes = {
            MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"})
    public GenericResponse<ActivateSubscriptionResponse> activateSubscription(@RequestBody ActivateSubscriptionRequest request) {
    	String threadID=UUID.randomUUID().toString();
		ThreadContext.put("sid", threadID);
		logPanelCalidad.logMensaje("activateSubscription: Petición Recibida", nombreClase);
		long startTime = System.nanoTime();
    	GenericResponse<ActivateSubscriptionResponse> response = new GenericResponse<>();
    	try {
    		loginAutomaticoValidators.validateActivateSubscription(request);
    		ActivateSubscriptionResponse activateSubscriptionResponse = loginClaroVideoService.activateSubscription(request);
    		
    		response.setCode(ResourceConstants.SUCCESS_CODE);
	    	response.setStatus("OK");
    		response.setMessage("Successful transaction");
    		response.setResponse(activateSubscriptionResponse);
    		long endTime = System.nanoTime();
    		logPanelCalidad.logInfo(startTime, endTime, "activateSubscription", "Successful transaction", nombreClase);
    	} catch(LoginClaroException e) {
    		response.setCode(e.getErrorCode());
    		response.setStatus("ERROR");
    		response.setMessage(e.getMessage());	
    		long endTime = System.nanoTime();
    		logPanelCalidad.logError(startTime, endTime, "activateSubscription", e.getMessage(), nombreClase);
    	} catch(Exception e) {
    		response.setCode(ResourceConstants.UNKNOWN_ERROR);
    		response.setStatus("ERROR");
    		response.setMessage(e.getMessage());
    		long endTime = System.nanoTime();
    		logPanelCalidad.logError(startTime, endTime, "activateSubscription", e.getMessage(), nombreClase);
    	}
    	return response;
    }
}
