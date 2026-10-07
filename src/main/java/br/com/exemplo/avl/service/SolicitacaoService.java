package br.com.exemplo.avl.service;

import java.util.List;
import org.springframework.stereotype.Service;

import br.com.exemplo.avl.dto.ApiResponse;
import br.com.exemplo.avl.dto.SolicitacaoRequest;
import br.com.exemplo.avl.model.Solicitacao;
import br.com.exemplo.avl.repository.SolicitacaoRepository;

@Service
public class SolicitacaoService {
    private final SolicitacaoRepository repository;

    public SolicitacaoService(SolicitacaoRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(int numero, String solicitante, String descricao) {
        repository.inserir(new Solicitacao(numero, solicitante, descricao));
    }

    public Solicitacao buscar(int numero) {
        return repository.buscar(numero);
    }

    public ApiResponse alterarSolicitacao(int numero, SolicitacaoRequest request) {
        if (request.getSolicitante() == null || request.getSolicitante().trim().isEmpty()) {
            return new ApiResponse(false, "Informe o nome do solicitante.");
        }

        if (request.getDescricao() == null || request.getDescricao().trim().isEmpty()) {
            return new ApiResponse(false, "Informe a descrição da solicitação.");
        }

        boolean alterado = repository.alterar(numero, request.getSolicitante().trim(), request.getDescricao().trim());

        if (!alterado) {
            return new ApiResponse(false, "Solicitação não encontrada.");
        }

        return new ApiResponse(true, "Solicitação alterada com sucesso.");
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
