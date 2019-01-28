package controllers.developer;

import domain.Developer;
import repository.CrudRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Andrey on 21.01.2019.
 */
public class DeveloperInfoController extends DeveloperAbstractController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long id = Long.parseLong(request.getParameter("id"));
        CrudRepository<Developer, Long> developerRepository = developers();
        Developer developer = getById(id);
        request.setAttribute("developer", developer);
        request.getRequestDispatcher("jsp/developer/developerInfo.jsp").forward(request, response);
    }
}