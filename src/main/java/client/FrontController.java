package client;

import controllers.company.*;
import controllers.customer.*;
import controllers.developer.*;
import controllers.project.*;
import controllers.skill.*;
import service.ServiceRepository;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrey on 20.01.2019.
 */

@WebFilter("/*")
public class FrontController implements Filter {
    private Map<String, Controller> pages;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServiceRepository.getINSTANCE();
        pages = new HashMap<>();
        pages.put("/", new StartPageController());
        pages.put("/developers", new DeveloperListController());
        pages.put("/developer_add", new DeveloperAddController());
        pages.put("/developer_edit", new DeveloperUpdateController());
        pages.put("/developer_delete", new DeveloperDeleteController());
        pages.put("/developer_info", new DeveloperInfoController());
        pages.put("/projects", new ProjectListController());
        pages.put("/project_add", new ProjectAddController());
        pages.put("/project_edit", new UpdateProjectController());
        pages.put("/project_delete", new ProjectDeleteController());
        pages.put("/project_info", new ProjectInfoController());
        pages.put("/skills", new SkillListController());
        pages.put("/skill_add", new SkillAddController());
        pages.put("/skill_edit", new SkillUpdateController());
        pages.put("/skill_delete", new SkillDeleteController());
        pages.put("/skill_info", new SkillInfoController());
        pages.put("/companies", new CompanyListController());
        pages.put("/company_add", new CompanyAddController());
        pages.put("/company_edit", new CompanyUpdateController());
        pages.put("/company_delete", new CompanyDeleteController());
        pages.put("/company_info", new CompanyInfoController());
        pages.put("/customers", new CustomerListController());
        pages.put("/customer_add", new CustomerAddController());
        pages.put("/customer_edit", new CustomerUpdateController());
        pages.put("/customer_delete", new CustomerDeleteController());
        pages.put("/customer_info", new CustomerInfoController());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletRequest.setCharacterEncoding("UTF-8");

        String uri = httpServletRequest.getRequestURI();

        if (uri.endsWith(".jsp")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            try {
                pages.get(uri).process(httpServletRequest, httpServletResponse);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void destroy() {

    }
}
