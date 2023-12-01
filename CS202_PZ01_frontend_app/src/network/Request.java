package network;


import java.net.URI;
import java.net.URISyntaxException;

import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Request {
	private String url;
	private Map<String, String> params;
	
	private String contentType = "application/json";
	private Duration requestTimeout;

	public Request(String urlString) {
		this.url = urlString;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Duration getRequestTimeout() {
		return requestTimeout;
	}

	public void setRequestTimeout(int ms) {
		this.requestTimeout = Duration.ofMillis(ms);
	}
	
	public HttpRequest.Builder initRequest() throws URISyntaxException {
		HttpRequest.Builder b = HttpRequest.newBuilder()
				.uri(URI.create(this.url + this.getParamsString()))
				.header("Accept", this.contentType);
		
		if(this.requestTimeout != null) b = b.timeout(this.requestTimeout);
		return b;
	}
	
	public void setParams(String... args) {
		assert args.length % 2 == 0 : "params require key-value pairs";
		
		this.params = new HashMap<>();
		for(int i=0; i<args.length; i += 2) {
			this.params.put(args[i], args[i+1]);	
		}
	}
	
	@SuppressWarnings("deprecation")
	private String getParamsString() {
		StringBuilder result = new StringBuilder();

		for (Map.Entry<String, String> entry : params.entrySet()) {
			result.append(URLEncoder.encode(entry.getKey()));
	        result.append("=");
	        result.append(URLEncoder.encode(entry.getValue()));
	        result.append("&");
		}

		String resultString = result.toString();
		return resultString.length() > 0
			? resultString.substring(0, resultString.length() - 1)
			: resultString;
    }

}
