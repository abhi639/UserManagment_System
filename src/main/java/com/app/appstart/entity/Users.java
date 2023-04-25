package com.app.appstart.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.tuple.GenerationTiming;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
		private long U_id;
	
	
		private String first_name;
		private String last_name;
		private String dateof_birth;
		private boolean isactive=true;
		
		private String email;
	
		
		
		private String mobile_number;
	    private String password;
	   
	    
	public String getFirst_name() {
			return first_name;
		}
		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}
		public String getLast_name() {
			return last_name;
		}
		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}
		public String getDateof_birth() {
			return dateof_birth;
		}
		public void setDateof_birth(String dateof_birth) {
			this.dateof_birth = dateof_birth;
		}
	
		public boolean isIsactive() {
			return isactive;
		}
		public void setIsactive(boolean isactive) {
			this.isactive = isactive;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="f_Add_id",referencedColumnName = "user_id")
	private List<Address> adress=new ArrayList<>();
	
	public long getU_id() {
		return U_id;
	}
	public void setU_id(long u_id) {
		U_id = u_id;
	}
	
	public String getEmail() {
		return email;	
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public List<Address> getAdress() {
		return adress;
	}
	public void setAdress(List<Address> adress) {
		this.adress = adress;
	}
	
	

	public Users() {
		super();
	}
	public Users(String first_name, String last_name, String dateof_birth, boolean isactive, String email, String role,
			String mobile_number, String password, List<Address> adress) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.dateof_birth = dateof_birth;
		this.isactive = isactive;
		this.email = email;
		
		this.mobile_number = mobile_number;
		this.password = password;
		
		this.adress = adress;
	}
	public Users(long u_id, String first_name, String last_name, String dateof_birth, boolean isactive, String email,
			 String mobile_number, String password,  List<Address> adress) {
		super();
		U_id = u_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.dateof_birth = dateof_birth;
		this.isactive = isactive;
		this.email = email;
	
		this.mobile_number = mobile_number;
		this.password = password;
		
		this.adress = adress;
	}
	public Users(long u_id, String first_name, String last_name, String dateof_birth, boolean isactive, String email,
			String mobile_number, String password) {
		super();
		U_id = u_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.dateof_birth = dateof_birth;
		this.isactive = isactive;
		this.email = email;
		this.mobile_number = mobile_number;
		this.password = password;
	}
	
	
	
	
	
	
}
