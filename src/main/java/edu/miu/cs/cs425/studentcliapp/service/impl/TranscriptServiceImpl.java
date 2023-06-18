package edu.miu.cs.cs425.studentcliapp.service.impl;


import edu.miu.cs.cs425.studentcliapp.model.Transcript;
import edu.miu.cs.cs425.studentcliapp.repository.TranscriptRepository;
import edu.miu.cs.cs425.studentcliapp.service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranscriptServiceImpl implements TranscriptService {
    @Autowired
    private TranscriptRepository transcriptRepository;
    @Override
    public Transcript saveTranscript(Transcript newtranscript) {
        return transcriptRepository.save(newtranscript);
    }
}
