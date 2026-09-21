import { Component, Prop } from 'vue-property-decorator';
import { IPSAppDEIndexView } from '@ibiz/dynamic-model-api';
import { ModelTool } from 'ibiz-core';
import { AppDefaultViewLayout } from '../app-default-view-layout/app-default-view-layout';

/** 
 * @description 应用实体首页视图默认样式视图布局面板
 * @export
 * @class AppDefaultDeIndexViewLayout
 * @extends {AppDefaultViewLayout}
 */
@Component({})
export class AppDefaultDeIndexViewLayout extends AppDefaultViewLayout {
    /**
     * 
     *
     * @type {IPSAppDEIndexView}
     * @memberof AppDefaultDeIndexViewLayout
     */
    @Prop() public declare viewInstance: IPSAppDEIndexView;

    /**
     * 引擎初始化
     *
     * @param {*} [opts={}]
     * @memberof AppDefaultDeIndexViewLayout
     */
    public engineInit(opts: any = {}) {
        const controls: any[] = this.containerModel.getPSControls() || [];
        let engineOpts = Object.assign({
            view: this,
            p2k: '0',
            isLoadDefault: true,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase()
        }, opts);
        //  表单
        const form = ModelTool.findPSControlByType('FORM', controls);
        if (form) {
            Object.assign(engineOpts, { form: (this.$refs[form.name] as any).ctrl });
        }
        //  数据关系栏
        const drbar = ModelTool.findPSControlByType('DRBAR', controls);
        if (drbar) {
            Object.assign(engineOpts, { drbar: (this.$refs[drbar.name] as any).ctrl })
        }
        this.engine.init(engineOpts);
    }
    
}