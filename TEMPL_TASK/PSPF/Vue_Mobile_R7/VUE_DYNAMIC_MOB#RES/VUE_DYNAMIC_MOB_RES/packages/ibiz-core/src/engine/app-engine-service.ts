import { LogUtil } from "../utils";
import { MobCalendarViewEngine } from "./mob-calendar-view-engine";
import { MobChartViewEngine } from "./mob-chart-view-engine";
import { MobCommonViewEngine } from "./mob-common-view-engine";
import { MobEditViewEngine } from "./mob-edit-view-engine";
import { MobMDViewEngine } from "./mob-mdview-engine";
import { MobMEditView9Engine } from "./mob-medit-view9-engine";
import { MobMPickupViewEngine } from "./mob-mpickup-view-engine";
import { MobPickupMDViewEngine } from "./mob-pickup-mdview-engine";
import { MobPickupViewEngine } from "./mob-pickup-view-engine";
import { MobTabExpViewEngine } from "./mob-tab-exp-view-engine";
import { MobWFDynaEditViewEngine } from "./mob-wfdyna-edit-view-engine";
import { MobWFEditView3Engine } from "./mob-wfedit-view3-engine";
import { MobWizardViewEngine } from "./mob-wizard-view-engine";
import { MobTreeViewEngine } from "./mob-tree-view-engine";
import { MobPickupTreeViewEngine } from "./mob-pickup-tree-view-engine";
import { MobEditView3Engine } from "./mob-edit-view3-engine";
import { MobListExpViewEngine } from "./mob-list-exp-view-engine";
import { MobOptionViewEngine } from "./mob-option-view-engine";
import { MobPortalViewEngine } from "./mob-portal-view-engine";
import { MobIndexViewEngine } from "./mob-indexview-engine";
import { CommonViewEngine } from "./common-view-engine";
import { MobCalendarExpViewEngine } from "./mob-calendar-exp-view-engine";

export class appEngineService {

    /**
     * 获取引擎服务
     *
     * @static
     * @param {string} type
     * @memberof appEngineService
     */
    public static getEngine(type: string) {
        switch (type) {
            case 'DEMOBMDVIEW':
            case 'DEMOBMDVIEW9':
                return new MobMDViewEngine();
            case 'DEMOBEDITVIEW':
            case 'DEMOBEDITVIEW9':
                return new MobEditViewEngine();
            case 'DEMOBEDITVIEW3':
                return new MobEditView3Engine();
            case 'DEMOBCUSTOMVIEW':
                return new MobCommonViewEngine();
            case 'DEMOBMEDITVIEW9':
                return new MobMEditView9Engine();
            case 'DEMOBWFDYNAEDITVIEW3':
                return new MobWFEditView3Engine();
            case 'DEMOBWFDYNAEDITVIEW':
                return new MobWFDynaEditViewEngine();
            case 'DEMOBPICKUPVIEW':
                return new MobPickupViewEngine();
            case 'DEMOBPICKUPMDVIEW':
                return new MobPickupMDViewEngine();
            case 'DEMOBMPICKUPVIEW':
                return new MobMPickupViewEngine();
            case 'DEMOBCALENDARVIEW':
                return new MobCalendarViewEngine();
            case 'DEMOBCHARTVIEW':
                return new MobChartViewEngine();
            case 'DEMOBTABEXPVIEW':
                return new MobTabExpViewEngine();
            case 'DEMOBWIZARDVIEW':
                return new MobWizardViewEngine();
            case 'DEMOBTREEVIEW':
                return new MobTreeViewEngine();
            case 'DEMOBPICKUPTREEVIEW':
                return new MobPickupTreeViewEngine();
            case 'DEMOBLISTEXPVIEW':
                return new MobListExpViewEngine();
            case 'DEMOBOPTVIEW':
                return new MobOptionViewEngine();
            case 'APPPORTALVIEW':
                return new MobPortalViewEngine();
            case 'APPINDEXVIEW':
                return new MobIndexViewEngine();
            case 'DEMOBPORTALVIEW':
                return new MobPortalViewEngine();
            case 'DEMOBCUSTOMVIEW':
                return new CommonViewEngine();
            case 'DEMOBCALENDAREXPVIEW':
                return new MobCalendarExpViewEngine();
            default:
                LogUtil.warn(`${type}暂未实现`);
                break;
        }
    }
}