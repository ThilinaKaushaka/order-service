package edu.icet.repository.custom.items;

import edu.icet.model.entity.item.box.BoxEntity;
import edu.icet.repository.SuperDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoxDao extends SuperDao, JpaRepository<BoxEntity,Integer> {
    @Query(value = "select * from `box` where item_id= :id",nativeQuery = true)
    BoxEntity findByItemId(@Param("id") Integer id);


}
