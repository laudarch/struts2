package struts2;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class LogFilter implements Filter {

	private static final Logger logger = Logger.getLogger(LogFilter.class);

	public void destroy() {

	}

	public void doFilter(final ServletRequest req, final ServletResponse rep,
			final FilterChain chain) throws IOException, ServletException {

		final HttpServletRequest request = (HttpServletRequest) req;

		log(request);

		try {
			chain.doFilter(req, rep);
		} catch (Exception e) {
			// donothing
		}

	}

	private void log(final HttpServletRequest request) {
		StringBuilder sb = new StringBuilder(1024);
		sb.append("URL:").append(request.getRequestURI()).append("\n");
		for (Map.Entry<String, String[]> entry : request.getParameterMap()
				.entrySet()) {
			sb.append("Parameter name:").append(entry.getKey()).append("\n");
			sb.append("values:");
			for (String obj : entry.getValue()) {
				sb.append(obj);
			}
			sb.append("\n");
		}
		logger.info(sb);
	}

	public void init(final FilterConfig config) throws ServletException {

	}

}
