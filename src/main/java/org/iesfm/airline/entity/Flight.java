package org.iesfm.airline.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Positive
    @NotNull
    private int id;
    @NotBlank
    private String origin;
    @NotBlank
    private String destination;
    @JsonFormat(pattern = "yyyy/MM/dd")
    @NotNull
    private Date date;

}
