package controllers.skill;

import client.Controller;
import domain.Skill;
import repository.CrudRepository;
import service.CrudRepositoryService;
import service.ServiceRepository;

/**
 * Created by Andrey on 23.01.2019.
 */
public class AbstractSkillController extends Controller {
    protected CrudRepository<Skill, Long> skills(){
        CrudRepositoryService skillService = ServiceRepository.getINSTANCE().getService(CrudRepositoryService.class);
        CrudRepository<Skill, Long> skillRepository = skillService.getRepository(Skill.class);
        return skillRepository;
    }

    protected Skill getById(long id){
        return skills().getDao(id);
    }

    protected void updateSkill(Skill skill){
        skills().updateDao(skill);
    }

    protected void deleteSkillById(long id){
        Skill skill = getById(id);
        skills().deleteDao(skill);
    }
}
