package controllers.project;

import domain.Project;
import repository.CrudRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Andrey on 22.01.2019.
 */
public class UpdateProjectController extends ProjectAbstractController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CrudRepository<Project, Long> projectRepository = projects();
        long id = Long.parseLong(request.getParameter("id"));
        Project project = getById(id);
        request.setAttribute("project", project);
        request.getRequestDispatcher("jsp/project/updateProject.jsp").forward(request, response);
    }

    @Override
    public void handlePost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Project project = new Project();
        CrudRepository<Project, Long> projectRepository = projects();
        long id = Long.parseLong(request.getParameter("projectId"));
        String name = request.getParameter("projectName");
        String description = request.getParameter("projectDescription");
        project.setId(id);
        project.setProjectName(name);
        project.setDescription(description);
        updateProject(project);
        response.sendRedirect("/projects");
    }
}
