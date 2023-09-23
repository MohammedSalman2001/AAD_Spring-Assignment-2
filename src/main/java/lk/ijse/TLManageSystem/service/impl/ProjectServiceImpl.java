package lk.ijse.TLManageSystem.service.impl;

import lk.ijse.TLManageSystem.dto.ProjectDTO;
import lk.ijse.TLManageSystem.entity.Project;
import lk.ijse.TLManageSystem.entity.TechLead;
import lk.ijse.TLManageSystem.repo.ProjectRepo;
import lk.ijse.TLManageSystem.repo.TechLeadRepo;
import lk.ijse.TLManageSystem.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TechLeadRepo techLeadRepo;
    @Override
    public void saveProject(ProjectDTO dto) {
        if (!projectRepo.existsById(dto.getProjectId())){
            TechLead techLead = mapper.map(techLeadRepo.getTechLeadsById(dto.getTechLeadID()), TechLead.class);
            if (techLead!=null){
                projectRepo.save( mapper.map(dto, Project.class));
            }else {
                throw new RuntimeException("Customer Not Found");
            }
        }else {
            throw new RuntimeException("Order Already Exist");
        }
    }

    @Override
    public void deleteProject(String id) {
        if (projectRepo.existsById(id)){
            projectRepo.deleteById(id);
        }else {
            throw new RuntimeException("Customer Already Exist");
        }
    }

    @Override
    public void updateProject(ProjectDTO dto) {
        if (projectRepo.existsById(dto.getProjectId())) {
            projectRepo.save(mapper.map(dto,Project.class));
        }else {
            throw new RuntimeException("Customer NOT Exist...!");
        }
    }

    @Override
    public ProjectDTO searchProject(String id) {
        if (projectRepo.existsById(id)){
            Project project = projectRepo.findById(id).get();
            return mapper.map(project,ProjectDTO.class);
        }else {
            throw new RuntimeException("Customer NOT Exist...!");
        }
    }

    @Override
    public List<ProjectDTO> getAllProject() {
        List<Project> all = projectRepo.findAll();
        return mapper.map(all,new TypeToken<List<ProjectDTO>>(){}.getType());
    }
}
