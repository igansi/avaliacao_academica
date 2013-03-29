package br.edu.infnet.avaliacaoAcademica;

/**
 * Define as páginas navegáveis do sistema.
 */
public enum AvailableNavigableUrls {
    LOGIN("/login.jsf"),
    MENU("/facets/menu.jsf"),
    STUDENT("/facets/student_crud.jsf"),
    EVALUATION_FORM("/facets/evaluation_form.jsf");
    
    private String url;

    private AvailableNavigableUrls(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
