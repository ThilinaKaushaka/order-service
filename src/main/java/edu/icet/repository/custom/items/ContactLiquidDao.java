package edu.icet.repository.custom.items;

import edu.icet.model.entity.item.contact_liquid.ContactLiquidEntity;
import edu.icet.repository.SuperDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContactLiquidDao extends SuperDao, JpaRepository<ContactLiquidEntity,Integer> {
    @Query(value = "select * from `contact_liquid` where item_id= :id",nativeQuery = true)
    ContactLiquidEntity findByItemId(@Param("id") Integer id);
}
