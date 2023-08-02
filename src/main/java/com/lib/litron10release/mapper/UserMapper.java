package com.lib.litron10release.mapper;

import com.lib.litron10release.dto.UserDTO;
import com.lib.litron10release.entity.UserLiter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    UserDTO mapperDTO(UserLiter user);
}
