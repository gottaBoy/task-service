<#ibiztemplate>
TARGET=PSSYSTEM
</#ibiztemplate>
<#if pub.isEnableModelRT()>
package ${pub.getPKGCodeName()}.runtime;

import net.ibizsys.central.cloud.core.IServiceSystemRuntime;

public interface ISystemRuntime extends IServiceSystemRuntime {
 
<#assign demodelhelper = pub.getStyleParam('DEMODELHELPER','FALSE')?upper_case>
<#comment><#assign demodelhelper = 'TRUE'></#comment>
<#if demodelhelper?length gt 0 && demodelhelper=="TRUE">
<#if sys.getAllPSDataEntities()??>
<#list sys.getAllPSDataEntities() as de>
<#if !(de.getPSSystemModule().getPSSysModelGroup()??)>
    /**
     * 实体 ${de.logicName} 相关信息
     */
    public final class ${de.name?upper_case}{
        final public static String NAME = "${de.name?upper_case}";
    <#if de.getDynaModelFilePath()?? && de.getDynaModelFilePath()?length gt 0>
        final public static String ID = "${de.getDynaModelFilePath()}";
    </#if>
    <#if de.getAllPSDEFields()??>
    <#list de.getAllPSDEFields() as defield>
        //${defield.logicName}
        final public static String FIELD_${defield.name?upper_case} = "${defield.name?upper_case}";
    </#list>
    </#if>
    <#if de.getAllPSDEActions()??>
    <#list de.getAllPSDEActions() as deaction>
        //${deaction.logicName}
        final public static String ACTION_${deaction.name?upper_case} = "${deaction.name?upper_case}";
    </#list>
    </#if>
    <#if de.getAllPSDEDataSets()??>
    <#list de.getAllPSDEDataSets() as dedataset>
        //${dedataset.logicName}
        final public static String DATASET_${dedataset.name?upper_case} = "${dedataset.name?upper_case}";
    </#list>
    </#if>
    <#if de.getAllPSDEDataQueries()??>
    <#list de.getAllPSDEDataQueries() as dedataquery>
        //${dedataquery.logicName}
        final public static String DATAQUERY_${dedataquery.name?upper_case} = "${dedataquery.name?upper_case}";
    </#list>
    </#if>
    }

</#if>
</#list>
</#if>
</#if>

<#assign clmodelhelper = pub.getStyleParam('CLMODELHELPER','FALSE')?upper_case>
<#if clmodelhelper?length gt 0 && clmodelhelper=="TRUE">
<#if sys.getAllPSCodeLists()??>
<#list sys.getAllPSCodeLists() as cl>
<#if cl.getCodeListType() == 'STATIC' && cl.getPSSystemModule()?? && !(cl.getPSSystemModule().getPSSysModelGroup()??)>
    /**
     * 代码表 ${cl.name} 相关信息
     */
    public enum ${cl.getPSSystemModule().codeName}__${cl.codeName}{
    <#if cl.getAllPSCodeItems()??>
    <#list cl.getAllPSCodeItems() as codeitem>
        <#if codeitem_index gt 0>,</#if>${codeitem.codeName?upper_case}(<#if cl.isCodeItemValueNumber()>${codeitem.getValue()}<#else>"${codeitem.getValue()?j_string}"</#if>, "${codeitem.getText()?j_string}")
    </#list>
        ;
    </#if>
        public final String text;
        <#if cl.isCodeItemValueNumber()>
        public final int value;
        <#else>
        public final String value;
        </#if>
        <#if cl.isCodeItemValueNumber()>
        private ${cl.getPSSystemModule().codeName}__${cl.codeName}(int value, String text){
        <#else>
        private ${cl.getPSSystemModule().codeName}__${cl.codeName}(String value, String text){
        </#if>
            this.value = value;
            this.text = text;
        }

        <#if cl.isCodeItemValueNumber()>
        public static ${cl.getPSSystemModule().codeName}__${cl.codeName} from(int value){
        <#else>
        public static ${cl.getPSSystemModule().codeName}__${cl.codeName} from(String value){
        </#if>
            switch(value){
            <#if cl.getAllPSCodeItems()??>
            <#list cl.getAllPSCodeItems() as codeitem>
            <#if cl.isCodeItemValueNumber()>
            case ${codeitem.getValue()}: return ${cl.getPSSystemModule().codeName}__${cl.codeName}.${codeitem.codeName?upper_case};
            <#else>
            case "${codeitem.getValue()?j_string}": return ${cl.getPSSystemModule().codeName}__${cl.codeName}.${codeitem.codeName?upper_case};
            </#if>
            </#list>
            </#if>
            default:
                return null;
            }    
        }
    }

</#if>
</#list>
</#if>
</#if>

}
</#if>