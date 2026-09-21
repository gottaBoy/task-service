<#ibiztemplate>
TARGET=PSSYSAPP
</#ibiztemplate>
declare module '*.vue' {
  import Vue from 'vue';
  export default Vue;
}
declare module 'vue-quill-editor';
declare module 'weixin-js-sdk';
declare module 'v-calendar/lib/components/calendar.umd';
declare module 'vue-touch';
declare module 'vue-amap';
declare module 'vue-qr';
declare module 'vue-text-format';
declare module 'less';
<#if app.getAllPSAppPkgs?? && app.getAllPSAppPkgs()??>
<#list app.getAllPSAppPkgs() as appPackage>
<#if appPackage.getVerParam2()?? && appPackage.getVerParam2() !="">declare module '${appPackage.getVerParam2()}';</#if>
</#list>
</#if>