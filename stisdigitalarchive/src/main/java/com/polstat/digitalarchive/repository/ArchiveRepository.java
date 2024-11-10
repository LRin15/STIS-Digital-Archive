package com.polstat.digitalarchive.repository;

import com.polstat.digitalarchive.entity.Archive;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ArchiveRepository extends JpaRepository<Archive, Long> {
    List<Archive> findByTitleContainingIgnoreCase(String title);
}

