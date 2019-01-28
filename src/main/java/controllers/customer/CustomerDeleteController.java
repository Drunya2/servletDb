package controllers.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Andrey on 24.01.2019.
 */
public class CustomerDeleteController extends AbstractCustomerController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long id = Long.parseLong(request.getParameter("id"));
        deleteById(id);
        response.sendRedirect("/customers");
    }
}
