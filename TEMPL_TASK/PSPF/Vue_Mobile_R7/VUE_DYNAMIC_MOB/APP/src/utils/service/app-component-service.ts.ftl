<#ibiztemplate>
TARGET=PSSYSAPP
</#ibiztemplate>

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
        this.viewMap.set("APPINDEXVIEW_DEFAULT",  'app-default-indexview');
        this.viewMap.set("DEMOBMDVIEW_DEFAULT", 'app-default-mob-mdview');
        this.viewMap.set("DEMOBEDITVIEW_DEFAULT", 'app-default-mob-editview');
        this.viewMap.set("DEMOBEDITVIEW3_DEFAULT",'app-default-mob-editview3');
        this.viewMap.set("APPPORTALVIEW_DEFAULT", 'app-default-mob-portalview');
        this.viewMap.set("DEMOBCALENDARVIEW_DEFAULT", 'app-default-mob-calendarview');
        this.viewMap.set("DEMOBCHARTVIEW_DEFAULT", 'app-default-mob-chartview');
        this.viewMap.set("DEMOBTABEXPVIEW_DEFAULT", 'app-default-mob-tabexpview');
        this.viewMap.set("DEMOBLISTEXPVIEW_DEFAULT", 'app-default-mob-listexpview');
        this.viewMap.set("DEMOBTREEVIEW_DEFAULT", 'app-default-mob-treeview');
        this.viewMap.set("DEMOBOPTVIEW_DEFAULT", 'app-default-mob-optview');
        this.viewMap.set("DEMOBPICKUPMDVIEW_DEFAULT", 'app-default-mob-pickmdview');
        this.viewMap.set("DEMOBPICKUPVIEW_DEFAULT", 'app-default-mob-pickview');
        this.viewMap.set("DEMOBMPICKUPVIEW_DEFAULT", 'app-default-mob-mpickview');
        this.viewMap.set("DEMOBPORTALVIEW_DEFAULT", 'app-default-mob-deportalview');
        this.viewMap.set("DEMOBEDITVIEW9_DEFAULT", 'app-default-mob-editview');
        this.viewMap.set("DEMOBMEDITVIEW9_DEFAULT", 'app-default-mob-meditview');
        this.viewMap.set("DEMOBMDVIEW9_DEFAULT", 'app-default-mob-mdview');
        this.viewMap.set("DEMOBPICKUPTREEVIEW_DEFAULT", 'app-default-mob-pickuptreeview');
        this.viewMap.set("DEMOBWFDYNAEDITVIEW_DEFAULT", 'app-default-mob-wfdynaeditview');
        this.viewMap.set("DEMOBWFDYNAACTIONVIEW_DEFAULT",'app-default-mob-wfdynaactionview');
        this.viewMap.set("DEMOBWFDYNAEXPMDVIEW_DEFAULT", 'app-default-mob-wfdynaexpmdview');
        this.viewMap.set("DEMOBWFDYNASTARTVIEW_DEFAULT", 'app-default-mob-wfdynastartview');
        this.viewMap.set("DEMOBWFDYNAEDITVIEW3_DEFAULT", 'app-default-mob-wfdynaeditview3');
        this.viewMap.set("DEMOBREDIRECTVIEW_DEFAULT", 'app-default-mob-deredirectview');
        this.viewMap.set("DEMOBCUSTOMVIEW_DEFAULT", 'app-default-mob-customview');
        this.viewMap.set("APPWFSTEPTRACEVIEW_DEFAULT", 'app-default-wfsteptraceview');
        this.viewMap.set("DEMOBPANELVIEW_DEFAULT", 'app-default-mob-depanelview');
        this.viewMap.set("DEMOBWIZARDVIEW_DEFAULT", 'app-default-mob-wizard-view'); 
        this.viewMap.set("DEMOBHTMLVIEW_DEFAULT", 'app-default-mob-html-view'); 
        this.viewMap.set("DEMOBCALENDAREXPVIEW_DEFAULT", 'app-default-mob-calendarexpview');
        // 注册视图插件
<#if app.getAllPSAppSubViewTypeRefs?? && app.getAllPSAppSubViewTypeRefs()??>
    <#list app.getAllPSAppSubViewTypeRefs() as subViewTypeRef> 
        <#if subViewTypeRef.getPSSysPFPlugin?? && subViewTypeRef.getPSSysPFPlugin()??>
          <#if !P.exists("view_style_plugin_register", subViewTypeRef.getPSSysPFPlugin().getPFPluginType(), subViewTypeRef.getPSSysPFPlugin().getPFPluginCode())>
        this.viewMap.set("${subViewTypeRef.getPSSysPFPlugin().getPFPluginCode()}", 'app-${srffilepath2(subViewTypeRef.getPSSysPFPlugin().getPFPluginType())}-${srffilepath2(subViewTypeRef.getPSSysPFPlugin().getPFPluginTag())}');
          </#if>
        </#if>
    </#list>
</#if>
        // 注册视图样式，无插件模式
<#if app.getAllRefPSAppViews?? && app.getAllRefPSAppViews()??>
    <#list app.getAllRefPSAppViews() as refView>
        <#if refView.getViewStyle?? && refView.getViewStyle()?? && refView.getViewStyle() != "" && refView.getViewStyle() != "DEFAULT" && refView.getViewStyle() != "STYLE" && refView.getViewStyle() != "STYLE2" && refView.getViewStyle() != "STYLE3" && refView.getViewStyle() != "STYLE4" && refView.getViewStyle() != "EXTEND">
          <#if !P.exists("view_style_noplugin_register", refView.getViewType(), refView.getViewStyle())>
        this.viewMap.set("${refView.getViewType()}_${refView.getViewStyle()}", 'app-${srffilepath2(refView.getViewStyle())}');
          </#if>
        </#if>
    </#list>
</#if>
    }

    /**
     * 获取视图组件
     * 
     * @memberof AppComponentService
     */
    public static getViewComponents(viewType: string, viewStyle: string, pluginCode?: string) {
        let componentName = 'app-default-notsupportedview';
        if(pluginCode){
            <#noparse>componentName = this.viewMap.get(`${pluginCode}`);</#noparse>
        }else{
            <#noparse>componentName = this.viewMap.get(`${viewType}_${viewStyle}`);</#noparse>
        }
        return componentName || 'app-default-notsupportedview';
    }

    /**
     * 注册部件组件

     * 
     * @memberof AppComponentService
     */
    protected static registerControlComponents() {
        this.controlMap.set("APPMENU_DEFAULT", 'app-default-mob-appmenu');
        this.controlMap.set("APPMENU_LISTVIEW", 'app-default-mob-appmenu');
        this.controlMap.set("MOBMDCTRL_LISTVIEW", 'app-default-mob-mdctrl');
        this.controlMap.set("MOBMDCTRL_DEFAULT", 'app-default-mob-mdctrl');
        this.controlMap.set("FORM_DEFAULT", 'app-default-mob-form');
        this.controlMap.set("APPMENU_ICONVIEW", 'app-default-mob-appmenu');
        this.controlMap.set("DASHBOARD_DEFAULT", 'app-default-mob-dashboard');
        this.controlMap.set("PORTLET_DEFAULT", 'app-default-mob-portlet');
        this.controlMap.set("CHART_DEFAULT", 'app-default-mob-chart');
        this.controlMap.set("CHART_NEW", 'app-default-mob-chart');
        this.controlMap.set("CALENDAR_DEFAULT", 'app-default-mob-calendar');
        this.controlMap.set("CALENDAR_TIMELINE", 'app-default-mob-calendar');
        this.controlMap.set("TABEXPPANEL_DEFAULT", 'app-default-mob-tabexppanel');
        this.controlMap.set("TABVIEWPANEL_DEFAULT", 'app-default-mob-tabviewpanel');
        this.controlMap.set("LIST_DEFAULT", 'app-default-mob-mdctrl');
        this.controlMap.set("LISTEXPBAR_DEFAULT", 'app-default-mob-listexpbar');
        this.controlMap.set("TREEVIEW_DEFAULT", 'app-default-mob-tree');
        this.controlMap.set("MULTIEDITVIEWPANEL_DEFAULT", 'app-default-mob-meditviewpanel');
        this.controlMap.set("CONTEXTMENU_DEFAULT", 'app-default-mob-contextmenu');
        this.controlMap.set("PICKUPVIEWPANEL_DEFAULT", 'app-default-mob-pickupviewpanel');
        this.controlMap.set("SEARCHFORM_DEFAULT", 'app-default-mob-searchform');
        this.controlMap.set("PANEL_DEFAULT", 'app-default-mob-panel');
        this.controlMap.set("DRTAB_DEFAULT", 'app-default-mob-drtab');
        this.controlMap.set("WIZARDPANEL_DEFAULT", 'app-default-mob-wizard-panel');
        this.controlMap.set("SEARCHBAR_DEFAULT", 'app-default-mob-searchbar');
        this.controlMap.set("CALENDAREXPBAR_DEFAULT", 'app-default-mob-calendarexpbar');    
        // 临时
        this.controlMap.set("PFPlugin", 'app-default-mob-mdctrl');
        // 注册部件插件标识
<#if app.getAllPSAppPFPluginRefs?? && app.getAllPSAppPFPluginRefs()??>
<#list app.getAllPSAppPFPluginRefs() as appPFPluginRef>
<#if appPFPluginRef.getRefMode() == "CONTROL">
        this.controlMap.set("${appPFPluginRef.getPSSysPFPlugin().getPFPluginCode()}", 'app-${srffilepath2(appPFPluginRef.getPSSysPFPlugin().getPFPluginType())}-${srffilepath2(appPFPluginRef.getPSSysPFPlugin().getPFPluginTag())}');
</#if>
</#list>
</#if>
        this.controlMap.set("NEW", 'app-default-mob-chart');
    }

    /**
     * 获取部件组件
     * 
     * @memberof AppComponentService
     */
    public static getControlComponents(ctrlType: string, ctrlStyle: string, pluginCode?: string) {
        let componentName = 'app-default-notsupportedcontrol';
        if(pluginCode){
            <#noparse>componentName = this.controlMap.get(`${pluginCode}`);</#noparse>
        }else{
            <#noparse>componentName = this.controlMap.get(`${ctrlType}_${ctrlStyle}`);</#noparse>
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
<#if app.getAllPSAppEditorStyleRefs?? && app.getAllPSAppEditorStyleRefs()??>
  <#list app.getAllPSAppEditorStyleRefs() as editorStyleRef>
    <#if editorStyleRef.getPSSysPFPlugin?? && editorStyleRef.getPSSysPFPlugin()??>
        this.editorMap.set("${editorStyleRef.getPSSysEditorStyle().getPSEditorType().getStandardPSEditorType()}_${editorStyleRef.getPSSysEditorStyle().getCodeName()}", "app-${srffilepath2(editorStyleRef.getPSSysEditorStyle().getPSEditorType().getStandardPSEditorType())}-${srffilepath2(editorStyleRef.getPSSysEditorStyle().getCodeName())}");
    </#if>
  </#list>
</#if>
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
        <#noparse>let componentName = editorStyle ? this.editorMap.get(`${editorType}_${editorStyle}`) : this.editorMap.get(`${editorType}_DEFAULT`);</#noparse>
        return componentName || 'app-not-supported-editor';
    }

}