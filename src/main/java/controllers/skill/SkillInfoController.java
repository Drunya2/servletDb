package controllers.skill;

import domain.Skill;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Andrey on 23.01.2019.
 */
public class SkillInfoController extends AbstractSkillController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long id = Long.parseLong(request.getParameter("id"));
        Skill skill = getById(id);
        request.setAttribute("skill", skill);
        request.getRequestDispatcher("jsp/skill/skillInfo.jsp").forward(request, response);
    }
}
