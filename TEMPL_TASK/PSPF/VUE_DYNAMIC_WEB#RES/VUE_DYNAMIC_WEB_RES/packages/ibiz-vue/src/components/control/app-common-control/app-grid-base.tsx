import {
    IPSDEGridColumn,
    IPSDEGridEditItem,
    IPSDEGridUAColumn,
    IPSDEUIAction,
    IPSEditor,
    IPSSysPFPlugin,
    IPSUIActionGroupDetail,
    IPSAppDEGridView,
    IPSDEGridGroupColumn,
    IPSDEGridFieldColumn
} from '@ibiz/dynamic-model-api';
import { throttle, ModelTool, Util } from 'ibiz-core';
import { Prop, Watch, Emit } from 'vue-property-decorator';
import { GridControlBase } from '../../../widgets';

/**
 * 表格部件基类
 *
 * @export
 * @class AppGridBase
 * @extends {GridControlBase}
 */
export class AppGridBase extends GridControlBase {
    /**
     * 部件动态参数
     *
     * @memberof AppGridBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 部件静态参数
     *
     * @memberof AppGridBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppGridBase
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
     * @memberof AppGridBase
     */
    @Watch('staticProps', {
        immediate: true,
    })
    public onStaticPropsChange(newVal: any, oldVal: any) {
        if (newVal && !Util.isFieldsSame(newVal, oldVal)) {
            super.onStaticPropsChange(newVal, oldVal);
        }
    }

    public mounted() {
        setTimeout(() => {
            this.initEmptyColumn();
        });
    }
    
    /**
     * 销毁视图回调
     *
     * @memberof AppGridBase
     */
    public destroyed() {
        this.ctrlDestroyed();
    }

    /**
     * 部件事件
     *
     * @param {{ controlname: string; action: string; data: any }} { controlname 部件名称, action 事件名称, data 事件参数 }
     * @memberof AppGridBase
     */
    @Emit('ctrl-event')
    public ctrlEvent({ controlname, action, data }: { controlname: string; action: string; data: any }): void { }

    /**
     * 操作列动画
     *
     * @param {show: boolean}
     * @memberof AppGridBase
     */
    public showPoptip(show: boolean) {
        let cls: string = show ? "ivu-poptip app-control-grid__filter filter__tip--show" : "ivu-poptip app-control-grid__filter filter__tip--hide";
        (this.$refs.pageColumn as any).$el.setAttribute("class", cls);
    }

    /**
     * 计算表格行样式
     *
     * @memberof AppGridBase
     */
    public calcGridRowStyle(row: any, rowIndex: number) {
        if (this.ctrlTriggerLogicMap.get('calcrowstyle')) {
            return this.ctrlTriggerLogicMap.get('calcrowstyle').executeUILogic({ arg: { row, rowIndex } });
        }
    }

    /**
     * 计算表格单元格样式
     *
     * @memberof AppGridBase
     */
    public calcGridCellStyle(row: any, column: any, rowIndex: number, columnIndex: number) {
        if (this.ctrlTriggerLogicMap.get('calccellstyle')) {
            return this.ctrlTriggerLogicMap.get('calccellstyle').executeUILogic({ arg: { row, column, rowIndex, columnIndex } });
        }
    }

    /**
     * 计算表格头行样式
     *
     * @memberof AppGridBase
     */
    public calcGridHeaderRowStyle(row: any, rowIndex: number) {
        if (this.ctrlTriggerLogicMap.get('calcheaderrowstyle')) {
            return this.ctrlTriggerLogicMap.get('calcheaderrowstyle').executeUILogic({ arg: { row, rowIndex } });
        }
    }

    /**
     * 计算表格头单元格样式
     *
     * @memberof AppGridBase
     */
    public calcGridHeaderCellStyle(row: any, column: any, rowIndex: number, columnIndex: number) {
        if (this.ctrlTriggerLogicMap.get('calcheadercellstyle')) {
            return this.ctrlTriggerLogicMap.get('calcheadercellstyle').executeUILogic({ arg: { row, column, rowIndex, columnIndex } });
        }
    }

    /**
     * 计算表格头单元格样式表
     *
     * @memberof AppGridBase
     */
    public calcGridHeaderCellClassName(row: any, column: any, rowIndex: number, columnIndex: number) {
        const columnInstance: any = this.controlInstance.findPSDEGridColumn(column.property);
        if (columnInstance && columnInstance.getHeaderPSSysCss?.()?.cssName) {
            return columnInstance.getHeaderPSSysCss().cssName
        }
    }

    /**
     * 计算表格参数
     *
     * @memberof AppGridBase
     */
    public computeGridParams() {
        let options: any = {
            data: this.items,
            border: true,
            'high-light-current-row': this.controlInstance?.singleSelect,
            'show-header': !this.controlInstance.hideHeader && !Object.is(this.controlInstance.gridStyle, 'USER'),
            'row-class-name': ({ row, rowIndex }: any) => this.getRowClassName({ row, rowIndex }),
            'row-style': ({ row, rowIndex }: any) => this.calcGridRowStyle(row, rowIndex),
            'cell-style': ({ row, column, rowIndex, columnIndex }: any) =>
                this.calcGridCellStyle(row, column, rowIndex, columnIndex),
            'header-row-style': ({ row, rowIndex }: any) => this.calcGridHeaderRowStyle(row, rowIndex),
            'header-cell-style': ({ row, column, rowIndex, columnIndex }: any) =>
                this.calcGridHeaderCellStyle(row, column, rowIndex, columnIndex),
            'header-cell-class-name': (({row, column, rowIndex, columnIndex}: any) => this.calcGridHeaderCellClassName(row, column, rowIndex, columnIndex)),
            'cell-class-name': ({ row, column, rowIndex, columnIndex }: any) =>
                this.getCellClassName({ row, column, rowIndex, columnIndex }),
            "max-height": "100%",
            stripe: (this.controlInstance?.getParentPSModelObject?.() as IPSAppDEGridView)?.viewStyle == 'STYLE2' ? true : false,
        };
        const aggMode = this.controlInstance?.aggMode;
        //  支持排序
        if (!this.isNoSort) {
            Object.assign(options, {
                'default-sort': {
                    prop: this.minorSortPSDEF,
                    order: Object.is(this.minorSortDir, 'asc')
                        ? 'ascending'
                        : Object.is(this.minorSortDir, 'desc')
                            ? 'descending'
                            : '',
                },
            });
        }
        //  支持表格聚合
        if (aggMode && aggMode != 'NONE' && !this.controlInstance.getAggPSLayoutPanel()) {
            Object.assign(options, {
                'show-summary': true,
                'summary-method': (param: any) => this.getSummaries(param),
            });
        }
        //  支持分组
        if (this.isEnableGroup) {
            Object.assign(options, {
                'span-method': ({ row, column, rowIndex, columnIndex }: any) =>
                    this.arraySpanMethod({ row, column, rowIndex, columnIndex }),
                'tree-props': {
                    children: 'children',
                    hasChildren: 'children && children.length>0 ? true : false',
                },
                'row-key': 'groupById',
            });
        }
        return options;
    }

    /**
     * 计算表格事件
     *
     * @memberof AppGridBase
     */
    public computeGridEvents() {
        let events: any = {
            'row-click': (row: any, column: any, event: any) => throttle(this.rowClick, [row, column, event], this),
            'row-dblclick': (row: any, column: any, event: any) => throttle(this.rowDBLClick, [row, column, event], this),
            'select': (selection: any, row: any) => throttle(this.select, [selection, row], this),
            'select-all': (selection: any) => throttle(this.selectAll, [selection], this),
        };
        //  支持排序
        if (!this.controlInstance?.noSort) {
            if (this.Environment && this.Environment.isPreviewMode) {
                return;
            }
            Object.assign(events, {
                'sort-change': ({ column, prop, order }: any) => this.onSortChange({ column, prop, order }),
            });
        }
        return events;
    }

    /**
     * 获取内建行为权限
     *
     * @protected
     * @param {('add' | 'remove')} action
     * @return {*} 
     * @memberof AppGridBase
     */
    protected calcBuildInActionsAuth(action: 'add' | 'remove') {
        let state: boolean = false;
        const buildInActions: number = this.staticProps.buildInActions || 0;
        if (action == 'add') {
            if (
                buildInActions == 1 ||
                buildInActions == 3 ||
                buildInActions == 5 ||
                buildInActions == 7
            ) {
                state = true;
            }
        } else {
            if (
                buildInActions == 4 ||
                buildInActions == 5 ||
                buildInActions == 6 ||
                buildInActions == 7
            ) {
                state = true;
            }
        }
        return state;
    }

    /**
     * 绘制表格内容
     *
     * @param {*} h CreateElement对象
     * @memberof AppGridBase
     */
    public renderGridContent(h: any) {
        this.renderEmptyColumn = !this.allColumns.find((column: any) => {
            return column.columnType != 'GROUPGRIDCOLUMN' && column.show && Object.is(column.unit, 'STAR');
        });
        const cls = {'app-control-grid--rowactive': this.gridRowActiveMode == 1};
        return this.$createElement(
            'el-table',
            {
                props: this.computeGridParams(),
                on: this.computeGridEvents(),
                ref: `${this.realCtrlRefName}`,
                class: cls,
                scopedSlots: {
                    // 无数据插槽
                    empty: () => {
                        return this.renderEmptyDataTip();
                    }
                },
            },
            [
                !this.isSingleSelect && !this.localMode ? (
                    <el-table-column align='center' class-name="grid-column--selection" type='selection' width='64'></el-table-column>
                ) : null,
                this.renderMDCtrlActionColumn(),
                this.isEnableGroup ? (
                    <el-table-column
                        show-overflow-tooltip
                        prop='group'
                        label={this.$t('app.grid.group')}
                        min-width='80'
                        scopedSlots={{
                            default: (scope: any) => {
                                return <span>{scope.row.group}</span>;
                            },
                        }}
                    ></el-table-column>
                ) : null,
                this.renderGridColumns(this.allColumnsInstance),
                this.renderEmptyColumn ? <el-table-column class="grid-column--empty"></el-table-column> : null,
                this.renderSummaryPanel()
            ],
        );
    }

    /**
     * 渲染多数据部件行为列
     *
     * @return {*} 
     * @memberof AppGridBase
     */
    public renderMDCtrlActionColumn() {
        const showAdd = this.calcBuildInActionsAuth('add');
        const showRemove = this.calcBuildInActionsAuth('remove');
        if (!showAdd && !showRemove) {
            return null;
        }
        if (this.localMode) {
            return (
                <el-table-column align='center' class-name='grid-column__localaction' width='64' scopedSlots={{
                    header: ({ column, $index }: any) => {
                        return (
                            showAdd ?
                            <el-button
                                type='primary'
                                size='mini'
                                icon='el-icon-plus'
                                circle
                                on-click={() => {
                                    this.newRow([{}]);
                                }}>
                            </el-button> : null
                        )
                    },
                    default: ({ row, column, $index}: any) => {
                        return (
                            showRemove ?
                            <div class="grid-column__localaction__content">
                                <span class='grid-column__localaction__index'>{ $index + 1 }</span>
                                <el-button
                                    class='grid-column__localaction__remove'
                                    type='danger'
                                    size='mini'
                                    icon='el-icon-delete'
                                    circle
                                    on-click={() => {
                                        this.remove([row]);
                                    }}
                                ></el-button>
                            </div> : null
                        )
                    }
                }}>
                </el-table-column>
            )
        }
    }

    /**
     * 渲染聚合面板
     *
     * @memberof AppGridBase
     */
    public renderSummaryPanel() {
        const panel = this.controlInstance.getAggPSLayoutPanel();
        if (!panel) {
            return;
        }
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent } = this.computeTargetCtrlData(panel, this.remoteData);
        return this.$createElement(targetCtrlName, { slot: 'append', props: targetCtrlParam, on: targetCtrlEvent, ref: panel.name });
    }

    /**
     * 绘制表格列
     *
     * @param {*} h CreateElement对象
     * @memberof AppGridBase
     */
    public renderGridColumns(allColumnsInstance: IPSDEGridColumn[]) {
        if (!allColumnsInstance || allColumnsInstance.length === 0) {
            return;
        }
        return allColumnsInstance.map((item: IPSDEGridColumn) => {
            //隐藏表格项
            if (item.hideDefault || item.hiddenDataItem || !this.getColumnState(item.name)) {
                return null;
            }
            const plugin: IPSSysPFPlugin = item.getPSSysPFPlugin() as IPSSysPFPlugin;
            if (plugin) {
                if (Object.is('fileDownload', plugin.pluginCode)) {
                  return this.renderDownloadColumn(item);
                }
                const pluginInstance: any = this.PluginFactory.getPluginInstance('CONTROLITEM', plugin.pluginCode);
                if (pluginInstance) {
                    return pluginInstance.renderCtrlItem(this.$createElement, item, this, null);
                }
            } else {
                if (item.columnType == 'UAGRIDCOLUMN') {
                    return this.renderUAColumn(item as IPSDEGridUAColumn);
                } else if (item.columnType == 'DEFGRIDCOLUMN') {
                    //  数据列
                    return this.renderGridColumn(item);
                } else if (item.columnType == 'GROUPGRIDCOLUMN') {
                    //分组列
                    return this.renderGroupGridColumn(item as IPSDEGridGroupColumn);
                }
            }
        });
    }

    /**
     * @description 绘制预置表格列下载列插件
     * @param {IPSDEGridColumn} column 表格列
     * @memberof AppGridBase
     */
    public renderDownloadColumn(column: IPSDEGridColumn) {
      const { name, codeName, enableRowEdit, width, caption, widthUnit, align, enableSort } = column;
      const editItem: IPSDEGridEditItem = ModelTool.getGridItemByCodeName(
          codeName,
          this.controlInstance,
      ) as IPSDEGridEditItem;
      const sysImage = column.getPSSysImage();
      let renderParams: any = {
          label: this.$tl(column.getCapPSLanguageRes()?.lanResTag, caption),
          prop: name,
          align: align ? align.toLowerCase() : 'center',
          sortable: !this.controlInstance.noSort && enableSort ? 'custom' : false,
      };

      if (widthUnit && widthUnit != 'STAR') {
          renderParams['width'] = width;
      } else {
          renderParams['min-width'] = width;
      }
      return this.$createElement('el-table-column', {
          props: renderParams,
          scopedSlots: {
              default: (scope: any) => {
                  return this.actualIsOpenEdit && enableRowEdit && editItem
                      ? this.renderOpenEditItem(column, scope)
                      : this.renderDownload(column, scope);
              },
              header: () => {
                  this.allColumnsInstance; // 别删，触发表格头刷新用
                  return (
                      <span class='grid-column__header'>
                          {sysImage ? <i class={sysImage?.cssClass} style='margin-right: 4px;'></i> : null}
                          {this.$tl(column.getCapPSLanguageRes()?.lanResTag, caption)}
                      </span>
                  );
              },
          },
      });
    }

    /**
     * @description 绘制文件下载
     * @param {IPSDEGridColumn} item 列实例
     * @param {*} scope 插槽
     * @return {*} 
     * @memberof AppGridBase
     */
    renderDownload(item: IPSDEGridColumn, scope: any) {
      const fileList: any[] = scope.row[item.dataItemName] ? JSON.parse(scope.row[item.dataItemName]) : [];
      return (
        fileList.map((file: any) => {
          return (
            <div>
              <a 
                target="_blank"
                class="grid-column--download"
                href={`${this.downloadUrl}/${file.id}`}>
                  {file.name}
              </a>
            </div>
          )
        })  
      )
    }

    /**
     * 绘制操作列
     *
     * @param {any} column 表格列实例
     * @memberof AppGridBase
     */
    public renderUAColumn(column: IPSDEGridUAColumn) {
        if (this.viewStyle == 'DEFAULT' && column.columnStyle == "EXPAND") {
            return this.renderDefaultUAColumn(column);
        } else {
            return this.renderStyle2UAColumn(column);
        }
    }

    /**
     * 绘制DEFAULT的操作列
     *
     * @param {any} column 表格列实例
     * @memberof AppGridBase
     */
    public renderDefaultUAColumn(column: IPSDEGridUAColumn) {
        const { name, caption, align, width, widthUnit } = column;
        //参数
        let renderParams: any = {
            'column-key': name,
            label: this.$tl(column.getCapPSLanguageRes()?.lanResTag, caption),
            align: 'center',
            'class-name': 'grid-column--ua--default',
        };
        const sysImage = column.getPSSysImage();
        renderParams['width'] = 42;
        renderParams['fixed'] = 'right';
        //绘制
        return this.$createElement('el-table-column', {
            props: renderParams,
            scopedSlots: {
                default: (scope: any) => {
                    let offset = require('@popperjs/core/lib/modifiers/offset').default;
                    return <div class="grid-column--ua__content" on-mouseenter={(e: any) => {
                        let _offset = Object.assign({ options: { offset: [0, -48] } }, offset);
                        (this.$apppopover as any).openPopover2(e, () => this.renderActionButtons(column, scope), 'left', true, true, undefined, 48, "view-default grid-column--ua__popover", [_offset]);
                    }}>
                        <i class='el-icon-more popover__icon' ></i>
                    </div>
                },
                header: () => {
                    return (
                        <span class='grid-column--ua__header'>
                            {sysImage ? <i class={sysImage?.cssClass}></i> : null}
                            {this.$tl(column.getCapPSLanguageRes()?.lanResTag, caption)}
                        </span>
                    );
                },
            },
        });
    }

    /**
     * 绘制操作列按钮组
     *
     * @param {any} _column 表格列实例
     * @param {row, column, $index} scope 插槽返回数据
     * @memberof AppGridBase
     */
    public renderActionButtons(_column: IPSDEGridUAColumn, scope: any) {
        const UIActionGroupDetails: Array<IPSUIActionGroupDetail> =
            _column.getPSDEUIActionGroup()?.getPSUIActionGroupDetails() || [];
        const { row, column, $index } = scope;
        if (UIActionGroupDetails.length > 0) {
            return (
                <div class='grid-column--ua'>
                    {UIActionGroupDetails.map((uiactionDetail: IPSUIActionGroupDetail, index: number) => {
                        const uiaction: IPSDEUIAction = uiactionDetail.getPSUIAction() as IPSDEUIAction;
                        const actionModel = row[uiaction.uIActionTag];
                        let columnClass = {};
                        if (uiactionDetail.actionLevel) {
                            Object.assign(columnClass, { [`srfactionlevel${uiactionDetail.actionLevel}`]: true });
                        }
                        if (index === 0) {
                            Object.assign(columnClass, { 'column--first': true });
                        } else {
                            Object.assign(columnClass, { 'column__divider': true });
                        }
                        if (actionModel?.disabled) {
                            Object.assign(columnClass, { 'column__content--disabled': true });
                        } else {
                            Object.assign(columnClass, { 'column__content--normal': true });
                        }
                        if (Util.isEmpty(actionModel) || actionModel.visabled) {
                            return <i-button
                                disabled={!Util.isEmpty(actionModel) && actionModel.disabled}
                                class={columnClass}
                                on-click={($event: any) => {
                                    throttle(this.handleActionButtonClick, [row, $event, _column, uiactionDetail], this);
                                }}
                            >
                                {uiactionDetail.showIcon ? <menu-icon item={uiaction} /> : null}
                                {uiactionDetail.showCaption ? <span class='column__content__caption'>{this.$tl(uiaction.getCapPSLanguageRes()?.lanResTag, uiaction.caption)}</span> : ''}
                            </i-button>
                        }
                    })}
                </div>
            );
        }
    }


    /**
     * 绘制STYLE2的操作列
     *
     * @param {any} column 表格列实例
     * @memberof AppGridBase
     */
    public renderStyle2UAColumn(column: IPSDEGridUAColumn) {
        const { name, caption, align, width, widthUnit } = column;
        //参数
        let renderParams: any = {
            'column-key': name,
            'class-name': 'grid-column--ua grid-column--ua--style2',
            label: this.$tl(column.getCapPSLanguageRes()?.lanResTag, caption),
            align: align ? align.toLowerCase() : 'center',
        };
        const sysImage = column.getPSSysImage();
        if (widthUnit && widthUnit != 'STAR') {
            renderParams['width'] = width;
        } else {
            renderParams['min-width'] = width;
        }
        //视图样式2操作列需要悬浮  加fixed: right
        renderParams['fixed'] = 'right';
        //绘制
        return this.$createElement('el-table-column', {
            props: renderParams,
            scopedSlots: {
                default: (scope: any) => {
                    return this.renderActionModel(column, scope);
                },
                header: () => {
                    return (
                        <span class='grid-column--ua__header'>
                            {sysImage ? <i class={sysImage?.cssClass}></i> : null}
                            {this.$tl(column.getCapPSLanguageRes()?.lanResTag, caption)}
                        </span>
                    );
                },
            },
        });
    }

    /**
     * 绘制操作列内容
     *
     * @param {any} _column 表格列实例
     * @param {row, column, $index} scope 插槽返回数据
     * @memberof AppGridBase
     */
    public renderActionModel(_column: IPSDEGridUAColumn, scope: any) {
        const UIActionGroupDetails: Array<IPSUIActionGroupDetail> =
            _column.getPSDEUIActionGroup()?.getPSUIActionGroupDetails() || [];
        const { row, column, $index } = scope;
        if (UIActionGroupDetails.length > 0) {
            return (
                <div class="grid-column--ua__content">
                    {UIActionGroupDetails.map((uiactionDetail: IPSUIActionGroupDetail, index: number) => {
                        const uiaction: IPSDEUIAction = uiactionDetail.getPSUIAction() as IPSDEUIAction;
                        const actionModel = row[uiaction.uIActionTag];
                        let columnClass = {};
                        if (index === 0) {
                            Object.assign(columnClass, { 'column--first': true });
                        } else {
                            Object.assign(columnClass, { 'column__divider': true });
                        }
                        if (actionModel?.disabled) {
                            Object.assign(columnClass, { 'column__content--disabled': true });
                        } else {
                            Object.assign(columnClass, { 'column__content--normal': true });
                        }
                        if (Util.isEmpty(actionModel) || actionModel.visabled) {
                            if (!uiactionDetail.showCaption) {
                                return (
                                    <span title={this.$tl(uiaction.getCapPSLanguageRes()?.lanResTag, uiaction.caption)}>
                                        <a
                                            class={columnClass}
                                            disabled={!Util.isEmpty(actionModel) && actionModel.disabled}
                                            on-click={($event: any) => {
                                                throttle(this.handleActionClick, [row, $event, _column, uiactionDetail], this);
                                            }}
                                        >
                                            {uiactionDetail.showIcon ? (
                                                    uiaction && uiaction.getPSSysImage()?.cssClass?
                                                <i
                                                    class={
                                                         uiaction.getPSSysImage()?.cssClass
                                                    }
                                                ></i>
                                                :uiaction && uiaction.getPSSysImage()?.imagePath?
                                                <img src={uiaction.getPSSysImage()?.imagePath} alt="" />:<i
                                                class='fa fa-save'
                                            ></i>
                                            ) : (
                                                ''
                                            )}
                                        </a>
                                    </span>
                                );
                            } else {
                                return (
                                    <a
                                        class={columnClass}
                                        disabled={!Util.isEmpty(actionModel) && actionModel.disabled}
                                        on-click={($event: any) => {
                                            throttle(this.handleActionClick, [row, $event, _column, uiactionDetail], this);
                                        }}
                                    >
                                        {uiactionDetail.showIcon ? (
                                            <i class={uiaction?.getPSSysImage?.()?.cssClass}></i>
                                        ) : (
                                            ''
                                        )}
                                        {uiactionDetail.showCaption ? this.$tl(uiaction.getCapPSLanguageRes()?.lanResTag, uiaction.caption) : ''}
                                    </a>
                                );
                            }
                        }
                    })}
                </div>
            );
        }
    }

    /**
     * 绘制数据列
     *
     * @param {any} column 表格列实例
     * @memberof AppGridBase
     */
    public renderGridColumn(column: IPSDEGridColumn) {
        const { name, codeName, enableRowEdit, width, caption, widthUnit, align, enableSort } = column;
        const editItem: IPSDEGridEditItem = ModelTool.getGridItemByCodeName(
            codeName,
            this.controlInstance,
        ) as IPSDEGridEditItem;
        const sysImage = column.getPSSysImage();
        let renderParams: any = {
            label: this.$tl(column.getCapPSLanguageRes()?.lanResTag, caption),
            prop: name,
            align: align ? align.toLowerCase() : 'center',
            sortable: !this.controlInstance.noSort && enableSort ? 'custom' : false,
        };
        if (widthUnit && widthUnit != 'STAR') {
            renderParams['width'] = width;
        } else {
            renderParams['min-width'] = width;
        }
        return this.$createElement('el-table-column', {
            props: renderParams,
            scopedSlots: {
                default: (scope: any) => {
                    return this.actualIsOpenEdit && enableRowEdit && editItem
                        ? this.renderOpenEditItem(column, scope)
                        : this.renderColumn(column, scope);
                },
                header: () => {
                    this.allColumnsInstance; // 别删，触发表格头刷新用
                    return (
                        <span class='grid-column__header'>
                            {sysImage ? <i class={sysImage?.cssClass}></i> : null}
                            {this.$tl(column.getCapPSLanguageRes()?.lanResTag, caption)}
                        </span>
                    );
                },
            },
        });
    }

    /**
     * 绘制分组列
     *
     * @param {IPSDEGridGroupColumn} column 表格分组列实例对象
     * @memberof AppGridBase
     */
    public renderGroupGridColumn(column: IPSDEGridGroupColumn): any {
        const { name, width, caption, widthUnit, align, enableSort } = column;
        let renderParams: any = {
            'show-overflow-tooltip': true,
            label: this.$tl(column.getCapPSLanguageRes()?.lanResTag, caption),
            prop: name,
            align: align ? align.toLowerCase() : 'center',
            sortable: !this.controlInstance.noSort && enableSort ? 'custom' : false,
        };
        const sysImage = column.getPSSysImage();
        if (widthUnit && widthUnit != 'STAR') {
            renderParams['width'] = width;
        } else {
            renderParams['min-width'] = width;
        }
        return this.$createElement('el-table-column', {
            props: renderParams,
            scopedSlots: {
                header: () => {
                    return (
                        <span class='grid-column__header'>
                            {sysImage ? <i class={sysImage?.cssClass}></i> : null}
                            {this.$tl(column.getCapPSLanguageRes()?.lanResTag, caption)}
                        </span>
                    );
                },
            },
        }, this.renderGridColumns(column.getPSDEGridColumns() || []));
    }

    /**
     * 绘制分页栏
     *
     * @param {*} h CreateElement对象
     * @memberof AppGridBase
     */
    public renderPagingBar(h: any) {
        // 表格列筛选
        let columnPopTip;
        // 分页显示文字
        let pageText = <span>{this.$t('app.dataview.sum')}&nbsp;{this.totalRecord}&nbsp;{this.$t('app.dataview.data')}</span>
        if (this.viewStyle == 'STYLE2') {
            pageText = <span>
                &nbsp; {this.$t('app.grid.show')}&nbsp;
                {this.items.length > 0 ? 1 : (this.curPage - 1) * this.limit + 1}&nbsp;-&nbsp;
                {this.totalRecord > this.curPage * this.limit ? this.curPage * this.limit : this.totalRecord}&nbsp;
                {this.$t('app.dataview.data')}，{this.$t('app.dataview.sum')}&nbsp;{this.totalRecord}&nbsp;{this.$t('app.dataview.data')}
            </span>
            columnPopTip = <poptip transfer placement='top-start' class='page-column'>
                <i-button icon='md-menu'>{this.$t('app.grid.choicecolumns')}</i-button>
                <div slot='content'>
                    {this.allColumns.map((col: any) => {
                        return (
                            col.columnType != "UAGRIDCOLUMN" ?
                                <div>
                                    <el-checkbox
                                        key={col.name}
                                        v-model={col.show}
                                        on-change={this.onColChange.bind(this)}
                                    >
                                        {col.label}
                                    </el-checkbox>
                                </div> : null
                        );
                    })}
                </div>
            </poptip>
        } else {
            pageText = <span>{this.$t('app.dataview.sum')}&nbsp;{this.totalRecord}&nbsp;{this.$t('app.dataview.data')}</span>
        }
        return this.items?.length > 0 ? (
            <row class='app-control-grid__pagination control-footer'>
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
                    {this.controlInstance.enableColFilter ? columnPopTip : null}
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
     * 绘制表格列过滤
     *
     * @memberof AppGridBase
     */
    public renderColumnFilter() {
        if (this.viewStyle == 'DEFAULT') {
            let ifShow = !!this.allColumnsInstance.find((item: IPSDEGridColumn) => item.columnType == 'UAGRIDCOLUMN' && item.columnStyle == 'EXPAND');
            if (!ifShow) {
                return
            }
            return <poptip transfer ref='pageColumn' placement='bottom-end' class='app-control-grid__filter' on-on-popper-show={() => this.showPoptip(true)} on-on-popper-hide={() => this.showPoptip(false)}>
                <icon type="md-options" />
                <div slot='content'>
                    <draggable value={this.allColumns} animation={300} handle='.handle-icon' on-change={({ moved }: any) => {
                        Util.changeIndex(this.allColumns, moved.oldIndex, moved.newIndex);
                        Util.changeIndex(this.allColumnsInstance, moved.oldIndex, moved.newIndex);
                    }}>
                        {this.allColumns.map((col: any) => {
                            return (
                                col.columnType != "UAGRIDCOLUMN" ?
                                    <div class='column--filter-item'>
                                        <el-checkbox
                                            key={col.name}
                                            v-model={col.show}
                                            on-change={this.onColChange.bind(this)}
                                        >
                                            {col.label}
                                        </el-checkbox>
                                        <icon type="md-menu handle-icon" />
                                    </div> : null
                            );
                        })}
                    </draggable>
                </div>
            </poptip>
        }
    }

    /**
     * 行编辑绘制
     *
     * @param {any} item 表格列实例
     * @param {row，column, $index} scope 插槽返回数据
     * @memberof AppGridBase
     */
    public renderOpenEditItem(item: IPSDEGridColumn, scope: any) {
        const editItem: IPSDEGridEditItem = ModelTool.getGridItemByCodeName(
            item.codeName,
            this.controlInstance,
        ) as IPSDEGridEditItem;
        let editor: IPSEditor | null = editItem?.getPSEditor();
        if (!editor) {
            return null;
        }
        const valueFormat = (item as IPSDEGridFieldColumn).valueFormat;
        const { row, column, $index } = scope;
        return (
            <app-form-item gridError={this.gridItemsModel[$index]?.[column.property]?.error}>
                <app-default-editor
                    name={ModelTool.getGridDataColName(item as IPSDEGridFieldColumn)}
                    editorInstance={editor}
                    ref={editor.name}
                    parentItem={editItem}
                    value={row[editor?.name]}
                    disabled={this.getColumnDisabled(row, editor?.name)}
                    context={this.context}
                    contextData={row}
                    viewparams={this.viewparams}
                    valueFormat={valueFormat}
                    service={this.service}
                    on-change={(value: any) => {
                        this.onGridItemValueChange(row, value, $index);
                    }}
                    on-blur={(value: any) => {
                        this.gridDetailBlur(row, value, $index);
                    }}
                    on-focus={(value: any) => {
                        this.gridDetailFocus(row, value, $index);
                    }}
                    on-click={(value: any) => {
                        this.gridDetailClick(row, value, $index);
                    }}
                />
            </app-form-item>
        );
    }

    /**
     * 绘制数据表格列
     *
     * @memberof AppGridBase
     */
    public renderColumn(item: IPSDEGridColumn, scope: any) {
        return (
            <app-grid-column
                row={scope.row}
                index={scope.$index}
                columnInstance={item}
                gridInstance={this.controlInstance}
                context={this.context}
                modelService={this.modelService}
                viewparams={this.viewparams}
                appUIService={this.appUIService}
                on-uiAction={($event: any) => this.columnUIAction(scope.row, $event, item)}
            ></app-grid-column>
        );
    }

    /**
     * 绘制
     *
     * @param {*} h CreateElement对象
     * @memberof AppGridBase
     */
    public render(h: any) {
        if (!this.controlIsLoaded || !this.controlInstance) {
            return null;
        }
        const { controlClassNames } = this.renderOptions;
        return (
            <div class={{ ...controlClassNames,'app-control-grid--no-paging-bar': !this.controlInstance?.enablePagingBar }}>
                {
                  Object.is("USER", this.controlInstance.gridStyle) ? 
                  <app-pq-grid
                    data={this.items}
                    aggMode={this.aggMode}
                    remoteData={this.remoteData}
                    context={this.context}
                    viewparams={this.viewparams}
                    rowEdit={this.actualIsOpenEdit}
                    gridInstance={this.controlInstance}
                    gridRowActiveMode={this.gridRowActiveMode}
                    gridItemsModel={this.gridItemsModel}
                    curPage={this.curPage}
                    pageSize={this.limit}
                    modelService={this.modelService}
                    appUIService={this.appUIService}
                    totalRecord={this.totalRecord}
                    on-actionClick={(data: any, event: any, column: any, detail: any) => {this.handleActionClick(data, event, column, detail)}}
                    on-rowClick={(row: any) => {this.rowClick(row)}}
                    on-rowDblclick={(row: any) => {this.rowDBLClick(row)}}
                    on-rowSelect={($event: any[]) => {this.selectAll($event)}}
                    on-pageChange={($event: any) => {this.pageOnChange($event)}}
                    on-pageRefresh={($event: any) => {this.pageRefresh()}}
                    on-uiAction={(row: any, $event: any, column: number) => {this.columnUIAction(row, $event, column)}}
                    on-valueChange={(row: any, $event: any, rowIndex: number) => this.onGridItemValueChange(row, $event, rowIndex)}
                    on-pageSizeChange={($event: any) => {this.onPageSizeChange($event)}}>
                  </app-pq-grid> : [
                  <i-form class="control-content">
                    {
                        !this.ctrlLoadingService?.isLoading ? this.renderGridContent(h) : this.renderLoadDataTip()
                    }
                  </i-form>,
                    this.controlInstance?.enablePagingBar && !Object.is(this.controlInstance?.gridStyle, 'USER') ? this.renderPagingBar(h) : '',
                    this.items?.length > 0 ? this.renderColumnFilter() : null
                  ]
                }
            </div>
        );
    }
}
