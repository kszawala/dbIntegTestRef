package org.kszawala.ref.db.base;

import javax.transaction.Transactional;

import org.kszawala.ref.db.config.TestH2Config;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@Transactional
@ContextConfiguration(classes = TestH2Config.class)
@Sql({ "/test-insert-cars.sql" })
@Sql(value = "/test-clean-cars.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class AbstractTest {

}
