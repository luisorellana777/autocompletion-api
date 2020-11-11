package com.autocompletion.autocompletion.controller;

import com.autocompletion.autocompletion.domain.InboundWord;
import com.autocompletion.autocompletion.service.AutocompletionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
public class AutocompletionController {

    private final AutocompletionService autocompletionService;

    @PutMapping("/recommended-words")
    public ResponseEntity<List<String>> recommendedWords(@RequestBody @Valid InboundWord inboundWord) {

        String prefix = inboundWord.getPrefix();
        String words = inboundWord.getWords();

        List<String> recommends = this.autocompletionService.recommends(prefix, words);

        return new ResponseEntity<>(recommends, HttpStatus.ACCEPTED);
    }
}
