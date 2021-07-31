package br.edu.infnet.bootalunoapp.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import br.edu.infnet.bootalunoapp.modelo.Aluno;
import br.edu.infnet.bootalunoapp.modelo.Turma;
import br.edu.infnet.bootalunoapp.repository.AlunoRepository;
import br.edu.infnet.bootalunoapp.repository.TurmaRepository;

public class InscricaoServiceTest {

	@Test
	public void alunoDeveriaEstarInscritoEmTurma() {
		TurmaRepository turmaRepo = Mockito.mock(TurmaRepository.class);
		AlunoRepository alunoRepo = Mockito.mock(AlunoRepository.class);
		
		InscricaoService service = new InscricaoService(alunoRepo, turmaRepo);
		
		Aluno aluno = new Aluno();
		Turma turma = new Turma();
		service.inscrever(aluno, turma);
		
		Mockito.verify(turmaRepo).save(turma);
		Mockito.verify(alunoRepo).save(aluno);
		
		//assertEquals(turma.getAlunos().get(0), aluno);
	}

}
