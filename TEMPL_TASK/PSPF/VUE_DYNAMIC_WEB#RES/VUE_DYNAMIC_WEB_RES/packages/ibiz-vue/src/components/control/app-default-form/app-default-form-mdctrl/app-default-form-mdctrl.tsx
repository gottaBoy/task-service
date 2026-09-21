import {
    IPSAppDataEntity,
    IPSAppDEField,
    IPSControl,
    IPSDEFormMDCtrl,
    IPSDEFormDetail,
    IPSDEFormItem,
    IPSCodeListEditor,
} from '@ibiz/dynamic-model-api';
import { DataEntityService, DataServiceHelp, FormItemModel, ModelTool, Util } from 'ibiz-core';
import { Subject, Subscription } from 'rxjs';
import { Component, Prop } from 'vue-property-decorator';
import { AppDefaultFormDetail } from '../app-default-form-detail/app-default-form-detail';
import { AppDefaultFormMdCtrlRepeater } from './app-default-form-mdctrl-repeater';

/**
 * 表单多数据部件
 *
 * @export
 * @class AppDefaultFormMdCtrl
 * @extends {Vue}
 */
@Component({
    components: {
        AppDefaultFormMdCtrlRepeater,
    },
})
export class AppDefaultFormMdCtrl extends AppDefaultFormDetail {
    /**
     * 表单成员实例对象
     *
     * @type {*}
     * @memberof AppDefaultFormMdCtrl
     */
    @Prop() public declare detailsInstance: IPSDEFormMDCtrl;

    /**
     * 表单状态通知对象
     *
     * @type {*}
     * @memberof AppDefaultFormMdCtrl
     */
    @Prop() public formState!: Subject<any>;

    /**
     * 视图操作参数集合
     *
     * @type {*}
     * @memberof AppDefaultFormMdCtrl
     */
    @Prop() public viewCtx: any;

    /**
     * 名称
     *
     * @type {*}
     * @memberof AppDefaultFormMdCtrl
     */
    @Prop() public name!: string;

    /**
     * 表单数据
     *
     * @type {*}
     * @memberof AppDefaultFormMdCtrl
     */
    @Prop() public data: any;

    /**
     * 项模型
     *
     * @type {*}
     * @memberof AppDefaultFormMdCtrl
     */
    @Prop() public detailsModel: any;

    /**
     * 表单服务
     *
     * @type {*}
     * @memberof AppDefaultFormMdCtrl
     */
    @Prop() public service: any;

    /**
     * 重复器唯一key
     *
     * @type {number}
     * @memberof AppDefaultFormMdCtrl
     */
    public repeaterKey: string = Util.createUUID();

    /**
     *
     *
     * @type {boolean}
     * @memberof AppDefaultFormMdCtrl
     */
    public isloaded: boolean = false;

    /**
     * 多数据部件类型
     *
     * @type {[多数据部件类型] {LIST：列表、 FORM：表单、 REPEATER：重复器, GRID：表格, DATAVIEW：卡片视图 }}
     * @memberof AppDefaultFormMdCtrl
     */
    public contentType: string | 'LIST' | 'FORM' | 'REPEATER' | 'GRID' | 'DATAVIEW' = 'FORM';

    /**
     * 多数据内容部件
     *
     * @type {*}
     * @memberof AppDefaultFormMdCtrl
     */
    public contentCtrl: IPSControl | null = null;

    /**
     * 多数据内容数据
     *
     * @type {Array<any>}
     * @memberof AppDefaultFormMdCtrl
     */
    public contentCtrlData: Array<any> = [];

    /**
     * 表单状态事件
     *
     * @private
     * @type {(Subscription | undefined)}
     * @memberof AppDefaultFormMdCtrl
     */
    public formStateEvent: Subscription | undefined;

    /**
     * 数据服务
     *
     * @type {(DataEntityService | null)}
     * @memberof AppDefaultFormMdCtrl
     */
    public dataService: DataEntityService | null = null;

    /**
     * 应用实体
     *
     * @type {(IPSAppDataEntity | null)}
     * @memberof AppDefaultFormMdCtrl
     */
    public appDataEntity: IPSAppDataEntity | null = null;

    /**
     * 应用实体codeName
     *
     * @type {string}
     * @memberof AppDefaultFormMdCtrl
     */
    public appEntityCodeName: string = '';

    /**
     * 主键数据行codeName
     *
     * @type {(string)}
     * @memberof AppDefaultFormMdCtrl
     */
    public appEntityKeyField: string = '';

    /**
     * 多数据部件向子部件发指令对象
     *
     * @private
     * @type {Subject<any>}
     * @memberof AppDefaultFormMdCtrl
     */
    public MDCtrlState: Subject<any> = new Subject<any>();

    /**
     * 子表单数量
     *
     * @type {number}
     * @memberof AppDefaultFormMdCtrl
     */
    public childFormCount: number = 0;

    /**
     * 错误提示数据
     *
     * @type {number}
     * @memberof AppDefaultFormMdCtrl
     */
    public errorInfoCount: number = 0;

    /**
     * 嵌入部件是否挂载
     *
     * @type {boolean}
     * @memberof AppDefaultFormMdCtrl
     */
    public controlIsMounted: boolean = false;

    /**
     * 执行队列
     *
     * @type {Array<Function>}
     * @memberof AppDefaultFormMdCtrl
     */
    public excuteQueue: Array<Function> = [];

    /**
     * 初始化
     *
     * @memberof AppDefaultFormMdCtrl
     */
    public created() {
        this.initFormMDCtrl();
    }

    /**
     * 初始化多数据内容部件
     *
     * @memberof AppDefaultFormMdCtrl
     */
    public async initFormMDCtrl() {
        if (!this.formState) {
            return;
        }
        this.contentType = this.detailsInstance.contentType;
        this.contentCtrl = this.detailsInstance.getContentPSControl();
        //  多数据部件类型为表单、表格等
        if (this.contentCtrl) {
            await this.contentCtrl.fill(true);
            this.appDataEntity = (this.contentCtrl as any).getPSAppDataEntity();
            if (this.appDataEntity) {
                this.appEntityCodeName = this.appDataEntity.codeName.toLowerCase();
                this.appEntityKeyField = (ModelTool.getAppEntityKeyField(
                    this.appDataEntity,
                ) as IPSAppDEField).codeName.toLowerCase();
            }
            this.dataService = await DataServiceHelp.getInstance().getService(this.appDataEntity);
        }
        if (this.contentType === 'FORM' || this.contentType === 'GRID') {
            //  表单状态监听
            this.formStateEvent = this.formState.subscribe((event: any) => {
                // 表单加载完成
                if (Object.is(event.type, 'load')) {
                    this.loadData();
                }
                // 表单保存之前
                if (Object.is(event.type, 'beforesave')) {
                    if (this.contentType === 'FORM' && this.contentCtrlData.length === 0) {
                        this.mdCtrlDataSaved(event);
                    } else {
                        this.childFormCount = 0;
                        this.errorInfoCount = 0;
                        //  表单或表格通知保存
                        if (this.contentCtrl) {
                            this.MDCtrlState.next({
                                tag: this.contentCtrl.name,
                                action: 'save',
                                data: { showResultInfo: false },
                            });
                        }
                    }
                }
                // 表单保存完成
                if (Object.is(event.type, 'save') && !Object.is(event?.action, 'autoSave')) {
                    this.loadData();
                }
            });
        }
        //  重复器
        if (this.contentType === 'REPEATER') {
            this.formStateEvent = this.formState.subscribe((event: any) => {
                if (Object.is(event.type, 'save') && !Object.is(event?.action, 'autoSave')) {
                    this.repeaterKey = Util.createUUID();
                }
            })
        }
        this.isloaded = true;
    }

    /**
     * 销毁
     *
     * @memberof AppDefaultFormMdCtrl
     */
    public destroyed() {
        if (this.formStateEvent) {
            this.formStateEvent.unsubscribe();
        }
    }

    /**
     * 加载数据
     *
     * @memberof AppDefaultFormMdCtrl
     */
    public async loadData() {
        //  表单
        if (this.dataService && this.contentType == 'FORM') {
            const result = await this.dataService.execute('selectAppLocal', this.context, this.viewparams);
            const { status, data } = result;
            if (status === 200 && data && data.length > 0) {
                this.contentCtrlData = data;
            }
            return;
        }
        if (this.contentType === 'GRID' && this.contentCtrl) {
            if(this.controlIsMounted){
                this.MDCtrlState.next({
                    tag: this.contentCtrl.name,
                    action: 'load',
                    data: {},
                });
            }else{
                const name = this.contentCtrl.name;
                this.excuteQueue.push(() =>{
                    this.MDCtrlState.next({
                        tag: name,
                        action: 'load',
                        data: {},
                    });
                })
            }
        }
    }

    /**
     * 获取内建行为权限
     *
     * @protected
     * @param {('add' | 'remove')} action
     * @return {*} 
     * @memberof AppDefaultFormMdCtrl
     */
    protected calcBuildInActionsAuth(action: 'add' | 'remove') {
        let state: boolean = false;
        if (action == 'add') {
            if (
                this.detailsInstance.buildInActions == 1 ||
                this.detailsInstance.buildInActions == 3 ||
                this.detailsInstance.buildInActions == 5 ||
                this.detailsInstance.buildInActions == 7
            ) {
                state = true;
            }
        } else {
            if (
                this.detailsInstance.buildInActions == 4 ||
                this.detailsInstance.buildInActions == 5 ||
                this.detailsInstance.buildInActions == 6 ||
                this.detailsInstance.buildInActions == 7
            ) {
                state = true;
            }
        }
        return state;
    }

    /**
     * 删除数据
     *
     * @param {*} data
     * @memberof AppDefaultFormMdCtrl
     */
    public async handleRemove(args: any, index: number) {
        if (this.dataService) {
            const result = await this.dataService.execute('removeAppLocal', this.context, args);
            const { status, data } = result;
            if (status === 200 && data) {
                this.contentCtrlData.splice(index, 1);
            }
        }
    }

    /**
     * 新增数据
     *
     * @memberof AppDefaultFormMdCtrl
     */
    public async hanldeAdd() {
        //  数据服务类型
        if (this.dataService && this.appEntityKeyField) {
            const tempData = { [this.appEntityKeyField]: Util.createUUID() };
            const result = await this.dataService.execute(
                'createAppLocal',
                this.context,
                Object.assign(tempData, this.viewparams),
            );
            const { status, data } = result;
            if (status === 200 && data) {
                this.contentCtrlData.push(data);
            }
            return;
        }
    }

    /**
     * 部件事件
     * @param ctrl 部件
     * @param action  行为
     * @param data 数据
     *
     * @memberof AppDefaultFormMdCtrl
     */
    public onCtrlEvent(controlname: string, action: string, data: any) {
        if (this.contentCtrl && this.contentCtrl.name === controlname) {
            if(action === 'controlIsMounted'){
                this.controlIsMounted = true;
                if(this.excuteQueue.length >0){
                    this.excuteQueue.map((excuter:any) =>{
                        excuter();
                    })
                    this.excuteQueue = [];
                }
            }
            if (this.contentType === 'FORM') {
                if (action === 'save') {
                    this.childFormCount++;
                    if (this.childFormCount === this.contentCtrlData.length) {
                        this.mdCtrlDataSaved(data);
                    }
                }
                if (action === 'checkFail') {
                    if (this.errorInfoCount !== 0) {
                        return;
                    }
                    this.errorInfoCount++;
                    this.$throw(this.$t('app.searchform.globalerrortip') as string, 'save', {
                        dangerouslyUseHTMLString: true,
                    });
                }
            }
            if (this.contentType === 'GRID') {
                if (action === 'save') {
                    this.mdCtrlDataSaved(data);
                }
                if (action === 'checkFail') {
                    if (this.errorInfoCount !== 0) {
                        return;
                    }
                    this.errorInfoCount++;
                    this.$throw(this.$t('app.searchform.globalerrortip') as string, 'save', {
                        dangerouslyUseHTMLString: true,
                    });
                }
            }
        }
    }

    /**
     * 关闭视图
     *
     * @param {any} args
     * @memberof AppDefaultFormMdCtrl
     */
    public closeView(args: any): void {
        this.$emit('closeView', [args]);
    }

    /**
     * 多数据部件数据保存完成
     *
     * @public
     * @memberof AppFormDRUIPart
     */
    public mdCtrlDataSaved(event: any) {
        this.$emit('drdatasaved', { type: 'MDCTRL' });
    }

    /**
     * 处理重复器数据变化
     *
     * @param {string} name
     * @param {any[]} value
     * @memberof AppDefaultFormMdCtrl
     */
    public handleRepeaterDataChange(name: string, value: any, formItem?: IPSDEFormItem) {
        this.$emit('valueChange', { name, value }, formItem);
    }

    /**
     * 计算目标部件所需参数
     *
     * @param {*} controlInstance 要绘制的部件实例
     * @param {*} [otherParam] 其他参数
     * @returns
     * @memberof AppDefaultFormMdCtrl
     */
    public computeTargetCtrlData(controlInstance: any) {
        const targetCtrlName: string = `app-control-shell`;
        const targetCtrlParam: any = {
            dynamicProps: {
                viewparams: Util.deepCopy(this.viewparams),
                context: Util.deepCopy(this.context),
                viewCtx: this.viewCtx,
            },
            staticProps: {
                modelData: controlInstance,
                isautoload: true,
                localmode: true,
                viewState: this.MDCtrlState,
                buildInActions: this.detailsInstance.buildInActions
            },
        };
        if (controlInstance.controlType === 'GRID') {
            targetCtrlParam.staticProps.isOpenEdit = true;
        }
        Object.defineProperty(targetCtrlParam.staticProps, 'modelData', { enumerable: false, writable: true });
        const targetCtrlEvent: any = {
            'ctrl-event': ({ controlname, action, data }: { controlname: string; action: string; data: any }) => {
                this.onCtrlEvent(controlname, action, data);
            },
            closeView: ($event: any) => {
                this.closeView($event);
            },
        };
        return { targetCtrlName: targetCtrlName, targetCtrlParam: targetCtrlParam, targetCtrlEvent: targetCtrlEvent };
    }

    /**
     * 处理按钮行为点击
     *
     * @protected
     * @param {*}
     * @memberof AppDefaultFormMdCtrl
     */
    protected handleButtonActionClick(event: any) {
        this.$emit('actionClick', event);
    }

    /**
     * 绘制内容
     *
     * @returns {*}
     * @memberof AppDefaultFormMdCtrl
     */
    public render(): any {
        if (!this.isloaded) {
            return;
        }
        const { detailClassNames } = this.renderOptions;
        Object.assign(detailClassNames, { 'app-form-mdctrl': true, [this.name]: true });
        return <div class={detailClassNames}>{this.renderMainContent()}</div>;
    }

    /**
     * 绘制主内容区
     *
     * @return {*}
     * @memberof AppDefaultFormMdCtrl
     */
    public renderMainContent() {
        switch (this.contentType) {
            case 'FORM':
                return this.renderMDCtrlForm();
            case 'GRID':
                return this.renderMDCtrlGrid();
            case 'REPEATER':
                return this.renderMDCtrlRepeater();
        }
    }

    /**
     * 渲染表单
     *
     * @return {*}
     * @memberof AppDefaultFormMdCtrl
     */
    renderMDCtrlForm() {
        return [
            <div class='app-form-mdctrl__header'>
                {
                    this.calcBuildInActionsAuth('add') ? (
                        <el-button
                            type='primary'
                            icon='el-icon-plus'
                            size='mini'
                            circle
                            on-click={() => {
                                this.hanldeAdd();
                            }}
                        ></el-button>
                    ) : null
                }
            </div>,
            <div class='app-form-mdctrl__content'>
                {this.contentCtrlData.map((data: any, index: number) => {
                    return this.renderSingleForm(data, index);
                })}
            </div>,
        ];
    }

    /**
     * 渲染表格
     *
     * @return {*}
     * @memberof AppDefaultFormMdCtrl
     */
    renderMDCtrlGrid() {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.contentCtrl);
        return (
            <div class='app-form-mdctrl__content'>
                {this.$createElement(targetCtrlName, {
                    key: this.name,
                    props: targetCtrlParam,
                    ref: this.name,
                    on: targetCtrlEvent,
                })}
            </div>
        );
    }

    /**
     * 渲染重复器
     *
     * @return {*}
     * @memberof AppDefaultFormMdCtrl
     */
    renderMDCtrlRepeater() {
        return (
            <app-default-form-md-ctrl-repeater
                key={this.repeaterKey}
                detailInstance={this.detailsInstance}
                controlInstance={this.controlInstance}
                parentData={this.data}
                contextState={this.formState}
                detailsModel={this.detailsModel}
                service={this.service}
                context={this.context}
                viewparams={this.viewparams}
                on-valueChange={(name: string, value: any, formItem?: IPSDEFormItem) => this.handleRepeaterDataChange(name, value, formItem)}
                on-actionClick={(event: any) => this.handleButtonActionClick(event)}
            ></app-default-form-md-ctrl-repeater>
        );
    }

    /**
     * 绘制单个表单
     *
     * @param {*} data
     * @memberof AppDefaultFormMdCtrl
     */
    public renderSingleForm(data: any, index: number) {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(this.contentCtrl);
        Object.assign(targetCtrlParam.dynamicProps.context, {
            [this.appEntityCodeName]: data[this.appEntityKeyField],
        });
        return (
            <div class='app-form-mdctrl__row'>
                {
                    this.calcBuildInActionsAuth('remove') ? (
                        <el-button
                            class='app-form-mdctrl__remove'
                            type='danger'
                            size='mini'
                            icon='el-icon-delete'
                            circle
                            on-click={() => {
                                this.handleRemove(data, index);
                            }}
                        ></el-button>
                    ) : null
                }
                {this.$createElement(targetCtrlName, {
                    key: this.name,
                    props: targetCtrlParam,
                    ref: this.name,
                    on: targetCtrlEvent,
                })}
            </div>
        );
    }
}
