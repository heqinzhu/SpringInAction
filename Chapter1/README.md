# Spring
Learning in springframework!
-------------------------------------------------------------------------------
#**_Chapter 1_**

##DI和AOP

###**名词解释**
**DI:** Dependency Injection(依赖注入)\
**AOP:** Aspect-Oriented Programming(面向切面编程)

###**过程简述**    
依赖注入：对象的依赖关系将由系统中负责协调各对象的第三方组件在创建对象的时候设定(程序编写者指定)。对象无需自行创建或管理他们的依赖关系，依赖关系将被自动注入到他们需要的对象当中去。
面向切面编程：促使软件系统实现功能点分离的过程。

###**作用**
DI能够让相互协作的软件组件保持松散耦合，AOP允许你把遍布应用各处的功能分离出来形成可复用的重要组件。


##Spring容器
###定义
容器是Spring框架的核心。Spring容器使用DI管理构成应用的组件，它会创建相互协作的组件之间的关联。

###容器分类
1. bean工厂(由 org.springframework.beans.factory.BeanFactory接口定义)是最简单的容器，提供基本的DI支持。
2. 应用上下文(由 org.springframework.context.ApplicationContext接口定义)基于BeanFactory构建，并提供应用框架级别的服务。
**其中，应用上下文比bean工厂更受欢迎。**

###获取应用上下文的几种方式
Spring自带了多种类型应用上下文，常用的有：
- AnnotationConfigApplicationContext:从一个或多个基于java的配置类中加载Spring上下文。
- AnnotationConfigWebApplicationContext:从一个或多个基于java的配置类中加载Spring Web上下文。
- ClassPathXmlApplicationContext:从类路径下的一个或多个XML配置文件中加载上下文定义，把应用上下文的定义文件作为类资源。
- FileSystemXmlApplicationContext:从文件系统下的一个或多个XML配置文件中加载上下文定义。
- XmlWebApplicationContext:从Web应用下的一个或多个XML配置文件中加载上下文定义。
---
#**_Chapter 2_**
##Spring的配置可选方案
- 在XML中显式配置；
+ 在Java中显式配置；
* 隐式的bean发现机制和自动装配

###自动装配
+ 组件扫描(*component scanning*)：Spring会自动发现应用上下文中所创建的bean。
+ 自动装配(*autowiring*)：Spring自动满足bean之间的依赖。

####组件扫描

1. 定义组件
```java
 package src.main.soundsystem;
 import org.springframework.stereotype.Component;
 @Component
 public class SgtPeppers implements CompactDisc {
     private String title = "Sgt. Pepper's lonely Hearts Club Band";
     private String artist = "The Beatles";
     @Override
     public void play() {
         System.out.println("Playing "+ title +"by " +artist);
     }
 }
```
2. 扫描
- xml形式
```xml
<!--spring配置文件 可通过此配置开启包扫描，对定义的组件进行自动扫描实例到容器 -->
<bean>
    <content:component-scan base-package="org.springframework.stereotype.Component"></content>
</bean>
```
- Java Configuration
```java
package src.main.soundsystem;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan/* 默认会扫描与配置类相同的包 同 xml形式 <context:component-scan base-package="src.main.java.soundsystem">*/
public class CDPlayerConfig {
}
```



