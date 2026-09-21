import { Emit, Prop, Watch } from 'vue-property-decorator';
import { Util } from 'ibiz-core';
import { MobSearchFormControlBase } from '../../../widgets';
import { IPSDEFormButton, IPSDEFormDetail, IPSDEFormGroupPanel, IPSDEFormItem, IPSDEFormPage, IPSDEFormRawItem, IPSDEFormTabPage, IPSDEFormTabPanel, IPSDESearchFormItem } from '@ibiz/dynamic-model-api';
/**
 * 搜索表单基类
 *
 * @export
 * @class AppMobSearchFormBase
 * @extends {MobSearchFormControlBase}
 */
export class AppMobSearchFormBase extends MobSearchFormControlBase {
  /**
   * 部件动态参数
   *
   * @memberof AppMobSearchFormBase
   */
  @Prop() public declare dynamicProps: any;

  /**
   * 部件静态参数
   *
   * @memberof AppMobSearchFormBase
   */
  @Prop() public declare staticProps: any;

  /**
   * 监听部件动态参数变化
   *
   * @param {*} newVal
   * @param {*} oldVal
   * @memberof AppMobSearchFormBase
   */
  @Watch('dynamicProps', {
    immediate: true,
  })
  public onDynamicPropsChange(newVal: any, oldVal: any) {
    if (newVal && !Util.isFieldsSame(newVal, oldVal)) {
      super.onDynamicPropsChange(newVal, oldVal);
    }
  }

  /**
   * 监听部件静态参数变化
   *
   * @param {*} newVal
   * @param {*} oldVal
   * @memberof AppMobSearchFormBase
   */
  @Watch('staticProps', {
    immediate: true,
  })
  public onStaticPropsChange(newVal: any, oldVal: any) {
    if (newVal && !Util.isFieldsSame(newVal, oldVal)) {
      super.onStaticPropsChange(newVal, oldVal);
    }
  }

  /**
   * 销毁视图回调
   *
   * @memberof AppMobSearchFormBase
   */
  public destroyed() {
    this.ctrlDestroyed();
  }

  /**
   * 部件事件
   *
   * @param {{ controlname: string; action: string; data: any }} { controlname 部件名称, action 事件名称, data 事件参数 }
   * @memberof AppMobSearchFormBase
   */
  @Emit('ctrl-event')
  public ctrlEvent({ controlname, action, data }: { controlname: string; action: string; data: any }): void { }

  /**
   * 初始化部件的绘制参数
   *
   * @type {Array<*>}
   * @memberof ViewBase
   */
  public initRenderOptions(opts?: any) {
    this.renderOptions = {};
    const { controlType, codeName } = this.controlInstance;
    // 部件类名
    const controlClassNames: any = {
      'control-container': true,
      [`app-control-${controlType.toLowerCase()}`]: true,
      [Util.srfFilePath2(codeName)]: true,
      [`app-control-${controlType.toLowerCase()}--` + (this.controlInstance.searchButtonPos?.toLowerCase() || 'right')]: true
    };
    Object.assign(controlClassNames, opts);
    if (this.controlInstance?.getPSSysCss?.()?.cssName) {
      Object.assign(controlClassNames, { [this.controlInstance.getPSSysCss()?.cssName || '']: true });
    }
    this.$set(this.renderOptions, 'controlClassNames', controlClassNames);
  }

  /**
   * 绘制表单分页
   *
   * @returns
   * @memberof AppFormBase
   */
  public renderFormPage(modelJson: IPSDEFormPage, index: number): any {
    const { noTabHeader } = this.controlInstance;
    if (noTabHeader) {
      return this.renderDetails(modelJson);
    }
    return (
      <app-default-mob-form-page
        detailsInstance={modelJson}
        index={index}
        runtimeModel={this.detailsModel[modelJson.name]}
        controlInstance={this.controlInstance}
        modelService={this.modelService}
      >
        {this.renderDetails(modelJson)}
      </app-default-mob-form-page>
    );
  }

  /**
   * 绘制子表单成员,布局控制
   *
   * @param {*} modelJson
   * @returns
   * @memberof AppFormBase
   */
  public renderDetails(modelJson: any) {
    let formDetails: IPSDEFormDetail[] = modelJson.getPSDEFormDetails();
    // 没有子表单成员
    if (!formDetails || formDetails.length == 0) {
      return null;
    }
    return formDetails.map((item: any, index: number) => {
      return this.renderByDetailType(item, index);
    });
  }

  /**
   * 根据detailType绘制对应detail
   *
   * @param {*} modelJson
   * @param {number} index
   * @memberof AppFormBase
   */
  public renderByDetailType(modelJson: IPSDEFormDetail, index: number) {
    if (modelJson.getPSSysPFPlugin()) {
      const pluginInstance: any = this.PluginFactory.getPluginInstance(
        'CONTROLITEM',
        modelJson.getPSSysPFPlugin()?.pluginCode || '',
      );
      if (pluginInstance) {
        return pluginInstance.renderCtrlItem(this.$createElement, modelJson, this, null);
      }
    } else {
      switch (modelJson.detailType) {
        case 'FORMPAGE':
          return this.renderFormPage(modelJson as IPSDEFormPage, index);
        case 'GROUPPANEL':
          return this.renderGroupPanel(modelJson as IPSDEFormGroupPanel, index);
        case 'TABPAGE':
          return this.renderTabPage(modelJson as IPSDEFormTabPage, index);
        case 'TABPANEL':
          return this.renderTabPanel(modelJson as IPSDEFormTabPanel, index);
        case 'FORMITEM':
          return this.renderFormItem(modelJson as IPSDEFormItem, index);
        case 'BUTTON':
          return this.renderButton(modelJson as IPSDEFormButton, index);
        case 'RAWITEM':
          return this.renderRawItem(modelJson as IPSDEFormRawItem, index);
      }
    }
  }

  /**
   * 渲染直接内容
   *
   * @param {IPSDEFormRawItem} modelJson
   * @param {number} index
   * @return {*} 
   * @memberof AppMobFormBase
   */
  public renderRawItem(modelJson: IPSDEFormRawItem, index: number) {
    return (
      <app-default-mob-form-raw-item
        context={this.context}
        viewparams={this.viewparams}
        index={index}
        data={this.data}
        detailsInstance={modelJson}
        runtimeModel={this.detailsModel[modelJson.name]}>
      </app-default-mob-form-raw-item>
    )
  }

  /**
   * 绘制表单按钮
   *
   * @param {IPSDEFormButton} modelJson
   * @param {number} index
   * @return {*}  {*}
   * @memberof AppMobFormBase
   */
  public renderButton(modelJson: IPSDEFormButton, index: number): any {
    return (
      <app-default-mob-form-button
        context={this.context}
        viewparams={this.viewparams}
        data={this.data}
        index={index}
        detailsInstance={modelJson}
        disabled={this.detailsModel[modelJson.name].disabled}
        runtimeModel={this.detailsModel[modelJson.name]}
        on-UIAction={this.onFormItemActionClick.bind(this)}>
      </app-default-mob-form-button>
    )
  }

  /**
   * 绘制分页部件panel
   *
   * @returns
   * @memberof AppMobFormBase
   */
  public renderTabPanel(modelJson: IPSDEFormTabPanel, index: number): any {
    return (
      <app-default-mob-form-tab-panel
        detailsInstance={modelJson}
        index={index}
        modelService={this.modelService}
        runtimeModel={this.detailsModel[modelJson.name]}
        controlInstance={this.controlInstance}
      >
        {modelJson.getPSDEFormTabPages?.()?.length &&
          modelJson.getPSDEFormTabPages()?.map((item: IPSDEFormTabPage, index2: number) => {
            return this.renderTabPage(item, index2);
          })}
      </app-default-mob-form-tab-panel>
    );
  }

  /**
   * 绘制分页部件
   *
   * @returns
   * @memberof AppMobFormBase
   */
  public renderTabPage(modelJson: IPSDEFormTabPage, index: number): any {
    return (
      <app-default-mob-form-tab-page
        modelService={this.modelService}
        detailsInstance={modelJson}
        index={index}
        runtimeModel={this.detailsModel[modelJson.name]}
        controlInstance={this.controlInstance}
      >
        {this.renderDetails(modelJson)}
      </app-default-mob-form-tab-page>
    );
  }

  /**
   * 绘制表单项
   *
   * @returns
   * @memberof AppFormBase
   */
  public renderFormItem(modelJson: IPSDESearchFormItem, index: number): any {
    let editor = modelJson.getPSEditor();
    return (
      <app-default-mob-form-item
        detailsInstance={modelJson}
        index={index}
        data={this.data}
        rules={this.rules[modelJson.name]}
        runtimeModel={this.detailsModel[modelJson.name]}
        context={Util.deepCopy(this.context)}
        viewparams={Util.deepCopy(this.viewparams)}
        contextState={this.formState}
        modelService={this.modelService}
        service={this.service}
        ignorefieldvaluechange={this.ignorefieldvaluechange}
        on-formItemValueChange={(value: any) => {
          this.onFormItemValueChange(value);
        }}
        controlInstance={this.controlInstance}
      >
        {editor && (
          <app-default-editor
            editorInstance={editor}
            containerCtrl={this.controlInstance}
            parentItem={modelJson}
            value={this.data[editor?.name]}
            contextData={this.data}
            context={Util.deepCopy(this.context)}
            viewparams={Util.deepCopy(this.viewparams)}
            contextState={this.formState}
            service={this.service}
            disabled={this.detailsModel[modelJson.name]?.disabled}
            ignorefieldvaluechange={this.ignorefieldvaluechange}
            on-change={(value: any) => {
              this.onFormItemValueChange(value);
            }}
          />
        )}
      </app-default-mob-form-item>
    );
  }

  /**
   * 绘制分组面板
   *
   * @returns
   * @memberof AppMobFormBase
   */
  public renderGroupPanel(modelJson: IPSDEFormGroupPanel, index: number): any {
    return (
      <app-default-mob-group-panel
        detailsInstance={modelJson}
        index={index}
        runtimeModel={this.detailsModel[modelJson.name]}
        controlInstance={this.controlInstance}
        on-groupUIActionClick={this.handleActionClick.bind(this)}
        context={this.context}
        viewparams={this.viewparams}
        data={this.data}
        modelService={this.modelService}
      >
        {this.renderDetails(modelJson)}
      </app-default-mob-group-panel>
    );
  }

  /**
   * 绘制表单内容
   *
   * @returns
   * @memberof AppFormBase
   */
  public renderFormContent() {
    const { noTabHeader, name } = this.controlInstance;
    const formPages = this.controlInstance.getPSDEFormPages();
    if (formPages && formPages.length > 0) {
      if (noTabHeader) {
        return formPages.map((item: any, index: number) => {
          return this.renderFormPage(item, index);
        });
      } else {
        return (
          <van-tabs
            type="card"
            class="app-form-tabs"
            color="#333"
            animated={true}
            swipeable={true}
            scrollspy={true}
            lazy-render={false}
            value={this.detailsModel[name]?.activatedPage}
            on-change={(e: any) => {
              this.detailsModel[name]?.clickPage(e);
            }}
          >
            {formPages.map((item: any, index: number) => {
              return (
                <van-tab title={item.caption} class="app-form-tab" name={item.name}>
                  {this.renderFormPage(item, index)}
                </van-tab>
              );
            })}
          </van-tabs>
        );
      }
    }
  }

  /**
   * 绘制搜索
   *
   * @return {*}
   * @memberof AppMobSearchFormBase
   */
  renderSearchFormDefault() {
    const { controlClassNames } = this.renderOptions;
    const pos = 'search-button-' + (this.controlInstance.searchButtonPos?.toLowerCase() || 'right');
    Object.assign(controlClassNames, { [pos]: true });
    return (
      <div class={controlClassNames}>
        <div class="search-form-content">{this.renderFormContent()}</div>
      </div>
    );
  }

  renderSearchButton() {
    const searchButtonStyle = this.controlInstance.searchButtonStyle;
    return searchButtonStyle != 'NONE' ? (
      <div class={'app-control-searchform__buttons'}>
        <app-mob-button
          class="button__item"
          on-click={() => {
            this.search();
          }}
        >
          搜索
        </app-mob-button>
        {searchButtonStyle != 'SEARCHONLY' ? (
          <app-mob-button
            class="button__item"
            on-click={() => {
              this.reset();
            }}
          >
            重置
          </app-mob-button>
        ) : null}
      </div>
    ) : null
  }


  /**
   *   绘制模态搜索表单
   *
   * @return {*} 
   * @memberof AppMobSearchFormBase
   */
  renderSearchFormModal() {
    const { controlClassNames } = this.renderOptions;
    return <div class={controlClassNames}>{this.renderFormContent()}</div>;
  }

  /**
   * 绘制表单
   *
   * @returns {*}
   * @memberof AppMobSearchFormBase
   */
  public render() {
    if (!this.controlIsLoaded) {
      return null;
    }
    const { controlClassNames } = this.renderOptions;
    const buttonClass = this.controlInstance.searchButtonPos?.toLowerCase() == 'bottom' ? 'control-footer app-control-searchform__footer' : 'control-right app-control-searchform__right';
    return <div class={controlClassNames}>
      <div class="control-content app-control-searchform__content">
        {this.renderFormContent()}
      </div>
      <div class={buttonClass}>
        {this.renderSearchButton()}
      </div>
    </div>
  }
}
