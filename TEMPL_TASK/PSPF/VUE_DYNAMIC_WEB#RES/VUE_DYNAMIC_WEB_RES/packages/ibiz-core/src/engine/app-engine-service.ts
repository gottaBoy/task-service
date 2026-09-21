import { LogUtil } from "../utils";
import { CalendarExpViewEngine } from "./calendar-exp-view-engine";
import { CalendarViewEngine } from "./calendar-view-engine";
import { ChartExpViewEngine } from "./chart-exp-view-engine";
import { ChartViewEngine } from "./chart-view-engine";
import { CommonViewEngine } from "./common-view-engine";
import { DataViewEngine } from "./data-view-engine";
import { DataViewExpViewEngine } from "./data-view-exp-view-engine";
import { DeIndexViewEngine } from "./deindex-view-engine";
import { EditViewEngine } from "./edit-view-engine";
import { EditView2Engine } from "./edit-view2-engine";
import { EditView3Engine } from "./edit-view3-engine";
import { EditView4Engine } from "./edit-view4-engine";
import { GridExpViewEngine } from "./grid-exp-view-engine";
import { GridViewEngine } from "./grid-view-engine";
import { GridView4Engine } from "./grid-view4-engine";
import { IndexPickupDataViewEngine } from "./index-pickup-data-view-engine";
import { KanBanViewEngine } from "./kan-ban-view-engine";
import { ListExpViewEngine } from "./list-exp-view-engine";
import { ListViewEngine } from "./list-view-engine";
import { MapExpViewEngine } from "./map-exp-view-engine";
import { MapViewEngine } from "./map-view-engine";
import { MEditViewEngine } from "./medit-view-engine";
import { MPickupViewEngine } from "./mpickup-view-engine";
import { PanelViewEngine } from "./panel-view-engine";
import { PickupGridViewEngine } from "./pickup-grid-view-engine";
import { PickupTreeViewEngine } from "./pickup-tree-view-engine";
import { ReportViewEngine } from "./report-view-engine";
import { TabExpViewEngine } from "./tab-exp-view-engine";
import { TabSearchViewEngine } from "./tab-search-view-engine";
import { TreeExpViewEngine } from "./tree-exp-view-engine";
import { TreeGridExViewEngine } from "./tree-grid-ex-view-engine";
import { TreeViewEngine } from "./tree-view-engine";
import { GanttViewEngine } from "./gantt-view-engine";
import { PortalViewEngine } from "./portal-view-engine";
import { OptionViewEngine } from "./option-view-engine";
import { PickupViewEngine } from "./pickup-view-engine";
import { PickupView2Engine } from "./pickup-view2-engine";
import { WizardViewEngine } from "./wizard-view-engine";
import { MPickupView2Engine } from "./mpickup-view2-engine";
import { PickupView3Engine } from "./pickup-view3-engine";
import { EditView9Engine } from "./edit-view9-engine";
import { GridView9Engine } from "./grid-view9-engine";

export class appEngineService{

    /**
     * 获取引擎服务
     *
     * @static
     * @param {string} type
     * @memberof appEngineService
     */
    public static getEngine(type:string){
        switch (type) {
            case 'DEGRIDVIEW':
                return new GridViewEngine();
            case 'DEGRIDVIEW4':
                return new GridView4Engine();
            case 'DEGRIDVIEW9':
              return new GridView9Engine();
            case 'DEEDITVIEW':
                return new EditViewEngine();
            case 'DEEDITVIEW9':
                return new EditView9Engine();
            case 'DECUSTOMVIEW':
                return new CommonViewEngine();
            case 'DEEDITVIEW2':
                return new EditView2Engine();
            case 'DEEDITVIEW3':
                return new EditView3Engine();
            case 'DEEDITVIEW4':
                return new EditView4Engine();
            case 'DELISTVIEW':
                return new ListViewEngine();
            case 'DEDATAVIEW':
                return new DataViewEngine();
            case 'DECALENDARVIEW':
                return new CalendarViewEngine();
            case 'DECHARTVIEW':
                return new ChartViewEngine();
            case 'DEKANBANVIEW':
                return new KanBanViewEngine();
            case 'DETREEVIEW':
                return new TreeViewEngine();
            case 'DEMEDITVIEW9':
                return new MEditViewEngine();
            case 'DETREEGRIDEXVIEW':
                return new TreeGridExViewEngine();
            case 'DEREPORTVIEW':
                return new ReportViewEngine();
            case 'DEMAPVIEW':
                return new MapViewEngine();
            case 'DEPICKUPGRIDVIEW':
                return new PickupGridViewEngine();
            case 'DEPICKUPTREEVIEW':
                return new PickupTreeViewEngine();
            case 'DEINDEXPICKUPDATAVIEW':
                return new IndexPickupDataViewEngine();
            case 'DETABSEARCHVIEW':
                return new TabSearchViewEngine();
            case 'DEMPICKUPVIEW':
                return new MPickupViewEngine();
            case 'DEMPICKUPVIEW2':
                return new MPickupView2Engine();
            case 'DEGRIDEXPVIEW':
                return new GridExpViewEngine();
            case 'DELISTEXPVIEW':
                return new ListExpViewEngine();
            case 'DEDATAVIEWEXPVIEW':
                return new DataViewExpViewEngine();
            case 'DECALENDAREXPVIEW':
                return new CalendarExpViewEngine();
            case 'DECHARTEXPVIEW':
                return new ChartExpViewEngine();
            case 'DEINDEXVIEW':
                return new DeIndexViewEngine();
            case 'DEPANELVIEW':
                return new PanelViewEngine();
            case 'DEMAPEXPVIEW':
                return new MapExpViewEngine();
            case 'DETABEXPVIEW':
                return new TabExpViewEngine();
            case 'DETREEEXPVIEW':
                return new TreeExpViewEngine();
            case 'DEGANTTVIEW':
                return new GanttViewEngine();
            case 'DEPORTALVIEW':
                return new PortalViewEngine();
            case 'DEOPTVIEW':
                return new OptionViewEngine();
            case 'DEPICKUPVIEW': 
                return new PickupViewEngine();
            case 'DEPICKUPVIEW2':
                return new PickupView2Engine();
            case 'DEPICKUPVIEW3':
                return new PickupView3Engine();
            case 'DEWIZARDVIEW':
                return new WizardViewEngine();
            default:
                LogUtil.warn(`${type}暂未实现`);
                break;
        }
    }
}