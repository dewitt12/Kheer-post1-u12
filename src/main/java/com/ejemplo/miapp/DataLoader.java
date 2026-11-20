package com.ejemplo.miapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/** Carga datos de ejemplo solo si la tabla esta vacia (util para las capturas). */
@Component
public class DataLoader implements CommandLineRunner {

    private final ProductoRepository repository;

    public DataLoader(ProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            repository.save(new Producto("Laptop", "Tecnologia", 2500000.0));
            repository.save(new Producto("Mouse", "Tecnologia", 45000.0));
            repository.save(new Producto("Cuaderno", "Papeleria", 8000.0));
        }
    }
}
