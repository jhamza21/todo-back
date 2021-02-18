package com.example.entities;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.validation.DateRange;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
//validate todo end date is greater than start date
@DateRange
public class Todo {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @NotBlank(message = "Title is a required field")
        private String title;
        private String description;
        @NotNull(message = "Start date is a required field")
        @JsonFormat(pattern="yyyy-MM-dd")
        private LocalDate startDate;
        @NotNull(message = "End date is a required field")
        @JsonFormat(pattern="yyyy-MM-dd")
        private LocalDate endDate;
        @NotNull(message = "Status is a required field")
        @Enumerated(EnumType.STRING)
        private TodoStatusType status;
    }


