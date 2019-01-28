package controllers.project;

import domain.Project;
import repository.CrudRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Andrey on 22.01.2019.
 */
public class ProjectListController extends ProjectAbstractController {

    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CrudRepository<Project, Long> projectRepository = projects();
        List<Project> projects = projectRepository.getList();
        request.setAttribute("projects", projects);
        request.getRequestDispatcher("jsp/project/projectsPage.jsp").forward(request, response);
    }
}
