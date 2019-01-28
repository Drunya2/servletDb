package controllers.project;

import domain.Project;
import repository.CrudRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Andrey on 22.01.2019.
 */
public class ProjectAddController extends ProjectAbstractController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getRequestDispatcher("jsp/project/addProject.jsp").forward(request, response);
    }

    @Override
    public void handlePost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("projectName");
        String description = request.getParameter("projectDescription");
        Project project = new Project();
        project.setProjectName(name);
        project.setDescription(description);
        CrudRepository<Project, Long> projectRepository = projects();
        projectRepository.createDao(project);
        response.sendRedirect("/projects");
    }
}
