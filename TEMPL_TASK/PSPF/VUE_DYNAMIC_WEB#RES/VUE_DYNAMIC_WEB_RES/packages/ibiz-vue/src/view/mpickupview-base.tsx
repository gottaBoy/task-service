import { IPSAppDEPickupView, IPSDEPickupViewPanel } from '@ibiz/dynamic-model-api';
import { MPickupViewEngine, ModelTool, throttle, MPickUpViewInterface, Util } from 'ibiz-core';
import { MainViewBase } from './mainview-base';

/**
 * 数据多项选择视图基类
 *
 * @export
 * @class MPickUpViewBase
 * @extends {MainViewBase}
 * @implements {MPickUpViewInterface}
 */
export class MPickUpViewBase extends MainViewBase implements MPickUpViewInterface {

    /**
     * 视图实例
     * 
     * @memberof MPickUpViewBase
     */
    public declare viewInstance: IPSAppDEPickupView;

    /**
     * 引擎对象
     *
     * @type {MPickupViewEngine}
     * @memberof MPickUpViewBase
     */
    public declare engine: MPickupViewEngine;

    /**
     * 选择视图面板实例
     * 
     * @memberof MPickUpViewBase
     */
    public pickUpViewPanelInstance!: IPSDEPickupViewPanel;

    /**
     * 是否显示按钮
     *
     * @type {boolean}
     * @memberof MPickUpViewBase
     */
    public isShowButton: boolean = true;

    /**
     * 选中数据的字符串
     *
     * @type {string}
     * @memberof MPickUpViewBase
     */
    public selectedData: string = "";

    /**
     * 视图选中数据
     *
     * @type {any[]}
     * @memberof MPickUpViewBase
     */
    public viewSelections: any[] = [];

    /**
     * 部件模型
     *
     * @type {*}
     * @memberof MPickUpViewBase
     */
    public ctrlModel: any = {};

    /**
     * 监听部件动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MPickUpViewBase
     */
    public onDynamicPropsChange(newVal: any, oldVal: any) {
        super.onDynamicPropsChange(newVal, oldVal);
        if (this.viewparams?.selectedData) {
            this.selectedData = JSON.stringify(this.viewparams.selectedData);
            this.viewSelections = this.viewparams.selectedData;
        }
    }

    /**
     * 监听部件静态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof MPickUpViewBase
     */
    public onStaticPropsChange(newVal: any, oldVal: any) {
        this.isShowButton = newVal?.isShowButton !== false;
        super.onStaticPropsChange(newVal, oldVal);
    }

    /**
     * 引擎初始化
     *
     * @public
     * @memberof MPickUpViewBase
     */
    public engineInit(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        let engineOpts = ({
            view: this,
            p2k: '0',
            pickupViewPanel: (this.$refs[this.pickUpViewPanelInstance?.name] as any).ctrl,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
        });
        this.engine.init(engineOpts);
    }

    /**
     * 初始化分页导航视图实例
     * 
     * @memberof MPickUpViewBase
     */
    public async viewModelInit() {
        this.viewInstance = (this.staticProps?.modeldata) as IPSAppDEPickupView;
        await super.viewModelInit();
        this.pickUpViewPanelInstance = ModelTool.findPSControlByType("PICKUPVIEWPANEL", this.viewInstance.getPSControls());
    }

    /**
     * 初始化容器模型
     *
     * @param {*} opts
     * @memberof MPickUpViewBase
     */
    public initContainerModel(opts: any) {
        super.initContainerModel(opts);
        const { modeldata } = opts;
        modeldata?.getPSControls().forEach((ctrl: any) => {
            this.ctrlModel[ctrl.name] = { name: `${ctrl.name}`, type: `${ctrl.controlType}` };
        });
    }

    /**
     * 删除右侧全部选中数据
     *
     * @memberof MPickUpViewBase
     */
    public onCLickLeft(): void {
        if (this.engine) {
            this.engine.toLeft();
        }
    }

    /**
     * 添加左侧选中数据
     *
     * @memberof MPickUpViewBase
     */
    public onCLickRight(): void {
        if (this.engine) {
            this.engine.toRight();
        }
    }

    /**
     * 选中数据全部删除
     *
     * @memberof MPickUpViewBase
     */
    public onCLickAllLeft(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        if (this.engine) {
            this.engine.toAllLeft();
        }
    }

    /**
     * 添加左侧面板所有数据到右侧
     *
     * @memberof MPickUpViewBase
     */
    public onCLickAllRight(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        if (this.engine) {
            this.engine.toAllRight();
        }
    }

    /**
     * 确定
     *
     * @memberof MPickUpViewBase
     */
    public onClickOk(): void {
        if (this.engine) {
            this.engine.ok(this.viewSelections);
        }
    }

    /**
     * 取消
     *
     * @memberof MPickUpViewBase
     */
    public onClickCancel(): void {
        if (this.engine) {
            this.engine.cancel();
        }
    }

    /**
     * 渲染视图主体内容区
     * 
     * @memberof MPickUpViewBase
     */
    public renderMainContent() {
        return (
            <div class="view-content__body__transfer">
                <div class="view-content__body__transfer__left" style={{ width: !this.isShowButton ? '100%' : '' }}>
                    {this.renderControlContent()}
                </div>
                {this.isShowButton && <div class="view-content__body__transfer__center">
                    {this.renderButtons()}
                </div>}
                {this.isShowButton && <div class="view-content__body__transfer__right">
                    {this.renderMpickerSelect()}
                </div>}
            </div>
        )
    }

    /**
     *  渲染视图底部按钮
     * @memberof MPickUpViewBase
     */
    public renderFooter() {
        return (
            this.isShowButton ? <div slot="footer" class="view-footer__buttons">
                <app-button
                    type="primary"
                    disabled={this.viewSelections.length > 0 ? false : true}
                    caption={this.viewButtonModel?.view_okbtn?.text}
                    on-onClick={(e: any) => throttle(this.onClickOk, e, this)}>
                </app-button>
                &nbsp;&nbsp;
                <app-button
                    caption={this.viewButtonModel?.view_cancelbtn?.text}
                    on-onClick={(e: any) => throttle(this.onClickCancel,e,this)}>
                </app-button>
            </div> : null
        )
    }

    /**
     * 渲染按钮
     * 
     * @memberof MPickUpViewBase
     */
    public renderButtons() {
        return [
            <app-button
                type="primary"
                tooltip={this.viewButtonModel?.view_rightbtn.text}
                disabled={this.viewButtonModel?.view_rightbtn.disabled}
                iconcls="el-icon-arrow-right"
                on-onClick={(e: any) => throttle(this.onCLickRight, e, this)}>
            </app-button>,
            <app-button
                type="primary"
                tooltip={this.viewButtonModel?.view_leftbtn.text}
                disabled={this.viewButtonModel?.view_leftbtn.disabled}
                iconcls="el-icon-arrow-left"
                on-onClick={(e: any) => throttle(this.onCLickLeft, e, this)}>
            </app-button>,
            <app-button
                type="primary"
                tooltip={this.viewButtonModel?.view_allrightbtn.text}
                disabled={this.viewButtonModel?.view_allrightbtn.disabled}
                iconcls="el-icon-d-arrow-right"
                on-onClick={(e: any) => throttle(this.onCLickAllRight, e, this)}>
            </app-button>,
            <app-button
                type="primary"
                tooltip={this.viewButtonModel?.view_allleftbtn.text}
                disabled={this.viewButtonModel?.view_allleftbtn.disabled}
                iconcls="el-icon-d-arrow-left"
                on-onClick={(e: any) => throttle(this.onCLickAllLeft, e, this)}>
            </app-button>
        ]
    }

    /**
     * 渲染多数据选择
     * 
     * @memberof MPickUpViewBase
     */
    public renderMpickerSelect() {
        return <div class="view-content__body__transfer__right__select">
            {this.viewSelections.map((item: any, index: number) => {
                return <div key={index} class={{ 'is-active': item._select, 'picker-item': true }} on-click={() => throttle(this.selectionsClick, [item], this)} on-dblclick={() => throttle(this.selectionsDBLClick, [item], this)}>
                    <span>{item.srfmajortext}</span>
                </div>
            })}
        </div>
    }

    /**
     * 渲染选择视图面板
     * 
     * @memberof MPickUpViewBase
     */
    public renderControlContent() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.pickUpViewPanelInstance);
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.pickUpViewPanelInstance?.name, on: targetCtrlEvent });
    }

    /**
     * 计算目标部件所需参数
     *
     * @param {string} [controlType]
     * @returns
     * @memberof MPickUpViewBase
     */
    public computeTargetCtrlData(controlInstance: any, args?: any) {
        const { targetCtrlName, targetCtrlParam, targetCtrlEvent } = super.computeTargetCtrlData(controlInstance, args);
        Object.assign(targetCtrlParam.dynamicProps, {
            selectedData: this.selectedData,
        })
        Object.assign(targetCtrlParam.staticProps, {
            isSingleSelect: false,
            isShowButton: this.isShowButton,
        })
        return { targetCtrlName, targetCtrlParam, targetCtrlEvent }
    }

    /**
     * 选中数据单击
     *
     * @param {*} item
     * @memberof MPickUpViewBase
     */
    public selectionsClick(item: any): void {
        item._select = !item._select;
        const removeSelect: boolean = this.viewSelections.some((selection: any) => selection._select);
        this.viewButtonModel.view_leftbtn.disabled = !removeSelect;
    }

    /**
     * 选中树双击
     *
     * @param {*} item
     * @memberof MPickUpViewBase
     */
    public selectionsDBLClick(item: any): void {
        const index: number = this.viewSelections.findIndex((selection: any) => Object.is(selection.srfkey, item.srfkey));
        if (index !== -1) {
            this.viewSelections.splice(index, 1);
        }
        const removeSelect: boolean = this.viewSelections.some((selection: any) => selection._select);
        this.viewButtonModel.view_leftbtn.disabled = !removeSelect;
        this.selectedData = JSON.stringify(this.viewSelections);
    }

}