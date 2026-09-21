<template>
    <div class="app-error-view">
        <div class="app-error-container">
            <img src="@/assets/img/500.png" />
            <div class="error-text">
                <div class="error-text1">{{ $t('components.500.errortext1') }}</div>
                <div class="error-text2">
                    {{ $t('components.500.errortext2') }}
                    <a @click="gotoPage">{{ $t('components.500.indexpage') }}</a>
                    {{ $t('components.500.continue') }}
                </div>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
import { Environment } from '@/environments/environment';
import { Vue, Component } from 'vue-property-decorator';

@Component({})
export default class Error500 extends Vue {
    /**
     * 跳转页面
     *
     * @returns
     * @memberof Error500
     */
    public gotoPage() {
        const length = this.$store.state.historyPathList.length;
        if (length > 0) {
            const path = this.$store.state.historyPathList[length - 1];
            if (Object.is(path, this.$route.fullPath)) {
                return;
            }
            const index = this.$store.state.pageTagList.findIndex((page: any) => Object.is(page.fullPath, path));
            if (index >= 0) {
                const page = this.$store.state.pageTagList[index];
                this.$router.push({
                    path: page.path,
                    params: page.params,
                    query: page.query,
                });
            }
        } else {
            let path: string | null = window.sessionStorage.getItem(Environment.AppName);
            if (path) {
                this.$router.push({ path: path });
            } else {
                this.$router.push('/');
            }
        }
    }
}
</script>

<style lang='less'>
@import './500.less';
</style>