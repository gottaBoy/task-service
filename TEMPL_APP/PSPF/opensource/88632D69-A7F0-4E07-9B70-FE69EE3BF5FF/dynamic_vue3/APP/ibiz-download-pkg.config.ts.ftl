<#ibiztemplate>
TARGET=PSSYSAPP
</#ibiztemplate>
<#assign pluginList = []>
<#if app.getAllPSAppPFPluginRefs?? && app.getAllPSAppPFPluginRefs()??>
<#list app.getAllPSAppPFPluginRefs() as plugin>
  <#if plugin.getRTObjectRepo?? && plugin.getRTObjectRepo()??>
    <#assign pluginList = pluginList + [plugin.getRTObjectRepo()]>
  </#if>
</#list>
</#if>
<#assign uniquePluginlist = []>
<#list pluginList as plugin>
  <#if !uniquePluginlist?seq_contains(plugin)>
    <#assign uniquePluginlist = uniquePluginlist + [plugin]>
  </#if>
</#list>
// eslint-disable-next-line import/no-extraneous-dependencies
import { defineDownloadPkgConfig } from '@ibiz-template/cli';
import { refAppPkgConfig } from './ibiz-ref-app-pkg.config';

export default defineDownloadPkgConfig({
  clean: true,
  registry: 'http://172.16.240.221:8081/repository/ibizsys/',
  outDir: './public/plugins',
  // 依赖包填写示例
  dependencies: [
    ...refAppPkgConfig,
    <#list uniquePluginlist as plugin>
    '${plugin}',
    </#list>
  ],
});
