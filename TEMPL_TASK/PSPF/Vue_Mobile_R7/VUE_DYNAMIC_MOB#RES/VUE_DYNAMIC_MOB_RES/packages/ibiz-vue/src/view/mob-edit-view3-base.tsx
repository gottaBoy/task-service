import { MobEditView3Interface, ModelTool } from 'ibiz-core';
import { MobEditViewBase } from './mob-edit-view-base';
import { IPSAppDEMobEditView, IPSDEDRTab, IPSDEDRTabPage } from '@ibiz/dynamic-model-api';

/**
 * 编辑视图基类
 *
 * @export
 * @class MobEditView3Base
 * @extends {MainViewBase}
 */
export class MobEditView3Base extends MobEditViewBase implements MobEditView3Interface {

    /**
     * 视图实例
     * 
     * @memberof MobEditView3Base
     */
    public declare viewInstance: IPSAppDEMobEditView;

    /**
     * 数据关系分页部件实例
     *
     * @public
     * @type {IBizFormModel}
     * @memberof MobEditView3Base
     */
    public drtabInstance !: IPSDEDRTab;

    /**
     * 关系项
     *
     * @type {*}
     * @memberof EditView3Base
     */
    public drItem: any;

    /**
     * 关系项缓存
     *
     * @type {*}
     * @memberof MobEditView3Base
     */
    public drItemCache: any[] = [];

    /**
     * 选中数据
     *
     * @type {*}
     * @memberof MobEditView3Base
     */
    public selection: any = {};

    /**
     * 引擎初始化
     *
     * @public
     * @memberof MobEditView3Base
     */
    public engineInit(): void {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        this.engine.init({
            view: this,
            form: (this.$refs[this.editFormInstance.name] as any).ctrl,
            drtab: (this.$refs[this.drtabInstance.name] as any).ctrl,
            p2k: '0',
            isLoadDefault: this.viewInstance.loadDefault,
            keyPSDEField: this.appDeCodeName.toLowerCase(),
            majorPSDEField: this.appDeMajorFieldName.toLowerCase(),
        });
    }

    /**
     * 初始化编辑视图实例
     * 
     * @memberof MobEditView3Base
     */
    public async viewModelInit() {
        await super.viewModelInit();
        this.drtabInstance = ModelTool.findPSControlByName('drtab', this.viewInstance.getPSControls()) as IPSDEDRTab;
    }

    /**
     * 计算tab样式
     *
     * @memberof MobEditView3Base
     */
    calcTabStyle(tag: string) {
        const items: any = this.drtabInstance.getPSDEDRTabPages();
        const count = 100 / (items.length + 1);
        return tag == 'form' ? { width: (count) + '%' } : { width: (100 - count) + '%' };
    }

    /**
     * 数据关系栏变更
     *
     * @param {*} tab
     * @param {MouseEvent} event
     * @memberof MobEditView3Base
     */
    public drTabChange(tab: any, event: MouseEvent) {
        if (this.engine) {
            this.engine.drTabSelectionChange(tab);
        }
    }
    /**
     * 渲染表单
     *
     * @return {*} 
     * @memberof AppEditView3Base
     */
    public renderForm() {
        if (!this.editFormInstance) {
            return null;
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.editFormInstance);
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.editFormInstance?.name, on: targetCtrlEvent });
    }

    /**
     * 渲染数据关系分页部件
     *
     * @return {*} 
     * @memberof AppEditView3Base
     */
    public renderDrTab() {
        if (!this.drtabInstance) {
            return null;
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.drtabInstance);
        Object.assign(targetCtrlParam.staticProps, {
            needFirstSelected: false
        });
        return this.$createElement(targetCtrlName, {
            props: targetCtrlParam,
            ref: this.drtabInstance?.name,
            style: this.calcTabStyle(this.drtabInstance?.name),
            on: targetCtrlEvent
        });
    }

    /**
     * 传染主内容区
     *
     * @return {*} 
     * @memberof AppDefaultMobEditView
     */
    public renderMainContent() {
        return (
                <div class="app-vc-tab">
                    <div class="app-vc-tab__header">
                        <div class="app-vc-tab__header__drtab">
                            <div
                                class={["drtab__item", (this.drItem && this.drItem.name === 'form') || !this.drItem ? 'drtab__item--select' : '']}
                                style={this.calcTabStyle('form')}
                                on-click={(event: any) => this.drTabChange({ name: 'form' }, event)}>
                                {this.drtabInstance ? this.$tl((this.drtabInstance.getEditItemCapPSLanguageRes()?.lanResTag, this.drtabInstance.editItemCaption)) : ''}
                            </div>
                            {this.renderDrTab()}
                        </div>
                    </div>
                    <div class="app-vc-tab__content">
                        <div class="app-vc-tab__content__form" style={this.drItem && this.drItem.name !== 'form' ? 'display: none;' : ''}>{this.renderForm()}</div>
                        {...this.renderDrView()}
                    </div>
                </div>
        )
    }

    /**
     * 渲染关系视图
     *
     * @return {*}  {*}
     * @memberof AppEditView3Base
     */
    public renderDrView(): any {
        if (!this.drItem) {
            return [];
        }
        return this.drtabInstance.getPSDEDRTabPages()?.map((item: IPSDEDRTabPage) => {
            const viewContext = this.drItem?.srfnavdata?.context || this.context;
            const viewParam = this.drItem?.srfnavdata?.viewparams || this.viewparams;
            Object.assign(viewContext, { viewpath: item.getPSAppView()?.modelPath });
            const cache = this.drItemCache.indexOf(item.name);
            return cache>-1 ? (
                this.$createElement('app-view-shell', {
                    props: {
                        staticProps: {
                            viewDefaultUsage: 'INCLUDEDVIEW',
                            appDeCodeName: this.appDeCodeName,
                        },
                        dynamicProps: {
                            _context: JSON.stringify(viewContext),
                            _viewparams: JSON.stringify(viewParam),
                        }
                    },
                    class: "view-container2",
                    style: { display: this.drItem?.name == item.name ? 'block' : 'none' },
                    on: {
                    }
                })
            ) : null
        })
    }

}
