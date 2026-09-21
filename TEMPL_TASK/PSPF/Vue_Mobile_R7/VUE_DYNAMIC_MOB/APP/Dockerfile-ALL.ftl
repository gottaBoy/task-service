<#ibiztemplate>
TARGET=PSSYSAPP
</#ibiztemplate>
FROM image.ibizlab.cn/library/nginx-dynamic:v4

WORKDIR /
COPY dist /dist