import qs from "qs";
import { ViewTool } from "../utils";
import { ViewEngine } from "./view-engine";

/**
 * 导航视图引擎
 *
 * @export
 * @class ExpViewEngine
 * @extends {ViewEngine}
 */
export class ExpViewEngine extends ViewEngine {

    /**
     * 导航栏部件
     *
     * @protected
     * @type {*}
     * @memberof ExpViewEngine
     */
    protected expBar: any = null;

    /**
     * 是否真正选中
     *
     * @protected
     * @type {boolean}
     * @memberof ExpViewEngine
     */
    protected isRealSelected: boolean = false;

    /**
     * 是否关闭导航视图
     *
     * @protected
     * @type {boolean}
     * @memberof ExpViewEngine
     */
    protected isCloseNavView: boolean = false;

    /**
     * 引擎加载
     *
    * @memberof ExpViewEngine
     */
    public load() {
        super.load();
        if (this.getExpBar() && this.isLoadDefault) {
            const tag = this.getExpBar().name;
            this.setViewState2({ tag: tag, action: 'load', viewdata: this.view.viewparams });
        } else {
            this.isLoadDefault = true;
        }
    }

    /**
     * 搜索
     *
     * @param {*} data
     * @memberof ExpViewEngine
     */
    public search(data: any) {
        const expBar = this.getExpBar();
        if (expBar) {
            this.setViewState2({ tag: expBar.name, action: 'load', viewdata: null });
        }
    }

    /**
     * 关闭导航视图
     *
     * @memberof ExpViewEngine
     */
    public closeNavView() {
        this.view.backSplit = this.view.split;
        this.view.split = 1;
        this.view.navItem = null;
        this.isCloseNavView = true;
    }

    /**
     * 处理导航视图重绘(有选中项，且导航视图需要刷新则通知嵌入导航视图执行刷新逻辑)
     * 
     * @memberof ExpViewEngine
     */
    public handleNavViewRefresh(tag: string) {
        if (this.view && this.view.viewState && this.isRealSelected) {
            this.setViewState2({ tag, action: 'load', viewdata: this.view.viewparams });
        }
    }

    /**
     * 事件处理
     *
     * @param {string} ctrlName 事件标识
     * @param {string} eventName 
     * @param {*} args
     * @memberof ExpViewEngine
     */
    public onCtrlEvent(ctrlName: string, eventName: string, args: any) {
        const expBar = this.getExpBar();
        if (ctrlName === expBar?.name) {
            this.handleExpBarEvents(eventName, args);
        }
        if (ctrlName === expBar?.xDataControlName) {
            this.handleXDataControlEvents(eventName, args);
        }
    }

    /**
     * 处理导航栏事件
     *
     * @protected
     * @param {string} eventName
     * @param {*} args
     * @memberof ExpViewEngine
     */
    protected handleExpBarEvents(eventName: string, args: any) {
        if (Object.is(eventName, 'load')) {
            this.emitViewEvent('viewLoaded', args);
        }
        if (Object.is(eventName, 'selectionchange')) {
            if (this.isCloseNavView) {
                this.isCloseNavView = false;
                return;
            }
            if (this.view && args && args.srfnavdata && args.srfnavdata.context && args.srfnavdata.context.viewpath) {
                this.view.navItem = args;
                if (this.view.backSplit !== 0) {
                    this.view.split = this.view.backSplit;
                }
                let isDefaultSelect: boolean = false;
                // 计算真实选中值
                if (args && args.data && args.data[0]) {
                    const selectedData = args.data[0];
                    isDefaultSelect = !!args.data[0].isDefaultSelect;
                    const result = Object.keys(selectedData).find((key: string) => {
                        return selectedData[key] !== null && key !== 'srfchecked';
                    })
                    if(result){
                        this.isRealSelected = true;
                    }else{
                        this.isRealSelected = false;
                    }
                }
                if(!isDefaultSelect && args.srfnavdata && args.srfnavdata.data){
                    const {startPath, viewParams} = ViewTool.getViewParamsByPath(this.view.$route.fullPath);
                    viewParams.srfnav = args.srfnavdata.data;
                    this.view.$router.push(`${startPath}?${encodeURIComponent(qs.stringify(viewParams, { delimiter: ';' }))}`);
                }
                this.view.$forceUpdate();
            }
            this.emitViewEvent('viewdataschange', args?.data);
        }
        if (Object.is(eventName, 'activated')) {
            this.emitViewEvent('viewdatasactivated', args);
        }
    }

    /**
     * 处理导航栏数据部件事件
     *
     * @protected
     * @param {string} eventName
     * @param {*} args
     * @memberof ExpViewEngine
     */
    protected handleXDataControlEvents(eventName: string, args: any) {
        if (Object.is(eventName, 'beforeload')) {
            this.handleBeforeLoad(args);
        }
    }

    /**
     * 导航栏数据部件加载之前
     *
     * @protected
     * @param {*} args
     * @memberof ExpViewEngine
     */
    protected handleBeforeLoad(args: any) {
        if (this.view && this.view.quickGroupData) {
            Object.assign(args, { viewparams: this.view.quickGroupData });
        }
    }

    /**
     * 获取导航栏
     *
     * @return {*} 
     * @memberof ExpViewEngine
     */
    public getExpBar() {
        return this.expBar;
    }

    /**
     * @description 视图销毁
     * @memberof ExpViewEngine
     */
    public destroyed() {
        super.destroyed();
        this.expBar = null;
    }
}