package controllers.company;

import domain.Company;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Andrey on 23.01.2019.
 */
public class CompanyUpdateController extends AbstractCompanyController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long id = Long.parseLong(request.getParameter("id"));
        Company company = getById(id);
        request.setAttribute("company", company);
        request.getRequestDispatcher("jsp/company/updateCompany.jsp").forward(request, response);
    }

    @Override
    public void handlePost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Company company = new Company();
        long id = Long.parseLong(request.getParameter("companyId"));
        String name = request.getParameter("companyName");
        String city = request.getParameter("companyCity");
        company.setId(id);
        company.setName(name);
        company.setCity(city);
        updateCompany(company);
        response.sendRedirect("/companies");
    }
}
