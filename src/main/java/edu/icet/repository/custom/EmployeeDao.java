package edu.icet.repository.custom;

import edu.icet.model.entity.employee.EmployeeEntity;
import edu.icet.repository.SuperDao;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface EmployeeDao extends SuperDao, JpaRepository<EmployeeEntity,Integer> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE employee set is_disable=true, resignation_date= :resignationDate WHERE id= :id",nativeQuery = true)
    void disableEmployee(@Param("id")Integer id, @Param("resignationDate")Date resignationDate);
}
