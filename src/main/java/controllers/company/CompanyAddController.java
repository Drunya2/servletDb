package controllers.company;

import domain.Company;
import domain.Developer;
import domain.Project;
import repository.CrudRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * Created by Andrey on 23.01.2019.
 */
public class CompanyAddController extends AbstractCompanyController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getRequestDispatcher("jsp/company/addCompany.jsp").forward(request, response);
    }

    @Override
    public void handlePost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("companyName");
        String city = request.getParameter("companyCity");
        String projectsId = request.getParameter("companyProjects");
        Set<Project> projects = getProjects(projectsId);

        String developersId = request.getParameter("companyDevelopers");
        Set<Developer> developers = getDevelopers(developersId);
        Company company = new Company();
        company.setName(name);
        company.setCity(city);
        CrudRepository<Company, Long> companyRepository = companies();
        companyRepository.createDao(company);

        for (Developer developer : developers){
            developer.setCompany(getLast());
            developers().updateDao(developer);
        }
        for (Project project : projects){
            project.setCompany(company);
            projects().updateDao(project);
        }
        response.sendRedirect("/companies");
    }
}
