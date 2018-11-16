package com.claro.loginautomaticocvideo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.claro.loginautomaticocvideo.bean.admin.ActivarServicioClaroVideoRequest;
import com.claro.loginautomaticocvideo.bean.admin.ActivarServicioClaroVideoResponse;
import com.claro.loginautomaticocvideo.bean.admin.ActualizarFormaPagoRequest;
import com.claro.loginautomaticocvideo.bean.admin.ActualizarFormaPagoResponse;
import com.claro.loginautomaticocvideo.bean.admin.ActualizarServicioFormaPagoTokenRequest;
import com.claro.loginautomaticocvideo.bean.admin.ActualizarServicioFormaPagoTokenResponse;
import com.claro.loginautomaticocvideo.bean.admin.ConsultaFormaPagoClienteRequest;
import com.claro.loginautomaticocvideo.bean.admin.ConsultaFormaPagoClienteResponse;
import com.claro.loginautomaticocvideo.bean.admin.ConsultaFormaPagoSucursalRequest;
import com.claro.loginautomaticocvideo.bean.admin.ConsultaFormaPagoSucursalResponse;
import com.claro.loginautomaticocvideo.bean.admin.ConsultaIPRequest;
import com.claro.loginautomaticocvideo.bean.admin.ConsultaIPResponse;
import com.claro.loginautomaticocvideo.bean.admin.ConsultaInformacionClienteRequest;
import com.claro.loginautomaticocvideo.bean.admin.ConsultaInformacionClienteResponse;
import com.claro.loginautomaticocvideo.bean.admin.ConsultaSucursalMacRequest;
import com.claro.loginautomaticocvideo.bean.admin.ConsultaSucursalMacResponse;
import com.claro.loginautomaticocvideo.bean.admin.ConsultaSuscripcionClienteRequest;
import com.claro.loginautomaticocvideo.bean.admin.ConsultaSuscripcionClienteResponse;
import com.claro.loginautomaticocvideo.bean.admin.ConsultaSuscripcionTokenRequest;
import com.claro.loginautomaticocvideo.bean.admin.ConsultaSuscripcionTokenResponse;
import com.claro.loginautomaticocvideo.bean.admin.FormaPagoCliente;
import com.claro.loginautomaticocvideo.bean.admin.FormaPagoSucursal;
import com.claro.loginautomaticocvideo.bean.admin.GenerarTokenRequest;
import com.claro.loginautomaticocvideo.bean.admin.GenerarTokenResponse;
import com.claro.loginautomaticocvideo.bean.admin.SuscripcionCliente;
import com.claro.loginautomaticocvideo.util.DateDeserializer;
import com.claro.loginautomaticocvideo.util.LogPanelCalidad;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Service
public class AdminService {
	
	@Value("${app.admin.url}")
	String apiAdminUrl;
	
	@Autowired
	LogPanelCalidad logPanelCalidad;
	
	@Autowired
	RestTemplate restTemplate;
	
	String nombreClase = "AdminService";
	
	public ActualizarServicioFormaPagoTokenResponse actualizarServicioFormaPagoToken(String token, String formaPago) {
		ActualizarServicioFormaPagoTokenResponse response = new ActualizarServicioFormaPagoTokenResponse();
		long startTime = System.nanoTime();
		try {
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			ActualizarServicioFormaPagoTokenRequest actualizarServicioFormaPagoTokenRequest = new ActualizarServicioFormaPagoTokenRequest();
			actualizarServicioFormaPagoTokenRequest.setToken(token);
			actualizarServicioFormaPagoTokenRequest.setPaymentMethodId(formaPago);
			
			HttpEntity<ActualizarServicioFormaPagoTokenRequest> request = new HttpEntity<ActualizarServicioFormaPagoTokenRequest>(actualizarServicioFormaPagoTokenRequest, header);
			ResponseEntity<String> restClient = restTemplate.exchange(apiAdminUrl.concat("/actualizarServicioFormaPagoToken"), HttpMethod.POST, request, String.class);
			
			//Panel de calidad
    		logPanelCalidad.logDebug("Consumiendo SRE - actualizarServicioFormaPagoToken", apiAdminUrl.concat("/actualizarServicioFormaPagoToken"),nombreClase);
    		
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
			JSONObject obj = new JSONObject(restClient.getBody()).getJSONObject("response");

			response = gsonBuilder.create().fromJson(obj.toString(), ActualizarServicioFormaPagoTokenResponse.class);
			
			//Panel de calidad
    		logPanelCalidad.logInfo("actualizarServicioFormaPagoToken", "Successful transaction", nombreClase);
		} catch (Exception e) {
			response = null;
			//Panel de calidad
			logPanelCalidad.logError("actualizarServicioFormaPagoToken", e.getMessage(), nombreClase);
		}

		return response;
	}
	
	public ActivarServicioClaroVideoResponse activarServicioClaroVideo(String token) {
		ActivarServicioClaroVideoResponse response = new ActivarServicioClaroVideoResponse();
		long startTime = System.nanoTime();
		try {
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			ActivarServicioClaroVideoRequest activarServicioClaroVideoRequest = new ActivarServicioClaroVideoRequest();
			activarServicioClaroVideoRequest.setToken(token);
			
			HttpEntity<ActivarServicioClaroVideoRequest> request = new HttpEntity<ActivarServicioClaroVideoRequest>(activarServicioClaroVideoRequest, header);
			ResponseEntity<String> restClient = restTemplate.exchange(apiAdminUrl.concat("/activarServicioClaroVideo"), HttpMethod.POST, request, String.class);
			
			//Panel de calidad
    		logPanelCalidad.logDebug("Consumiendo SRE - activarServicioClaroVideo", apiAdminUrl.concat("/activarServicioClaroVideo"), nombreClase);
    		
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
			JSONObject obj = new JSONObject(restClient.getBody()).getJSONObject("response");

			response = gsonBuilder.create().fromJson(obj.toString(), ActivarServicioClaroVideoResponse.class);
			
			//Panel de calidad
    		logPanelCalidad.logInfo("activarServicioClaroVideo", "Successful transaction", nombreClase);
		} catch (Exception e) {
			response = null;
			//Panel de calidad
			logPanelCalidad.logError("activarServicioClaroVideo", e.getMessage(), nombreClase);
		}

		return response;
	}
	
	public ActualizarFormaPagoResponse actualizarFormaPago(String token, String formaPago, String codSuc) {
		ActualizarFormaPagoResponse response = new ActualizarFormaPagoResponse();
		long startTime = System.nanoTime();
		try {
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			ActualizarFormaPagoRequest actualizarFormaPagoRequest = new ActualizarFormaPagoRequest();
			actualizarFormaPagoRequest.setToken(token);
			actualizarFormaPagoRequest.setPaymentMethodId(formaPago);
			actualizarFormaPagoRequest.setAddressId(codSuc);
			
			HttpEntity<ActualizarFormaPagoRequest> request = new HttpEntity<ActualizarFormaPagoRequest>(actualizarFormaPagoRequest, header);
			ResponseEntity<String> restClient = restTemplate.exchange(apiAdminUrl.concat("/actualizarFormaPago"), HttpMethod.POST, request, String.class);
			
			//Panel de calidad
    		logPanelCalidad.logDebug("Consumiendo SRE - actualizarFormaPago", apiAdminUrl.concat("/actualizarFormaPago"), nombreClase);
    		
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
			JSONObject obj = new JSONObject(restClient.getBody()).getJSONObject("response");

			response = gsonBuilder.create().fromJson(obj.toString(), ActualizarFormaPagoResponse.class);
			
			//Panel de calidad
    		logPanelCalidad.logInfo("actualizarFormaPago", "Successful transaction", nombreClase);
		} catch (Exception e) {
			response = null;
			//Panel de calidad
			logPanelCalidad.logError("actualizarFormaPago", e.getMessage(), nombreClase);
		}

		return response;
	}
	
	public ConsultaFormaPagoClienteResponse consultaFormaPagoCliente(String codCli, String onlyServicesFlag) {
		ConsultaFormaPagoClienteResponse response = new ConsultaFormaPagoClienteResponse();
		long startTime = System.nanoTime();
		try {
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			ConsultaFormaPagoClienteRequest consultaFormaPagoClienteRequest = new ConsultaFormaPagoClienteRequest();
			consultaFormaPagoClienteRequest.setCustomerId(codCli);
			consultaFormaPagoClienteRequest.setOnlyServicesFlag(onlyServicesFlag);
			
			HttpEntity<ConsultaFormaPagoClienteRequest> request = new HttpEntity<ConsultaFormaPagoClienteRequest>(consultaFormaPagoClienteRequest, header);
			ResponseEntity<String> restClient = restTemplate.exchange(apiAdminUrl.concat("/consultaFormaPagoCliente"), HttpMethod.POST, request, String.class);
			
			//Panel de calidad
			long endTimeDebug = System.nanoTime();
    		logPanelCalidad.logDebug("Consumiendo JEIS - consultaFormaPagoCliente", apiAdminUrl.concat("/consultaFormaPagoCliente"), nombreClase);
    		
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
			JSONObject objectResult = new JSONObject(restClient.getBody()).getJSONObject("response");

			List<FormaPagoCliente> FormaPagoCliente = new ArrayList<FormaPagoCliente>();
			Object jsonArray = objectResult.get("formaPagoCliente");
			FormaPagoCliente = gsonBuilder.create().fromJson(jsonArray.toString(), new TypeToken<List<FormaPagoCliente>>(){}.getType());
			response.setFormaPagoCliente(FormaPagoCliente);
			
			//Panel de calidad
    		logPanelCalidad.logInfo("consultaFormaPagoCliente", "Successful transaction", nombreClase);
		} catch (Exception e) {
			response = null;
			//Panel de calidad
			logPanelCalidad.logError("consultaFormaPagoCliente", e.getMessage(), nombreClase);
		}
		return response;
	}
	
	public ConsultaFormaPagoSucursalResponse consultaFormaPagoSucursal(String codSucursal) {
		ConsultaFormaPagoSucursalResponse response = new ConsultaFormaPagoSucursalResponse();
		long startTime = System.nanoTime();
		try {
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			ConsultaFormaPagoSucursalRequest consultaFormaPagoSucursalRequest = new ConsultaFormaPagoSucursalRequest();
			consultaFormaPagoSucursalRequest.setAddressId(codSucursal);
			
			HttpEntity<ConsultaFormaPagoSucursalRequest> request = new HttpEntity<ConsultaFormaPagoSucursalRequest>(consultaFormaPagoSucursalRequest, header);
			ResponseEntity<String> restClient = restTemplate.exchange(apiAdminUrl.concat("/consultaFormaPagoSucursal"), HttpMethod.POST, request, String.class);
			
			//Panel de calidad
    		logPanelCalidad.logDebug("Consumiendo JEIS - consultaFormaPagoSucursal", apiAdminUrl.concat("/consultaFormaPagoSucursal"), nombreClase);
    		
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
			JSONObject objectResult = new JSONObject(restClient.getBody()).getJSONObject("response");

			List<FormaPagoSucursal> FormaPagoSucursal = new ArrayList<FormaPagoSucursal>();
			Object jsonArray = objectResult.get("formaPagoSucursal");
			FormaPagoSucursal = gsonBuilder.create().fromJson(jsonArray.toString(), new TypeToken<List<FormaPagoSucursal>>(){}.getType());
			response.setFormaPagoSucursal(FormaPagoSucursal);
			
			//Panel de calidad
    		logPanelCalidad.logInfo("consultaFormaPagoSucursal", "Successful transaction", nombreClase);
		} catch (Exception e) {
			response = null;
			//Panel de calidad
			logPanelCalidad.logError("consultaFormaPagoSucursal", e.getMessage(), nombreClase);
		}
		return response;
	}
	
	public ConsultaSucursalMacResponse consultaSucursalMac(String macAddress) {
		ConsultaSucursalMacResponse response = new ConsultaSucursalMacResponse();
		long startTime = System.nanoTime();
		try {
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			ConsultaSucursalMacRequest consultaSucursalMacRequest = new ConsultaSucursalMacRequest();
			consultaSucursalMacRequest.setMacAddress(macAddress);
			
			HttpEntity<ConsultaSucursalMacRequest> request = new HttpEntity<ConsultaSucursalMacRequest>(consultaSucursalMacRequest, header);
			ResponseEntity<String> restClient = restTemplate.exchange(apiAdminUrl.concat("/consultaSucursalMac"), HttpMethod.POST, request, String.class);
			
			//Panel de calidad
    		logPanelCalidad.logDebug("Consumiendo JEIS - consultaSucursalMac", apiAdminUrl.concat("/consultaSucursalMac"), nombreClase);
    		
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
			JSONObject obj = new JSONObject(restClient.getBody()).getJSONObject("response");
			
			//Panel de calidad
    		logPanelCalidad.logInfo("consultaSucursalMac", "Successful transaction", nombreClase);
    		
			response = gsonBuilder.create().fromJson(obj.toString(), ConsultaSucursalMacResponse.class);
		
		} catch (Exception e) {
			response = null;
			//Panel de calidad
			logPanelCalidad.logError("consultaSucursalMac", e.getMessage(), nombreClase);
		}
		return response;
	}
	
	public ConsultaIPResponse consultaIP(String ipCliente) {
		ConsultaIPResponse response = new ConsultaIPResponse();
		long startTime = System.nanoTime();
		try {
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			ConsultaIPRequest consultaIP = new ConsultaIPRequest();
			consultaIP.setIp(ipCliente);
    		
			HttpEntity<ConsultaIPRequest> request = new HttpEntity<ConsultaIPRequest>(consultaIP, header);
			ResponseEntity<String> restClient = restTemplate.exchange(apiAdminUrl.concat("/consultaIP"), HttpMethod.POST, request, String.class);
			
			//Panel de calidad
    		logPanelCalidad.logDebug("Consumiendo JEIS - consultaIP", apiAdminUrl.concat("/consultaIP"), nombreClase);
    		
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
			JSONObject obj = new JSONObject(restClient.getBody()).getJSONObject("response");
			
			//Panel de calidad
    		logPanelCalidad.logInfo("consultaIP", "Successful transaction", nombreClase);
    		
			response = gsonBuilder.create().fromJson(obj.toString(), ConsultaIPResponse.class);
			
		} catch (Exception e) {
			response = null;
			//Panel de calidad
			logPanelCalidad.logError("consultaIP", e.getMessage(), nombreClase);
		}
		return response;
	}
	
	public ConsultaSuscripcionTokenResponse consultaSuscripcionToken(String token) {
		ConsultaSuscripcionTokenResponse response = new ConsultaSuscripcionTokenResponse();
		long startTime = System.nanoTime();
		try {
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			ConsultaSuscripcionTokenRequest consultaSuscripcionToken = new ConsultaSuscripcionTokenRequest();
			consultaSuscripcionToken.setToken(token);
			
			HttpEntity<ConsultaSuscripcionTokenRequest> request = new HttpEntity<ConsultaSuscripcionTokenRequest>(consultaSuscripcionToken, header);
			ResponseEntity<String> restClient = restTemplate.exchange(apiAdminUrl.concat("/consultaSuscripcionToken"), HttpMethod.POST, request, String.class);
			
			//Panel de calidad
    		logPanelCalidad.logDebug("Consumiendo JEIS - consultaSuscripcionToken", apiAdminUrl.concat("/consultaSuscripcionToken"), nombreClase);
    		
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
			JSONObject obj = new JSONObject(restClient.getBody()).getJSONObject("response");
			//Panel de calidad
    		logPanelCalidad.logInfo("consultaSuscripcionToken", "Successful transaction", nombreClase);
    		
			response = gsonBuilder.create().fromJson(obj.toString(), ConsultaSuscripcionTokenResponse.class);
			
		} catch (Exception e) {
			response = null;
			//Panel de calidad
			logPanelCalidad.logError("consultaSuscripcionToken", e.getMessage(), nombreClase);
		}
		return response;
	}

	public ConsultaSuscripcionClienteResponse consultaSuscripcionCliente(String customerid) {
		ConsultaSuscripcionClienteResponse response = new ConsultaSuscripcionClienteResponse();
		long startTime = System.nanoTime();
		try {
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			ConsultaSuscripcionClienteRequest consultaSuscripcionClienteRequest = new ConsultaSuscripcionClienteRequest();
			consultaSuscripcionClienteRequest.setCustomerId(customerid);
			
			HttpEntity<ConsultaSuscripcionClienteRequest> request = new HttpEntity<ConsultaSuscripcionClienteRequest>(consultaSuscripcionClienteRequest, header);
			ResponseEntity<String> restClient = restTemplate.exchange(apiAdminUrl.concat("/consultaSuscripcionCliente"), HttpMethod.POST, request, String.class);
			
			//Panel de calidad
    		logPanelCalidad.logDebug("Consumiendo JEIS - consultaSuscripcionCliente", apiAdminUrl.concat("/consultaSuscripcionCliente"), nombreClase);
    		
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
			JSONObject objectResult = new JSONObject(restClient.getBody()).getJSONObject("response");

			List<SuscripcionCliente> SuscripcionCliente = new ArrayList<SuscripcionCliente>();
			Object jsonArray = objectResult.get("suscripcionCliente");
			SuscripcionCliente = gsonBuilder.create().fromJson(jsonArray.toString(), new TypeToken<List<SuscripcionCliente>>(){}.getType());
			response.setSuscripcionCliente(SuscripcionCliente);
			
			//Panel de calidad
    		logPanelCalidad.logInfo("consultaSuscripcionCliente", "Successful transaction", nombreClase);
		} catch (Exception e) {
			response = null;
			//Panel de calidad
			logPanelCalidad.logError("consultaSuscripcionCliente", e.getMessage(), nombreClase);
		}
		return response;
	}

	public ConsultaInformacionClienteResponse consultaInformacionCliente(String customerid) {
		ConsultaInformacionClienteResponse response = new ConsultaInformacionClienteResponse();
		long startTime = System.nanoTime();
		try {
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			ConsultaInformacionClienteRequest consultaInformacionClienteRequest = new ConsultaInformacionClienteRequest();
			consultaInformacionClienteRequest.setCustomerId(customerid);
			
			HttpEntity<ConsultaInformacionClienteRequest> request = new HttpEntity<ConsultaInformacionClienteRequest>(consultaInformacionClienteRequest, header);
			ResponseEntity<String> restClient = restTemplate.exchange(apiAdminUrl.concat("/consultaInformacionCliente"), HttpMethod.POST, request, String.class);
			
			//Panel de calidad
    		logPanelCalidad.logDebug("Consumiendo JEIS - consultaInformacionCliente", apiAdminUrl.concat("/consultaInformacionCliente"), nombreClase);
    		
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
			JSONObject obj = new JSONObject(restClient.getBody()).getJSONObject("response");
			
			response = gsonBuilder.create().fromJson(obj.toString(), ConsultaInformacionClienteResponse.class);
			
			//Panel de calidad
    		logPanelCalidad.logInfo("consultaInformacionCliente", "Successful transaction", nombreClase);
		} catch (Exception e) {
			response = null;
			//Panel de calidad
			logPanelCalidad.logError("consultaInformacionCliente", e.getMessage(), nombreClase);
		}
		return response;
	}

	public GenerarTokenResponse generarToken(String customerid, String billingmail, String mailClaroOpcional) {
		GenerarTokenResponse response = new GenerarTokenResponse();
		long startTime = System.nanoTime();
		try {
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			GenerarTokenRequest generarTokenRequest = new GenerarTokenRequest();
			generarTokenRequest.setCustomerId(customerid);
			generarTokenRequest.setClaroVideoMail(billingmail);
			generarTokenRequest.setClaroWebSiteMail(mailClaroOpcional);
			
			HttpEntity<GenerarTokenRequest> request = new HttpEntity<GenerarTokenRequest>(generarTokenRequest, header);
			ResponseEntity<String> restClient = restTemplate.exchange(apiAdminUrl.concat("/generarToken"), HttpMethod.POST, request, String.class);
			
			//Panel de calidad
    		logPanelCalidad.logDebug("Consumiendo SRE - generarToken", apiAdminUrl.concat("/generarToken"), nombreClase);
    		
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
			JSONObject obj = new JSONObject(restClient.getBody()).getJSONObject("response");
			
			response = gsonBuilder.create().fromJson(obj.toString(), GenerarTokenResponse.class);
			
			//Panel de calidad
    		logPanelCalidad.logInfo("GenerarToken", "Successful transaction", nombreClase);
		} catch (Exception e) {
			response = null;
			//Panel de calidad
			logPanelCalidad.logError("GenerarToken", e.getMessage(), nombreClase);
		}
		return response;
	}
}
