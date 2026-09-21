import { Component, Prop } from 'vue-property-decorator';
import { IPSLanguageRes } from '@ibiz/dynamic-model-api';
import { AppDefaultFormDetail } from '../app-default-form-detail/app-default-form-detail';

/**
 * 表单UI组件
 *
 * @export
 * @class AppDefaultFormTabPage
 * @extends {Vue}
 */
@Component({})
export class AppDefaultFormTabPage extends AppDefaultFormDetail {

    /**
     * 表单数据
     *
     * @type {*}
     * @memberof AppDefaultFormTabPage
     */
    @Prop() public data: any;

    /**
     * 绘制表单分页标题
     *
     * @param {*} viewPanel
     * @returns
     * @memberof AppDefaultFormTabPage
     */
     public renderLabel() {
        const { caption } = this.detailsInstance;
        const sysCss = this.detailsInstance.getLabelPSSysCss();
        const sysImg = this.detailsInstance.getPSSysImage();
        let labelClass = sysCss?.cssName ? 'caption ' + sysCss.cssName : 'caption';
        let labelCaption: any = this.$tl((this.detailsInstance.getCapPSLanguageRes() as IPSLanguageRes)?.lanResTag, caption);
        let labelIcon: any;
        if(sysImg){
            if(sysImg?.imagePath){
                labelIcon = <img src={sysImg?.imagePath} style={{'margin-right' : '4px'}}></img>
            }else{
                labelIcon = <i class={sysImg?.cssClass} style={{'margin-right' : '4px'}}></i>
            }
        }
        return <span class={labelClass}>
            {labelIcon}{labelCaption}
        </span>
    }

    /**
     * 绘制内容
     *
     * @returns {*}
     * @memberof AppDefaultFormTabPage
     */
    public render(): any {
        const { detailClassNames } = this.renderOptions;
        const { codeName } = this.detailsInstance;
        const tabsName = this.detailsInstance?.getParentPSModelObject()?.name;
        if(this.detailsInstance.dynaClass){
            const context = this.context;
            const viewparams = this.viewparams;
            const data = this.data;
            Object.assign(detailClassNames,...eval(this.detailsInstance.dynaClass))
        }
        return  <tab-pane label={this.renderLabel} name={codeName} index={this.index} tab={tabsName} class={detailClassNames} style={this.runtimeModel.visible ? '' : 'display: none;'}>
            {this.$slots.default}
        </tab-pane>
    }
}
