<#ibiztemplate>
TARGET=PSSYSAPP
</#ibiztemplate>
FROM srcimagename

WORKDIR /dist/assets
RUN rm -rf model
COPY model model