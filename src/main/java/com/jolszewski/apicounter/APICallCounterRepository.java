package com.jolszewski.apicounter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface APICallCounterRepository extends JpaRepository<APICallCounter, String> {

}
