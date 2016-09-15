package pl.gft.kszawala.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories
@ComponentScan
@EnableTransactionManagement
@EnableAutoConfiguration
public class TestH2Config {

	// This combination of Bean injections is recommended for
	// Repository/EnableTransactionManagement. Found somewhere in JavaDoc of
	// Spring.

	// 1. Create DataSource
	@Bean
	public DataSource dataSource() {

		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("create-cars.sql").build();
	}

	// 2. Use the DataSource to create EntityManagerFactory
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(final DataSource dataSource,
			final JpaVendorAdapter adapter) {

		final LocalContainerEntityManagerFactoryBean b = new LocalContainerEntityManagerFactoryBean();
		b.setDataSource(dataSource);
		b.setJpaVendorAdapter(adapter);
		b.setPackagesToScan("pl.gft.kszawala");

		return b;
	}

	// 3. Use the EntityManagerFactory to create TransactionManager
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {

		final HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		return adapter;
	}

	@Bean
	public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {

		final JpaTransactionManager mgr = new JpaTransactionManager();
		mgr.setEntityManagerFactory(emf);

		return mgr;
	}
}
