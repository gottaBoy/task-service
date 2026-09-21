import { IPSAppDataEntity, IPSAppDEChartView, IPSAppDEField, IPSAppDERS, IPSDEChart, IPSDEFormItem, IPSDESearchForm } from "@ibiz/dynamic-model-api";
import { ModelTool } from "ibiz-core";
export class AppMobChartModel {
    /**
     * 图表部件模型对象
     *
     * @type {IPSDEChart}
     * @memberof AppChartModel
     */
    public controlInstance!: IPSDEChart;

    /**
     * Creates an instance of AppChartModel.
     * @param {*} opts
     * @memberof AppChartModel
     */
    constructor(opts: any) {
        this.controlInstance = opts;
    }
    /**
     * 获取数据项集合
     *
     * @returns {any[]}
     * @memberof AppChartModel
     */
    public getDataItems(): any[] {
        const modelArray: any[] = [
            {
                name: 'size',
                prop: 'size',
                dataType: 'QUERYPARAM'
            },
            {
                name: 'query',
                prop: 'query',
                dataType: 'QUERYPARAM'
            },
            {
                name: 'filter',
                prop: 'filter',
                dataType: 'QUERYPARAM'
            },
            {
                name: 'page',
                prop: 'page',
                dataType: 'QUERYPARAM'
            },
            {
                name: 'sort',
                prop: 'sort',
                dataType: 'QUERYPARAM'
            },
            {
                name: 'srfparentdata',
                prop: 'srfparentdata',
                dataType: 'QUERYPARAM'
            },
            // 前端新增修改标识，新增为"0",修改为"1"或未设值
            {
                name: 'srffrontuf',
                prop: 'srffrontuf',
                dataType: 'TEXT',
            },
            // 预置工作流数据字段
            {
                name: 'srfprocessdefinitionkey',
                prop: 'srfprocessdefinitionkey',
                dataType: 'TEXT'
            },
            {
                name: 'srftaskdefinitionkey',
                prop: 'srftaskdefinitionkey',
                dataType: 'TEXT'
            },
            {
                name: 'srftaskid',
                prop: 'srftaskid',
                dataType: 'TEXT'
            }
        ];
        const appDataEntity: IPSAppDataEntity = this.controlInstance.getPSAppDataEntity() as IPSAppDataEntity;
        //关联主实体的主键
        const minorAppDERSs: Array<IPSAppDERS> = appDataEntity?.getMinorPSAppDERSs() || [];
        if (appDataEntity && appDataEntity.major == false && minorAppDERSs.length > 0) {
            minorAppDERSs.forEach((minorAppDERSs: IPSAppDERS) => {
                const majorAppDataEntity = minorAppDERSs.getMajorPSAppDataEntity();
                if (majorAppDataEntity) {
                    let obj: any = {
                        name: majorAppDataEntity.codeName?.toLowerCase(),
                        dataType: 'FRONTKEY',
                    };
                    if (minorAppDERSs.getParentPSAppDEField()) {
                        obj.prop = minorAppDERSs.getParentPSAppDEField()?.codeName.toLowerCase();
                    } else {
                        obj.prop = (ModelTool.getAppEntityKeyField(majorAppDataEntity) as IPSAppDEField)?.codeName || '';
                    }
                    modelArray.push(obj);
                }
            });
        }
        const searchFormInstance: IPSDESearchForm = ModelTool.findPSControlByType("SEARCHFORM", (this.controlInstance.getParentPSModelObject() as IPSAppDEChartView).getPSControls() || []);
        if (searchFormInstance) {
            (searchFormInstance.getPSDEFormItems?.() || []).forEach((formItem: IPSDEFormItem) => {
                let temp: any = { name: formItem.id, prop: formItem.id };
                if (formItem.getPSAppDEField?.()) {
                    temp.dataType = 'QUERYPARAM';
                }
                modelArray.push(temp);
            });
        }

        // 界面主键标识
        const keyField: string = (ModelTool.getAppEntityKeyField(appDataEntity) as IPSAppDEField)?.codeName || '';
        modelArray.push({
            name: appDataEntity?.codeName.toLowerCase(),
            prop: keyField.toLowerCase(),
        });
        return modelArray;
    }
}