<template>
    <el-alert class="app-rawitem-alert__container" :title="title" :type="type" :show-icon="Boolean(showIcon)" :closable="Boolean(closeable)">
    </el-alert>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator';

@Component({
})
export default class AppRawAlert extends Vue {

    /**
     * 提示内容
     *
     * @type {string}
     * @memberof AppRawAlert
     */
    @Prop() public title?: string;

    /**
     * 提示类型
     *
     * @type {string}
     * @memberof AppRawAlert
     */
    @Prop() public type?: string;

    /**
     * 是否展示图标
     *
     * @type {boolean}
     * @memberof AppRawAlert
     */
    @Prop() public showIcon?: boolean;

    /**
     * 是否可关闭
     *
     * @type {boolean}
     * @memberof AppRawAlert
     */
    @Prop({default:true}) public closeable?: boolean;
}
</script>