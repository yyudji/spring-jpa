package br.com.smu.investimento;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//Define a entidade Declaracao(mesmo nome da classe)
@Entity
//Nome da sequence criada
//allocationSize = valor de incremento na sequence
@SequenceGenerator(name="declaracao", sequenceName = "SQ_DECLARACAO", allocationSize = 1)
public class Declaracao {
	//Id da tabela
	@Id
	@GeneratedValue(generator = "id_declaracao", strategy = GenerationType.SEQUENCE)
	private int id;
	private String ip;
	private String userAgent;
	private boolean assinado;

	//especifica o tipo de dado a ser armazenado em propriedades do tipo Date e Calendar
	//Timestamp = data e hora da declaracao
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDate dataAssinatura;
	
	//Varias declaracoes para 1 Investidor
	@ManyToOne
	//
	@JoinColumn(name="id_investidor")
	private Investidor investidor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public boolean isAssinado() {
		return assinado;
	}
	public void setAssinado(boolean assinado) {
		this.assinado = assinado;
	}
	public LocalDate getDataAssinatura() {
		return dataAssinatura;
	}
	public void setDataAssinatura(LocalDate dataAssinatura) {
		this.dataAssinatura = dataAssinatura;
	}

}
