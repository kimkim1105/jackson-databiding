//package cmc.com.demo.appconfig;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "barEntityManagerFactory",
//        transactionManagerRef = "barTransactionManager",
//        basePackages = { "cmc.com.demo.repository.bar" }
//)
//public class BarDbConfig {
//    @Bean(name = "barDataSource")
//    @ConfigurationProperties(prefix = "bar.datasource")
//    public DataSource barDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "barEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean
//    barEntityManagerFactory(
//            EntityManagerFactoryBuilder builder,
//            @Qualifier("barDataSource") DataSource barDataSource
//    ) {
//        return
//                builder
//                        .dataSource(barDataSource)
//                        .packages("cmc.com.demo.entity.bar")
//                        .persistenceUnit("foo")
//                        .build();
//    }
//    @Bean(name = "barTransactionManager")
//    public PlatformTransactionManager barTransactionManager(
//            @Qualifier("barEntityManagerFactory") EntityManagerFactory
//                    barEntityManagerFactory
//    ) {
//        return new JpaTransactionManager(barEntityManagerFactory);
//    }
//}
