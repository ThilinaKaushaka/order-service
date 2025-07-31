package edu.icet.repository.custom.items;

import edu.icet.model.entity.item.lens_cleaner.LensCleanerEntity;
import edu.icet.repository.SuperDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LensCleanerDao extends SuperDao, JpaRepository<LensCleanerEntity,Integer> {
    @Query(value = "select * from `lens_cleaner` where item_id= :id",nativeQuery = true)
    LensCleanerEntity findByItemId(@Param("id") Integer id);
}
