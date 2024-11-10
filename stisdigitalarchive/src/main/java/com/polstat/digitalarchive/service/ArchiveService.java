package com.polstat.digitalarchive.service;

import com.polstat.digitalarchive.dto.ArchiveDto;
import java.util.List;

public interface ArchiveService {
    ArchiveDto createArchive(ArchiveDto archiveDto);
    List<ArchiveDto> getAllArchives();
    ArchiveDto getArchiveById(Long id);
    List<ArchiveDto> searchArchivesByTitle(String title);
    void deleteArchive(Long id);
}
