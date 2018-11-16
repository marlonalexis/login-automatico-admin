package com.claro.loginautomaticocvideo.web.rest;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.claro.loginautomaticocvideo.bean.ActivarServicioClaroVideoRequest;
import com.claro.loginautomaticocvideo.bean.ActivarServicioClaroVideoResponse;
import com.claro.loginautomaticocvideo.bean.ActualizarFormaPagoRequest;
import com.claro.loginautomaticocvideo.bean.ActualizarFormaPagoResponse;
import com.claro.loginautomaticocvideo.bean.ActualizarServicioFormaPagoTokenRequest;
import com.claro.loginautomaticocvideo.bean.ActualizarServicioFormaPagoTokenResponse;
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
import com.claro.loginautomaticocvideo.bean.GenerarTokenRequest;
import com.claro.loginautomaticocvideo.bean.GenerarTokenResponse;
import com.claro.loginautomaticocvideo.bean.GenericRequest;
import com.claro.loginautomaticocvideo.bean.GenericResponse;
import com.claro.loginautomaticocvideo.exception.AdminManagerException;
import com.claro.loginautomaticocvideo.service.JeisService;
import com.claro.loginautomaticocvideo.service.SreService;
import com.claro.loginautomaticocvideo.util.AdminManagerValidators;
import com.claro.loginautomaticocvideo.util.LogPanelCalidad;
import com.claro.loginautomaticocvideo.util.ResourceConstants;

@Controller
@RestController
@RequestMapping("/AdminManager")
public class AdminController {

	@Autowired
	AdminManagerValidators adminManagerValidators;
	
	@Autowired
	JeisService jeisService;
	
	@Autowired
	SreService sreService;
	
	@Autowired
	LogPanelCalidad logPanelCalidad;
	
	String nombreClase = "AdminController";
	
	private static final Logger log = LogManager.getLogger(AdminController.class);
	
    @RequestMapping(path = "/consultaIP", method = RequestMethod.POST, consumes = {
            MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"})
    public GenericResponse<ConsultaIPResponse> consultaIP(@RequestBody ConsultaIPRequest request) {
    	String threadID=UUID.randomUUID().toString();
		ThreadContext.put("sid", threadID);
		logPanelCalidad.logMensaje("consultaIP: Petición Recibida", nombreClase);
		long startTime = System.nanoTime();
    	GenericResponse<ConsultaIPResponse> response = new GenericResponse<>();
    	try {
    		adminManagerValidators.validateConsultarIP(request);
    		ConsultaIPResponse consultaIp = jeisService.consultarIP(request);
    		
    		response.setCode(ResourceConstants.SUCCESS_CODE);
	    	response.setStatus("OK");
    		response.setMessage("Successful transaction");
			response.setResponse(consultaIp);
			//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logInfo(startTime, endTime, "consultaIP", "Successful transaction",nombreClase);
    	} catch(AdminManagerException e) {
    		response.setCode(e.getErrorCode());
    		response.setStatus("ERROR");
    		response.setMessage(e.getMessage());
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logError(startTime, endTime, "consultaIP", e.getMessage(),nombreClase);
    	} catch(Exception e) {
    		response.setCode(ResourceConstants.UNKNOWN_ERROR);
    		response.setStatus("ERROR");
    		response.setMessage(e.getMessage());
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logError(startTime, endTime, "consultaIP", e.getMessage(),nombreClase);
    	}
    	return response;
    }
    
    @RequestMapping(path = "/consultaSuscripcionCliente", method = RequestMethod.POST, consumes = {
            MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"})
    public GenericResponse<ConsultaSuscripcionClienteResponse> consultaSuscripcionCliente(@RequestBody ConsultaSuscripcionClienteRequest request) {
    	String threadID=UUID.randomUUID().toString();
		ThreadContext.put("sid", threadID);
		logPanelCalidad.logMensaje("consultaSuscripcionCliente: Petición Recibida", nombreClase);
		long startTime = System.nanoTime();
    	GenericResponse<ConsultaSuscripcionClienteResponse> response = new GenericResponse<>();
    	try {
    		adminManagerValidators.validateConsultarSuscripcionCliente(request);
    		ConsultaSuscripcionClienteResponse consultaSuscripcionCliente = jeisService.consultarSuscripcionCliente(request);
    		
    		response.setCode(ResourceConstants.SUCCESS_CODE);
	    	response.setStatus("OK");
    		response.setMessage("Successful transaction");
			response.setResponse(consultaSuscripcionCliente);
			//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logInfo(startTime, endTime, "consultaSuscripcionCliente", "Successful transaction",nombreClase);
    	} catch(AdminManagerException e) {
    		response.setCode(e.getErrorCode());
    		response.setStatus("ERROR");
    		response.setMessage(e.getMessage());
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logError(startTime, endTime, "consultaSuscripcionCliente", e.getMessage(),nombreClase);
    	} catch(Exception e) {
    		response.setCode(ResourceConstants.UNKNOWN_ERROR);
    		response.setStatus("ERROR");
    		response.setMessage(e.getMessage());
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logError(startTime, endTime, "consultaSuscripcionCliente", e.getMessage(),nombreClase);
    	}
    	return response;
    }
    
    @RequestMapping(path = "/consultaInformacionCliente", method = RequestMethod.POST, consumes = {
            MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"})
    public GenericResponse<ConsultaInformacionClienteResponse> consultaInformacionCliente(@RequestBody ConsultaInformacionClienteRequest request) {
    	String threadID=UUID.randomUUID().toString();
		ThreadContext.put("sid", threadID);
		logPanelCalidad.logMensaje("consultaInformacionCliente: Petición Recibida", nombreClase);
		long startTime = System.nanoTime();
    	GenericResponse<ConsultaInformacionClienteResponse> response = new GenericResponse<>();
    	try {
    		adminManagerValidators.validateConsultarInformacionCliente(request);
    		ConsultaInformacionClienteResponse consultaInformacionCliente = jeisService.consultarInformacionCliente(request);
    		
    		response.setCode(ResourceConstants.SUCCESS_CODE);
	    	response.setStatus("OK");
    		response.setMessage("Successful transaction");
			response.setResponse(consultaInformacionCliente);
			//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logInfo(startTime, endTime, "consultaInformacionCliente", "Successful transaction",nombreClase);
    	} catch(AdminManagerException e) {
    		response.setCode(e.getErrorCode());
    		response.setStatus("ERROR");
    		response.setMessage(e.getMessage());
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logError(startTime, endTime, "consultaInformacionCliente", e.getMessage(),nombreClase);
    	} catch(Exception e) {
    		response.setCode(ResourceConstants.UNKNOWN_ERROR);
    		response.setStatus("ERROR");
    		response.setMessage(e.getMessage());
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logError(startTime, endTime, "consultaInformacionCliente", e.getMessage(),nombreClase);
    	}
    	return response;
    }
    
    @RequestMapping(path = "/consultaSuscripcionToken", method = RequestMethod.POST, consumes = {
            MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"})
    public GenericResponse<ConsultaSuscripcionTokenResponse> consultaSuscripcionToken(@RequestBody ConsultaSuscripcionTokenRequest request) {
    	String threadID=UUID.randomUUID().toString();
		ThreadContext.put("sid", threadID);
		logPanelCalidad.logMensaje("consultaSuscripcionToken: Petición Recibida", nombreClase);
		long startTime = System.nanoTime();
    	GenericResponse<ConsultaSuscripcionTokenResponse> response = new GenericResponse<>();
    	try {
    		adminManagerValidators.validateConsultarSuscripcionToken(request);
    		ConsultaSuscripcionTokenResponse consultaSuscripcionToken = jeisService.consultarSuscripcionToken(request);
    		
    		response.setCode(ResourceConstants.SUCCESS_CODE);
	    	response.setStatus("OK");
    		response.setMessage("Successful transaction");
			response.setResponse(consultaSuscripcionToken);
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logInfo(startTime, endTime, "consultaSuscripcionToken", "Successful transaction",nombreClase);
    	} catch(AdminManagerException e) {
    		response.setCode(e.getErrorCode());
    		response.setStatus("ERROR");
    		response.setMessage(e.getMessage());
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logError(startTime, endTime, "consultaSuscripcionToken", e.getMessage(),nombreClase);
    	} catch(Exception e) {
    		response.setCode(ResourceConstants.UNKNOWN_ERROR);
    		response.setStatus("ERROR");
    		response.setMessage(e.getMessage());
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logError(startTime, endTime, "consultaSuscripcionToken", e.getMessage(),nombreClase);
    	}
    	return response;
    }
    
    @RequestMapping(path = "/consultaSucursalMac", method = RequestMethod.POST, consumes = {
            MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"})
    public GenericResponse<ConsultaSucursalMacResponse> consultaSucursalMac(@RequestBody ConsultaSucursalMacRequest request) {
    	String threadID=UUID.randomUUID().toString();
		ThreadContext.put("sid", threadID);
		logPanelCalidad.logMensaje("consultaSucursalMac: Petición Recibida", nombreClase);
		long startTime = System.nanoTime();
    	GenericResponse<ConsultaSucursalMacResponse> response = new GenericResponse<>();
    	try {
    		adminManagerValidators.validateConsultarSucursalMac(request);
    		ConsultaSucursalMacResponse consultaSucursalMac = jeisService.consultarSucursalMac(request);
    		
    		response.setCode(ResourceConstants.SUCCESS_CODE);
	    	response.setStatus("OK");
    		response.setMessage("Successful transaction");
			response.setResponse(consultaSucursalMac);
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logInfo(startTime, endTime, "consultaSucursalMac", "Successful transaction",nombreClase);
    	} catch(AdminManagerException e) {
    		response.setCode(e.getErrorCode());
    		response.setStatus("ERROR");
    		response.setMessage(e.getMessage());
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logError(startTime, endTime, "consultaSucursalMac", e.getMessage(),nombreClase);
    	} catch(Exception e) {
    		response.setCode(ResourceConstants.UNKNOWN_ERROR);
    		response.setStatus("ERROR");
    		response.setMessage(e.getMessage());
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logError(startTime, endTime, "consultaSucursalMac", e.getMessage(),nombreClase);
    	}
    	return response;
    }
    
    @RequestMapping(path = "/consultaFormaPagoSucursal", method = RequestMethod.POST, consumes = {
            MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"})
    public GenericResponse<ConsultaFormaPagoSucursalResponse> consultaFormaPagoSucursal(@RequestBody ConsultaFormaPagoSucursalRequest request) {
    	String threadID=UUID.randomUUID().toString();
		ThreadContext.put("sid", threadID);
		logPanelCalidad.logMensaje("consultaFormaPagoSucursal: Petición Recibida", nombreClase);
		long startTime = System.nanoTime();
    	GenericResponse<ConsultaFormaPagoSucursalResponse> response = new GenericResponse<>();
    	try {
    		adminManagerValidators.validateConsultarFormaPagoSucursal(request);
    		ConsultaFormaPagoSucursalResponse consultaFormaPagoSucursal = jeisService.consultarFormaPagoSucursal(request);
    		
    		response.setCode(ResourceConstants.SUCCESS_CODE);
	    	response.setStatus("OK");
    		response.setMessage("Successful transaction");
			response.setResponse(consultaFormaPagoSucursal);
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logInfo(startTime, endTime, "consultaFormaPagoSucursal", "Successful transaction",nombreClase);
    	} catch(AdminManagerException e) {
    		response.setCode(e.getErrorCode());
    		response.setStatus("ERROR");
    		response.setMessage(e.getMessage());
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logError(startTime, endTime, "consultaFormaPagoSucursal", e.getMessage(),nombreClase);
    	} catch(Exception e) {
    		response.setCode(ResourceConstants.UNKNOWN_ERROR);
    		response.setStatus("ERROR");
    		response.setMessage(e.getMessage());
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logError(startTime, endTime, "consultaFormaPagoSucursal", e.getMessage(),nombreClase);
    	}
    	return response;
    }
    
    @RequestMapping(path = "/consultaFormaPagoCliente", method = RequestMethod.POST, consumes = {
            MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"})
    public GenericResponse<ConsultaFormaPagoClienteResponse> consultaFormaPagoCliente(@RequestBody ConsultaFormaPagoClienteRequest request) {
    	String threadID=UUID.randomUUID().toString();
		ThreadContext.put("sid", threadID);
		logPanelCalidad.logMensaje("consultaFormaPagoCliente: Petición Recibida", nombreClase);
		long startTime = System.nanoTime();
    	GenericResponse<ConsultaFormaPagoClienteResponse> response = new GenericResponse<>();
    	try {
    		adminManagerValidators.validateConsultarFormaPagoCliente(request);
    		ConsultaFormaPagoClienteResponse consultaFormaPagoCliente = jeisService.consultarFormaPagoCliente(request);
    		
    		response.setCode(ResourceConstants.SUCCESS_CODE);
	    	response.setStatus("OK");
    		response.setMessage("Successful transaction");
			response.setResponse(consultaFormaPagoCliente);
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logInfo(startTime, endTime, "consultaFormaPagoCliente", "Successful transaction",nombreClase);
    	} catch(AdminManagerException e) {
    		response.setCode(e.getErrorCode());
    		response.setStatus("ERROR");
    		response.setMessage(e.getMessage());
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logError(startTime, endTime, "consultaFormaPagoCliente", e.getMessage(),nombreClase);
    	} catch(Exception e) {
    		response.setCode(ResourceConstants.UNKNOWN_ERROR);
    		response.setStatus("ERROR");
    		response.setMessage(e.getMessage());
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logError(startTime, endTime, "consultaFormaPagoCliente", e.getMessage(),nombreClase);
    	}
    	return response;
    }
    
    @RequestMapping(path = "/generarToken", method = RequestMethod.POST, consumes = {
            MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"})
    public GenericResponse<GenerarTokenResponse> generarToken(@RequestBody GenerarTokenRequest request) {
    	String threadID=UUID.randomUUID().toString();
		ThreadContext.put("sid", threadID);
		logPanelCalidad.logMensaje("generarToken: Petición Recibida", nombreClase);
		long startTime = System.nanoTime();
    	GenericResponse<GenerarTokenResponse> response = new GenericResponse<>();
    	try {
    		adminManagerValidators.validateGenerarToken(request);
    		GenerarTokenResponse generarToken = sreService.generarToken(request);
    		
    		response.setCode(ResourceConstants.SUCCESS_CODE);
	    	response.setStatus("OK");
    		response.setMessage("Successful transaction");
			response.setResponse(generarToken);
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logInfo(startTime, endTime, "generarToken", "Successful transaction",nombreClase);
    	} catch(AdminManagerException e) {
    		response.setCode(e.getErrorCode());
    		response.setStatus("ERROR");
    		response.setMessage(e.getMessage());
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logError(startTime, endTime, "generarToken", e.getMessage(),nombreClase);
    	} catch(Exception e) {
    		response.setCode(ResourceConstants.UNKNOWN_ERROR);
    		response.setStatus("ERROR");
    		response.setMessage(e.getMessage());
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logError(startTime, endTime, "generarToken", e.getMessage(),nombreClase);
    	}
    	return response;
    }
    
    @RequestMapping(path = "/actualizarFormaPago", method = RequestMethod.POST, consumes = {
            MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"})
    public GenericResponse<ActualizarFormaPagoResponse> actualizarFormaPago(@RequestBody ActualizarFormaPagoRequest request) {
    	String threadID=UUID.randomUUID().toString();
		ThreadContext.put("sid", threadID);
		logPanelCalidad.logMensaje("actualizarFormaPago: Petición Recibida", nombreClase);
		long startTime = System.nanoTime();
    	GenericResponse<ActualizarFormaPagoResponse> response = new GenericResponse<>();
    	try {
    		adminManagerValidators.validateActualizaFormaPago(request);
    		ActualizarFormaPagoResponse actualizarFormaPago = sreService.actualizarFormaPago(request);
    		
    		response.setCode(ResourceConstants.SUCCESS_CODE);
	    	response.setStatus("OK");
    		response.setMessage("Successful transaction");
			response.setResponse(actualizarFormaPago);
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logInfo(startTime, endTime, "actualizarFormaPago", "Successful transaction",nombreClase);
    	} catch(AdminManagerException e) {
    		response.setCode(e.getErrorCode());
    		response.setStatus("ERROR");
    		response.setMessage(e.getMessage());
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logError(startTime, endTime, "actualizarFormaPago", e.getMessage(),nombreClase);
    	} catch(Exception e) {
    		response.setCode(ResourceConstants.UNKNOWN_ERROR);
    		response.setStatus("ERROR");
    		response.setMessage(e.getMessage());
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logError(startTime, endTime, "actualizarFormaPago", e.getMessage(),nombreClase);
    	}
    	return response;
    }
    
    @RequestMapping(path = "/actualizarServicioFormaPagoToken", method = RequestMethod.POST, consumes = {
            MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"})
    public GenericResponse<ActualizarServicioFormaPagoTokenResponse> actualizarServicioFormaPagoToken(@RequestBody ActualizarServicioFormaPagoTokenRequest request) {
    	String threadID=UUID.randomUUID().toString();
		ThreadContext.put("sid", threadID);
		logPanelCalidad.logMensaje("actualizarServicioFormaPagoToken: Petición Recibida", nombreClase);
		long startTime = System.nanoTime();
    	GenericResponse<ActualizarServicioFormaPagoTokenResponse> response = new GenericResponse<>();
    	try {
    		adminManagerValidators.validateActualizarServicioFormaPagoToken(request);
    		ActualizarServicioFormaPagoTokenResponse actualizarServicioFormaPagoToken = sreService.actualizarServicioFormaPagoToken(request);
    		
    		response.setCode(ResourceConstants.SUCCESS_CODE);
	    	response.setStatus("OK");
    		response.setMessage("Successful transaction");
			response.setResponse(actualizarServicioFormaPagoToken);
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logInfo(startTime, endTime, "actualizarServicioFormaPagoToken", "Successful transaction",nombreClase);
    	} catch(AdminManagerException e) {
    		response.setCode(e.getErrorCode());
    		response.setStatus("ERROR");
    		response.setMessage(e.getMessage());
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logError(startTime, endTime, "actualizarServicioFormaPagoToken", e.getMessage(),nombreClase);
    	} catch(Exception e) {
    		response.setCode(ResourceConstants.UNKNOWN_ERROR);
    		response.setStatus("ERROR");
    		response.setMessage(e.getMessage());
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logError(startTime, endTime, "actualizarServicioFormaPagoToken", e.getMessage(),nombreClase);
    	}
    	return response;
    }
    
    @RequestMapping(path = "/activarServicioClaroVideo", method = RequestMethod.POST, consumes = {
            MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8"})
    public GenericResponse<ActivarServicioClaroVideoResponse> activarServicioClaroVideo(@RequestBody ActivarServicioClaroVideoRequest request) {
    	String threadID=UUID.randomUUID().toString();
		ThreadContext.put("sid", threadID);
		logPanelCalidad.logMensaje("activarServicioClaroVideo: Petición Recibida", nombreClase);
		long startTime = System.nanoTime();
    	GenericResponse<ActivarServicioClaroVideoResponse> response = new GenericResponse<>();
    	try {
    		adminManagerValidators.validateActivarServicioClaroVideo(request);
    		ActivarServicioClaroVideoResponse activarServicioClaroVideo = sreService.activarServicioClaroVideo(request);
    		
    		response.setCode(ResourceConstants.SUCCESS_CODE);
	    	response.setStatus("OK");
    		response.setMessage("Successful transaction");
			response.setResponse(activarServicioClaroVideo);
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logInfo(startTime, endTime, "activarServicioClaroVideo", "Successful transaction",nombreClase);
    	} catch(AdminManagerException e) {
    		response.setCode(e.getErrorCode());
    		response.setStatus("ERROR");
    		response.setMessage(e.getMessage());
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logError(startTime, endTime, "activarServicioClaroVideo", e.getMessage(),nombreClase);
    	} catch(Exception e) {
    		response.setCode(ResourceConstants.UNKNOWN_ERROR);
    		response.setStatus("ERROR");
    		response.setMessage(e.getMessage());
    		//Panel de calidad
			long endTime = System.nanoTime();
    		logPanelCalidad.logError(startTime, endTime, "activarServicioClaroVideo", e.getMessage(),nombreClase);
    	}
    	return response;
    }
}
