<template>
    <div class="app-about">
        <el-form>
            <el-form-item label="应用名称">
                <span>{{ appTitle }}</span>
            </el-form-item>
            <el-form-item label="代码标识">
                <span>{{ appCodeName }}</span>
            </el-form-item>
            <el-form-item label="系统名称">
                <span>{{ sysName }}</span>
            </el-form-item>
            <el-form-item label="版本">
                <span>{{ appVersion }}</span>
            </el-form-item>
        </el-form>
    </div>
</template>

<script lang="ts">
import { AppServiceBase } from 'ibiz-core';
import {Vue, Component} from 'vue-property-decorator';

@Component({})
export default class AppAbout extends Vue {

    /**
     * 应用名称
     *
     * @memberof AppAbout
     */
    appTitle: string = '';

    /**
     * 代码标识
     *
     * @memberof AppAbout
     */
    appCodeName: string = '';

    /**
     * 系统名称
     *
     * @memberof AppAbout
     */
    sysName: string = '';

    /**
     * 版本
     *
     * @memberof AppAbout
     */
    appVersion: string = '';

    created() {
        const APP = AppServiceBase.getInstance().getAppModelDataObject();
        if (APP) {
            this.appTitle = APP.name || APP.pKGCodeName;
            this.appCodeName = APP.codeName;
            this.sysName = APP.sysCodeName;
            this.appVersion = APP.appVersion;
        }
    }
}
</script>