package controllers.skill;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Andrey on 23.01.2019.
 */
public class SkillDeleteController extends AbstractSkillController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long id = Long.parseLong(request.getParameter("id"));
        deleteSkillById(id);
        response.sendRedirect("/skills");
    }
}
