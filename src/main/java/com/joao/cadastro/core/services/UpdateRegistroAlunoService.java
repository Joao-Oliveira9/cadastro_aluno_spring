package com.joao.cadastro.core.services;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.core.entities.Curso;
import com.joao.cadastro.core.usecases.UpdateUseCase;
import com.joao.cadastro.repository.AlunoRepository;
import com.joao.cadastro.repository.CursoRepository;
import com.joao.cadastro.repository.DocumentoMatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateRegistroAlunoService extends BaseService implements UpdateUseCase {
    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    DocumentoMatriculaRepository documentoMatriculaRepository;

    @Autowired
    CursoRepository cursoRepository;

    @Transactional
    public String atualizarRegistroAluno(AlunoDto alunoDto) {
        System.out.println("Valor " + alunoDto.getNome_aluno());
        if(!checarDocumentoMatricula(alunoDto.getNumeroDocumentoMatricula())){
            String nomeCurso = alunoDto.getNome_curso();
            Curso cursoRealizado = buscarCurso(nomeCurso);
            Aluno aluno = documentoMatriculaRepository.findBynumeroDocumento(alunoDto.getNumeroDocumentoMatricula()).getAluno();
            aluno.setCurso(cursoRealizado);
            aluno.setNome(alunoDto.getNome_aluno());
            alunoRepository.save(aluno);
            return "Aluno " + alunoDto.getNome_aluno() + " teve informações modificado";
        }
        return "Não existe aluno com esse registro de matricula";
    }
}
