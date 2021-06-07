package com.cotiviti.moviereservation.user.service;
import com.cotiviti.moviereservation.user.dto.UrlPermissionDto;

import java.util.List;

public interface UrlPermissionService {
    List<UrlPermissionDto> getByRoleId();
}
