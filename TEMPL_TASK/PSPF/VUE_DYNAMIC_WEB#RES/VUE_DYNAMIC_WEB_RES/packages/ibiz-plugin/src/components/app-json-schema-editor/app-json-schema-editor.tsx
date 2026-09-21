import { Component, Model, Prop, Vue, Watch } from 'vue-property-decorator';
import 'json-editor';
@Component({})
export class AppJsonSchemaEditor extends Vue {

    /**
     * @description 传入值
     * @type {string}
     * @memberof AppJsonSchemaEditor
     */
    @Model('change')
    value!: string;

    @Watch('value')
    onValueWatch() {
        if (this.jsonSchemaEditor) {
            this.jsonSchemaEditor.setValue(this.value);
        }
    }

    /**
     * @description 主题
     * @type {('html' | 'foundation3' | 'foundation4' | 'foundation5'| 'foundation6' | 'jqueryui' | 'bootstrap2' | 'bootstrap3')}
     * @memberof AppJsonSchemaEditor
     */
    @Prop({ type: String, default: 'bootstrap2' })
    theme!: 'html' | 'foundation3' | 'foundation4' | 'foundation5'| 'foundation6' | 'jqueryui' | 'bootstrap2' | 'bootstrap3';

    /**
     * @description 图标库
     * @type {('jqueryui' | 'fontawesome4' | null)}
     * @memberof AppJsonSchemaEditor
     */
    @Prop({ type: String, default: 'jqueryui' })
    iconlib!: 'jqueryui' | 'fontawesome4' | null;

    /**
     * @description 只读
     * @type {boolean}
     * @memberof AppJsonSchemaEditor
     */
    @Prop({ type: Boolean, default: false })
    readonly!: boolean;

    /**
     * @description jsonSchema编辑器对象
     * @type {*}
     * @memberof AppJsonSchemaEditor
     */
    jsonSchemaEditor: any;

    /**
     * @description Vue生命周期，实例挂载完毕
     * @memberof AppJsonSchemaEditor
     */
    mounted() {
        this.initJsonEditor();
    }

    /**
     * Vue实例销毁前
     *
     * @memberof AppJsonSchemaEditor
     */
    beforeDestroy() {
        if (this.jsonSchemaEditor) {
            this.jsonSchemaEditor.destroy();
        }
    }

    /**
     * @description 初始化Json编辑器
     * @memberof AppJsonSchemaEditor
     */
    initJsonEditor() {
        const jsonSchemaEditor = this.$refs.jsonSchemaEdito;
        if (jsonSchemaEditor) {
            this.jsonSchemaEditor = new (window as any).JSONEditor(jsonSchemaEditor, {
                schema: {
                    type: 'object',
                },
                theme: this.theme,
                iconlib: this.iconlib,
            });
            this.registerEvent();
        }
    }

    /**
     * 注册事件
     *
     * @memberof AppJsonSchemaEditor
     */
    registerEvent() {
        // 数据发生变化
        if (this.readonly) {
            this.jsonSchemaEditor.disable();
        }
        this.jsonSchemaEditor.on('change',() => {
            this.$emit('change', this.jsonSchemaEditor.getValue());
        });
    }

    /**
     * @description 绘制josn编辑器
     * @return {*} 
     * @memberof AppJsonSchemaEditor
     */
    render() {
        return (
            <div class="app-json-editor">
                <div class={{ "app-json-schema-editor__content": true, [`app-json-schema-editor__content--${this.theme}`]: true }} ref='jsonSchemaEdito'></div>
            </div>
        )
    }
}
export default AppJsonSchemaEditor;