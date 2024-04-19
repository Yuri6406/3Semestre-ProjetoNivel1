package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Principal {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {

		// Pessoa Juridica

		String caminhoJ = "arquivoJuridico.txt";

		List<PessoaJuridica> lista = new ArrayList<PessoaJuridica>();
		lista.add(new PessoaJuridica(1, "Yuri", "41992258899"));
		lista.add(new PessoaJuridica(2, "Ariane", "433445258899"));
		lista.add(new PessoaJuridica(3, "Isabelly", "9927258899"));
		lista.add(new PessoaJuridica(4, "belly", "9999999999"));

		boolean gravou = PessoaJuridicaRepo.persistir(caminhoJ, lista);

		List<PessoaJuridica> obj = (List<PessoaJuridica>) PessoaJuridicaRepo.recuperar(caminhoJ);

		for (PessoaJuridica pessoaJuridica : obj) {
			System.out.println(pessoaJuridica);
		}

		// metodos PJ - CRUD

		PessoaJuridica p1 = new PessoaJuridica(10, "Yuri", "4242424");
		PessoaJuridica p2 = new PessoaJuridica(11, "Ariane", "111111");
		PessoaJuridica p3 = new PessoaJuridica(12, "Isabelly", "222222");

		PessoaJuridicaRepo repo = new PessoaJuridicaRepo();
		repo.inserirPessoaVazio(10, p1, p2, p3);
		repo.adicionarPessoa(2, p1, p2);
		repo.alterar(new PessoaJuridica(12, "atualizou", "50"));
		repo.obterTodos();

		// Pessoa Fisica

		String caminhoF = "arquivoPesF.txt";

		List<PessoaFisica> listaF = new ArrayList<PessoaFisica>();
		listaF.add(new PessoaFisica(4, "Yuri", "41992258899", 11));
		listaF.add(new PessoaFisica(5, "Ariane", "433445258899", 29));
		listaF.add(new PessoaFisica(6, "Isabelly", "9927258899", 28));

		boolean gravouf = PessoaFisicaRepo.persistir(caminhoF, listaF);

		List<PessoaFisica> objF = (List<PessoaFisica>) PessoaFisicaRepo.recuperar(caminhoF);

		for (PessoaFisica pessoaFisica : objF) {
			System.out.println(pessoaFisica);
		}

		// metodos PF - CRUD

		PessoaFisica p4 = new PessoaFisica(10, "Yuri", "4242424",29);
		PessoaFisica p5 = new PessoaFisica(11, "Ariane", "111111",28);
		PessoaFisica p6 = new PessoaFisica(12, "Isabelly", "222222",27);

		PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
		repo1.inserirPessoaVazio(12, p4, p5, p6);
		repo1.adicionarPessoa(2, p4, p5);
		repo1.alterar(new PessoaFisica(12, "atualizou", "50",4));
		repo1.excluir(p5);
		repo1.obterTodos();

	}
}
