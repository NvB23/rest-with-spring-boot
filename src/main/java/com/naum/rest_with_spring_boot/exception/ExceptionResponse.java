package com.naum.rest_with_spring_boot.exeption;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {
}
