//package cmc.com.demo.appconfig;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.jpa.HibernateEntityManagerFactory;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import java.util.List;
//import java.util.Properties;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "entityManagerFactory",
//        basePackages = { "cmc.com.demo.repository.foo" }
//)
//public class FooDbConfig {
//    @Primary
//    @Bean(name = "dataSource")
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Primary
//    @Bean(name = "entityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean
//    entityManagerFactory(
//            EntityManagerFactoryBuilder builder,
//            @Qualifier("dataSource") DataSource dataSource
//    ) {
//        return builder
//                .dataSource(dataSource)
//                .packages("cmc.com.demo.entity.foo")
//                .persistenceUnit("foo")
//                .build();
//    }
//
//    @Primary
//    @Bean(name = "transactionManager")
//    public PlatformTransactionManager transactionManager(
//            @Qualifier("entityManagerFactory") EntityManagerFactory
//                    entityManagerFactory
//    ) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
////    @Bean
////    @Qualifier(value = "entityManager")
////    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
////        return entityManagerFactory.createEntityManager();
////    }
//
//    @Bean(name = "sessionFactoryBean")
//    public LocalSessionFactoryBean sessionFactoryBean(@Qualifier("dataSource") DataSource dataSource) {
//        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
//        sessionFactoryBean.setDataSource(dataSource);
////        sessionFactoryBean.setHibernateProperties(hibernateProperties);
////        sessionFactoryBean.setMappingResources(hibernateMappings.toArray(new String[hibernateMappings.size()]));
//        return sessionFactoryBean;
//    }
//
//    @Bean
//    public SessionFactory sessionFactory(LocalSessionFactoryBean sessionFactoryBean) {
//        return sessionFactoryBean.getObject();
//    }
//
////
////    @Bean(name = "barDataSource")
////    @ConfigurationProperties(prefix = "bar.datasource")
////    public DataSource barDataSource() {
////        return DataSourceBuilder.create().build();
////    }
////
////    @Bean(name = "barEntityManagerFactory")
////    public LocalContainerEntityManagerFactoryBean
////    barEntityManagerFactory(
////            EntityManagerFactoryBuilder builder,
////            @Qualifier("barDataSource") DataSource barDataSource
////    ) {
////        return
////                builder
////                        .dataSource(barDataSource)
////                        .packages("cmc.com.demo.entity.bar")
////                        .persistenceUnit("bar")
////                        .build();
////    }
////    @Bean(name = "barTransactionManager")
////    public PlatformTransactionManager barTransactionManager(
////            @Qualifier("barEntityManagerFactory") EntityManagerFactory
////                    barEntityManagerFactory
////    ) {
////        return new JpaTransactionManager(barEntityManagerFactory);
////    }
//
//}
