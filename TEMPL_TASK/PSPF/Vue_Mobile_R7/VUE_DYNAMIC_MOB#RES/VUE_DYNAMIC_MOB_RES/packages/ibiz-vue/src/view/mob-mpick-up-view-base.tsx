import { MobMPickUpViewInterface, ModelTool } from 'ibiz-core'
import { MainViewBase } from './main-view-base';
import { IPSAppDEPickupView, IPSDEPickupViewPanel } from '@ibiz/dynamic-model-api';

/**
 * 多选择视图基类
 *
 * @export
 * @class MobMPickUpViewBase
 * @extends {MainViewBase}
 */
export class MobMPickUpViewBase extends MainViewBase implements MobMPickUpViewInterface {

    /**
     * 视图实例
     * 
     * @memberof MobMPickUpViewBase
     */
    public declare viewInstance: IPSAppDEPickupView;

    /**
     * 数据选择面板实例
     * 
     * @memberof MobMPickUpViewBase
     */
    public viewPickUpViewPanelInstance!: IPSDEPickupViewPanel;

    /**
     * 视图选中数据
     *
     * @type {any[]}
     * @memberof MobMPickUpViewBase
     */
    public viewSelections: any[] = [];

    /**
     * 初始化数据选择视图实例
     * 
     * @memberof MobMPickUpViewBase
     */
    public async viewModelInit() {
        await super.viewModelInit();
        this.viewPickUpViewPanelInstance = ModelTool.findPSControlByName("pickupviewpanel", this.viewInstance.getPSControls());
    }

    /**
     * 初始化数据选择视图实例
     * 
     * @memberof MobMPickUpViewBase
     */
    public renderFooter() {
        return <div class="view-footer__buttons" slot="footer">
            <app-mob-button
                class="button__item"
                color="medium"
                text={this.$t('app.button.cancel')}
                on-click={() => { this.onClickCancel() }} />
            <app-mob-button
                class="button__item"
                text={this.$t('app.button.confirm')}
                disabled={this.viewSelections.length === 0}
                on-click={() => { this.onClickOk() }} />
        </div>
    }

    /**
     * 确定
     *
     * @memberof MobMPickUpViewBase
     */
    public onClickOk(): void {
        this.$emit('view-event', { viewName: this.viewInstance.codeName, action: 'viewDatasChange', data: this.viewSelections })
        this.$emit('view-event', { viewName: this.viewInstance.codeName, action: 'close', data: this.viewSelections })
    }

    /**
     * 取消
     *
     * @memberof MobMPickUpViewBase
     */
    public onClickCancel(): void {
        this.$emit('view-event', { viewName: this.viewInstance.codeName, action: 'close', data: null })
    }


    /**
     * 渲染视图主体内容区
     * 
     * @memberof MobMPickUpViewBase
     */
    public renderMainContent() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent }: { targetCtrlName: string, targetCtrlParam: any, targetCtrlEvent: any } = this.computeTargetCtrlData(this.viewPickUpViewPanelInstance);
        Object.assign(targetCtrlParam.staticProps, {
            isSingleSelect: false
        });
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.viewPickUpViewPanelInstance.name, on: targetCtrlEvent });
    }

}
