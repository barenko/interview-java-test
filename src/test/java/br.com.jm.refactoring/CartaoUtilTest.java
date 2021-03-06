package br.com.jm.refactoring;

import org.junit.Test;

public class CartaoUtilTest {
    CartaoUtil cartao = new CartaoUtil();

    @Test
    public void test(){
        System.out.println("In?cio do teste");
        System.out.println(cartao.validar(CartaoUtil.VISA, "4567 4567 4567 4565", "03/2030"));
        System.out.println(cartao.validar(CartaoUtil.VISA, "4567 4567 4567 4563", "03/2030"));
        System.out.println(cartao.validar(CartaoUtil.MASTERCARD, "5567 4567 4567 4562", "03/2030"));
        System.out.println(cartao.validar(CartaoUtil.MASTERCARD, "5567 4567 4567 4564", "03/2030"));
        System.out.println(cartao.validar(CartaoUtil.MASTERCARD, "5567 4567 4567 4562", "03/2000"));
        System.out.println("Fim do teste");
    }
}