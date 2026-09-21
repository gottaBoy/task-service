import { Vue, Component, Prop, Emit } from 'vue-property-decorator';
import { ToolbarItem } from 'ibiz-core';
import './view-toolbar.less';
import { IPSDEToolbar, IPSDEToolbarItem, IPSLanguageRes, IPSDECMUIActionItem, IPSAppDEUIAction, IPSDETBGroupItem } from '@ibiz/dynamic-model-api';

/**
 * 视图工具栏
 *
 * @export
 * @class ViewToolbar
 * @extends {Vue}
 */
@Component({})
export class ViewToolbar extends Vue implements ToolbarItem {

  /**
   * 工具栏模型
   *
   * @type {{ [key: string]: ToolbarItem }}
   * @memberof ViewToolbar
   */
  @Prop()
  public toolbarModel!: IPSDEToolbar;

  /**
   * 工具栏权限对象
   *
   * @type {{ [key: string]: ToolbarItem }}
   * @memberof ViewToolbar
   */
  @Prop()
  public toolBarAuth!: any;

  /**
   * 视图标识
   *
   * @type string
   * @memberof ViewToolbar
   */
  @Prop()
  public viewtag!: string;

  /**
   * 计树器服务集合
   *
   * @type {any}
   * @memberof ViewToolbar
   */
  @Prop()
  public counterServiceArray?: any;

  /**
   *工具栏弹出或关闭状态
   *
   * @memberof ViewToolbar
   */
  public popupStatus = false;

  /**
   * 所有工机具项
   *
   * @protected
   * @type {ToolbarItem[]}
   * @memberof ViewToolbar
   */
  public items: IPSDEToolbarItem[] = [];


  /**
   * 工具栏绘制
   *
   * @type {any[]}
   * @memberof ViewToolbar
   */
  public popupData: any[] = [];

  /**
   * 工具栏项点击
   *
   * @param {*} uiAction
   * @param {MouseEvent} e
   * @memberof ViewToolbar
   */
  @Emit('item-click')
  public itemClick(uiAction: any, e?: MouseEvent): void { }


  /**
   * 点击处理
   *
   * @param {*} item
   * @memberof ViewToolbar
   */
  public handleClick(item: any, e: any) {
    if (item.itemType == 'ITEMS') {
      const items = (item.oneself as IPSDETBGroupItem).getPSDEToolbarItems() || [];
      this.popupData = this.initToolBarParam(items);
      this.popupStatus = true;
    } else if (item.itemType == 'DEUIACTION') {
      const _item = item.oneself as IPSDECMUIActionItem;
      const uiAction = this.getToolBarUIActon(_item);
      this.itemClick({ tag: uiAction.name, item: uiAction }, e);
    }
  }

  /**
   * 初始化工具栏参数
   *
   * @param {any[]} items
   * @memberof ViewToolbar
   */
  public initToolBarParam(items: any[]): any {
    let data: any = [];
    items.forEach((item: any) => {
      data.push(this.getToolbarItemData(item));
    })
    return data;
  }


  /**
   * 绘制菜单项
   *
   * @protected
   * @param {*} item
   * @returns {*}
   * @memberof ViewToolbar
   */
  protected renderPopupItem(item: any): any {
    return (
      <div class="popup__item">
        <app-mob-button
          size="large"
          flexType="vertical"
          buttonType="text"
          disabled={this.getAuthValue(item, 'disabled')}
          class={item.class}
          style={{display:this.getAuthValue(item, 'visible')?'':'none'}}
          text={item.showCaption ? item.caption : ''}
          runTimeIconItem={{ iconName: item?.sysImage?.cssClass, imagePath: item?.sysImage?.imagePath }}
          on-click={(e: any) => [this.handleClick(item, e), (this.popupStatus = false)]}
        />
      </div>
    );
  }

  /**
   * 获取按钮权限
   *
   * @memberof ViewToolbar
   */
  getAuthValue(item: any, tag: 'disabled' | 'visible') {
    if (!item.name) {
      return;
    }
    return this.toolBarAuth[item.name][tag];
  }


  /**
   * 获取工具栏参数
   *
   * @param {IPSDEToolbarItem} item
   * @memberof ViewToolbar
   */
  public getToolbarItemData(item: IPSDEToolbarItem) {
    return {
      name: item.name,
      toolbarName: this.toolbarModel.name,
      showCaption: item.showCaption,
      caption: this.$tl((item.getCapPSLanguageRes() as IPSLanguageRes)?.lanResTag, item.caption),
      itemType: item.itemType,
      showIcon: item.showIcon,
      sysImage: { cssClass: item.getPSSysImage()?.cssClass, imagePath: item.getPSSysImage()?.imagePath },
      oneself: item,
    }
  }

  /**
   * 获取工具栏行为参数
   *
   * @param {IPSDECMUIActionItem} item
   * @return {*} 
   * @memberof ViewToolbar
   */
  getToolBarUIActon(item: IPSDECMUIActionItem) {
    const uiAction = item.getPSUIAction?.() as IPSAppDEUIAction;
    return {
      name: item.name,
      dataaccaction: uiAction?.dataAccessAction,
      noprivdisplaymode: uiAction.noPrivDisplayMode,
      uiaction: uiAction,
      toolbarName: this.toolbarModel.name,
    }
  }

  /**
   * 绘制底部模式工具栏
   *
   * @protected
   * @returns {*}
   * @memberof ViewToolbar
   */
  public renderBottomDefault(): any {
    return <div class="view-footer__buttons">
      {
        this.items.map((item: any) => {
          return <app-mob-button
            disabled={this.getAuthValue(item, 'disabled')}
            class={item.class}
            style={{display:this.getAuthValue(item, 'visible')?'':'none'}}
            text={item.showCaption ? item.caption : ''}
            runTimeIconItem={{ iconName: item?.sysImage?.cssClass, imagePath: item?.sysImage?.imagePath }}
            on-click={(e: any) => [this.handleClick(item, e)]}
          ></app-mob-button>
        })
      }
      {
        this.renderPopup()
      }
    </div>

  }

  /**
   * 绘制弹出层
   *
   * @param {*} items
   * @memberof ViewToolbar
   */
  public renderPopup() {
    return (
      <van-popup
        class="view-footer__popup"
        value={this.popupStatus}
        round
        position="bottom"
        get-container="body"
        on-click-overlay={() => {
          this.popupStatus = false;
        }}
      >
        <div class="container">
          {this.popupData.map((item: any) => {
            return this.renderPopupItem(item);
          })}
        </div>
      </van-popup>
    )
  }


  created() {
    if(!this.toolbarModel){
      return;
    }
    const items = this.toolbarModel.getPSDEToolbarItems() || [];
    this.items = this.initToolBarParam(items);
  }

  /**
   * 绘制导航栏项
   *
   * @return {*}  {any[]}
   * @memberof ViewToolbar
   */
  renderNavToolBar(): any[] {
    const data = this.items.map((item: any) => {
      return (
        <app-mob-button
          size="large"
          buttonType="text"
          style={{display:this.getAuthValue(item, 'visible')?'':'none'}}
          disabled={this.getAuthValue(item, 'disabled')}
          class={[item.class,'app-mob-button__nav']}
          text={item.showCaption ? item.caption : ''}
          runTimeIconItem={{ iconName: item?.sysImage?.cssClass, imagePath: item?.sysImage?.imagePath }}
          on-click={(e: any) => [this.handleClick(item, e)]}
        />
      );
    }) || [];
    data.push(this.renderPopup());
    return data
  }

  /**
   * 绘制右侧
   *
   * @return {*}
   * @memberof ViewToolbar
   */
  renderRightDefault() {
    return this.$createElement(
      'ion-buttons',
      {
        attrs: { slot: 'end' },
      },
      this.renderNavToolBar(),
    );
  }

  /**
   * 绘制左侧
   *
   * @return {*}
   * @memberof ViewToolbar
   */
  renderLeftDefault() {
    return this.$createElement(
      'ion-buttons',
      {
        attrs: { slot: 'start' },
      },
      [...this.renderNavToolBar()],
    );
  }

  /**
   * 绘制工具栏内容
   *
   * @returns {*}
   * @memberof ViewToolbar
   */
  public render(): any {
    if (this.items?.length == 0) {
      return;
    }
    const toolBarStyle = this.toolbarModel.toolbarStyle;
    let content: any;
    switch (toolBarStyle.toLowerCase()) {
      case 'mobbottommenu':
        content = this.renderBottomDefault();
        break;
      case 'mobnavrightmenu':
        content = this.renderRightDefault();
        break;
      case 'mobnavleftmenu':
        content = this.renderLeftDefault();
        break;
    }
    return content;
  }
}
