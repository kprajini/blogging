package com.blogging.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

	public int id;
	public String name;
	public String username;
	public String email;
	public Address address;
	public String phone;
	public String website;
	public Company company;
	

	//Added for Junits
	public Users(int id, String name, String username, String email, String phone, String website) {
		
		this.id=id;
		this.name = name;
		this.username=username;
		this.email=email;
		this.phone=phone;
		this.website=website;				
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Users [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", username=");
		builder.append(username);
		builder.append(", email=");
		builder.append(email);
		builder.append(", address=");
		builder.append(address);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", website=");
		builder.append(website);
		builder.append(", company=");
		builder.append(company);
		builder.append("]");
		return builder.toString();
	}

    
}
