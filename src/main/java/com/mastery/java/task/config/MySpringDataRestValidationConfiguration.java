//package com.mastery.java.task.config;
//
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class MySpringDataRestValidationConfiguration extends RepositoryRestConfigurerAdapter {
//
//    @Bean
//    @Primary
//    /**
//     * Create a validator to use in bean validation - primary to be able to autowire without qualifier
//     */
//    Validator validator() {
//        return new LocalValidatorFactoryBean();
//    }
//
//    @Bean
//    //the bean name starting with beforeCreate will result into registering the validator before insert
//    public BeforeCreateCompanyValidator beforeCreateCompanyValidator() {
//        return new BeforeCreateCompanyValidator();
//    }
//
//    @Override
//    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
//        Validator validator = validator();
//        //bean validation always before save and create
//        validatingListener.addValidator("beforeCreate", validator);
//        validatingListener.addValidator("beforeSave", validator);
//    }
//}
