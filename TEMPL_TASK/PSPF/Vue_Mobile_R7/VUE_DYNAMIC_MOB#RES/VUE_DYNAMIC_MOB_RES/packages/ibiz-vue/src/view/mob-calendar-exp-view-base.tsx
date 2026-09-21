import { IPSAppDataEntity, IPSAppDEField, IPSAppDEMobCalendarExplorerView, IPSCalendarExpBar } from '@ibiz/dynamic-model-api';
import { MobCalendarExpViewInterface, ModelTool } from 'ibiz-core';
import { MobExpViewBase } from './mob-exp-view-base';


/**
 * 日历导航视图基类
 *
 * @export
 * @class MobCalendarExpViewBase
 * @extends {MobExpViewBase}
 */
export class MobCalendarExpViewBase extends MobExpViewBase implements MobCalendarExpViewInterface {

    /**
     * 视图实例
     * 
     * @memberof MobCalendarExpViewBase
     */
    public declare viewInstance: IPSAppDEMobCalendarExplorerView;

    /**
     * 导航栏实例
     * 
     * @memberof MobCalendarExpViewBase
     */
    public declare expBarInstance: IPSCalendarExpBar;

    /**
     * 选中数据
     *
     * @type {*}
     * @memberof MobCalendarExpViewBase
     */
    public selection: any = {};

    /**
     * 引擎初始化
     *
     * @public
     * @memberof MobCalendarExpViewBase
     */
    public engineInit(opts: any = {}): void {
        if (this.Environment?.isPreviewMode) {
            return;
        }
        let engineOpts = ({
            view: this,
            p2k: '0',
            calendarexpbar: (this.$refs[this.expBarInstance.name] as any).ctrl,
            keyPSDEField: (ModelTool.getContainerAppEntityCodeName(this.viewInstance) as string).toLowerCase(),
            majorPSDEField: (ModelTool.getAppEntityMajorField(this.viewInstance.getPSAppDataEntity() as IPSAppDataEntity) as IPSAppDEField)?.codeName.toLowerCase(),
            isLoadDefault: this.viewInstance.loadDefault,
        });
        this.engine.init(engineOpts);
    }

    /**
     * 初始化分页导航视图实例
     * 
     * @memberof MobCalendarExpViewBase
     */
    public async viewModelInit() {
        await super.viewModelInit();
        this.expBarInstance = ModelTool.findPSControlByName('calendarexpbar', this.viewInstance.getPSControls()) as IPSCalendarExpBar;
    }

    /**
     * 计算目标部件所需参数
     *
     * @param {string} [controlType]
     * @returns
     * @memberof MobCalendarExpViewBase
     */
    public computeTargetCtrlData(controlInstance: any, args?: any) {
        const { targetCtrlName, targetCtrlParam, targetCtrlEvent } = super.computeTargetCtrlData(controlInstance, args);
        Object.assign(targetCtrlParam.staticProps, {
            sideBarLayout: this.viewInstance.sideBarLayout
        })
        return { targetCtrlName: targetCtrlName, targetCtrlParam: targetCtrlParam, targetCtrlEvent: targetCtrlEvent };
    }

    /**
     * 列表导航栏
     *
     * @return {*} 
     * @memberof MobCalendarExpViewBase
     */
    public renderCalendarExpBar() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.expBarInstance);
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.expBarInstance.name, on: targetCtrlEvent });
    }

    /**
     * 渲染视图主体内容区
     * 
     * @memberof ExpViewBase
     */
    public renderMainContent() {
        return (<div class="app-vc-expbar">
            <div class="app-vc-expbar__left">
                {this.renderCalendarExpBar()}
            </div>
            <div class="app-vc-expbar__body">
                {this.renderNavView()}
            </div>
        </div>)
    }

    /**
     * 绘制导航视图
     *
     * @memberof MobCalendarExpViewBase
     */
    public renderNavView() {
        const { srfnavdata } = this.selection;
        if (!srfnavdata) {
            return;
        }
        const { context, viewparams } = srfnavdata;
        let targetCtrlParam: any = {
            staticProps: {
                viewDefaultUsage: 'INCLUDEDVIEW',
                viewpath: this.context.viewpath
            },
            dynamicProps: {
                _viewparams: JSON.stringify(viewparams),
                _context: JSON.stringify(context),
            }
        };
        return this.$createElement('app-view-shell', {
            class: "view-container2",
            props: targetCtrlParam,
        });
    }
}