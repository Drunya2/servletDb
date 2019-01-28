package controllers.company;

import domain.Company;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Andrey on 23.01.2019.
 */
public class CompanyInfoController extends AbstractCompanyController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long id = Long.parseLong(request.getParameter("id"));
        Company company = getById(id);
        request.setAttribute("company", company);
        request.getRequestDispatcher("jsp/company/companyInfo.jsp").forward(request, response);
    }
}
