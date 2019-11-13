# chaos-variation

一款基于 SpringCloud 组件构建的分布式服务架构（持续更新），可以作学习之用

搭建环境

一、数据库 Mysql:8.0

二、缓存   Redis:3.2

    1、windows启动RabbitMq命令，
    
    2、在命令窗口中,找到redis安装地址
    
    3、使用redis-server redis.windows.conf
    
三、消息中间件 RabbitMq:3.7.16

四、消息中间件rabbitMq依赖 Erlang 22.0

#注册中心

http://localhost:8200

#zipkin链路跟踪

http://localhost:8204

#网关

http://localhost:8202

#auth2认证

http://localhost:8203

#配置中心服务端
http://localhost:8300

#配置中心客户端
http://localhost:8400
    
    1、配置中心 启动顺序 variation-server、variation-config-client、varation-config-server
    2、直接访问http://localhost:8300/variation-a.yml  获取默认配置信息
    3、访问http://10.203.116.90:8400/config/from 获取配置文件中的from数据
    4、修改gitHub中默认配置信息，执行http://localhost:8400/actuator/refresh
       出现：["config.client.version":"from"] ,表示配置修改成功
       
       
       
---未完待续。。。       






