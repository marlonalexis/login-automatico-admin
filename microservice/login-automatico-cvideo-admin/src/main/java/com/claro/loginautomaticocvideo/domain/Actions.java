package com.claro.loginautomaticocvideo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="actions")
public class Actions {
	@Id
	private String id;
    private String endpoint;
    private String operation;
    private String payload;
    private String parameters;
    private String idInstancia;
    private String idTipoTransaccion;
    private String idIntegrador;
    private String codAlterno;
    private String dataSource;
    private String idRequest;
    
    public Actions(){
    	
    }
     
	public Actions(String id, String endpoint, String operation, String payload, String parameters, String idInstancia,
			String idTipoTransaccion, String idIntegrador, String codAlterno, String dataSource) {
		super();
		this.id = id;
		this.endpoint = endpoint;
		this.operation = operation;
		this.payload = payload;
		this.parameters = parameters;
		this.idInstancia = idInstancia;
		this.idTipoTransaccion = idTipoTransaccion;
		this.idIntegrador = idIntegrador;
		this.codAlterno = codAlterno;
		this.dataSource = dataSource;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public String getIdInstancia() {
		return idInstancia;
	}
	public void setIdInstancia(String idInstancia) {
		this.idInstancia = idInstancia;
	}
	public String getIdTipoTransaccion() {
		return idTipoTransaccion;
	}
	public void setIdTipoTransaccion(String idTipoTransaccion) {
		this.idTipoTransaccion = idTipoTransaccion;
	}
	public String getIdIntegrador() {
		return idIntegrador;
	}
	public void setIdIntegrador(String idIntegrador) {
		this.idIntegrador = idIntegrador;
	}
	public String getCodAlterno() {
		return codAlterno;
	}
	public void setCodAlterno(String codAlterno) {
		this.codAlterno = codAlterno;
	}
	public String getDataSource() {
		return dataSource;
	}
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	public String getIdRequest() {
		return idRequest;
	}
	public void setIdRequest(String idRequest) {
		this.idRequest = idRequest;
	}
	@Override
	public String toString() {
		return "Actions [id=" + id + ", endpoint=" + endpoint + ", operation=" + operation + ", payload=" + payload
				+ ", parameters=" + parameters + ", idInstancia=" + idInstancia + ", idTipoTransaccion="
				+ idTipoTransaccion + ", idIntegrador=" + idIntegrador + ", codAlterno=" + codAlterno + ", dataSource="
				+ dataSource + ", idRequest=" + idRequest + "]";
	}
}

