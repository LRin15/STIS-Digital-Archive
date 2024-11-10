package com.polstat.digitalarchive.mapper;

import com.polstat.digitalarchive.dto.ArchiveDto;
import com.polstat.digitalarchive.entity.Archive;

public class ArchiveMapper {
    public static Archive mapToArchive(ArchiveDto archiveDto) {
        return Archive.builder()
                .id(archiveDto.getId())
                .title(archiveDto.getTitle())
                .description(archiveDto.getDescription())
                .archiveType(archiveDto.getArchiveType())
                .fileUrl(archiveDto.getFileUrl())
                .createdAt(archiveDto.getCreatedAt())
                .build();
    }

    public static ArchiveDto mapToArchiveDto(Archive archive) {
        return ArchiveDto.builder()
                .id(archive.getId())
                .title(archive.getTitle())
                .description(archive.getDescription())
                .archiveType(archive.getArchiveType())
                .fileUrl(archive.getFileUrl())
                .createdAt(archive.getCreatedAt())
                .build();
    }
}
