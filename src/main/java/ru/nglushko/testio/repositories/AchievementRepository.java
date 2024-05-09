package ru.nglushko.testio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nglushko.testio.models.entity.Achievement;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement, Long> {
}