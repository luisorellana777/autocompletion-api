package com.autocompletion.autocompletion.service;

import com.autocompletion.autocompletion.exception.GeneralException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

@Service
@Log4j2
public class AutocompletionService {

    @Value("${thread-number}")
    private Integer threadQuantity;

    public List<String> recommends(String prefix, String words) {

        try {

            List<String> wordsList = Arrays.asList(words.split("\\s+"));

            ForkJoinPool customThreadPool = new ForkJoinPool(threadQuantity);
            List<String> collectWords = customThreadPool.submit(
                    () -> wordsList
                            .parallelStream()
                            .filter(word -> word.toLowerCase().contains(prefix.toLowerCase())))
                    .get()
                    .collect(Collectors.toList());

            log.info("Recommended Words -> {} \nFor Prefix -> {}", collectWords, prefix);

            return collectWords;

        } catch (Exception e) {
            throw new GeneralException(e.getMessage());
        }

    }
}
