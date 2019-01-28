package controllers.developer;

import domain.Developer;
import repository.CrudRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Andrey on 20.01.2019.
 */
public class DeveloperListController extends DeveloperAbstractController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CrudRepository<Developer, Long> developerRepository = developers();
        List<Developer> developers = developerRepository.getList();
        request.setAttribute("developers", developers);
        request.getRequestDispatcher("jsp/developer/developersPage.jsp").forward(request, response);
    }
}
