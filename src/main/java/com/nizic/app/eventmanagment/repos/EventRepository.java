package com.nizic.app.eventmanagment.repos;

import com.nizic.app.eventmanagment.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    public Long countById(Long id);

    @Query("SELECT e FROM Event e WHERE e.name LIKE %?1%")
    public List<Event> findAll(String keyword);

    @Query("SELECT e FROM Event e WHERE e.from BETWEEN :startDateTime AND :endDateTime")
    public List<Event> findByFromBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);

    @Query("SELECT e FROM Event e WHERE e.to BETWEEN :startDateTime AND :endDateTime")
    public List<Event> findByToBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);

    @Query("SELECT e FROM Event e WHERE e.freeEntry = :freeEntry")
    public List<Event> findByFreeEntry(Boolean freeEntry);
}
