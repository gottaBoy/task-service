import { Vue, Component, Prop, Inject } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { EditorBase } from '../editor-base/editor-base';

/**
 * 日期时间选择编辑器
 *
 * @export
 * @class DatePickerEditor
 * @extends {EditorBase}
 */
@Component({})
@VueLifeCycleProcessing()
export default class DatePickerEditor extends EditorBase {


    /**
     * 编辑器初始化
     *
     * @memberof DatePickerEditor
     */
    public async initEditor() {
        const { editorType: type, editorStyle: style } = this.editorInstance;
        const editorTypeStyle: string = `${type}${style && style != 'DEFAULT' ? '_' + style : ''}`;
        this.customProps.placeholder = this.editorInstance.placeHolder || '请选择时间...';
        if(editorTypeStyle == 'MOBDATE_day'){
            this.customProps.displayFormat = 'YYYY-MM-DD';
        }else{
            this.customProps.displayFormat = (this.editorInstance as any).dateTimeFormat ? (this.editorInstance as any).dateTimeFormat : 'YYYY-MM-DD HH:mm:ss';
        }
        if(!editorTypeStyle){
            switch (this.editorInstance?.editorType) {
                // 时间选择器(新）
                case 'MOBDATE':
                    this.customProps.displayFormat = 'yyyy-MM-dd HH:mm:ss';
                    break;
                // 时间选择控件_小时
                case 'MOBDATE_HOUR':
                    this.customProps.displayFormat = 'yyyy-MM-dd HH';
                    break;
                // 时间选择控件_分钟
                case 'MOBDATE_MINUTE':
                    this.customProps.displayFormat = 'yyyy-MM-dd HH:mm';
                    break;
                // 时间选择控件_秒钟
                case 'MOBDATE_SECOND':
                    this.customProps.displayFormat = 'yyyy-MM-dd HH:mm:ss';
                    break;
                // 时间选择控件_无日期
                case 'MOBDATE_NODAY':
                    this.customProps.displayFormat = 'HH:mm:ss';
                    break;
                // 时间选择控件_无日期无秒钟
                case 'MOBDATE_NODAY_NOSECOND':
                    this.customProps.displayFormat = 'HH:mm';
                    break;
                // 时间选择控件_无秒钟
                case 'MOBDATE_NOSECOND':
                    this.customProps.displayFormat = 'yyyy-MM-dd HH:mm';
                    break;
            }
        }
    }

    /**
     * 默认绘制
     * 
     * @memberof DatePickerEditor
     */
    public renderDefault() {
        return this.$createElement(this.editorComponentName, {
            props: {
                name: this.editorInstance.name,
                value: this.value,
                disabled: this.disabled,
                readOnly:this.readOnly,
                ...this.customProps,
            },
            on: { 
              change: this.editorChange,
              enter: this.editorEnter,
              leave: this.editorLeave              
            },
            class:this.dynaClass,
            style: this.customStyle
        })
    }

    /**
     * 绘制内容
     *
     * @returns {*}
     * @memberof DatePickerEditor
     */
    public render(): any {
        if (!this.editorIsLoaded) {
            return null;
        }
        return this.renderDefault();
    }
}
