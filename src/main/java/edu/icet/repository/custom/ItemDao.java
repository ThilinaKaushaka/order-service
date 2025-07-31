package edu.icet.repository.custom;

import edu.icet.model.entity.item.ItemEntity;
import edu.icet.repository.SuperDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemDao extends SuperDao, JpaRepository<ItemEntity,Integer> {
    @Query(value ="SELECT id from item ORDER BY id DESC LIMIT 1" ,nativeQuery = true)
    Integer findLastId();

}
