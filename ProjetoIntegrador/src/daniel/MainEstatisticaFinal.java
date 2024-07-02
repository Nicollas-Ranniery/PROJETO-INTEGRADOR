package daniel;

import java.util.Scanner;

public class MainEstatisticaFinal {

    public static boolean cpfValido(String cpf) { //Função que Valida o CPF
        // Remover caracteres não numéricos:
        cpf = cpf.replaceAll("\\D", "");

        // Verificação se o cpf tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Transformar de String para Character
        // Criação de um vetor
        int[] cpfInt_Char = new int[11];
        // Pegar cada valor numérico da variável Ste armazenar em cada um dos 11 "espaços" do vetor
        for (int i = 0; i < 11; i++) {
            cpfInt_Char[i] = Character.getNumericValue(cpf.charAt(i));
        }

        // Verificação se todos os dígitos são iguais:
        if (cpfInt_Char[0] == cpfInt_Char[1] && cpfInt_Char[2] == cpfInt_Char[3] && cpfInt_Char[3] == cpfInt_Char[4] && cpfInt_Char[4] == cpfInt_Char[5] && cpfInt_Char[5] == cpfInt_Char[6] && cpfInt_Char[6] == cpfInt_Char[7] && cpfInt_Char[7] == cpfInt_Char[8] && cpfInt_Char[8] == cpfInt_Char[9] && cpfInt_Char[9] == cpfInt_Char[10]) {
            return false;
        }
        // VERIFICAÇÃO DO 1° DÍGITO
        //  Multiplicamos os 9 primeiros dígitos pela sequência decrescente de números de 10 à 2 e soma os resultados.
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += cpfInt_Char[i] * (10 - i);
        }
        //Multiplicamos o resultado por 10 e dividimos por 11 (O QUE NOS INTERESSA É O RESTO)
        int digito1 = (soma * 10) % 11;

        // VERIFICAÇÃO DO 2° DÍGITO
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += cpfInt_Char[i] * (11 - i);
        }
        int digito2 = (soma * 10) % 11;

        // Retorno - CPF válido:
        return cpfInt_Char[9] == digito1 && cpfInt_Char[10] == digito2;
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in); //Interações do Menu
        Scanner scanner = new Scanner(System.in); //Dados do Cliente
        String cpf;

        // Declaração dos Arrays com os valores de cada area
        String[][] PlateiaA = { //Essa matriz é somente para visualização para o usuário.
                {"A01", "A02", "A03", "A04", "A05"},
                {"A06", "A07", "A08", "A09", "A10"},
                {"A11", "A12", "A13", "A14", "A15"},
                {"A16", "A17", "A18", "A19", "A20"},
                {"A21", "A22", "A23", "A24", "A25"}
        };
        int[][] PlateiaAocupacaoSessaoOzManha = {//Por meio dessa matriz, eu irei saber, qual está ocupada ou não.
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        int[][] PlateiaAocupacaoSessaoOzTarde = {//Por meio dessa matriz, eu irei saber, qual está ocupada ou não.
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        int[][] PlateiaAocupacaoSessaoOzNoite = {//Por meio dessa matriz, eu irei saber, qual está ocupada ou não.
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        int[][] PlateiaAocupacaoSessaoCisneManha = {//Por meio dessa matriz, eu irei saber, qual está ocupada ou não.
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        int[][] PlateiaAocupacaoSessaoCisneTarde = {//Por meio dessa matriz, eu irei saber, qual está ocupada ou não.
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        int[][] PlateiaAocupacaoSessaoCisneNoite = {//Por meio dessa matriz, eu irei saber, qual está ocupada ou não.
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        int[][] PlateiaAocupacaoSessaoRentManha = {//Por meio dessa matriz, eu irei saber, qual está ocupada ou não.
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        int[][] PlateiaAocupacaoSessaoRentTarde = {//Por meio dessa matriz, eu irei saber, qual está ocupada ou não.
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        int[][] PlateiaAocupacaoSessaoRentNoite = {//Por meio dessa matriz, eu irei saber, qual está ocupada ou não.
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };


        String[][] PlateiaB = {
                {"B01", "B02", "B03", "B04", "B05", "B06", "B07", "B08", "B09", "B10"},
                {"B11", "B12", "B13", "B14", "B15", "B16", "B17", "B18", "B19", "B20"},
                {"B21", "B22", "B23", "B24", "B25", "B26", "B27", "B28", "B29", "B30"},
                {"B31", "B32", "B33", "B34", "B35", "B36", "B37", "B38", "B39", "B40"},
                {"B41", "B42", "B43", "B44", "B45", "B46", "B47", "B48", "B49", "B50"},
                {"B51", "B52", "B53", "B54", "B55", "B56", "B57", "B58", "B59", "B60"},
                {"B61", "B62", "B63", "B64", "B65", "B66", "B67", "B68", "B69", "B70"},
                {"B71", "B72", "B73", "B74", "B75", "B76", "B77", "B78", "B79", "B80"},
                {"B81", "B82", "B83", "B84", "B85", "B86", "B87", "B88", "B89", "B90"},
                {"B91", "B92", "B93", "B94", "B95", "B96", "B97", "B98", "B99", "B100"}
        };
        int[][] PlateiaBocupacaoSessaoOzManha = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] PlateiaBocupacaoSessaoOzTarde = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] PlateiaBocupacaoSessaoOzNoite = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] PlateiaBocupacaoSessaoCisneManha = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] PlateiaBocupacaoSessaoCisneTarde = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] PlateiaBocupacaoSessaoCisneNoite = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] PlateiaBocupacaoSessaoRentManha = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] PlateiaBocupacaoSessaoRentTarde = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] PlateiaBocupacaoSessaoRentNoite = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        String[][] BalcaoNobre = {
                {"N01", "N02", "N03", "N04", "N05", "N06", "N07", "N08", "N09", "N10"},
                {"N11", "N12", "N13", "N14", "N15", "N16", "N17", "N18", "N19", "N20"},
                {"N21", "N22", "N23", "N24", "N25", "N26", "N27", "N28", "N29", "N30"},
                {"N31", "N32", "N33", "N34", "N35", "N36", "N37", "N38", "N39", "N40"},
                {"N41", "N42", "N43", "N44", "N45", "N46", "N47", "N48", "N49", "N50"},
        };
        int[][] BalcaoNobreOcupacaoSessaoOzManha = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] BalcaoNobreOcupacaoSessaoOzTarde = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] BalcaoNobreOcupacaoSessaoOzNoite = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] BalcaoNobreOcupacaoSessaoCisneManha = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] BalcaoNobreOcupacaoSessaoCisneTarde = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] BalcaoNobreOcupacaoSessaoCisneNoite = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] BalcaoNobreOcupacaoSessaoRentManha = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] BalcaoNobreOcupacaoSessaoRentTarde = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] BalcaoNobreOcupacaoSessaoRentNoite = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        String[][] Camarotes = {
                {"CM1_01", "CM1_02", "CM1_03", "CM1_04", "CM1_05", "CM1_06", "CM1_07", "CM1_08", "CM1_09", "CM1_10"}, //Camarote 01
                {"CM2_01", "CM2_02", "CM2_03", "CM2_04", "CM2_05", "CM2_06", "CM2_07", "CM2_08", "CM2_09", "CM2_10"}, //Camarote 02
                {"CM3_01", "CM3_02", "CM3_03", "CM3_04", "CM3_05", "CM3_06", "CM3_07", "CM3_08", "CM3_09", "CM3_10"}, //Camarote 03
                {"CM4_01", "CM4_02", "CM4_03", "CM4_04", "CM4_05", "CM4_06", "CM4_07", "CM4_08", "CM4_09", "CM4_10"}, //Camarote 04
                {"CM5_01", "CM5_02", "CM5_03", "CM5_04", "CM5_05", "CM5_06", "CM5_07", "CM5_08", "CM5_09", "CM5_10"}, //Camarote 05
        };
        int[][] CamarotesOcupacaoSessaoOzManha = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] CamarotesOcupacaoSessaoOzTarde = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] CamarotesOcupacaoSessaoOzNoite = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] CamarotesOcupacaoSessaoCisneManha = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] CamarotesOcupacaoSessaoCisneTarde = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] CamarotesOcupacaoSessaoCisneNoite = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] CamarotesOcupacaoSessaoRentManha = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] CamarotesOcupacaoSessaoRentTarde = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] CamarotesOcupacaoSessaoRentNoite = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };


        String[][] Frisas = {
                {"FR1_01", "FR1_02", "FR1_03", "FR1_04", "FR1_05"}, //Frisa 01
                {"FR2_01", "FR2_02", "FR2_03", "FR2_04", "FR2_05"}, //Frisa 02
                {"FR3_01", "FR3_02", "FR3_03", "FR3_04", "FR3_05"}, //Frisa 03
                {"FR4_01", "FR4_02", "FR4_03", "FR4_04", "FR4_05"}, //Frisa 04
                {"FR5_01", "FR5_02", "FR5_03", "FR5_04", "FR5_05"}, //Frisa 05
                {"FR6_01", "FR6_02", "FR6_03", "FR6_04", "FR6_05"}, //Frisa 06
        };
        int[][] FrisasOcupacaoSessaoOzManha = {//Por meio dessa matriz, eu irei saber, qual está ocupada ou não.
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        int[][] FrisasOcupacaoSessaoOzTarde = {//Por meio dessa matriz, eu irei saber, qual está ocupada ou não.
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        int[][] FrisasOcupacaoSessaoOzNoite = {//Por meio dessa matriz, eu irei saber, qual está ocupada ou não.
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        int[][] FrisasOcupacaoSessaoCisneManha = {//Por meio dessa matriz, eu irei saber, qual está ocupada ou não.
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        int[][] FrisasOcupacaoSessaoCisneTarde = {//Por meio dessa matriz, eu irei saber, qual está ocupada ou não.
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        int[][] FrisasOcupacaoSessaoCisneNoite = {//Por meio dessa matriz, eu irei saber, qual está ocupada ou não.
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        int[][] FrisasOcupacaoSessaoRentManha = {//Por meio dessa matriz, eu irei saber, qual está ocupada ou não.
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        int[][] FrisasOcupacaoSessaoRentTarde = {//Por meio dessa matriz, eu irei saber, qual está ocupada ou não.
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        int[][] FrisasOcupacaoSessaoRentNoite = {//Por meio dessa matriz, eu irei saber, qual está ocupada ou não.
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };

        String[][] tabelaGeral = {
                {"Ana Silva", "80492969973", "O Mágico de Oz", "Manhã", "1", "A22"},
                {"Bruno Henrique", "48430663118", "Lago dos Cisnes", "Tarde", "2", "B23"},
                {"Gabriella Pio Lima", "80907307795", "Rent!", "Noite", "3", "CM2_01"},
                {"Gabriel Machado", "92671397119", "O Mágico de Oz", "Noite", "4", "FR1_04"},
                {"Daniel de Souza", "72120278717", "O Mágico de Oz", "Tarde", "1", "A11"},
                {"Nicollas Ranniery", "73997403724", "Rent!", "Manhã", "2", "B01"},
                {"Gabriel Pereira", "66881765720", "O Mágico de Oz", "Noite", "1", "A16"},
                {"Helena Fernandes", "44998625071", "Rent!", "Tarde", "4", "FR3_02"},
                {"Igor Gomes", "95343285880", "O Mágico de Oz", "Manhã", "1", "A05"},
                {"Julia Martins", "76982656098", "Rent!", "Manhã", "3", "CM1_10"},
                {"Lucas Azevedo", "04308003474", "Rent!", "Tarde", "1", "A24"},
                {"Mariana Santos", "48365804204", "Rent!", "Noite", "2", "B90"},
                {"Nicolas Oliveira", "02411501404", "O Mágico de Oz", "Manhã", "5", "N05"},
                {"Olivia Ribeiro", "16199029666", "Lago dos Cisnes", "Tarde", "5" ,"N10"},
                {"Paulo Barros", "33127128665", "O Mágico de Oz", "Noite", "5", "N50"},
                {"Queila Cardoso", "16687832310", "Rent!", "Noite", "1" ,"A08"},
                {"Rafael Pinto", "54201742008", "Rent!", "Tarde", "3", "CM5_02"},
                {"Sofia Ferreira", "01919892230", "Rent!", "Manhã", "4", "FR1_03"},
                {"Thiago Duarte", "86350702085", "Rent!", "Manhã", "1", "A12"},
                {"Ursula Batista", "90414038410", "Lago dos Cisnes", "Noite", "5", "N33"},
                {"Victor Nunes", "03762414467", "O Mágico de Oz", "Manhã", "5" ,"N41"},
                {"Wagner Moreira", "50740662392", "Rent!", "Noite", "2", "B28"},
                {"Ximena Almeida", "13213278033", "O Mágico de Oz", "Tarde", "2", "B09"},
                {"Yuri Mendes", "10183609727", "Rent!", "Manhã", "5", "N22"},
                {"Zoe Vieira", "60634105973", "O Mágico de Oz", "Manhã", "5", "N23"}
        }; //Irá armazenar Nome, CPF, Nome da Peça, Turno, Area, poltrona.
        String[] VendaCliente = new String[6];
        int v = 0; //Iteração para esse vetor VendaCliente.
        boolean rodarAplicacao = true;
        int linhaTabelaGeral = 0;


        boolean continuarAtendimento = true;

        while (continuarAtendimento) {

            System.out.print("\n> Olá! Para darmos início ao atendimento, nos diga seu nome por favor: \n");
            String nomeCliente = scanner.nextLine();
            VendaCliente[v] = nomeCliente;
            v++; //Iteração do indice 0 para o indice 1.

            System.out.printf("\n> %s, seja bem vindo(a) ao Teatro ABC!\n", nomeCliente.toUpperCase());

            System.out.printf("""
                    ______________________________________
                    |         Menu de Operações          |
                    |___________________________________ |
                    | Operação 1 - Comprar Ingresso      |
                    | Operação 2 - Imprimir Ingresso     |
                    | Operação 3 - Mostrar Estatística   |
                    | Operação 4 - Encerrar o Sistema    |
                    |____________________________________|
                    > Digite o número da operação que você quer fazer, %s:
                    """, nomeCliente.toUpperCase());
            // input -> variável para ler entradas como String.
            String input = ler.nextLine();
            // A entrada é convertida para inteiro
            // OBS -> trim() -> Usado para não deixar linhas em branco antes ou após uma entrada de dados
            int operacao = Integer.parseInt(input.trim());


            switch (operacao) {
                case 1:
                    System.out.println("\n<< OPERAÇÃO 1 - COMPRA DE INGRESSO >>");

                    boolean cpfInvalido = true;
                    while (cpfInvalido) {
                        System.out.println("> Informe o seu CPF: ");
                        cpf = scanner.nextLine();

                        if (cpfValido(cpf)) {
                            System.out.println("> CPF válido!\n");
                            VendaCliente[v] = cpf;
                            v++;
                            cpfInvalido = false;
                        } else {
                            System.out.println("> CPF inválido!\n");
                        }
                    }

                    boolean verificacaoPeca = true;
                    String peca = "";
                    while (verificacaoPeca) {
                        System.out.printf("""                                                    
                                > %s, qual é a peça que você quer assistir?
                                _____________________________________
                                |          Peças em Cartaz          |
                                |___________________________________|
                                | 1 - O Mágico de Oz                |
                                | 2 - Lago dos Cisnes               |
                                | 3 - Rent!                         |
                                |___________________________________|
                                > Digite o número da peça:
                                """, nomeCliente.toUpperCase());
                        peca = scanner.nextLine();
                        int numeroPeca = Integer.parseInt(peca.trim());

                        switch (numeroPeca) {
                            case 1:
                                verificacaoPeca = false;
                                VendaCliente[v] = "O Mágico de Oz";
                                peca = VendaCliente[v];
                                v++;
                                break;

                            case 2:
                                verificacaoPeca = false;
                                VendaCliente[v] = "Lago dos Cisnes";
                                peca = VendaCliente[v];
                                v++;
                                break;

                            case 3:
                                verificacaoPeca = false;
                                VendaCliente[v] = "Rent!";
                                peca = VendaCliente[v];
                                v++;
                                break;

                            default:
                                System.out.println("> Opção inválida");
                                System.out.println("> Digite novamente: ");
                        }

                    }

                    boolean verificacaoSessao = true;
                    while (verificacaoSessao) {
                        //IF AQUI - PARA ARMAZENAR VARIÁVEIS PARA A ESTATÍSTICA
                        if (peca.equalsIgnoreCase("O Mágico de Oz")) {

                            System.out.printf("""

                                    > Certo %s, agora escolha a sessão da peça.
                                    _____________________________________
                                    |              Sessões              |
                                    |___________________________________|
                                    | Sessão 1 - Manhã                  |
                                    | Sessão 2 - Tarde                  |
                                    | Sessão 3 - Noite                  |
                                    |___________________________________|
                                    > Digite o número da sessão escolhida:
                                    """, nomeCliente.toUpperCase());
                            input = scanner.nextLine();
                            int sessaoOz = Integer.parseInt(input.trim());
                            boolean VerificaSessaoOz = true;

                            while (VerificaSessaoOz) { //Verifica se foi escolhido as opções de 1 à 3.
                                switch (sessaoOz) {
                                    case 1:
                                        VendaCliente[v] = "Manhã";
                                        v++;
                                        VerificaSessaoOz = false;
                                        break;

                                    case 2:
                                        VendaCliente[v] = "Tarde";
                                        v++;
                                        VerificaSessaoOz = false;
                                        break;

                                    case 3:
                                        VendaCliente[v] = "Noite";
                                        v++;
                                        VerificaSessaoOz = false;
                                        break;

                                    default:
                                        System.out.println("Opção Inválida! Tente novamente:");
                                        input = scanner.nextLine();
                                        sessaoOz = Integer.parseInt(input.trim());
                                        break;
                                }
                            }

                            // TEMOS 3 SESSOES -> sessaoOz; sessaoCisne e sessaoRent. Uma para cada peça.

                            //Pergunta para o usuário qual área ele deseja.
                            System.out.print("""
                                    __________________________________
                                    |       Área       |    Valor    |
                                    |__________________|_____________|
                                    | 1 - Plateia A    |  R$ 40,00   |
                                    | 2 - Plateia B    |  R$ 60,00   |
                                    | 3 - Camarote     |  R$ 80,00   |
                                    | 4 - Frisa        |  R$120,00   |
                                    | 5 - Balcão Nobre |  R$250,00   |
                                    |__________________|_____________|
                                    > Digite o número da área escolhida:
                                    """);

                            String AreaEscolhida = scanner.nextLine();
                            int SwitchescolhaArea = Integer.parseInt(AreaEscolhida.trim());
                            boolean VerificaAreaEscolhida = true;

                            while (VerificaAreaEscolhida) { //Verifica se a opção digitada pelo usuário está dentre as escolhidas.

                                switch (SwitchescolhaArea) {
                                    case 1, 2, 3, 4, 5:
                                        VendaCliente[v] = AreaEscolhida;
                                        v++;
                                        VerificaAreaEscolhida = false;
                                        break;

                                    default:
                                        System.out.println("Opção Inválida! Tente novamente: ");
                                        AreaEscolhida = scanner.nextLine();
                                        SwitchescolhaArea = Integer.parseInt(AreaEscolhida.trim());
                                        break;
                                }

                            }

                            /*int escolhaArea = Integer.parseInt(VendaCliente[4]); //Area escolhida pelo usuário*/
                            int escolhaArea = SwitchescolhaArea;

                            switch (escolhaArea) { //Switch case para exibir qual área o cliente escolheu
                                case 1: // Plateia A
                                    for (String[] linha : PlateiaA) {
                                        for (String elemento : linha) {
                                            System.out.printf("%-4s  ", elemento);
                                        }
                                        System.out.println();
                                    }
                                    break;

                                case 2: //Plateia B
                                    for (String[] linha : PlateiaB) {
                                        for (String elemento : linha) {
                                            System.out.printf("%-4s  ", elemento);
                                        }
                                        System.out.println();
                                    }
                                    break;

                                case 3: //Camarotes
                                    for (String[] linha : Camarotes) {
                                        for (String elemento : linha) {
                                            System.out.printf("%-4s  ", elemento);
                                        }
                                        System.out.println();
                                    }
                                    break;

                                case 4: //Frisas
                                    for (String[] linha : Frisas) {
                                        for (String elemento : linha) {
                                            System.out.printf("%-4s  ", elemento);
                                        }
                                        System.out.println();
                                    }
                                    break;

                                case 5: //Balcão Nobre
                                    for (String[] linha : BalcaoNobre) {
                                        for (String elemento : linha) {
                                            System.out.printf("%-4s  ", elemento);
                                        }
                                        System.out.println();
                                    }
                                    break;
                            }


                            //A validação abaixo verifica se a poltrona está ocupada.
                            //SwitchEscolhaArea --> Area escolhida pelo usuário
                            //SessaoRent --> Armazena qual turno eslhido pelo usuário.
                            boolean verificaOcupacaoPoltrona = true;
                            while (verificaOcupacaoPoltrona) {

                                System.out.println("> Escolha a poltrona: ");
                                String poltronaEscolhida = scanner.nextLine();

                                switch (sessaoOz) {

                                    case 1: //Manhã
                                        if (SwitchescolhaArea == 1) { //Plateia A - Manhã
                                            for (int i = 0; i < PlateiaA.length; i++) {
                                                for (int j = 0; j < PlateiaA[i].length; j++) {
                                                    if (PlateiaA[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (PlateiaAocupacaoSessaoOzManha[i][j] != 1) {
                                                            PlateiaAocupacaoSessaoOzManha[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 2) { //Plateia B - Manhã
                                            for (int i = 0; i < PlateiaB.length; i++) {
                                                for (int j = 0; j < PlateiaB[i].length; j++) {
                                                    if (PlateiaB[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (PlateiaBocupacaoSessaoOzManha[i][j] != 1) {
                                                            PlateiaBocupacaoSessaoOzManha[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida;
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 3) { //Camarotes - Manhã
                                            for (int i = 0; i < Camarotes.length; i++) {
                                                for (int j = 0; j < Camarotes[i].length; j++) {
                                                    if (Camarotes[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (CamarotesOcupacaoSessaoOzManha[i][j] != 1) {
                                                            CamarotesOcupacaoSessaoOzManha[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 4) { //Frisas - Manhã
                                            for (int i = 0; i < Frisas.length; i++) {
                                                for (int j = 0; j < Frisas[i].length; j++) {
                                                    if (Frisas[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (FrisasOcupacaoSessaoOzManha[i][j] != 1) {
                                                            FrisasOcupacaoSessaoOzManha[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;

                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 5) { //Balcão Nobre - Manhã
                                            for (int i = 0; i < BalcaoNobre.length; i++) {
                                                for (int j = 0; j < BalcaoNobre[i].length; j++) {
                                                    if (BalcaoNobre[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (BalcaoNobreOcupacaoSessaoOzManha[i][j] != 1) {
                                                            BalcaoNobreOcupacaoSessaoOzManha[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;

                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        break;

                                    case 2: //Tarde
                                        if (SwitchescolhaArea == 1) { //Plateia A - Tarde
                                            for (int i = 0; i < PlateiaA.length; i++) {
                                                for (int j = 0; j < PlateiaA[i].length; j++) {
                                                    if (PlateiaA[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (PlateiaAocupacaoSessaoOzTarde[i][j] != 1) {
                                                            PlateiaAocupacaoSessaoOzTarde[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 2) { //Plateia B - Tarde
                                            for (int i = 0; i < PlateiaB.length; i++) {
                                                for (int j = 0; j < PlateiaB[i].length; j++) {
                                                    if (PlateiaB[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (PlateiaBocupacaoSessaoOzTarde[i][j] != 1) {
                                                            PlateiaBocupacaoSessaoOzTarde[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 3) { //Camarotes - Tarde
                                            for (int i = 0; i < Camarotes.length; i++) {
                                                for (int j = 0; j < Camarotes[i].length; j++) {
                                                    if (Camarotes[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (CamarotesOcupacaoSessaoOzTarde[i][j] != 1) {
                                                            CamarotesOcupacaoSessaoOzTarde[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 4) { //Frisas - Tarde
                                            for (int i = 0; i < Frisas.length; i++) {
                                                for (int j = 0; j < Frisas[i].length; j++) {
                                                    if (Frisas[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (FrisasOcupacaoSessaoOzTarde[i][j] != 1) {
                                                            FrisasOcupacaoSessaoOzTarde[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;

                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 5) { //Balcão Nobre - Tarde
                                            for (int i = 0; i < BalcaoNobre.length; i++) {
                                                for (int j = 0; j < BalcaoNobre[i].length; j++) {
                                                    if (BalcaoNobre[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (BalcaoNobreOcupacaoSessaoOzTarde[i][j] != 1) {
                                                            BalcaoNobreOcupacaoSessaoOzTarde[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;

                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        break;

                                    case 3: //Noite
                                        if (SwitchescolhaArea == 1) { //Plateia A - Noite
                                            for (int i = 0; i < PlateiaA.length; i++) {
                                                for (int j = 0; j < PlateiaA[i].length; j++) {
                                                    if (PlateiaA[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (PlateiaAocupacaoSessaoOzNoite[i][j] != 1) {
                                                            PlateiaAocupacaoSessaoOzNoite[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 2) { //Plateia B - Noite
                                            for (int i = 0; i < PlateiaB.length; i++) {
                                                for (int j = 0; j < PlateiaB[i].length; j++) {
                                                    if (PlateiaB[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (PlateiaBocupacaoSessaoOzNoite[i][j] != 1) {
                                                            PlateiaBocupacaoSessaoOzNoite[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 3) { //Camarotes - Noite
                                            for (int i = 0; i < Camarotes.length; i++) {
                                                for (int j = 0; j < Camarotes[i].length; j++) {
                                                    if (Camarotes[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (CamarotesOcupacaoSessaoOzNoite[i][j] != 1) {
                                                            CamarotesOcupacaoSessaoOzNoite[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 4) { //Frisas - Noite
                                            for (int i = 0; i < Frisas.length; i++) {
                                                for (int j = 0; j < Frisas[i].length; j++) {
                                                    if (Frisas[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (FrisasOcupacaoSessaoOzNoite[i][j] != 1) {
                                                            FrisasOcupacaoSessaoOzNoite[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;

                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 5) { //Balcão Nobre - Noite
                                            for (int i = 0; i < BalcaoNobre.length; i++) {
                                                for (int j = 0; j < BalcaoNobre[i].length; j++) {
                                                    if (BalcaoNobre[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (BalcaoNobreOcupacaoSessaoOzNoite[i][j] != 1) {
                                                            BalcaoNobreOcupacaoSessaoOzNoite[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;

                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                }
                            }

                            verificacaoSessao = false;

                        } else if (peca.equalsIgnoreCase("Lago dos Cisnes")) {
                            System.out.printf("""

                                    > Certo %s, agora escolha a sessão da peça.
                                    _____________________________________
                                    |              Sessões              |
                                    |___________________________________|
                                    | Sessão 1 - Manhã                  |
                                    | Sessão 2 - Tarde                  |
                                    | Sessão 3 - Noite                  |
                                    |___________________________________|
                                    > Digite o número da sessão escolhida:
                                    """, nomeCliente.toUpperCase());
                            input = scanner.nextLine();
                            int sessaoCisne = Integer.parseInt(input.trim());
                            boolean VerificaSessaoCisne = true;

                            while (VerificaSessaoCisne) { //Verificação do turno escolhido
                                switch (sessaoCisne) {
                                    case 1:
                                        VendaCliente[v] = "Manhã";
                                        v++;
                                        VerificaSessaoCisne = false;
                                        break;

                                    case 2:
                                        VendaCliente[v] = "Tarde";
                                        v++;
                                        VerificaSessaoCisne = false;
                                        break;

                                    case 3:
                                        VendaCliente[v] = "Noite";
                                        v++;
                                        VerificaSessaoCisne = false;
                                        break;

                                    default:
                                        System.out.println("Opção Inválida: Tente novamente.");
                                        input = scanner.nextLine();
                                        sessaoCisne = Integer.parseInt(input.trim());
                                        break;
                                }
                            }


                            System.out.print("""
                                    __________________________________
                                    |       Área       |    Valor    |
                                    |__________________|_____________|
                                    | 1 - Plateia A    |  R$ 40,00   |
                                    | 2 - Plateia B    |  R$ 60,00   |
                                    | 3 - Camarote     |  R$ 80,00   |
                                    | 4 - Frisa        |  R$120,00   |
                                    | 5 - Balcão Nobre |  R$250,00   |
                                    |__________________|_____________|                                              
                                    > Digite o número da área escolhida:
                                    """);

                            String AreaEscolhida = scanner.nextLine();
                            int SwitchescolhaArea = Integer.parseInt(AreaEscolhida.trim());
                            boolean VerificaAreaEscolhida = true;

                            while (VerificaAreaEscolhida) { //Verificação da Área escolhida.

                                switch (SwitchescolhaArea) {
                                    case 1, 2, 3, 4, 5:
                                        VendaCliente[v] = AreaEscolhida;
                                        v++;
                                        VerificaAreaEscolhida = false;
                                        break;

                                    default:
                                        System.out.println("Opção Inválida! Tente novamente: ");
                                        AreaEscolhida = scanner.nextLine();
                                        SwitchescolhaArea = Integer.parseInt(AreaEscolhida.trim());
                                        break;
                                }

                            }

                            /*int escolhaArea = Integer.parseInt(VendaCliente[4]); //Area escolhida pelo usuário*/
                            int escolhaArea = SwitchescolhaArea; //Area escolhida pelo usuário


                            switch (escolhaArea) { //Switch case para exibir qual área o cliente escolheu
                                case 1: // Plateia A
                                    for (String[] linha : PlateiaA) {
                                        for (String elemento : linha) {
                                            System.out.printf("%-4s  ", elemento);
                                        }
                                        System.out.println();
                                    }
                                    break;

                                case 2: //Plateia B
                                    for (String[] linha : PlateiaB) {
                                        for (String elemento : linha) {
                                            System.out.printf("%-4s  ", elemento);
                                        }
                                        System.out.println();
                                    }
                                    break;

                                case 3: //Camarotes
                                    for (String[] linha : Camarotes) {
                                        for (String elemento : linha) {
                                            System.out.printf("%-4s  ", elemento);
                                        }
                                        System.out.println();
                                    }
                                    break;

                                case 4: //Frisas
                                    for (String[] linha : Frisas) {
                                        for (String elemento : linha) {
                                            System.out.printf("%-4s  ", elemento);
                                        }
                                        System.out.println();
                                    }
                                    break;

                                case 5: //Balcão Nobre
                                    for (String[] linha : BalcaoNobre) {
                                        for (String elemento : linha) {
                                            System.out.printf("%-4s  ", elemento);
                                        }
                                        System.out.println();
                                    }
                                    break;
                            }

                            //A validação abaixo verifica se a poltrona está ocupada.
                            //SwitchEscolhaArea --> Area escolhida pelo usuário
                            //SessaoRent --> Armazena qual turno eslhido pelo usuário.
                            boolean verificaOcupacaoPoltrona = true;
                            while (verificaOcupacaoPoltrona) {

                                System.out.println("> Escolha a poltrona: ");
                                String poltronaEscolhida = scanner.nextLine();

                                switch (sessaoCisne) {

                                    case 1: //Manhã
                                        if (SwitchescolhaArea == 1) { //Plateia A - Manhã
                                            for (int i = 0; i < PlateiaA.length; i++) {
                                                for (int j = 0; j < PlateiaA[i].length; j++) {
                                                    if (PlateiaA[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (PlateiaAocupacaoSessaoCisneManha[i][j] != 1) {
                                                            PlateiaAocupacaoSessaoCisneManha[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 2) { //Plateia B - Manhã
                                            for (int i = 0; i < PlateiaB.length; i++) {
                                                for (int j = 0; j < PlateiaB[i].length; j++) {
                                                    if (PlateiaB[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (PlateiaBocupacaoSessaoCisneManha[i][j] != 1) {
                                                            PlateiaBocupacaoSessaoCisneManha[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 3) { //Camarotes - Manhã
                                            for (int i = 0; i < Camarotes.length; i++) {
                                                for (int j = 0; j < Camarotes[i].length; j++) {
                                                    if (Camarotes[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (CamarotesOcupacaoSessaoCisneManha[i][j] != 1) {
                                                            CamarotesOcupacaoSessaoCisneManha[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 4) { //Frisas - Manhã
                                            for (int i = 0; i < Frisas.length; i++) {
                                                for (int j = 0; j < Frisas[i].length; j++) {
                                                    if (Frisas[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (FrisasOcupacaoSessaoCisneManha[i][j] != 1) {
                                                            FrisasOcupacaoSessaoCisneManha[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;

                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 5) { //Balcão Nobre - Manhã
                                            for (int i = 0; i < BalcaoNobre.length; i++) {
                                                for (int j = 0; j < BalcaoNobre[i].length; j++) {
                                                    if (BalcaoNobre[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (BalcaoNobreOcupacaoSessaoCisneManha[i][j] != 1) {
                                                            BalcaoNobreOcupacaoSessaoCisneManha[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;

                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        break;

                                    case 2: //Tarde
                                        if (SwitchescolhaArea == 1) { //Plateia A - Tarde
                                            for (int i = 0; i < PlateiaA.length; i++) {
                                                for (int j = 0; j < PlateiaA[i].length; j++) {
                                                    if (PlateiaA[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (PlateiaAocupacaoSessaoCisneTarde[i][j] != 1) {
                                                            PlateiaAocupacaoSessaoCisneTarde[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 2) { //Plateia B - Tarde
                                            for (int i = 0; i < PlateiaB.length; i++) {
                                                for (int j = 0; j < PlateiaB[i].length; j++) {
                                                    if (PlateiaB[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (PlateiaBocupacaoSessaoCisneTarde[i][j] != 1) {
                                                            PlateiaBocupacaoSessaoCisneTarde[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 3) { //Camarotes - Tarde
                                            for (int i = 0; i < Camarotes.length; i++) {
                                                for (int j = 0; j < Camarotes[i].length; j++) {
                                                    if (Camarotes[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (CamarotesOcupacaoSessaoCisneTarde[i][j] != 1) {
                                                            CamarotesOcupacaoSessaoCisneTarde[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 4) { //Frisas - Tarde
                                            for (int i = 0; i < Frisas.length; i++) {
                                                for (int j = 0; j < Frisas[i].length; j++) {
                                                    if (Frisas[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (FrisasOcupacaoSessaoCisneTarde[i][j] != 1) {
                                                            FrisasOcupacaoSessaoCisneTarde[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;

                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 5) { //Balcão Nobre - Tarde
                                            for (int i = 0; i < BalcaoNobre.length; i++) {
                                                for (int j = 0; j < BalcaoNobre[i].length; j++) {
                                                    if (BalcaoNobre[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (BalcaoNobreOcupacaoSessaoCisneTarde[i][j] != 1) {
                                                            BalcaoNobreOcupacaoSessaoCisneTarde[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;

                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        break;

                                    case 3: //Noite
                                        if (SwitchescolhaArea == 1) { //Plateia A - Noite
                                            for (int i = 0; i < PlateiaA.length; i++) {
                                                for (int j = 0; j < PlateiaA[i].length; j++) {
                                                    if (PlateiaA[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (PlateiaAocupacaoSessaoCisneNoite[i][j] != 1) {
                                                            PlateiaAocupacaoSessaoCisneNoite[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 2) { //Plateia B - Noite
                                            for (int i = 0; i < PlateiaB.length; i++) {
                                                for (int j = 0; j < PlateiaB[i].length; j++) {
                                                    if (PlateiaB[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (PlateiaBocupacaoSessaoCisneNoite[i][j] != 1) {
                                                            PlateiaBocupacaoSessaoCisneNoite[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 3) { //Camarotes - Noite
                                            for (int i = 0; i < Camarotes.length; i++) {
                                                for (int j = 0; j < Camarotes[i].length; j++) {
                                                    if (Camarotes[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (CamarotesOcupacaoSessaoCisneNoite[i][j] != 1) {
                                                            CamarotesOcupacaoSessaoCisneNoite[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida;
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 4) { //Frisas - Noite
                                            for (int i = 0; i < Frisas.length; i++) {
                                                for (int j = 0; j < Frisas[i].length; j++) {
                                                    if (Frisas[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (FrisasOcupacaoSessaoCisneNoite[i][j] != 1) {
                                                            FrisasOcupacaoSessaoCisneNoite[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;

                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 5) { //Balcão Nobre - Noite
                                            for (int i = 0; i < BalcaoNobre.length; i++) {
                                                for (int j = 0; j < BalcaoNobre[i].length; j++) {
                                                    if (BalcaoNobre[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (BalcaoNobreOcupacaoSessaoCisneNoite[i][j] != 1) {
                                                            BalcaoNobreOcupacaoSessaoCisneNoite[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;

                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                }
                            }

                            verificacaoSessao = false;

                        } else if (peca.equalsIgnoreCase("Rent!")) {
                            System.out.printf("""

                                    > Certo %s, agora escolha a sessão da peça.
                                    _____________________________________
                                    |              Sessões              |
                                    |___________________________________|
                                    | Sessão 1 - Manhã                  |
                                    | Sessão 2 - Tarde                  |
                                    | Sessão 3 - Noite                  |
                                    |___________________________________|
                                    > Digite o número da sessão escolhida:
                                    """, nomeCliente.toUpperCase());

                            input = scanner.nextLine();
                            int sessaoRent = Integer.parseInt(input.trim());
                            boolean VerificaSessaoRent = true;

                            while (VerificaSessaoRent) { //Verificacao da sessao escolhida.
                                switch (sessaoRent) {
                                    case 1:
                                        VendaCliente[v] = "Manhã";
                                        v++;
                                        VerificaSessaoRent = false;
                                        break;

                                    case 2:
                                        VendaCliente[v] = "Tarde";
                                        v++;
                                        VerificaSessaoRent = false;
                                        break;

                                    case 3:
                                        VendaCliente[v] = "Noite";
                                        v++;
                                        VerificaSessaoRent = false;
                                        break;

                                    default:
                                        System.out.println("Opção Inválida! Tente novamente: ");
                                        input = scanner.nextLine();
                                        sessaoRent = Integer.parseInt(input.trim());
                                        break;
                                }
                            }

                            System.out.print("""
                                    __________________________________
                                    |       Área       |    Valor    |
                                    |__________________|_____________|
                                    | 1 - Plateia A    |  R$ 40,00   |
                                    | 2 - Plateia B    |  R$ 60,00   |
                                    | 3 - Camarote     |  R$ 80,00   |
                                    | 4 - Frisa        |  R$120,00   |
                                    | 5 - Balcão Nobre |  R$250,00   |
                                    |__________________|_____________|
                                    > Digite o número da área escolhida:
                                    """);

                            String AreaEscolhida = scanner.nextLine();
                            int SwitchescolhaArea = Integer.parseInt(AreaEscolhida.trim());
                            boolean VerificaAreaEscolhida = true;

                            while (VerificaAreaEscolhida) { //Verifica a área escolhida.

                                switch (SwitchescolhaArea) {
                                    case 1, 2, 3, 4, 5:
                                        VendaCliente[v] = AreaEscolhida;
                                        v++;
                                        VerificaAreaEscolhida = false;
                                        break;

                                    default:
                                        System.out.println("Opção Inválida! Tente novamente: ");
                                        AreaEscolhida = scanner.nextLine();
                                        SwitchescolhaArea = Integer.parseInt(AreaEscolhida.trim());
                                        break;
                                }

                            }

                            /*int escolhaArea = Integer.parseInt(VendaCliente[4]); //Area escolhida pelo usuário*/
                            int escolhaArea = SwitchescolhaArea; //Area escolhida pelo usuário

                            switch (escolhaArea) { //Switch case para exibir qual área o cliente escolheu
                                case 1: // Plateia A
                                    for (String[] linha : PlateiaA) {
                                        for (String elemento : linha) {
                                            System.out.printf("%-4s  ", elemento);
                                        }
                                        System.out.println();
                                    }
                                    break;

                                case 2: //Plateia B
                                    for (String[] linha : PlateiaB) {
                                        for (String elemento : linha) {
                                            System.out.printf("%-4s  ", elemento);
                                        }
                                        System.out.println();
                                    }
                                    break;

                                case 3: //Camarotes
                                    for (String[] linha : Camarotes) {
                                        for (String elemento : linha) {
                                            System.out.printf("%-4s  ", elemento);
                                        }
                                        System.out.println();
                                    }
                                    break;

                                case 4: //Frisas
                                    for (String[] linha : Frisas) {
                                        for (String elemento : linha) {
                                            System.out.printf("%-4s  ", elemento);
                                        }
                                        System.out.println();
                                    }
                                    break;

                                case 5: //Balcão Nobre
                                    for (String[] linha : BalcaoNobre) {
                                        for (String elemento : linha) {
                                            System.out.printf("%-4s  ", elemento);
                                        }
                                        System.out.println();
                                    }
                                    break;
                            }


                            //SwitchEscolhaArea --> Area escolhida pelo usuário
                            //SessaoRent --> Armazena qual turno eslhido pelo usuário.
                            boolean verificaOcupacaoPoltrona = true;
                            while (verificaOcupacaoPoltrona) {

                                System.out.println("> Escolha a poltrona: ");
                                String poltronaEscolhida = scanner.nextLine();

                                switch (sessaoRent) {

                                    case 1: //Manhã
                                        if (SwitchescolhaArea == 1) { //Plateia A - Manhã
                                            for (int i = 0; i < PlateiaA.length; i++) {
                                                for (int j = 0; j < PlateiaA[i].length; j++) {
                                                    if (PlateiaA[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (PlateiaAocupacaoSessaoRentManha[i][j] != 1) {
                                                            PlateiaAocupacaoSessaoRentManha[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 2) { //Plateia B - Manhã
                                            for (int i = 0; i < PlateiaB.length; i++) {
                                                for (int j = 0; j < PlateiaB[i].length; j++) {
                                                    if (PlateiaB[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (PlateiaBocupacaoSessaoRentManha[i][j] != 1) {
                                                            PlateiaBocupacaoSessaoRentManha[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 3) { //Camarotes - Manhã
                                            for (int i = 0; i < Camarotes.length; i++) {
                                                for (int j = 0; j < Camarotes[i].length; j++) {
                                                    if (Camarotes[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (CamarotesOcupacaoSessaoRentManha[i][j] != 1) {
                                                            CamarotesOcupacaoSessaoRentManha[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 4) { //Frisas - Manhã
                                            for (int i = 0; i < Frisas.length; i++) {
                                                for (int j = 0; j < Frisas[i].length; j++) {
                                                    if (Frisas[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (FrisasOcupacaoSessaoRentManha[i][j] != 1) {
                                                            FrisasOcupacaoSessaoRentManha[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;

                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 5) { //Balcão Nobre - Manhã
                                            for (int i = 0; i < BalcaoNobre.length; i++) {
                                                for (int j = 0; j < BalcaoNobre[i].length; j++) {
                                                    if (BalcaoNobre[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (BalcaoNobreOcupacaoSessaoRentManha[i][j] != 1) {
                                                            BalcaoNobreOcupacaoSessaoRentManha[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;

                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        break;

                                    case 2: //Tarde
                                        if (SwitchescolhaArea == 1) { //Plateia A - Tarde
                                            for (int i = 0; i < PlateiaA.length; i++) {
                                                for (int j = 0; j < PlateiaA[i].length; j++) {
                                                    if (PlateiaA[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (PlateiaAocupacaoSessaoRentTarde[i][j] != 1) {
                                                            PlateiaAocupacaoSessaoRentTarde[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 2) { //Plateia B - Tarde
                                            for (int i = 0; i < PlateiaB.length; i++) {
                                                for (int j = 0; j < PlateiaB[i].length; j++) {
                                                    if (PlateiaB[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (PlateiaBocupacaoSessaoRentTarde[i][j] != 1) {
                                                            PlateiaBocupacaoSessaoRentTarde[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 3) { //Camarotes - Tarde
                                            for (int i = 0; i < Camarotes.length; i++) {
                                                for (int j = 0; j < Camarotes[i].length; j++) {
                                                    if (Camarotes[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (CamarotesOcupacaoSessaoRentTarde[i][j] != 1) {
                                                            CamarotesOcupacaoSessaoRentTarde[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 4) { //Frisas - Tarde
                                            for (int i = 0; i < Frisas.length; i++) {
                                                for (int j = 0; j < Frisas[i].length; j++) {
                                                    if (Frisas[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (FrisasOcupacaoSessaoRentTarde[i][j] != 1) {
                                                            FrisasOcupacaoSessaoRentTarde[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;

                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 5) { //Balcão Nobre - Tarde
                                            for (int i = 0; i < BalcaoNobre.length; i++) {
                                                for (int j = 0; j < BalcaoNobre[i].length; j++) {
                                                    if (BalcaoNobre[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (BalcaoNobreOcupacaoSessaoRentTarde[i][j] != 1) {
                                                            BalcaoNobreOcupacaoSessaoRentTarde[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;

                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        break;

                                    case 3: //Noite
                                        if (SwitchescolhaArea == 1) { //Plateia A - Noite
                                            for (int i = 0; i < PlateiaA.length; i++) {
                                                for (int j = 0; j < PlateiaA[i].length; j++) {
                                                    if (PlateiaA[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (PlateiaAocupacaoSessaoRentNoite[i][j] != 1) {
                                                            PlateiaAocupacaoSessaoRentNoite[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 2) { //Plateia B - Noite
                                            for (int i = 0; i < PlateiaB.length; i++) {
                                                for (int j = 0; j < PlateiaB[i].length; j++) {
                                                    if (PlateiaB[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (PlateiaBocupacaoSessaoRentNoite[i][j] != 1) {
                                                            PlateiaBocupacaoSessaoRentNoite[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 3) { //Camarotes - Noite
                                            for (int i = 0; i < Camarotes.length; i++) {
                                                for (int j = 0; j < Camarotes[i].length; j++) {
                                                    if (Camarotes[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (CamarotesOcupacaoSessaoRentNoite[i][j] != 1) {
                                                            CamarotesOcupacaoSessaoRentNoite[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;
                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 4) { //Frisas - Noite
                                            for (int i = 0; i < Frisas.length; i++) {
                                                for (int j = 0; j < Frisas[i].length; j++) {
                                                    if (Frisas[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (FrisasOcupacaoSessaoRentNoite[i][j] != 1) {
                                                            FrisasOcupacaoSessaoRentNoite[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;

                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        } else if (SwitchescolhaArea == 5) { //Balcão Nobre - Noite
                                            for (int i = 0; i < BalcaoNobre.length; i++) {
                                                for (int j = 0; j < BalcaoNobre[i].length; j++) {
                                                    if (BalcaoNobre[i][j].equalsIgnoreCase(poltronaEscolhida)) {
                                                        if (BalcaoNobreOcupacaoSessaoRentNoite[i][j] != 1) {
                                                            BalcaoNobreOcupacaoSessaoRentNoite[i][j] = 1;
                                                            VendaCliente[v] = poltronaEscolhida.toUpperCase();
                                                            verificaOcupacaoPoltrona = false;

                                                        } else {
                                                            System.out.printf("\nA poltrona escolhida %s está ocupada\n", poltronaEscolhida);

                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                }
                            }

                            verificacaoSessao = false;

                        } else {
                            System.out.println("""
                                    > Peça inválida. Por favor insira uma peça válida
                                    """);
                        }
                    }


                    System.out.println("\n> Compra finalizada com sucesso!\n");
                    v = 0; //Zera o índice do vetor, para quando tiver novas entradas, começar a inserir do início do vetor.

                    //Aqui é aonde o vetor armazena os dados na matriz Tabela Matriz GERAL
                    tabelaGeral[linhaTabelaGeral][0] = VendaCliente[0]; // Nome --
                    tabelaGeral[linhaTabelaGeral][1] = VendaCliente[1]; // CPF -- ***********
                    tabelaGeral[linhaTabelaGeral][2] = VendaCliente[2]; // Peça -- Lago dos cisnes
                    tabelaGeral[linhaTabelaGeral][3] = VendaCliente[3]; // Sessão -- Manhã; Tarde; Noite
                    tabelaGeral[linhaTabelaGeral][4] = VendaCliente[4]; // Área -- 1; 2; 3; 4; 5;
                    tabelaGeral[linhaTabelaGeral][5] = VendaCliente[5]; // Poltrona -- A12


                    linhaTabelaGeral++; //Garante que o próximo cliente que compra, os dados são armazenados na outra linha da matriz, evitando substituição dos dados de outro cliente.

                    //Impressão Tabela Geral


                    /*for (String[] strings : tabelaGeral) {
                        for (String string : strings) {
                            if (string != null) {
                                System.out.printf("%-4s   ", string);
                            } else {
                                System.out.print("vazio" + " ");
                            }
                        }
                        System.out.println();
                    }

                     */

                    break;

                case 2:

                    System.out.println("\n<< OPERAÇÃO 2 - IMPRIMIR INGRESSO >>");

                    // Solicita o CPF ao usuário
                    System.out.println("\n> Digite o CPF cadastrado na compra: ");
                    String cpfrecibo = scanner.nextLine();

                    // Variável que vai verificar se o CPF foi encontrado
                    boolean found = false;


                    // Aqui o for vai percorrer toda a tabelaGeral pra encontrar o CPF
                    for (int i = 0; i < tabelaGeral.length; i++) {
                        // O if irá verificar se a posição [i][1] não é null (não preenchida com algum cpf)
                        // Na segunda parte do if, ele vai buscar se o índice [i][1], que é o CPF cadastrado
                        // pelo usuário na compra e armazenado na tabelaGeral é igual ao fornecido pelo
                        // usuário e lido na variável "cpfrecibo"
                        if (tabelaGeral[i][1] != null && tabelaGeral[i][1].equals(cpfrecibo)) {
                            // Aqui será imprimido o recibo da reserva SE o CPF for encontrado
                            System.out.println("Nome: " + tabelaGeral[i][0].toUpperCase());
                            System.out.println("CPF: " + tabelaGeral[i][1]);
                            System.out.println("Peça: " + tabelaGeral[i][2].toUpperCase());
                            System.out.println("Sessão: " + tabelaGeral[i][3].toUpperCase());
                            System.out.println("Poltrona: " + tabelaGeral[i][5]);
                            //System.out.println("Poltrona: " + tabelaGeral[i][4]);Area do teatro

                            switch (tabelaGeral[i][4]) {
                                case "1":
                                    System.out.println("Área: Plateia A");
                                    System.out.println("Valor: 40,00");
                                    break;
                                case "2":
                                    System.out.println("Área: Plateia B");
                                    System.out.println("Valor: 60,00");
                                    break;
                                case "3":
                                    System.out.println("Área: Camarote");
                                    System.out.println("Valor: 80,00");
                                    break;
                                case "4":
                                    System.out.println("Área: Frisa");
                                    System.out.println("Valor: 120,00");
                                    break;
                                case "5":
                                    System.out.println("Área: Balcão Nobre");
                                    System.out.println("Valor: 250,00");
                                    break;
                                default:
                                    System.out.println("Valor desconhecido");
                                    break;
                            }
                            found = true;
                            System.out.println(); // Adiciona uma linha em branco para separar os recibos
                        }
                    }

                    // Verifica SE caso o cpf não foi encontrado e exibe a mensagem abaixo
                    if (!found) {
                        System.out.println("Compra não encontrada com o CPF fornecido.");
                    }
                    v = 0;
                    break;

                case 3:
                    System.out.println("\n<< OPERAÇÃO 3 - EXIBIR ESTATÍSTICAS >>\n");
                    //1 - Qual peça teve mais e menos ingressos vendidos.

                    System.out.println("\n****  PEÇAS MAIS E MENOS VENDIDAS  ****\n");
                    int countMagicoDeOz = 0;
                    int countCisne = 0;
                    int countRent = 0;
                    //Verifica e conta cada peça.
                    for (int i = 0; i < tabelaGeral.length; i++) {
                        if (tabelaGeral[i][2] != null) {
                            switch (tabelaGeral[i][2]) {
                                case "O Mágico de Oz":
                                    countMagicoDeOz++;
                                    break;
                                case "Lago dos Cisnes":
                                    countCisne++;
                                    break;
                                case "Rent!":
                                    countRent++;
                                    break;
                            }
                        }
                    }

                    // Verificação da peça mais vendida:
                    if (countMagicoDeOz > countCisne && countMagicoDeOz > countRent) {
                        System.out.printf("""
                                -------- Peça Mais Vendida --------
                                > O Mágico de Oz foi a peça mais vendida:
                                >> Foram %d ingressos vendidos.
                                
                                """, countMagicoDeOz);
                    } else if (countCisne > countMagicoDeOz && countCisne > countRent) {
                        System.out.printf("""
                                -------- Peça Mais Vendida --------
                                > Lago dos Cisnes foi a peça mais vendida:
                                >> Foram %d ingressos vendidos.
                                
                                """, countCisne);
                    } else if (countRent > countMagicoDeOz && countRent > countCisne) {
                        System.out.printf("""
                                -------- Peça Mais Vendida --------
                                > Rent! foi a peça mais vendida:
                                >> Foram %d ingressos vendidos.
                                
                                """, countRent);
                    }

                    // Verificação da peça menos vendida:
                    if (countMagicoDeOz < countCisne && countMagicoDeOz < countRent) {
                        System.out.printf("""
                                -------- Peça Menos Vendida --------
                                > O Mágico de Oz foi a peça menos vendida:
                                >> Foram %d ingressos vendidos.
                                
                                """, countMagicoDeOz);
                    } else if (countCisne < countMagicoDeOz && countCisne < countRent) {
                        System.out.printf("""
                                -------- Peça Menos Vendida --------
                                > Lago dos Cisnes foi a peça menos vendida:
                                >> Foram %d ingressos vendidos.
                                
                                """, countCisne);
                    } else if (countRent < countMagicoDeOz && countRent < countCisne) {
                        System.out.printf("""
                                -------- Peça Menos Vendida --------
                                > Rent! foi a peça menos vendida:
                                >> Foram %d ingressos vendidos.
                                
                                """, countRent);
                    }

                    // Verificação de casos de empates:
                    if (countMagicoDeOz == countCisne && countCisne == countRent) {
                        System.out.printf("""
                                -------- Peças Com Empate --------
                                > Houve um empate entre todas as peças:
                                >> Foram %d ingressos vendidos (em cada peça).
                                
                                """, countMagicoDeOz);
                    } else if (countMagicoDeOz == countCisne && countCisne != countRent) {
                        System.out.printf("""
                                -------- Peças Com Empate --------
                                > O Mágico de Oz e Lago dos Cisnes tiveram o mesmo número de vendas:
                                >> Foram %d ingressos vendidos (em cada peça).
                                
                                """, countMagicoDeOz);
                    } else if (countMagicoDeOz == countRent && countRent != countCisne) {
                        System.out.printf("""
                                -------- Peças Com Empate --------
                                > O Mágico de Oz e Rent! tiveram o mesmo número de vendas:
                                >> Foram %d ingressos vendidos (em cada peça).
                                
                                """, countMagicoDeOz);
                    } else if (countCisne == countRent && countRent != countMagicoDeOz) {
                        System.out.printf("""
                                -------- Peças Com Empate --------
                                > Lago dos Cisnes e Rent! tiveram o mesmo número de vendas:
                                >> Foram %d ingressos vendidos (em cada peça).
                                
                                """, countCisne);
                    }

                    System.out.printf("""
                                         --- Visão Geral ---
                                _____________________________________
                                        Peça        |    Vendas     |
                                ____________________|_______________|
                                |  O Mágico de Oz   |       %d
                                |  Lago dos Cisnes  |       %d
                                |  Rent!            |       %d
                                |___________________|________________
                            
                                """, countMagicoDeOz, countCisne, countRent);


                    /*A simulação da estatística podemos fazer antes da apresentação, e tiramos o
                    print para colocarmos no documento, mostrando o resultado de cada pergunta*/

                    /*2- Qual sessão teve maior e menor ocupação de poltronas;*/
                    //Manhã - Tarde - Noite

                    System.out.println("\n****  SESSÃO COM MAIOR E MENOR OCUPÇÃO DE POLTRONAS  ****\n");
                    int countManha = 0;
                    int countTarde = 0;
                    int countNoite = 0;
                    //Verifica e conta cada sessão
                    for (int i = 0; i < tabelaGeral.length; i++) {
                        if (tabelaGeral[i][3] != null) {
                            switch (tabelaGeral[i][3]) {
                                case "Manhã":
                                    countManha++;
                                    break;
                                case "Tarde":
                                    countTarde++;
                                    break;
                                case "Noite":
                                    countNoite++;
                                    break;
                            }
                        }
                    }

                    // Verificação da sessão mais ocupada:
                    if (countManha > countTarde && countManha > countNoite) {
                        System.out.printf("""
                                -------- Sessão Com Maior Ocupação --------
                                > A sessão da Manhã teve maior ocupação de poltronas:
                                >> Foram %d poltronas ocupadas.
                                
                                """, countManha);
                    } else if (countTarde > countManha && countTarde > countNoite) {
                        System.out.printf("""
                                -------- Sessão Com Maior Ocupação --------
                                > A sessão da Tarde teve maior ocupação de poltronas:
                                >> Foram %d poltronas ocupadas.
                                
                                """, countTarde);
                    } else if (countNoite > countManha && countNoite > countTarde) {
                        System.out.printf("""
                                -------- Sessão Com Maior Ocupação --------
                                > A sessão da Noite teve maior ocupação de poltronas:
                                >> Foram %d poltronas ocupadas.
                                
                                """, countNoite);
                    }

                    // Verificação da sessão menos ocupada:
                    if (countManha < countTarde && countManha < countNoite) {
                        System.out.printf("""
                                -------- Sessão Com Menor Ocupação --------
                                > A sessão da Manhã teve menor ocupação de poltronas:
                                >> Foram %d poltronas ocupadas.
                                
                                """, countManha);
                    } else if (countTarde < countManha && countTarde < countNoite) {
                        System.out.printf("""
                                -------- Sessão Com Menor Ocupação --------
                                > A sessão da Tarde teve menor ocupação de poltronas:
                                >> Foram %d poltronas ocupadas.
                                
                                """, countTarde);
                    } else if (countNoite < countManha && countNoite < countTarde) {
                        System.out.printf("""
                                -------- Sessão Com Menor Ocupação --------
                                > A sessão da Noite teve menor ocupação de poltronas:
                                >> Foram %d poltronas ocupadas.
                                
                                """, countNoite);
                    }

                    // Verificação de casos de empates:
                    if (countManha == countTarde && countTarde == countNoite) {
                        System.out.printf("""
                                -------- Sessões Com Empate --------
                                > Houve um empate entre todas as sessões:
                                >> Todas tiveram %d poltronas ocupadas.
                                
                                """, countManha);
                    } else if (countManha == countTarde && countTarde != countNoite) {
                        System.out.printf("""
                                -------- Sessões Com Empate --------
                                > As sessões: Manhã e Tarde tiveram a mesma quantidade de poltronas ocupadas:
                                >> Foram %d poltronas ocupadas.
                               
                                """, countManha);
                    } else if (countManha == countNoite && countNoite != countTarde) {
                        System.out.printf("""
                                -------- Sessões Com Empate --------
                                > As sessões: Manhã e Noite tiveram a mesma quantidade de poltronas ocupadas:
                                >> Foram %d poltronas ocupadas.
                                
                                """, countManha);
                    } else if (countTarde == countNoite && countNoite != countManha) {
                        System.out.printf("""
                                -------- Sessões Com Empate --------
                                > As sessões: Tarde e Noite tiveram a mesma quantidade de poltronas ocupadas:
                                >> Foram %d poltronas ocupadas.
                                
                                """, countTarde);
                    }


                    System.out.printf("""
                                        --- Visão Geral ---
                                ___________________________________
                                    Sessão   | Poltronas Vendidas |
                                _____________|____________________|
                                |  Manhã     |          %d
                                |  Tarde     |          %d
                                |  Noite     |          %d
                                |____________|_____________________
                                   
                                """, countManha, countTarde, countNoite);

                    // PEÇA C/ MAIS - MENOS - INGRESSOS VENDIDOS
                    // SESSÃO C/ MAIOR - MENOR - OCUPAÇÃO DE POLTRONAS
                    // PECA - SESSÃO - MAIS - MENOS - LUCRATIVA
                    // LUCRO MÉDIO DO TEATRO - TODAS AS ÁREAS POR PEÇA


                    // 03 - Peça mais lucrativa:
                    System.out.println("\n****  RECEITA DAS PEÇAS E SESSÕES  ****\n");

                    // Variáveis que vão armazenar os lucros de cada área e sessão
                    int lucroMagicoDeOz = 0, lucroCisne = 0, lucroRent = 0;
                    int lucroManha = 0, lucroTarde = 0, lucroNoite = 0;
                    int countPlateiaA = 0, countPlateiaB = 0, countCamarote = 0, countFrisa = 0, countBalcaoN = 0;
                    int lucroPlateiaA = 0, lucroPlateiaB = 0, lucroCamarote = 0, lucroFrisa = 0, lucroBalcaoN = 0;

                    // For que vai percorrer a tabela geral
                    for (int i = 0; i < tabelaGeral.length; i++) {
                        // Variável que irá contar os ingressos
                        int valoringresso = 0;
                        // If que contará
                        if (tabelaGeral[i][4] != null) {
                            switch (tabelaGeral[i][4]) {
                                case "1":
                                    valoringresso = 40;
                                    countPlateiaA++;
                                    lucroPlateiaA += valoringresso;
                                    break;
                                case "2":
                                    valoringresso = 60;
                                    countPlateiaB++;
                                    lucroPlateiaB += valoringresso;
                                    break;
                                case "3":
                                    valoringresso = 80;
                                    countCamarote++;
                                    lucroCamarote += valoringresso;
                                    break;
                                case "4":
                                    valoringresso = 120;
                                    countFrisa++;
                                    lucroFrisa += valoringresso;
                                    break;
                                case "5":
                                    valoringresso = 250;
                                    countBalcaoN++;
                                    lucroBalcaoN += valoringresso;
                                    break;
                                default:
                                    System.out.println("Valor desconhecido.");
                            }
                        }
                        if (tabelaGeral[i][2] != null) {
                            switch (tabelaGeral[i][2].toLowerCase()) {
                                case "o mágico de oz":
                                    lucroMagicoDeOz += valoringresso;
                                    break;
                                case "lago dos cisnes":
                                    lucroCisne += valoringresso;
                                    break;
                                case "rent!":
                                    lucroRent += valoringresso;
                                    break;
                            }
                        }

                        if (tabelaGeral[i][3] != null) {
                            switch (tabelaGeral[i][3].toLowerCase()) {
                                case "manhã":
                                    lucroManha += valoringresso;
                                    break;
                                case "tarde":
                                    lucroTarde += valoringresso;
                                    break;
                                case "noite":
                                    lucroNoite += valoringresso;
                                    break;
                            }
                        }
                    }

                    System.out.println("---  RECEITA DAS PEÇAS  ---\n");
                    // Verificação da peça mais lucrativa:
                    if (lucroMagicoDeOz > lucroCisne && lucroMagicoDeOz > lucroRent) {
                        System.out.printf("""
                                -------- Peça Com Maior Receita --------
                                > A peça O Mágico de Oz foi a mais rentável:
                                >> A renda foi de R$ %d.%n
                                """, lucroMagicoDeOz);
                    } else if (lucroCisne > lucroMagicoDeOz && lucroCisne > lucroRent) {
                        System.out.printf("""
                                -------- Peça Com Maior Receita --------
                                > A peça Lago dos Cisnes foi a mais rentável:
                                >> A renda foi de R$ %d.%n
                                """, lucroCisne);
                    } else if (lucroRent > lucroMagicoDeOz && lucroRent > lucroCisne) {
                        System.out.printf("""
                                -------- Peça Com Maior Receita --------
                                > A peça Rent! foi a mais rentável:
                                >> A renda foi de R$ %d.%n""", lucroRent);
                    }

                    // Verificação da peça menos lucrativa:
                    if (lucroMagicoDeOz < lucroCisne && lucroMagicoDeOz < lucroRent) {
                        System.out.printf("""
                                -------- Peça Com Menor Receita --------
                                > A peça O Mágico de Oz foi a menos rentável:
                                >> A renda foi de R$ %d.%n
                                """, lucroMagicoDeOz);
                    } else if (lucroCisne < lucroMagicoDeOz && lucroCisne < lucroRent) {
                        System.out.printf("""
                                -------- Peça Com Menor Receita --------
                                > A peça Lago dos Cisnes foi a menos rentável:
                                >> A renda foi de R$ %d.%n
                                """, lucroCisne);
                    } else if (lucroRent < lucroMagicoDeOz && lucroRent < lucroCisne) {
                        System.out.printf("""
                                -------- Peça Com Menor Receita --------
                                > A peça Rent! foi a menos rentável:
                                >> A renda foi de R$ %d.%n
                                """, lucroRent);
                    }

                    // Verificação de casos de empate:
                    if (lucroMagicoDeOz == lucroCisne && lucroMagicoDeOz == lucroRent) {
                        System.out.printf("""
                                -------- Receita de Peças Empatadas --------
                                > Houve um empate entre todas as Peças:
                                >> Todas tiveram uma receita de: R$ %d.%n
                                """, lucroMagicoDeOz);
                    } else if (lucroCisne == lucroMagicoDeOz && lucroCisne != lucroRent) {
                        System.out.printf("""
                                -------- Receita de Peças Empatadas --------
                                > As peças: Lago dos Cisnes e Magico de Oz tiveram o mesmo lucro
                                >> A receita foi de R$ %d.%n
                                """, lucroCisne);
                    } else if (lucroRent == lucroMagicoDeOz && lucroRent != lucroCisne) {
                        System.out.printf("""
                                -------- Receita de Peças Empatadas --------
                                > As peças: Rent! e O Mágico de Oz tiveram o mesmo lucro:
                                >> A receita foi de R$ %d.%n
                                """, lucroRent);
                    } else if (lucroRent == lucroCisne && lucroRent != lucroCisne) {
                        System.out.printf("""
                                -------- Receita de Peças Empatadas --------
                                > As peças: Rent! e Lago do Cisne tiveram o mesmo lucro:
                                >> A receita foi de R$ %d.%n
                                """, lucroRent);
                    }

                    System.out.printf("""
                                        --- Visão Geral ---
                                ____________________________________
                                        Peça       |    Receita    |
                                ___________________|_______________|
                                | O Mágico de Oz   | R$    %d
                                | Lago dos Cisne   | R$    %d
                                | Rent!            | R$    %d
                                |__________________|________________
                                
                          
                                """, lucroMagicoDeOz, lucroCisne, lucroRent);

                    System.out.println("---  RECEITA DAS SESSÕES  ---\n");
                    // Verificação da sessão mais lucrativa:
                    if (lucroManha > lucroTarde && lucroManha > lucroNoite) {
                        System.out.printf("""
                                -------- Sessão Com Maior Receita --------
                                > A Sessão da Manhã teve a maior receita:
                                >> A receita foi de R$ %d.%n
                                """, lucroManha);
                    } else if (lucroTarde > lucroManha && lucroTarde > lucroNoite) {
                        System.out.printf("""
                                -------- Sessão Com Maior Receita --------
                                > A Sessão da Tarde teve a maior receita:
                                >> A receita foi de R$ %d.%n
                                """, lucroTarde);
                    } else if (lucroNoite > lucroManha && lucroNoite > lucroTarde) {
                        System.out.printf("""
                                -------- Sessão Com Maior Receita --------
                                > A Sessão da Noite teve a maior receita:
                                >> A receita foi de R$ %d.%n
                                """, lucroNoite);
                    }

                    // Verificação da sessão menos lucrativa:
                    if (lucroManha < lucroTarde && lucroManha < lucroNoite) {
                        System.out.printf("""
                                -------- Sessão Com Menor Receita --------
                                > A Sessão da Manhã teve a menor receita:
                                >> A receita foi de R$ %d.%n
                                """, lucroManha);
                    } else if (lucroTarde < lucroManha && lucroTarde < lucroNoite) {
                        System.out.printf("""
                                -------- Sessão Com Menor Receita --------
                                > A Sessão da Tarde teve a menor receita:
                                >> A receita foi de R$ %d.%n
                                """, lucroTarde);
                    } else if (lucroNoite < lucroManha && lucroNoite < lucroTarde) {
                        System.out.printf("""
                                -------- Sessão Com Menor Receita --------
                                > A Sessão da Noite teve a menor receita:
                                >> A receita foi de R$ %d.%n
                                """, lucroNoite);
                    }

                    // Verificação de casos de empate:
                    if (lucroManha == lucroTarde && lucroManha == lucroNoite) {
                        System.out.printf("""
                                -------- Receitas das Sessões Empatadas --------
                                > Houve um empate entre todas as Sessões:
                                >> Todas tiveram uma receita de: R$ %d.%n
                                """, lucroManha);
                    } else if (lucroManha == lucroTarde && lucroTarde != lucroNoite) {
                        System.out.printf("""
                                -------- Receitas das Sessões Empatadas --------
                                > As sessões: Manhã e Tarde tiveram a mesma receita:
                                >> A receita foi de R$ %d.%n
                                """, lucroManha);
                    } else if (lucroManha == lucroNoite && lucroNoite != lucroTarde) {
                        System.out.printf("""
                                -------- Receitas das Sessões Empatadas --------
                                > As sessões: Manhã e Noite tiveram a mesma receita:
                                >> A receita foi de R$ %d.%n
                                """, lucroManha);
                    } else if (lucroTarde == lucroNoite && lucroNoite != lucroManha) {
                        System.out.printf("""
                                -------- Receitas das Sessões Empatadas --------
                                > As sessões: Tarde e Noite tiveram a mesma receita:
                                >> A receita foi de R$ %d.%n
                                """, lucroTarde);
                    }

                    System.out.printf("""
                                    --- Visão Geral ---
                                ____________________________
                                   Sessão  |    Receita    |
                                ___________|_______________|
                                |  Manhã   | R$    %d
                                |  Tarde   | R$    %d
                                |  Noite   | R$    %d
                                |__________|________________
                                
                                """, lucroManha, lucroTarde, lucroNoite);

                    // 04 - LUCRO MÉDIO DO TEATRO - TODAS AS ÁREAS POR PEÇA
                    System.out.println("\n****  RECEITA MÉDIA  ****\n");

                    // Converte a variável para double e divide por 3 (Quantidade de peças)
                    double lucroMedioPeca = (double) (lucroMagicoDeOz + lucroCisne + lucroRent) / 3;
                    double lucroMedioSessao = (double) (lucroManha + lucroTarde + lucroNoite) / 3;

                    System.out.println("---  RECEITA MÉDIA DO TEATRO POR PEÇA  ---\n");
                    System.out.printf("""
                                > A receita média do teatro por peça é de R$ %.2f.%n
                                                      --- Visão Geral ---
                                _________________________________________________________________
                                        Peça       |  Receita Total  |  Receita Média Por Peça  |
                                ___________________|_________________|__________________________|
                                | O Mágico de Oz   |  R$ %d
                                | Lago dos Cisnes  |  R$ %d                  R$ %.2f
                                | Rent!            |  R$ %d
                                |__________________|______________________________________________
                                
                                """, lucroMedioPeca, lucroMagicoDeOz, lucroCisne, lucroMedioPeca, lucroRent);

                    System.out.println("---  RECEITA MÉDIA DO TEATRO POR SESSÃO  ---\n");
                    System.out.printf("""
                                > A receita média do teatro por sessão é de %.2f. %n
                                                     --- Visão Geral ---
                                _________________________________________________________________
                                      Sessão     |  Receita Total  |  Receita Média Por Sessão  |
                                _________________|_________________|____________________________|
                                |     Manhã      |   R$   %d
                                |     Tarde      |   R$   %d           R$        %.2f
                                |     Noite      |   R$   %d
                                |________________|________________________________________________
                                
                                """,lucroMedioSessao, lucroManha, lucroTarde, lucroMedioSessao,lucroNoite);

                    System.out.println("---  RECEITA MÉDIA DO TEATRO POR ÁREA  ---\n");
                    // Lucro médio de todas as áreas de todas as peças
                    double lucroMedioArea = (double) (lucroMagicoDeOz + lucroCisne + lucroRent) / 5;
                    System.out.printf("""
                                > A receita média do teatro por área é de %.2f. %n
                                                                       --- Visão Geral ---
                                _________________________________________________________________________________________________________
                                       Área     |   Preço Unitário   | Poltronas Vendidas |  Receita Total  |  Receita Média Das Áreas  |
                                ________________|____________________|____________________|_________________|___________________________|
                                | Plateia A    -      R$ 40,00                 %d                R$ %d
                                | Plateia B    -      R$ 60,00                 %d                R$ %d
                                | Camarotes    -      R$ 80,00                 %d                R$ %d                R$ %.2f
                                | Frisas       -      R$120,00                 %d                R$ %d
                                | Balcão Nobre -      R$250,00                 %d                R$ %d
                                |________________________________________________________________________________________________________
                               
                                """,lucroMedioArea, countPlateiaA, lucroPlateiaA,
                            countPlateiaB, lucroPlateiaB,
                            countCamarote, lucroCamarote, lucroMedioArea,
                            countFrisa, lucroFrisa,
                            countBalcaoN, lucroBalcaoN);




                    System.out.println("---  RECEITA MÉDIA DE CADA PEÇA POR ÁREA E SESSÃO  ---\n");
                    int lucroMedioOzArea = lucroMagicoDeOz / 5;
                    int lucroMedioCisneArea = lucroCisne / 5;
                    int lucroMedioRentArea = lucroRent / 5;

                    int lucroMedioOzSessao = lucroMagicoDeOz / 3;
                    int lucroMedioCisneSessao = lucroCisne / 3;
                    int lucroMedioRentSessao = lucroRent / 3;

                    System.out.printf("""
                                               ---  O Mágico de Oz  ---
                            > A receita média das Sessões da Peça O Mágico de Oz foi de: R$ %d
                            > A receita média das Áreas da Peça O Mágico de Oz foi de: R$ %d.%n
                            """, lucroMedioOzSessao, lucroMedioOzArea);
                    System.out.printf("""
                                               ---  Lago Dos Cisnes  ---
                            > A receita média das Sessões da Peça Lago dos Cisnes foi de: R$ %d
                            > A receita média das Áreas da Peça Lago dos Cisnes foi de: R$ %d.%n
                            """, lucroMedioCisneSessao, lucroMedioCisneArea);
                    System.out.printf("""
                                               ---  Rent!  ---
                            > A receita média das Sessões da Peça Rent! foi de: R$ %d
                            > A receita média das Áreas da Peça Rent! foi de: R$ %d.%n
                            """, lucroMedioRentSessao, lucroMedioRentArea);

                    System.out.printf("""
                                                                     --- Visão Geral ---
                                ________________________________________________________________________________________________
                                        Peça       |  Receita Total  |  Receita Média Das Áreas  |  Receita Média Das Sessões  |
                                ___________________|_________________|___________________________|_____________________________|
                                | O Mágico de Oz   |     R$ %d                 R$ %d                         R$ %d
                                | Lago dos Cisnes  |     R$ %d                  R$ %d                         R$ %d
                                | Rent!            |     R$ %d                 R$ %d                         R$ %d
                                |__________________|____________________________________________________________________________
                               
                                """, lucroMagicoDeOz, lucroMedioOzArea, lucroMedioOzSessao,
                            lucroCisne, lucroMedioCisneArea, lucroMedioCisneSessao,
                            lucroRent, lucroMedioRentArea, lucroMedioRentSessao);

                    System.out.println("---  RECEITA MÉDIA DE CADA SESSÃO  ---\n");
                    // Como temos 3 Sessões (1 em cada peça), dividi por 3 para saber a receita média.
                    int lucroMedioManha = lucroManha / 3;
                    int lucroMedioTarde = lucroTarde / 3;
                    int lucroMedioNoite = lucroNoite / 3;

                    System.out.printf("""
                                               ---  Sessão Manhã  ---
                            > A receita média da Sessão Manhã foi de: R$ %d %n
                            """, lucroMedioManha);
                    System.out.printf("""
                                               ---  Sessão Tarde  ---
                            > A receita média da Sessão Tarde foi de: R$ %d %n
                            """, lucroMedioTarde);
                    System.out.printf("""
                                               ---  Sessão Noite  ---
                            > A receita média da Sessão Noite foi de: R$ %d %n                                              
                            """, lucroMedioNoite);

                    System.out.printf("""
                                                     --- Visão Geral ---
                                __________________________________________________________________
                                      Sessão     |  Receita Total  |  Receita Média Das Sessões  |
                                _________________|_________________|_____________________________|
                                |     Manhã      |      R$ %d                 R$ %d
                                |     Tarde      |      R$ %d                  R$ %d
                                |     Noite      |      R$ %d                  R$ %d
                                |________________|________________________________________________
                                   
                                """, lucroManha, lucroMedioManha,
                            lucroTarde, lucroMedioTarde,
                            lucroNoite, lucroMedioNoite);


                    //Zerando variavel para a próxima iteração do case 3 "Mostrar Estatística.
                    countMagicoDeOz = 0;
                    countCisne = 0;
                    countRent = 0;
                    lucroMagicoDeOz = 0;
                    lucroCisne = 0;
                    lucroRent = 0;
                    countManha = 0;
                    countTarde = 0;
                    countNoite = 0;
                    lucroManha = 0;
                    lucroTarde = 0;
                    lucroNoite = 0;
                    countPlateiaA = 0;
                    countPlateiaB = 0;
                    countCamarote = 0;
                    countFrisa = 0;
                    countBalcaoN = 0;
                    lucroPlateiaA = 0;
                    lucroPlateiaB = 0;
                    lucroFrisa = 0;
                    lucroCamarote = 0;
                    lucroBalcaoN = 0;
                    lucroMedioPeca = 0;
                    lucroMedioSessao = 0;
                    lucroMedioArea = 0;
                    lucroMedioOzArea = 0;
                    lucroMedioCisneArea = 0;
                    lucroMedioRentArea = 0;
                    lucroMedioOzSessao = 0;
                    lucroMedioCisneSessao = 0;
                    lucroMedioRentSessao = 0;

                    v = 0;
                    break;

                case 4:
                    // Opção "Sair"
                    System.out.printf("""
                                       
                                        > %s, deseja mesmo encerrar o sistema? (sim/não)
                                        """, nomeCliente.toUpperCase());
                    String confirmacao = ler.nextLine();

                    if (confirmacao.equalsIgnoreCase("sim") || confirmacao.equalsIgnoreCase("s")) {
                        continuarAtendimento = false;
                        System.out.println("> Atendimento encerrado.");
                        // VOLTAR AO MENU DE OPERAÇÕES
                    }
                    v = 0;

                    break;

                default:
                    System.out.println("> Opção inválida! Digite uma das opções disponíveis acima.");
                    v = 0;
                    break;

            }
        }
    }
}


//Feito por Daniel de Souza Jorge, Gabriel Machado, Gabriella Pio Correa, Nicollas Ranniery, Bruno Henrique.