package br.edu.infnet.bootalunoapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.bootalunoapp.modelo.Aluno;
import br.edu.infnet.bootalunoapp.repository.AlunoRepository;

@SpringBootTest
public class AlunoServiceTest {

	@InjectMocks
	private AlunoService service;
	
	@Mock
	private AlunoRepository repo;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void deveriaSalvarUmAlunoExemplo2() {
		Aluno aluno = new Aluno();
		aluno.setId(1);
		Mockito.when(repo.save(Mockito.any(Aluno.class))).thenReturn(new Aluno());
		
		Aluno alunoSalvo = service.salvar(new Aluno());
		
		assertNotNull(alunoSalvo);
		assertEquals(new Integer(1), aluno.getId());
	}
	
	@Test
	public void deveriaRertornar2Alunos() {
		Aluno aluno1 = new Aluno();
		aluno1.setId(1);
		
		Aluno aluno2 = new Aluno();
		aluno2.setId(2);
		
		Mockito.doReturn(Arrays.asList(aluno1, aluno2)).when(repo).findAll();
		
		java.util.List<Aluno> alunos = service.listAll();
		
		//Mockito.verify(repo).save(Mockito.any());
		
		Assert.assertEquals(2, alunos.size());
	}
	
	/*@Test
	public void deveriaSalvarUmAluno() {
		
		//arrange
		AlunoRepository repo = Mockito.mock(AlunoRepository.class);
		AlunoService service = new AlunoService(repo);
		Aluno aluno = new Aluno();
		aluno.setId(1);
		Mockito.when(repo.save(Mockito.any(Aluno.class))).thenReturn(new Aluno());
		
		//act
		Aluno alunoSalvo = service.salvar(new Aluno());
		
		//verifique
		assertNotNull(alunoSalvo);
		assertEquals(new Integer(1), aluno.getId());
		
	}*/

}
