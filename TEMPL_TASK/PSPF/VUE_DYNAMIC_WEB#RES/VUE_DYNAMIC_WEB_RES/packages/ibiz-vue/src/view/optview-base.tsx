import { MainViewBase } from "./mainview-base";
import { OptionViewEngine, ModelTool, throttle, OptViewInterface } from 'ibiz-core';
import { IPSAppDEEditView, IPSDEForm } from "@ibiz/dynamic-model-api";

/**
 * 选项操作视图基类
 *
 * @export
 * @class OptViewBase
 * @extends {MainViewBase}
 * @implements {OptViewInterface}
 */
export class OptViewBase extends MainViewBase implements OptViewInterface {

    /**
     * 视图实例
     * 
     * @memberof OptViewBase
     */
    public declare viewInstance: IPSAppDEEditView;

    /**
     * 编辑表单实例
     *
     * @public
     * @type {IBizFormModel}
     * @memberof OptViewBase
     */
    public editFormInstance !: IPSDEForm;

    /**
     * 引擎初始化
     *
     * @public
     * @memberof OptViewBase
     */
    public engineInit(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        this.engine.init({
            view: this,
            form: (this.$refs[this.editFormInstance?.name] as any).ctrl,
            p2k: '0',
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
            isLoadDefault: this.viewInstance.loadDefault,
        });
    }

    /**
     * 初始化编辑视图实例
     * 
     * @memberof OptViewBase
     */
    public async viewModelInit() {
        await super.viewModelInit();
        this.editFormInstance = ModelTool.findPSControlByName('form',this.viewInstance.getPSControls()) as IPSDEForm;      
    }


    /**
     * 渲染视图主体内容区
     * 
     * @memberof OptViewBase
     */
    public renderMainContent() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent }: { targetCtrlName: string, targetCtrlParam: any, targetCtrlEvent: any } = this.computeTargetCtrlData(this.editFormInstance);
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.editFormInstance?.name, on: targetCtrlEvent },);
    }

    /**
     *  渲染视图底部按钮
     */
    public renderFooter() {
        return <template slot="footer">
            <div dis-hover bordered={false}  class="view-footer__buttons">
                    <app-button
                        type="primary"
                        caption={this.viewButtonModel.view_okbtn.text}
                        on-onClick={(e: any) => throttle(this.onClickOk, e, this)}>
                    </app-button>                
                    &nbsp;&nbsp;
                    <app-button
                        caption={this.viewButtonModel.view_cancelbtn.text}
                        on-onClick={(e: any) => throttle(this.onClickCancel, e, this)}>
                    </app-button>
            </div>
        </template>
    }

    /**
     * 确定
     *
     * @memberof OptViewBase
     */
    public onClickOk(e: MouseEvent): void {
        if (this.engine) {
            this.engine.ok();
        }
    }

    /**
     * 取消
     *
     * @memberof OptViewBase
     */
    public onClickCancel(e: MouseEvent): void {
        if (this.engine) {
            this.engine.cancel();
        }
    }

}
