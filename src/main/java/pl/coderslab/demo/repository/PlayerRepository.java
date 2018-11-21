package pl.coderslab.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.demo.domain.Player;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {

    @Query("select u from Player u where u.name like %?1%")
    List<Player> findByFirstnameInclude(String name);
    Player findById (long id);
    Player findTopByGuidAndNameAndIp(String guid,String name, String ip);
    List<Player> findAllByBannedIsTrue();
}
