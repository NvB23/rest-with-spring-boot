package com.naum.rest_with_spring_boot.models;

import java.util.concurrent.atomic.AtomicLong;

public record Greeting(AtomicLong id, String content) {
}
