package net.unesc.entidades;

public enum FormaAlerta {
    NOTIFICACAO("Notificação"),   
    EMAIL("E-mail"),
    SMS("SMS"),
    POPUP("Pop-up");
    
    private String descricao;

    private FormaAlerta(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }  
}
