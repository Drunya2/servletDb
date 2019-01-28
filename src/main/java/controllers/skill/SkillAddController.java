package controllers.skill;

import domain.Skill;
import domain.SkillLevel;
import repository.CrudRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Andrey on 23.01.2019.
 */
public class SkillAddController extends AbstractSkillController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getRequestDispatcher("jsp/skill/addSkill.jsp").forward(request, response);
    }

    @Override
    public void handlePost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CrudRepository<Skill, Long> skillRepository = skills();
        String skillName = request.getParameter("skillName");
        String skillLevel = request.getParameter("skillLevel");
        Skill skill = new Skill();
        skill.setSkill(skillName);
        skill.setSkillLevel(SkillLevel.valueOf(skillLevel));
        skillRepository.createDao(skill);
        response.sendRedirect("/skills");
    }
}
