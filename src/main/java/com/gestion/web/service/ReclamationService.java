package com.gestion.web.service;

import com.gestion.web.repository.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ReclamationService {

    @Autowired
    ReclamationRepository reclamationRepository;
}
