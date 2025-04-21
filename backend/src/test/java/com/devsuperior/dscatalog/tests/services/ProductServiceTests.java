package com.devsuperior.dscatalog.tests.services;

import com.devsuperior.dscatalog.repositories.ProductRepository; // Corrigido o pacote
import com.devsuperior.dscatalog.services.ProductService; // Corrigido o pacote
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ProductServiceTests {
    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository repository;

    private long existingId;

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;
    }

    @Test
    public void deleteShouldDoNothingWhenIdExists() {
        long existingId = 1L;
        Assertions.assertDoesNotThrow(() -> {
            service.delete(existingId);
        });
        Mockito.verify(repository, Mockito.times(1)).deleteById(existingId);
    }
}