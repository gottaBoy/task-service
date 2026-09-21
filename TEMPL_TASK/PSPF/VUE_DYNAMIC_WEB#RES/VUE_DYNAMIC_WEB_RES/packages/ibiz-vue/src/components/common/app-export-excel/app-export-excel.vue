<template>
    <dropdown :class="{'more-dropdown': isMore}" v-if="itemLevel === 0" :visible="visible" :transfer="!isMore" trigger='click'>
        <app-button
            v-if="!isMore"
            :disabled="item.disabled"
            :loading="loading"
            :caption="caption"
            :stopBubble="false"
            iconcls='fa fa-file-excel-o'
        >
        </app-button>
        <div class="more-dropdown-content" v-else @click="clickVisible">
            <menu-icon v-if="item.showIcon" :item='item' />
            <span v-if="item.showCaption" class='caption'>{{item.caption}}</span>
        </div>        
        <dropdown-menu slot='list'>
            <dropdown-item>
                <p @click="exportExcel($event, 'maxRowCount')">
                    {{caption}}{{$t('components.appexportexcel.total')}}({{$t('components.appexportexcel.max')}}{{caption}}{{item.MaxRowCount  || Environment.exportMaxRowCount  || 1000}}{{$t('components.appexportexcel.row')}})
                </p>
            </dropdown-item>
            <dropdown-item>
                <p @click="exportExcel($event, 'activatedPage')">
                    {{caption}}{{$t('components.appexportexcel.currentpage')}}
                </p>
            </dropdown-item>
             <dropdown-item class="dropdown-item-custom">
                <p>
                    <el-input v-model.trim="startPage" @click.native.stop size="small" maxlength="4"></el-input>
                    <span class="item-text">-</span>
                    <el-input v-model.trim="endPage" @click.native.stop size="small" maxlength="4"></el-input>
                    <span class="item-text">{{$t('components.appexportexcel.page')}}</span>
                    <el-button @click="exportExcel($event, 'custom')" size="small">{{caption}}</el-button>
                </p>
            </dropdown-item>
        </dropdown-menu>
    </dropdown>
</template>

<script lang="ts">
import { AppServiceBase } from 'ibiz-core/src/service';
import { Vue, Component, Prop, Watch } from 'vue-property-decorator';

/**
 * 数据导出组件
 *
 * @export
 * @class AppExportExcel
 * @extends {Vue}
 */
@Component({
})
export default class AppExportExcel extends Vue {

    /**
     * 工具栏显示类型
     *
     * @type {string}
     * @memberof AppExportExcel
     */
    @Prop({ default: 'button'})
    showType!: string;

    /**
     * 是否是存在多个下拉选项的工具栏
     *
     * @type {boolean}
     * @memberof AppExportExcel
     */
    isMore: boolean = this.showType === 'more'

    /**
     * 工具栏项
     *
     * @type {*}
     * @memberof AppExportExcel
     */
    @Prop() public item?: any;

    /**
     * 工具栏项
     *
     * @type {*}
     * @memberof AppExportExcel
     */
    @Prop() public caption?: any;

    /**
     * 工具栏项层级
     *
     * @type {number}
     * @memberof AppExportExcel
     */
    @Prop({ default: 0 }) public itemLevel!: number;

    /**
     * 是否加载
     *
     * @type {number}
     * @memberof AppExportExcel
     */
    @Prop({ default: false }) public loading!: boolean;

    /** 
     * 环境变量
     * @type {*}
     * @memberof AppExportExcel
     */
    public Environment: any = AppServiceBase.getInstance().getAppEnvironment();

    /**
     * 起始页
     *
     * @type {string}
     * @memberof AppExportExcel
     */
    public startPage: string = '1';

    /**
     * 结束页
     *
     * @type {string}
     * @memberof AppExportExcel
     */
    public endPage: string = '9999';

    /**
     * 是否显示下拉菜单
     *
     * @type {boolean}
     * @memberof AppExportExcel
     */
    public visible: boolean = false;

    /**
     * 点击触发相似
     *
     * @memberof AppExportExcel
     */
    public clickVisible(): void {
        this.visible = !this.visible
    }

    /**
     * 导出数据
     *
     * @param {*} $event
     * @param {string} type
     * @returns {void}
     * @memberof AppExportExcel
     */
    public exportExcel($event: any, type: string): void {
        const exportparms: any = { type: type };
        if (Object.is(type, 'maxRowCount')) {
            Object.assign(exportparms, { maxRowCount: this.item.MaxRowCount })
            this.visible = false;
        } else if (Object.is(type, 'activatedPage')) {
            this.visible = false;
        } else if (Object.is(type, 'custom')) {
            if (!this.startPage || !this.endPage) {
                this.$warning((this.$t('components.appexportexcel.desc') as string),'exportExcel');
                return;
            }
            const startPage: any = Number.parseInt(this.startPage, 10);
            const endPage: any = Number.parseInt(this.endPage, 10);
            if (Number.isNaN(startPage) || Number.isNaN(endPage)) {
                this.$warning((this.$t('components.appexportexcel.desc1') as string),'exportExcel');
                return;
            }

            if (startPage < 1 || endPage < 1 || startPage > endPage) {
                this.$warning((this.$t('components.appexportexcel.desc1') as string),'exportExcel');
                return;
            }
            this.startPage = '1';
            this.endPage = '9999';
            Object.assign(exportparms, { startPage: startPage, endPage: endPage });
            this.visible = false;
        }
        if (!this.visible) {
            Object.assign($event, { exportparms: exportparms });
            this.$emit('exportexcel', $event);
        }
    }

}
</script>
