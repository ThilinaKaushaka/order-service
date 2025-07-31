package edu.icet.repository.custom.items;

import edu.icet.model.entity.item.lens_cloth.LensClothEntity;
import edu.icet.repository.SuperDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LensClothDao extends SuperDao, JpaRepository<LensClothEntity,Integer> {
    @Query(value = "select * from `lens_cloth` where item_id= :id",nativeQuery = true)
    LensClothEntity findByItemId(@Param("id") Integer id);
}
