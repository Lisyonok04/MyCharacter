package ru.mycharacter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.mycharacter.api.controllers.CharacterApi;
import ru.mycharacter.api.models.CharacterProfileResponse;
import ru.mycharacter.service.CharacterService;

@RestController
@RequiredArgsConstructor
public class CharacterController implements CharacterApi {

    private final CharacterService characterService;

    @Override
    public ResponseEntity<CharacterProfileResponse> getCharacterById(Long id) {
        return ResponseEntity.ok(characterService.getCharacterProfile(id));
    }
}