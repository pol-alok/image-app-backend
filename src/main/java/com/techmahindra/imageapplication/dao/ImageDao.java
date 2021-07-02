package com.techmahindra.imageapplication.dao;

import com.techmahindra.imageapplication.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageDao extends JpaRepository<Image, Long> {

    Optional<Image> findById(long id);

}
