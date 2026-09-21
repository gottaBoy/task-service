<template>
    <el-divider :content-position="contentPosition">
        <span v-html="html"></span>
    </el-divider>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator';

@Component({
})
export default class AppDivider extends Vue {

    /**
     * 分割标题位置
     *
     * @type {*}
     * @memberof AppDivider
     */
    @Prop({default:'left'}) public contentPosition?: 'left' | 'center' | 'right';

    /**
     * 分割标题内容
     *
     * @type {*}
     * @memberof AppDivider
     */
    @Prop() public html?: string;
}
</script>