//package com.startup.ssl.config;
//
//import java.io.InputStream;
//import java.security.KeyStore;
//
//import javax.net.ssl.KeyManagerFactory;
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLSocket;
//import javax.net.ssl.SSLSocketFactory;
//import javax.net.ssl.TrustManagerFactory;
//
//import org.apache.http.client.HttpClient;
//import org.apache.http.conn.ssl.NoopHostnameVerifier;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.ssl.SSLContexts;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.Resource;
//import org.springframework.http.client.ClientHttpRequestFactory;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.web.client.RestOperations;
//import org.springframework.web.client.RestTemplate;
//
//@Configuration
//public class RestClientConfig {
//
//	private static final Logger log = LoggerFactory.getLogger(RestClientConfig.class);
//
//	@Bean()
//	@Qualifier("SSLRestOperations")
//	public RestOperations restOperations(ClientHttpRequestFactory clientHttpRequestFactory) throws Exception {
//		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
//		return restTemplate;
//	}
//
//	@Bean
//	public ClientHttpRequestFactory clientHttpRequestFactory(HttpClient httpClient) {
//		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
//		// timeout
//		requestFactory.setReadTimeout(60 * 1000);
//		requestFactory.setConnectTimeout(60 * 1000);
//		return requestFactory;
//	}
//
//	@Bean
//	public HttpClient httpClient(@Value("${keystore.file}") Resource file, @Value("${keystore.pass}") String keystorePassword)
//			throws Exception {
//		KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
//		TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//
//		KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
//		KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
//
//		InputStream instream = file.getInputStream();
//		InputStream instreamKey = file.getInputStream();
//		try {
//			keyStore.load(instreamKey, keystorePassword.toCharArray());
//			trustStore.load(instream, keystorePassword.toCharArray());
//
//			kmf.init(keyStore, keystorePassword.toCharArray());
//			tmf.init(trustStore);
//
//		} finally {
//			instream.close();
//			instreamKey.close();
//		}
//
//		SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(trustStore, new TrustSelfSignedStrategy())
//				.loadKeyMaterial(trustStore, keystorePassword.toCharArray()).build();
//
//		SSLSocketFactory socketFactory = sslcontext.getSocketFactory();
//		SSLSocket socket = (SSLSocket) socketFactory.createSocket();
//
//		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1.2" }, null,
//				new NoopHostnameVerifier());
//
//		return HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier()) // HostnameVerifier
//																						// NoopHostnameVerifier
//				.setSSLSocketFactory(sslsf).build();
//	}
//
//}
