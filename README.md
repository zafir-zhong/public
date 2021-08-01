# tool
本文件会聚合各种工具服务  
并且会生成一个便于docker（k8s）部署的版本
## lanproxy
基于lan-proxy开源代理工具，改造让其首先读取lanproxy.home，然后才读取user.home  
已调试完成，打包后运行Dockerfile第一行，然后运行proxy.yml即可
打包成容器的逻辑为：拷贝server中的内容，放到指定目录，设置正确的权限
k8s部署逻辑为：通过挂载本地目录覆盖config内容，并通过节点上的proxydata标签选择有数据的节点（你也可以通过其他方式进行数据挂载）
端口对外暴露方式为：把不同端口映射到节点端口上，由于我推荐使用ssl，所以我只暴露了ssl对应的端口。
而公网实际端口也是通过映射方式暴露的，所以管理端填的虽然是80，但是实际对外的端口不是。
进行验证的限制是为了更安全
## swagger2word
基于 swagger2word对swagger2的json进行解析整理成word的开源工具。  
由于其json字符串在请求参数，不好用，所以改成放在请求体中  
本服务的dockerfile和yml已经过验证，但是请自行检查jar的文件名和路径
## zzx-generator：

基于renren-generator改造   
当前实现了：swagger/lombok通过配置开启开启，优化了响应类生成，请通过application.yml和generator.properties配置  
远期目标为：可视化选择连接数据库（或提交sql）、选择是否包含swagger、lombok、用户信息，直接生成下载  



# simple-service
提供一个模拟服务的模板，分别有个参数控制进入返回成功还是失败的文件
