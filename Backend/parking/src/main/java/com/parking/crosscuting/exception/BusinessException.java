package com.parking.crosscuting.exception;

import com.parking.crosscuting.messagescatalog.MessagesEnum;

public class BusinessException extends RuntimeException {

    private final MessagesEnum messagesEnum;
    private static final long serialVersionUID = 1L;

    public BusinessException(final MessagesEnum messagesEnum) {
        super(messagesEnum.getContent());
        this.messagesEnum = messagesEnum;
    }

    public MessagesEnum getMessagesEnum() {
        return messagesEnum;
    }
}