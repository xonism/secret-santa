package xonism.secretrandomizer.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

public record SecretSantaRequest(
        @NotEmpty(message = "Participants are required")
        @Size(min = 3, message = "At least 3 participants are required")
        @Valid
        List<Participant> participants
) {
    public record Participant(@NotBlank(message = "Name is required")
                              String name,
                              @NotBlank(message = "Email address is required")
                              String emailAddress
    ) {
    }
}
