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

import com.trabalhodev.model.Jogador;
import com.trabalhodev.repository.JogadorRepository;

@RestController
@RequestMapping("/api/jogadores")
public class JogadorController {

    private final JogadorRepository jogadorRepository;

    public JogadorController(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    @GetMapping
    public List<Jogador> listarTodos() {
        return jogadorRepository.findAll();
    }

    @PostMapping
    public Jogador criarJogador(@RequestBody Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    @GetMapping("/{id}")
    public Jogador buscarPorId(@PathVariable Long id) {
        return jogadorRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Jogador atualizarJogador(@PathVariable Long id, @RequestBody Jogador jogadorAtualizado) {
        return jogadorRepository.findById(id).map(jogador -> {
            jogador.setNome(jogadorAtualizado.getNome());
            jogador.setEmail(jogadorAtualizado.getEmail());
            jogador.setDataNasc(jogadorAtualizado.getDataNasc());
            return jogadorRepository.save(jogador);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletarJogador(@PathVariable Long id) {
        jogadorRepository.deleteById(id);
    }
}
