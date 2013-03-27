package br.edu.infnet.avaliacaoAcademica.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * Define métodos para auxiliar o uso de {@link ManagedBean}.
 */
public final class ManagedBeanHelper {

    private ManagedBeanHelper() {}

    /**
     * Adiciona um atributo na sessão.
     * @param key Identificador do atributo
     * @param value Valor do atributo, ou seja, o próprio atributo
     */
    public static <T> void setAttributeInSession(String key, T value) {
        getHttpSession().setAttribute(key, value);
    }

    /**
     * Recupera um atributo da sessão.
     * @param key Identificador do atributo
     * @return Valor do atributo
     */
    @SuppressWarnings("unchecked")
    public static <T> T getAttributeOfSession(String key) {
        return (T) getHttpSession().getAttribute(key);
    }

    /**
     * Remove um atributo da sessão.
     * @param key Identificador do atributo
     */
    public static <T> void removeAttributeInSession(String key) {
        getHttpSession().removeAttribute(key);
    }
    
    /**
     * Redireciona a navegação para a URL especificada.
     * @param url URL na qual se deseja navegar
     */
    public static void handleNavigation(String url) {
        getContext().getApplication().getNavigationHandler().handleNavigation(getContext(), null, url);
    }

    private static HttpSession getHttpSession() {
        return (HttpSession) getContext().getExternalContext().getSession(false);
    }
    
    private static FacesContext getContext() {
        return FacesContext.getCurrentInstance();
    }
}
