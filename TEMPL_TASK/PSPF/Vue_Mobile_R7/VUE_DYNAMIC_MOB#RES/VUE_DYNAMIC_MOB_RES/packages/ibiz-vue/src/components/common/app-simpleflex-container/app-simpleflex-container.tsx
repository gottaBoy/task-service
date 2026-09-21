import Vue from 'vue';
import { Component, Prop } from 'vue-property-decorator';

@Component({})
export class AppSimpleFlexContainer extends Vue {

  /**
   * 子容器模型
   *
   * @type {*}
   * @memberof AppSimpleFlexContainer
   */
  @Prop() public panelItems!: any;

  /**
   * 绘制回调
   *
   * @type {Function}
   * @memberof AppSimpleFlexContainer
   */
  @Prop() public renderCallBack!: Function;

  /**
   * 当前下标
   *
   * @type {number}
   * @memberof AppSimpleFlexContainer
   */
  @Prop() public index?: number;

  /**
   * 子容器模型
   *
   * @type {*}
   * @memberof AppSimpleFlexContainer
   */
  public getDetailStyle(panelItem: any) {
    const boxLayoutPosStyle: any = {};
    const layoutPos = panelItem?.getPSLayoutPos() as any;
    // 自身对齐方式
    if (layoutPos && (layoutPos.vAlignSelf || layoutPos.hAlignSelf)) {
      Object.assign(boxLayoutPosStyle, { display: 'flex' });
      // 自身垂直对齐模式
      switch (layoutPos.vAlignSelf) {
        case 'TOP':
          Object.assign(boxLayoutPosStyle, { 'align-items': 'flex-start' });
          break;
        case 'MIDDLE':
          Object.assign(boxLayoutPosStyle, { 'align-items': 'center' });
          break;
        case 'BOTTOM':
          Object.assign(boxLayoutPosStyle, { 'align-items': 'flex-end' });
          break;
        default:
          break;
      }
      // 自身水平对齐模式
      switch (layoutPos.hAlignSelf) {
        case 'LEFT':
          Object.assign(boxLayoutPosStyle, { 'justify-content': 'flex-start' });
          break;
        case 'CENTER':
          Object.assign(boxLayoutPosStyle, { 'justify-content': 'center' });
          break;
        case 'RIGHT':
          Object.assign(boxLayoutPosStyle, { 'justify-content': 'flex-end' });
          break;
        case 'JUSTIFY':
          Object.assign(boxLayoutPosStyle, { 'justify-content': 'space-between' });
          break;
        default:
          break;
      }
      // 自身垂直对齐模式/自身水平对齐模式生效，占满剩余空间
      if (!boxLayoutPosStyle['flex-grow']) {
        Object.assign(boxLayoutPosStyle, { 'flex-grow': 1 });
      }
    }
    // 简单FLEX布局
    if (layoutPos && layoutPos.layout == 'SIMPLEFLEX') {
      if (layoutPos?.grow && layoutPos?.grow !== -1) {
        Object.assign(boxLayoutPosStyle, { width: `${(100 / 12) * layoutPos?.grow}%`, height: 'auto' });
      } else {
        // 简单FLEX布局自适应
        Object.assign(boxLayoutPosStyle, { 'flex-grow': 1, 'min-width': `${100 / 12}%`, height: 'auto' });
      }
    }
    return boxLayoutPosStyle;
  }

  /**
   * 绘制
   *
   * @memberof AppSimpleFlexContainer
   */
  render() {
    if (!this.panelItems) {
      return null;
    }
    return <div class="app-simpleflex-container">
      {
        this.panelItems.map((panelItem: any) => {
          return <div style={this.getDetailStyle(panelItem)} class="app-simpleflex-container__pos-container">
            {
              panelItem.getPSPanelItems() && panelItem.getPSPanelItems().map((item: any) => {
                return <div class="app-simpleflex-container__item" style={this.getDetailStyle(item)}>
                  {
                    this.renderCallBack(item,panelItem,this.index)
                  }
                </div>
              })
            }
          </div>
        })
      }
    </div>
  }
}
