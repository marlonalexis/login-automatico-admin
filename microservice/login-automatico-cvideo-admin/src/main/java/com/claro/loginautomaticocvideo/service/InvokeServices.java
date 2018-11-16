package com.claro.loginautomaticocvideo.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.apache.axis.AxisFault;
import org.apache.axis.client.Call;
import org.apache.axis.message.SOAPEnvelope;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.claro.loginautomaticocvideo.exception.IntegrationException;
import com.claro.loginautomaticocvideo.util.LogPanelCalidad;

@Service
public class InvokeServices {
	private static final Logger logger = LogManager.getLogger(InvokeServices.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	LogPanelCalidad logPanelCalidad;
	
	String nombreClase = "InvokeServices";
	
	public JSONObject invokeRest(String inputXML, String endpoint) {

		try {

			JSONObject jsonResult = null;
			logPanelCalidad.logMensaje("Invocando rest...", nombreClase);
			HttpHeaders headers = new HttpHeaders();
			headers.add("header_name", "header_value");
			headers.setContentType(MediaType.APPLICATION_JSON);
			logPanelCalidad.logMensaje("inputXML: " + inputXML, nombreClase);

			byte[] ptext = inputXML.getBytes(StandardCharsets.ISO_8859_1); 
			String value = new String(ptext, StandardCharsets.UTF_8); 
			HttpEntity<String> request = new HttpEntity<String>(value, headers);
			ResponseEntity<String> response = restTemplate.postForEntity(endpoint, request, String.class);
			if(response.getBody() != null) {
				jsonResult = new JSONObject(response.getBody().replaceAll("\"SALES.T_VTATABSLCFAC_BI\"", "").replaceAll("[\n\r]", ""));
			}

			return jsonResult;

		} catch (Exception e) {
			logPanelCalidad.logMensaje("ERROR XPATH: " + e.getMessage(), nombreClase);
			return null;
		}
	}
	
	public SOAPEnvelope invokeSOAP(String url, String request, String operation) throws IntegrationException {
		SOAPEnvelope response = null;
		logPanelCalidad.logMensaje("Invocando soap...", nombreClase);
		logPanelCalidad.logMensaje("REQUEST:  " + request, nombreClase);
		try {
			InputStream input = new ByteArrayInputStream(request.getBytes("UTF-8"));
			response = new SOAPEnvelope(input);
			org.apache.axis.client.Service service = new org.apache.axis.client.Service();
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new URL(url));
			call.setOperationName(operation);
			call.setUseSOAPAction(true);
			call.setTimeout(30000);
			response = call.invoke(response);
		} catch (AxisFault e) {
			logPanelCalidad.logMensaje("AXISFAULT EXCEPTION: " + e.getMessage(), nombreClase);
			throw new IntegrationException("ERROR FALLO EN EL SERVICIO", e);

		} catch (Exception e) {
			logPanelCalidad.logMensaje("ERROR AL INVOCAR SERVICIO: " + e.getMessage(), nombreClase);
			throw new IntegrationException("ERROR AL INVOCAR SERVICIO", e);
		}
		return response;
	}

	
}
