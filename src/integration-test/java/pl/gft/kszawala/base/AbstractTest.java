package pl.gft.kszawala.base;

import javax.transaction.Transactional;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import pl.gft.kszawala.config.TestH2Config;

@Transactional
@ContextConfiguration(classes = TestH2Config.class)
@Sql({ "/test-insert-cars.sql" })
@Sql(value = "/test-clean-cars.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class AbstractTest {

}
