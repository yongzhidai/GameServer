# GameServer
一个服务器处理框架，包括 协议处理，消息处理，持久层数据处理

目录结构介绍：
	src ---源程序目录
	 |-dbsqlmapper   ---mybaits sqlmap文件目录
	resource 	     ---源目录，存放配置文件
	mybatis-generate ---mybatis-generator的配置文件
	Tomcat-config    ---tomcat的配置文件，配置了context以及数据源
	WEB-INF          ---项目的部署目录
	 
架构思路：
	使用Tomcat做启动
		使用tomcat提供的数据源
		使用tomcat提供的热加载机制
		后期方便添加web界面功能，来对服务器的管理
	使用mybatis做持久层
		采用mybatis-generator做自动代码生成工具，减少开发中对数据库编码的工作量
	使用mina2.0.9做网络通信
		提供网络通信的性能和稳定