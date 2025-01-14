package hub.forum.api.controller;

import hub.forum.api.dto.TopicoRequestDTO;
import hub.forum.api.dto.TopicoResponseDTO;
import hub.forum.api.model.Topico;
import hub.forum.api.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository topicoRepository;

    public TopicoController(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    @GetMapping
    public List<TopicoResponseDTO> listar() {
        return topicoRepository.findAll().stream()
                .map(TopicoResponseDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoResponseDTO> detalhar(@PathVariable Long id) {
        return topicoRepository.findById(id)
                .map(topico -> ResponseEntity.ok(new TopicoResponseDTO(topico)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid TopicoRequestDTO dto) {
        if (topicoRepository.existsByTituloAndMensagem(dto.titulo(), dto.mensagem())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Tópico com o mesmo título e mensagem já existe.");
        }
        Topico topico = new Topico();
        topico.setTitulo(dto.titulo());
        topico.setMensagem(dto.mensagem());
        topico.setStatus(dto.status());
        topico.setAutor(dto.autor());
        topico.setCurso(dto.curso());

        Topico novoTopico = topicoRepository.save(topico);
        return ResponseEntity.status(HttpStatus.CREATED).body(new TopicoResponseDTO(novoTopico));
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody @Valid TopicoRequestDTO dto) {
        return topicoRepository.findById(id).map(existingTopico -> {
            if (topicoRepository.existsByTituloAndMensagem(dto.titulo(), dto.mensagem()) &&
                    (!existingTopico.getTitulo().equals(dto.titulo()) || !existingTopico.getMensagem().equals(dto.mensagem()))) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Outro tópico com o mesmo título e mensagem já existe.");
            }

            existingTopico.setTitulo(dto.titulo());
            existingTopico.setMensagem(dto.mensagem());
            existingTopico.setStatus(dto.status());
            existingTopico.setAutor(dto.autor());
            existingTopico.setCurso(dto.curso());

            Topico atualizado = topicoRepository.save(existingTopico);
            return ResponseEntity.ok(new TopicoResponseDTO(atualizado));
        }).orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> remover(@PathVariable Long id) {
        return topicoRepository.findById(id).map(existingTopico -> {
            topicoRepository.delete(existingTopico);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
