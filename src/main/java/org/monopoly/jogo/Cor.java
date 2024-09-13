package org.monopoly.jogo;

public enum Cor {
    PRETO {
        public String getNome() {return "Preto";}
    },
    BRANCO {
        public String getNome() {return "Branco";}
    },
    VERMELHO {
        public String getNome() {return "Vermelho";}
    },
    VERDE {
        public String getNome() {return "Verde";}
    },
    AZUL {
        public String getNome() {return "Azul";}
    },
    AMARELO {
        public String getNome() {return "Amarelo";}
    },
    LARANJA {
        public String getNome() {return "Laranja";}
    },
    ROSA{
        public String getNome() {return "Rosa";}
    };

    public abstract String getNome();
}
