package br.bcc.services;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author ascarneiro
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        //resources.add(br.bcc.services.FilmesResource.class);
        //resources.add(br.bcc.services.PesquisasResource.class);
        resources.add(br.bcc.services.FilmesResource.class);
        resources.add(br.bcc.services.PesquisasResource.class);
        resources.add(br.bcc.services.UsuariosResource.class);
    }

}
