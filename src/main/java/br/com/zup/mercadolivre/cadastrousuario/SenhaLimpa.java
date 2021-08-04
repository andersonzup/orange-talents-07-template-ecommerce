package br.com.zup.mercadolivre.cadastrousuario;


import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;

import javax.validation.constraints.NotBlank;

public class SenhaLimpa {

    @NotBlank
    @Length(min = 6)
    private String senha;

    public SenhaLimpa(String senha) {
        Assert.hasLength(senha, "senha não pode ser em branco");
        Assert.isTrue(senha.length()>=6, "Senha tem que ter no mínimo 6 caracteres");
        this.senha = senha;
    }
    public String hash(){
        return new BCryptPasswordEncoder().encode(senha);
    }
}