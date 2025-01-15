package hub.forum.api.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record TopicoRequestDTO(
        @NotBlank String titulo,
        @NotBlank String mensagem,
        @NotBlank String status,
        @NotBlank String autor,
        @NotBlank String curso
) {}
