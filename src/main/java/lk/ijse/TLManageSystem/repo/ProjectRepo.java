package lk.ijse.TLManageSystem.repo;


import lk.ijse.TLManageSystem.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, String> {
}
