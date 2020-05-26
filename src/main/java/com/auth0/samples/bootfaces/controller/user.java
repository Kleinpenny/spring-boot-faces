package com.auth0.samples.bootfaces.controller;

import com.auth0.samples.bootfaces.model.Product;
import com.auth0.samples.bootfaces.model.User;
import com.auth0.samples.bootfaces.persistence.ProductRepository;
import com.auth0.samples.bootfaces.persistence.UserRepository;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ReferencedBean;
import javax.inject.Named;

@Named("user")
@SessionScoped
@Join(path = "/list", to = "/list.jsf")
public class user implements Serializable {
	String userName;
	String email;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public boolean save() {
		int result = 0;
		final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
		final String USER = "root";
		final String PASS = "Pp1998107";

		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
			PreparedStatement stmt = con.prepareStatement("insert into user(name,password) values(?,?)");
			stmt.setString(1, this.getUserName());
			stmt.setString(2, this.getEmail());
			// System.out.println("Pls give me some feedback");
			result = stmt.executeUpdate();
			if (result == 1) {
				stmt.close();
				con.close();
				return true;
			} else {
				stmt.close();
				con.close();
				return false;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public String submit() {
		if (this.save()) {
			return "/result.jsf";
		} else {
			return "/index.jsf";
		}
	}


}
