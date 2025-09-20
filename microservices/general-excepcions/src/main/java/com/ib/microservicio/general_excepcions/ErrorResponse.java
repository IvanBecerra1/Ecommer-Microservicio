package com.ib.microservicio.general_excepcions;

import java.util.Map;

public record ErrorResponse(Map<String, String> error) {
    
}
