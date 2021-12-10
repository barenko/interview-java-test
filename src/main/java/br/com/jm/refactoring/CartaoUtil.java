//https://www.devmedia.com.br/artigo-java-magazine-46-refactoring-da-teoria-a-pratica/10169
package br.com.jm.refactoring;

import java.text.*;
import java.util.*;

public class CartaoUtil {
    public static final int VISA = 1;
    public static final int MASTERCARD = 2;
    public static final int AMEX = 3;
    public static final int DINERS = 4;
    public static final String CARTAO_OK = "Cartão válido";
    public static final String CARTAO_ERRO = "Cartão inválido";

    private boolean validarData(String validade) {
        Date dataValidade = null;
        try {
            dataValidade = new SimpleDateFormat("MM/yyyy").parse(validade);
        } catch (ParseException e) {
            return false;
        }

        Calendar calValidade = new GregorianCalendar();
        calValidade.setTime(dataValidade);

        // apenas mês e ano são utilizados na validação
        Calendar calTemp = new GregorianCalendar();
        Calendar calHoje = (GregorianCalendar) calValidade.clone();
        calHoje.set(Calendar.MONTH, calTemp.get(Calendar.MONTH));
        calHoje.set(Calendar.YEAR, calTemp.get(Calendar.YEAR));

        return calHoje.before(calValidade);
    }

    public String validar(int bandeira, String numero, String validade) {
        var formatado = numero.replaceAll("\\D", "");
        if (validarBandeira(bandeira, formatado) && validarData(validade) && validarDigitoVerificador(formatado)) {
            return CARTAO_OK;
        } else {
            return CARTAO_ERRO;
        }
    }

    private boolean validarBandeira(int bandeira, String formatado){
        return Bandeira.get(bandeira).isOk(formatado);
    }

    private boolean validarDigitoVerificador(String formatado) {
        // fórmula de LUHN (http://www.merriampark.com/anatomycc.htm)
        int soma = 0;
        int digito = 0;
        int somafim = 0;
        boolean multiplica = false;

        for (int i = formatado.length() - 1; i >= 0; i--) {
            digito = Integer.parseInt(formatado.substring(i, i + 1));
            if (multiplica) {
                somafim = digito * 2;
                if (somafim > 9) {
                    somafim -= 9;
                }
            } else {
                somafim = digito;
            }
            soma += somafim;
            multiplica = !multiplica;
        }
        return soma % 10 == 0;
    }
}