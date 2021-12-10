package br.com.jr.refactoring;

import br.com.jm.refactoring.CartaoUtil;
import org.junit.Assert;
import org.junit.Test;

public class CartaoUtilTest {

    @Test
    public void testVisa(){
        CartaoUtil cartao = new CartaoUtil();
        Assert.assertEquals("Cartão válido", cartao.validar(CartaoUtil.VISA, "4567 4567 4567 4565", "03/2030"));
        Assert.assertEquals("Cartão inválido", cartao.validar(CartaoUtil.VISA, "4567 4567 4567 4563", "03/2030"));
    }

    @Test
    public void testMastercard(){
        CartaoUtil cartao = new CartaoUtil();
        Assert.assertEquals("Cartão válido", cartao.validar(CartaoUtil.MASTERCARD, "5567 4567 4567 4562", "03/2030"));
        Assert.assertEquals("Cartão inválido", cartao.validar(CartaoUtil.MASTERCARD, "5567 4567 4567 4564", "03/2030"));
        Assert.assertEquals("Cartão inválido", cartao.validar(CartaoUtil.MASTERCARD, "5567 4567 4567 4562", "03/2000"));
    }
}