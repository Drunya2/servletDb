package controllers.project;

import domain.Project;
import repository.CrudRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Andrey on 22.01.2019.
 */
public class ProjectInfoController extends ProjectAbstractController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CrudRepository<Project, Long> projectRepository = projects();
        long id = Long.parseLong(request.getParameter("id"));
        Project project = getById(id);
        request.setAttribute("project", project);
        request.getRequestDispatcher("jsp/project/projectInfo.jsp").forward(request, response);
    }
}
