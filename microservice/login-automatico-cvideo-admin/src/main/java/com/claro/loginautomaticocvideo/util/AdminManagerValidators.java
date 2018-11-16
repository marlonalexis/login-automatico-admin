package com.claro.loginautomaticocvideo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.claro.loginautomaticocvideo.bean.ActivarServicioClaroVideoRequest;
import com.claro.loginautomaticocvideo.bean.ActualizarFormaPagoRequest;
import com.claro.loginautomaticocvideo.bean.ActualizarServicioFormaPagoTokenRequest;
import com.claro.loginautomaticocvideo.bean.ConsultaFormaPagoClienteRequest;
import com.claro.loginautomaticocvideo.bean.ConsultaFormaPagoSucursalRequest;
import com.claro.loginautomaticocvideo.bean.ConsultaIPRequest;
import com.claro.loginautomaticocvideo.bean.ConsultaInformacionClienteRequest;
import com.claro.loginautomaticocvideo.bean.ConsultaSucursalMacRequest;
import com.claro.loginautomaticocvideo.bean.ConsultaSuscripcionClienteRequest;
import com.claro.loginautomaticocvideo.bean.ConsultaSuscripcionTokenRequest;
import com.claro.loginautomaticocvideo.bean.GenerarTokenRequest;
import com.claro.loginautomaticocvideo.bean.GenericRequest;
import com.claro.loginautomaticocvideo.dao.ActionsRepository;
import com.claro.loginautomaticocvideo.domain.Actions;
import com.claro.loginautomaticocvideo.exception.AdminManagerException;

@Component
public class AdminManagerValidators {
	
	@Autowired
	ActionsRepository actionsRepository;
	
	public void validateConsultarIP(ConsultaIPRequest request) throws AdminManagerException {
		if (request == null) {
            throw new AdminManagerException("Values are required", ResourceConstants.MISSING_VALUES);
        }
		if (request.getIp() == null || request.getIp().replace(" ", "").equals("")) {
            throw new AdminManagerException("ip is required", ResourceConstants.MISSING_VALUES);
        }
	}

	public void validateConsultarSuscripcionCliente(ConsultaSuscripcionClienteRequest request) throws AdminManagerException {
		if (request == null) {
            throw new AdminManagerException("Values are required", ResourceConstants.MISSING_VALUES);
        }
		if (request.getCustomerId() == null || request.getCustomerId().replace(" ", "").equals("")) {
            throw new AdminManagerException("customerId is required", ResourceConstants.MISSING_VALUES);
        }
	}

	public void validateConsultarInformacionCliente(ConsultaInformacionClienteRequest request) throws AdminManagerException {
		if (request == null) {
            throw new AdminManagerException("Values are required", ResourceConstants.MISSING_VALUES);
        }
		if (request.getCustomerId() == null || request.getCustomerId().replace(" ", "").equals("")) {
            throw new AdminManagerException("customerId is required", ResourceConstants.MISSING_VALUES);
        }
	}

	public void validateConsultarSuscripcionToken(ConsultaSuscripcionTokenRequest request) throws AdminManagerException {
		if (request == null) {
            throw new AdminManagerException("Values are required", ResourceConstants.MISSING_VALUES);
        }
		if (request.getToken() == null || request.getToken().replace(" ", "").equals("")) {
            throw new AdminManagerException("token is required", ResourceConstants.MISSING_VALUES);
        }
	}

	public void validateConsultarSucursalMac(ConsultaSucursalMacRequest request) throws AdminManagerException {
		if (request == null) {
            throw new AdminManagerException("Values are required", ResourceConstants.MISSING_VALUES);
        }
		if (request.getMacAddress() == null || request.getMacAddress().replace(" ", "").equals("")) {
            throw new AdminManagerException("macAddress is required", ResourceConstants.MISSING_VALUES);
        }
	}

	public void validateConsultarFormaPagoSucursal(ConsultaFormaPagoSucursalRequest request) throws AdminManagerException {
		if (request == null) {
            throw new AdminManagerException("Values are required", ResourceConstants.MISSING_VALUES);
        }
		if (request.getAddressId() == null || request.getAddressId().replace(" ", "").equals("")) {
            throw new AdminManagerException("addressId is required", ResourceConstants.MISSING_VALUES);
        }
	}

	public void validateConsultarFormaPagoCliente(ConsultaFormaPagoClienteRequest request) throws AdminManagerException {
		if (request == null) {
            throw new AdminManagerException("Values are required", ResourceConstants.MISSING_VALUES);
        }
		if (request.getCustomerId() == null || request.getCustomerId().replace(" ", "").equals("")) {
            throw new AdminManagerException("customerId is required", ResourceConstants.MISSING_VALUES);
        }
		if (request.getOnlyServicesFlag() == null || request.getOnlyServicesFlag().replace(" ", "").equals("")) {
            throw new AdminManagerException("onlyServicesFlag is required", ResourceConstants.MISSING_VALUES);
        }
	}

	public void validateGenerarToken(GenerarTokenRequest request) throws AdminManagerException {
		if (request == null) {
            throw new AdminManagerException("Values are required", ResourceConstants.MISSING_VALUES);
        }
		if (request.getCustomerId() == null || request.getCustomerId().replace(" ", "").equals("")) {
            throw new AdminManagerException("customerId is required", ResourceConstants.MISSING_VALUES);
        }
		if (request.getClaroVideoMail() == null || request.getClaroVideoMail().replace(" ", "").equals("")) {
            throw new AdminManagerException("claroVideoMail is required", ResourceConstants.MISSING_VALUES);
        }
	}

	public void validateActualizaFormaPago(ActualizarFormaPagoRequest request) throws AdminManagerException {
		if (request == null) {
            throw new AdminManagerException("Values are required", ResourceConstants.MISSING_VALUES);
        }
		if (request.getToken() == null || request.getToken().replace(" ", "").equals("")) {
            throw new AdminManagerException("token is required", ResourceConstants.MISSING_VALUES);
        }
		if (request.getPaymentMethodId() == null || request.getPaymentMethodId().replace(" ", "").equals("")) {
            throw new AdminManagerException("paymentMethodId is required", ResourceConstants.MISSING_VALUES);
        }
		if (request.getAddressId() == null || request.getAddressId().replace(" ", "").equals("")) {
            throw new AdminManagerException("addressId is required", ResourceConstants.MISSING_VALUES);
        }
	}

	public void validateActualizarServicioFormaPagoToken(ActualizarServicioFormaPagoTokenRequest request) throws AdminManagerException {
		if (request == null) {
            throw new AdminManagerException("Values are required", ResourceConstants.MISSING_VALUES);
        }
		if (request.getToken() == null || request.getToken().replace(" ", "").equals("")) {
            throw new AdminManagerException("token is required", ResourceConstants.MISSING_VALUES);
        }
		if (request.getPaymentMethodId() == null || request.getPaymentMethodId().replace(" ", "").equals("")) {
            throw new AdminManagerException("paymentMethodId is required", ResourceConstants.MISSING_VALUES);
        }
	}

	public void validateActivarServicioClaroVideo(ActivarServicioClaroVideoRequest request) throws AdminManagerException {
		if (request == null) {
            throw new AdminManagerException("Values are required", ResourceConstants.MISSING_VALUES);
        }
		if (request.getToken() == null || request.getToken().replace(" ", "").equals("")) {
            throw new AdminManagerException("token is required", ResourceConstants.MISSING_VALUES);
        }
	}

}
