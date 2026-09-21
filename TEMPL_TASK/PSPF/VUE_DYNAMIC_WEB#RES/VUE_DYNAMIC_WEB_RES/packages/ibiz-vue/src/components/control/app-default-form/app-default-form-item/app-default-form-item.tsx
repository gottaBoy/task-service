import { Subject } from 'rxjs';
import { Component, Prop} from 'vue-property-decorator';
import { IPSDEFormItemEx } from '@ibiz/dynamic-model-api';
import { AppServiceBase } from 'ibiz-core';
import { AppDefaultFormDetail } from '../app-default-form-detail/app-default-form-detail';

/**
 * 表单UI组件
 *
 * @export
 * @class AppDefaultFormItem
 * @extends {Vue}
 */
@Component({})
export class AppDefaultFormItem extends AppDefaultFormDetail {
    /**
     * 表单项实例对象
     *
     * @type {*}
     * @memberof AppDefaultFormItem
     */
    @Prop() public declare detailsInstance: IPSDEFormItemEx;

    /**
     * 表单数据
     *
     * @type {*}
     * @memberof AppDefaultFormItem
     */
    @Prop() public data: any;

    /**
     * 表单值规则
     *
     * @type {*}
     * @memberof AppDefaultFormItem
     */
    @Prop() public rules: any;
    
    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof AppDefaultFormItem
     */
    @Prop() formState!: Subject<any>;    

    /**
     * 表单服务对象
     *
     * @type {*}
     * @memberof AppDefaultFormItem
     */
    @Prop() service: any;    

    /**
     * 忽略表单项值变化
     *
     * @type {boolean}
     * @memberof AppDefaultFormItem
     */
    @Prop() ignorefieldvaluechange?: boolean;

    /**
     * 当前值规则
     *
     * @readonly
     * @memberof AppDefaultFormItem
     */
    get curRules() {
        if (this.rules && this.rules.length > 0 && (this.index || this.index == 0)) {
            this.rules.forEach((rule: any) => {
                Object.assign(rule, { index: this.index })
            })
        }
        return this.rules;
    }

    /**
     * 表单项值变化事件
     *
     * @memberof AppDefaultFormItem
     */
    public onFormItemValueChange(...args: any) {
        this.$emit('formItemValueChange', ...args);
    }

    /**
     * 绘制基础复合编辑器
     *
     * @memberof AppDefaultFormItem
     */
     public renderBaseCompositeEditor(refFormItem: any[],name: string,editor: any,contentStyle: any) {
        if (Object.is(editor?.editorType,'DATERANGE') || Object.is(editor?.editorType,'DATERANGE_NOTIME')) {
            return (
                <app-date-range
                    activeData={this.data}
                    name={name}
                    editorType={editor.editorType}
                    refFormItem={refFormItem}
                    disabled={this.runtimeModel?.disabled}
                    format={editor?.editorParams?.['TIMEFMT']}
                    on-formitemvaluechange={(value: any) => {
                      this.onFormItemValueChange(value);
                    }}
                    style={contentStyle}
                ></app-date-range>
            );
        } else if (Object.is(editor?.editorType,'NUMBERRANGE')) {
            return (
                <app-number-range
                    name={name}
                    activeData={this.data}
                    refFormItem={refFormItem}
                    disabled={this.runtimeModel?.disabled}
                    on-formitemvaluechange={(value: any) => {
                        this.onFormItemValueChange(value);
                    }}
                    style={contentStyle ? contentStyle : 'width: 300px'}
                ></app-number-range>
            )
        } else {
            return (
                <app-range-editor
                    value={this.data[name]}
                    activeData={this.data}
                    name={name}
                    editorType={editor?.editorType}
                    refFormItem={refFormItem}
                    disabled={this.runtimeModel?.disabled}
                    format={editor?.editorParams?.['TIMEFMT']}
                    on-formitemvaluechange={(value: any) => {
                      this.onFormItemValueChange(value);
                    }}
                    style={contentStyle}
                ></app-range-editor>
            );
        }
    }

    /**
     * 绘制复合表单项
     *
     * @returns
     * @memberof AppDefaultFormItem
     */
    public renderCompositeItem() {
        const { name, contentHeight, contentWidth } = this.detailsInstance;
        let editor = this.detailsInstance.getPSEditor();
        let formItems = this.detailsInstance.getPSDEFormItems();
        let editorType = editor?.editorType;
        // 设置高宽
        let contentStyle: string = '';
        contentStyle += contentWidth && contentWidth != 0 ? `width:${contentWidth}px;` : '';
        contentStyle += contentHeight && contentHeight != 0 ? `height:${contentHeight}px;` : '';
        contentStyle += this.runtimeModel?.visible ? '' : 'display: none;';
        const refFormItem: any = [];
        if(formItems){
            formItems?.forEach((formItem: any) => {
                refFormItem.push(formItem?.name);
            });   
        }
        if (editor?.editorType !== 'USERCONTROL') {
          return this.renderBaseCompositeEditor(refFormItem,name,editor,contentStyle);
        } else {
          return (
          <app-default-editor
              editorInstance={editor}
              value={this.data[editor.name]}
              contextData={this.data}
              context={this.context}
              viewparams={this.viewparams}
              contextState={this.formState}
              service={this.service}
              disabled={this.runtimeModel?.disabled}
              ignorefieldvaluechange={this.ignorefieldvaluechange}
              on-change={(value: any) => {
                  this.onFormItemValueChange(value);
              }}
          />)
        }
    }

    /**
     * 绘制内容
     *
     * @returns {*}
     * @memberof AppDefaultFormItem
     */
    public render(): any {
        const { detailClassNames } = this.renderOptions;
        let {
            name,
            caption,
            labelWidth,
            labelPos,
            showCaption,
            emptyCaption,
            detailStyle,
            compositeItem,
            contentWidth,
            contentHeight,
        } = this.detailsInstance;
        let editor = this.detailsInstance.getPSEditor();
        let sysCss = this.detailsInstance.getLabelPSSysCss();
        let editorType = editor?.editorType;
        // 隐藏表单项
        if (editorType == 'HIDDEN') {
            return;
        }
        // 设置高宽
        let contentStyle: string = '';
        contentStyle += contentWidth && contentWidth != 0 ? `width:${contentWidth}px;` : '';
        contentStyle += contentHeight && contentHeight != 0 ? `height:${contentHeight}px;` : '';
        contentStyle += this.runtimeModel?.visible ? '' : 'display: none;';
        const labelStyle = {}
        if(sysCss?.cssName){
            Object.assign(labelStyle,{[sysCss?.cssName]:true})
        }
        const context = this.context;
        const viewparams = this.viewparams;
        const data = this.data;
        if(this.detailsInstance.dynaClass){
            Object.assign(detailClassNames,...eval(this.detailsInstance.dynaClass))
        }
        if(this.detailsInstance.labelDynaClass){
            Object.assign(labelStyle,...eval(this.detailsInstance.labelDynaClass))
        }
        return (
            <app-form-item
                name={name}
                caption={this.runtimeModel?.caption}
                isEmptyCaption={emptyCaption}
                isShowCaption={showCaption}
                labelWidth={labelWidth}
                labelPos={this.computeLabelPos(labelPos)}
                detailsInstance={this.detailsInstance}
                uiStyle={detailStyle}
                itemRules={this.curRules}
                required={this.runtimeModel?.required}
                error={this.runtimeModel?.error}
                class={detailClassNames}
                labelStyle={labelStyle}
                style={contentStyle}
                controlInstance={this.controlInstance}
            >
                { compositeItem ? (
                    this.renderCompositeItem()
                ) : this.$slots.default }
            </app-form-item>
        );
    }

    /**
     * @description 计算表单项标题位置
     * @protected
     * @param {string} pos 配置项位置
     * @return {*}  {string}
     * @memberof AppDefaultFormItem
     */
    protected computeLabelPos(pos: string): string {
        const Environment = AppServiceBase.getInstance().getAppEnvironment();
        if (Environment && Environment.formItemLabelPos) {
            switch (Environment.formItemLabelPos) {
                case 'LEFT':
                case 'RIGHT':
                case 'TOP':
                case 'BOTTOM':
                    return Environment.formItemLabelPos;
            }
        }
        return pos;
    }
}
