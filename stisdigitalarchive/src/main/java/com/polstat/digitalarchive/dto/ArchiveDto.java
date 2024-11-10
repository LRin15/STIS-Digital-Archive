package com.polstat.digitalarchive.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArchiveDto {
    private Long id;

    @NotEmpty(message = "Title is required")
    private String title;

    private String description;

    @NotNull(message = "Archive type is required")
    private String archiveType;

    @NotNull(message = "fileUrl is required")
    private String fileUrl;

    private Date createdAt;
}
