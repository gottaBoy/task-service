<template>
    <div>
        <div v-if="Object.is(modelType, 'AUTH_SSO')">
            <app-third-login :name="name"></app-third-login>
        </div>
        <div v-if="Object.is(modelType, 'AUTH_CAPTCHA')">
            <app-preset-auth :name="name" @valueChange="valueChange"></app-preset-auth>
        </div>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator';

@Component({})
export default class AppUserControl extends Vue {
    /**
     * @description 上下文
     * @class AppUserControl
     * @type {*}
     */
    @Prop() public parent?: any;

    /**
     * @description 类型数据
     * @class AppUserControl
     * @type {*}
     */
    @Prop() public modelJson!: any;

    /**
     * @description 名称
     * @type {string}
     */
    public name: string = '';

    /**
     * @description 绘制数据
     * @type {string}
     */
    public modelType: string | undefined = undefined;

    /**
     * @description 接收子组件数据将数据向上抛
     */
    public valueChange(data: any) {
        this.$emit('valueChange', data);
    }

    /**
     * @description 生命周期 初始化
     */
    created() {
        if (this.modelJson && this.modelJson.M && this.modelJson.M.predefinedType) {
            this.modelType = this.modelJson.M.predefinedType;
            this.name = this.modelJson.name;
        }
    }
}
</script>
<style lang='less'>
</style>