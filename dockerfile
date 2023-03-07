FROM registry-dev.yinzuo.cn/kubesphere/java-8-centos7:v2.1.0
USER root
WORKDIR /root
COPY target/*.jar /root/
CMD  mkdir -p /root/logs/inzone-order-data-sync & java -jar *.jar --spring.profiles.active=$conf_path