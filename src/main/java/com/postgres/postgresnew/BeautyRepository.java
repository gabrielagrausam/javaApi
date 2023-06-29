package com.postgres.postgresnew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeautyRepository extends JpaRepository<Beauty, Long>{
}
