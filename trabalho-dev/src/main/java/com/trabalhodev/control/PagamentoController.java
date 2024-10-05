package com.trabalhodev.control;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalhodev.model.Pagamento;
import com.trabalhodev.repository.PagamentoRepository;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    private final PagamentoRepository pagamentoRepository;

    public PagamentoController(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    @GetMapping
    public List<Pagamento> listarTodos() {
        return pagamentoRepository.findAll();
    }

    @PostMapping
    public Pagamento criarPagamento(@RequestBody Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    @GetMapping("/{id}")
    public Pagamento buscarPorId(@PathVariable Long id) {
        return pagamentoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Pagamento atualizarPagamento(@PathVariable Long id, @RequestBody Pagamento pagamentoAtualizado) {
        return pagamentoRepository.findById(id).map(pagamento -> {
            pagamento.setAno(pagamentoAtualizado.getAno());
            pagamento.setMes(pagamentoAtualizado.getMes());
            pagamento.setValor(pagamentoAtualizado.getValor());
            pagamento.setJogador(pagamentoAtualizado.getJogador());
            return pagamentoRepository.save(pagamento);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletarPagamento(@PathVariable Long id) {
        pagamentoRepository.deleteById(id);
    }
}
