FROM java:8
MAINTAINER ipcc

#读取参数信息,兼容docker旧版本,旧版本不支持参数
# 读取环境变量 $N,读取参数${N}
#ARG APP_NAME
#ARG PROFILE_ACTIVE

#ENV APP_NAME=""
#ENV PROFILE_ACTIVE=""

ENV JAVA_OPTIONS=""

RUN echo 'Asia/Shanghai' >/etc/timezone
RUN mkdir /tools; mkdir -p /data/template; mkdir -p /data/file; mkdir -p /data/log; chmod 777 /tools; chmod 777 /data;
EXPOSE 8888/tcp
VOLUME ["/tools", "/data"]
ADD root.jar /tools/app.jar
ADD boot.conf /tools/boot.conf
RUN bash -c 'touch /tools/app.jar'
RUN bash -c 'touch /tools/boot.conf'
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTIONS -jar /tools/app.jar