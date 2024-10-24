package com.Review.Reviews.repo;

import com.Review.Reviews.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Reviews,Long> {
    List<Reviews> findByProductId(Long productId);


}
