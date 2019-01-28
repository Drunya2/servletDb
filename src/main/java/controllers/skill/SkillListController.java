package controllers.skill;

import domain.Skill;
import repository.CrudRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Andrey on 23.01.2019.
 */
public class SkillListController extends AbstractSkillController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CrudRepository<Skill, Long> skillRepository = skills();
        List<Skill> skills =  skillRepository.getList();
        request.setAttribute("skills", skills);
        request.getRequestDispatcher("jsp/skill/skillsPage.jsp").forward(request, response);
    }
}
