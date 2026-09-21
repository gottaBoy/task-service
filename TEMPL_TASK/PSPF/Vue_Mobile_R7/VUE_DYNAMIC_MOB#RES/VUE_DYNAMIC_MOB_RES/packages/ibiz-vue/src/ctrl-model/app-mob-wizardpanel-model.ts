import { IPSAppDataEntity, IPSAppDEField, IPSDEWizardPanel } from '@ibiz/dynamic-model-api';

export class AppMobWizardPanelModel {

    /**
     * 向导面板模型实例
     * 
     * @memberof AppMobWizardPanelModel
     */
    public controlInstance!: IPSDEWizardPanel;

    /**
     * Creates an instance of AppMobWizardPanelModel.
     * 
     * @param {*} [opts={}]
     * @memberof AppMobWizardPanelModel
     */
    constructor(opts: any) {
        this.controlInstance = opts;
    }

    /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof AppMobWizardPanelModel
    */
    public getDataItems(): any[] {
        let modelArray: Array<any> = [];
        let appDEFileds: Array<IPSAppDEField> = (this.controlInstance.getPSAppDataEntity() as IPSAppDataEntity)?.getAllPSAppDEFields() || [];
        if (appDEFileds?.length > 0) {
            appDEFileds.forEach((field: any) => {
                modelArray.push({
                    name: field.keyField ? ((this.controlInstance.getPSAppDataEntity() as IPSAppDataEntity))?.codeName?.toLowerCase() : field.codeName.toLowerCase(),
                    prop: field.codeName.toLowerCase()
                })
            })
        }
        return modelArray;
    }
}