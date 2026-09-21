<#ibiztemplate>
TARGET=PSSYSAPP
</#ibiztemplate>
.DS_Store
node_modules
/dist

/tests/e2e/videos/
/tests/e2e/screenshots/

# local env files
.env.local
.env.*.local

# Log files
npm-debug.log*
yarn-debug.log*
yarn-error.log*

# Editor directories and files
.idea
.vscode
*.suo
*.ntvs*
*.njsproj
*.sln
*.sw?
.history

# 排除模型 link 文件提交
public/assets/model