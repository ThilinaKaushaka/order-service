package edu.icet.repository.custom.items;

import edu.icet.model.entity.item.frame.FrameEntity;
import edu.icet.repository.SuperDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FrameDao extends SuperDao, JpaRepository<FrameEntity,Integer> {
    @Query(value = "select * from `frame` where item_id= :id",nativeQuery = true)
    FrameEntity findByItemId(@Param("id") Integer id);
}
