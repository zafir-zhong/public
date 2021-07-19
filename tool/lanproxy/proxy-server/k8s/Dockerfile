# docker build -t tool/lan-proxy:1.0.00-release .

FROM openjdk:8-jdk-alpine

RUN \
    ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    echo "Asia/Shanghai" > /etc/timezone && \
    mkdir -p /app && \
    mkdir -p /app/data && \
    chmod -R 777 /app/
# 路径请执行核对
ADD  proxy-server-0.1/ /app/
# 如有需要，自己拷贝路径
#ADD  home.jks /app/config/home.jks

#用于调试的可以休眠而不执行
# ENTRYPOINT ["sh","-c","sleep 10000"]
ENTRYPOINT ["sh","/app/bin/startup.sh"]