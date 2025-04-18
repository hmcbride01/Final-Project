package aide.service.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import aide.service.entity.Service;

public interface ServiceDao extends JpaRepository<Service, Long> {

}
