import pq from "pqgridf";
import 'jquery-ui-pack/jquery-ui.css';
import 'jquery-ui-pack/jquery-ui.structure.css';
import 'jquery-ui-pack/jquery-ui.theme.css';
import 'pqgridf/pqgrid.min.css';
import 'pqgridf/pqgrid.ui.min.css';
import 'pqgridf/themes/steelblue/pqgrid.css';
import { ModelTool, Util, AppServiceBase } from "ibiz-core";
import { Vue, Component, Prop, Watch } from "vue-property-decorator";
import {
  IPSDEGrid,
  IPSDEGridColumn,
  IPSDEGridEditItem,
  IPSDEGridFieldColumn,
  IPSDEGridGroupColumn,
  IPSDEGridUAColumn,
  IPSDEUIAction,
  IPSEditor,
  IPSUIActionGroupDetail
} from "@ibiz/dynamic-model-api";

@Component({})
export default class AppPQGrid extends Vue {
  /**
   * 上下文
   *
   * @type {any}
   * @memberof AppPQGrid
   */
  @Prop() public context!: any;

  /**
   * 视图参数
   *
   * @type {any}
   * @memberof AppPQGrid
   */
  @Prop() public viewparams!: any;

  /**
   * 表格部件服务对象
   *
   * @type {*}
   * @memberof AppPQGrid
   */
  @Prop() public service: any;

  /**
   * 表格实例
   *
   * @type {any}
   * @memberof AppPQGrid
   */
  @Prop() public gridInstance!: IPSDEGrid;

  /**
   * 表格项模型集合
   *
   * @type {any}
   * @memberof AppPQGrid
   */
  @Prop() public gridItemsModel!: any[];

  /**
   * 表格数据
   *
   * @type {any[]}
   * @memberof AppPQGrid
   */
  @Prop() public data!: any[];

  /**
   * 数据总条数
   *
   * @type {number}
   * @memberof AppPQGrid
   */
  @Prop({ default: 0 }) public totalRecord!: number;

  /**
   * 分页大小
   *
   * @type {number}
   * @memberof AppPQGrid
   */
  @Prop({ default: 20 }) public pageSize!: number;

  /**
   * 当前页码
   *
   * @type {number}
   * @memberof AppPQGrid
   */
  @Prop({ default: 1 }) public curPage!: number;

  /**
   * 表格行激活模式
   * 0 不激活
   * 1 单击激活
   * 2 双击激活
   * @type {number}
   * @memberof AppPQGrid
   */
  @Prop({ default: 2 }) public gridRowActiveMode!: number;

  /**
   * 模型服务
   *
   * @type {number}
   * @memberof AppPQGrid
   */
  @Prop() public modelService: any;

  /**
   * 界面服务
   *
   * @type {number}
   * @memberof AppPQGrid
   */
  @Prop() public appUIService: any;

  /**
   * @description 是否启用列宽自适应
   * @type {boolean}
   * @memberof AppPQGrid
   */
  @Prop({ default: false }) public columnWidthAdaptive!: boolean;

  /**
   * @description 是否实际开启行编辑
   * @type {boolean}
   * @memberof AppPQGrid
   */
  @Prop({ default: false }) public rowEdit!: boolean;

  /**
   * @description 聚合模式
   * @type {string}
   * @memberof AppPQGrid
   */
  @Prop() public aggMode!: string;

  /**
   * @description 远程聚合数据
   * @type {*}
   * @memberof AppPQGrid
   */
  @Prop() public remoteData: any;

  /**
   * 当前表格id
   * 
   * @type {string}
   * @memberof AppPQGrid
   */
  public id: string = Util.createUUID();

  /**
   * pqGrid 表格对象实例
   * 
   * @type {string}
   * @memberof AppPQGrid
   */
  public pqGrid: any;

  /**
   * pqPager 表格分页对象实例
   * 
   * @type {string}
   * @memberof AppPQGrid
   */
  public pqPager: any;

  /**
   * 表格编辑项
   * 
   * @type {string}
   * @memberof AppPQGrid
   */
  public editItems: any[] = [];

  /**
   * 所有列实例
   * 
   * @type {string}
   * @memberof AppPQGrid
   */
  public columnInstances: IPSDEGridColumn[] = [];

  /**
   * @description 列数据计数map
   * @type {Map<string,number>}
   * @memberof AppPQGrid
   */
  public colDataMap: Map<string,number> = new Map();

  /**
   * 监听表格数据变化
   *
   * @param newVal 新值
   * @param oldVal 旧值
   * @memberof AppPQGrid
   */
  @Watch('data', { immediate: true, deep: true })
  public dataChange(newVal: any[], oldVal: any[]) {
    if (this.pqGrid) {
      this.pqGrid.option({ dataModel: { data: Util.deepCopy(newVal) } });
      this.pqGrid.refreshView();
      this.setPQPager();
    }
  }

  /**
   * 监听行编辑变化
   *
   * @param newVal 新值
   * @param oldVal 旧值
   * @memberof AppPQGrid
   */
  @Watch('rowEdit', { immediate: true, deep: true })
  public rowEditChange(newVal: boolean, oldVal: boolean) {
    if (this.pqGrid && this.editItems.length > 0) {
      if (newVal) {
        this.pqGrid.editCell({ rowIndx: 0, dataIndx: this.editItems[0] });
        this.pqGrid.refreshRow({ rowIndx: 0 });
      } else {
        this.pqGrid.quitEditMode();
      }
    }
  }

  /**
   * @description 代码表列加载完成
   * @param {IPSDEGridColumn} colInstance
   * @param {number} dataItemName
   * @memberof AppPQGrid
   */
  public codeListLoadFinish(colInstance: IPSDEGridColumn,dataItemName: string) {
    if (this.colDataMap.has(colInstance.codeName)) {
      const value: number = this.colDataMap.get(colInstance.codeName) || 0;
      this.colDataMap.set(colInstance.codeName,value+1);
      if (value == this.pageSize) {
        this.pqGrid.flex({dataIndx: [dataItemName]});
      }
    } else {
      this.colDataMap.set(colInstance.codeName,1);
    }
  }

  /**
   * 设置表格分页
   *
   * @memberof AppPQGrid
   */
  public setPQPager() {
    if (this.pqPager) {
      const options = {
        curPage: this.curPage,
        rPP: this.pageSize,
        totalPages: Math.ceil(this.totalRecord / this.pageSize),
        totalRecords: Util.deepCopy(this.totalRecord),
      }
      this.pqPager.option(options);
    }
  }

  /**
   * Vue 生命周期
   * 
   * @memberof AppPQGrid
   */
  mounted() {
    if (this.gridInstance) {
      this.initPQGrid();
      this.initGridEvent();
      this.initAllColumns();
    }
  }

    /**
     * @description 组件销毁
     * @memberof AppPQGrid
     */
    destroyed() {
        if (this.pqGrid) {
            this.pqGrid.destroy();
        }
        if (this.pqPager) {
            this.pqPager.destroy();
        }
        this.pqGrid = null;
        this.pqPager = null;
    }

  /**
   * 初始化PQGrid
   * 
   * @memberof AppPQGrid
   */
  initPQGrid() {
    const options = {
      menuIcon: true,
      numberCell: { show: false },
      width: this.gridInstance.width ? this.gridInstance.width : "100%",
      height: this.gridInstance.height ? this.gridInstance.height : "100%",
      colModel: this.initPQGridCol(),
      dataModel: { location: "local" },
      postRenderInterval: -1,
    }
    //  表格列自适应
    if (this.columnWidthAdaptive) {
      Object.assign(options, { flex: { on: true } })
    }
    if (this.gridInstance.enablePagingBar) {
      Object.assign(options, {
        pageModel: {
          type: "local",
          rPP: this.pageSize,
        }
      });
    }
    if (this.gridInstance.enableGroup) {
      Object.assign(options, {
        groupModel: {
          on: true,
          dataIndx: [this.gridInstance.getGroupPSAppDEField()?.codeName.toLowerCase()],
          collapsed: [true],
          title: [
            "{0} ({1})",
            "{0} - {1}"
          ]
        }
      });
    }
    this.pqGrid = pq.grid(`#${this.id}`, options);
    this.pqPager = this.pqGrid.pager();
  }

  /**
   * 初始化PQGrid事件
   * 
   * @memberof AppPQGrid
   */
  initGridEvent() {
    if (this.pqGrid) {
      this.pqGrid.on("check", ($event: any, ui: any) => {
        this.rowSelect($event, ui);
      });
      this.pqGrid.on("dataReady", ($event: any, ui: any) => {
        this.calculateSummary($event, ui);
      });
      this.pqGrid.on("change", ($event: any, ui: any) => {
        this.calculateSummary($event, ui);
      });
      this.pqGrid.on("group", ($event: any, ui: any) => {
        this.$nextTick(() => {
          this.setPQPager();
        })
      });
      this.pqGrid.on("editorBegin", ($event: any, ui: any) => {
        this.editorBegin($event, ui);
      });
      this.pqGrid.on("sort", ($event: any, ui: any) => {
        this.$nextTick(() => {
          this.setPQPager();
        })
      });
      this.pqGrid.on("rowClick", ($event: any, ui: any) => {
        this.rowClick($event, ui);
      });
      this.pqGrid.on("rowDblClick", ($event: any, ui: any) => {
        this.rowDblClick($event, ui);
      });
      this.pqGrid.on("refresh", ($event: any, ui: any) => {
        this.$nextTick(() => {
          this.setPQPager();
        })
        if (this.columnWidthAdaptive && !Object.is(ui.source,'flex')) {
          this.pqGrid.flex();
        }
      });
    }
    if (this.pqPager) {
      this.pqPager.on("change", ($event: any, ui: any) => {
        this.pageChange($event, ui);
      });
      this.pqPager.on("refresh", ($event: any, ui: any) => {
        this.pageRefresh($event, ui);
      });
    }
  }

  /**
   * 初始化所有列
   * 
   * @memberof AppPQGrid
   */
  initAllColumns() {
    this.columnInstances = [];
    const columns = this.gridInstance.getPSDEGridColumns() as IPSDEGridColumn[];
    const init = (columns: IPSDEGridColumn[]) => {
      columns.forEach((column: IPSDEGridColumn) => {
        if (Object.is(column.columnType,'GROUPGRIDCOLUMN')) {
          init((column as IPSDEGridGroupColumn).getPSDEGridColumns() as IPSDEGridColumn[]);
        } else {
          this.columnInstances.push(column);
        }
      })
    }
    init(columns);
  }

  /**
   * 初始化PQGrid表格列
   * 
   * @memberof AppPQGrid
   */
  initPQGridCol() {
    let colModel: any[] = [
      {
        type: "checkbox",
        align: "center",
        dataType: "bool",
        dataIndx: "pqGridSelect",
        sortable: false, 
        editor: false,
        cb: { all: false, header: true, select: true },
        render: (ui: any) => {
          if (ui.rowData.summaryRow) {
            return {
              text: "数据聚合"
            };
          }
        },
      }
    ];
    if (this.gridInstance.enableGroup) {
      const groupColModel = {
        width: 120,
        align: "center",
        title: this.$t('app.grid.group'),
        editable: false,
        sortable: false,
        dataIndx: this.gridInstance.getGroupPSAppDEField()?.name.toLowerCase(),
        render: (ui: any) => {
          if (ui.rowData.summaryRow) {
            return {
              text: "<span style='display: none'></span>"
            };
          }
        },
      }
      colModel.push(groupColModel);
    }
    const otherColModel = this.initColModel(this.gridInstance.getPSDEGridColumns() as IPSDEGridColumn[]);
    colModel = colModel.concat(otherColModel);
    return colModel;
  }

  /**
   * 初始化PQGrid列模型
   * 
   * @param columnsInstance 表格列实例集合
   * @memberof AppPQGrid
   */
  initColModel(columnsInstance: IPSDEGridColumn[]): any[] {
    const colModels: any[] = [];
    if (columnsInstance.length > 0) {
      columnsInstance.forEach((colInstance: IPSDEGridColumn) => {
        const colModel = {
          title: this.$tl(colInstance.getCapPSLanguageRes()?.lanResTag, colInstance.caption),
          align: colInstance.align ? colInstance.align.toLowerCase() : "center",
          hidden: colInstance.hideDefault || colInstance.hiddenDataItem,
          sortable: !this.gridInstance.noSort && colInstance.enableSort,
          editable: this.gridInstance.enableRowEdit && colInstance.enableRowEdit,
        }
        if (!this.columnWidthAdaptive) {
          if (colInstance.widthUnit && !Object.is("STAR", colInstance.widthUnit)) {
            Object.assign(colModel, {
              width: colInstance.width ? colInstance.width : 150,
            });
          } else {
            Object.assign(colModel, {
              minWidth: colInstance.width ? colInstance.width : 150,
            });
          }
        }
        if (Object.is("UAGRIDCOLUMN", colInstance.columnType)) {
          this.initUAColumn(colModel, colInstance as IPSDEGridUAColumn);
        } else if (Object.is("DEFGRIDCOLUMN", colInstance.columnType)) {
          this.initDataColumn(colModel, colInstance);
        } else if (Object.is("GROUPGRIDCOLUMN", colInstance.columnType)) {
          this.initGroupColumn(colModel, colInstance as IPSDEGridGroupColumn);
        } else {
          Object.assign(colModel, {
            hidden: true,
          })
        }
        colModels.push(colModel);
      });
    }
    return colModels;
  }

  /**
   * 初始化分组列
   * 
   * @param colModel 列模型
   * @param colInstance 列实例
   * @memberof AppPQGrid
   */
  initGroupColumn(colModel: any, colInstance: IPSDEGridGroupColumn) {
    const gridColumns: IPSDEGridColumn[] = colInstance.getPSDEGridColumns() as IPSDEGridColumn[];
    Object.assign(colModel, {
      colModel: this.initColModel(gridColumns),
    })
  }

  /**
   * 初始化数据列
   * 
   * @param colModel 列模型
   * @param colInstance 列实例
   * @memberof AppPQGrid
   */
  initDataColumn(colModel: any, colInstance: IPSDEGridColumn) {
    const editItem: IPSDEGridEditItem = ModelTool.getGridItemByCodeName(
      colInstance.codeName,
      this.gridInstance,
    ) as IPSDEGridEditItem;
    const editor: IPSEditor | null = editItem?.getPSEditor();
    const valueFormat = (colInstance as IPSDEGridFieldColumn).valueFormat;
    this.editItems.push(colInstance.dataItemName);
    Object.assign(colModel, {
      dataIndx: colInstance.dataItemName,
      render: (ui: any) => {
        if (!ui.rowData.summaryRow) {
          return {
            text: "<span style='display: none'></span>"
          };
        }
      },
      postRender: (ui: any) => {
        const cell = this.pqGrid.getCell(ui);
        const dataColumn = this.renderDataColumn(ui, colInstance);
        cell[0].appendChild(dataColumn.$el);
      },
      editor: {
        type: (ui: any) => {
          if (editor && this.rowEdit) {
            const editorColumn = this.renderEditColumn(ui, editItem, editor, valueFormat);
            ui.$cell[0].appendChild(editorColumn.$el);
          } else {
            const dataColumn = this.renderDataColumn(ui, colInstance);
            ui.$cell[0].appendChild(dataColumn.$el);
          }
        },
      }
    });
  }

  /**
   * 计算编辑列启用状态
   * 
   * @param editItem 行数据
   * @param editItem 编辑列
   * @memberof AppPQGrid
   */
  calcEditDisabled(rowData: any, editItem: IPSDEGridEditItem): boolean {
    switch (editItem.enableCond) {
      case 0:
        return false;
      case 1:
        return rowData.srfuf != 0;
      case 2:
        return rowData.srfuf != 1;
      case 3:
        return false;
      default:
        return false;
    }
  }

  /**
   * 初始化操作列
   * 
   * @param colModel 列模型
   * @param colInstance 列实例
   * @memberof AppPQGrid
   */
  initUAColumn(colModel: any, colInstance: IPSDEGridUAColumn) {
    const UIActionGroupDetails: Array<IPSUIActionGroupDetail> =
      colInstance.getPSDEUIActionGroup()?.getPSUIActionGroupDetails() || [];
    Object.assign(colModel, {
      render: (ui: any) => {
        let uiAction = "";
        if (!ui.rowData.summaryRow) {
          if (UIActionGroupDetails.length > 0) {
            UIActionGroupDetails.forEach((uiactionDetail: IPSUIActionGroupDetail) => {
              const uiaction: IPSDEUIAction = uiactionDetail.getPSUIAction() as IPSDEUIAction;
              const actionModel = ui.rowData[uiaction.uIActionTag];
              if (actionModel?.visabled) {
                uiAction +=
                  `<button
                  type='button'
                  actiontag='${uiaction.uIActionTag}'
                  class='ui-button ${!actionModel.disabled ? 'ui-state-default' : ''}'>
                  ${uiactionDetail.showIcon ?
                    uiaction?.getPSSysImage()?.cssClass ? '<i class="' + uiaction?.getPSSysImage?.()?.cssClass + '" ></i>'
                      : uiaction?.getPSSysImage()?.imagePath ? '<img src="' + uiaction.getPSSysImage()?.imagePath + '" />'
                        : ''
                    : ''
                  }
                  <span class='ui-button-text'>
                    ${this.$tl(uiaction.getCapPSLanguageRes()?.lanResTag, uiaction.caption)}
                  </span>
                </button>`
              }
            })
          }
        }
        return uiAction;
      },
      postRender: (ui: any) => {
        const cell = this.pqGrid.getCell(ui);
        cell.find("button").bind("click", ($event: any) => {
          const attributes: any[] = $event.currentTarget?.attributes;
          if (attributes?.length > 0) {
            attributes.forEach((attribute: any) => {
              if (Object.is('actiontag', attribute.name)) {
                const action = UIActionGroupDetails.find((uiactionDetail: IPSUIActionGroupDetail) => {
                  const uiaction: IPSDEUIAction = uiactionDetail.getPSUIAction() as IPSDEUIAction;
                  return Object.is(uiaction.uIActionTag, attribute.value);
                })
                if (action) {
                  this.$emit("actionClick", ui.rowData, $event, colInstance, action);
                }
              }
            })
          }
        })
      },
    })
  }

  /**
   * 表格行选中
   * 
   * @param $event 事件源
   * @param ui ui数据
   * @memberof AppPQGrid
   */
  rowSelect($event: any, ui: any) {
    if (ui.rows && ui.rows.length > 0) {
      const rows: any[] = ui.rows;
      const selections: any[] = [];
      rows.forEach((row: any) => {
        if (row.rowData && row.rowData['pqGridSelect']) {
          const selectData = this.data.find((item: any) => Object.is(item.srfkey, row.rowData['srfkey']));
          if (selectData) {
            selections.push(selectData);
          }
        }
      });
      this.$emit("rowSelect", selections);
    }
  }

  /**
   * 页面变化
   * 
   * @param $event 事件源
   * @param ui ui数据
   * @memberof AppPQGrid
   */
  pageChange($event: any, ui: any) {
    // 页码变化
    if (ui.curPage) {
      this.$emit("pageChange", ui.curPage);
    }
    // 分页条数变化
    if (ui.rPP) {
      this.$emit("pageChange", 1);
      this.$emit("pageSizeChange", Number(ui.rPP));
    }
  }

  /**
   * 分页刷新
   * 
   * @param $event 事件源
   * @param ui ui数据
   * @memberof AppPQGrid
   */
  pageRefresh($event: any, ui: any) {
    this.$emit("pageRefresh", $event);
  }

  /**
   * 表格项值改变
   * 
   * @param row 行数据
   * @param $event 数据
   * @param rowIndex 行号
   * @memberof AppPQGrid
   */
  onGridItemValueChange(row: any, $event: any, rowIndex: number) {
    this.$emit("valueChange", row, $event, rowIndex);
  }

  /**
   * 行单击
   * 
   * @param $event 事件源
   * @param ui ui数据
   * @memberof AppPQGrid
   */
  rowClick($event: any, ui: any) {
    if (this.gridRowActiveMode == 2 || this.gridRowActiveMode == 0) {
      this.pqGrid.setSelection({ rowIndx: ui.rowIndx, focus: false })
    }
    const selectData = this.data.find((item: any) => Object.is(item.srfkey, ui.rowData['srfkey']));
    this.$emit("rowClick", selectData);
  }

  /**
   * 行双击
   * 
   * @param $event 事件源
   * @param ui ui数据
   * @memberof AppPQGrid
   */
  rowDblClick($event: any, ui: any) {
    const selectData = this.data.find((item: any) => Object.is(item.srfkey, ui.rowData['srfkey']));
    this.$emit("rowDblclick", selectData);
  }

  /**
   * 开始编辑时触发
   * 
   * @param $event 事件源
   * @param ui ui数据
   * @memberof AppPQGrid
   */
  editorBegin($event: any, ui: any) {
    if (!this.rowEdit) {
      this.pqGrid.quitEditMode();
    }
  }

  /**
   * 计算表格聚合
   * 
   * @param $event 事件源
   * @param ui ui数据
   * @memberof AppPQGrid
   */
  calculateSummary($event: any, ui: any) {
    if (!Object.is(this.aggMode, "NONE")) {
      let aggData: any = {
        summaryRow: true,
      };
      if (Object.is(this.aggMode, "PAGE")) {
        const data: any[] = this.pqGrid.getData();
        this.columnInstances.forEach((column: IPSDEGridColumn) => {
          if (column.dataItemName) {
            Object.assign(aggData, {
              [column.dataItemName]: this.getAggValue(data, column),
            })
          }
        })
      } else if (Object.is(this.aggMode, "ALL") && this.remoteData) {
        this.columnInstances.forEach((column: IPSDEGridColumn) => {
          if (column.dataItemName) {
            Object.assign(aggData, {
              [column.dataItemName]: this.getAggValue(this.remoteData, column),
            })
          }
        })
      }
      this.pqGrid.option({ summaryData: [aggData] });
    }
  }

  /**
   * 获取聚合数据
   * 
   * @param aggData 聚合数据
   * @param column 列模型
   * @memberof AppPQGrid
   */
  getAggValue(aggData: any, column: IPSDEGridColumn): string {
    switch (column.aggMode) {
      case "NONE":
          return "";
      case "SUM":
          let sum: number = 0;
          if (Object.is(this.aggMode, 'PAGE')) {
            aggData.forEach((item: any) => {
                sum += Number(item[column.dataItemName] ? item[column.dataItemName] : 0);
            })
          } else {
            sum = Number(aggData[column.dataItemName]);
          }
          return "SUM:" + sum;
      case "AVG":
          let avg: number = 0;
          if (Object.is(this.aggMode, 'PAGE')) {
            let sum2: number = 0;
            aggData.forEach((item: any) => {
                sum2 += Number(item[column.dataItemName] ? item[column.dataItemName] : 0);
            })
            avg = Number(Number(sum2 / (aggData.length)).toFixed(3));
          } else {
            avg = Number(aggData[column.dataItemName]);
          }
          return "AVG:" + avg;
      case "MAX":
          let max: number = 0;
          if (Object.is(this.aggMode, 'PAGE')) { 
            aggData.forEach((item: any) => {
                const value: number = Number(item[column.dataItemName] ? item[column.dataItemName] : 0);
                if (value > max) {
                    max = value;
                }
            })
          } else {
            max = Number(aggData[column.dataItemName]);
          }
          return "MAX:" + max;
      case "MIN":
          let min: number = 0;
          if (Object.is(this.aggMode, 'PAGE')) {
            aggData.forEach((item: any) => {
              const value: number = Number(item[column.dataItemName] ? item[column.dataItemName] : 0);
              if (min > value) {
                  min = value;
              }
            })
          } else {
            min = Number(aggData[column.dataItemName]);
          }
          return "MIN:" + min;
      default:
          return "";
    }
  }

  /**
   * 列界面行为
   * 
   * @param rowData 行数据
   * @param $event 事件源
   * @param colInstance 列实例
   * @memberof AppPQGrid
   */
  columnUIAction(rowData: any, $event: any, colInstance: any) {
    const selectData = this.data.find((item: any) => Object.is(item.srfkey, rowData['srfkey']));
    this.$emit("uiAction", selectData, $event, colInstance);
  }

  /**
   * 绘制数据列
   * 
   * @param ui PQGrid ui参数
   * @param colInstance 列实例
   * @memberof AppPQGrid
   */
  renderDataColumn(ui: any, colInstance: IPSDEGridColumn) {
    const that = this;
    const dataColumn: any = new Vue({
      store: AppServiceBase.getInstance().getAppStore(),
      router: AppServiceBase.getInstance().getRouter(),
      i18n: AppServiceBase.getInstance().getI18n(),
      render(h) {
        return (
          <app-grid-column
            row={ui.rowData}
            index={ui.rowIndx}
            columnInstance={colInstance}
            gridInstance={that.gridInstance}
            context={that.context}
            modelService={that.modelService}
            viewparams={that.viewparams}
            appUIService={that.appUIService}
            on-loadFinish={() => {that.codeListLoadFinish(colInstance,colInstance.dataItemName)}}
            on-uiAction={($event: any) => that.columnUIAction(ui.rowData, $event, colInstance)}
          ></app-grid-column>
        )
      }
    }).$mount();
    return dataColumn;
  }

  /**
   * 绘制编辑列
   * 
   * @param ui PQGrid ui参数
   * @param editItem 编辑项
   * @param editItem 编辑器
   * @param editItem 值格式化
   * @memberof AppPQGrid
   */
  renderEditColumn(ui: any, editItem: IPSDEGridEditItem, editor: IPSEditor, valueFormat: string) {
    const that = this;
    const editColumn: any = new Vue({
      store: AppServiceBase.getInstance().getAppStore(),
      router: AppServiceBase.getInstance().getRouter(),
      i18n: AppServiceBase.getInstance().getI18n(),
      render(h) {
        return (
          <el-tooltip content={that.gridItemsModel[ui.rowIndx][ui.dataIndx].error} placement="top" disabled={that.gridItemsModel[ui.rowIndx][ui.dataIndx].error ? false: true}>
            <app-default-editor
              editorInstance={editor}
              parentItem={editItem}
              value={ui.rowData[editor?.name]}
              disabled={that.calcEditDisabled(ui.rowData, editItem)}
              context={that.context}
              contextData={ui.rowData}
              viewparams={that.viewparams}
              valueFormat={valueFormat}
              service={that.service}
              on-change={(value: any) => {
                that.onGridItemValueChange(ui.rowData, value, ui.rowIndx);
              }}/>
          </el-tooltip>
        )
      },
    }).$mount();
    return editColumn;
  }

  /**
   * 绘制
   * 
   * @memberof AppPQGrid
   */
  render() {
    return (
      <div class={{"app-pq-grid": true,'app-pq-grid--flex': this.columnWidthAdaptive}} id={this.id}></div>
    )
  }
}