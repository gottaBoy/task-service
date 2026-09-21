import { IPSAppView, IPSDEGrid, IPSDERBase, IPSGridExpBar } from '@ibiz/dynamic-model-api';
import { GridExpBarControlInterface, Util } from 'ibiz-core';
import { ExpBarControlBase } from './expbar-control-base';

/**
 * 表格导航部件基类
 *
 * @export
 * @class GridExpControlBase
 * @extends {MDControlBase}
 */
export class GridExpBarControlBase extends ExpBarControlBase implements GridExpBarControlInterface {

    /**
     * 表格导航模型对象
     * 
     * @memberof GridExpBarControlBase
     */
    public declare controlInstance: IPSGridExpBar;

    /**
     * 数据部件
     *
     * @memberof GridExpBarControlBase
     */
    protected declare $xDataControl: IPSDEGrid;

    /**
     * 处理数据部件参数
     *
     * @memberof GridExpBarControlBase
     */
    public async handleXDataCtrlOptions() {
        this.navViewModel = await this.$xDataControl?.getNavPSAppView()?.fill() as IPSAppView;
        if (this.navViewModel) {
            this.navViewName = this.navViewModel.modelPath;
        }
        this.navFilter = this.$xDataControl?.navFilter ? this.$xDataControl.navFilter : "";
        const navPSDer: any = this.$xDataControl.getNavPSDER();
        if (navPSDer) {
            this.navPSDer = `n_${(navPSDer.pickupDEFName && navPSDer.minorCodeName).toLowerCase()}_eq`;
        }
        // this.navPSDer = (this.$xDataControl?.getNavPSDER?.() as IPSDERBase) ? "n_" + (this.$xDataControl.getNavPSDER() as any).pickupDEFName?.toLowerCase() + "_eq" : "";
        //  导航上下文
        const navContext = (this.$xDataControl as any).getPSNavigateContexts();
        if (navContext && navContext.length) {
            this.navigateContext = Util.formatNavParam(navContext);
        }
        //  导航参数
        const navParams = (this.$xDataControl as any).getPSNavigateParams();
        if (navParams && navParams.length) {
            this.navigateParams = Util.formatNavParam(navParams);
        }
    }

    /**
     * 处理快速分组模型动态数据部分(%xxx%)
     *
     *
     * @param {Array<any>} inputArray 代码表数组
     * @return {*} 
     * @memberof GridExpBarControlBase
     */
    public handleDynamicData(inputArray:Array<any>){
        if(inputArray.length >0){
            inputArray.forEach((item:any) =>{
               if(item.data && Object.keys(item.data).length >0){
                   Object.keys(item.data).forEach((name:any) =>{
                        let value: any = item.data[name];
                        if (value && typeof(value)=='string' && value.startsWith('%') && value.endsWith('%')) {
                            const key = (value.substring(1, value.length - 1)).toLowerCase();
                            if (this.context[key]) {
                                value = this.context[key];
                            } else if(this.viewparams[key]){
                                value = this.viewparams[key];
                            }
                        }
                        item.data[name] = value;
                   })
               }
            })
        }
        return inputArray;
    }

}