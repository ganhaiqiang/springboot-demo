# springboot 2.x demo
==================================
##### springboot 2.0版本主要改动
------ ---------------------------------------------------
##### 1 、Spring Boot 2是完全基于java8，这也就证明了java8已经被大家全面接受和普及， 虽然java9也已经发布， 但是java9的普及可能还需要一段时间，但是现在Spring Boot 2也同时对java9做了一些支持。
##### 2 、http请求方面， 引入了Webflux， 他是基于Spring Webflux， 它是一个新的非堵塞函数式 Reactive Web 框架，可以用来建立异步的，非阻塞，事件驱动的服务，并且扩展性非常好。性能对比于之前的同步方式有了一定的提高
##### 3 、db方面，默认引入了HikariCP，替代了之前的tomcat-pool作为底层的数据库连接池， 对比于tomcat-pool， HikariCP拥有更好的性能，总而言之就是提高了db的访问速度。
##### 4 、redis方面， 默认引入了Lettuce, 替代了之前的jedis作为底层的redis链接方式， 同样Lettuce底层基于netty框架，使用异步的方式，访问redis，并且如果结合之前的Webflux, 可以达成请求的全异步， 同样对比于之前的jedis，统一了redis和redis-cluster的访问方式，简化了开发人员的使用方式，同时也提高了redis的访问速度
##### 5 、es方面，默认也从之前的支持es2升级到了es5+, es5也出来了一段时间， 大部分的人应该也是通过自己实现来完成es5的对接， 现在springboot2也是进行了es5的支持。
##### 6 、metrics方面，Spring Boot 2引入了Micrometer，来统一metrics的规范，使得开发人员更好的理解和使用metrics的模块，而不需要关心对接的具体存储是什么东西。
##### 7 、Spring Boot 2 同时也加入了 对于OAuth 2.0的支持， 使得开发人员更加友好的和方面的使用spring-security来完成权限模块的开发
##### 8、目前Spring Boot 2已经发不了RC2的版本了，官方在2月28日也会正式发布第一个Release版本