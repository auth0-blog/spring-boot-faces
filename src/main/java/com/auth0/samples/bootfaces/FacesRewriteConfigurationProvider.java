package com.auth0.samples.bootfaces;

import javax.servlet.ServletContext;

import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.rule.Join;

@RewriteConfiguration
public class FacesRewriteConfigurationProvider extends HttpConfigurationProvider {

	   @Override
	   public int priority()
	   {
	     return 10;
	   }

	   @Override
	   public Configuration getConfiguration(final ServletContext context)
	   {
	     return ConfigurationBuilder.begin()
	       .addRule(Join.path("/").to("/index.jsf"))
	       .addRule(Join.path("/book/{id}/").to("/viewBook.jsf"));
	    }
	
}
