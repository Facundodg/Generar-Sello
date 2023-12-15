package com.example.demo.Repocitori;

import com.example.demo.Model.Entity.Sello;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SelloRepocitory extends JpaRepository<Sello, Long> {
}
