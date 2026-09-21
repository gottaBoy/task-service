<template>
    <div
        ref="json_schema"
        style="
            text-align: center;
            font-size: 24px;
            font-weight: 700;
            margin-bottom: 20px;
        "
    ></div>
</template>
<script lang="ts">
import {
    Vue,
    Component,
    Prop,
    Model,
    Emit,
    Watch,
} from "vue-property-decorator";

@Component({})
export default class AppJsonSchema extends Vue {
    /**
     *值
     */
    @Model("change") readonly value?: any;

    /**
     * 只读
     */
    @Prop({default:false}) public readonly!: boolean;

    /**
     * 禁用
     */
    @Prop({default:false}) public disabled!: boolean;

    /**
     * name
     */
    @Prop() public name!: string;

    /**
     * 是否开启高级配置，默认为true--开启
     */
    @Prop({ default: true }) public enableAdvancedSetting?: boolean;

    /** 
     * 状态管理
     */
    public state: boolean = this.readonly || this.disabled;

    /**
     * json 编辑对象
     */
    public amisScoped: any;

    @Watch("value", { immediate: true })
    onValueWatch() {
        if (this.amisScoped) {
            const tempcom = this.amisScoped.getComponentByName("page.form");
            if (tempcom) {
                if (typeof this.value == 'object' && this.value !== null) {
                    tempcom.setData({ schema: this.value });
                } else {
                    tempcom.setData({ schema: { type: 'object' } });
                }
            }
        }
    }
    @Watch("disabled")
    onDisabledWatch() {
        this.state = this.readonly || this.disabled;
        this.initJsonSchema();
    }

    @Watch("readonly")
    onReadonlyWatch() {
        this.state = this.readonly || this.disabled;
        this.initJsonSchema();
    }

    

    public initJsonSchema() {
        let amis = (window as any).amisRequire("amis/embed");
        let that = this;
        this.amisScoped = amis.embed(
            this.$refs.json_schema,
            {
                type: "page",
                name: "page",
                body: {
                    type: "form",
                    name: "form",
                    title: "属性结构",
                    mode: "horizontal",
                    actions: [
                        {
                            type: "submit",
                            label: "确定",
                            disabled: that.state,
                        },
                    ],
                    body: [
                        {
                            type: "json-schema-editor",
                            name: "schema",
                            label: "字段类型",
                            disabled: that.state,
                            enableAdvancedSetting: that.enableAdvancedSetting,
                            advancedSettings: {
                                string: [
                                    {
                                        type: "input-text",
                                        name: "maxLength",
                                        label: "Max Length",
                                    },
                                ],
                                number: [
                                    {
                                        type: "input-number",
                                        name: "max",
                                        label: "Max",
                                    },
                                ],
                            },
                        },
                    ],
                },
            },
            {},
            {
                tracker: (eventTrack: any, props: any) => {
                    const { eventType } = eventTrack;
                    if (eventType == "submit") {
                        //抛出数据
                        if (props && props.data && props.data.schema) {
                            const obj = props.data.schema;
                            if (obj && (!that.disabled || !that.readonly)) {
                                that.$emit("change", obj);
                            }
                        }
                    }
                },
            }
        );
    }

    /** 
     * 设置值
     */
    public setJsonData() {
        if (this.amisScoped && this.amisScoped.getComponentByName) {
            const tempcom = this.amisScoped.getComponentByName('page.form');
            if (tempcom) {
                if (typeof this.value == 'object' && this.value !== null) {
                    tempcom.setData({ schema: this.value });
                } else {
                    tempcom.setData({ schema: { type: 'object' } });
                }
            }
        }
    }

    /**
     * 生命周期mounted
     */
    mounted() {
        this.initJsonSchema();
        setTimeout(() => {
            this.setJsonData();
        }, 500);
    }
}
</script>