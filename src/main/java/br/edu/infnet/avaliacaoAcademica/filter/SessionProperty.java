package br.edu.infnet.avaliacaoAcademica.filter;

/**
 * Define as propriedades que estarão armazenadas na sessão do sistema
 */
public enum SessionProperty {
    LOGGED_USER("LOGGED_USER");

    private String propertyName;
    
    private SessionProperty(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyName() {
        return propertyName;
    }
}
