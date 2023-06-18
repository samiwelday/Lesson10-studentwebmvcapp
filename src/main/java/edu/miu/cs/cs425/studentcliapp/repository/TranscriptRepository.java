package edu.miu.cs.cs425.studentcliapp.repository;


import edu.miu.cs.cs425.studentcliapp.model.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranscriptRepository extends JpaRepository<Transcript, Long> {
}
