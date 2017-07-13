package com.aliona.curscrawler.repository;

/**
 * Created by User on 12.07.2017.
 */
import com.aliona.curscrawler.entity.Curs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface CursRepository extends JpaRepository<Curs, Long> {


}
