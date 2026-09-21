<#ibiztemplate>
TARGET=PSSYSAPP
</#ibiztemplate>
FROM registry.cn-shanghai.aliyuncs.com/ibizops/nginx-dynamic:v1

WORKDIR /
COPY dist /dist