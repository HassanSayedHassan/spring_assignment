package com.siemens.spring_assignment.mappers.impl;

import com.siemens.spring_assignment.domains.dtos.TeacherDto;
import com.siemens.spring_assignment.domains.entities.TeacherEntity;
import com.siemens.spring_assignment.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapperImpl implements Mapper<TeacherEntity, TeacherDto> {

    private final ModelMapper modelMapper;

    public TeacherMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public TeacherDto toDto(TeacherEntity TeacherEntity) {
        return modelMapper.map(TeacherEntity, TeacherDto.class);
    }

    @Override
    public TeacherEntity toEntity(TeacherDto TeacherDto) {
        return modelMapper.map(TeacherDto, TeacherEntity.class);
    }
}
