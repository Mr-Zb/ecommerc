//package com.fun.framework.utils;
//
//import java.security.KeyManagementException;
//import java.security.NoSuchAlgorithmException;
//import java.security.cert.CertificateException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.X509TrustManager;
//
//import org.apache.http.NameValuePair;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.config.Registry;
//import org.apache.http.config.RegistryBuilder;
//import org.apache.http.conn.socket.ConnectionSocketFactory;
//import org.apache.http.conn.socket.PlainConnectionSocketFactory;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.util.EntityUtils;
//
//public class HttpUtils {
//	public HttpClient httpClient = null;
//	public final RequestConfig requestConfig = RequestConfig.custom()//
//			.setSocketTimeout(30 * 1000).setConnectTimeout(30 * 1000)//
//			.setRedirectsEnabled(true)//
//			.build();// 设置请求和传输超时时间
//
//	/**
//	 * 绕过验证
//	 * 
//	 * @return
//	 * @throws NoSuchAlgorithmException
//	 * @throws KeyManagementException
//	 */
//	public SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
//		SSLContext sc = SSLContext.getInstance("TLS");// TLS//SSLv3
//		// 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
//		X509TrustManager trustManager = new X509TrustManager() {
//			@Override
//			public void checkClientTrusted(java.security.cert.X509Certificate[] paramArrayOfX509Certificate, String paramString) throws CertificateException {
//			}
//
//			@Override
//			public void checkServerTrusted(java.security.cert.X509Certificate[] paramArrayOfX509Certificate, String paramString) throws CertificateException {
//			}
//
//			@Override
//			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//				return null;
//			}
//		};
//		sc.init(null, new TrustManager[] { trustManager }, null);
//		return sc;
//	}
//
//	public HttpUtils() throws KeyManagementException, NoSuchAlgorithmException {
//		// 设置协议http和https对应的处理socket链接工厂的对象
//		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()//
//				.register("http", PlainConnectionSocketFactory.INSTANCE)//
//				.register("https", new SSLConnectionSocketFactory(createIgnoreVerifySSL()))//
//				.build();
//		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
//		HttpClients.custom().setConnectionManager(connManager);
//		this.httpClient = HttpClients.custom().setConnectionManager(connManager).build();
//	}
//
//	public String get(String host) throws Exception {
//		HttpGet httpGet = null;
//		try {
//			httpGet = new HttpGet(host);
//			httpGet.setConfig(requestConfig);
//
//			httpGet.setHeader("Content-type", "application/x-www-form-urlencoded; charset=UTF-8");
//			httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.82 Safari/537.36");
//			return EntityUtils.toString(httpClient.execute(httpGet).getEntity());
//		} catch (Exception e) {
//		} finally {
//			if (httpGet != null) {
//				httpGet.abort();
//				httpGet.releaseConnection();
//			}
//		}
//		return "";
//	}
//
//	public String post(String host, Map<String, String> map) throws Exception {
//		HttpPost httpPost = null;
//		try {
//			// 创建post方式请求对象
//			httpPost = new HttpPost(host);
//			// 设置参数到请求对象中
//			httpPost.setConfig(requestConfig);
//			httpPost.setHeader("Content-type", "application/x-www-form-urlencoded; charset=UTF-8");
//			httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.82 Safari/537.36");
//			httpPost.addHeader("X-Requested-With", "XMLHttpRequest");
//			// 装填参数
//			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//			map.entrySet().stream().forEach(a -> {
//				nvps.add(new BasicNameValuePair(a.getKey(), a.getValue()));
//			});
//			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
//
//			return EntityUtils.toString(httpClient.execute(httpPost).getEntity());
//		} catch (Exception e) {
//		} finally {
//			if (httpPost != null) {
//				httpPost.abort();
//				httpPost.releaseConnection();
//			}
//		}
//		return "";
//	}
//}
