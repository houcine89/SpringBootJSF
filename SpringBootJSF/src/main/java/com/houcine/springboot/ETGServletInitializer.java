package com.houcine.springboot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Classe utilisé pour lancer Spring boot dans un context Web.
 * 
 * @author <a href="mailto:houcine.gasmi3@docapost.fr">hgasmi</a>
 * @since 28 juil. 2015
 * @Copyright - Docapost - All Rights Reserved www.docapost.com
 */
public class ETGServletInitializer extends SpringBootServletInitializer {

    /**
     * {@inheritDoc}
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }

}
