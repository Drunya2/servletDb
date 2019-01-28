package client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Andrey on 20.01.2019.
 */
public class StartPageController extends Controller {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getRequestDispatcher("jsp/startPage.jsp").forward(request, response);
    }
}
