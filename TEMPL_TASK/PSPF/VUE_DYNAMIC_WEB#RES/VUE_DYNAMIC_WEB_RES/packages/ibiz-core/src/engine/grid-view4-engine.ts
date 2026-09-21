import { GridViewEngine } from "./grid-view-engine";

/**
 * 实体表格视图（上下关系）视图引擎
 *
 * @export
 * @class GridView4Engine
 * @extends {GridViewEngine}
 */
export class GridView4Engine extends GridViewEngine {

	/**
	 * 数据关系分页部件
	 *
	 * @protected
	 * @type {*}
	 * @memberof GridView4Engine
	 */
	protected drTab: any = null;

	/**
	 * 引擎初始化
	 *
	 * @param {*} opts
	 * @memberof GridView4Engine
	 */
	init(opts: any) {
		this.drTab = opts.drtab;
		super.init(opts);
	}

	/**
	 * 处理部件事件
	 *
	 * @param {string} controlName
	 * @param {string} action
	 * @param {*} data
	 * @memberof GridView4Engine
	 */
	public onCtrlEvent(controlName: string, action: string, data: any) {
		const drTabName = this.getDrTab()?.name;
		if (controlName === drTabName) {
			if (Object.is(action,'selectionchange')) {
				this.handleDrTabSelectionChange(data);
			}
		}
		super.onCtrlEvent(controlName, action, data);
	}

	/**
	 * 处理数据关系分页部件选中变化
	 *
	 * @param {*} data
	 * @memberof GridView4Engine
	 */
	public handleDrTabSelectionChange(data: any) {
		if (data) {
			this.view.drItem = data;
			this.setViewState2({ tag: this.getDrTab().name, action: 'change', viewdata: data });
			this.view.$forceUpdate();
		}
	}

	/**
	 * 表格部件选中数据变化
	 *
	 * @param {any[]} args
	 * @memberof GridView4Engine
	 */
	public selectionChange(args: any[]) {
		if (args && args.length) {
			const data = args[0];
			Object.assign(data, {
				srfparentdename: this.getMDCtrl()?.appDeCodeName,
				srfparentkey: data.srfkey,
			});
			this.setViewState2({ tag: this.getDrTab()?.name, action: 'state', viewdata: data });
		}
		super.selectionChange(args);
	}

	/**
	 * 获取数据关系分页部件
	 *
	 * @return {*} 
	 * @memberof GridView4Engine
	 */
	public getDrTab() {
		return this.drTab;
	}

    /**
     * @description 视图销毁
     * @memberof GridView4Engine
     */
    public destroyed() {
        super.destroyed();
        this.drTab = null;
    }

}