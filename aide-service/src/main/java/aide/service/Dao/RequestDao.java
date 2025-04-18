package aide.service.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import aide.service.entity.Request;

public interface RequestDao extends JpaRepository<Request, Long> {

}
