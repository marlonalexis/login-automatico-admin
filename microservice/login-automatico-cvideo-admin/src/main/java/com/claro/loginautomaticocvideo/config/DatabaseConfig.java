package com.claro.loginautomaticocvideo.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.claro.loginautomaticocvideo.domain.Actions;
import com.claro.loginautomaticocvideo.util.ResourceConstants;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

	@Autowired
	private MongoOperations mongoOperation;
	
    @Value("${microGateway.endpoint}")
    private String microGatewayEndpoint;
    @Value("${microGateway.operation}")
    private String microGatewayOperation;

    
    /* JEIS */
    
    @Value("${jeis.consultaIp.idRequest}")
    private String consultaIp_idRequest;
    @Value("${jeis.consultaIp.payload}")
    private String consultaIpPayload;
    
    @Value("${jeis.consultaSuscripcionCliente.idRequest}")
    private String consultaSuscripcionCliente_idRequest;
    @Value("${jeis.consultaSuscripcionCliente.payload}")
    private String consultaSuscripcionClientePayload;
    
    @Value("${jeis.consultaInformacionCliente.idRequest}")
    private String consultaInformacionCliente_idRequest;
    @Value("${jeis.consultaInformacionCliente.payload}")
    private String consultaInformacionClientePayload;
    
    @Value("${jeis.consultaSuscripcionToken.idRequest}")
    private String consultaSuscripcionToken_idRequest;
    @Value("${jeis.consultaSuscripcionToken.payload}")
    private String consultaSuscripcionTokenPayload;
	
    @Value("${jeis.consultaSucursalMAC.idRequest}")
    private String consultaSucursalMAC_idRequest;
    @Value("${jeis.consultaSucursalMAC.payload}")
    private String consultaSucursalMACPayload;
    
    @Value("${jeis.consultaFormaPagoSucursal.idRequest}")
    private String consultaFormaPagoSucursal_idRequest;
    @Value("${jeis.consultaFormaPagoSucursal.payload}")
    private String consultaFormaPagoSucursalPayload;
    
    @Value("${jeis.consultaFormaPagoCliente.idRequest}")
    private String consultaFormaPagoCliente_idRequest;
    @Value("${jeis.consultaFormaPagoCliente.payload}")
    private String consultaFormaPagoClientePayload;
    
    /* SRE */
    @Value("${sre.generarToken.idRequest}")
    private String generarToken_idRequest;
    @Value("${sre.generarToken.payload}")
    private String generarTokenPayload;
    
    @Value("${sre.actualizaFormaPago.idRequest}")
    private String actualizaFormaPago_idRequest;
    @Value("${sre.actualizaFormaPago.payload}")
    private String actualizaFormaPagoPayload;
    
    @Value("${sre.actualizaServicioFormaPagoToken.idRequest}")
    private String actualizaServicioFormaPagoToken_idRequest;
    @Value("${sre.actualizaServicioFormaPagoToken.payload}")
    private String actualizaServicioFormaPagoTokenPayload;
    
    @Value("${sre.activaServicioClaroVideo.idRequest}")
    private String activaServicioClaroVideo_idRequest;
    @Value("${sre.activaServicioClaroVideo.payload}")
    private String activaServicioClaroVideoPayload;
    
    /****** MONGODB ******/
	@Bean
	InitializingBean sendDatabase() {
	    return () -> {
	    	try {
				//JEIS
				Query JEISTemplate1 = new Query(Criteria.where("_id").is(ResourceConstants.CONSULTA_IP));
				Actions jeis1 = mongoOperation.findOne(JEISTemplate1, Actions.class);
				if (jeis1 == null) {
					System.out.println("Se creara JEIS para "+ResourceConstants.CONSULTA_IP);
					Actions temp = new Actions();
					temp.setId(ResourceConstants.CONSULTA_IP);
					temp.setEndpoint(microGatewayEndpoint);
					temp.setOperation(microGatewayOperation);
					temp.setIdRequest(consultaIp_idRequest);
					temp.setPayload(consultaIpPayload);

		    		mongoOperation.save(temp);
				}
				Query JEISTemplate2 = new Query(Criteria.where("_id").is(ResourceConstants.CONSULTA_SUSCRIPCION_CLIENTE));
				Actions jeis2 = mongoOperation.findOne(JEISTemplate2, Actions.class);
				if (jeis2 == null) {
					System.out.println("Se creara JEIS para "+ResourceConstants.CONSULTA_SUSCRIPCION_CLIENTE);
					Actions temp = new Actions();
					temp.setId(ResourceConstants.CONSULTA_SUSCRIPCION_CLIENTE);
					temp.setEndpoint(microGatewayEndpoint);
					temp.setOperation(microGatewayOperation);
					temp.setIdRequest(consultaSuscripcionCliente_idRequest);
					temp.setPayload(consultaSuscripcionClientePayload);

		    		mongoOperation.save(temp);
				}
				Query JEISTemplate3 = new Query(Criteria.where("_id").is(ResourceConstants.CONSULTA_INFORMACION_CLIENTE));
				Actions jeis3 = mongoOperation.findOne(JEISTemplate3, Actions.class);
				if (jeis3 == null) {
					System.out.println("Se creara JEIS para "+ResourceConstants.CONSULTA_INFORMACION_CLIENTE);
					Actions temp = new Actions();
					temp.setId(ResourceConstants.CONSULTA_INFORMACION_CLIENTE);
					temp.setEndpoint(microGatewayEndpoint);
					temp.setOperation(microGatewayOperation);
					temp.setIdRequest(consultaInformacionCliente_idRequest);
					temp.setPayload(consultaInformacionClientePayload);

		    		mongoOperation.save(temp);
				}
				Query JEISTemplate4 = new Query(Criteria.where("_id").is(ResourceConstants.CONSULTA_SUSCRIPCION_TOKEN));
				Actions jeis4 = mongoOperation.findOne(JEISTemplate4, Actions.class);
				if (jeis4 == null) {
					System.out.println("Se creara JEIS para "+ResourceConstants.CONSULTA_SUSCRIPCION_TOKEN);
					Actions temp = new Actions();
					temp.setId(ResourceConstants.CONSULTA_SUSCRIPCION_TOKEN);
					temp.setEndpoint(microGatewayEndpoint);
					temp.setOperation(microGatewayOperation);
					temp.setIdRequest(consultaSuscripcionToken_idRequest);
					temp.setPayload(consultaSuscripcionTokenPayload);

		    		mongoOperation.save(temp);
				}
				Query JEISTemplate5 = new Query(Criteria.where("_id").is(ResourceConstants.CONSULTA_SUCURSAL_MAC));
				Actions jeis5 = mongoOperation.findOne(JEISTemplate5, Actions.class);
				if (jeis5 == null) {
					System.out.println("Se creara JEIS para "+ResourceConstants.CONSULTA_SUCURSAL_MAC);
					Actions temp = new Actions();
					temp.setId(ResourceConstants.CONSULTA_SUCURSAL_MAC);
					temp.setEndpoint(microGatewayEndpoint);
					temp.setOperation(microGatewayOperation);
					temp.setIdRequest(consultaSucursalMAC_idRequest);
					temp.setPayload(consultaSucursalMACPayload);

		    		mongoOperation.save(temp);
				}
				Query JEISTemplate6 = new Query(Criteria.where("_id").is(ResourceConstants.CONSULTA_FORMAPAGO_SUCURSAL));
				Actions jeis6 = mongoOperation.findOne(JEISTemplate6, Actions.class);
				if (jeis6 == null) {
					System.out.println("Se creara JEIS para "+ResourceConstants.CONSULTA_FORMAPAGO_SUCURSAL);
					Actions temp = new Actions();
					temp.setId(ResourceConstants.CONSULTA_FORMAPAGO_SUCURSAL);
					temp.setEndpoint(microGatewayEndpoint);
					temp.setOperation(microGatewayOperation);
					temp.setIdRequest(consultaFormaPagoSucursal_idRequest);
					temp.setPayload(consultaFormaPagoSucursalPayload);

		    		mongoOperation.save(temp);
				}
				Query JEISTemplate7 = new Query(Criteria.where("_id").is(ResourceConstants.CONSULTA_FORMAPAGO_CLIENTE));
				Actions jeis7 = mongoOperation.findOne(JEISTemplate7, Actions.class);
				if (jeis7 == null) {
					System.out.println("Se creara JEIS para "+ResourceConstants.CONSULTA_FORMAPAGO_CLIENTE);
					Actions temp = new Actions();
					temp.setId(ResourceConstants.CONSULTA_FORMAPAGO_CLIENTE);
					temp.setEndpoint(microGatewayEndpoint);
					temp.setOperation(microGatewayOperation);
					temp.setIdRequest(consultaFormaPagoCliente_idRequest);
					temp.setPayload(consultaFormaPagoClientePayload);

		    		mongoOperation.save(temp);
				}
				
				/* SRE */
				Query SRETemplate1 = new Query(Criteria.where("_id").is(ResourceConstants.GENERAR_TOKEN));
				Actions sre1 = mongoOperation.findOne(SRETemplate1, Actions.class);
				if (sre1 == null) {
					System.out.println("Se creara SRE para "+ResourceConstants.GENERAR_TOKEN);
					Actions temp = new Actions();
					temp.setId(ResourceConstants.GENERAR_TOKEN);
					temp.setEndpoint(microGatewayEndpoint);
					temp.setOperation(microGatewayOperation);
					temp.setIdRequest(generarToken_idRequest);
					temp.setPayload(generarTokenPayload);

		    		mongoOperation.save(temp);
				}
				Query SRETemplate2 = new Query(Criteria.where("_id").is(ResourceConstants.ACTUALIZAR_FORMA_PAGO));
				Actions sre2 = mongoOperation.findOne(SRETemplate2, Actions.class);
				if (sre2 == null) {
					System.out.println("Se creara SRE para "+ResourceConstants.ACTUALIZAR_FORMA_PAGO);
					Actions temp = new Actions();
					temp.setId(ResourceConstants.ACTUALIZAR_FORMA_PAGO);
					temp.setEndpoint(microGatewayEndpoint);
					temp.setOperation(microGatewayOperation);
					temp.setIdRequest(actualizaFormaPago_idRequest);
					temp.setPayload(actualizaFormaPagoPayload);

		    		mongoOperation.save(temp);
				}
				Query SRETemplate3 = new Query(Criteria.where("_id").is(ResourceConstants.ACTUALIZAR_SERVICIO_FORMA_PAGO));
				Actions sre3 = mongoOperation.findOne(SRETemplate3, Actions.class);
				if (sre3 == null) {
					System.out.println("Se creara SRE para "+ResourceConstants.ACTUALIZAR_SERVICIO_FORMA_PAGO);
					Actions temp = new Actions();
					temp.setId(ResourceConstants.ACTUALIZAR_SERVICIO_FORMA_PAGO);
					temp.setEndpoint(microGatewayEndpoint);
					temp.setOperation(microGatewayOperation);
					temp.setIdRequest(actualizaServicioFormaPagoToken_idRequest);
					temp.setPayload(actualizaServicioFormaPagoTokenPayload);

		    		mongoOperation.save(temp);
				}
				Query SRETemplate4 = new Query(Criteria.where("_id").is(ResourceConstants.ACTIVA_SERVICIO_CLARO));
				Actions sre4 = mongoOperation.findOne(SRETemplate4, Actions.class);
				if (sre4 == null) {
					System.out.println("Se creara SRE para "+ResourceConstants.ACTIVA_SERVICIO_CLARO);
					Actions temp = new Actions();
					temp.setId(ResourceConstants.ACTIVA_SERVICIO_CLARO);
					temp.setEndpoint(microGatewayEndpoint);
					temp.setOperation(microGatewayOperation);
					temp.setIdRequest(activaServicioClaroVideo_idRequest);
					temp.setPayload(activaServicioClaroVideoPayload);

		    		mongoOperation.save(temp);
				}
	    	} catch (ClassCastException e) {
	    		System.out.println("No se pudo cargar secuencia en Mongo...");
	    	}
	    };
	}
}
