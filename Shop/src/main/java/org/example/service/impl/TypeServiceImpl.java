package org.example.service.impl;

import org.example.mapper.TypeMapper;
import org.example.pojo.Type;
import org.example.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("type_service_impl")
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeMapper  typeMapper;


    @Override
    public List<Type> selectAll() {
        return typeMapper.selectByExample(null);
    }
}
