
/**
 * 应用组件服务
 * 
 * @memberof AppComponentService
 */
export class AppComponentService {

    /**
     * 视图组件Map
     * 
     * @memberof AppComponentService
     */
    protected static viewMap: Map<string, any> = new Map();

    /**
     * 部件组件Map
     * 
     * @memberof AppComponentService
     */
    protected static controlMap: Map<string, any> = new Map();

    /**
     * 控件组件Map
     * 
     * @memberof AppComponentService
     */
    protected static editorMap: Map<string, any> = new Map();

    /**
     * 注册应用组件

     * 
     * @memberof AppComponentService
     */
    public static registerAppComponents() {
        this.registerViewComponents();
        this.registerControlComponents();
        this.registerEditorComponents();
    }

    /**
     * 注册视图组件
     * 
     * @memberof AppComponentService
     */
    protected static registerViewComponents() {
        this.viewMap.set("APPINDEXVIEW_DEFAULT",  () => { return import('../../components/view/app-default-indexview/app-default-indexview') });
        this.viewMap.set("DEMOBMDVIEW_DEFAULT", () => { return import('../../components/view/app-default-mob-mdview/app-default-mob-mdview') });
        this.viewMap.set("DEMOBEDITVIEW_DEFAULT", () => { return import('../../components/view/app-default-mob-editview/app-default-mob-editview') });
        this.viewMap.set("DEMOBEDITVIEW3_DEFAULT",() => { return import('../../components/view/app-default-mob-editview3/app-default-mob-editview3') });
        this.viewMap.set("APPPORTALVIEW_DEFAULT", () => { return import('../../components/view/app-default-mob-portalview/app-default-mob-portalview') });
        this.viewMap.set("DEMOBCALENDARVIEW_DEFAULT", () => { return import('../../components/view/app-default-mob-calendarview/app-default-mob-calendarview') });
        this.viewMap.set("DEMOBCHARTVIEW_DEFAULT", () => { return import('../../components/view/app-default-mob-chartview/app-default-mob-chartview') });
        this.viewMap.set("DEMOBTABEXPVIEW_DEFAULT", () => { return import('../../components/view/app-default-mob-tabexpview/app-default-mob-tabexpview') });
        this.viewMap.set("DEMOBLISTEXPVIEW_DEFAULT", () => { return import('../../components/view/app-default-mob-listexpview/app-default-mob-listexpview') });
        this.viewMap.set("DEMOBTREEVIEW_DEFAULT", () => { return import('../../components/view/app-default-mob-treeview/app-default-mob-treeview') });
        this.viewMap.set("DEMOBOPTVIEW_DEFAULT", () => { return import('../../components/view/app-default-mob-optview/app-default-mob-optview') });
        this.viewMap.set("DEMOBPICKUPMDVIEW_DEFAULT", () => { return import('../../components/view/app-default-mob-pickmdview/app-default-mob-pickmdview') });
        this.viewMap.set("DEMOBPICKUPVIEW_DEFAULT", () => { return import('../../components/view/app-default-mob-pickview/app-default-mob-pickview') });
        this.viewMap.set("DEMOBMPICKUPVIEW_DEFAULT", () => { return import('../../components/view/app-default-mob-mpickview/app-default-mob-mpickview') });
        this.viewMap.set("DEMOBPORTALVIEW_DEFAULT", () => { return import('../../components/view/app-default-mob-deportalview/app-default-mob-deportalview') });
        this.viewMap.set("DEMOBEDITVIEW9_DEFAULT", () => { return import('../../components/view/app-default-mob-editview/app-default-mob-editview') });
        this.viewMap.set("DEMOBMEDITVIEW9_DEFAULT", () => { return import('../../components/view/app-default-mob-meditview/app-default-mob-meditview') });
        this.viewMap.set("DEMOBMDVIEW9_DEFAULT", () => { return import('../../components/view/app-default-mob-mdview/app-default-mob-mdview') });
        this.viewMap.set("DEMOBPICKUPTREEVIEW_DEFAULT", () => { return import('../../components/view/app-default-mob-pickuptreeview/app-default-mob-pickuptreeview') });
        this.viewMap.set("DEMOBWFDYNAEDITVIEW_DEFAULT", () => { return import('../../components/view/app-default-mob-wfdynaeditview/app-default-mob-wfdynaeditview') });
        this.viewMap.set("DEMOBWFDYNAACTIONVIEW_DEFAULT",() => { return import('../../components/view/app-default-mob-wfdynaactionview/app-default-mob-wfdynaactionview') });
        this.viewMap.set("DEMOBWFDYNAEXPMDVIEW_DEFAULT", () => { return import('../../components/view/app-default-mob-wfdynaexpmdview/app-default-mob-wfdynaexpmdview') });
        this.viewMap.set("DEMOBWFDYNASTARTVIEW_DEFAULT", () => { return import('../../components/view/app-default-mob-wfdynastartview/app-default-mob-wfdynastartview') });
        this.viewMap.set("DEMOBWFDYNAEDITVIEW3_DEFAULT", () => { return import('../../components/view/app-default-mob-wfdynaeditview3/app-default-mob-wfdynaeditview3') });
        this.viewMap.set("DEMOBREDIRECTVIEW_DEFAULT", () => { return import('../../components/view/app-default-mob-deredirectview/app-default-mob-deredirectview') });
        this.viewMap.set("DEMOBCUSTOMVIEW_DEFAULT", () => { return import('../../components/view/app-default-mob-customview/app-default-mob-customview') });
        this.viewMap.set("APPWFSTEPTRACEVIEW_DEFAULT", () => { return import('../../components/view/app-default-wfsteptraceview/app-default-wfsteptraceview') });
        this.viewMap.set("DEMOBPANELVIEW_DEFAULT", () => { return import('../../components/view/app-default-mob-depanelview/app-default-mob-depanelview') });
        this.viewMap.set("DEMOBWIZARDVIEW_DEFAULT", () => { return import('../../components/view/app-default-mob-wizard-view/app-default-mob-wizard-view') });    
        // 注册视图插件
        this.viewMap.set("VIEWSTYLE", 'app-view-custom-viewstyle');
        // 注册视图样式，无插件模式
        this.viewMap.set("DEMOBMDVIEW_TESTVIEWSTYLE", 'app-testviewstyle');
    }

    /**
     * 获取视图组件
     * 
     * @memberof AppComponentService
     */
    public static getViewComponents(viewType: string, viewStyle: string, pluginCode?: string) {
        let componentName = 'app-default-notsupportedview';
        if(pluginCode){
            componentName = this.viewMap.get(`${pluginCode}`);
        }else{
            componentName = this.viewMap.get(`${viewType}_${viewStyle}`);
        }
        return componentName || 'app-default-notsupportedview';
    }

    /**
     * 注册部件组件

     * 
     * @memberof AppComponentService
     */
    protected static registerControlComponents() {
        this.controlMap.set("APPMENU_DEFAULT", ()=>{ return import('../../components/control/app-default-mob-appmenu/app-default-mob-appmenu') });
        this.controlMap.set("APPMENU_LISTVIEW", ()=>{ return import('../../components/control/app-default-mob-appmenu/app-default-mob-appmenu') });
        this.controlMap.set("MOBMDCTRL_LISTVIEW", ()=>{ return import('../../components/control/app-default-mob-mdctrl/app-default-mob-mdctrl') });
        this.controlMap.set("MOBMDCTRL_DEFAULT", ()=>{ return import('../../components/control/app-default-mob-mdctrl/app-default-mob-mdctrl') });
        this.controlMap.set("FORM_DEFAULT", ()=>{ return import('../../components/control/app-default-mob-form/app-default-mob-form') });
        this.controlMap.set("APPMENU_ICONVIEW", ()=>{ return import('../../components/control/app-default-mob-appmenu/app-default-mob-appmenu') });
        this.controlMap.set("DASHBOARD_DEFAULT", ()=>{ return import('../../components/control/app-default-mob-dashboard/app-default-mob-dashboard') });
        this.controlMap.set("PORTLET_DEFAULT", ()=>{ return import('../../components/control/app-default-mob-portlet/app-default-mob-portlet') });
        this.controlMap.set("CHART_DEFAULT", ()=>{ return import('../../components/control/app-default-mob-chart/app-default-mob-chart') });
        this.controlMap.set("CHART_NEW", ()=>{ return import('../../components/control/app-default-mob-chart/app-default-mob-chart') });
        this.controlMap.set("CALENDAR_DEFAULT", ()=>{ return import('../../components/control/app-default-mob-calendar/app-default-mob-calendar') });
        this.controlMap.set("CALENDAR_TIMELINE", ()=>{ return import('../../components/control/app-default-mob-calendar/app-default-mob-calendar') });
        this.controlMap.set("TABEXPPANEL_DEFAULT", ()=>{ return import('../../components/control/app-default-mob-tabexppanel/app-default-mob-tabexppanel') });
        this.controlMap.set("TABVIEWPANEL_DEFAULT", ()=>{ return import('../../components/control/app-default-mob-tabviewpanel/app-default-mob-tabviewpanel') });
        this.controlMap.set("LIST_DEFAULT", ()=>{ return import('../../components/control/app-default-mob-mdctrl/app-default-mob-mdctrl') });
        this.controlMap.set("LISTEXPBAR_DEFAULT", ()=>{ return import('../../components/control/app-default-mob-listexpbar/app-default-mob-listexpbar') });
        this.controlMap.set("TREEVIEW_DEFAULT", ()=>{ return import('../../components/control/app-default-mob-tree/app-default-mob-tree') });
        this.controlMap.set("MULTIEDITVIEWPANEL_DEFAULT", ()=>{ return import('../../components/control/app-default-mob-meditviewpanel/app-default-mob-meditviewpanel') });
        this.controlMap.set("CONTEXTMENU_DEFAULT", ()=>{ return import('../../components/control/app-default-mob-contextmenu/app-default-mob-contextmenu') });
        this.controlMap.set("PICKUPVIEWPANEL_DEFAULT", ()=>{ return import('../../components/control/app-default-mob-pickupviewpanel/app-default-mob-pickupviewpanel') });
        this.controlMap.set("SEARCHFORM_DEFAULT", ()=>{ return import('../../components/control/app-default-mob-searchform/app-default-mob-searchform') });
        this.controlMap.set("PANEL_DEFAULT", ()=>{ return import('../../components/control/app-default-mob-panel/app-default-mob-panel') });
        this.controlMap.set("DRTAB_DEFAULT", ()=>{ return import('../../components/control/app-default-mob-drtab/app-default-mob-drtab') });
        this.controlMap.set("WIZARDPANEL_DEFAULT", ()=>{ return import('../../components/control/app-default-mob-wizard-panel/app-default-mob-wizard-panel') });
        this.controlMap.set("SEARCHBAR_DEFAULT", ()=>{ return import('../../components/control/app-default-mob-searchbar/app-default-mob-searchbar') });    
        // 临时
        this.controlMap.set("PFPlugin", 'app-default-mob-mdctrl');
        // 注册部件插件标识
        this.controlMap.set("listplugin", 'app-custom-listplugin');
        this.controlMap.set("testFormPlugin", 'app-editform-render-test-form-plugin');
        this.controlMap.set("NEW", ()=>{ return import('../../components/control/app-default-mob-chart/app-default-mob-chart') });
    }

    /**
     * 获取部件组件
     * 
     * @memberof AppComponentService
     */
    public static getControlComponents(ctrlType: string, ctrlStyle: string, pluginCode?: string) {
        let componentName = 'app-default-notsupportedcontrol';
        if(pluginCode){
            componentName = this.controlMap.get(`${pluginCode}`);
        }else{
            componentName = this.controlMap.get(`${ctrlType}_${ctrlStyle}`);
        }
        return componentName || 'app-default-notsupportedcontrol';
    }

    /**
     * 注册编辑器组件

     * 
     * @memberof AppComponentService
     */
    protected static registerEditorComponents() {
        this.editorMap.set('MOBTEXT_DEFAULT','app-mob-input');
        this.editorMap.set('MOBPASSWORD_DEFAULT','app-mob-input')
        this.editorMap.set('MOBNUMBER_DEFAULT','app-mob-input')
        this.editorMap.set('MOBSTEPPER_DEFAULT','app-mob-stepper')
        this.editorMap.set('MOBRADIOLIST_DEFAULT','app-mob-radio-list')
        this.editorMap.set('MOBTEXTAREA_DEFAULT','app-mob-textarea')
        this.editorMap.set('MOBSLIDER_DEFAULT','app-mob-slider')
        this.editorMap.set('MOBSWITCH_DEFAULT','app-mob-switch')
        this.editorMap.set('MOBRATING_DEFAULT','app-mob-rate')
        this.editorMap.set('MOBDATE_DEFAULT','app-mob-datetime-picker')
        this.editorMap.set('MOBHTMLTEXT_DEFAULT','app-mob-rich-text-editor')
        this.editorMap.set('MOBDROPDOWNLIST_DEFAULT','app-mob-select')
        this.editorMap.set('MOBCHECKLIST_DEFAULT','app-mob-check-list')
        this.editorMap.set('MOBPICKER_DEFAULT','app-mob-picker')
        this.editorMap.set('MOBMPICKER_DEFAULT','app-mob-mpicker')
        this.editorMap.set('MOBPICKER_DROPDOWNVIEW_DEFAULT','app-mob-select-drop-down')
        this.editorMap.set('MOBSINGLEFILEUPLOAD_DEFAULT','app-mob-file-upload')
        this.editorMap.set('MOBMULTIFILEUPLOAD_DEFAULT','app-mob-file-upload')
        this.editorMap.set('MOBPICTURE_DEFAULT','app-mob-picture')
        this.editorMap.set('MOBPICTURELIST_DEFAULT','app-mob-picture')
        this.editorMap.set('SPAN_DEFAULT','app-mob-span')
        // 预置扩展编辑器
        this.editorMap.set("MOBDATE_day", "app-mob-datetime-picker");
        this.editorMap.set("MOBNUMBER_POSITIVENUMBER", "app-mob-input");
        //微服务编辑器
        //微服务编辑器
        this.editorMap.set("MOBPICKER_MOBORGSELECT", "app-mob-org-select");
        this.editorMap.set("MOBPICKER_MOBORGMULTIPLE", "app-mob-org-select");
        this.editorMap.set("MOBPICKER_MOBALLORGSELECT", "app-mob-org-select");
        this.editorMap.set("MOBPICKER_MOBALLORGMULTIPLE", "app-mob-org-select");
        this.editorMap.set("MOBPICKER_MOBALLDEPTPERSONSELECT", "app-mob-department-personnel");
        this.editorMap.set("MOBPICKER_MOBALLDEPTPERSONMULTIPLE", "app-mob-department-personnel");
        this.editorMap.set("MOBPICKER_MOBDEPTPERSONSELECT", "app-mob-department-personnel");
        this.editorMap.set("MOBPICKER_MOBDEPTPERSONMULTIPLE", "app-mob-department-personnel");
        this.editorMap.set("MOBPICKER_MOBALLEMPSELECT", "app-mob-group-select");
        this.editorMap.set("MOBPICKER_MOBALLEMPMULTIPLE", "app-mob-group-select");
        this.editorMap.set("MOBPICKER_MOBEMPSELECT", "app-mob-group-select");
        this.editorMap.set("MOBPICKER_MOBEMPMULTIPLE", "app-mob-group-select");
        this.editorMap.set("MOBPICKER_MOBALLDEPATMENTSELECT", "app-mob-department-select");
        this.editorMap.set("MOBPICKER_MOBALLDEPATMENTMULTIPLE", "app-mob-department-select");
        this.editorMap.set("MOBPICKER_MOBDEPATMENTSELECT", "app-mob-department-select");
        this.editorMap.set("MOBPICKER_MOBDEPATMENTMULTIPLE", "app-mob-department-select");
        // 注册编辑器
        // pc 编辑器标识
        this.editorMap.set('TEXT_DEFAULT','app-mob-input');
        this.editorMap.set('TEXTBOX_DEFAULT','app-mob-input');
        this.editorMap.set('PASSWORD_DEFAULT','app-mob-input');
        this.editorMap.set('NUMBER_DEFAULT','app-mob-input');
        this.editorMap.set('STEPPER_DEFAULT','app-mob-stepper');
        this.editorMap.set('RADIOLIST_DEFAULT','app-mob-radio-list');
        this.editorMap.set('TEXTAREA_DEFAULT','app-mob-textarea');
        this.editorMap.set('SLIDER_DEFAULT','app-mob-slider');
        this.editorMap.set('SWITCH_DEFAULT','app-mob-switch');
        this.editorMap.set('RATING_DEFAULT','app-mob-rate');
        this.editorMap.set('DATE_DEFAULT','app-mob-datetime-picker');
        this.editorMap.set('DATEPICKER_DEFAULT','app-mob-datetime-picker');
        this.editorMap.set('HTMLTEXT_DEFAULT','app-mob-rich-text-editor');
        this.editorMap.set('DROPDOWNLIST_DEFAULT','app-mob-select');
        this.editorMap.set('MDROPDOWNLIST_DEFAULT','app-mob-check-list');
        this.editorMap.set('RADIOBUTTONLIST_DEFAULT','app-mob-radio-list');
        this.editorMap.set('CHECKLIST_DEFAULT','app-mob-check-list');
        this.editorMap.set('PICKER_DEFAULT','app-mob-picker');
        this.editorMap.set('MPICKER_DEFAULT','app-mob-mpicker');
        this.editorMap.set('PICKER_DROPDOWNVIEW_DEFAULT','app-mob-select-drop-down');
        this.editorMap.set('SINGLEFILEUPLOAD_DEFAULT','app-mob-file-upload');
        this.editorMap.set('FILEUPLOADER_DEFAULT','app-mob-file-upload');
        this.editorMap.set('MULTIFILEUPLOAD_DEFAULT','app-mob-file-upload');
        this.editorMap.set('PICTURE_DEFAULT','app-mob-picture');
        this.editorMap.set('PICTURELIST_DEFAULT','app-mob-picture');


    }

    /**
     * 获取编辑器组件
     * 
     * @memberof AppComponentService
     */
    public static getEditorComponents(editorType: string, editorStyle: string) {
        let componentName = editorStyle ? this.editorMap.get(`${editorType}_${editorStyle}`) : this.editorMap.get(`${editorType}_DEFAULT`);
        return componentName || 'app-not-supported-editor';
    }

}