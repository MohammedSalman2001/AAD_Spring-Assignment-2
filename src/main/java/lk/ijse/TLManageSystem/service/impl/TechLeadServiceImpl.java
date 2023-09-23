package lk.ijse.TLManageSystem.service.impl;

import lk.ijse.TLManageSystem.dto.TechLeadDTO;
import lk.ijse.TLManageSystem.entity.TechLead;
import lk.ijse.TLManageSystem.repo.TechLeadRepo;
import lk.ijse.TLManageSystem.service.TechLeadService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class TechLeadServiceImpl implements TechLeadService {

    @Autowired
    private TechLeadRepo techLeadRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveTechLead(TechLeadDTO dto) {
        if (!techLeadRepo.existsById(dto.getTLId())){
            techLeadRepo.save( mapper.map(dto, TechLead.class));
        }else {
            throw new RuntimeException("Customer Already Exist...!");
        }
    }

    @Override
    public void deleteTechLead(String id) {
        if (techLeadRepo.existsById(id)){
            techLeadRepo.deleteById(id);
        }else {
            throw new RuntimeException("Customer Already Exist...!");
        }
    }

    @Override
    public void updateTechLead(TechLeadDTO dto) {
        if (techLeadRepo.existsById(dto.getTLId())) {
            techLeadRepo.save(mapper.map(dto,TechLead.class));
        }else {
            throw new RuntimeException("Customer NOT Exist...!");
        }
    }

    @Override
    public TechLeadDTO searchTechLead(String id) {
        if (techLeadRepo.existsById(id)){
            TechLead techLead = techLeadRepo.findById(id).get();
            return mapper.map(techLead,TechLeadDTO.class);
        }else {
            throw new RuntimeException("Customer NOT Exist...!");
        }
    }

    @Override
    public List<TechLeadDTO> getAllTechLead() {
        List<TechLead> all = techLeadRepo.findAll();
        return mapper.map(all,new TypeToken<List<TechLeadDTO>>(){}.getType());
    }
}
