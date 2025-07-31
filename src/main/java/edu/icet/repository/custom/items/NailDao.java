package edu.icet.repository.custom.items;

import edu.icet.model.entity.item.nail.NailEntity;
import edu.icet.repository.SuperDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NailDao extends SuperDao, JpaRepository<NailEntity,Integer> {
    @Query(value = "select * from `nails` where item_id= :id",nativeQuery = true)
    NailEntity findByItemId(@Param("id") Integer id);
}
