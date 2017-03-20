package conf;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class[]{};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[]{AppWebConfiguration.class, WebSocketConfig.class};
	}

	/*Specify the servlet mapping(s) for the DispatcherServlet — for example "/", "/app", etc.*/
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		
		registration.setMultipartConfig( new MultipartConfigElement("") );
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
	
		super.onStartup(servletContext);
		servletContext.addListener(RequestContextListener.class);
	}

}
