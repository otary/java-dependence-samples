package cn.chenzw.dependence.mapstruct.mapper;

import cn.chenzw.dependence.mapstruct.dto.UserDTO;
import cn.chenzw.dependence.mapstruct.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User toEntity(UserDTO userDTO);

    UserDTO toDTO(User user);
    
}
