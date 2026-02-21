// ContactRepository.java
package com.portfolio.portfolio_backend.repository;

import com.portfolio.portfolio_backend.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}