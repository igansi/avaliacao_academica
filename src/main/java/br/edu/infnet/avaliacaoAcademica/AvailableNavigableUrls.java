package br.edu.infnet.avaliacaoAcademica;

/**
 * Define as páginas navegáveis do sistema.
 */
public enum AvailableNavigableUrls {
    LOGIN("/login.jsf"),
    STUDENT("/facets/student.jsf");
    
    private String url;

    private AvailableNavigableUrls(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
