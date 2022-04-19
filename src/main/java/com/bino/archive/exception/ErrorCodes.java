package com.bino.archive.exception;

import lombok.Getter;

@Getter
public enum ErrorCodes {
    ARMOIRE_NOT_FOUND(1000),
    ARMOIRE_NOT_VALID(1001),
    CLASSEUR_NOT_FOUND(2000),
    CLASSEUR_NOT_VALID(2001),
    DOCUMENT_NOT_FOUND(3000),
    DOCUMENT_NOT_VALID(3001),
    RANGER_NOT_FOUND(4000),
    RANGER_NOT_VALID(4001),
    UTILISATEUR_NOT_VALID(5000),
    UTILISATEUR_NOT_FOUND(5001);

    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }


}
