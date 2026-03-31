public class CalculadoraIMC {

    public static void main(String[] args) {

        String nome = IO.readln("Informe seu nome: ");

        char genero = IO.readln("Informe seu gênero (M: masculino, F: feminino, N: prefiro não informar): ").charAt(0);

        double altura = Double.parseDouble(IO.readln("Informe sua altura em metros (ex: 1.75): "));

        double peso = Double.parseDouble(IO.readln("Informe seu peso em quilos (ex: 70.5): "));

        double imc = calcularIMC(peso, altura);
        String classificacao = classificarIMC(genero, imc);

        exibirResultado(nome, genero, imc, classificacao);

        
    }

    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    public static String classificarIMC(char genero, double imc) {
        String classificacao = "";

        switch (genero) {
            case 'M':
            case 'm':
                if (imc >= 40) {
                    classificacao = "Obesidade Mórbida";
                } else if (imc >= 30) {
                    classificacao = "Obesidade Moderada";
                } else if (imc >= 25) {
                    classificacao = "Obesidade Leve";
                } else if (imc >= 20) {
                    classificacao = "Normal";
                } else {
                    classificacao = "Abaixo do Normal";
                }
                break;

            case 'F':
            case 'f':
            case 'N':
            case 'n':
            default:
                if (imc >= 39) {
                    classificacao = "Obesidade Mórbida";
                } else if (imc >= 29) {
                    classificacao = "Obesidade Moderada";
                } else if (imc >= 24) {
                    classificacao = "Obesidade Leve";
                } else if (imc >= 19) {
                    classificacao = "Normal";
                } else {
                    classificacao = "Abaixo do Normal";
                }
                break;
        }

        return classificacao;
    }

    public static void exibirResultado(String nome, char genero, double imc, String classificacao) {
        String generoExibido;

        switch (Character.toUpperCase(genero)) {
            case 'M':
                generoExibido = "Masculino";
                break;
            case 'F':
                generoExibido = "Feminino";
                break;
            default:
                generoExibido = "Não informado";
                break;
        }

        IO.println("\n--- Resultado ---");
        IO.println("Nome: " + nome);
        IO.println("Gênero: " + generoExibido);
        IO.println("IMC: " + String.format("%.1f", imc));
        IO.println("Classificação: " + classificacao);
        IO.println("-----------------\n");
    }
}
