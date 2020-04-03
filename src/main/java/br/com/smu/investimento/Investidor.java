package br.com.smu.investimento;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="investidor", sequenceName = "SQ_INVESTIDOR", allocationSize = 1)
public class Investidor {
	
	@Id
	@GeneratedValue(generator = "id_investidor", strategy = GenerationType.SEQUENCE)
	private int id;
	private String nome;
	private String cpf;
	private String email;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="id_endereco")
	private Endereco endereco;
	
	@OneToMany(mappedBy = "investidor", cascade = CascadeType.PERSIST)
	private List<Declaracao> listaDeclaracao= new ArrayList<Declaracao>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<Declaracao> getListaDeclaracao() {
		return listaDeclaracao;
	}
	public void setListaDeclaracao(List<Declaracao> listaDeclaracao) {
		this.listaDeclaracao = listaDeclaracao;
	}
	
}
