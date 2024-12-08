package com.joao.cadastro.core.services;

import com.joao.cadastro.core.entities.DocumentoMatricula;
import  com.joao.cadastro.repository.AlunoRepository;
import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.core.usecases.CriarRegistroAlunoUseCase;
import com.joao.cadastro.repository.DocumentoMatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CriarResgistroAlunoService implements CriarRegistroAlunoUseCase {
    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    DocumentoMatriculaRepository documentoMatriculaRepository;

    @Override
    //eu preciso criar tbm uma entidade DocumentoMatricula pra ser capaz de mapear o aluno corretamente
    public void criarRegistroAluno(Aluno aluno) {
        int numeroDocumento = aluno.getDocumentoMatricula().getNumeroDocumento();
        DocumentoMatricula documentoMatricula = new DocumentoMatricula();
        documentoMatricula.setNumeroDocumento(numeroDocumento);

        aluno.setDocumentoMatricula(documentoMatricula);
        alunoRepository.save(aluno);
    }
}
