package struts2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse rep, FilterChain chain) throws IOException, ServletException {
		
		final HttpServletRequest request = (HttpServletRequest) req;
		
		conloseLog(req, request);
		
		chain.doFilter(req, rep);
		
	}
	
	private void conloseLog(ServletRequest req, HttpServletRequest request){
		
		System.out.println("URL：" + request.getRequestURI());
		for (Map.Entry entry : req.getParameterMap().entrySet()) {
			System.out.println("key：" + entry.getKey());
			System.out.print("values：");
			for(String obj : (String[]) entry.getValue()){
				System.out.println(obj);
			}
		}
		System.out.println("###########################");
		
	}
	
	private void fileLog(ServletRequest req, HttpServletRequest request){
		
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
