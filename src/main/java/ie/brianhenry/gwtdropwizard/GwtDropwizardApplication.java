package ie.brianhenry.gwtdropwizard;

import ie.brianhenry.gwtdropwizard.health.TemplateHealthCheck;
import ie.brianhenry.gwtdropwizard.resources.GwtDropwizardResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class GwtDropwizardApplication extends Application<GwtDropwizardConfiguration> {
	public static void main(String[] args) throws Exception {
		new GwtDropwizardApplication().run(args);
	}

	@Override
	public String getName() {
		return "hello-world";
	}

	@Override
	public void initialize(Bootstrap<GwtDropwizardConfiguration> bootstrap) {
		bootstrap.addBundle(new AssetsBundle("/gwt", "/", "index.html", "gwt"));
		
		
	}

	@Override
	public void run(GwtDropwizardConfiguration configuration,
			Environment environment) {
		final GwtDropwizardResource resource = new GwtDropwizardResource(
				configuration.getTemplate(), configuration.getDefaultName());

		final TemplateHealthCheck healthCheck = new TemplateHealthCheck(
				configuration.getTemplate());
		environment.healthChecks().register("template", healthCheck);

		environment.jersey().setUrlPattern("/api/*");

		environment.jersey().register(resource);

	}

}