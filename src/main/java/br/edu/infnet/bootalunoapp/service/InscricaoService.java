package br.edu.infnet.bootalunoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.bootalunoapp.modelo.Aluno;
import br.edu.infnet.bootalunoapp.modelo.Turma;
import br.edu.infnet.bootalunoapp.repository.AlunoRepository;
import br.edu.infnet.bootalunoapp.repository.TurmaRepository;

@Service
public class InscricaoService {
	
	private AlunoRepository alunoRepo;
	private TurmaRepository turmaRepo;

	@Autowired	
	public InscricaoService(AlunoRepository alunoRepo, TurmaRepository turmaRepo) {
		//turma.getAlunos().add(aluno);
		this.alunoRepo = alunoRepo;
		this.turmaRepo = turmaRepo;
		
	}
	
	public void inscrever(Aluno aluno, Turma turma) {
		alunoRepo.save(aluno);
		turmaRepo.save(turma);
	}
}
