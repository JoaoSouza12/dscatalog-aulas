package com.devsuperior.dscatalog.repositories;

import com.devsuperior.dscatalog.entities.Category; // Corrigido o pacote
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}