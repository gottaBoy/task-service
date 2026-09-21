import { Component, Vue } from 'vue-property-decorator';
@Component({})
export default class ${srfclassname('${ctrl.codeName}')} extends Vue {

    /**
     * 表单数据对象
     *
     * @type {*}
     * @memberof ${srfclassname('${ctrl.codeName}')}Base
     */
    public data: any = {
        <#list ctrl.getAllPSDEFormDetails() as item>
        <#if item.getDetailType?? && item.getDetailType()?? && (item.getDetailType() == "FORMITEM" || item.getDetailType() == "FORMPART")>
        ${item.getName()}: null,
        </#if>
        </#list>
        ${ctrl.getPSAppDataEntity().getCodeName()?lower_case}:null,
    };


    /**
     * 绘制表单
     *
     * @return {*} 
     * @memberof ${srfclassname('${ctrl.codeName}')}
     */
    render(){
        return (
            ${P.getPartCode(item,'FORM').code}
        )
    }


}