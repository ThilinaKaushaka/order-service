package edu.icet.repository.custom.items;

import edu.icet.model.entity.item.lens.LensEntity;
import edu.icet.repository.SuperDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LensDao extends SuperDao, JpaRepository<LensEntity,Integer> {
    @Query(value = "select * from `lens` where item_id= :id",nativeQuery = true)
    LensEntity findByItemId(@Param("id") Integer id);
}
