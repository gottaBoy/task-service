import { Component } from 'vue-property-decorator';
import { AppIndexViewBase, AppLoadingService, VueLifeCycleProcessing } from "ibiz-vue";;

/**
 * ${view.getCaption()}
 *
 * @export
 * @class ${srfclassname('${view.name}')}
 * @extends {Vue}
 */
@Component({})
@VueLifeCycleProcessing()
export class ${srfclassname('${view.name}')} extends AppIndexViewBase {

  /**
   * 应用loading服务
   *
   * @memberof ${srfclassname('${view.name}')}
   */
  public appLoadingService = AppLoadingService.getInstance();

  /**
   * @description 是否显示标题
   * @type {boolean}
   * @memberof ${srfclassname('${view.name}')}
   */
  public showCaption: boolean = ${view.isShowCaptionBar()?c} && !this.noViewCaption;

  /**
   * 是否满屏
   *
   * @type {boolean}
   * @memberof ${srfclassname('${view.name}')}
   */
  public isFullScreen: boolean = false;

  <#if view.getMainMenuAlign?? && (view.getMainMenuAlign() == 'LEFT' || view.getMainMenuAlign() == 'NONE' || view.getMainMenuAlign() == '')>
  /**
   * 菜单收缩变化
   *
   * @type {boolean}
   * @memberof ${srfclassname('${view.name}')}
   */
  public collapseChange: boolean = false;
  </#if>

  <#if view.getMainMenuAlign?? && (view.getMainMenuAlign() == 'LEFT' || view.getMainMenuAlign() == 'NONE' || view.getMainMenuAlign() == 'TOP' || view.getMainMenuAlign() == '')>
  /**
   * 抽屉状态
   *
   * @type {boolean}
   * @memberof ${srfclassname('${view.name}')}
   */
  public contextMenuDragVisiable: boolean = false;

  /**
   * 当前字体
   *
   * @memberof ${srfclassname('${view.name}')}
   */
  get selectFont() {
    let _this: any = this;
    if (_this.$router.app.$store.state.selectFont) {
      return _this.$router.app.$store.state.selectFont;
    } else if (localStorage.getItem('font-family')) {
      return localStorage.getItem('font-family');
    } else {
      return 'Microsoft YaHei';
    }
  }
  </#if>

  /**
   * 当前主题
   *
   * @memberof ${srfclassname('${view.name}')}
   */
  public selectTheme() {
    let _this: any = this;
    if (_this.$router.app.$store.state.selectTheme) {
      return _this.$router.app.$store.state.selectTheme;
    } else if (localStorage.getItem('theme-class')) {
      return localStorage.getItem('theme-class');
    } else {
      return 'app-theme-default';
    }
  }

  <#if view.getMainMenuAlign?? && (view.getMainMenuAlign() == 'LEFT' || view.getMainMenuAlign() == '')>
  /**
   * 菜单收缩
   *
   * @memberof ${srfclassname('${view.name}')}
   */
  public collapseMenus() {
    if (this.$store.getters['getCustomParamByTag']('srffullscreen')) {
      this.isFullScreen = !this.isFullScreen;
      if (this.isFullScreen) {
        this.collapseChange = true;
      } else {
        this.collapseChange = false;
      }
    } else {
      this.collapseChange = !this.collapseChange;
    }
  }
  </#if>

  /**
   * 初始化
   * 
   * @memberof ${srfclassname('${view.name}')} 
   */
  public created() {
    document.getElementsByTagName('html')[0].className = this.selectTheme();
    this.isFullScreen = Boolean(this.$store.getters['getCustomParamByTag']('srffullscreen'));
  }

  <#if view.getMainMenuAlign?? && (view.getMainMenuAlign() == 'LEFT' || view.getMainMenuAlign() == '')>
  /**
   * 渲染左侧菜单样式
   * 
   * @memberof ${srfclassname('${view.name}')}
   */
  public renderContentLeft() {
    let contentClass = {
      'index_content': true,
      <#if view.getViewStyle?? && (view.getViewStyle() == 'DEFAULT' || view.getViewStyle() == 'EXTEND')>
      'index_tab_content': true,
      <#else>
      'index_route_content': true,
      </#if>
    }
    return (
      <layout style={{ 'font-family': this.selectFont, 'height': '100vh' }}>
        <header class="index_header">
          <div class="header-left" >
            <div class="page-logo">
              <div class="page-logo-left">
                <#if view.isEnableAppSwitch??>
                <span class="page-logo-menuicon" on-click={() => this.contextMenuDragVisiable = !this.contextMenuDragVisiable}><icon type="md-menu" />&nbsp;</span>
                </#if>
                <#if view.getAppIconPath?? && view.getAppIconPath()??>
                <img class="page-logo-image" src='${view.getAppIconPath()}'></img>
                </#if>
                {this.showCaption ? <span class="page-logo-title">{this.model.srfCaption}</span> : null}
                <#if view.isEnableAppSwitch??>
                <context-menu-drag viewStyle='${view.getViewStyle()}' contextMenuDragVisiable={this.contextMenuDragVisiable}></context-menu-drag>
                </#if>
              </div>
              {!this.collapseChange ? <i class="ivu-icon el-icon-s-fold" on-click={() => this.collapseMenus()}></i> : null}
              {this.collapseChange ? <i class="ivu-icon el-icon-s-unfold" on-click={() => this.collapseMenus()}></i> : null}
              <#if view.getViewStyle?? && view.getViewStyle() == 'STYLE4'>
              <app-breadcrumb indexViewTag='${view.codeName}' />
              </#if>
            </div>
          </div>
          <div class="header-right" style="display: flex;align-items: center;justify-content: space-between;">
            <app-header-menus />
            <app-lang title={this.model.srfTitle || this.model.srfCaption} style='font-size: 15px;padding: 0 10px;' />
            <app-orgsector />
            <app-user viewStyle='${view.getViewStyle()}' />
            <app-message-popover />
          </div>
        </header>
        <layout>
          <sider class="index_sider" width={this.isFullScreen ? 0 : this.collapseChange ? 68 : 200} hide-trigger value={this.collapseChange}>
            {this.renderMainContent()}
          </sider>
          <content class={contentClass}>
          <#if view.getViewStyle?? && (view.getViewStyle() == 'DEFAULT' || view.getViewStyle() == 'EXTEND')>
            <tab-page-exp modelService={this.modelService}></tab-page-exp>
          </#if>
            <app-nav-pos></app-nav-pos>
          </content>
        </layout>
      </layout>
    );
  }
  </#if>

  <#if view.getMainMenuAlign?? && view.getMainMenuAlign() == 'NONE'>
  /**
   * 渲染无菜单样式
   * 
   * @memberof ${srfclassname('${view.name}')}
   */
  public renderContentOnly() {
    let contentClass = {
      'index_content': true,
      'index_no_menu_align': true,
      <#if view.getViewStyle?? && (view.getViewStyle() == 'DEFAULT' || view.getViewStyle() == 'EXTEND')>
      'index_tab_content': true,
      <#else>
      'index_route_content': true,
      </#if>
    }
    return (
      <layout style={{ 'font-family': this.selectFont, 'height': '100vh' }}>
        <header class="index_header">
          <div class="header-left" >
            <div class="page-logo">
              <div class="page-logo-left">
                <#if view.isEnableAppSwitch??>
                <span class="page-logo-menuicon" on-click={() => this.contextMenuDragVisiable = !this.contextMenuDragVisiable}><icon type="md-menu" />&nbsp;</span>
                </#if>
                <#if view.getAppIconPath?? && view.getAppIconPath()??>
                <img class="page-logo-image" src='${view.getAppIconPath()}'></img>
                </#if>
                {this.showCaption ? <span class="page-logo-title">{this.model.srfCaption}</span> : null}
                <#if view.isEnableAppSwitch??>
                <context-menu-drag viewStyle='${view.getViewStyle()}' contextMenuDragVisiable={this.contextMenuDragVisiable}></context-menu-drag>
                </#if>
              </div>
            </div>
          </div>
          <div class="header-right" style="display: flex;align-items: center;justify-content: space-between;">
            <app-header-menus />
            <app-lang title={this.model.srfTitle || this.model.srfCaption} style='font-size: 15px;padding: 0 10px;' />
            <app-orgsector />
            <app-user viewStyle='${view.getViewStyle()}' />
            <app-message-popover />
          </div>
        </header>
        <layout>
          <sider class="index_sider no-menu-align" width={0} hide-trigger value={this.collapseChange}>
            {this.renderMainContent()}
          </sider>
          <content class={contentClass}>
            <app-nav-pos></app-nav-pos>
          </content>
        </layout>
      </layout>
    );
  }
  </#if>

  <#if view.getMainMenuAlign?? && view.getMainMenuAlign() == 'TOP'>
  /**
   * 渲染顶部菜单样式
   * 
   * @memberof ${srfclassname('${view.name}')}
   */
  public renderContentTop() {
    return (
      <layout style={{ 'font-family': this.selectFont, 'height': '100vh' }}>
        <header class="index_header" >
          <div class="header-left">
            <div class="page-logo">
              <#if view.getAppIconPath?? && view.getAppIconPath()??>
              <img class="page-logo-image" src='${view.getAppIconPath()}'></img>
              </#if>
              {this.showCaption ? <span style="display: inline-block;margin-left: 10px;font-size: 22px;">{this.model.srfCaption}</span> : null}
            </div>
            <div style="margin-left: 50px;">
              {this.renderMainContent()}
            </div>
          </div>
          <div class="header-right" style="display: flex;align-items: center;justify-content: space-between;">
            <app-header-menus />
            <app-lang title={this.model.srfTitle || this.model.srfCaption} style='font-size: 15px;padding: 0 10px;'></app-lang>
            <app-orgsector></app-orgsector>
            <app-user></app-user>
            <app-message-popover></app-message-popover>
            <app-lock-scren />
            <app-full-scren />
            <app-theme style="width:45px;display: flex;justify-content: center;"></app-theme>
          </div>
        </header>
        <content class="app-horizontal-layout" style="height:calc(100vh - 50px);" on-click={() => this.contextMenuDragVisiable = false}>
          <router-view></router-view>
        </content>
      </layout>
    );
  }
  </#if>

  <#if view.getMainMenuAlign?? && view.getMainMenuAlign() == 'CENTER'>
  /**
   * 渲染中间菜单样式
   * 
   * @memberof ${srfclassname('${view.name}')}
   */
  public renderContentMiddle() {
    let cardClass = {
      'view-card': true
    };
    return (
      <card class={cardClass} disHover={true} bordered={false}>
        {this.showCaption ? <div slot='title' class='header-container' key='view-header'>
          <span class='caption-info'>{this.model.srfCaption}</span>
        </div> : null}
        <div class='content-container'>
          {this.renderMainContent()}
        </div>
      </card>
    );
  }
  </#if>

  <#if view.getMainMenuAlign?? && (view.getMainMenuAlign() == 'TABEXP_LEFT' || view.getMainMenuAlign() == 'TREEEXP' || view.getMainMenuAlign() == 'TABEXP_TOP' || view.getMainMenuAlign() == 'TABEXP_RIGHT' || view.getMainMenuAlign() == 'TABEXP_BOTTOM')>
  /**
   * 渲染分页导航菜单样式
   *
   * @return {*} 
   * @memberof ${srfclassname('${view.name}')}
   */
  public renderContentTabexpView() {
    return (
      <div class='view-container view-default tabexp-container'>
        {this.renderMainContent()}
      </div>
    );
  }
  </#if>

  /**
   * 绘制内容
   * 
   * @memberof ${srfclassname('${view.name}')}
   */
  public renderContent(): any {
    <#if view.getMainMenuAlign??>
      <#if view.getMainMenuAlign() == 'LEFT' || view.getMainMenuAlign() == ''>
    return this.renderContentLeft();
      <#elseif view.getMainMenuAlign() == 'TOP'>
    return this.renderContentTop();
      <#elseif view.getMainMenuAlign() == 'CENTER'>
    return this.renderContentMiddle();
      <#elseif view.getMainMenuAlign() == 'TABEXP_LEFT' || view.getMainMenuAlign() == 'TREEEXP'>
    return this.renderContentTabexpView();
      <#elseif view.getMainMenuAlign() == 'TABEXP_TOP'>
    return this.renderContentTabexpView();
      <#elseif view.getMainMenuAlign() == 'TABEXP_RIGHT'>
    return this.renderContentTabexpView();
      <#elseif view.getMainMenuAlign() == 'TABEXP_BOTTOM'>
    return this.renderContentTabexpView();
      <#elseif view.getMainMenuAlign() == 'NONE'>
    return this.renderContentOnly();
      </#if>
    <#else>
    return this.renderContentLeft();
    </#if>
  }

  /**
   * 绘制应用首页视图
   * 
   * @memberof ${srfclassname('${view.name}')}
   */
  public render(h: any): any {
    if (!this.viewIsLoaded) {
      return null;
    }
    let viewClass = {
      'view-container': <#if view.getMainMenuAlign?? && view.getMainMenuAlign() != 'LEFT' && view.getMainMenuAlign() != 'TOP'>true<#else>false</#if>,
      'inner_indexview': <#if view.getMainMenuAlign?? && view.getMainMenuAlign() == 'CENTER'>true<#else>false</#if>,
      'view-default': true,
      '${view.getViewType()?lower_case}': true,
      '${srffilepath2(view.getCodeName())}': true,
      <#if view.getPSSysCss?? && view.getPSSysCss()??>'${view.getPSSysCss().getCssName()}': true</#if>
    };
    return (
      <div class={viewClass}>
      <#if view.isDefaultPage??>
        <div class="loading-bar" v-notification-signal={this.appLoadingService.isLoading}></div>
      </#if>
        <app-studioaction
          viewInstance={this.viewInstance}
          context={this.context}
          viewparams={this.viewparams}
          viewName={'${view.getCodeName()?lower_case}'}
          viewTitle={this.model?.srfCaption} />
        {this.renderContent()}
      </div>
    );
  }
}