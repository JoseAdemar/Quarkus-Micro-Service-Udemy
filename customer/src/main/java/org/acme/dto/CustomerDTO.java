package org.acme.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data // Gera os getters e setters equals e hash code
@Jacksonized //Reconhece a classe DTO como um objeto Json
@AllArgsConstructor //Cria construtores com argumentos
@NoArgsConstructor  //Cria construtor padrao sem argumentos
public class CustomerDTO {

    private String name;

    private String phone;

    private String email;

    private String address;

    private Long age;
}
