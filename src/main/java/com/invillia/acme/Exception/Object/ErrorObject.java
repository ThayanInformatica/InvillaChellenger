package com.invillia.acme.Exception.Object;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorObject {

    private final String message;
    private final String field;
    private final Object parameter;
}