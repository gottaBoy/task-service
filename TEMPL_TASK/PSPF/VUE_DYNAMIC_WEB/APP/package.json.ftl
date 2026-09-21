<#ibiztemplate>
TARGET=PSSYSAPP
</#ibiztemplate>
{
    "name": "${app.getCodeName()}",
    "version": "0.1.0",
    "private": true,
    "workspaces": [
        "packages/*",
        "plugins/*"
    ],
<#if app.getPSDynaModel?? && app.getPSDynaModel()??>
    <#assign dynaModel = app.getPSDynaModel()/>
    <#if dynaModel.getJOString?? && dynaModel.getJOString()?? && dynaModel.getJOString() != "">
        <#assign model = dynaModel.getJOString()?eval/>
    </#if>
</#if>
<#if model?? && model.package?? && model.package.scripts??>
    <#assign scripts = model.package.scripts/>
    "scripts": {
    <#list scripts?keys as key>
        "${key}": "${scripts[key]}"<#if scripts?size gt (key_index + 1)>,</#if>
    </#list>
    },
<#else>
    "scripts": {
        "link-model": "./node_modules/.bin/ibz link <#if pub?? && pub.getModelFolder?? && pub.getModelFolder()??> ../${pub.getModelFolder()}/PSSYSAPPS/${app.getCodeName()}  ./public/assets/model</#if>",
        "serve": "node --max_old_space_size=8102 ./node_modules/@vue/cli-service/bin/vue-cli-service serve --mode dev",
        "dev-serve": "node --max_old_space_size=8102 ./node_modules/@vue/cli-service/bin/vue-cli-service serve --mode dev",
        "build": "node --max_old_space_size=8102 ./node_modules/@vue/cli-service/bin/vue-cli-service build --mode prod",
        "micro-build": "node --max_old_space_size=8102 ./node_modules/@vue/cli-service/bin/vue-cli-service build --mode micro",
        "dev-build": "node --max_old_space_size=8102 ./node_modules/@vue/cli-service/bin/vue-cli-service build --mode dev",
        "watch": "vue-cli-service build --watch --no-clean --mode dev",
        "test:unit": "vue-cli-service test:unit",
        "test:e2e": "vue-cli-service test:e2e",
        "lint": "vue-cli-service lint"
    },
</#if>
    "dependencies": {
        "@fullcalendar/core": "^4.4.0",
        "@fullcalendar/daygrid": "^4.4.0",
        "@fullcalendar/interaction": "^4.4.0",
        "@fullcalendar/list": "^4.4.0",
        "@fullcalendar/timegrid": "^4.4.0",
        "@fullcalendar/vue": "^4.4.0",
        "@ibiz/drawer-vue": "^0.0.7",
        "@popperjs/core": "^2.9.2",
        "@babel/plugin-proposal-object-rest-spread": "^7.14.7",
        "dexie": "^3.0.3",
        "dingtalk-jsapi": "^2.13.23",
        "async-validator": "^3.5.1",
        "axios": "^0.21.1",
        "core-js": "^3.10.1",
        "echarts": "5.0.2",
        "element-ui": "^2.15.1",
        "file-saver": "^2.0.5",
        "font-awesome": "^4.7.0",
        "ibiz-core": "1.0.0",
        "ibiz-vue": "1.0.0",
        "ibiz-plugin": "1.0.0",
        "ibiz-vue-lib": "0.1.24",
        "moment": "^2.29.1",
        "vue-text-format": "^1.2.6",
        "mavon-editor": "^2.9.1",
        "path-to-regexp": "^6.2.0",
        "qs": "^6.10.1",
        "qx-util": "^0.0.7",
        "pqgridf": "^3.5.1",
        "jquery-ui-pack": "^1.12.3",
        "jszip": "^3.7.1",
        "jquery": "^3.6.0",
        "@types/jquery": "^3.5.8",
        "@types/jqueryui": "^1.12.16",
        "rxjs": "^6.6.7",
        "tinymce": "5.7.1",
        "view-design": "4.4.0",
        "vue": "^2.6.12",
        "vue-amap": "^0.5.10",
        "vue-class-component": "^7.2.6",
        "vue-grid-layout": "^2.3.12",
        "vue-i18n": "^8.24.3",
        "vue-property-decorator": "^9.1.2",
        "vue-router": "^3.5.1",
        "vuedraggable": "^2.24.3",
        "vuex": "^3.6.2",
        "@interactjs/interact": "^1.10.11",
        "@interactjs/auto-start": "^1.10.11",
        "@interactjs/actions": "^1.10.11",
        "@interactjs/modifiers": "^1.10.11",
        "@interactjs/dev-tools": "^1.10.11",
        "@ibiz/dynamic-model-api": "2.1.24",
        "@ibiz/model-location": "0.0.8",
        "xgplayer":"2.31.4",
        "ramda": "^0.27.1",
        "element-resize-detector": "^1.2.2",
        "monaco-editor": "^0.24.0",
        "json-editor": "^0.7.28",
        "monaco-editor-webpack-plugin": "^3.1.0",
<#if app.getAllPSAppPkgs?? && app.getAllPSAppPkgs()??>
    <#list app.getAllPSAppPkgs() as appPackage>
        <#if appPackage.getVerParam()?? && appPackage.getVerParam() !="">
        ${appPackage.getVerParam()},
        </#if>
    </#list>
</#if>
        "xlsx": "^0.16.9"
    },
    "devDependencies": {
        "@ibiz/cli": "0.2.7",
        "@types/echarts": "^4.9.7",
        "@types/mockjs": "^1.0.3",
        "@types/qs": "^6.9.6",
        "@vue/cli-plugin-babel": "^4.5.12",
        "@vue/cli-plugin-router": "^4.5.12",
        "@vue/cli-plugin-typescript": "^4.5.12",
        "@vue/cli-plugin-vuex": "^4.5.12",
        "@vue/cli-service": "^4.5.12",
        "@vue/test-utils": "1.1.4",
        "axios-mock-adapter": "^1.19.0",
        "compression-webpack-plugin": "^5.0.1",
        "less": "3.13.1",
        "less-loader": "^7.3.0",
        "mockjs": "^1.1.0",
        "script-loader": "^0.7.2",
        "typescript": "^4.2.4",
<#if app.getAllPSAppPkgs?? && app.getAllPSAppPkgs()??>
    <#list app.getAllPSAppPkgs() as appPackage>
        <#if appPackage.getVerParam2()?? && appPackage.getVerParam2() !="">
        ${appPackage.getVerParam2()},
        </#if>
    </#list>
</#if>
        "vue-template-compiler": "^2.6.12"
    }
}