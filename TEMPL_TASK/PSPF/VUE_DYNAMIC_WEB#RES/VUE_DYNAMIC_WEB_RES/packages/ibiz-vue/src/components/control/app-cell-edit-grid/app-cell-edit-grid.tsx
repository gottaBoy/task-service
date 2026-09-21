import { Component } from 'vue-property-decorator';
import { AppGridBase } from '../app-common-control/app-grid-base';
import { VueLifeCycleProcessing } from '../../../decorators';
import { ModelTool, throttle } from 'ibiz-core';
import { IPSDEGridColumn, IPSDEGridEditItem, IPSDEGridFieldColumn, IPSEditor } from '@ibiz/dynamic-model-api';

/**
 * 单元格编辑表格部件
 * 行编辑只在点击单元格的时候绘制，减少性能压力
 *
 * @export
 * @class AppCellEditGrid
 * @extends {AppGridBase}
 */
@Component({})
@VueLifeCycleProcessing()
export class AppCellEditGrid extends AppGridBase {
    /**
     * 渲染完成
     *
     * @memberof AppDataViewBase
     */
    public ctrlMounted() {
        super.ctrlMounted();
        // 绑定this,添加监听全局点击事件
        this.clearCellEdit = this.clearCellEdit.bind(this);
        window.addEventListener('click', this.clearCellEdit);
    }

    /**
     * 执行destroyed后的逻辑
     *
     * @memberof MDControlBase
     */
    public ctrlDestroyed() {
        super.ctrlDestroyed();
        window.removeEventListener('click', this.clearCellEdit);
    }

    /**
     * 当前开启编辑的单元格element
     */
    public currentEditCell: any = null;

    /**
     * 清空所有开启编辑的单元格
     * @param event
     */
    public clearCellEdit(event: any) {
        // 当有单元格开启编辑，且点击不是当前单元格内部时，清空所有
        if (this.currentEditCell && !this.currentEditCell.contains(event.target)) {
            this.items.forEach((item: any) => {
                item.editColumnName = undefined;
            });
            this.currentEditCell = null;
            this.$forceUpdate();
        }
    }

    /**
     * 单元格点击事件回调
     * @param row 行数据
     * @param column 列信息
     * @param cell 单元格元素
     * @param event 事件
     * @return {*} 
     */
    public cellClick(row: any, column: any, cell: any, event: any) {
        // 阻止冒泡，因为编辑项重绘，导致cell内部已经没有event.target了。
        event.stopPropagation();

        // 已经开启的单元格不需要反复执行
        if (this.currentEditCell == cell) {
            return;
        }

        // 如果有其他已经开启的单元格，则先清除
        if (this.currentEditCell && this.currentEditCell !== cell) {
            this.clearCellEdit({ target: cell });
        }

        // 开启选中单元格的编辑项，并存储元素给clearCellEdit使用
        row.editColumnName = column.property;
        this.currentEditCell = cell;
        this.$forceUpdate();
    }

    /**
     * 计算表格事件
     *
     * @memberof AppGridBase
     */
    public computeGridEvents() {
        let events = super.computeGridEvents();
        Object.assign(events, {
            'cell-click': (row: any, column: any, cell: any, event: any) =>
                throttle(this.cellClick, [row, column, cell, event], this),
        });
        return events;
    }

    /**
     * 表格编辑项值变更
     *  
     * @param row 行数据
     * @param {{ name: string, value: any }} 变化数据键值
     * @param rowIndex 行索引
     * @memberof GridControlBase
     */
    public onGridItemValueChange2(row: any, $event: { name: string, value: any }, rowIndex: number, item:any): void {
        if (!$event) {
            return;
        }
        if (!$event.name || Object.is($event.name, '') || !row.hasOwnProperty($event.name)) {
            return;
        }
        row[$event.name] = $event.value;
        // 列数据项值也需要更新
        const dataItemName:any = item.dataItemName;  
        if (dataItemName) {
            row[dataItemName] = $event.value;
        }
        this.gridEditItemChange(row, $event.name, $event.value, rowIndex);
    }

    /**
     * 绘制编辑项
     * @param item
     * @param scope
     * @return {*} 
     */
    public renderOpenEditItem(item: IPSDEGridColumn, scope: any) {
        if (scope.row.editColumnName == scope.column.property) {
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
                            this.onGridItemValueChange2(row, value, $index, item);
                        }}
                    />
                </app-form-item>
            );
        } else {
            return this.renderColumn(item, scope);
        }
    }
}
