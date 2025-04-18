package aide.service.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import aide.service.entity.Aide;

public interface AideDao extends JpaRepository<Aide, Long> {

}
