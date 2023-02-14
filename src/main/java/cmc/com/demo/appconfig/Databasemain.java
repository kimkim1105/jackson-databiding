//package cmc.com.demo.appconfig;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//@ComponentScan("")
//@PropertySource("file:./database.properties")
//@EnableJpaRepositories(
//        basePackages = "org.paulushc",
//        entityManagerFactoryRef = "mainEntityManager",
//        transactionManagerRef = "mainTransactionManager")
//public class DatabaseMain() {
//
//    @Value("${main.db.driver}")
//    private String driver;
//    @Value("${main.db.url}")
//    private String url;
//    @Value("${main.db.username}")
//    private String username;
//    @Value("${main.db.password}")
//    private String password;
//    @Value("${hibernate.dialect}")
//    private String dialect;
//    @Value("${hibernate.show_sql}")
//    private boolean showSQL;
//    @Value("${hibernate.format_sql}")
//    private boolean formatSQL;
//    @Value("${entitymanager.packages.to.scan}")
//    private String packageScan;
//    @Value("${connection.release_mode}")
//    private String releaseMode;
//
//    @Bean(name = "mainDataSource")
//    @Primary
//    public DataSource mainDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(driver);
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        return dataSource;
//    }
//
//    @Bean(name = "mainEntityManager")
//    @Primary
//    public LocalContainerEntityManagerFactoryBean mainEntityManager() {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(mainDataSource());
//        em.setPackagesToScan(new String[] { packageScan });
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        em.setJpaProperties(hibernateProperties());
//
//        return em;
//    }
//
//    @Bean(name = "mainTransactionManager")
//    @Primary
//    public PlatformTransactionManager mainTransactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(mainEntityManager().getObject());
//        return transactionManager;
//    }
//
//    @Bean(name = "mainSessionFactory")
//    @Primary
//    public LocalSessionFactoryBean mainSessionFactory() {
//        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
//        sessionFactoryBean.setDataSource(mainDataSource());
//        sessionFactoryBean.setPackagesToScan(packageScan);
//        sessionFactoryBean.setHibernateProperties(hibernateProperties());
//        return sessionFactoryBean;
//    }
//
//    private Properties hibernateProperties() {
//        Properties properties = new Properties();
//        properties.put("hibernate.hbm2ddl.auto", false);
//        properties.put("hibernate.dialect", dialect);
//        properties.put("hibernate.temp.use_jdbc_metadata_defaults", "false");
//        properties.put("hibernate.show_sql",showSQL);
//        properties.put("hibernate.format_sql",formatSQL);
//        properties.put("entitymanager.packages.to.scan",packageScan);
//        properties.put("connection.release_mode",releaseMode);
//        return properties;
//    }
//}
