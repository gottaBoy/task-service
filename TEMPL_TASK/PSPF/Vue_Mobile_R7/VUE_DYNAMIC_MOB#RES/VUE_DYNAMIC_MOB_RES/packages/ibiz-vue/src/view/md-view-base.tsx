import { ModelTool, Util, MobMDCtrlViewInterface } from 'ibiz-core';
import { IPSDESearchForm, IPSSearchBar, IPSAppDEMultiDataView, IPSAppCodeList, IPSCodeItem, IPSAppDEField, IPSDEMobMDCtrl, IPSDEListItem, IPSDEListDataItem, IPSAppDataEntity } from '@ibiz/dynamic-model-api';
import { MainViewBase } from "./main-view-base";

/**
 * 多数据视图基类
 *
 * @export
 * @class MDViewBase
 * @extends {MainViewBase}
 */
export class MDViewBase extends MainViewBase implements MobMDCtrlViewInterface {

    /**
     * 视图实例
     * 
     * @memberof MDViewBase
     */
    public declare viewInstance: any;

    /**
     * 多数据部件是否单选
     *
     * @type {boolean}
     * @memberof MDViewBase
     */
    public isSingleSelect?: boolean;

    /**
     * 搜索参数
     *
     * @memberof MDViewBase
     */
    public queryParams = {
        // 快速搜索
        query: '',
        //  快速分组数据对象
        quickGroupData: {},
        // 分类值
        categoryValue: {},
        // 排序值
        sortValue: {}
    }

    /**
     * 快速分组相关参数
     *
     * @type {*}
     * @memberof MDViewBase
     */
    public quickGroupParam: any = {
        // 是否启用快速分组
        isEnableQuickGroup: false,
        // 快速分组是否有抛值
        isEmitQuickGroupValue: false,
        // 快速分组代码表
        quickGroupCodeList: null,
    }

    /**
     * 排序相关参数
     *
     * @memberof MDViewBase
     */
    public sortParam = {
        // 排序缓存
        sortCache: { asc: "", desc: "" },
        // 点击优先级加主题色
        active: false
    }

    /**
     * 搜索表单实例
     *
     * @type {IBizMobSearchFormModel}
     * @memberof MDViewBase
     */
    public searchFormInstance !: IPSDESearchForm;

    /**
     * 快速搜索表单实例
     *
     * @type {IBizMobSearchFormModel}
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
     * 是否展开搜索表单
     *
     * @type {boolean}
     * @memberof MDViewBase
     */
    public isExpandSearchForm: boolean = false;
    
    /**
     * 部件计数
     *
     * @memberof MDViewBase
     */
    public pageTotal: number = 0;



    /**
     * 视图实体对象
     *
     * @memberof MobMDViewBase
     */
    get appDataEntity(){
        return (this.viewInstance?.getPSAppDataEntity() as IPSAppDataEntity);
    }

    /**
     * 初始化多数据视图实例
     * 
     * @param opts 
     * @memberof MDViewBase
     */
    public async viewModelInit() {
        await super.viewModelInit();
        this.searchFormInstance = ModelTool.findPSControlByName('searchform', this.viewInstance.getPSControls() || []) as IPSDESearchForm;
        this.quickSearchFormInstance = ModelTool.findPSControlByName('quicksearchform', this.viewInstance.getPSControls() || []) as IPSDESearchForm;
        this.searchBarInstance = ModelTool.findPSControlByType('SEARCHBAR', this.viewInstance.getPSControls() || []) as IPSSearchBar;
        this.quickGroupParam.isEnableQuickGroup = this.viewInstance?.enableQuickGroup;
        this.quickGroupParam.quickGroupCodeList = (this.viewInstance as IPSAppDEMultiDataView).getQuickGroupPSCodeList();
    }

    /**
     *  多数据视图初始化
     *
     * @memberof MDViewBase
     */
    public async viewInit() {
        super.viewInit();
        // 初始化属性值
        this.queryParams.query = '';
        this.quickGroupParam.isEnableQuickGroup = this.viewInstance?.enableQuickGroup;
    }

    /**
     * 渲染快速搜索
     * 
     * @memberof MDViewBase
     */
    public renderQuickSearch() {
        if (!this.viewInstance.enableQuickSearch) {
            return;
        }
        return this.model && this.enableControlUIAuth ? <app-search-history appDataEntity={this.appDataEntity} on-quickValueChange={this.MDViewEvent.bind(this)} parentModel={this.viewInstance} slot="quicksearch"></app-search-history> : null;
    }


    /**
     * 视图事件
     *
     * @param {string} tag
     * @param {*} data
     * @memberof MDViewBase
     */
    public MDViewEvent($event: any) {
        const { tag, value } = $event;
        if (!tag) {
            console.log('视图事件tag 异常');
            return;
        }
        this.engine.onViewEvent(tag, value);
    }

    /**
     * 渲染快速分组
     * 
     * @memberof MDViewBase
     */
    public renderQuickGroup() {
        if (!this.quickGroupParam.isEnableQuickGroup) {
            return;
        }
        const codeList = (this.viewInstance as IPSAppDEMultiDataView).getQuickGroupPSCodeList?.();
        return <app-quick-group ref="quickGroup" context={this.context} viewparams={this.viewparams} codeList={codeList} on-valueChange={this.MDViewEvent.bind(this)} slot="quickGroupSearch"></app-quick-group>;
    }

    /**
     * 渲染搜索表单
     * 
     * @memberof MDViewBase
     */
    public renderSearchForm() {
        if (!this.searchFormInstance) {
            return;
        }
        return this.renderSearchFormContent();
    }

    /**
     * 渲染搜索表单内容区
     * 
     * @memberof MobMDViewBase
     */
    public renderSearchFormContent() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent }: { targetCtrlName: string, targetCtrlParam: any, targetCtrlEvent: any } = this.computeTargetCtrlData(this.searchFormInstance);
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: this.searchFormInstance.name, on: targetCtrlEvent, slot: 'searchForm' });
    }

    /**
     * 渲染多数据工具
     * 
     * @memberof MDViewBase
     */
    public renderViewHeaderButton() {
        const controlClassNames: any = {
            'default-sort': true,
            [`${Util.srfFilePath2(this.viewInstance.codeName)}-toolbar`]: true,
        };
        const mdctrl = ModelTool.findPSControlByName('mdctrl', this.viewInstance.getPSControls()) as IPSDEMobMDCtrl;
        const listItems = mdctrl?.getPSDEListItems();
        const listDataItems = mdctrl?.getPSDEListDataItems();
        return <div class="mdview-tools" slot="mdviewtools">
            <div class={controlClassNames}>
                <div class="view-tool">
                    <div class="view-tool-sorts">
                        {listItems && listItems.map((item: IPSDEListItem) => {
                            if (item.enableSort && item.itemType == 'ACTIONITEM') {
                                return <div class="view-tool-sorts-item">
                                    <span class={{ text: true, active: this.sortParam.active }} on-click={() => this.MDViewEvent({ tag: 'onsort', value: item?.name })}>{item?.caption}</span>
                                    <span class="sort-icon" on-click={() => this.MDViewEvent({ tag: 'onsort', value: item?.name })}>
                                        <ion-icon class={{ 'ios': true, 'hydrated': true, 'sort-select': this.sortParam.sortCache.asc == item?.name }} name="chevron-up-outline" ></ion-icon>
                                        <ion-icon class={{ 'ios': true, 'hydrated': true, 'sort-select': this.sortParam.sortCache.desc == item?.name }} name="chevron-down-outline" ></ion-icon>
                                    </span>
                                </div>
                            }
                        })}
                    </div>
                </div>
            </div>
            <div class="mdview-tools-select">
                {listItems && listItems.map((item: IPSDEListItem) => {
                    // 列表项需要代码表，需要根据key去数据项中找到对应的然后去取代码表
                    const dataItem = listDataItems?.find((dataItem: IPSDEListDataItem) => {
                        return dataItem.name == item.name.toLowerCase();
                    })
                    const codelist = dataItem?.getFrontPSCodeList?.() as IPSAppCodeList;
                    let items: Array<any> = [];
                    if (codelist && codelist?.getPSCodeItems?.()) {
                        const codeItems = codelist?.getPSCodeItems() as IPSCodeItem[];
                        codeItems.forEach((codeitem: IPSCodeItem) => {
                            items.push({
                                value: codeitem?.value,
                                label: codeitem?.text
                            })
                        })
                    }
                    if (codelist?.codeListType == 'STATIC' && item.itemType == 'TEXTITEM') {
                        return <app-van-select name={'n_' + item.name.toLowerCase() + '_eq'} title={item?.caption} items={items} on-onConfirm={this.MDViewEvent.bind(this)}></app-van-select>
                    }
                })}
            </div>
        </div>
    }
}
