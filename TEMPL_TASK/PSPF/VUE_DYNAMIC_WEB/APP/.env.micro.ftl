<#ibiztemplate>
TARGET=PSSYSAPP
</#ibiztemplate>
# .env.micro 用于微应用环境构建
// 打包模式（使用vue本身机制）
NODE_ENV=production
// 是否为开发模式
VUE_APP_DEVMODE=false
// 是否开启权限认证
VUE_APP_ENABLEPERMISSIONVALID=true
// 打包基础路径
VUE_APP_PUBLICPATH=http://localhost:8080