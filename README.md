# SpringCloudDemos

#运行eureka-server服务端
1、windows需要在hosts中添加映射  

127.0.0.1 master  
127.0.0.1 backup1  
127.0.0.1 backup2

2、使用eclipse启动时，分别指定不同的active propfiles，这里使用的是maven启动三个eureka-server  

spring-boot:run -Dspring.profiles.active=peer1  
spring-boot:run -Dspring.profiles.active=peer2  
spring-boot:run -Dspring.profiles.active=peer3    

![激活peer2配置文件示例](https://github.com/super2013/SpringCloudDemos/blob/master/imges/use_profiles_active.png)

启动成功后，访问http://master:1111/，输入账号密码admin和123456  

![master界面](https://github.com/super2013/SpringCloudDemos/blob/master/imges/peer1_master_server.png)
