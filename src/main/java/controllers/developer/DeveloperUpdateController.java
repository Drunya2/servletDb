package controllers.developer;

import domain.Developer;
import domain.Sex;
import repository.CrudRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Andrey on 21.01.2019.
 */
public class DeveloperUpdateController extends DeveloperAbstractController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long id = Long.parseLong(request.getParameter("id"));
        CrudRepository<Developer, Long> developerRepository = developers();
        Developer developer = getById(id);
        request.setAttribute("developer", developer);
        request.getRequestDispatcher("jsp/developer/updateDeveloper.jsp").forward(request, response);
    }

    @Override
    public void handlePost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Developer developer = new Developer();
        developer.setId(Long.parseLong(request.getParameter("developerId")));
        developer.setName(request.getParameter("developerName"));
        developer.setSurname(request.getParameter("developerSurname"));
        developer.setSex(Sex.valueOf(request.getParameter("developerSex")));
        developer.setSalary(Long.parseLong(request.getParameter("developerSalary")));
        CrudRepository<Developer, Long> developerRepository = developers();
        updateDeveloper(developer);
        response.sendRedirect("/developers");
    }
}
