package edu.icet.repository.custom;

import edu.icet.model.entity.item.ItemEntity;
import edu.icet.repository.SuperDao;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemDao extends SuperDao, JpaRepository<ItemEntity,Integer> {
    @Query(value = "SELECT id from item ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Integer findLastId();

    @Modifying
    @Transactional
    @Query(value = "UPDATE item SET qty = qty - :qty WHERE id = :id", nativeQuery = true)
    void minItemQty(@Param("id") Integer id, @Param("qty") Integer qty);

}
