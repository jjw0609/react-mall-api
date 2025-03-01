package org.jjw.reactmallapi.repository;

import org.jjw.reactmallapi.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
