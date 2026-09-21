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
        this.viewMap.set("APPINDEXVIEW_DEFAULT", 'app-default-indexview');
        this.viewMap.set("DEEDITVIEW_DEFAULT", 'app-default-editview');
        this.viewMap.set("DEGRIDVIEW_DEFAULT", 'app-default-gridview');
        this.viewMap.set("DEGRIDVIEW4_DEFAULT", 'app-default-gridview4');
        this.viewMap.set("DELISTVIEW_DEFAULT", 'app-default-listview');
        this.viewMap.set("DECHARTVIEW_DEFAULT", 'app-default-chartview');
        this.viewMap.set("DECHARTEXPVIEW_DEFAULT", 'app-default-chartexpview');
        this.viewMap.set("DEDATAVIEW_DEFAULT", 'app-default-dataviewview');
        this.viewMap.set("DECALENDARVIEW_DEFAULT", 'app-default-calendarview');
        this.viewMap.set("DEKANBANVIEW_DEFAULT", 'app-default-kanbanview');
        this.viewMap.set("DEPORTALVIEW_DEFAULT", 'app-default-deportalview');
        this.viewMap.set("DETABEXPVIEW_DEFAULT", 'app-default-tabexpview');
        this.viewMap.set("DETABSEARCHVIEW_DEFAULT", 'app-default-tabsearchview');
        this.viewMap.set("DEMEDITVIEW9_DEFAULT", 'app-default-meditview');
        this.viewMap.set("DEGANTTVIEW_DEFAULT", 'app-default-ganttview');
        this.viewMap.set("DETREEVIEW_DEFAULT", 'app-default-treeview');
        this.viewMap.set("DETREEGRIDEXVIEW_DEFAULT", 'app-default-treegridexview');
        this.viewMap.set("DELISTEXPVIEW_DEFAULT", 'app-default-listexpview');
        this.viewMap.set("DEGRIDEXPVIEW_DEFAULT", 'app-default-gridexpview');
        this.viewMap.set("DEWFDYNAEXPGRIDVIEW_DEFAULT", 'app-default-wfdynaexpgridview');
        this.viewMap.set("DEDATAVIEWEXPVIEW_DEFAULT", 'app-default-dataviewexpview');
        this.viewMap.set("DEPICKUPGRIDVIEW_DEFAULT", 'app-default-pickupgridview');
        this.viewMap.set("DEMPICKUPVIEW_DEFAULT", 'app-default-mpickupview');
        this.viewMap.set("DEMPICKUPVIEW2_DEFAULT", 'app-default-mpickupview2');
        this.viewMap.set("DEPICKUPVIEW_DEFAULT", 'app-default-pickupview');
        this.viewMap.set("DEPICKUPVIEW2_DEFAULT", 'app-default-pickupview2');
        this.viewMap.set("DEPICKUPVIEW3_DEFAULT", 'app-default-pickupview3');
        this.viewMap.set("DECALENDAREXPVIEW_DEFAULT", 'app-default-calendarexpview');
        this.viewMap.set("DETREEEXPVIEW_DEFAULT", 'app-default-treeexpview');
        this.viewMap.set("DEPICKUPTREEVIEW_DEFAULT", 'app-default-pickuptreeview');
        this.viewMap.set("DECUSTOMVIEW_DEFAULT", 'app-default-customview');
        this.viewMap.set("DEOPTVIEW_DEFAULT", 'app-default-optview');
        this.viewMap.set("APPPORTALVIEW_DEFAULT", 'app-default-portalview');
        this.viewMap.set("DEWFDYNAACTIONVIEW_DEFAULT", 'app-default-wfdynaactionview');
        this.viewMap.set("DEWFDYNASTARTVIEW_DEFAULT", 'app-default-wfdynastartview');
        this.viewMap.set("DEWFDYNAEDITVIEW_DEFAULT", 'app-default-wfdynaeditview');
        this.viewMap.set("DEWFDYNAEDITVIEW3_DEFAULT", 'app-default-wfdynaeditview3');
        this.viewMap.set("DEPORTALVIEW9_DEFAULT", 'app-default-deportalview');
        this.viewMap.set("DEEDITVIEW9_DEFAULT", 'app-default-editview');
        this.viewMap.set("DEGRIDVIEW9_DEFAULT", 'app-default-gridview');
        this.viewMap.set("DELISTVIEW9_DEFAULT", 'app-default-listview');
        this.viewMap.set("DECHARTVIEW9_DEFAULT", 'app-default-chartview');
        this.viewMap.set("DEDATAVIEW9_DEFAULT",'app-default-dataviewview');
        this.viewMap.set("DEFORMPICKUPDATAVIEW_DEFAULT","app-default-formpickupdataview");
        this.viewMap.set("DEINDEXPICKUPDATAVIEW_DEFAULT","app-default-indexpickupdataview");
        this.viewMap.set("DEWIZARDVIEW_DEFAULT", 'app-default-wizardview');
        this.viewMap.set("DEWFACTIONVIEW_DEFAULT", 'app-default-wfactionview');
        this.viewMap.set("DEREDIRECTVIEW_DEFAULT", 'app-default-deredirectview');
        this.viewMap.set("APPWFSTEPTRACEVIEW_DEFAULT", 'app-default-wfsteptraceview');
        this.viewMap.set("DEEDITVIEW2_DEFAULT", 'app-default-editview2');
        this.viewMap.set("DEEDITVIEW3_DEFAULT", 'app-default-editview3');
        this.viewMap.set("DEEDITVIEW4_DEFAULT", 'app-default-editview4');
        this.viewMap.set("DEHTMLVIEW_DEFAULT", 'app-default-htmlview');
        this.viewMap.set("DEMAPVIEW_DEFAULT", 'app-default-mapview');
        this.viewMap.set("DEREPORTVIEW_DEFAULT",'app-default-dereportview');
        this.viewMap.set("DEMAPEXPVIEW_DEFAULT",'app-default-mapexpview');
        this.viewMap.set("DEPANELVIEW_DEFAULT", 'app-default-depanelview');
        this.viewMap.set("DEINDEXVIEW_DEFAULT", 'app-default-deindexview');
        // STYLE2 样式
        this.viewMap.set("APPINDEXVIEW_STYLE2", 'app-style2-indexview');
        this.viewMap.set("DEEDITVIEW_STYLE2", 'app-style2-editview');
        this.viewMap.set("DEEDITVIEW2_STYLE2", 'app-style2-editview2');
        this.viewMap.set("DEEDITVIEW3_STYLE2", 'app-style2-editview3');
        this.viewMap.set("DEEDITVIEW4_STYLE2", 'app-style2-editview4');
        this.viewMap.set("DEGRIDVIEW_STYLE2", 'app-style2-gridview');
        this.viewMap.set("DELISTVIEW_STYLE2", 'app-style2-listview');
        this.viewMap.set("DECHARTVIEW_STYLE2", 'app-style2-chartview');
        this.viewMap.set("DECHARTEXPVIEW_STYLE2", 'app-style2-chartexpview');
        this.viewMap.set("DEDATAVIEW_STYLE2", 'app-style2-dataviewview');
        this.viewMap.set("DECALENDARVIEW_STYLE2", 'app-style2-calendarview');
        this.viewMap.set("DEKANBANVIEW_STYLE2", 'app-style2-kanbanview');
        this.viewMap.set("DEPORTALVIEW_STYLE2", 'app-style2-deportalview');
        this.viewMap.set("DETABEXPVIEW_STYLE2", 'app-style2-tabexpview');
        this.viewMap.set("DETABSEARCHVIEW_STYLE2", 'app-style2-tabsearchview');
        this.viewMap.set("DEMEDITVIEW9_STYLE2", 'app-style2-meditview');
        this.viewMap.set("DEGANTTVIEW_STYLE2", 'app-style2-ganttview');
        this.viewMap.set("DETREEVIEW_STYLE2", 'app-style2-treeview');
        this.viewMap.set("DETREEGRIDEXVIEW_STYLE2", 'app-style2-treegridexview');
        this.viewMap.set("DELISTEXPVIEW_STYLE2", 'app-style2-listexpview');
        this.viewMap.set("DEGRIDEXPVIEW_STYLE2", 'app-style2-gridexpview');
        this.viewMap.set("DEWFDYNAEXPGRIDVIEW_STYLE2", 'app-style2-wfdynaexpgridview');
        this.viewMap.set("DEDATAVIEWEXPVIEW_STYLE2", 'app-style2-dataviewexpview');
        this.viewMap.set("DEPICKUPGRIDVIEW_STYLE2", 'app-style2-pickupgridview');
        this.viewMap.set("DEMPICKUPVIEW_STYLE2", 'app-style2-mpickupview');
        this.viewMap.set("DEPICKUPVIEW_STYLE2", 'app-style2-pickupview');
        this.viewMap.set("DECALENDAREXPVIEW_STYLE2", 'app-style2-calendarexpview');
        this.viewMap.set("DETREEEXPVIEW_STYLE2", 'app-style2-treeexpview');
        this.viewMap.set("DEPICKUPTREEVIEW_STYLE2", 'app-style2-pickuptreeview');
        this.viewMap.set("DECUSTOMVIEW_STYLE2", 'app-style2-customview');
        this.viewMap.set("DEOPTVIEW_STYLE2", 'app-style2-optview');
        this.viewMap.set("DEOPTVIEW_STYLE2", 'app-style2-optview');
        this.viewMap.set("APPPORTALVIEW_STYLE2", 'app-style2-portalview');
        this.viewMap.set("DEWFDYNAACTIONVIEW_STYLE2", 'app-style2-wfdynaactionview');
        this.viewMap.set("DEWFDYNASTARTVIEW_STYLE2", 'app-style2-wfdynastartview');
        this.viewMap.set("DEWFDYNAEDITVIEW_STYLE2", 'app-style2-wfdynaeditview');
        this.viewMap.set("DEWFDYNAEDITVIEW3_STYLE2", 'app-style2-wfdynaeditview3');
        this.viewMap.set("DEPORTALVIEW9_STYLE2", 'app-style2-deportalview');
        this.viewMap.set("DEEDITVIEW9_STYLE2", 'app-style2-editview');
        this.viewMap.set("DEGRIDVIEW9_STYLE2", 'app-style2-gridview');
        this.viewMap.set("DELISTVIEW9_STYLE2", 'app-style2-listview');
        this.viewMap.set("DEHTMLVIEW_STYLE2", 'app-style2-htmlview');
        this.viewMap.set("DECHARTVIEW9_STYLE2", 'app-style2-chartview');
        this.viewMap.set("DEDATAVIEW9_STYLE2",'app-style2-dataviewview');
        this.viewMap.set("DEFORMPICKUPDATAVIEW_STYLE2","app-style2-formpickupdataview");
        this.viewMap.set("DEINDEXPICKUPDATAVIEW_STYLE2","app-style2-indexpickupdataview");
        this.viewMap.set("DEWIZARDVIEW_STYLE2", 'app-style2-wizardview');
        this.viewMap.set("DEWFACTIONVIEW_STYLE2", 'app-style2-wfactionview');
        this.viewMap.set("DEREDIRECTVIEW_STYLE2", 'app-style2-deredirectview');
        this.viewMap.set("APPWFSTEPTRACEVIEW_STYLE2", 'app-style2-wfsteptraceview');
        this.viewMap.set("DEREPORTVIEW_STYLE2",'app-style2-dereportview');
        this.viewMap.set("DEMAPEXPVIEW_STYLE2",'app-style2-mapexpview');
        this.viewMap.set("DEPANELVIEW_STYLE2",'app-style2-depanelview');
        this.viewMap.set("DEMAPVIEW_STYLE2", 'app-style2-mapview');
        // STYLE3 样式
        this.viewMap.set("APPINDEXVIEW_STYLE3", 'app-style2-indexview');
        // STYLE4 样式
        this.viewMap.set("APPINDEXVIEW_STYLE4", 'app-default-indexview');
        this.viewMap.set("APPPORTALVIEW_STYLE4", 'app-style4-portalview');
        this.viewMap.set("DEPORTALVIEW_STYLE4", 'app-style4-deportalview');
        // 注册视图插件
<#if app.getAllPSAppSubViewTypeRefs?? && app.getAllPSAppSubViewTypeRefs()??>
    <#list app.getAllPSAppSubViewTypeRefs() as subViewTypeRef> 
        <#if subViewTypeRef.getPSSysPFPlugin?? && subViewTypeRef.getPSSysPFPlugin()?? && (subViewTypeRef.getPSSysPFPlugin().isRuntimeObject() == false)>
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
        this.controlMap.set("FORM_DEFAULT", 'app-default-form');
        this.controlMap.set("SEARCHFORM_DEFAULT", 'app-default-searchform');
        this.controlMap.set("GRID_DEFAULT", 'app-default-grid');
        this.controlMap.set("LIST_DEFAULT", 'app-default-list');
        this.controlMap.set("LIST_LISTVIEW", 'app-default-list');
        this.controlMap.set("APPMENU_DEFAULT", 'app-default-appmenu');
        this.controlMap.set("CHART_DEFAULT", 'app-default-chart');
        this.controlMap.set("CHART_NEW", 'app-default-chart');
        this.controlMap.set("CHARTEXPBAR_DEFAULT", 'app-default-chart-exp-bar');
        this.controlMap.set("DATAVIEW_DEFAULT", 'app-default-dataview');
        this.controlMap.set("PANEL_DEFAULT", 'app-default-panel');
        this.controlMap.set("CALENDAR_DEFAULT", 'app-default-calendar');
        this.controlMap.set("KANBAN_DEFAULT", 'app-default-kanban');
        this.controlMap.set("DASHBOARD_DEFAULT", 'app-default-dashboard');
        this.controlMap.set("PORTLET_DEFAULT", 'app-default-portlet');
        this.controlMap.set("TABEXPPANEL_DEFAULT", 'app-default-tabexp-panel');
        this.controlMap.set("CONTEXTMENU_DEFAULT", 'app-default-contextmenu');
        this.controlMap.set("GANTT_DEFAULT", 'app-default-gantt');
        this.controlMap.set("MULTIEDITVIEWPANEL_DEFAULT", 'app-default-meditViewPanel');
        this.controlMap.set("TREEVIEW_DEFAULT", 'app-default-tree');
        this.controlMap.set("TREEGRIDEX_DEFAULT", 'app-default-tree-grid-ex');
        this.controlMap.set("LISTEXPBAR_DEFAULT", 'app-default-list-exp-bar');
        this.controlMap.set("GRIDEXPBAR_DEFAULT", 'app-default-grid-exp-bar');
        this.controlMap.set("DATAVIEWEXPBAR_DEFAULT", 'app-default-dataview-exp-bar');
        this.controlMap.set("PICKUPVIEWPANEL_DEFAULT", 'app-default-pick-up-view-panel');
        this.controlMap.set("CALENDAREXPBAR_DEFAULT", 'app-default-calendar-exp-bar');
        this.controlMap.set("TREEEXPBAR_DEFAULT", 'app-default-tree-exp-bar');
        this.controlMap.set("SEARCHBAR_DEFAULT", 'app-default-searchbar');
        this.controlMap.set("TABVIEWPANEL_DEFAULT", 'app-default-tab-view-panel');
        this.controlMap.set("WIZARDPANEL_DEFAULT", 'app-default-wizard-panel');
        this.controlMap.set("WIZARDPANEL_STATE", 'app-default-state-wizard-panel');
        this.controlMap.set("DRTAB_DEFAULT", 'app-default-drtab');
        this.controlMap.set("DRBAR_DEFAULT", 'app-default-drbar');
        this.controlMap.set("MAP_DEFAULT", 'app-default-map');
        this.controlMap.set("REPORTPANEL_DEFAULT", 'app-default-report-panel');
        this.controlMap.set("MAPEXPBAR_DEFAULT", 'app-default-map-exp-bar');
        this.controlMap.set("DASHBOARD_STYLE4", 'app-default-dashboard');
        this.controlMap.set("VIEWPANEL_DEFAULT", 'app-default-view-panel');
        // 注册部件插件标识
<#if app.getAllPSAppPFPluginRefs?? && app.getAllPSAppPFPluginRefs()??>
  <#list app.getAllPSAppPFPluginRefs() as appPFPluginRef>
    <#if (appPFPluginRef.getRefMode() == "CONTROL") && appPFPluginRef.getPSSysPFPlugin()?? && (appPFPluginRef.getPSSysPFPlugin().isRuntimeObject() == false)>
      <#if !P.exists("plugin_control_register", appPFPluginRef.getPSSysPFPlugin().getPFPluginType(), appPFPluginRef.getPSSysPFPlugin().getPFPluginTag())>
        this.controlMap.set("${appPFPluginRef.getPSSysPFPlugin().getPFPluginType()}_${appPFPluginRef.getPSSysPFPlugin().getPFPluginCode()}", 'app-${srffilepath2(appPFPluginRef.getPSSysPFPlugin().getPFPluginType())}-${srffilepath2(appPFPluginRef.getPSSysPFPlugin().getPFPluginTag())}');
      </#if>
    </#if>
  </#list>
</#if>
        this.controlMap.set("PivotTable", 'app-pivot-table');
        this.controlMap.set("GRID_RENDER_PivotTable", 'app-pivot-table');
        this.controlMap.set("GRID_RENDER_CellEditGrid", 'app-cell-edit-grid');
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
        this.editorMap.set("TEXTBOX_DEFAULT", 'input-box');
        this.editorMap.set("PASSWORD_DEFAULT", 'input-box');
        this.editorMap.set("TEXTAREA_DEFAULT", 'input-box');
        this.editorMap.set("TEXTAREA_10_DEFAULT", 'input-box');
        this.editorMap.set("MARKDOWN_DEFAULT", 'app-markdown-editor');
        this.editorMap.set("CODE_DEFAULT", 'app-code-editor');
        this.editorMap.set("NUMBER_DEFAULT", 'input-box');
        this.editorMap.set("SLIDER_DEFAULT", 'app-slider');
        this.editorMap.set("RATING_DEFAULT", 'app-rate');
        this.editorMap.set("STEPPER_DEFAULT", 'app-stepper');
        this.editorMap.set("SWITCH_DEFAULT", 'app-switch');
        this.editorMap.set("SPANEX_DEFAULT", 'i-input');
        this.editorMap.set("SPAN_DEFAULT", 'app-span');
        this.editorMap.set("AC_DEFAULT", 'app-autocomplete');
        this.editorMap.set("HTMLEDITOR_DEFAULT", 'app-rich-text-editor');
        this.editorMap.set("FILEUPLOADER_DEFAULT", 'app-file-upload');
        this.editorMap.set("FILEUPLOADER_ONE_DEFAULT", "app-file-upload");
        this.editorMap.set("PICTURE_DEFAULT", 'app-image-upload');
        this.editorMap.set("PICTURE_ONE_DEFAULT", 'app-image-upload');
        this.editorMap.set("RADIOBUTTONLIST_DEFAULT", 'app-radio-group');
        this.editorMap.set("CHECKBOX_DEFAULT", 'app-checkbox');
        this.editorMap.set("CHECKBOXLIST_DEFAULT", 'app-checkbox-list');
        this.editorMap.set("MDROPDOWNLIST_DEFAULT", 'dropdown-list-mpicker');
        this.editorMap.set("DROPDOWNLIST_DEFAULT", 'dropdown-list');
        this.editorMap.set("DROPDOWNLIST_100_DEFAULT", 'dropdown-list');
        this.editorMap.set("DATEPICKEREX_DEFAULT", 'date-picker');
        this.editorMap.set("DATEPICKEREX_NOTIME_DEFAULT", 'date-picker');
        this.editorMap.set("DATEPICKER_DEFAULT", 'date-picker');
        this.editorMap.set("DATEPICKEREX_HOUR_DEFAULT", 'time-picker');
        this.editorMap.set("DATEPICKEREX_MINUTE_DEFAULT", 'time-picker');
        this.editorMap.set("DATEPICKEREX_SECOND_DEFAULT", 'time-picker');
        this.editorMap.set("DATEPICKEREX_NODAY_DEFAULT", 'time-picker');
        this.editorMap.set("DATEPICKEREX_NODAY_NOSECOND_DEFAULT", 'time-picker');
        this.editorMap.set("PICKEREX_DROPDOWNVIEW_DEFAULT", 'app-picker-select-view');
        this.editorMap.set("PICKEREX_DROPDOWNVIEW_LINK_DEFAULT", 'app-picker-select-view');
        this.editorMap.set("PICKUPVIEW_DEFAULT", 'app-embed-picker');
        this.editorMap.set("ADDRESSPICKUP_DEFAULT", 'app-mpicker');
        this.editorMap.set("ADDRESSPICKUP_IMPORTABILITY", 'app-mpicker-importability');
        this.editorMap.set("ADDRESSPICKUP_AC_DEFAULT", 'app-mpicker');
        this.editorMap.set("PICKEREX_LINKONLY_DEFAULT", 'app-picker');
        this.editorMap.set("PICKER_DEFAULT", 'app-picker');
        this.editorMap.set("PICKER_IMPORTABILITY", 'app-picker-importability');
        this.editorMap.set("PICKER_TAGPICKER", 'app-tag-picker');
        this.editorMap.set("PICKER_ALLEMPSELECT", 'app-picker');
        this.editorMap.set("PICKEREX_NOBUTTON_DEFAULT", 'app-picker');
        this.editorMap.set("PICKEREX_NOAC_LINK_DEFAULT", 'app-picker');
        this.editorMap.set("PICKEREX_TRIGGER_LINK_DEFAULT", 'app-picker');
        this.editorMap.set("PICKEREX_TRIGGER_DEFAULT", 'app-picker');
        this.editorMap.set("PICKEREX_NOAC_DEFAULT", 'app-picker');
        this.editorMap.set("PICKEREX_LINK_DEFAULT", 'app-picker');
        this.editorMap.set("IPADDRESSTEXTBOX_DEFAULT", "app-input-ip");
        this.editorMap.set("RAW_DEFAULT", "app-rawitem");
        this.editorMap.set("AC_FS_DEFAULT", 'app-autocomplete');
        this.editorMap.set("AC_NOBUTTON_DEFAULT", 'app-autocomplete');
        this.editorMap.set("AC_FS_NOBUTTON_DEFAULT", 'app-autocomplete');
        this.editorMap.set("LISTBOX_DEFAULT", 'app-list-box');
        this.editorMap.set("LISTBOXPICKUP_DEFAULT", 'app-list-box');
        this.editorMap.set("PICTURE_ONE_RAW_DEFAULT", 'app-image-select');
        this.editorMap.set('MAPPICKER_DEFAULT','app-map-picker');
        this.editorMap.set('ARRAY_DEFAULT','app-array-box');
        this.editorMap.set('DATERANGE_DEFAULT','app-date-range-picker');
        this.editorMap.set('DATERANGE_NOTIME_DEFAULT','app-date-range-picker');
        this.editorMap.set('NUMBERRANGE_DEFAULT','app-number-range-picker');
        this.editorMap.set('CASCADER_DEFAULT','app-cascader');
        this.editorMap.set('COLORPICKER_DEFAULT','app-color-picker');
        //兼容移动端编辑器
        this.editorMap.set('MOBTEXT_DEFAULT','input-box');
        this.editorMap.set('MOBPASSWORD_DEFAULT','input-box');
        this.editorMap.set('MOBNUMBER_DEFAULT','input-box');
        this.editorMap.set('MOBSTEPPER_DEFAULT','app-stepper');
        this.editorMap.set('MOBTEXTAREA_DEFAULT','input-box');
        this.editorMap.set('MOBSLIDER_DEFAULT','app-slider');
        this.editorMap.set('MOBSWITCH_DEFAULT','app-switch');
        this.editorMap.set('MOBRATING_DEFAULT','app-rate');
        this.editorMap.set('MOBDATE_DEFAULT','date-picker');
        this.editorMap.set('MOBHTMLTEXT_DEFAULT','app-rich-text-editor');
        this.editorMap.set('MOBDROPDOWNLIST_DEFAULT','dropdown-list');
        this.editorMap.set('MOBCHECKLIST_DEFAULT','app-checkbox-list');
        this.editorMap.set('MOBPICKER_DEFAULT','app-picker');
        this.editorMap.set('MOBMPICKER_DEFAULT','app-mpicker');
        this.editorMap.set('MOBPICKER_DROPDOWNVIEW_DEFAULT','dropdown-list');
        this.editorMap.set('MOBSINGLEFILEUPLOAD_DEFAULT','app-file-upload');
        this.editorMap.set('MOBMULTIFILEUPLOAD_DEFAULT','app-file-upload');
        this.editorMap.set('SPAN_DEFAULT','app-span');
        // 预置扩展编辑器
        this.editorMap.set("TEXTBOX_JSONSCHEMA", "app-json-schema");
        this.editorMap.set("MDROPDOWNLIST_CRONEDITOR", "cron-editor");
        this.editorMap.set("DROPDOWNLIST_HIDDEN", "dropdown-list-hidden");
        this.editorMap.set("MDROPDOWNLIST_TRANSFER", "app-transfer");
        this.editorMap.set("PICKER_MAPPOSITION", "app-map-position");
        this.editorMap.set("FILEUPLOADER_DISK", "disk-file-upload");
        this.editorMap.set("PICTURE_ROMATE", "app-image-romate");
        this.editorMap.set("PICTURE_DISKPIC", "disk-image-upload");
        this.editorMap.set("FILEUPLOADER_DRAG", "app-file-upload");
        this.editorMap.set("PICTURE_INFO", "app-image-preview");
        this.editorMap.set("FILEUPLOADER_INFO", "app-upload-file-info");
        this.editorMap.set("TEXTBOX_COLORPICKER", "app-color-picker");
        this.editorMap.set("TEXTBOX_ICONPICKER", "app-icon-picker");
        this.editorMap.set("HTMLEDITOR_INFO", "html-container");
        this.editorMap.set("TEXTAREA_WFAPPROVAL", "app-wf-approval");
        this.editorMap.set("TEXTAREA_WFAPPROVALTIMELINE", "action-timeline");
        this.editorMap.set("TEXTAREA_WFAPPROVALEXTENDTIMELINE", "extend-action-timeline");
        this.editorMap.set("TEXTAREA_10_WFOPINION", 'app-wf-opinion');
        this.editorMap.set("SPAN_AFTERTIME", "app-after-time");
        this.editorMap.set("SPAN_ADDRESSPICKUP", "app-span");
        this.editorMap.set("SPAN_COLORSPAN", "app-color-span");
        this.editorMap.set("PICKER_ORGSELECT", "app-org-select");
        this.editorMap.set("PICKER_ORGMULTIPLE", "app-org-select");
        this.editorMap.set("PICKER_ALLORGSELECT", "app-org-select");
        this.editorMap.set("PICKER_ALLORGMULTIPLE", "app-org-select");
        this.editorMap.set("PICKER_ALLDEPTPERSONSELECT", "app-department-personnel");
        this.editorMap.set("PICKER_ALLDEPTPERSONMULTIPLE", "app-department-personnel");
        this.editorMap.set("PICKER_DEPTPERSONSELECT", "app-department-personnel");
        this.editorMap.set("PICKER_DEPTPERSONMULTIPLE", "app-department-personnel");
        this.editorMap.set("PICKER_ALLEMPSELECT", "app-group-select");
        this.editorMap.set("PICKER_ALLEMPMULTIPLE", "app-group-select");
        this.editorMap.set("PICKER_EMPSELECT", "app-group-select");
        this.editorMap.set("PICKER_EMPMULTIPLE", "app-group-select");
        this.editorMap.set("PICKER_ALLDEPATMENTSELECT", "app-department-select");
        this.editorMap.set("PICKER_ALLDEPATMENTMULTIPLE", "app-department-select");
        this.editorMap.set("PICKER_DEPATMENTSELECT", "app-department-select");
        this.editorMap.set("PICKER_DEPATMENTMULTIPLE", "app-department-select");
        this.editorMap.set("FILEUPLOADER_CAMERA", "app-file-upload-camera");
        this.editorMap.set("FILEUPLOADER_USEWORKTEMP", "text-file-upload");
        this.editorMap.set("PICKER_COMMONMICROCOM", "app-common-microcom");
        this.editorMap.set("SLIDER_PROGRESS", 'app-progress');
       // 注册编辑器
<#if app.getAllPSAppEditorStyleRefs?? && app.getAllPSAppEditorStyleRefs()??>
<#list app.getAllPSAppEditorStyleRefs() as editorStyleRef>
    <#if editorStyleRef.getPSSysPFPlugin?? && editorStyleRef.getPSSysPFPlugin()?? && (editorStyleRef.getPSSysPFPlugin().isRuntimeObject() == false)>
      <#if !P.exists("editor_style_plugin_register", editorStyleRef.getPSSysEditorStyle().getEditorType(), editorStyleRef.getPSSysEditorStyle().getCodeName())>
        this.editorMap.set("${editorStyleRef.getPSSysEditorStyle().getEditorType()}_${editorStyleRef.getPSSysEditorStyle().getCodeName()}", "app-${srffilepath2(editorStyleRef.getPSSysEditorStyle().getEditorType())}-${srffilepath2(editorStyleRef.getPSSysEditorStyle().getCodeName())}");
      </#if>
    </#if>
</#list>
</#if>
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