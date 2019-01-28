package controllers.developer;

import client.Controller;
import domain.Developer;
import domain.Project;
import domain.Skill;
import repository.CrudRepository;
import service.CrudRepositoryService;
import service.ServiceRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrey on 22.01.2019.
 */
public class DeveloperAbstractController extends Controller {
    protected CrudRepository<Developer, Long> developers() {
        CrudRepositoryService crudRepositoryService = ServiceRepository.getINSTANCE().getService(CrudRepositoryService.class);
        CrudRepository<Developer, Long> developerRepository = crudRepositoryService.getRepository(Developer.class);
        return developerRepository;
    }

    protected CrudRepository<Project, Long> projects() {
        CrudRepositoryService crudRepositoryService = ServiceRepository.getINSTANCE().getService(CrudRepositoryService.class);
        CrudRepository<Project, Long> projectRepository = crudRepositoryService.getRepository(Project.class);
        return projectRepository;
    }

    protected CrudRepository<Skill, Long> skills() {
        CrudRepositoryService crudRepositoryService = ServiceRepository.getINSTANCE().getService(CrudRepositoryService.class);
        CrudRepository<Skill, Long> skillRepository = crudRepositoryService.getRepository(Skill.class);
        return skillRepository;
    }

    protected Developer getById(long id){
        return developers().getDao(id);
    }

    protected void updateDeveloper(Developer developer){
        developers().updateDao(developer);
    }

    protected void deleteById(long id){
        Developer developer = developers().getDao(id);
        developers().deleteDao(developer);
    }

    protected boolean containsProject(long id){
        Project project = projects().getDao(id);
        if (project == null) return false;
        else return true;
    }

    protected Project getProjectById(long id){
        return projects().getDao(id);
    }

    protected Set<Project> getProjects(String parameter){
        String [] projects = parameter.split(" ");
        Set<Project> projectsSet = new HashSet<>();
        for (String id : projects){
            if (!id.equals("")) {
                long idProject = Long.parseLong(id);
                if (containsProject(idProject)) projectsSet.add(getProjectById(idProject));
            }
        }

        return projectsSet;
    }

    protected boolean containsSkill(long id){
        Skill skill = skills().getDao(id);
        if (skill == null) return false;
        else return true;
    }

    protected Skill getSkillById(long id){
        return skills().getDao(id);
    }

    protected Set<Skill> getSkills(String parameter){
        String [] skills = parameter.split(" ");
        Set<Skill> skillsSet = new HashSet<>();
        for (String id : skills){
            if (!id.equals("")){
                long idSkill = Long.parseLong(id);
                if (containsSkill(idSkill)) skillsSet.add(getSkillById(idSkill));
            }
        }

        return skillsSet;
    }

}
