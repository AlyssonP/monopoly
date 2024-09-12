package org.monopoly.lugares;

public enum TipoImposto {
    RENDA {
        public String getNome(){ return "Renda"; }
        public int getValor() { return 200; }
    },
    RIQUEZA {
        public String getNome(){ return "Riqueza"; }
        public int getValor() { return 75; }
    };

    public abstract String getNome();
    public abstract int getValor();
}
