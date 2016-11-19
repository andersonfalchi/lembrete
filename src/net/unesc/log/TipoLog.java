package net.unesc.log;

public enum TipoLog {
    EXCLUSAO("Exclusão"),
    INCLUSAO("Inclusão"),
    FUNCAO("Função"),
    LOGOFF("Logoff"),
    LOGIN("Login");
    
    private String descricao;

    private TipoLog(String descricao) {
        this.descricao = descricao;
    }
}
