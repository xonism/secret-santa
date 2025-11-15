package xonism.secretrandomizer.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import xonism.secretrandomizer.annotation.RestApiController;
import xonism.secretrandomizer.model.SecretSantaRequest;
import xonism.secretrandomizer.service.SecretSantaService;

@RequiredArgsConstructor
@RestApiController("/secret-santa")
public class SecretSantaController {

    private final SecretSantaService secretSantaService;

    @PostMapping
    public void randomize(@Valid @RequestBody SecretSantaRequest request) {
        secretSantaService.randomize(request);
    }
}
