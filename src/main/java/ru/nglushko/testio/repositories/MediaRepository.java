package ru.nglushko.testio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nglushko.testio.models.entity.Media;

public interface MediaRepository extends JpaRepository<Media, Long> {
}