package com.fun.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Inherited允许子类继承父类中的注解
 * @Documented注解表明制作javadoc时，
 * 是否将注解信息加入文档。如果注解在声明时使用了@Documented，
 * 则在制作javadoc时注解信息会加入javadoc。
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    String value() default "";
}
