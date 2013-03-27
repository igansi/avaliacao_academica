package br.edu.infnet.avaliacaoAcademica.hibernate.dao;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * Cria a base de dados baseado nas configurações do hibernate.
 */
public class CreateDatabaseByHibernate {

    private static final String HIBERNATE_CFG_XML_FILE = "br/edu/infnet/avaliacaoAcademica/xml/hibernate.cfg.xml";

    public static void main(String[] args) {
        Configuration config = getConfiguration();
        SchemaExport schema = new SchemaExport(config);

        schema.create(true, true);
    }

    private static Configuration getConfiguration() {
        Configuration config = new Configuration();

        config.configure(HIBERNATE_CFG_XML_FILE);
        return config;
    }
}
