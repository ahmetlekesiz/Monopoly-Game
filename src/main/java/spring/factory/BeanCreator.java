package spring.factory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanCreator {

    public static BeanCreator instance = new BeanCreator();

    private BeanCreator() {}


    /**
     *
     * @param configClass
     * @param consumerClass
     * @param <T>
     * @return
     */
    public <T> T createBean(Class<?> configClass, Class<T> consumerClass) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(configClass);
        return applicationContext.getBean(consumerClass);
    }
}
