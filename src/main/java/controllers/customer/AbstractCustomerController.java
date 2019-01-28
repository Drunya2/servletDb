package controllers.customer;

import client.Controller;
import domain.Customer;
import repository.CrudRepository;
import service.CrudRepositoryService;
import service.ServiceRepository;

/**
 * Created by Andrey on 24.01.2019.
 */
public class AbstractCustomerController extends Controller {

    protected CrudRepository<Customer, Long> customers(){
        CrudRepositoryService companyService = ServiceRepository.getINSTANCE().getService(CrudRepositoryService.class);
        CrudRepository<Customer, Long> customerRepository = companyService.getRepository(Customer.class);
        return customerRepository;
    }

    protected Customer getById(long id){
        return customers().getDao(id);
    }

    protected void updateCustomer(Customer customer){
        customers().updateDao(customer);
    }

    protected void deleteById(long id){
        Customer customer = customers().getDao(id);
        customers().deleteDao(customer);
    }
}
