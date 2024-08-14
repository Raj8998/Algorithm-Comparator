package com.project.algocomparator.constants;

public class MySQLDBConfigurationConstants {
	public static final String ENTITY_MANAGER = "entityManager";
	public static final String TRANSACTION_MANAGER = "transactionManager";
	public static final String PERSISTENCE_UNIT = "mysqlPU";
	public static final String BASE_PACKAGES = "com.project.algocomparator";
	public static final String DATA_SOURCE_BEAN = "dataSource";
	public static final String SCHEMA_INITIALIZER_BEAN = "schemaInitializer";
	public static final String DATA_INITIALIZER_BEAN = "dataInitializer";
	
	public static final String DB_DRIVER = "db.driver";
	public static final String DB_URL = "db.url";
	public static final String DB_USERNAME = "db.username";
	public static final String DB_PASSWORD = "db.password";
	public static final String DB_SCHEMA = "db.schema";
	public static final String DB_INIT_DATA = "db.data";
	
	public static final String DB_MIN_POOL_SIZE = "c3p0.min_size";
	public static final String DB_MAX_POOL_SIZE = "c3p0.max_size";
	public static final String DB_IDLE_TEST_PERIOD = "c3p0.idle_test_period";
	public static final String DB_TIMEOUT = "c3p0.timeout";
	public static final String DB_MAX_STATEMENTS = "c3p0.max_statements";
}
