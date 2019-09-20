package sqlGen.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
public class WebConfig implements WebMvcConfigurer {

//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/").setViewName("index");
//	}
	
	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
		tilesViewResolver.setViewClass(TilesView.class);
		return tilesViewResolver;
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tiles = new TilesConfigurer();
		tiles.setDefinitions(new String[] { "WEB-INF/tiles/tiles.xml","WEB-INF/tiles/tiles_genSql.xml","WEB-INF/tiles/tiles_genEntity.xml"});
		return tiles;
	}

	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
	}
	
	@Bean
	public SpringLiquibase liquibase(DataSource dataSource) {
	    SpringLiquibase liquibase = new SpringLiquibase();
	    liquibase.setChangeLog("classpath:db/changelog/liquibase-outputChangeLog.xml");
	    liquibase.setDataSource(dataSource);
	    liquibase.setShouldRun(false);
	    return liquibase;
	}

}
