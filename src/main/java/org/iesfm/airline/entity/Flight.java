package org.iesfm.airline.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    private int id;
    private String origin;
    private String destination;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date date;

}
