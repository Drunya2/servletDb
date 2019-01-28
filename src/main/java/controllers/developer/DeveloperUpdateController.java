package controllers.developer;

import domain.Developer;
import domain.Project;
import domain.Sex;
import domain.Skill;
import repository.CrudRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * Created by Andrey on 21.01.2019.
 */
public class DeveloperUpdateController extends DeveloperAbstractController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long id = Long.parseLong(request.getParameter("id"));
        Developer developer = getById(id);
        request.setAttribute("developer", developer);
        request.getRequestDispatcher("jsp/developer/updateDeveloper.jsp").forward(request, response);
    }

    @Override
    public void handlePost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String projectsId = request.getParameter("developerProjects");
        Set<Project> projects = getProjects(projectsId);
        String skillId = request.getParameter("developerSkills");
        Set<Skill> skills = getSkills(skillId);
        Developer developer = new Developer();
        developer.setId(Long.parseLong(request.getParameter("developerId")));
        developer.setName(request.getParameter("developerName"));
        developer.setSurname(request.getParameter("developerSurname"));
        developer.setSex(Sex.valueOf(request.getParameter("developerSex")));
        developer.setSalary(Long.parseLong(request.getParameter("developerSalary")));
        developer.setProjects(null);
        developer.setSkills(null);
        developer.setProjects(projects);
        developer.setSkills(skills);
        updateDeveloper(developer);
        response.sendRedirect("/developers");
    }
}
