
package edu.cibertec.curso.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ErrorDTO {
    
    private String status;
    private String error;
    private String menssage;
    
}
