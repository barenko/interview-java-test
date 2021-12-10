package br.com.jm.refactoring;

import java.util.function.Predicate;

enum Bandeira {
    VISA(CartaoUtil.VISA, formatado -> formatado.matches("^4(.{12}|.{15})$")),
    MASTERCARD(CartaoUtil.MASTERCARD, formatado -> formatado.matches("^5[1-5]\\d{14}$")),
    AMEX(CartaoUtil.AMEX, formatado -> formatado.matches("^37.{13}$")),
    DINERS(CartaoUtil.DINERS, formatado -> formatado.matches("^3(0[1-5].{11}|6.{12}|8.{12})")),
    NONE(0, f -> false);
    private Predicate<String> isOk;
    private int code;

    Bandeira(int code, Predicate<String> lambda) {
        this.code = code;
        this.isOk = lambda;
    }

    public boolean isOk(String cartao) {
        return isOk.test(cartao);
    }

    public static Bandeira get(int bandeira) {
        for (var b : Bandeira.values()) {
            if (b.code == bandeira) return b;
        }
        return NONE;
    }
}
