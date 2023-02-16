FROM amazoncorretto:11-alpine-jdk

LABEL source="https://github.com/albertloubet/pix-manager.git" \
   maintainer="albertloubet"

EXPOSE 8082

ADD build/distributions/*boot*.zip /pix-manager.zip

RUN unzip -o pix-manager && \
  rm -rf *.zip && \
  mv pix-manager-* pix-manager && \
  useradd pixmanagersuser

USER pixmanagersuser

ENTRYPOINT [ "/pix-manager/bin/pix-manager", "-Djava.security.egd=file:/dev/./urandom"]