package com.careerhigh.backend.persist.repository;

import com.careerhigh.backend.persist.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}