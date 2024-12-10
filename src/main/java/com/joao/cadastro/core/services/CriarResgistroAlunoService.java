package com.joao.cadastro.core.services;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.entities.Curso;
import com.joao.cadastro.core.entities.DocumentoMatricula;
import com.joao.cadastro.core.usecases.AlunoExistenteUseCaseImpl;
import  com.joao.cadastro.repository.AlunoRepository;
import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.core.usecases.CriarRegistroAlunoUseCase;
import com.joao.cadastro.repository.CursoRepository;
import com.joao.cadastro.repository.DocumentoMatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CriarResgistroAlunoService extends AlunoExistenteUseCaseImpl implements CriarRegistroAlunoUseCase {
    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    DocumentoMatriculaRepository documentoMatriculaRepository;

    @Autowired
    CursoRepository cursoRepository;

    @Transactional
    public String criarRegistroAluno(AlunoDto alunoDto) {
     /*   if(checarDocumentoMatricula(Integer.parseInt(alunoDto.getNumeroDocumentoMatricula()))){
            String nomeCurso = alunoDto.getNome_curso();
            Curso cursoRealizado = buscarCurso(nomeCurso);
            DocumentoMatricula documentoMatricula = criarRegistroMatricula(alunoDto.getNumeroDocumentoMatricula());

            Aluno aluno = new Aluno();
            aluno.setCurso(cursoRealizado);
            aluno.setNome(alunoDto.getNome_aluno());
            aluno.setDocumentoMatricula(documentoMatricula);

            alunoRepository.save(aluno);
            return "Aluno " + aluno.getNome() +" inserido";
        }
        return "Numero de matricula ja sendo utilizado";*/

        if(checarDocumentoMatricula(alunoDto.getNumeroDocumentoMatricula())){
            String nomeCurso = alunoDto.getNome_curso();
            Curso cursoRealizado = buscarCurso(nomeCurso);
            DocumentoMatricula documentoMatricula = criarRegistroMatricula(alunoDto.getNumeroDocumentoMatricula());

            Aluno aluno = new Aluno();
            aluno.setCurso(cursoRealizado);
            aluno.setNome(alunoDto.getNome_aluno());
            aluno.setDocumentoMatricula(documentoMatricula);

            alunoRepository.save(aluno);
            return "Aluno " + aluno.getNome() +" inserido";
        }
        return "Numero de matricula ja sendo utilizado";

    }

    //buscar uma entidade curso na base de dados com base no nome
    private Curso buscarCurso(String nomeCurso){
        return cursoRepository.findCursoByNome(nomeCurso);
    }

    //cria uma entidade matricula
    private DocumentoMatricula criarRegistroMatricula(int numeroMatricula){
        DocumentoMatricula documentoMatricula = new DocumentoMatricula();
        documentoMatricula.setNumeroDocumento(numeroMatricula);
        System.out.println(documentoMatricula.getNumeroDocumento());
        return documentoMatricula;
    }

}
