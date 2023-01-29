package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity //pra dizer ao d que é uma entidade do bd 
@Table(name = "tb_user") // dar o nome da tabela
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id //diz ao bd que o id é o pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)//pra dizer que é auto incrementada
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	/*criar as associações:
	 *um pedido um usuário, um usuário tem vários pedidos.
	 * */
	
	// 1 usuário pode ter vários pedidos:
	
	@OneToMany(mappedBy = "client")
	private List<Order> orders= new ArrayList<>();//ja instancio minha lista 
	
	public User() {		
	}
	public User(Long id, String name, String email, String phone, String password) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}