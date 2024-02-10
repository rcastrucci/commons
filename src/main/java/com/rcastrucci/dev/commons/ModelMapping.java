package com.rcastrucci.dev.commons;

import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

public class ModelMapping {

    public final ModelMapper mapper;

    /**
     * Constructor
     * @param mapper an instance of ModelMapper
     */
    public ModelMapping(ModelMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Method to map an entire list of source to a specific list of target
     * @param source a list with the source type to map the object from
     * @param targetClass class with the type target to map the object to
     * @return a List of objects with a target type
     * @param <SOURCE> A list with the source type
     * @param <TARGET> A class with the target type
     */
    public <SOURCE, TARGET> List<TARGET> mapList(List<SOURCE> source, Class<TARGET> targetClass) {
        return source
                .stream()
                .map(element -> mapper.map(element, targetClass))
                .collect(Collectors.toList());
    }

    /**
     * Method to map an object to another type of object
     * @param source the source object to map from
     * @param destinationType a class with the target object to map to
     * @return an object mapped to the target type
     * @param <TARGET> Destination class with the target type
     */
    public <TARGET> TARGET map(Object source, Class<TARGET> destinationType) {
        return mapper.map(source, destinationType);
    }

}