package it.uniroma3.silphSiw.service;

import it.uniroma3.silphSiw.model.RequestForm;
import it.uniroma3.silphSiw.repository.RequestFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RequestFormService {

    @Autowired
    private RequestFormRepository requestFormRepository;

    @Transactional
    public RequestForm insertForm(RequestForm form) {
        return requestFormRepository.save(form);
    }

    @Transactional
    public List<RequestForm> findAllRequests(){
        return (List<RequestForm>) requestFormRepository.findAll();
    }

    public RequestForm findById(Long id) {
        return requestFormRepository.findById(id).get();
    }
}
