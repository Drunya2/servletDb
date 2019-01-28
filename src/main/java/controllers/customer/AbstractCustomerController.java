package controllers.customer;

import client.Controller;
import domain.Company;
import domain.Customer;
import domain.Project;
import repository.CrudRepository;
import service.CrudRepositoryService;
import service.ServiceRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrey on 24.01.2019.
 */
public class AbstractCustomerController extends Controller {

    protected CrudRepository<Customer, Long> customers(){
        CrudRepositoryService companyService = ServiceRepository.getINSTANCE().getService(CrudRepositoryService.class);
        CrudRepository<Customer, Long> customerRepository = companyService.getRepository(Customer.class);
        return customerRepository;
    }

    protected CrudRepository<Project, Long> projects() {
        CrudRepositoryService crudRepositoryService = ServiceRepository.getINSTANCE().getService(CrudRepositoryService.class);
        CrudRepository<Project, Long> projectRepository = crudRepositoryService.getRepository(Project.class);
        return projectRepository;
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

    protected boolean containsProject(long id) {
        Project project = projects().getDao(id);
        if (project == null) return false;
        else return true;
    }

    protected Project getProjectById(long id) {
        return projects().getDao(id);
    }

    protected Set<Project> getProjects(String parameter) {
        String[] projects = parameter.split(" ");
        Set<Project> projectsSet = new HashSet<>();
        for (String id : projects) {
            long idProject = Long.parseLong(id);
            if (containsProject(idProject)) projectsSet.add(getProjectById(idProject));
        }

        return projectsSet;
    }

    protected Customer getLast() {
        Customer customer = customers().getLastDao();
        return customer;
    }
}
