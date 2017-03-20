package com.pageBean;

import javax.servlet.http.HttpServletRequest;

public class Page {

	public static int getPc(HttpServletRequest request) {
		String value = request.getParameter("pc");
		if (value == null || value.trim().isEmpty()) {
			return 1;
		}
		return Integer.parseInt(value);
	}

}
