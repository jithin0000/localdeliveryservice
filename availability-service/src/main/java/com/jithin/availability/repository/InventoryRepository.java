package com.jithin.availability.repository;

import com.jithin.availability.entity.Inventory;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends ElasticsearchRepository<Inventory,String> {

    List<Inventory> findByProductNameContaining(String name);
}
