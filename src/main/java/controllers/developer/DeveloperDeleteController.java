package controllers.developer;

import domain.Developer;
import repository.CrudRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Andrey on 21.01.2019.
 */
public class DeveloperDeleteController extends DeveloperAbstractController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CrudRepository<Developer, Long> developerRepository = developers();
        deleteById(Long.parseLong(request.getParameter("id")));
        response.sendRedirect("/developers");
    }
}
