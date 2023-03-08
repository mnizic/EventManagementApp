package com.nizic.app.eventmanagment.repos;

import com.nizic.app.eventmanagment.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
