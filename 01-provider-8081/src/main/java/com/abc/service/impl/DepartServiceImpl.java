package com.abc.service.impl;

import com.abc.bean.Depart;
import com.abc.repository.DepartRepository;
import com.abc.service.DepartService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class DepartServiceImpl implements DepartService {
    @Resource
    DepartRepository departRepository;
    @Override
    public boolean save(Depart depart) {
        Depart save = departRepository.save(depart);
        return save != null;
    }
}
