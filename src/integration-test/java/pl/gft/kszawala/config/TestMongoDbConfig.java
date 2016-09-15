package pl.gft.kszawala.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@ComponentScan
// @see https://www.mkyong.com/mongodb/spring-data-mongodb-hello-world-example/
public class TestMongoDbConfig extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {

		return "test";
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {

		return new MongoClient("127.0.0.1:27017");
	}
}
