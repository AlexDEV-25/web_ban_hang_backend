package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.app.entity.Thumbnail;

@RepositoryRestResource(path = "thumbnails")
public interface ThumbnailRepository extends JpaRepository<Thumbnail, Long> {

}
