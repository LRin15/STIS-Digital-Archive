package com.polstat.digitalarchive.service;

import com.polstat.digitalarchive.dto.ArchiveDto;
import com.polstat.digitalarchive.entity.Archive;
import com.polstat.digitalarchive.mapper.ArchiveMapper;
import com.polstat.digitalarchive.repository.ArchiveRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArchiveServiceImpl implements ArchiveService {
    @Autowired
    private ArchiveRepository archiveRepository;

    @Override
    public ArchiveDto createArchive(ArchiveDto archiveDto) {
        Archive archive = archiveRepository.save(ArchiveMapper.mapToArchive(archiveDto));
        return ArchiveMapper.mapToArchiveDto(archive);
    }

    @Override
    public List<ArchiveDto> getAllArchives() {
        List<Archive> archives = archiveRepository.findAll();
        return archives.stream()
                .map(ArchiveMapper::mapToArchiveDto)
                .collect(Collectors.toList());
    }

    @Override
    public ArchiveDto getArchiveById(Long id) {
        Archive archive = archiveRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Archive not found with id: " + id));
        return ArchiveMapper.mapToArchiveDto(archive);
    }

    @Override
    public List<ArchiveDto> searchArchivesByTitle(String title) {
        List<Archive> archives = archiveRepository.findByTitleContainingIgnoreCase(title);
        return archives.stream()
                .map(ArchiveMapper::mapToArchiveDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteArchive(Long id) {
        archiveRepository.deleteById(id);
    }
}
