package lk.ijse.TLManageSystem.repo;


import lk.ijse.TLManageSystem.entity.TechLead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechLeadRepo extends JpaRepository<TechLead,String> {
    TechLead getTechLeadsById(String id);
}
