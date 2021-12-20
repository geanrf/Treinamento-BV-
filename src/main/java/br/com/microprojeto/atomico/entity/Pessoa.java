package br.com.microprojeto.atomico.entity;

public class Pessoa {

	private String id;
	private String nome;
	private String cpf;
	private String rg;
	private String logradouro;
	private String numLogradouro;
	private String cep;
	private String ddd;
	private String telefone;

	public Pessoa(String id, String nome, String cpf, String rg, String logradouro, String numLogradouro, String cep, String ddd,
				  String telefone) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.logradouro = logradouro;
		this.numLogradouro = numLogradouro;
		this.cep = cep;
		this.ddd = ddd;
		this.telefone = telefone;
	}

	public Pessoa(String id, String nome, String cpf, String rg, String logradouro, String numLogradouro, String cep,
			String telefone) {
	}

	public Pessoa() {

	}

	@Override
	public String toString() {
		return "Pessoa{" + "id=" + id + ", nome='" + nome + '\'' + ", CPF=" + cpf + ", RG=" + rg + ", logradouro='"
				+ logradouro + '\'' + ", numLogradouro=" + numLogradouro + ", CEP=" + cep + ", DDD=" + ddd
				+ ", telefone=" + telefone + '}';
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumLogradouro() {
		return numLogradouro;
	}

	public void setNumLogradouro(String numLogradouro) {
		this.numLogradouro = numLogradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
