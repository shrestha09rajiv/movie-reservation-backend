package com.cotiviti.moviereservation.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlPermissionDto {
    private Long id;
    private Long roleId;
    private String title;
    private String icon;
    private String link;
}
