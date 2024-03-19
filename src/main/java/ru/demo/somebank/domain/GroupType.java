package ru.demo.somebank.domain;

import lombok.RequiredArgsConstructor;

/**
 * Вид группового владения счётом
 */
@RequiredArgsConstructor
public enum GroupType {

    FAMILY("Семейный тип счёта");

    private final String description;
}
