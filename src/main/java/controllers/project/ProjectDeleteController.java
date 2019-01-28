package controllers.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Andrey on 22.01.2019.
 */
public class ProjectDeleteController extends ProjectAbstractController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long id = Long.parseLong(request.getParameter("id"));
        deleteById(id);
        response.sendRedirect("/projects");
    }
}
