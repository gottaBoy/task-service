/**
 * 应用组件服务
 * 
 * @memberof AppLayoutService
 */
export class AppLayoutService {

    /**
     * 布局组件Map
     * 
     * @memberof AppLayoutService
     */
    protected static layoutMap: Map<string, any> = new Map();

    /**
     * 注册布局组件
     * 
     * @memberof AppLayoutService
     */
    public static registerLayoutComponent() {
        this.layoutMap.set("APPINDEXVIEW-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-indexview-layout/app-default-indexview-layout"); });
        this.layoutMap.set("DEMOBMDVIEW-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-mdview-layout/app-default-mob-mdview-layout"); });
        this.layoutMap.set("APPLOGIN-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-login-layout/app-default-mob-loginview-layout"); });
        this.layoutMap.set("DEMOBMDVIEW9-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-mdview-layout/app-default-mob-mdview-layout"); });
        this.layoutMap.set("DEMOBEDITVIEW-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-editview-layout/app-default-mob-editview-layout"); });
        this.layoutMap.set("DEMOBEDITVIEW3-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-editview3-layout/app-default-mob-editview3-layout"); });
        this.layoutMap.set("APPPORTALVIEW-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-portalview-layout/app-default-mob-portalview-layout"); });
        this.layoutMap.set("DEMOBCALENDARVIEW-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-calendarview-layout/app-default-mob-calendarview-layout"); });
        this.layoutMap.set("DEMOBCHARTVIEW-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-chartview-layout/app-default-mob-chartview-layout"); });
        this.layoutMap.set("DEMOBTABEXPVIEW-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-tabexpview-layout/app-default-mob-tabexpview-layout"); });
        this.layoutMap.set("DEMOBLISTEXPVIEW-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-listexpview-layout/app-default-mob-listexpview-layout"); });
        this.layoutMap.set("DEMOBTREEVIEW-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-treeview-layout/app-default-mob-treeview-layout"); });
        this.layoutMap.set("DEMOBMEDITVIEW9-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-meditview-layout/app-default-mob-meditview-layout"); });
        this.layoutMap.set("DEMOBEDITVIEW9-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-editview-layout/app-default-mob-editview-layout"); });
        this.layoutMap.set("DEMOBOPTVIEW-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-optview-layout/app-default-optview-layout"); });
        this.layoutMap.set("DEMOBPICKUPMDVIEW-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-pickupmdview-layout/app-default-mob-pickupmdview-layout"); });
        this.layoutMap.set("DEMOBPICKUPVIEW-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-pickupview-layout/app-default-mob-pickupview-layout"); });
        this.layoutMap.set("DEMOBMPICKUPVIEW-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-mpickupview-layout/app-default-mob-mpickupview-layout"); });
        this.layoutMap.set("DEMOBPORTALVIEW-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-deportalview-layout/app-default-mob-deportalview-layout"); });
        this.layoutMap.set("DEMOBPICKUPTREEVIEW-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-pickuptreeview-layout/app-default-mob-pickuptreeview-layout"); });
        this.layoutMap.set("DEMOBWFDYNAEDITVIEW-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-wfdynaeditview-layout/app-default-mob-wfdynaeditview-layout"); });
        this.layoutMap.set("DEMOBWFDYNAACTIONVIEW-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-wfdynaactionview-layout/app-default-mob-wfdynaactionview-layout"); });
        this.layoutMap.set("DEMOBWFDYNAEXPMDVIEW-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-wfdynaexpmdview-layout/app-default-mob-wfdynaexpmdview-layout"); });
        this.layoutMap.set("DEMOBWFDYNAEDITVIEW3-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-wfdynaeditview3-layout/app-default-mob-wfdynaeditview3-layout"); });
        this.layoutMap.set("DEMOBWFDYNASTARTVIEW-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-wfdynastartview-layout/app-default-mob-wfdynastartview-layout"); });
        this.layoutMap.set("DEMOBREDIRECTVIEW-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-deredirectview-layout/app-default-mob-deredirectview-layout"); });
        this.layoutMap.set("DEMOBCUSTOMVIEW-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-customview-layout/app-default-mob-customview-layout"); });
        this.layoutMap.set("APPWFSTEPTRACEVIEW-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-wfsteptraceview-layout/app-default-wfsteptraceview-layout"); });
        this.layoutMap.set("DEMOBPANELVIEW-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-depanelview-layout/app-default-mob-depanelview-layout"); });
        this.layoutMap.set("DEMOBWIZARDVIEW-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-wizard-view-layout/app-default-mob-wizard-view-layout"); });
        this.layoutMap.set("DEMOBHTMLVIEW-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-html-view-layout/app-default-mob-html-view-layout"); });
        this.layoutMap.set("DEMOBCALENDAREXPVIEW-DEFAULT", () => { return import("../../components/layout/app-default-layout/app-default-mob-calendarexpview-layout/app-default-mob-calendarexpview-layout"); });
    }

    /**
     * 获取布局组件
     * 
     * @memberof AppLayoutService
     */
    public static getLayoutComponent(key: string) {
        return this.layoutMap.get(key);
    }

}