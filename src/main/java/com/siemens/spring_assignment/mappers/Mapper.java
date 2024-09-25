package com.siemens.spring_assignment.mappers;

public interface Mapper<A,B> {

    B toDto(A a);

    A toEntity(B b);

}
