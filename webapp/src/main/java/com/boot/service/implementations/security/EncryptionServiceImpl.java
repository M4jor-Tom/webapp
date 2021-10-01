package com.boot.service.implementations.security;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;

import com.boot.service.security.EncryptionService;

public class EncryptionServiceImpl implements EncryptionService {

	private StrongPasswordEncryptor strongPasswordEncryptor;

	private StrongPasswordEncryptor getStrongPasswordEncryptor() {
		return strongPasswordEncryptor;
	}

	@Autowired
	public void setStrongPasswordEncryptor(StrongPasswordEncryptor strongPasswordEncryptor) {
		this.strongPasswordEncryptor = strongPasswordEncryptor;
	}
	
	@Override
	public String encryptString(String input) {
		return getStrongPasswordEncryptor().encryptPassword(input);
	}

	@Override
	public boolean checkPassword(String plainPassword, String encryptedPassword) {
		return getStrongPasswordEncryptor().checkPassword(plainPassword, encryptedPassword);
	}
}