package com.Connectly.connection_service.Service;

import com.Connectly.connection_service.Entity.Person;
import com.Connectly.connection_service.Repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConnectionService {
    private final PersonRepository personRepository;

    public List<Person> getFirstDegreeConnections(Long userId){
        log.info("Getting 1st degree connections for userid: {}", userId);

        return personRepository.getFirstDegreeConnections(userId);
    }
}
