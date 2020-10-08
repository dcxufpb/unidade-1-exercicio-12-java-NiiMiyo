package com.example.project;

public class Loja {

	private static final String ENDLN = System.lineSeparator();

    private String nomeLoja;
    private Endereco endereco;
    private String telefone;
    private String observacao;
    private String cnpj;
    private String inscricaoEstadual;

    public Loja(String nomeLoja, Endereco endereco, String telefone,
                String observacao, String cnpj, String inscricaoEstadual) {
        this.nomeLoja = nomeLoja;
        this.endereco = endereco;
        this.telefone = telefone;
        this.observacao = observacao;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getNomeLoja() {
        return this.nomeLoja;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String dadosLoja() {
		// Implemente aqui
		this.verificaLoja();

		String numeroStr = (this.getEndereco().getNumero() > 0) ? this.getEndereco().getNumero() + "" : "s/n";

		String ln2 = this.getEndereco().getLogradouro() + ", " + numeroStr;
		ln2 += isEmpty(this.getEndereco().getComplemento()) ? "" : " " + this.getEndereco().getComplemento();
		ln2 += ENDLN;

		String ln3 = "";
		ln3 += isEmpty( this.getEndereco().getBairro() ) ? "" : this.getEndereco().getBairro() + " - ";
		ln3 += this.getEndereco().getMunicipio() + " - " + this.getEndereco().getEstado() + ENDLN;

		String ln4 = "";
		ln4 += isEmpty( this.getEndereco().getCep()) ? "" : "CEP:" + this.getEndereco().getCep();
		

		if (!isEmpty( this.getTelefone() )){
			ln4 += isEmpty(ln4) ? "" : " ";
			ln4 += "Tel " + this.getTelefone();
		}
		ln4 += isEmpty(ln4) ? "" : ENDLN;

		String ln5 = "";
		ln5 += isEmpty( this.getObservacao() ) ? "" : this.getObservacao();
		ln5 += ENDLN;


		String output = this.getNomeLoja() + ENDLN;
		output += ln2;
		output += ln3;
		output += ln4;
		output += ln5;
		output += "CNPJ: " + this.getCnpj() + ENDLN;
		output += "IE: " + this.getInscricaoEstadual() + ENDLN;

		return output;
	}

	private static boolean isEmpty(String str){
		if (str == null) return true;
		int spaceCount = str.length() - str.replace(".", "").length();
		return (spaceCount == str.length());
	}

	private void verificaLoja() {
		if (isEmpty(this.getEndereco().getMunicipio())){
			throw new RuntimeException("O campo município do endereço é obrigatório");
		}

		if (isEmpty(this.getCnpj())) {
			throw new RuntimeException("O campo CNPJ da loja é obrigatório");
		}

		if (isEmpty(this.getInscricaoEstadual())) {
			throw new RuntimeException("O campo inscrição estadual da loja é obrigatório");
		}

		if (isEmpty(this.getNomeLoja())) {
			throw new RuntimeException("O campo nome da loja é obrigatório");
		}

		if (isEmpty(this.getEndereco().getLogradouro())) {
			throw new RuntimeException("O campo logradouro do endereço é obrigatório");
		}

		if (isEmpty( this.getEndereco().getEstado() )) {
			throw new RuntimeException("O campo estado do endereço é obrigatório");
		}
	}

}