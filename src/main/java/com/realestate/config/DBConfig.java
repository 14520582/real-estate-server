package com.realestate.config;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration 
@EnableJpaRepositories(basePackages = "com.realestate.dao")
@EnableTransactionManagement(proxyTargetClass = true)
@PropertySource("classpath:database.properties")
public class DBConfig {
	@Autowired
        private Environment env;	
	  @Bean
	  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	    
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setDatabase(Database.MYSQL);
	    vendorAdapter.setGenerateDdl(true);
	    
	    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	    em.setDataSource(getDataSource());
	    em.setPackagesToScan("com.realestate.entity");
	    em.setJpaVendorAdapter(vendorAdapter);
	    em.setJpaProperties(jpaProperties());
	 
	    return em;
	  }
	@Bean
	public JpaVendorAdapter getJpaVendorAdapter() {
		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		return adapter;
	}
    @Bean
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName(env.getProperty("database.driverClassName"));
	    dataSource.setUrl(env.getProperty("database.url"));
	    dataSource.setUsername(env.getProperty("database.username"));
	    dataSource.setPassword(env.getProperty("database.password"));
	    return dataSource;
	}
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(emf);
    
      return transactionManager;
    }
	  @Bean
	  public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	    return new PersistenceExceptionTranslationPostProcessor();
	  }
        private Properties jpaProperties() {
            Properties properties = new Properties();
            properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
            properties.put("hibernate.id.new_generator_mappings", env.getProperty("hibernate.id.new_generator_mappings"));
            properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
            properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
            properties.put("hibernate.enable_lazy_load_no_trans", env.getProperty("hibernate.enable_lazy_load_no_trans"));
            return properties;        
        }	
} 