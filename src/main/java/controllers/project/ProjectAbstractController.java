package controllers.project;

import client.Controller;
import domain.Project;
import repository.CrudRepository;
import service.CrudRepositoryService;
import service.ServiceRepository;

/**
 * Created by Andrey on 22.01.2019.
 */
public class ProjectAbstractController extends Controller {
    protected CrudRepository<Project, Long> projects(){
        CrudRepositoryService projectService = ServiceRepository.getINSTANCE().getService(CrudRepositoryService.class);
        CrudRepository<Project, Long> projectRepository = projectService.getRepository(Project.class);
        return projectRepository;
    }

    protected Project getById(long id){
        return projects().getDao(id);
    }

    protected void updateProject(Project project){
        projects().updateDao(project);
    }

    protected void deleteById(long id){
        Project project = projects().getDao(id);
        projects().deleteDao(project);
    }
}
