package com.dscatalog.services;


import com.dscatalog.DTOs.CategoryDTO;
import com.dscatalog.entities.Category;
import com.dscatalog.expections.DatabaseException;
import com.dscatalog.expections.ResourceNotFoundException;
import com.dscatalog.repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CategoryService {


    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAllPaged(PageRequest pageRequest) {
        Page<Category> list = repository.findAll(pageRequest);
        return list.map(x -> new CategoryDTO(x));
    }
    @Transactional
    public CategoryDTO insert(com.dscatalog.DTOs.@Valid CategoryDTO dto) {
        Category entity = new Category();
        entity.setName(dto.getName());
        entity = repository.save(entity);
        return new CategoryDTO(entity);
    }
    @Transactional
    public CategoryDTO update(Long id, com.dscatalog.DTOs.@Valid CategoryDTO dto) {
        try {
            Category entity = repository.getReferenceById(id);
            entity.setName(dto.getName());
            entity = repository.save(entity);
            return new CategoryDTO(entity);
        }catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }

    }
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Category not found. Id: " + id);
        }
        try {
            repository.deleteById(id); // Exclui a entidade pelo repositório
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation - Cannot delete the category because it is associated with other entities");
        }
    }

}
