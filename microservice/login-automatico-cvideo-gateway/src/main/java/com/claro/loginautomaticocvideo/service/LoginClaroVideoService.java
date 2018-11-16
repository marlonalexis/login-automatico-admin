package com.claro.loginautomaticocvideo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.claro.loginautomaticocvideo.bean.ActivateSubscriptionRequest;
import com.claro.loginautomaticocvideo.bean.ActivateSubscriptionResponse;
import com.claro.loginautomaticocvideo.bean.QueryCustomerRequest;
import com.claro.loginautomaticocvideo.bean.QueryCustomerResponse;
import com.claro.loginautomaticocvideo.bean.admin.ActivarServicioClaroVideoRequest;
import com.claro.loginautomaticocvideo.bean.admin.ActivarServicioClaroVideoResponse;
import com.claro.loginautomaticocvideo.bean.admin.ActualizarFormaPagoRequest;
import com.claro.loginautomaticocvideo.bean.admin.ActualizarFormaPagoResponse;
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
import com.claro.loginautomaticocvideo.exception.LoginClaroException;
import com.claro.loginautomaticocvideo.util.DateDeserializer;
import com.claro.loginautomaticocvideo.util.LogPanelCalidad;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Service
public class LoginClaroVideoService {

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${app.admin.url}")
	String apiAdminUrl;
	
	@Autowired
	LogPanelCalidad logPanelCalidad;
	
    @Value("${conf.formaPago.TarjetaCredito}")
    private String formaPago_TarjetaCredito;
    
    @Value("${conf.formaPago.DebitoCuentaBancaria}")
    private String formaPago_DebitoCuentaBancaria;
    
    @Value("${conf.formaPago.Efectivo}")
    private String formaPago_Efectivo;
    
    @Value("${consultaFormaPagoCliente.onlyServicesFlag}")
    private String onlyServicesFlag;
	
    @Autowired
	AdminService adminService;
    
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public QueryCustomerResponse queryCustomer(QueryCustomerRequest request) throws LoginClaroException {
		QueryCustomerResponse queryCustomerResponse = new QueryCustomerResponse();
		/* Consulta IP */
		ConsultaIPResponse consultaIp = adminService.consultaIP(request.getIp());
		if (consultaIp != null) {
			if (consultaIp.getCustomerid() != null) {
				/* Consulta Suscripcion Cliente */
				ConsultaSuscripcionClienteResponse consultaSuscripcionCliente = adminService.consultaSuscripcionCliente(consultaIp.getCustomerid());
				if (consultaSuscripcionCliente != null) {
					if (consultaSuscripcionCliente.getSuscripcionCliente().size() > 1) {
						queryCustomerResponse.setCod_error("1");
						queryCustomerResponse.setMensaje("No existe informacion del cliente");
						return queryCustomerResponse;
					}else if (consultaSuscripcionCliente.getSuscripcionCliente().get(0).getToken() != null &&
							consultaSuscripcionCliente.getSuscripcionCliente().size() == 1) {
						/* Consulta Informacion Cliente */
						ConsultaInformacionClienteResponse consultaInformacionCliente = adminService.consultaInformacionCliente(consultaIp.getCustomerid());//consultaInformacionCliente("04538656");
						if (consultaInformacionCliente != null) {
							queryCustomerResponse.setNombres(consultaInformacionCliente.getNames());
							queryCustomerResponse.setApellidos(consultaInformacionCliente.getSurnames());
							queryCustomerResponse.setMail(consultaSuscripcionCliente.getSuscripcionCliente().get(0).getClarovideomail());
							queryCustomerResponse.setToken(consultaSuscripcionCliente.getSuscripcionCliente().get(0).getToken());
							return queryCustomerResponse;
						}else {
							throw new LoginClaroException("No hay conexion con el servicio => consultaInformacionCliente");	
						}
					}else {
						/* Consulta Informacion Cliente */
						ConsultaInformacionClienteResponse consultaInformacionCliente = adminService.consultaInformacionCliente(consultaIp.getCustomerid()); //No tiene nada
						if (consultaInformacionCliente != null) {
							String mailClaroOpcional = "";
							if (consultaInformacionCliente.getBillingmail() != null &&
									!consultaInformacionCliente.getBillingmail().equals("")) {
								if (consultaInformacionCliente.getClarowebsitemail() != null &&
										!consultaInformacionCliente.getClarowebsitemail().equals("")) {
									mailClaroOpcional = consultaInformacionCliente.getClarowebsitemail();
								}
								/* Generar Token */
								GenerarTokenResponse generarToken = adminService.generarToken(consultaIp.getCustomerid(),//"04538656",//consultaIp.getCodigocliente(), 
									    consultaInformacionCliente.getBillingmail(), 
									    mailClaroOpcional);
								if (generarToken.getToken() != null && !generarToken.getToken().equals("")) {
									queryCustomerResponse.setNombres(consultaInformacionCliente.getNames());
									queryCustomerResponse.setApellidos(consultaInformacionCliente.getSurnames());
									queryCustomerResponse.setMail(consultaInformacionCliente.getBillingmail());
									queryCustomerResponse.setToken(generarToken.getToken());
									return queryCustomerResponse;
								}else {
									queryCustomerResponse.setCod_error("1");
									queryCustomerResponse.setMensaje(generarToken.getMessagedescription());
									return queryCustomerResponse;
								}
							}else {
								if (consultaInformacionCliente.getClarowebsitemail() != null &&
										!consultaInformacionCliente.getClarowebsitemail().equals("")) {
									/* Generar token */
									GenerarTokenResponse generarToken = adminService.generarToken(consultaIp.getCustomerid(),//"00644690",//consultaIp.getCodigocliente(), 
											consultaInformacionCliente.getClarowebsitemail(), 
										    mailClaroOpcional);
									if (generarToken.getToken() != null && !generarToken.getToken().equals("")) {
										queryCustomerResponse.setNombres(consultaInformacionCliente.getNames());
										queryCustomerResponse.setApellidos(consultaInformacionCliente.getSurnames());
										queryCustomerResponse.setMail(consultaInformacionCliente.getClarowebsitemail());
										queryCustomerResponse.setToken(generarToken.getToken());
										return queryCustomerResponse;
									} else {
										queryCustomerResponse.setCod_error("1");
										queryCustomerResponse.setMensaje(generarToken.getMessagedescription());
										return queryCustomerResponse;
									}
								}else {
									queryCustomerResponse.setCod_error("1");
									queryCustomerResponse.setMensaje("No existe informacion del cliente");
									return queryCustomerResponse;
								}
							}
						}else {
							throw new LoginClaroException("No hay conexion con el servicio => consultaInformacionCliente");	
						}
					}
				} else {
					throw new LoginClaroException("No hay conexion con el servicio => consultaSuscripcionCliente");	
				}
			}else {
				if (consultaIp.getMessagecode() != null) {
					queryCustomerResponse.setCod_error(consultaIp.getMessagecode());
					queryCustomerResponse.setMensaje(consultaIp.getMessagedescription());
					return queryCustomerResponse;
				}else {
					throw new LoginClaroException("Error en el response => consultaIp");
				}
			}
		} else {
			throw new LoginClaroException("No hay conexion con el servicio => consultaIp");
		}
	}
	
	public ActivateSubscriptionResponse activateSubscription(ActivateSubscriptionRequest request) throws LoginClaroException {
		ActivateSubscriptionResponse activateSubscriptionResponse = new ActivateSubscriptionResponse();
		/* Consultar Ip */
		ConsultaIPResponse consultaIP = adminService.consultaIP(request.getIp());
		if (consultaIP != null) {
			if (consultaIP.getCustomerid() != null &&
					consultaIP.getMacaddress() != null) {
				/* Consultar Suscripcion Token */
				ConsultaSuscripcionTokenResponse consultaSuscripcionToken = adminService.consultaSuscripcionToken(request.getToken());
				if (consultaSuscripcionToken != null) {
					if (consultaSuscripcionToken.getCustomerid() != null &&
							consultaSuscripcionToken.getValidpaymentmethodflag() != null &&
							consultaSuscripcionToken.getValidservicepaymentmethodflag() != null &&
							consultaSuscripcionToken.getValidclarovideoserviceflag() != null) {
						System.out.println(consultaSuscripcionToken);
						System.out.println("Entra fase de procesos");
						Boolean procesoStatus = false;
						//consultaSuscripcionToken.setValidpaymentmethodflag("0");
						//consultaSuscripcionToken.setValidservicepaymentmethodflag("0");
						//consultaSuscripcionToken.setValidclarovideoserviceflag("0");
						//Primer flag
						if (consultaSuscripcionToken.getValidpaymentmethodflag().equals("1")) {
							if (consultaSuscripcionToken.getValidservicepaymentmethodflag().equals("1")) {
								if (consultaSuscripcionToken.getValidclarovideoserviceflag().equals("1")) {
									activateSubscriptionResponse.setCod_error("2");
									activateSubscriptionResponse.setMensaje("Cliente ya tiene una suscripción activa");
									return activateSubscriptionResponse;
								} else {
									System.out.println("Proceso 3");
									//Proceso 3
									ActivateSubscriptionResponse response = proceso3(request.getToken());
									if (response.getCod_error() != null &&
											response.getMensaje() != null) {
										return response;
									}else {
										response.setCod_error("0");
										response.setMensaje("Activación Éxitosa");
										return response;
									}
								}
							} else {
								System.out.println("Proceso 2");
								//Proceso 2
								ActivateSubscriptionResponse response = proceso2(request.getToken(), consultaSuscripcionToken.getPaymentmethodid());
								if (response.getCod_error() != null &&
										response.getMensaje() != null) {
									return response;
								}else {
									procesoStatus = true;
								}
							}
						}else {
							System.out.println("Proceso 1");
							//Proceso 1
							ActivateSubscriptionResponse response = proceso1(consultaIP.getMacaddress(), consultaSuscripcionToken.getCustomerid(), request.getToken());
							if (response.getCod_error() != null &&
									response.getMensaje() != null) {
								return response;
							}else {
								procesoStatus = true;
							}
						}
						
						//Validacion proceso 1 y 2
						//Sigue proceso 1 y 2
						if (procesoStatus == true) {
							System.out.println("Entro en el proceso 1 o 2, se procede a la validacion 3");
							if (consultaSuscripcionToken.getValidclarovideoserviceflag().equals("1")) {
								activateSubscriptionResponse.setCod_error("2");
								activateSubscriptionResponse.setMensaje("Cliente ya tiene una suscripción activa");
								return activateSubscriptionResponse;
							}else {
								//Proceso 3
								ActivateSubscriptionResponse response = proceso3(request.getToken());
								if (response.getCod_error() != null &&
										response.getMensaje() != null) {
									return response;
								}else {
									response.setCod_error("0");
									response.setMensaje("Activación Éxitosa");
									return response;
								}
							}
						}
						return activateSubscriptionResponse;
					} else {
						if (consultaSuscripcionToken.getMessagecode() != null) {
							activateSubscriptionResponse.setCod_error(consultaSuscripcionToken.getMessagecode());
							activateSubscriptionResponse.setMensaje(consultaSuscripcionToken.getMessagedescription());
							return activateSubscriptionResponse;
						} else {
							throw new LoginClaroException("Error en el response => consultaSuscripcionToken");
						}
					}
				} else {
					throw new LoginClaroException("No hay conexion con el servicio => consultaSuscripcionToken");
				}
			} else {
				if (consultaIP.getMessagecode() != null) {
					activateSubscriptionResponse.setCod_error(consultaIP.getMessagecode());
					activateSubscriptionResponse.setMensaje(consultaIP.getMessagedescription());
					return activateSubscriptionResponse;
				} else {
					throw new LoginClaroException("Error en el response => consultaIp");
				}
			}
		} else {
			throw new LoginClaroException("No hay conexion con el servicio => consultaIP");
		}
	}

	private ActivateSubscriptionResponse proceso3(String token) throws LoginClaroException {
		ActivateSubscriptionResponse activateSubscriptionResponse = new ActivateSubscriptionResponse();
		System.out.println(token);
		ActivarServicioClaroVideoResponse activarServicioClaroVideo = adminService.activarServicioClaroVideo(token);
		if (activarServicioClaroVideo != null) {
			if (activarServicioClaroVideo.getMessagecode() != null &&
				activarServicioClaroVideo.getMessagedescription() != null) {
				if (activarServicioClaroVideo.getMessagecode().equals("0")) {
					activateSubscriptionResponse.setCod_error(activarServicioClaroVideo.getMessagecode());
					activateSubscriptionResponse.setMensaje(activarServicioClaroVideo.getMessagedescription());
				}
			} else {
				throw new LoginClaroException("Error en el response => consultaSuscripcionToken");
			}
		} else {
			throw new LoginClaroException("No hay conexion con el servicio => activarServicioClaroVideo");
		}
		return activateSubscriptionResponse;
	}

	private ActivateSubscriptionResponse proceso2(String token, String paymentmethodid) throws LoginClaroException {
		ActivateSubscriptionResponse activateSubscriptionResponse = new ActivateSubscriptionResponse();
		ActualizarServicioFormaPagoTokenResponse actualizarServicioFormaPagoToken = adminService.actualizarServicioFormaPagoToken(token, paymentmethodid);
		if (actualizarServicioFormaPagoToken != null) {
			if (actualizarServicioFormaPagoToken.getMessagecode() != null &&
					actualizarServicioFormaPagoToken.getMessagedescription() != null) {
				if (actualizarServicioFormaPagoToken.getMessagecode().equals("0")) {
					activateSubscriptionResponse.setCod_error(actualizarServicioFormaPagoToken.getMessagecode());
					activateSubscriptionResponse.setMensaje(actualizarServicioFormaPagoToken.getMessagedescription());
				}
			} else {
				throw new LoginClaroException("Error en el response => actualizarServicioFormaPagoToken");
			}
		} else {
			throw new LoginClaroException("No hay conexion con el servicio => actualizarServicioFormaPagoToken");
		}
		return activateSubscriptionResponse;
	}

	private ActivateSubscriptionResponse proceso1(String macaddress, String customerid, String token) throws LoginClaroException {
		ActivateSubscriptionResponse activateSubscriptionResponse = new ActivateSubscriptionResponse();
		//macaddress = "384C90D38B12"; //Prueba
		/*Consulta Sucursal */
		ConsultaSucursalMacResponse consultaSucursalMac = adminService.consultaSucursalMac(macaddress);
		if (consultaSucursalMac != null) {
			System.out.println(consultaSucursalMac);
			if (consultaSucursalMac.getCustomerid() != null &&
					consultaSucursalMac.getAddressid() != null) {
				System.out.println("Validacion si cliente token es igual a cliente sucursal");
				//consultaSucursalMac.setCustomerid(customerid);
				//Validacion si cliente token es igual a cliente sucursal
				if (customerid.equals(consultaSucursalMac.getCustomerid())) {
					System.out.println("Es igual");
					/*Consulta forma de pago sucursal */
					//consultaSucursalMac.setAddressid("0001553470");//varias formas de pago
					ConsultaFormaPagoSucursalResponse consultaFormaPagoSucursal = adminService.consultaFormaPagoSucursal(consultaSucursalMac.getAddressid());
					if (consultaFormaPagoSucursal != null) {
						System.out.println(consultaFormaPagoSucursal);
						if (consultaFormaPagoSucursal.getFormaPagoSucursal().size() > 1) {
							//Mas de una forma de pago
							System.out.println("Mas de una forma de pago");
							String codCli = consultaFormaPagoSucursal.getFormaPagoSucursal().get(0).getCustomerid();
							/*Consulta forma de pago cliente */
							//System.out.println(codCli);
							//codCli = "00281362";
							ConsultaFormaPagoClienteResponse consultaFormaPagoCliente = adminService.consultaFormaPagoCliente(codCli, onlyServicesFlag);
							List<FormaPagoCliente> listaTarjetaCredito = new ArrayList<>(); //03
							List<FormaPagoCliente> listaDebitoCuenta = new ArrayList<>(); //02
							List<FormaPagoCliente> listaEfectivo = new ArrayList<>(); //01
							if (consultaFormaPagoCliente != null) {
								System.out.println(consultaFormaPagoCliente);
								if (consultaFormaPagoCliente.getFormaPagoCliente().size() > 1) {
									System.out.println("Varios metodos de pago");
									for (FormaPagoCliente formaPago : consultaFormaPagoCliente.getFormaPagoCliente()) {
										if (formaPago.getPaymenttypeid().equals(formaPago_TarjetaCredito)) {
											listaTarjetaCredito.add(formaPago);
										}
										if (formaPago.getPaymenttypeid().equals(formaPago_DebitoCuentaBancaria)) {
											listaDebitoCuenta.add(formaPago);
										}
										if (formaPago.getPaymenttypeid().equals(formaPago_Efectivo)) {
											listaEfectivo.add(formaPago);
										}
									}
									//Validacion
									if (listaTarjetaCredito.size() > 0) {
										System.out.println("Actualiza forma de pago - Va por tarjeta de credito");
										if (listaTarjetaCredito.size() == 1) {
											System.out.println("Solo tiene una forma de pago");
											/*Actualiza forma de pago */
											ActualizarFormaPagoResponse actualizarFormaPagoResponse = adminService.actualizarFormaPago(token, 
													listaTarjetaCredito.get(0).getPaymentmethodid(), 
													consultaSucursalMac.getAddressid());
											if (actualizarFormaPagoResponse != null) {
												if (actualizarFormaPagoResponse.getMessagecode().equals("0")) {
													activateSubscriptionResponse.setCod_error(actualizarFormaPagoResponse.getMessagecode());
													activateSubscriptionResponse.setMensaje(actualizarFormaPagoResponse.getMessagedescription());
													return activateSubscriptionResponse;
												}
											} else {
												throw new LoginClaroException("No hay conexion con el servicio => actualizarFormaPago");	
											}
										} else {
											System.out.println("Tiene varias");
											Float validarDeudaVencidaTC = Float.parseFloat(listaTarjetaCredito.get(0).getPendingdebt());
											int cont = 0;
											int itemNum = 0;
											for (FormaPagoCliente formaPagoCliente : listaTarjetaCredito) {
												Float ItemDedudaVencida = Float.parseFloat(formaPagoCliente.getPendingdebt());
												if (ItemDedudaVencida < validarDeudaVencidaTC) {
													validarDeudaVencidaTC = ItemDedudaVencida;
													itemNum = cont;
												}
												cont++;
											}
											/*Actualiza forma de pago */
											System.out.println(listaTarjetaCredito.get(itemNum).getPaymentmethodid());
											System.out.println(consultaSucursalMac.getAddressid());
											ActualizarFormaPagoResponse actualizarFormaPagoResponse = adminService.actualizarFormaPago(token, 
													listaTarjetaCredito.get(itemNum).getPaymentmethodid(), 
													consultaSucursalMac.getAddressid());
											System.out.println(actualizarFormaPagoResponse);
											if (actualizarFormaPagoResponse != null) {
												if (actualizarFormaPagoResponse.getMessagecode().equals("0")) {
													activateSubscriptionResponse.setCod_error(actualizarFormaPagoResponse.getMessagecode());
													activateSubscriptionResponse.setMensaje(actualizarFormaPagoResponse.getMessagedescription());
													return activateSubscriptionResponse;
												}
											} else {
												throw new LoginClaroException("No hay conexion con el servicio => actualizarFormaPago");	
											}
										}
									}else if(listaDebitoCuenta.size() > 0){
										System.out.println("Actualiza forma de pago - Va por debito de cuenta");
										if (listaDebitoCuenta.size() == 1) {
											System.out.println("Solo tiene una forma de pago");
											/*Actualiza forma de pago */
											ActualizarFormaPagoResponse actualizarFormaPagoResponse = adminService.actualizarFormaPago(token, 
													listaDebitoCuenta.get(0).getPaymentmethodid(), 
													consultaSucursalMac.getAddressid());
											if (actualizarFormaPagoResponse != null) {
												if (actualizarFormaPagoResponse.getMessagecode().equals("0")) {
													activateSubscriptionResponse.setCod_error(actualizarFormaPagoResponse.getMessagecode());
													activateSubscriptionResponse.setMensaje(actualizarFormaPagoResponse.getMessagedescription());
													return activateSubscriptionResponse;
												}
											} else {
												throw new LoginClaroException("No hay conexion con el servicio => actualizarFormaPago");	
											}
										} else {
											Float validarDeudaVencidaDC = Float.parseFloat(listaEfectivo.get(0).getPendingdebt());
											int cont = 0;
											int itemNum = 0;
											for (FormaPagoCliente formaPagoCliente : listaDebitoCuenta) {
												Float ItemDedudaVencida = Float.parseFloat(formaPagoCliente.getPendingdebt());
												if (ItemDedudaVencida < validarDeudaVencidaDC) {
													validarDeudaVencidaDC = ItemDedudaVencida;
													itemNum = cont;
												}
												cont++;
											}
											/*Actualiza forma de pago */
											ActualizarFormaPagoResponse actualizarFormaPagoResponse = adminService.actualizarFormaPago(token, 
													listaDebitoCuenta.get(itemNum).getPaymentmethodid(), 
													consultaSucursalMac.getAddressid());
											if (actualizarFormaPagoResponse != null) {
												if (actualizarFormaPagoResponse.getMessagecode().equals("0")) {
													activateSubscriptionResponse.setCod_error(actualizarFormaPagoResponse.getMessagecode());
													activateSubscriptionResponse.setMensaje(actualizarFormaPagoResponse.getMessagedescription());
													return activateSubscriptionResponse;
												}
											} else {
												throw new LoginClaroException("No hay conexion con el servicio => actualizarFormaPago");	
											}
										}
									}else if(listaEfectivo.size() > 0){
										System.out.println("Actualiza forma de pago - Va por efectivo");
										if (listaEfectivo.size() == 1) {
											System.out.println("Solo tiene una forma de pago");
											/*Actualiza forma de pago */
											ActualizarFormaPagoResponse actualizarFormaPagoResponse = adminService.actualizarFormaPago(token, 
													listaEfectivo.get(0).getPaymentmethodid(), 
													consultaSucursalMac.getAddressid());
											if (actualizarFormaPagoResponse != null) {
												if (actualizarFormaPagoResponse.getMessagecode().equals("0")) {
													activateSubscriptionResponse.setCod_error(actualizarFormaPagoResponse.getMessagecode());
													activateSubscriptionResponse.setMensaje(actualizarFormaPagoResponse.getMessagedescription());
													return activateSubscriptionResponse;
												}
											} else {
												throw new LoginClaroException("No hay conexion con el servicio => actualizarFormaPago");	
											}
										} else {
											Float validarDeudaVencidaEF = Float.parseFloat(listaEfectivo.get(0).getPendingdebt());
											int cont = 0;
											int itemNum = 0;
											for (FormaPagoCliente formaPagoCliente : listaEfectivo) {
												Float ItemDedudaVencida = Float.parseFloat(formaPagoCliente.getPendingdebt());
												if (ItemDedudaVencida < validarDeudaVencidaEF) {
													validarDeudaVencidaEF = ItemDedudaVencida;
													itemNum = cont;
												}
												cont++;
											}
											/*Actualiza forma de pago */
											ActualizarFormaPagoResponse actualizarFormaPagoResponse = adminService.actualizarFormaPago(token, 
													listaEfectivo.get(itemNum).getPaymentmethodid(), 
													consultaSucursalMac.getAddressid());
											if (actualizarFormaPagoResponse != null) {
												if (actualizarFormaPagoResponse.getMessagecode().equals("0")) {
													activateSubscriptionResponse.setCod_error(actualizarFormaPagoResponse.getMessagecode());
													activateSubscriptionResponse.setMensaje(actualizarFormaPagoResponse.getMessagedescription());
													return activateSubscriptionResponse;
												}
											} else {
												throw new LoginClaroException("No hay conexion con el servicio => actualizarFormaPago");	
											}
										}
									}
									return activateSubscriptionResponse;
								} else if(consultaFormaPagoCliente.getFormaPagoCliente().size() == 1 &&
										consultaFormaPagoCliente.getFormaPagoCliente().get(0).getPaymentmethodid() != null){
									System.out.println("Tiene una forma de pago");
									System.out.println(token);
									System.out.println(consultaFormaPagoCliente.getFormaPagoCliente().get(0).getPaymentmethodid());
									System.out.println(consultaSucursalMac.getAddressid());
									/*Actualiza forma de pago */
									ActualizarFormaPagoResponse actualizarFormaPagoResponse = adminService.actualizarFormaPago(token, 
											consultaFormaPagoCliente.getFormaPagoCliente().get(0).getPaymentmethodid(),
											consultaSucursalMac.getAddressid());
									if (actualizarFormaPagoResponse != null) {
										if (actualizarFormaPagoResponse.getMessagecode().equals("0")) {
											activateSubscriptionResponse.setCod_error(actualizarFormaPagoResponse.getMessagecode());
											activateSubscriptionResponse.setMensaje(actualizarFormaPagoResponse.getMessagedescription());
											return activateSubscriptionResponse;
										}else {
											return activateSubscriptionResponse;
										}
									}else {
										throw new LoginClaroException("No hay conexion con el servicio => actualizarFormaPago");
									}
								}else {
									if (consultaFormaPagoCliente.getFormaPagoCliente().get(0).getMessagecode() != null) {
										activateSubscriptionResponse.setCod_error(consultaFormaPagoCliente.getFormaPagoCliente().get(0).getMessagecode());
										activateSubscriptionResponse.setMensaje(consultaFormaPagoCliente.getFormaPagoCliente().get(0).getMessagedescription());
										return activateSubscriptionResponse;
									} else {
										throw new LoginClaroException("Error en el response => consultaFormaPagoCliente");
									}
								}
							} else {
								throw new LoginClaroException("No hay conexion con el servicio => consultaFormaPagoCliente");
							}
						}else if (consultaFormaPagoSucursal.getFormaPagoSucursal().get(0).getPaymentmethodid() != null &&
								consultaFormaPagoSucursal.getFormaPagoSucursal().size() == 1) {
							//Una forma de pago
							System.out.println("Tiene una forma de pago se procede a actualizar");
							/*Actualiza forma de pago */
							ActualizarFormaPagoResponse actualizarFormaPagoResponse = adminService.actualizarFormaPago(token, 
									consultaFormaPagoSucursal.getFormaPagoSucursal().get(0).getPaymentmethodid(),
									consultaSucursalMac.getAddressid());
							if (actualizarFormaPagoResponse != null) {
								if (actualizarFormaPagoResponse.getMessagecode().equals("0")) {
									activateSubscriptionResponse.setCod_error(actualizarFormaPagoResponse.getMessagecode());
									activateSubscriptionResponse.setMensaje(actualizarFormaPagoResponse.getMessagedescription());
									return activateSubscriptionResponse;
								}else {
									return activateSubscriptionResponse;
								}
							}else {
								throw new LoginClaroException("No hay conexion con el servicio => actualizarFormaPago");
							}
						}else {
							if (consultaFormaPagoSucursal.getFormaPagoSucursal().get(0).getMessagecode() != null) {
								activateSubscriptionResponse.setCod_error(consultaFormaPagoSucursal.getFormaPagoSucursal().get(0).getMessagecode());
								activateSubscriptionResponse.setMensaje(consultaFormaPagoSucursal.getFormaPagoSucursal().get(0).getMessagedescription());
								return activateSubscriptionResponse;
							} else {
								throw new LoginClaroException("Error en el response => consultaFormaPagoSucursal");
							}
						}
					} else {
						throw new LoginClaroException("No hay conexion con el servicio => consultaFormaPagoSucursal");
					}
				} else {
					System.out.println("No es igual");
					activateSubscriptionResponse.setCod_error("1");
					activateSubscriptionResponse.setMensaje("No existe Información del Cliente");
					return activateSubscriptionResponse;
				}
			} else {
				if (consultaSucursalMac.getMessagecode() != null &&
						consultaSucursalMac.getMessagedescription() != null) {
					activateSubscriptionResponse.setCod_error(consultaSucursalMac.getMessagecode());
					activateSubscriptionResponse.setMensaje(consultaSucursalMac.getMessagedescription());
					return activateSubscriptionResponse;
				} else {
					throw new LoginClaroException("Error en el response => consultaSucursalMac");
				}
			}
		} else {
			throw new LoginClaroException("No hay conexion con el servicio => consultaSucursalMac");
		}
	}
}
