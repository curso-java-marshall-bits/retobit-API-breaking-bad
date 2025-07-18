package dev.marshallBits.breakingBadApi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // TODO: Implementar manejo de CharacterNotFoundException
    // PISTA: Usar @ExceptionHandler(CharacterNotFoundException.class)
    // PISTA: Retornar ResponseEntity con status NOT_FOUND (404)
    @ExceptionHandler(CharacterNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleCharacterNotFound(CharacterNotFoundException ex) {
        // TODO: Crear un Map con la información del error
        // Incluir: timestamp, status, error, message
        throw new UnsupportedOperationException("¡Implementa este manejador de excepciones!");
    }

    // TODO: Implementar manejo de errores de validación
    // PISTA: Usar @ExceptionHandler(MethodArgumentNotValidException.class)
    // PISTA: Retornar ResponseEntity con status BAD_REQUEST (400)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {
        // TODO: Extraer los errores de validación y crear una respuesta apropiada
        // PISTA: Usar ex.getBindingResult().getFieldErrors()
        throw new UnsupportedOperationException("¡Implementa este manejador de excepciones!");
    }

    // ✅ IMPLEMENTADO: Manejo de errores generales
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralError(Exception ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.put("error", "Error interno del servidor");
        error.put("message", "Ha ocurrido un error inesperado");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    // Método auxiliar para crear respuestas de error consistentes
    private Map<String, Object> createErrorResponse(HttpStatus status, String error, String message) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", status.value());
        errorResponse.put("error", error);
        errorResponse.put("message", message);
        return errorResponse;
    }
}
