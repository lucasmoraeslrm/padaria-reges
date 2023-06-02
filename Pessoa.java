
package com.mycompany.padariareges;

import java.util.Calendar;

class Pessoa {
    private String nomeCompleto;
    private String email;
    private String endereco;
    private String telefone;
    private Calendar dataNasc;
    private String documento;
    private String rgIe;
    
    /*construtor*/
    public Pessoa(String nomeCompleto, String email, String endereco, String telefone, Calendar dataNasc,
                  String documento, String rgIe) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.documento = documento;
        this.rgIe = rgIe;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Calendar getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Calendar dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getRgIe() {
        return rgIe;
    }

    public void setRgIe(String rgIe) {
        this.rgIe = rgIe;
    }
}
