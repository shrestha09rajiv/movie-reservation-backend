package com.cotiviti.moviereservation.user.mapper;

import com.cotiviti.moviereservation.user.domain.UrlPermission;
import com.cotiviti.moviereservation.user.dto.UrlPermissionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UrlPermissionMapper {
    UrlPermissionMapper INSTANCE = Mappers.getMapper(UrlPermissionMapper.class);

    UrlPermissionDto toDto(UrlPermission payment);

    List<UrlPermissionDto> toDto(List<UrlPermission> payments);
}
