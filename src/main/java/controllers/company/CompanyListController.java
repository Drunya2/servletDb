package controllers.company;

import domain.Company;
import repository.CrudRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Andrey on 23.01.2019.
 */
public class CompanyListController extends AbstractCompanyController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CrudRepository<Company, Long> companyRepository = companies();
        List<Company> companies = companyRepository.getList();
        request.setAttribute("companies", companies);
        request.getRequestDispatcher("jsp/company/companiesPage.jsp").forward(request, response);
    }
}
