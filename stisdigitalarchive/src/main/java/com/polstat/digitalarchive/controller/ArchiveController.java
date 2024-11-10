package com.polstat.digitalarchive.controller;

import com.polstat.digitalarchive.dto.ArchiveDto;
import com.polstat.digitalarchive.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/archives")
public class ArchiveController {
    @Autowired
    private ArchiveService archiveService;

    @PostMapping("/create")
    public ResponseEntity<ArchiveDto> createArchive(@RequestBody @Valid ArchiveDto archiveDto) {
        ArchiveDto createdArchive = archiveService.createArchive(archiveDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdArchive);
    }

    @GetMapping
    public ResponseEntity<List<ArchiveDto>> getAllArchives() {
        List<ArchiveDto> archives = archiveService.getAllArchives();
        return ResponseEntity.ok(archives);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArchiveDto> getArchiveById(@PathVariable Long id) {
        ArchiveDto archive = archiveService.getArchiveById(id);
        return ResponseEntity.ok(archive);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ArchiveDto>> searchArchives(@RequestParam String keyword) {
        List<ArchiveDto> archives = archiveService.searchArchivesByTitle(keyword);
        return ResponseEntity.ok(archives);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArchive(@PathVariable Long id) {
        archiveService.deleteArchive(id);
        return ResponseEntity.ok("Archive deleted successfully");
    }
}
