package pl.coderslab.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.demo.domain.Setings;


public interface SetingsRepository extends JpaRepository<Setings, Long> {

    Setings findById(long id);
}
