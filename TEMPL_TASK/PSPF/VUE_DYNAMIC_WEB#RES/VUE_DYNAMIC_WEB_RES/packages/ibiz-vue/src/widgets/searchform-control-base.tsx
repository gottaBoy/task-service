import { IPSApplication, IPSAppUtil, IPSControlHandler } from '@ibiz/dynamic-model-api';
import { EditFormControlBase } from './editform-control-base';
import moment from 'moment';
import { GetModelService, LogUtil, SearchFormControlInterface, Util } from 'ibiz-core';
import { CodeListTranslator } from '../app-service';
/**
 * 搜索表单部件基类
 *
 * @export
 * @class SearchFormControlBase
 * @extends {EditFormControlBase}
 */
export class SearchFormControlBase extends EditFormControlBase implements SearchFormControlInterface {

    /**
     * 代码表翻译器实例
     * 
     * @typedef {CodeListTranslator}
     * @memberof SearchFormControlBase
     */
    public codeListTranslator: CodeListTranslator = new CodeListTranslator();

    /**
     * 是否展开搜索表单
     *
     * @type {*}
     * @memberof SearchFormControlBase
     */
    public isExpandSearchForm: any = false;

    /**
     * 存储项名称
     * 
     * @type {string}
     * @memberof SearchFormControlBase
     */
    public saveItemName: string = '';

    /**
     * 历史记录
     * 
     * @type {any[]}
     * @memberof SearchFormControlBase
     */
    protected historyItems: any[] = [];

    /**
     * 选中记录
     * 
     * @type {any}
     * @memberof SearchFormControlBase
     */
    protected selectItem: any = null;

    /**
     * 模型id
     * 
     * @type {any}
     * @memberof SearchFormControlBase
     */
    public modelId: string = "";

    /**
     * 功能服务名称
     * 
     * @type {any}
     * @memberof SearchFormControlBase
     */
    public utilServiceName: string = "";

    /**
     * 是否开启保存查询条件
     * 
     * @type {any}
     * @memberof SearchFormControlBase
     */
    public enableSaveFilter: boolean = true;

    /**
     * @description 是否显示搜索下拉
     * @type {boolean}
     * @memberof SearchFormControlBase
     */
    public dropdownVisible: boolean = false;

    /**
     * 折叠状态
     *
     * @type {boolean}
     * @memberof SearchFormControlBase
     */
    public collapsed: boolean = true;

    /**
     * 是否显示可折叠
     *
     * @type {boolean}
     * @memberof SearchFormControlBase
     */
    public showCollapse: boolean = false;

    /**
     * 监听静态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof SearchFormControlBase
     */
    public onStaticPropsChange(newVal: any, oldVal: any) {
        this.enableSaveFilter = newVal.enableSaveFilter === false ? false : true;
        super.onStaticPropsChange(newVal, oldVal);
    }

    /**
     * 监听动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof SearchFormControlBase
     */
    public onDynamicPropsChange(newVal: any, oldVal: any) {
        this.isExpandSearchForm = newVal?.isExpandSearchForm;
        //搜索表单绘制之后关闭清空数据
        // if (!this.isExpandSearchForm && this.controlIsLoaded) {
        //     Object.keys(this.data).forEach((key: any) => {
        //         this.data[key] = null;
        //     });
        // }
        super.onDynamicPropsChange(newVal, oldVal);
    }

    /**
     * 初始化搜索表单模型
     *
     * @memberof SearchFormControlBase
     */
    public async ctrlModelInit() {
        await super.ctrlModelInit();
        this.loaddraftAction = (this.controlInstance.getPSControlHandler() as IPSControlHandler)?.findPSControlHandlerAction('loaddraft')?.getPSAppDEMethod?.()?.codeName || 'GetDraft';
        this.loadAction = (this.controlInstance.getPSControlHandler() as IPSControlHandler)?.findPSControlHandlerAction('load')?.getPSAppDEMethod?.()?.codeName || 'Load';
        this.modelId = `searchform_${this.appDeCodeName ? this.appDeCodeName.toLowerCase() : 'app'}_${this.controlInstance.codeName.toLowerCase()}`;
        await this.initUtilService();
        if ((this.controlInstance as any).searchButtonStyle == 'USER') {
            this.initCollapse();
        }
    }

    /**
     * 初始化折叠数据
     *
     * @memberof SearchFormControlBase
     */
    public initCollapse() {
        let defaultExpandCount = 0;
        Object.keys(this.detailsModel).forEach((key: string) => {
            const detail = this.detailsModel[key];
            if (Object.is(detail.detailType, 'FORMITEM') && (detail.col || detail.offset > 0)) {
                defaultExpandCount += detail.col + detail.offset;
            }
            if (defaultExpandCount > 48) {
                detail.visible = false;
                this.showCollapse = true;
            } else {
                detail.visible = true;
            }
        })
    }

    /**
     * 初始化功能服务名称
     *
     * @memberof SearchFormControlBase
     */
    public async initUtilService() {
        const appUtil: IPSAppUtil = ((await (await GetModelService(this.context))?.app as IPSApplication).getAllPSAppUtils() || []).find((util: any) => {
            return util.utilType == 'FILTERSTORAGE';
        }) as IPSAppUtil;
        if (appUtil) {
            this.utilServiceName = appUtil.codeName?.toLowerCase();
        }
        this.utilServiceName = "dynafilter";
    }

    /**
     * 部件创建完毕
     *
     * @memberof SearchFormControlBase
     */
    public ctrlInit(): void {
        super.ctrlInit();
        this.loadModel();
    }

    public loadModel() {
        let param: any = {};
        Object.assign(param, {
            appdeName: this.appDeCodeName,
            modelid: this.modelId,
            utilServiceName: this.utilServiceName,
            ...this.viewparams
        });
        let tempContext: any = JSON.parse(JSON.stringify(this.context));
        this.onControlRequset('load', tempContext, param);
        let post = this.service.loadModel(this.utilServiceName, tempContext, param);
        post.then((response: any) => {
            this.onControlResponse('load', response);
            if (response.status == 200 && response.data) {
                this.historyItems = response.data;
            }
        }).catch((response: any) => {
            this.onControlResponse('load', response);
            LogUtil.log(response);
        });
    }

    /**
     * 处理dataChang下发的事件
     *
     * @memberof SearchFormControlBase
     */
    public handleDataChange() {
        if (this.isAutoSave) {
            this.ctrlEvent({
                controlname: this.name,
                action: 'load',
                data: this.data,
            });
        }
    }

    /**
     * 加载草稿
     *
     * @param {*} opt 额外参数
     * @memberof SearchFormControlBase
     */
    public async loadDraft(opt: any = {}, mode?: string): Promise<void> {
        if (!this.loaddraftAction) {
            this.$throw('视图' + (this.$t('app.searchform.notconfig.loaddraftaction') as string), 'loadDraft');
            return;
        }
        const arg: any = { ...opt };
        let viewparamResult: any = Object.assign(arg, this.viewparams);
        let tempContext: any = JSON.parse(JSON.stringify(this.context));
        // 处理新建默认值（表单数据覆盖视图参数）V8由请求响应处理新建默认值调整为请求前处理新建默认值
        this.createDefault();
        if(this.data && Object.keys(this.data).length >0){
            Object.keys(this.data).forEach((key:string) =>{
                if(this.data[key] !== null){
                    Object.assign(viewparamResult,{[key]: this.data[key]});
                }
            })
        }
        if (!(await this.handleCtrlEvents('onbeforeloaddraft', { action: this.loaddraftAction, navParam: viewparamResult }))) {
            return;
        }
        this.onControlRequset('loadDraft', tempContext, viewparamResult);
        try {
            const response: any = await this.service.loadDraft(this.loaddraftAction, tempContext, viewparamResult, this.showBusyIndicator);
            this.onControlResponse('loadDraft', response);
            if (!response.status || response.status !== 200) {
                if (!(await this.handleCtrlEvents('onloaddrafterror', { action: this.loaddraftAction, navParam: viewparamResult, data: response?.data }))) {
                    return;
                }
                this.$throw(response, 'loadDraft');
                return;
            }
            const data = response.data;
            if (!(await this.handleCtrlEvents('onloaddraftsuccess', { action: this.loaddraftAction, navParam: viewparamResult, data: data }))) {
                return;
            }
            this.resetDraftFormStates();
            await this.onFormLoad(data, 'loadDraft');
            setTimeout(() => {
                const form: any = this.$refs[this.name];
                if (form) {
                    form.fields.forEach((field: any) => {
                        field.validateMessage = "";
                        field.validateState = "";
                        field.validateStatus = false;
                    });
                }
            });
            if (Object.is(mode, 'RESET')) {
                if (!this.formValidateStatus()) {
                    return;
                }
            }
            this.ctrlEvent({
                controlname: this.name,
                action: 'load',
                data: this.data,
            });
            this.$nextTick(() => {
                this.formState.next({ type: 'load', data: data });
            });
        } catch (error: any) {
            this.onControlResponse('loadDraft', error);
            if (!(await this.handleCtrlEvents('onloaddrafterror', { action: this.loaddraftAction, navParam: viewparamResult, data: error?.data }))) {
                return;
            }
            this.$throw(error, 'loadDraft');
        }
    }

    /**
     * 表单值变化
     *
     * @param {{ name: string, newVal: any, oldVal: any }} param
     * @memberof SearchFormControlBase
     */
    public formDataChange(param: { name: string; newVal: any; oldVal: any }): void {
        super.formDataChange(param);
        this.ctrlEvent({
            controlname: this.name,
            action: 'valuechange',
            data: this.data,
        });
    }

    /**
     * 表单加载完成
     *
     * @param {*} [data={}]
     * @param {string} action
     * @memberof SearchFormControlBase
     */
    public async onFormLoad(data: any = {}, action: string): Promise<void> {
        this.setFormEnableCond(data);
        await this.fillForm(data, action)
        this.formLogic({ name: '' });
    }

    /**
     * 回车事件
     *
     * @param {*} $event
     * @memberof SearchFormControlBase
     */
    public onEnter($event: any): void {
        this.ctrlEvent({
            controlname: this.name,
            action: 'search',
            data: this.data,
        });
    }

    /**
     * 搜索
     *
     * @memberof SearchFormControlBase
     */
    public search() {
        this.handleCtrlEvents('onsearch', { action: 'search', data: this.data }).then((result: boolean) => {
            if (!result) {
                return;
            }
            this.ctrlEvent({
                controlname: this.name,
                action: 'search',
                data: this.data,
            });
        })
    }

    /**
     * 确定
     *
     * @return {*}
     * @memberof SearchFormControlBase
     */
    public onOk() {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        let propip: any = this.$refs.propip;
        propip.handleMouseleave();
        this.onSave(this.saveItemName);
        this.dropdownVisible = false;
    }

    /**
     * 取消设置
     *
     * @return {*}
     * @memberof SearchFormControlBase
     */
    public onCancel() {
        if (this.Environment && this.Environment.isPreviewMode) {
            return;
        }
        let propip: any = this.$refs.propip;
        propip.handleMouseleave();
        this.dropdownVisible = false;
    }

    /**
     * @description 填充搜索表单
     * @param {string} value 历史记录值
     * @memberof SearchFormControlBase
     */
    public fillSearchForm(value: string) {
      const find = this.historyItems.find((item: any) => Object.is(item.value, value));
      if (find) {
        this.data = JSON.parse(JSON.stringify(find.data));
        this.dropdownVisible = false;
      }
    }

    /**
     * 删除记录
     *
     * @return {*}
     * @memberof SearchFormControlBase
     */
    public removeHistoryItem(event: any, item: any) {
        event.stopPropagation();
        if (!(item && item.name && item.value)) {
            return;
        }
        const index = this.historyItems.findIndex((_item: any) => {
            return _item.name == item.name && _item.value == _item.value;
        });
        if (index !== -1) {
            this.historyItems.splice(index, 1);
            if (this.selectItem == item.value) {
                if (this.historyItems.length > 0) {
                    this.selectItem = this.historyItems[0].value;
                    this.data = JSON.parse(JSON.stringify(this.historyItems[0].data));
                } else {
                    this.selectItem = null;
                    Object.keys(this.data).forEach((key: any) => {
                        this.data[key] = null;
                    })
                }
            }
            let param: any = {};
            Object.assign(param, {
                model: JSON.parse(JSON.stringify(this.historyItems)),
                appdeName: this.appDeCodeName,
                modelid: this.modelId,
                utilServiceName: this.utilServiceName,
                ...this.viewparams
            });
            let post = this.service.saveModel(this.utilServiceName, this.context, param);
            post.then((response: any) => {
                this.ctrlEvent({ controlname: this.controlInstance.name, action: "save", data: response.data });
            }).catch((response: any) => {
                LogUtil.log(response);
            });
        }
    }

    /**
     * 保存
     *
     * @return {*}
     * @memberof SearchFormControlBase
     */
    public async onSave(name?: string) {
        if (Util.isEmptyObject(this.data)) {
            LogUtil.warn(this.$t('app.searchform.nosearchparam'));
            return;
        }
        let time = moment();
        this.historyItems.push({
            name: await this.getSaveName(name),
            value: time.unix().toString(),
            data: JSON.parse(JSON.stringify(this.data))
        })
        this.selectItem = time.unix().toString();
        let param: any = {};
        Object.assign(param, {
            model: JSON.parse(JSON.stringify(this.historyItems)),
            appdeName: this.appDeCodeName,
            modelid: this.modelId,
            utilServiceName: this.utilServiceName,
            ...this.viewparams
        });
        try {
            const response = await this.service.saveModel(this.utilServiceName, this.context, param);
            this.ctrlEvent({ controlname: this.controlInstance.name, action: "save", data: response.data });
        } catch (error: any) {
            LogUtil.error(error);
        }
    }

    /**
     * 改变过滤条件
     *
     * @return {*}
     * @memberof SearchFormControlBase
     */
    public onFilterChange(evt: any) {
        let item: any = this.historyItems.find((item: any) => Object.is(evt, item.value));
        if (item) {
            this.selectItem = item.value;
            this.data = JSON.parse(JSON.stringify(item.data));
        }
    }

    /**
     * 重置
     *
     * @memberof SearchFormControlBase
     */
    public reset() {
        this.handleCtrlEvents('onreset', { action: 'reset' }).then((result: boolean) => {
            if (!result) {
                return;
            }
            if(this.data && Object.keys(this.data).length >0){
                Object.keys(this.data).forEach((key:string) =>{
                    this.data[key] = null;
                })
            }
            this.loadDraft({}, 'RESET');
        });
    }

    /**
     * 开启自动搜索时，值变更触发搜索
     * 
     * @param $event 
     * @memberof SearchFormControlBase
     */
    public onFormItemValueChange($event: { name: string, value: any }): void {
        super.onFormItemValueChange($event);
        //  自动搜索
        if ((this.controlInstance as any).enableAutoSearch) {
            this.search();
        }
    }

    /**
     * 保存查询条件时获取保存名称
     * 
     * @memberof SearchFormControlBase
     */
    public async getSaveName(name?: string): Promise<string> {
        if (name) {
            return name;
        }
        for (const key of Object.keys(this.data)) {
            if (key.search(/n_\\S*_\\S*/) && Util.isExistAndNotEmpty(this.data[key])) {
                const field = this.controlInstance.findPSDEFormItem(key)?.getPSAppDEField?.();
                if (field) {
                    const editItem = this.findFormItemByField(field.name);
                    let value = await this.formatCodelistValue(this.data[key], editItem);
                    if (editItem) {
                        name += `${name == '' ? '' : ', '}${field.logicName}: ${value}`;
                    }
                }
            }
        }
        return name || moment().unix().toString();
    }

    /**
     * 转化代码表值
     * 
     * @memberof SearchFormControlBase
     */
    public async formatCodelistValue(value: any, item: any): Promise<any> {
        const codeList = item.getPSEditor?.()?.getPSAppCodeList?.();
        if (codeList) {
            try {
                let response = await this.codeListTranslator.getCodeListText(value, codeList, this, Util.deepCopy(this.context), Util.deepCopy(this.viewparams));
                if (response) {
                    return response;
                }
            } catch {
                return value;
            }
        }
        return value;
    }

    /**
     * 折叠状态改变
     *
     * @memberof SearchFormControlBase
     */
     public onCollapseChange() {
        this.collapsed = !this.collapsed;
        // 默认显示两行
        let defaultExpandCount = 0;
        Object.keys(this.detailsModel).forEach((key: string) => {
            const detail = this.detailsModel[key];
            if (this.collapsed) {
                if (Object.is(detail.detailType, 'FORMITEM') && (detail.col || detail.offset > 0)) {
                    defaultExpandCount += detail.col + detail.offset;
                }
                if (defaultExpandCount > 48) {
                    detail.visible = false;
                }
            } else {
                detail.visible = true;
            }
        })
    }
}