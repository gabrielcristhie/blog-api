package com.solides.blog.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
	
	@NotEmpty
	@Size(min = 4, message = "O usuário precisa ter no mínimo 4 caracteres")
	private String name;
	
	@Email(message = "Endereço de email inválido, insira um email válido.")
	private String email;
	
	@NotEmpty
	@Size(min = 6, message = "A senha deve ter no mínimo seis dígitos")
	private String password;
	
	@NotEmpty
	private String about;
}
