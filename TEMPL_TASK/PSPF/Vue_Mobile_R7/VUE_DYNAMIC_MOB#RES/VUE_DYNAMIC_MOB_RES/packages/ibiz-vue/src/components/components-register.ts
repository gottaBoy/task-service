// 注册插件
import { IonPage } from '../components/common/ion-page/ion-page';
import appKeepAlive from '../components/common/app-keep-alive/app-keep-alive.vue';
import { AppEmbedView } from '../components/common/app-embed-view/app-embed-view';
import { AppNavPos } from '../components/common/app-nav-pos/app-nav-pos';
import { AppViewShell } from '../view-container/app-view-shell';
import { AppSimpleFlexContainer } from '../components/common/app-simpleflex-container/app-simpleflex-container';
// 部件组件

import { AppDefaultEditor } from './editor/app-default-editor';
import { ViewToolbar } from './control/view-toolbar/view-toolbar';
import { AppDefaultNotSupportedControl } from './control/app-default-notsupportedcontrol/app-default-notsupportedcontrol';
// 模型组件 
import { AppPSSysImage } from './common/model-components/app-ps-sys-image/app-ps-sys-image';
import { AppControlShell } from './control/app-control-shell/app-control-shell';
import AppNotSupportedEditor from './editor/app-not-supported-editor/app-not-supported-editor';

export const ComponentsRegister = {
    install(v: any, opt: any) {
        v.component('ion-page', IonPage);
        v.component('app-nav-pos', AppNavPos);
        v.component('app-keep-alive', appKeepAlive);
        v.component('app-embed-view', AppEmbedView);
        v.component('app-radio', () => import('../components/common/app-radio/app-radio.vue'));
        v.component('app-wf-step-trace', () => import('../components/common/app-wf-step-trace/app-wf-step-trace.vue'));
        v.component('app-multiple-select', () => import('../components/common/app-multiple-select/app-multiple-select.vue'));
        v.component('app-form-druipart', () => import('../components/common/app-form-druipart/app-form-druipart.vue'));
        v.component('app-scroll-container', () => import('../components/common/app-scroll-container/app-scroll-container.vue'));
        v.component('app-simpleflex-container', AppSimpleFlexContainer);
        v.component('app-form-item', () => import('../components/common/app-form-item/app-form-item.vue'));
        v.component('app-form-group', () => import('../components/common/app-form-group/app-form-group.vue'));
        v.component('app-panel-field', () => import('../components/common/app-panel-field/app-panel-field.vue'));
        //  加载遮罩组件
        v.component('app-loading-mask', () => import('../components/common/app-loading-mask/app-loading-mask.vue'));
        // 日历组件
        v.component('app-calendar', () => import('../components/common/app-calendar/app-calendar.vue'));
        // 搜索表单2
        v.component('app-form-item2', () => import('../components/common/app-form-item2/app-form-item2.vue'));
        // 搜索表单2编辑器
        v.component('app-search-editor', () => import('../components/common/app-search-editor/app-search-editor.vue'));
        // ICON
        v.component('app-mob-icon', () => import('../components/common/app-mob-icon/app-mob-icon.vue'));
        // 视图消息
        v.component('app-mob-alert', () => import('../components/common/app-mob-alert/app-mob-alert.vue'));

        // 编辑器 BEGIN
        // 评分器
        v.component('app-mob-rate', () => import('../components/common/app-mob-rate/app-mob-rate.vue'));
        // 下拉视图
        v.component('app-mob-select-drop-down', () => import('../components/common/app-mob-select-drop-down/app-mob-select-drop-down.vue'));
        // 多行文本
        v.component('app-mob-textarea', () => import('../components/common/app-mob-textarea/app-mob-textarea.vue'));
        // 图片选择
        v.component('app-mob-picture', () => import('../components/common/app-mob-picture/app-mob-picture.vue'));
        // 下拉列表 （多选）
        v.component('app-mob-check-list', () => import('../components/common/app-mob-check-list/app-mob-check-list.vue'));
        // 文件上传
        v.component('app-mob-file-upload', () => import('../components/common/app-mob-file-upload/app-mob-file-upload.vue'));
        // 开关
        v.component('app-mob-switch', () => import('../components/common/app-mob-switch/app-mob-switch.vue'));
        // 滑动输入条
        v.component('app-mob-slider', () => import('../components/common/app-mob-slider/app-mob-slider.vue'));
        //单选框
        v.component('app-mob-radio-list', () => import('../components/common/app-mob-radio-list/app-mob-radio-list.vue'));
        //下拉单选
        v.component('app-mob-dropdown-list', () => import('../components/common/app-mob-dropdown-list/app-mob-dropdown-list.vue'));
        //下拉单选
        v.component('app-mob-mpicker', () => import('../components/common/app-mob-mpicker/app-mob-mpicker.vue'));
        //span
        v.component('app-mob-span', () => import('../components/common/app-mob-span/app-mob-span.vue'));
        // 数据选择多选
        v.component('app-mob-picker', () => import('../components/common/app-mob-picker/app-mob-picker.vue'));
        // 下拉选择
        v.component('app-mob-select', () => import('../components/common/app-mob-select-vant/app-mob-select-vant.vue'));
        // 时间选择器
        v.component('app-mob-datetime-picker', () => import('../components/common/app-mob-datetime-picker/app-mob-datetime-picker.vue'));
        // 输入框
        v.component('app-mob-input', () => import('../components/common/app-mob-input/app-mob-input.vue'));
        // 步进器
        v.component('app-mob-stepper', () => import('../components/common/app-mob-stepper/app-mob-stepper.vue'));
        // 富文本（模态）
        v.component('app-rich-text', () => import('../components/common/app-rich-text/app-rich-text.vue'));
        // 富文本项
        v.component('app-mob-rich-text-editor', () => import('../components/common/app-mob-rich-text-editor/app-mob-rich-text-editor.vue'));
        // 编辑器 END

        // 菜单样式 BEGIN
        // 图标视图
        v.component('app-mob-menu-ionic-view', () => import('../components/common/app-mob-menu-ionic-view/app-mob-menu-ionic-view.vue'));
        // 列表视图
        v.component('app-mob-menu-list-view', () => import('../components/common/app-mob-menu-list-view/app-mob-menu-list-view.vue'));
        // 图片滑动视图
        v.component('app-mob-menu-swiper-view', () => import('../components/common/app-mob-menu-swiper-view/app-mob-menu-swiper-view.vue'));
        //快速分组组件
        v.component('app-van-select', () => import('../components/common/app-van-select/app-van-select.vue'));
        // 默认样式视图
        v.component('app-mob-menu-default-view', () => import('../components/common/app-mob-menu-default-view/app-mob-menu-default-view.vue'));
        // 菜单样式 END

        // 列表项插件
        v.component('app-list-index-text', () => import('../components/common/app-list-index-text/app-list-index-text.vue'));
        v.component('app-upload-file-info', () => import('../components/common/app-upload-file-info/app-upload-file-info.vue'));
        // 多数据快速分组组件
        v.component('app-quick-group', () => import('../components/common/app-quick-group/app-quick-group.vue'));
        // 搜索历史组件
        v.component('app-search-history', () => import('../components/common/app-search-history/app-search-history.vue'));
        // 主题切换组件
        v.component('app-mob-select-theme', () => import('../components/common/app-mob-select-theme/app-mob-select-theme.vue'));
        // 上下文菜单
        v.component('app-mob-context-menu', () => import('../components/common/app-mob-context-menu/app-mob-context-menu.vue'));
        // 单位选择器
        v.component('app-mob-org-select', () => import('../components/common/app-mob-org-select/app-mob-org-select.vue'));
        // 部门选择器
        v.component('app-mob-department-select', () => import('../components/common/app-mob-department-select/app-mob-department-select.vue'));
        // 人员部门选择器
        v.component('app-mob-department-personnel', () => import('../components/common/app-mob-department-personnel/app-mob-department-personnel.vue'));
        v.component('app-mob-group-picker', () => import('../components/common/app-mob-group-picker/app-mob-group-picker.vue'));
        v.component('app-mob-group-select', () => import('../components/common/app-mob-group-select/app-mob-group-select.vue'));
        // 树选择
        v.component('app-tree', () => import('../components/common/app-tree/app-tree.vue'));
        v.component('app-rawitem', () => import('../components/common/app-rawitem/app-rawitem.vue'));
        v.component('app-mob-button', () => import('../components/common/app-mob-button/app-mob-button.vue'));
        v.component('app-default-editor', AppDefaultEditor);
        v.component('app-mob-org-picker', () => import('../components/common/app-mob-org-picker/app-mob-org-picker.vue'));

        // ui组件 BEGIN
        // 按钮     
        // 视图组件
        v.component('app-view-shell', AppViewShell);
        // 部件组件
        v.component('app-control-shell', AppControlShell);
        v.component('view-toolbar', ViewToolbar);
        v.component('app-default-notsupportedcontrol', AppDefaultNotSupportedControl);
        v.component('app-not-supported-editor', AppNotSupportedEditor);
        // 模型组件
        v.component('app-ps-sys-image', AppPSSysImage);

        // 视图
        v.component("app-default-indexview", () => import('../components/view/app-default-indexview/app-default-indexview'));
        v.component("app-default-mob-mdview", () => import('../components/view/app-default-mob-mdview/app-default-mob-mdview'));
        v.component("app-default-mob-editview", () => import('../components/view/app-default-mob-editview/app-default-mob-editview'));
        v.component("app-default-mob-editview3", () => import('../components/view/app-default-mob-editview3/app-default-mob-editview3'));
        v.component("app-default-mob-portalview", () => import('../components/view/app-default-mob-portalview/app-default-mob-portalview'));
        v.component("app-default-mob-calendarview", () => import('../components/view/app-default-mob-calendarview/app-default-mob-calendarview'));
        v.component("app-default-mob-chartview", () => import('../components/view/app-default-mob-chartview/app-default-mob-chartview'));
        v.component("app-default-mob-tabexpview", () => import('../components/view/app-default-mob-tabexpview/app-default-mob-tabexpview'));
        v.component("app-default-mob-listexpview", () => import('../components/view/app-default-mob-listexpview/app-default-mob-listexpview'));
        v.component("app-default-mob-treeview", () => import('../components/view/app-default-mob-treeview/app-default-mob-treeview'));
        v.component("app-default-mob-optview", () => import('../components/view/app-default-mob-optview/app-default-mob-optview'));
        v.component("app-default-mob-pickmdview", () => import('../components/view/app-default-mob-pickmdview/app-default-mob-pickmdview'));
        v.component("app-default-mob-pickview", () => import('../components/view/app-default-mob-pickview/app-default-mob-pickview'));
        v.component("app-default-mob-mpickview", () => import('../components/view/app-default-mob-mpickview/app-default-mob-mpickview'));
        v.component("app-default-mob-deportalview", () => import('../components/view/app-default-mob-deportalview/app-default-mob-deportalview'));
        v.component("app-default-mob-meditview", () => import('../components/view/app-default-mob-meditview/app-default-mob-meditview'));
        v.component("app-default-mob-pickuptreeview", () => import('../components/view/app-default-mob-pickuptreeview/app-default-mob-pickuptreeview'));
        v.component("app-default-mob-wfdynaeditview", () => import('../components/view/app-default-mob-wfdynaeditview/app-default-mob-wfdynaeditview'));
        v.component("app-default-mob-wfdynaactionview", () => import('../components/view/app-default-mob-wfdynaactionview/app-default-mob-wfdynaactionview'));
        v.component("app-default-mob-wfdynaexpmdview", () => import('../components/view/app-default-mob-wfdynaexpmdview/app-default-mob-wfdynaexpmdview'));
        v.component("app-default-mob-wfdynastartview", () => import('../components/view/app-default-mob-wfdynastartview/app-default-mob-wfdynastartview'));
        v.component("app-default-mob-wfdynaeditview3", () => import('../components/view/app-default-mob-wfdynaeditview3/app-default-mob-wfdynaeditview3'));
        v.component("app-default-mob-deredirectview", () => import('../components/view/app-default-mob-deredirectview/app-default-mob-deredirectview'));
        v.component("app-default-mob-customview", () => import('../components/view/app-default-mob-customview/app-default-mob-customview'));
        v.component("app-default-wfsteptraceview", () => import('../components/view/app-default-wfsteptraceview/app-default-wfsteptraceview'));
        v.component("app-default-mob-depanelview", () => import('../components/view/app-default-mob-depanelview/app-default-mob-depanelview'));
        v.component("app-default-mob-wizard-view", () => import('../components/view/app-default-mob-wizard-view/app-default-mob-wizard-view'));
        v.component("app-default-mob-html-view", () => import('../components/view/app-default-mob-html-view/app-default-mob-html-view'));
        v.component("app-default-mob-calendarexpview", () => import('../components/view/app-default-mob-calendarexpview/app-default-mob-calendarexpview'));
        v.component("app-default-notsupportedview", () => import('../components/view/app-default-notsupportedview'));
        // 部件
        v.component("app-default-mob-appmenu", () => import('../components/control/app-default-mob-appmenu/app-default-mob-appmenu'));
        v.component("app-default-mob-mdctrl", () => import('../components/control/app-default-mob-mdctrl/app-default-mob-mdctrl'));
        v.component("app-default-mob-form", () => import('../components/control/app-default-mob-form/app-default-mob-form'));
        v.component("app-default-mob-dashboard", () => import('../components/control/app-default-mob-dashboard/app-default-mob-dashboard'));
        v.component("app-default-mob-portlet", () => import('../components/control/app-default-mob-portlet/app-default-mob-portlet'));
        v.component("app-default-mob-chart", () => import('../components/control/app-default-mob-chart/app-default-mob-chart'));
        v.component("app-default-mob-calendar", () => import('../components/control/app-default-mob-calendar/app-default-mob-calendar'));
        v.component("app-default-mob-tabexppanel", () => import('../components/control/app-default-mob-tabexppanel/app-default-mob-tabexppanel'));
        v.component("app-default-mob-tabviewpanel", () => import('../components/control/app-default-mob-tabviewpanel/app-default-mob-tabviewpanel'));
        v.component("app-default-mob-listexpbar", () => import('../components/control/app-default-mob-listexpbar/app-default-mob-listexpbar'));
        v.component("app-default-mob-tree", () => import('../components/control/app-default-mob-tree/app-default-mob-tree'));
        v.component("app-default-mob-meditviewpanel", () => import('../components/control/app-default-mob-meditviewpanel/app-default-mob-meditviewpanel'));
        v.component("app-default-mob-contextmenu", () => import('../components/control/app-default-mob-contextmenu/app-default-mob-contextmenu'));
        v.component("app-default-mob-pickupviewpanel", () => import('../components/control/app-default-mob-pickupviewpanel/app-default-mob-pickupviewpanel'));
        v.component("app-default-mob-searchform", () => import('../components/control/app-default-mob-searchform/app-default-mob-searchform'));
        v.component("app-default-mob-panel", () => import('../components/control/app-default-mob-panel/app-default-mob-panel'));
        v.component("app-default-mob-drtab", () => import('../components/control/app-default-mob-drtab/app-default-mob-drtab'));
        v.component("app-default-mob-wizard-panel", () => import('../components/control/app-default-mob-wizard-panel/app-default-mob-wizard-panel'));
        v.component("app-default-mob-searchbar", () => import('../components/control/app-default-mob-searchbar/app-default-mob-searchbar'));
        v.component("app-default-mob-calendarexpbar", () => import('../components/control/app-default-mob-calendarexpbar/app-default-mob-calendarexpbar'));
    }
}