package com.claro.loginautomaticocvideo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claro.loginautomaticocvideo.bean.ConsultaFormaPagoClienteRequest;
import com.claro.loginautomaticocvideo.bean.ConsultaFormaPagoClienteResponse;
import com.claro.loginautomaticocvideo.bean.ConsultaFormaPagoSucursalRequest;
import com.claro.loginautomaticocvideo.bean.ConsultaFormaPagoSucursalResponse;
import com.claro.loginautomaticocvideo.bean.ConsultaIPRequest;
import com.claro.loginautomaticocvideo.bean.ConsultaIPResponse;
import com.claro.loginautomaticocvideo.bean.ConsultaInformacionClienteRequest;
import com.claro.loginautomaticocvideo.bean.ConsultaInformacionClienteResponse;
import com.claro.loginautomaticocvideo.bean.ConsultaSucursalMacRequest;
import com.claro.loginautomaticocvideo.bean.ConsultaSucursalMacResponse;
import com.claro.loginautomaticocvideo.bean.ConsultaSuscripcionClienteRequest;
import com.claro.loginautomaticocvideo.bean.ConsultaSuscripcionClienteResponse;
import com.claro.loginautomaticocvideo.bean.ConsultaSuscripcionTokenRequest;
import com.claro.loginautomaticocvideo.bean.ConsultaSuscripcionTokenResponse;
import com.claro.loginautomaticocvideo.bean.FormaPagoCliente;
import com.claro.loginautomaticocvideo.bean.FormaPagoSucursal;
import com.claro.loginautomaticocvideo.bean.GenericRequest;
import com.claro.loginautomaticocvideo.bean.SuscripcionCliente;
import com.claro.loginautomaticocvideo.dao.ActionsRepository;
import com.claro.loginautomaticocvideo.domain.Actions;
import com.claro.loginautomaticocvideo.exception.AdminManagerException;
import com.claro.loginautomaticocvideo.util.DateDeserializer;
import com.claro.loginautomaticocvideo.util.LogPanelCalidad;
import com.claro.loginautomaticocvideo.util.ResourceConstants;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

@Service 
public class JeisService {
	@Autowired
	InvokeServices invokeService;
	
	@Autowired
	ActionsRepository actionsRepository;
	
	@Autowired
	LogPanelCalidad logPanelCalidad;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public ConsultaIPResponse consultarIP(ConsultaIPRequest request) throws AdminManagerException{
		Actions jeis = actionsRepository.findById(ResourceConstants.CONSULTA_IP);
		String inputXML = jeis.getPayload();
		inputXML =  inputXML.replace("{pvIdRequest}", jeis.getIdRequest());
		inputXML =  inputXML.replace("{pvIp}", request.getIp());
		JSONObject objectResult = invokeService.invokeRest(inputXML, jeis.getEndpoint()+jeis.getOperation());
		ConsultaIPResponse consultaIP = new ConsultaIPResponse();
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
		
		if(objectResult != null) {
			try {
				if (objectResult.getJSONObject("datos").getJSONObject("registro") != null) {
					consultaIP = gsonBuilder.create().fromJson(objectResult.getJSONObject("datos").getJSONObject("registro").toString(), ConsultaIPResponse.class);
				}
			} catch (Exception e) {
				consultaIP = gsonBuilder.create().fromJson(objectResult.toString(), ConsultaIPResponse.class);
			}
		}else {
			throw new AdminManagerException("No hay conexion con el servicio");
		}
		
		return consultaIP;
	}

	public ConsultaInformacionClienteResponse consultarInformacionCliente(
			ConsultaInformacionClienteRequest request) throws AdminManagerException {
		Actions jeis = actionsRepository.findById(ResourceConstants.CONSULTA_INFORMACION_CLIENTE);
		String inputXML = jeis.getPayload();
		inputXML =  inputXML.replace("{pvIdRequest}", jeis.getIdRequest());
		inputXML =  inputXML.replace("{pvcustomerId}", request.getCustomerId());
		JSONObject objectResult = invokeService.invokeRest(inputXML, jeis.getEndpoint()+jeis.getOperation());
		ConsultaInformacionClienteResponse consultaInformacionCliente = new ConsultaInformacionClienteResponse();
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
		
		if(objectResult != null) {
			try {
				if (objectResult.getJSONObject("datos").getJSONObject("registro") != null) {
					consultaInformacionCliente = gsonBuilder.create().fromJson(objectResult.getJSONObject("datos").getJSONObject("registro").toString(), ConsultaInformacionClienteResponse.class);
				}
			} catch (Exception e) {
				consultaInformacionCliente = gsonBuilder.create().fromJson(objectResult.toString(), ConsultaInformacionClienteResponse.class);
			}
		}else {
			throw new AdminManagerException("No hay conexion con el servicio");
		}
		
		return consultaInformacionCliente;
	}

	public ConsultaSuscripcionTokenResponse consultarSuscripcionToken(
			ConsultaSuscripcionTokenRequest request) throws AdminManagerException {
		Actions jeis = actionsRepository.findById(ResourceConstants.CONSULTA_SUSCRIPCION_TOKEN);
		String inputXML = jeis.getPayload();
		inputXML =  inputXML.replace("{pvIdRequest}", jeis.getIdRequest());
		inputXML =  inputXML.replace("{pvToken}", request.getToken());
		JSONObject objectResult = invokeService.invokeRest(inputXML, jeis.getEndpoint()+jeis.getOperation());
		ConsultaSuscripcionTokenResponse consultaSuscripcionToken = new ConsultaSuscripcionTokenResponse();
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
		
		if(objectResult != null) {
			try {
				if (objectResult.getJSONObject("datos").getJSONObject("registro") != null) {
					consultaSuscripcionToken = gsonBuilder.create().fromJson(objectResult.getJSONObject("datos").getJSONObject("registro").toString(), ConsultaSuscripcionTokenResponse.class);
				}
			} catch (Exception e) {
				consultaSuscripcionToken = gsonBuilder.create().fromJson(objectResult.toString(), ConsultaSuscripcionTokenResponse.class);
			}
		}else {
			throw new AdminManagerException("No hay conexion con el servicio");
		}
		
		return consultaSuscripcionToken;
	}

	public ConsultaSucursalMacResponse consultarSucursalMac(ConsultaSucursalMacRequest request) throws AdminManagerException {
		Actions jeis = actionsRepository.findById(ResourceConstants.CONSULTA_SUCURSAL_MAC);
		String inputXML = jeis.getPayload();
		inputXML =  inputXML.replace("{pvIdRequest}", jeis.getIdRequest());
		inputXML =  inputXML.replace("{pvMacAddress}", request.getMacAddress());
		JSONObject objectResult = invokeService.invokeRest(inputXML, jeis.getEndpoint()+jeis.getOperation());
		ConsultaSucursalMacResponse consultaSucursalMac = new ConsultaSucursalMacResponse();
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
		
		if(objectResult != null) {
			try {
				if (objectResult.getJSONObject("datos").getJSONObject("registro") != null) {
					consultaSucursalMac = gsonBuilder.create().fromJson(objectResult.getJSONObject("datos").getJSONObject("registro").toString(), ConsultaSucursalMacResponse.class);
				}
			} catch (Exception e) {
				consultaSucursalMac = gsonBuilder.create().fromJson(objectResult.toString(), ConsultaSucursalMacResponse.class);
			}
		}else {
			throw new AdminManagerException("No hay conexion con el servicio");
		}
		
		return consultaSucursalMac;
	}
 
	public ConsultaFormaPagoSucursalResponse consultarFormaPagoSucursal(
			ConsultaFormaPagoSucursalRequest request) throws AdminManagerException {
		Actions jeis = actionsRepository.findById(ResourceConstants.CONSULTA_FORMAPAGO_SUCURSAL);
		String inputXML = jeis.getPayload();
		inputXML =  inputXML.replace("{pvIdRequest}", jeis.getIdRequest());
		inputXML =  inputXML.replace("{pvaddressId}", request.getAddressId());
		JSONObject objectResult = invokeService.invokeRest(inputXML, jeis.getEndpoint()+jeis.getOperation());

		ConsultaFormaPagoSucursalResponse consultaFormaPagoSucursal = new ConsultaFormaPagoSucursalResponse();
		List<FormaPagoSucursal> FormaPagoSucursal = new ArrayList<>();
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
		
		if(objectResult != null) {
			try {
				if (objectResult.get("messagecode") != null) {
					FormaPagoSucursal.add(gsonBuilder.create().fromJson(objectResult.toString(), FormaPagoSucursal.class));
				}
			} catch (Exception e) {
				Object jsonArray = objectResult.getJSONObject("datos").get("registro");
				if (jsonArray instanceof JSONArray) {
					FormaPagoSucursal =  gsonBuilder.create().fromJson(jsonArray.toString(), new TypeToken<List<FormaPagoSucursal>>(){}.getType());
				}else {
					FormaPagoSucursal.add(gsonBuilder.create().fromJson(jsonArray.toString(), FormaPagoSucursal.class));
				}
			}
			consultaFormaPagoSucursal.setFormaPagoSucursal(FormaPagoSucursal);;
		}else {
			throw new AdminManagerException("No hay conexion con el servicio");
		}
		return consultaFormaPagoSucursal;
	}

	public ConsultaFormaPagoClienteResponse consultarFormaPagoCliente(
			ConsultaFormaPagoClienteRequest request) throws AdminManagerException {
		Actions jeis = actionsRepository.findById(ResourceConstants.CONSULTA_FORMAPAGO_CLIENTE);
		String inputXML = jeis.getPayload();
		inputXML =  inputXML.replace("{pvIdRequest}", jeis.getIdRequest());
		inputXML =  inputXML.replace("{pvcustomerId}", request.getCustomerId());
		inputXML =  inputXML.replace("{pvonlyServicesFlag}", request.getOnlyServicesFlag());
		JSONObject objectResult = invokeService.invokeRest(inputXML, jeis.getEndpoint()+jeis.getOperation());
		
		ConsultaFormaPagoClienteResponse consultaFormaPagoCliente = new ConsultaFormaPagoClienteResponse();
		List<FormaPagoCliente> FormaPagoCliente = new ArrayList<>();
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
		
		if(objectResult != null) {
			try {
				if (objectResult.get("messagecode") != null) {
					FormaPagoCliente.add(gsonBuilder.create().fromJson(objectResult.toString(), FormaPagoCliente.class));
				}
			} catch (Exception e) {
				Object jsonArray = objectResult.getJSONObject("datos").get("registro");
				if (jsonArray instanceof JSONArray) {
					FormaPagoCliente =  gsonBuilder.create().fromJson(jsonArray.toString(), new TypeToken<List<FormaPagoCliente>>(){}.getType());
				}else {
					FormaPagoCliente.add(gsonBuilder.create().fromJson(jsonArray.toString(), FormaPagoCliente.class));
				}
			}
			consultaFormaPagoCliente.setFormaPagoCliente(FormaPagoCliente);;
		}else {
			throw new AdminManagerException("No hay conexion con el servicio");
		}
		return consultaFormaPagoCliente;
	}
	

	public ConsultaSuscripcionClienteResponse consultarSuscripcionCliente(ConsultaSuscripcionClienteRequest request) throws AdminManagerException {
		Actions jeis = actionsRepository.findById(ResourceConstants.CONSULTA_SUSCRIPCION_CLIENTE);
		String inputXML = jeis.getPayload();
		inputXML =  inputXML.replace("{pvIdRequest}", jeis.getIdRequest());
		inputXML =  inputXML.replace("{pvcustomerId}", request.getCustomerId());
		JSONObject objectResult = invokeService.invokeRest(inputXML, jeis.getEndpoint()+jeis.getOperation());
		ConsultaSuscripcionClienteResponse consultaSuscripcionCliente = new ConsultaSuscripcionClienteResponse();
		List<SuscripcionCliente> SuscripcionCliente = new ArrayList<>();
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
		
		if(objectResult != null) {
			try {
				if (objectResult.get("messagecode") != null) {
					SuscripcionCliente.add(gsonBuilder.create().fromJson(objectResult.toString(), SuscripcionCliente.class));
				}
			} catch (Exception e) {
				Object jsonArray = objectResult.getJSONObject("datos").get("registro");
				if (jsonArray instanceof JSONArray) {
					SuscripcionCliente =  gsonBuilder.create().fromJson(jsonArray.toString(), new TypeToken<List<SuscripcionCliente>>(){}.getType());
				}else {
					SuscripcionCliente.add(gsonBuilder.create().fromJson(jsonArray.toString(), SuscripcionCliente.class));
				}
			}
			consultaSuscripcionCliente.setSuscripcionCliente(SuscripcionCliente);
		}else {
			throw new AdminManagerException("No hay conexion con el servicio");
		}
		return consultaSuscripcionCliente;
	}
}
