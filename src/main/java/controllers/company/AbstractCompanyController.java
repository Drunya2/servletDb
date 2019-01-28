package controllers.company;

import client.Controller;
import domain.Company;
import domain.Developer;
import domain.Project;
import repository.CrudRepository;
import service.CrudRepositoryService;
import service.ServiceRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrey on 23.01.2019.
 */
public class AbstractCompanyController extends Controller {
    protected CrudRepository<Company, Long> companies() {
        CrudRepositoryService companyService = ServiceRepository.getINSTANCE().getService(CrudRepositoryService.class);
        CrudRepository<Company, Long> companyRepository = companyService.getRepository(Company.class);
        return companyRepository;
    }

    protected CrudRepository<Project, Long> projects() {
        CrudRepositoryService crudRepositoryService = ServiceRepository.getINSTANCE().getService(CrudRepositoryService.class);
        CrudRepository<Project, Long> projectRepository = crudRepositoryService.getRepository(Project.class);
        return projectRepository;
    }

    protected CrudRepository<Developer, Long> developers() {
        CrudRepositoryService crudRepositoryService = ServiceRepository.getINSTANCE().getService(CrudRepositoryService.class);
        CrudRepository<Developer, Long> developerRepository = crudRepositoryService.getRepository(Developer.class);
        return developerRepository;
    }

    protected Company getById(long id) {
        return companies().getDao(id);
    }

    protected void updateCompany(Company company) {
        companies().updateDao(company);
    }

    protected void deleteById(long id) {
        Company company = companies().getDao(id);
        companies().deleteDao(company);
    }

    protected boolean containsProject(long id) {
        Project project = projects().getDao(id);
        if (project == null) return false;
        else return true;
    }

    protected Project getProjectById(long id) {
        return projects().getDao(id);
    }

    protected Set<Project> getProjects(String parameter) {
        String[] projects = parameter.split(" ");
        Set<Project> projectsSet = new HashSet<>();
        for (String id : projects) {
            if (!id.equals("")) {
                long idProject = Long.parseLong(id);
                if (containsProject(idProject)) projectsSet.add(getProjectById(idProject));
            }
        }
        return projectsSet;
    }

    protected boolean containsDeveloper(long id) {
        Developer developer = developers().getDao(id);
        if (developer == null) return false;
        else return true;
    }

    protected Developer getDeveloperById(long id) {
        return developers().getDao(id);
    }

    protected Set<Developer> getDevelopers(String parameter) {
        String[] developers = parameter.split(" ");
        Set<Developer> developersSet = new HashSet<>();
        for (String id : developers) {
            if (!id.equals("")) {
                long idDeveloper = Long.parseLong(id);
                if (containsDeveloper(idDeveloper)) developersSet.add(getDeveloperById(idDeveloper));
            }
        }

        return developersSet;
    }

    protected Company getLast() {
        Company company = companies().getLastDao();
        return company;
    }
}
