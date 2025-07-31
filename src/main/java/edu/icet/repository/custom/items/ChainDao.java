package edu.icet.repository.custom.items;

import edu.icet.model.entity.item.chain.ChainEntity;
import edu.icet.repository.SuperDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChainDao extends SuperDao, JpaRepository<ChainEntity,Integer> {
    @Query(value = "select * from `chain` where item_id= :id",nativeQuery = true)
    ChainEntity findByItemId(@Param("id") Integer id);
}
