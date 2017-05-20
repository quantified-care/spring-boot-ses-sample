package com.quantifiedcare;

import com.amazonaws.auth.AWSCredentials;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author jlouns
 */
@ConfigurationProperties(prefix = "ses")
public class SesProperties implements AWSCredentials {
	private String accessKey;
	private String secretKey;

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	@Override
	public String getAWSAccessKeyId() {
		return getAccessKey();
	}

	@Override
	public String getAWSSecretKey() {
		return getSecretKey();
	}
}
