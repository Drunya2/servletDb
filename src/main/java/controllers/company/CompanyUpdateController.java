package controllers.company;

import domain.Company;
import domain.Developer;
import domain.Project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

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
        String projectsToDelete = request.getParameter("companyProjectsToDelete");
        String developersToDelete = request.getParameter("companyDevelopersToDelete");
        deleteCompanyOldProjectsAndDevelopers(projectsToDelete, developersToDelete);

        Company company = new Company();
        long id = Long.parseLong(request.getParameter("companyId"));
        String name = request.getParameter("companyName");
        String city = request.getParameter("companyCity");
        String projectsId = request.getParameter("companyProjects");
        Set<Project> projects = getProjects(projectsId);

        String developersId = request.getParameter("companyDevelopers");
        Set<Developer> developers = getDevelopers(developersId);
        company.setId(id);
        company.setName(name);
        company.setCity(city);
        updateCompany(company);
        for (Developer developer : developers){
            developer.setCompany(company);
            developers().updateDao(developer);
        }
        for (Project project : projects){
            project.setCompany(company);
            projects().updateDao(project);
        }
        response.sendRedirect("/companies");
    }

    private void deleteCompanyOldProjectsAndDevelopers(String projectIds, String developerIds){
        Set<Project> projects = getProjects(projectIds);
        Set<Developer> developers = getDevelopers(developerIds);
        for (Project project : projects){
            project.setCompany(null);
            projects().updateDao(project);
        }

        for (Developer developer : developers){
            developer.setCompany(null);
            developers().updateDao(developer);
        }
    }
}
