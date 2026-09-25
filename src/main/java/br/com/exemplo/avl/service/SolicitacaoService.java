package br.com.exemplo.avl.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.com.exemplo.avl.model.Solicitacao;
import br.com.exemplo.avl.repository.SolicitacaoRepository;

@Service
public class SolicitacaoService {
    private final SolicitacaoRepository repository;

    public SolicitacaoService(SolicitacaoRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(int numero, String descricao) {
        repository.inserir(new Solicitacao(numero, descricao));
    }

    public Solicitacao buscar(int numero) {
        return repository.buscar(numero);
    }

    public boolean remover(int numero) {
        return repository.remover(numero);
    }

    public List<Solicitacao> listar() {
        return repository.listar();
    }

    public String exibirArvore() {
        return repository.exibirArvore();
    }
}
