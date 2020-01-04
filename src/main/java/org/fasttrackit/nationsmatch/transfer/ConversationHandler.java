package org.fasttrackit.nationsmatch.transfer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ConversationHandler {
    private Long id;
    @NotBlank
    private String UserFirstName;
    @NotBlank
    private String UserLastName;
    @NotNull
    private LocalDate messageSentDate;
    private boolean sent;
    private boolean seen;
}
