# tool
本文件会聚合各种工具服务  
并且会生成一个便于docker（k8s）部署的版本
## lanproxy
基于lan-proxy开源代理工具，改造让其首先读取lanproxy.home，然后才读取user.home  
正在调试docker和k8s部署方式的部署(已调试完成，打包后运行Dockerfile第一行，然后运行proxy.yml即可)
## swagger2word
基于 swagger2word对swagger2的json进行解析整理成word的开源工具。  
由于其json字符串在请求参数，不好用，所以改成放在请求体中  
本服务的dockerfile和yml已经过验证，但是请自行改jar的文件名和路径
## zzx-generator，：
基于renren-generator改造   
当前实现了：swagger/lombok通过配置开启开启，优化了响应类生成，请通过application.yml和generator.properties配置  
远期目标为：可视化选择连接数据库（或提交sql）、选择是否包含swagger、lombok、用户信息，直接生成下载  
