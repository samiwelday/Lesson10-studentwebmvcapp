package edu.miu.cs.cs425.studentcliapp.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transcripts")
public class Transcript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transcriptId;
    private String degreeTitle;
    @OneToOne(mappedBy = "transcript")
    private Student student;

//    public Transcript(String degreeTitle) {
//        this.degreeTitle = degreeTitle;
//    }
//
//    public Transcript() {
//    }

}
