package controllers.skill;

import domain.Skill;
import domain.SkillLevel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Andrey on 23.01.2019.
 */
public class SkillUpdateController extends AbstractSkillController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long id = Long.parseLong(request.getParameter("id"));
        Skill skill = getById(id);
        request.setAttribute("skill", skill);
        request.getRequestDispatcher("jsp/skill/updateSkill.jsp").forward(request, response);
    }

    @Override
    public void handlePost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long id = Long.parseLong(request.getParameter("skillId"));
        String skillName = request.getParameter("skillName");
        String skillLevel = request.getParameter("skillLevel");
        Skill skill = skills().getDao(id);
        skill.setSkill(skillName);
        skill.setSkillLevel(SkillLevel.valueOf(skillLevel));
        updateSkill(skill);
        response.sendRedirect("/skills");
    }
}
