package com.autocompleton.autocompleton.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InboundWord {

    @NotNull(message = "prefix must not be null.")
    @NotEmpty(message = "prefix must not be empty.")
    private String prefix;
    @NotNull(message = "words must not be null.")
    @NotEmpty(message = "words must not be empty.")
    private String words;
}
