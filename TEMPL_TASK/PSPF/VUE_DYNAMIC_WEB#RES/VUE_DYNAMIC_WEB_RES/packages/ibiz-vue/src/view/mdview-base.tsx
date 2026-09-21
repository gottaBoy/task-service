import { IPSDESearchForm, IPSSearchBar, IPSAppDEMultiDataView, IPSAppDEField } from '@ibiz/dynamic-model-api';
import { throttle, ModelTool, Util } from 'ibiz-core'
import { MDViewInterface } from 'ibiz-core/src/interface/view/md-view';
import { AppGlobalService } from '../app-service/logic-service/app-global-action-service';
import { MainViewBase } from "./mainview-base";

/**
 * 多数据视图基类
 *
 * @export
 * @class MDViewBase
 * @extends {MainViewBase}
 * @implements {MDViewInterface}
 */
export class MDViewBase extends MainViewBase implements MDViewInterface {

    /**
     * 查询参数
     *
     * @type {*}
     * @memberof MDViewBase
     */
    public queryParams: any = {};

    /**
     * 实际是否展开搜索表单
     *
     * @type {boolean}
     * @memberof MDViewBase
     */
    public isExpandSearchForm: boolean = false;

    /**
     * 快速分组是否有抛值
     *
     * @description 第一次不抛值，否则会导致多数据部件多次加载
     * @memberof MDViewBase
     */
    public isEmitQuickGroupValue: boolean = false;

    /**
     * 搜索表单实例
     *
     * @type {IBizSearchFormModel}
     * @memberof MDViewBase
     */
    public searchFormInstance !: IPSDESearchForm;

    /**
     * 快速搜索表单实例
     *
     * @type {IBizSearchFormModel}
     * @memberof MDViewBase
     */
    public quickSearchFormInstance !: IPSDESearchForm;

    /**
     * 搜索栏实例
     *
     * @type {IBizSearchBarModel}
     * @memberof MDViewBase
     */
    public searchBarInstance!: IPSSearchBar;

    /**
     * 可搜索字段名称
     * 
     * @type {(string)}
     * @memberof MDViewBase
     */
    public placeholder: string = "";

    /**
     * 快速搜索
     *
     * @memberof MDViewBase
     */
    public onSearch(event?: any) {
        if (this.engine) {
            this.engine.search(event);
        }
    }

    /**
     * 快速分组值变化
     * 
     * @param {*} $event 事件源
     * @memberof MDViewBase
     */
    public quickGroupValueChange($event: any) {
        if ($event) {
            this.queryParams.quickGroupData = $event.data;
            this.onSearch($event);
        }
    }

    /**
     * 快速搜索栏数据对象
     *
     * @memberof MDViewBase
     */
    public quickFormData: any;

    /**
     * 初始化日历视图实例
     * 
     * @param opts 
     * @memberof MDViewBase
     */
    public async viewModelInit() {
        await super.viewModelInit();
        this.searchFormInstance = ModelTool.findPSControlByName('searchform', this.viewInstance.getPSControls() || []) as IPSDESearchForm;
        this.quickSearchFormInstance = ModelTool.findPSControlByName('quicksearchform', this.viewInstance.getPSControls() || []) as IPSDESearchForm;
        this.searchBarInstance = ModelTool.findPSControlByType('SEARCHBAR', this.viewInstance.getPSControls() || []) as IPSSearchBar;
        this.isExpandSearchForm = this.viewInstance?.expandSearchForm ? true : false;
    }

    /**
     *  多数据视图初始化
     *
     * @memberof MDViewBase
     */
    public viewInit() {
        super.viewInit();
        // 初始化属性值
        this.queryParams.quickSearchValue = '';
        this.initQuickSearchPlaceholder();
    }

    /**
     *  初始化快速搜索栏空白填充内容
     *
     * @memberof MDViewBase
     */
    public initQuickSearchPlaceholder() {
        const quickSearchFields: Array<IPSAppDEField> = (this.viewInstance as IPSAppDEMultiDataView).getPSAppDataEntity()?.getQuickSearchPSAppDEFields() || [];
        if (quickSearchFields.length > 0) {
            quickSearchFields.forEach((field: IPSAppDEField, index: number) => {
                const _field: IPSAppDEField | null | undefined = (this.viewInstance as IPSAppDEMultiDataView).getPSAppDataEntity()?.findPSAppDEField(field.codeName);
                if (_field) {
                    if(_field.quickSearchPlaceHolder){
                        this.placeholder += (this.$tl(_field.getQSPHPSLanguageRes()?.lanResTag, _field.quickSearchPlaceHolder) + (index === quickSearchFields.length - 1 ? '' : ', '));
                    }else{
                        this.placeholder += (this.$tl(_field.getLNPSLanguageRes()?.lanResTag, _field.logicName) + (index === quickSearchFields.length - 1 ? '' : ', '));
                    }
                }
            })
        }
    }

    /**
     * 渲染快速搜索
     * 
     * @memberof MDViewBase
     */
    public renderQuickSearch() {
        if (!this.viewInstance?.enableQuickSearch) {
            return;
        }
        if (this.viewInstance?.viewStyle == "DEFAULT") {
            return this.renderDefaultQuickSearch();
        } else {
            return this.renderStyle2QuickSearch();
        }
    }

    /**
     * 渲染快速搜索(DEFAULT)
     *
     * @return {*} 
     * @memberof MDViewBase
     */
    public renderDefaultQuickSearch() {
        return <app-quick-search slot="quickSearch" v-model={this.queryParams.quickSearchValue} on-search={($event: any) => this.onSearch($event)} appDataEntity={this.viewInstance.getPSAppDataEntity()} />
    }

    /**
     * 渲染快速搜索过滤（带搜索表单）
     *
     * @param {('searchform' | 'searchbar' | string)} type
     * @param {*} [content]
     * @return {*}  {*}
     * @memberof MDViewBase
     */
    public renderDefaultQuickSearchFilter(content?: any): any {
        const barFilters: Array<any> = this.searchBarInstance?.getPSSearchBarFilters() || [];
        const searchformItem: Array<any> = this.searchFormInstance?.getPSDEFormItems() || [];
        let enableFilter = this.viewInstance?.enableFilter === true && barFilters.length > 0 || searchformItem.length > 0;
        const popoverClass: string = this.searchFormInstance ? 'app-quick-searchform__popover' : this.searchBarInstance ? 'app-quick-searchbar__popover' : '';
        return [
            <app-quick-search v-model={this.queryParams.quickSearchValue} class={{'is-filter': enableFilter }} on-search={($event: any) => this.onSearch($event)} appDataEntity={this.viewInstance.getPSAppDataEntity()} />,
            <el-popover placement="bottom" popper-class={popoverClass} trigger="click" visible-arrow={false} on-hide={() => this.isExpandSearchForm = !this.isExpandSearchForm}>
                <i-button slot="reference" class={{ 'is-expand': this.isExpandSearchForm, 'is-hidden': !enableFilter }} icon="ios-funnel" on-click={(e: any) => {
                    if (!this.isExpandSearchForm) {
                        throttle(() => (AppGlobalService.getInstance() as any).executeGlobalAction('ToggleFilter', undefined, undefined, undefined, e, undefined, this, undefined), [], this);
                    }
                }} />
                <div>{content}</div>
            </el-popover>
        ]
    }

    /**
     * 渲染快速搜索(STYLE2)
     *
     * @return {*} 
     * @memberof MDViewBase
     */
    public renderStyle2QuickSearch() {
        return <app-quick-search v-model={this.queryParams.quickSearchValue} on-search={($event: any) => this.onSearch($event)} appDataEntity={this.viewInstance.getPSAppDataEntity()} />
    }

    /**
     * 计算目标部件所需参数
     *
     * @param {string} [controlType]
     * @returns
     * @memberof MDViewBase
     */
    public computeTargetCtrlData(controlInstance: any, args?: any) {
        const { targetCtrlName, targetCtrlParam, targetCtrlEvent } = super.computeTargetCtrlData(controlInstance, args);
        if (Object.is(controlInstance?.controlType, 'SEARCHFORM') || Object.is(controlInstance?.controlType, 'SEARCHBAR')) {
            Object.assign(targetCtrlParam.dynamicProps, {
                isExpandSearchForm: this.isExpandSearchForm
            });
        } else {
            Object.assign(targetCtrlParam.staticProps, {
                mDCtrlActiveMode: this.viewInstance.mDCtrlActiveMode
            });
        }
        return { targetCtrlName: targetCtrlName, targetCtrlParam: targetCtrlParam, targetCtrlEvent: targetCtrlEvent };
    }

    /**
     * 渲染搜索表单
     * @memberof MDViewBase
     */
    public renderSearchForm() {
        if (!this.searchFormInstance) {
            return
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.searchFormInstance);
        //  继承样式不带插槽名
        if (this.viewInstance.viewStyle === 'EXTEND') {
            return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.searchFormInstance?.name, on: targetCtrlEvent });
        } else {
            return this.$createElement(targetCtrlName, { slot: 'searchForm', props: targetCtrlParam, ref: this.searchFormInstance?.name, on: targetCtrlEvent });
        }
    }

    /**
     * 渲染快速搜索表单
     * 
     * @memberof MDViewBase
     */
    public renderQuickSearchForm() {
        if (!this.quickSearchFormInstance) {
            return
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.quickSearchFormInstance);
        return this.$createElement(targetCtrlName, { slot: 'quickSearchForm', props: targetCtrlParam, ref: this.quickSearchFormInstance?.name, on: targetCtrlEvent });
    }

    /**
     * 渲染搜索栏
     * 
     * @memberof MDViewBase
     */
    public renderSearchBar() {
        if (!this.searchBarInstance) {
            return
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.searchBarInstance);
        Object.assign(targetCtrlParam.dynamicProps, {
            isExpandSearchForm: this.isExpandSearchForm
        });
        //  继承样式不带插槽名
        if (this.viewInstance.viewStyle === 'EXTEND') {
            return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.searchBarInstance?.name, on: targetCtrlEvent });
        } else {
            return this.$createElement(targetCtrlName, { slot: 'searchBar', props: targetCtrlParam, ref: this.searchBarInstance?.name, on: targetCtrlEvent });
        }
    }

    /**
     * 渲染快速分组
     * 
     * @memberof MDViewBase
     */
    public renderQuickGroup() {
        if (!this.viewInstance?.enableQuickGroup) {
            return;
        }
        let counterService: any;
        if (this.viewInstance?.getPSAppCounterRef?.()?.id) {
            counterService = Util.findElementByField(this.counterServiceArray, 'id', this.viewInstance?.getPSAppCounterRef?.()?.id)?.service;
        }
        const codeList = (this.viewInstance as IPSAppDEMultiDataView).getQuickGroupPSCodeList?.();
        return <app-quick-group slot="quickGroupSearch" context={this.context} viewparams={this.viewparams} codeList={codeList} on-valuechange={this.quickGroupValueChange.bind(this)} counterService={counterService}></app-quick-group>
    }
}
