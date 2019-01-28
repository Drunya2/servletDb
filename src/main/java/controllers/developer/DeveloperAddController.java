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
 * Created by Andrey on 20.01.2019.
 */
public class DeveloperAddController extends DeveloperAbstractController {

    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("developerId", request.getParameter("developerId"));
        request.getRequestDispatcher("jsp/developer/addDeveloper.jsp").forward(request, response);
    }

    @Override
    public void handlePost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("developerName");
        String surname = request.getParameter("developerSurname");
        String sex = request.getParameter("developerSex");
        long salary = 0;
        if (!request.getParameter("developerSalary").equals("")){
            salary = Long.parseLong(request.getParameter("developerSalary"));
        }
        String projectsId = request.getParameter("developerProjects");
        Set<Project> projects = getProjects(projectsId);

        String skillId = request.getParameter("developerSkills");
        Set<Skill> skills = getSkills(skillId);

        CrudRepository<Developer, Long> developerRepository = developers();
        Developer developer = new Developer();
        developer.setName(name);
        developer.setSurname(surname);
        developer.setSex(Sex.valueOf(sex));
        developer.setSalary(salary);
        developer.setProjects(projects);
        developer.setSkills(skills);
        developerRepository.createDao(developer);
        response.sendRedirect("/developers");
    }
}
