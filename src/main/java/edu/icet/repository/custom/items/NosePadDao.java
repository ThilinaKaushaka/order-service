package edu.icet.repository.custom.items;

import edu.icet.model.entity.item.nose_pad.NosePadEntity;
import edu.icet.repository.SuperDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NosePadDao extends SuperDao, JpaRepository<NosePadEntity,Integer> {
    @Query(value = "select * from  `nose_pad` where item_id= :id",nativeQuery = true)
    NosePadEntity findByItemId(@Param("id") Integer id);
}
