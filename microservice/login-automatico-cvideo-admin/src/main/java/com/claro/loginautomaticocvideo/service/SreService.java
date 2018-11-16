package com.claro.loginautomaticocvideo.service;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claro.loginautomaticocvideo.bean.ActivarServicioClaroVideoRequest;
import com.claro.loginautomaticocvideo.bean.ActivarServicioClaroVideoResponse;
import com.claro.loginautomaticocvideo.bean.ActualizarFormaPagoRequest;
import com.claro.loginautomaticocvideo.bean.ActualizarFormaPagoResponse;
import com.claro.loginautomaticocvideo.bean.ActualizarServicioFormaPagoTokenRequest;
import com.claro.loginautomaticocvideo.bean.ActualizarServicioFormaPagoTokenResponse;
import com.claro.loginautomaticocvideo.bean.ConsultaIPRequest;
import com.claro.loginautomaticocvideo.bean.ConsultaIPResponse;
import com.claro.loginautomaticocvideo.bean.GenerarTokenRequest;
import com.claro.loginautomaticocvideo.bean.GenerarTokenResponse;
import com.claro.loginautomaticocvideo.dao.ActionsRepository;
import com.claro.loginautomaticocvideo.domain.Actions;
import com.claro.loginautomaticocvideo.exception.AdminManagerException;
import com.claro.loginautomaticocvideo.util.DateDeserializer;
import com.claro.loginautomaticocvideo.util.ResourceConstants;
import com.google.gson.GsonBuilder;

@Service
public class SreService {
	@Autowired
	InvokeServices invokeService;
	
	@Autowired
	ActionsRepository actionsRepository;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public GenerarTokenResponse generarToken(GenerarTokenRequest request) throws AdminManagerException{
		Actions sre = actionsRepository.findById(ResourceConstants.GENERAR_TOKEN);
		String inputXML = sre.getPayload();
		inputXML =  inputXML.replace("{pvIdRequest}", sre.getIdRequest());
		inputXML =  inputXML.replace("{pvcustomerId}", request.getCustomerId());
		inputXML =  inputXML.replace("{pvclaroVideoMail}", request.getClaroVideoMail());
		inputXML =  inputXML.replace("{pvclaroWebSiteMail}", request.getClaroWebSiteMail());
		JSONObject objectResult = invokeService.invokeRest(inputXML, sre.getEndpoint()+sre.getOperation());
		GenerarTokenResponse generarToken = new GenerarTokenResponse();
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
		
		if(objectResult != null) {
			try {
				if (objectResult.getJSONObject("datos").getJSONObject("registro") != null) {
					generarToken = gsonBuilder.create().fromJson(objectResult.getJSONObject("datos").getJSONObject("registro").toString(), GenerarTokenResponse.class);
				}
			} catch (Exception e) {
				generarToken = gsonBuilder.create().fromJson(objectResult.toString(), GenerarTokenResponse.class);
			}
		}else {
			throw new AdminManagerException("No hay conexion con el servicio");
		}
		
		return generarToken;
	}

	public ActualizarFormaPagoResponse actualizarFormaPago(ActualizarFormaPagoRequest request) throws AdminManagerException {
		Actions sre = actionsRepository.findById(ResourceConstants.ACTUALIZAR_FORMA_PAGO);
		String inputXML = sre.getPayload();
		inputXML =  inputXML.replace("{pvIdRequest}", sre.getIdRequest());
		inputXML =  inputXML.replace("{pvtoken}", request.getToken());
		inputXML =  inputXML.replace("{pvpaymentMethodId}", request.getPaymentMethodId());
		inputXML =  inputXML.replace("{pvaddressId}", request.getAddressId());
		JSONObject objectResult = invokeService.invokeRest(inputXML, sre.getEndpoint()+sre.getOperation());
		ActualizarFormaPagoResponse actualizarFormaPago = new ActualizarFormaPagoResponse();
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
		
		if(objectResult != null) {
			try {
				if (objectResult.getJSONObject("datos").getJSONObject("registro") != null) {
					actualizarFormaPago = gsonBuilder.create().fromJson(objectResult.getJSONObject("datos").getJSONObject("registro").toString(), ActualizarFormaPagoResponse.class);
				}
			} catch (Exception e) {
				actualizarFormaPago = gsonBuilder.create().fromJson(objectResult.toString(), ActualizarFormaPagoResponse.class);
			}
		}else {
			throw new AdminManagerException("No hay conexion con el servicio");
		}
		
		return actualizarFormaPago;
	}

	public ActualizarServicioFormaPagoTokenResponse actualizarServicioFormaPagoToken(
			ActualizarServicioFormaPagoTokenRequest request) throws AdminManagerException {
		Actions sre = actionsRepository.findById(ResourceConstants.ACTUALIZAR_SERVICIO_FORMA_PAGO);
		String inputXML = sre.getPayload();
		inputXML =  inputXML.replace("{pvIdRequest}", sre.getIdRequest());
		inputXML =  inputXML.replace("{pvtoken}", request.getToken());
		inputXML =  inputXML.replace("{pvpaymentMethodId}", request.getPaymentMethodId());
		JSONObject objectResult = invokeService.invokeRest(inputXML, sre.getEndpoint()+sre.getOperation());
		ActualizarServicioFormaPagoTokenResponse actualizarServicioFormaPagoToken = new ActualizarServicioFormaPagoTokenResponse();
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
		
		if(objectResult != null) {
			try {
				if (objectResult.getJSONObject("datos").getJSONObject("registro") != null) {
					actualizarServicioFormaPagoToken = gsonBuilder.create().fromJson(objectResult.getJSONObject("datos").getJSONObject("registro").toString(), ActualizarServicioFormaPagoTokenResponse.class);
				}
			} catch (Exception e) {
				actualizarServicioFormaPagoToken = gsonBuilder.create().fromJson(objectResult.toString(), ActualizarServicioFormaPagoTokenResponse.class);
			}
		}else {
			throw new AdminManagerException("No hay conexion con el servicio");
		}
		
		return actualizarServicioFormaPagoToken;
	}

	public ActivarServicioClaroVideoResponse activarServicioClaroVideo(ActivarServicioClaroVideoRequest request) throws AdminManagerException {
		Actions sre = actionsRepository.findById(ResourceConstants.ACTIVA_SERVICIO_CLARO);
		String inputXML = sre.getPayload();
		inputXML =  inputXML.replace("{pvIdRequest}", sre.getIdRequest());
		inputXML =  inputXML.replace("{pvtoken}", request.getToken());
		JSONObject objectResult = invokeService.invokeRest(inputXML, sre.getEndpoint()+sre.getOperation());
		ActivarServicioClaroVideoResponse activarServicioClaroVideo = new ActivarServicioClaroVideoResponse();
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
		
		if(objectResult != null) {
			try {
				if (objectResult.getJSONObject("datos").getJSONObject("registro") != null) {
					activarServicioClaroVideo = gsonBuilder.create().fromJson(objectResult.getJSONObject("datos").getJSONObject("registro").toString(), ActivarServicioClaroVideoResponse.class);
				}
			} catch (Exception e) {
				activarServicioClaroVideo = gsonBuilder.create().fromJson(objectResult.toString(), ActivarServicioClaroVideoResponse.class);
			}
		}else {
			throw new AdminManagerException("No hay conexion con el servicio");
		}
		
		return activarServicioClaroVideo;
	}
	
}
