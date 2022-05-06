package model2_shop.com.fiter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter("/item/*")
public class ItemLoginCheck implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//로그인이 되어 있고 등급이 1이상인 사람(0,1)만 접근할 수 있도록 작성하세요!
	}
}
