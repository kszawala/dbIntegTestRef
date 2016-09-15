package org.kszawala.ref.db.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
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
public class TestMySqlConfig {

	// This combination of Bean injections is recommended for
	// Repository/EnableTransactionManagement. Found somewhere in JavaDoc of
	// Spring.

	// 1. Create DataSource
	@Bean
	public DataSource dataSource() {

		final DriverManagerDataSource d = new DriverManagerDataSource();
		d.setDriverClassName("com.mysql.jdbc.Driver");
		d.setUrl("jdbc:mysql://localhost:3306/eclipse");
		d.setPassword("root");
		d.setUsername("root");

		return d;
	}

	// 2. Use the DataSource to create EntityManagerFactory
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(final DataSource dataSource,
			final JpaVendorAdapter adapter) {

		final LocalContainerEntityManagerFactoryBean b = new LocalContainerEntityManagerFactoryBean();
		b.setDataSource(dataSource);
		b.setJpaVendorAdapter(adapter);
		b.setPackagesToScan("org.kszawala.ref.db");

		// -------------- persistence.xml --------------------------

		// <property name="hibernate.archive.autodetection" value="class" />
		// <property name="hibernate.dialect"
		// value="org.hibernate.dialect.H2Dialect" />
		// <property name="hibernate.connection.driver_class"
		// value="org.h2.Driver" />
		// <property name="hibernate.connection.url" value="jdbc:h2:mem:KS" />
		// <property name="hibernate.connection.user" value="sa" />
		// <property name="hibernate.show_sql" value="true" />
		// <property name="hibernate.flushMode" value="FLUSH_AUTO" />
		// <property name="hibernate.hbm2ddl.auto" value="create" />
		// <property name="hibernate.temp.use_jdbc_metadata_defaults"
		// value="false" />

		// final Properties persistenceXml = new Properties();
		// persistenceXml.setProperty("hibernate.flushMode", "FLUSH_AUTO");
		// persistenceXml.setProperty("hibernate.hbm2ddl.auto", "create");
		// b.setJpaProperties(persistenceXml);

		// -------------- persistence.xml --------------------------

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
