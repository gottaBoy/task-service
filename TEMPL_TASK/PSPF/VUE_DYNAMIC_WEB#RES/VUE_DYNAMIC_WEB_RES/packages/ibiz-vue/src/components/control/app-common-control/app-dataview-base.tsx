import { CreateElement } from 'vue';
import { Emit, Prop, Watch } from 'vue-property-decorator';
import { throttle, Util } from 'ibiz-core';
import { DataViewControlBase } from '../../../widgets';

/**
 * 数据视图部件基类
 *
 * @export
 * @class AppDataViewBase
 * @extends {DataViewControlBase}
 */
export class AppDataViewBase extends DataViewControlBase {

    /**
     * 部件动态参数
     *
     * @memberof AppDataViewBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 部件静态参数
     *
     * @memberof AppDataViewBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppDataViewBase
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
     * 监听静态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppDataViewBase
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
     * 部件事件
     * 
     * @param 抛出参数 
     * @memberof AppDataViewBase
     */
    @Emit('ctrl-event')
    public ctrlEvent({ controlname, action, data }: { controlname: string, action: string, data: any }): void { }

    /**
     * @description 是否显示回到顶部
     * @readonly
     * @type {boolean}
     * @memberof AppDataViewBase
     */
    get backTopVisible(): boolean {
      let visible: boolean = false;
      const el = document.querySelector(`#${this.controlId}`);
      if (el) {
        visible = true;
      }
      return visible;
    }

    /**
     * 绘制分组
     *
     * @param {*} h
     * @return {*} 
     * @memberof AppDataViewBase
     */
    public renderGroup(h: any) {
        return this.groupData.map((group: any, index: number) => {
            return (
                <el-collapse-item class="app-control-dataview__content__group" name={group.group}>
                    <div slot="title" class="group__title">
                        <div class="group__caption">{group.label}</div>
                        <div class="group__action">
                            {/* TODO 分组界面行为组 */}
                            {/* {this.renderGroupAction(group)} */}
                        </div>
                    </div>
                    { this.hasChildrenRender(h, group) }
                </el-collapse-item>
            );
        });
    }

    /**
     * 绘制有子成员项
     *
     * @param {*} h
     * @param {*} group
     * @return {*} 
     * @memberof AppDataViewBase
     */
    public hasChildrenRender(h: any, group: any) {
        if (group.children.length > 0) {
            const { cardColXS, cardColSM, cardColMD, cardColLG } = this.controlInstance;
            return group.children.map((groupChild: any, index: number) => {
                return (
                    <a href={groupChild.starturl}>
                        <i-col xs={cardColXS} sm={cardColSM} md={cardColMD} class="group__content" lg={cardColLG}>
                            {this.renderCard(groupChild)}
                        </i-col>
                    </a>
                );
            });
        } else {
            return (
                <div class="group__empty">
                    {this.$t('app.commonwords.nodata')}
                </div>
            );
        }
    }

    /**
     * 渲染数据视图项行为
     *
     * @param {*} item
     * @return {*} 
     * @memberof AppDataViewBase
     */
    public renderDataViewItemAction(item: any) {
        return Object.keys(this.actionModel).map((key: string) => {
            if (item[key].visabled) {
                const action = this.actionModel[key];
                return (
                    <el-button type='text' disabled={item[key].disabled}
                        class="bottom__action"
                        on-click={($event: any) => {
                            this.handleActionClick(item, $event, action, action);
                        }}>
                        {action.showIcon && <i class={[action.cssClass, "bottom__action__icon"]}></i>}
                        <span>
                            {action.showCaption ? this.$tl(action.lanResTag, action?.caption ? action.caption : '') : ''}
                        </span>
                    </el-button>
                )
            }
        });
    }

    /**
     * 渲染数据视图项
     *
     * @param {*} item
     * @return {*} 
     * @memberof AppDataViewBase
     */
    public renderDataViewItem(item: any) {
        return (
            <div class="item__content">
                <div class="item__content__top">
                    <div class="top__title">
                        <span>{item.srfmajortext}</span>
                    </div>
                    {item.content && <div class="top__description">{item.content}</div>}
                </div>
                {
                    this.actionModel && Object.keys(this.actionModel).length > 0 &&
                    <div class="item__content__bottom">
                        {this.renderDataViewItemAction(item)}
                    </div>
                }
            </div>
        )
    }

    /**
     * 渲染卡片
     *
     * @param {*} item
     * @return {*} 
     * @memberof AppDataViewBase
     */
    public renderCard(item: any) {
        const style: any = {
            width: this.controlInstance.cardWidth > 0 ? `${this.controlInstance.cardWidth}px` : false,
            height: this.controlInstance.cardHeight > 0 ? `${this.controlInstance.cardHeight}px` : false
        };
        const itemCssName = {
            "app-control-dataview__content__item": true,
            "is-active": item.srfchecked === 1
        }
        const itemCss = this.controlInstance.getItemPSSysCss();
        if (itemCss) {
            Object.assign(itemCssName, {
                [itemCss.cssName] : true,
            })
        }
        return (
            <el-card
                shadow="hover"
                body-style={style}
                class={itemCssName}
                nativeOnClick={() => throttle(this.handleClick, [item], this)}
                nativeOnDblclick={() => throttle(this.handleDblClick, [item], this)}>
                {this.controlInstance.getItemPSLayoutPanel()
                    ? this.renderItemPSLayoutPanel(item)
                    : this.renderDataViewItem(item)}
            </el-card>
        );
    }

    /**
     * 绘制数据视图内容
     *
     * @memberof AppDataViewBase
     */
    public renderDataViewContent(h: CreateElement) {
        if (!this.isEnableGroup) {
            const { cardColXS, cardColSM, cardColMD, cardColLG } = this.controlInstance;
            return this.items.map((item: any, index: number) => {
                return (
                    <i-col xs={cardColXS} sm={cardColSM} md={cardColMD} lg={cardColLG}> 
                        {this.renderCard(item)}
                    </i-col>
                );
            });
        } else {
            return <el-collapse v-model={this.activeName}>{this.renderGroup(h)}</el-collapse>;
        }
    }

    /**
     * @description 绘制加载更多
     * @return {*} 
     * @memberof AppDataViewBase
     */
     renderLoadMore(){
        if (this.enablePagingBar || Object.is(this.totalRecord, this.items.length)) {
            return null;
        }
        return (
            <div
                onclick={(event: MouseEvent) => {
                    this.loadMore(event);
                }}
                class='app-control-dataview__load--more'
            >
                {this.$t('app.dataview.loadmore')}
            </div>
        );
    }

    /**
     * 绘制排序栏
     *
     * @memberof AppDataViewBase
     */
    public renderSortBar(h: any) {
        return (
            <app-sort-bar
                sortModel={this.sortModel}
                sortField={this.sortField}
                sortDir={this.sortDir}
                entityName={this.appDeCodeName}
                on-clickSort={(val: any) => throttle(this.sortClick, [val], this)}
            ></app-sort-bar>
        );
    }

    /**
     * 绘制分页栏
     *
     * @memberof AppDataViewBase
     */
    public renderPaging() {
        if (!this.enablePagingBar) {
            return null;
        }
        const pageText = <span>{this.$t('app.dataview.sum')}&nbsp;{this.totalRecord}&nbsp;{this.$t('app.dataview.data')}</span>
        return this.items?.length > 0 ? (
            <row class='app-control-dataview__pagination control-footer'>
                <page
                    class='pagination--pull-right'
                    on-on-change={($event: any) => this.pageOnChange($event)}
                    on-on-page-size-change={($event: any) => this.onPageSizeChange($event)}
                    transfer={true}
                    total={this.totalRecord}
                    show-sizer
                    current={this.curPage}
                    page-size={this.limit}
                    page-size-opts={[10, 20, 30, 40, 50, 60, 70, 80, 90, 100]}
                    show-elevator
                    show-total
                >
                    {this.renderBatchToolbar()}
                    <span>
                        <i-button icon='md-refresh' class="pagination__refresh" title={this.$t('app.grid.refresh')} on-click={() => throttle(this.pageRefresh, [], this)}></i-button>
                    </span>
                    {pageText}
                </page>
            </row>
        ) : null;
    }

    /**
     * 绘制
     * 
     * @memberof AppDataViewBase
     */
    public render(h: CreateElement) {
        if (!this.controlIsLoaded) {
            return null;
        }
        const { controlClassNames } = this.renderOptions;
        return (
            <div class={controlClassNames}>
                {this.hasSortBar && (
                    <div class='control-header app-control-dataview__header'>{this.renderSortBar(h)}</div>
                )}
                {this.items.length > 0 && (
                    <row class='control-content app-control-dataview__content' gutter={24} type='flex' justify='start'>
                        {this.renderDataViewContent(h)}
                        {this.renderLoadMore()}
                    </row>
                )}
                {this.renderPaging()}
                {!this.enablePagingBar ? this.renderBatchToolbar() : null}
                {!this.ctrlLoadingService?.isLoading ? this.renderEmptyDataTip() : this.renderLoadDataTip()}
                {this.backTopVisible && <el-backtop target={`#${this.controlId}`}></el-backtop>}
            </div>
        );
    }

    /**
     * 销毁视图回调
     *
     * @memberof AppDataViewBase
     */
    public destroyed() {
        this.ctrlDestroyed();
    }
}