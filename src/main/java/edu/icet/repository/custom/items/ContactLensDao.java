package edu.icet.repository.custom.items;

import edu.icet.model.entity.item.contact_lens.ContactLensEntity;
import edu.icet.repository.SuperDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContactLensDao extends SuperDao, JpaRepository<ContactLensEntity,Integer> {
    @Query(value = "select * from `contact_lens` where item_id= :id",nativeQuery = true)
    ContactLensEntity findByItemId(@Param("id") Integer id);
}
