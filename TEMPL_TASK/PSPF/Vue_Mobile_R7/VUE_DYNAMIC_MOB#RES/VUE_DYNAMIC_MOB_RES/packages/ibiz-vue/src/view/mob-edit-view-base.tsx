import { IPSAppDEMobEditView, IPSDEForm } from "@ibiz/dynamic-model-api";
import { MobEditViewInterface, ModelTool } from "ibiz-core";
import { MainViewBase } from "./main-view-base";

/**
 * 编辑视图基类
 *
 * @export
 * @class MobEditViewBase
 * @extends {MainViewBase}
 */
export class MobEditViewBase extends MainViewBase implements MobEditViewInterface {

    /**
     * 视图实例
     * 
     * @memberof MobEditViewBase
     */
    public declare viewInstance: IPSAppDEMobEditView;

    /**
     * 编辑表单实例
     *
     * @public
     * @type {IPSDEForm}
     * @memberof MobEditViewBase
     */
    public editFormInstance !: IPSDEForm;

    /**
     * 表单数据是否变化
     *
     * @type {boolean}
     * @memberof MobEditViewBase
     */
    public dataChange: boolean = false;

    /**
     * 引擎初始化
     *
     * @public
     * @memberof MobEditViewBase
     */
    public engineInit(opts: any = {}): void {
        if (this.Environment?.isPreviewMode) {
            return;
        }
        this.engine.init({
            view: this,
            form: (this.$refs[this.editFormInstance.name] as any).ctrl,
            p2k: '0',
            isLoadDefault: this.viewInstance.loadDefault,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
        });
    }

    /**
     * 初始化编辑视图实例
     * 
     * @memberof MobEditViewBase
     */
    public async viewModelInit() {
        await super.viewModelInit();
        this.editFormInstance = ModelTool.findPSControlByName('form', this.viewInstance.getPSControls()) as IPSDEForm;
    }

    /**
     * 检查表单是否修改
     *
     * @return {*}  {Promise<boolean>}
     * @memberof MobEditViewBase
     */
    public async checkChange(): Promise<boolean> {
        if (!this.dataChange) {
            return true;
        }
        const title: any = this.$t('app.tabpage.sureclosetip.title');
        const content: any = this.$t('app.tabpage.sureclosetip.content');
        const result = await this.$Notice.confirm.call(this, title, content);
        if (result) {
            this.dataChange = false;
            return true;
        } else {
            return false;
        }
    }

    /**
     * 关闭视图
     * 
     * @param {any[]} [args]
     * @memberof MobEditViewBase
     */
    public async closeView(args?: any[]) {
        let result = await this.checkChange();
        if (result) {
            super.closeView(args);
        }
    }

    /**
     * 渲染视图主体内容区
     * 
     * @memberof MobEditViewBase
     */
    public renderMainContent() {
        if (!this.editFormInstance) {
            return null;
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.editFormInstance);
        return this.$createElement(targetCtrlName, {props: targetCtrlParam, ref: this.editFormInstance.name, on: targetCtrlEvent });
    }

    /**
     * 绘制头部标题栏
     * 
     * @memberof MobEditViewBase
     */
    public renderViewHeaderCaptionBar() {
        if (!this.showCaptionBar) {
            return null;
        }
        const srfCaption = this.model.srfCaption;
        const dataInfo: string = this.model.dataInfo ? (`-${this.model.dataInfo}`) : '';
        const showInfoBar: boolean = (this.viewInstance as IPSAppDEMobEditView).showDataInfoBar;
        const psImage = this.viewInstance.getPSSysImage();
        return <ion-title slot="captionbar" class="view-title"><app-ps-sys-image imageModel={psImage}></app-ps-sys-image>{dataInfo && showInfoBar ? srfCaption + dataInfo : srfCaption}</ion-title>
    }
}
