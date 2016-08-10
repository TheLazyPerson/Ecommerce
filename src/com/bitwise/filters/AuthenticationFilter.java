package com.bitwise.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

  
    public AuthenticationFilter() {
        
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

	 	HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/login";
        String path = ((HttpServletRequest) request).getRequestURI();
        
        boolean loggedIn = session != null && session.getAttribute("username") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        boolean flag = authUserAgainstCookie(request);
        if ((loggedIn && flag) || loginRequest  ) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURI);
        }
        
	}
	
	private boolean authUserAgainstCookie(HttpServletRequest req) {
		boolean flag = false;
		Cookie [] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (! isSessionExpired(req)) {
					if (cookie.getValue()
							.equals(req.getSession(false)
									.getAttribute("sessID"))) {
						flag = true;
					}
				}
			}
		}
		return flag;
	}
	private boolean isSessionExpired(HttpServletRequest req) {
		return req.getSession(false) == null; 
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
