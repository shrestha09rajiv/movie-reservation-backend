package com.cotiviti.moviereservation.user.mapper;

import com.cotiviti.moviereservation.user.domain.User;
import com.cotiviti.moviereservation.user.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toEntity(UserDto userDto);

    UserDto toDto(User user);

}
