<template>
    <div :class="classes">
        <template v-if="uiStyle=='STYLE2'">
            <app-form-group2
                :caption="caption"
                :uiStyle="uiStyle"
                :layoutType="layoutType"
                :isShowCaption="isShowCaption"
                :uiActionGroup="uiActionGroup"
                :titleBarCloseMode="titleBarCloseMode">
                   <slot></slot>
                </app-form-group2>
        </template>
        <template v-else>
            <card v-if="isShowCaption === true" :bordered="false" :dis-hover="true">
                <p :class="[titleClass, 'app-form-group__header']" slot='title' @click="clickCollapse">
                      <i v-if="iconInfo && iconInfo.cssClass" :class="[iconInfo.cssClass, 'header__icon']" />
                      <img v-else-if="iconInfo && iconInfo.imagePath" class="header__icon" :src="iconInfo.imagePath" alt="">
                      <span>{{caption}}</span>
                </p>
                <template slot='extra'>
                    <span v-if="uiActionGroup" class="app-form-group__actions">
                        <dropdown v-if="uiActionGroup.extractMode && Object.is(uiActionGroup.extractMode, 'ITEMS')" :transfer="true" trigger='click'>
                            <a href='javascript:void(0)'>
                                {{uiActionGroup.caption}}
                            </a>
                            <dropdown-menu slot='list' v-if="uiActionGroup.details && Array.isArray(uiActionGroup.details)">
                                <dropdown-item v-for="(detail,index) in (uiActionGroup.details)" :key="index" :name="detail.name">
                                    <span :class="{'app-form-group__action__item': true, 'is-disable': detail.disabled}" v-show="detail.visible" @click="doUIAction($event, detail)">
                                        <template v-if="detail.isShowIcon">
                                            <template v-if="detail.icon && !Object.is(detail.icon, '')">
                                                <i :class="detail.icon" ></i>
                                            </template>
                                            <template v-if="!(detail.icon && !Object.is(detail.icon, ''))">
                                                <div v-if="detail.img && !Object.is(detail.img, '')">
                                                    <img :src="detail.img" />
                                                </div>
                                            </template>
                                        </template>
                                        &nbsp;
                                        <span>
                                            <template v-if="detail.isShowCaption">
                                                <template v-if="uiActionGroup.langbase && !Object.is(uiActionGroup.langbase, '') && detail.uiactiontag && !Object.is(detail.uiactiontag, '')">
                                                    {{$t(`${uiActionGroup.langbase}.uiactions.${detail.uiactiontag}`)}}
                                                </template>
                                                <template v-if="!(uiActionGroup.langbase && !Object.is(uiActionGroup.langbase, '') && detail.uiactiontag && !Object.is(detail.uiactiontag, ''))">
                                                    {{detail.caption}}
                                                </template>
                                            </template>
                                        </span>
                                    </span>
                                </dropdown-item>
                            </dropdown-menu>
                        </dropdown>
                        <span v-else-if="uiActionGroup.details && Array.isArray(uiActionGroup.details)" class='app-form-group__action__extract'>
                            <div v-for="(detail,index) in uiActionGroup.details" :key="index">
                                <a v-show="detail.visible" :class="{'app-form-group__action__item': true, 'is-disable': detail.disabled}" @click="doUIAction($event, detail)">
                                    <template v-if="detail.isShowIcon">
                                        <template v-if="detail.icon && !Object.is(detail.icon, '')">
                                            <i :class="detail.icon" ></i>
                                        </template>
                                        <template v-if="!(detail.icon && !Object.is(detail.icon, ''))">
                                            <div v-if="detail.img && !Object.is(detail.img, '')">
                                                <img :src="detail.img" />
                                            </div>
                                        </template>
                                    </template>
                                    &nbsp;
                                    <span>
                                        <template v-if="detail.isShowCaption">
                                            <template v-if="uiActionGroup.langbase && !Object.is(uiActionGroup.langbase, '') && detail.uiactiontag && !Object.is(detail.uiactiontag, '')">
                                                {{$t(`${uiActionGroup.langbase}.uiactions.${detail.uiactiontag}`)}}
                                            </template>
                                            <template v-if="!(uiActionGroup.langbase && !Object.is(uiActionGroup.langbase, '') && detail.uiactiontag && !Object.is(detail.uiactiontag, ''))">
                                                {{detail.caption}}
                                            </template>
                                        </template>
                                    </span>
                                </a>
                            </div>
                        </span>
                        <i v-if="titleBarCloseMode !== 0" :class="{'el-collapse-item__arrow el-icon-arrow-right': true, 'is-active': !collapseContant,'app-form-group__actions__collapse-icon':true}" @click="clickCollapse"></i>
                    </span>
                    <slot name="dataInfoPanel"></slot>
                    <a v-if="isManageContainer" class='app-form-group__action__showmore' @click="doManageContainer">
                        <icon :type=" manageContainerStatus ? 'ios-repeat' : 'ios-menu' " />
                        {{manageContainerStatus?$t('components.appformgroup.hide'):$t('components.appformgroup.showmore')}}
                    </a>
                </template>
                <template v-if="Object.is(layoutType, 'FLEX')">
                    <slot></slot>
                </template>
                <template v-if="!Object.is(layoutType, 'FLEX')">
                    <row :gutter="10"><slot></slot></row>
                </template>
            </card>
            <template v-if="isShowCaption === false">
                <slot></slot>
            </template>
        </template>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator';

@Component({})
export default class AppFormGroup extends Vue {

    /**
     * 标题
     *
     * @type {string}
     * @memberof AppFormGroup
     */
    @Prop() public caption?: string;

    /**
     * 注入数据
     *
     * @type {*}
     * @memberof AppFormGroup
     */
    @Prop() public data!: any;

    /**
     * 是否为管理容器
     *
     * @type {string}
     * @memberof AppFormGroup
     */
    @Prop({ default: false }) public isManageContainer?: boolean;
    
    /**
     * 管理容器状态
     *
     * @type {string}
     * @memberof AppFormGroup
     */
    @Prop({ default: false }) public manageContainerStatus?: boolean;

    /**
     * 内置界面样式
     * 
     * @type {string}
     * @memberof AppFormGroup
     */
    @Prop() public uiStyle?: string;

    /**
     * 布局模式
     *
     * @type {string}
     * @memberof AppFormGroup
     */
    @Prop() public layoutType?: string;

    /**
     * 标题样式
     *
     * @type {string}
     * @memberof AppFormGroup
     */    
    @Prop() public titleStyle?:string;

    /**
     * 分组图标
     *
     * @type {string}
     * @memberof AppFormGroup
     */ 
    @Prop() public iconInfo?:any;

    /**
     * 是否显示标题
     *
     * @type {boolean}
     * @memberof AppFormGroup
     */
    @Prop({ default: true }) public isShowCaption!: boolean;

    /**
     * 信息面板模式
     *
     * @type {boolean}
     * @memberof AppFormGroup
     */
    @Prop({ default: false }) public isInfoGroupMode!: boolean;

    /**
     * 界面行为组
     *
     * @type {*}
     * @memberof AppFormGroup
     */
    @Prop() public uiActionGroup?: any;

    /**
     * 标题栏关闭模式
     * 0: 不支持关闭
     * 1: 默认打开
     * 2： 默认关闭
     *
     * @type {(number | 0 | 1 | 2)} 
     * @memberof AppFormGroup
     */
    @Prop({ default: 0 }) public titleBarCloseMode!: number | 0 | 1 | 2;

    /**
     * 收缩内容
     *
     * @type {boolean}
     * @memberof AppFormGroup
     */
    public collapseContant: boolean = false;

    /**
     * 计算样式
     *
     * @readonly
     * @type {string[]}
     * @memberof AppFormGroup
     */
    get classes(): string[] {
        return [
            'app-form-group',
            this.isShowCaption && this.collapseContant ? 'app-group-collapse--collapse' : '',
            this.isInfoGroupMode ? 'is-group' : '',
            Object.is(this.layoutType, 'FLEX') ? 'is-flex' : '',
            this.isShowCaption ? 'show-caption' : '',
        ];
    }

    /**
     * 标题样式
     *
     * @readonly
     * @type {string}
     * @memberof AppFormGroup
     */
    get titleClass():string{
        return this.titleStyle?this.titleStyle:'';
    }

    /**
     * vue 生命周期
     *
     * @memberof AppFormGroup
     */
    public created() {
        this.collapseContant = this.titleBarCloseMode === 2 ? true : false;
    }

    /**
     * 触发收缩
     *
     * @memberof AppFormGroup
     */
    public clickCollapse(): void {
        if (this.titleBarCloseMode !== 0) {
            this.collapseContant = !this.collapseContant;
            this.$emit("collapseChange",this.collapseContant);
        }
    }

    /**
     * 执行界面行
     *
     * @param {*} $event
     * @memberof AppFormGroup
     */
    public doUIAction($event: any, item: any): void {
        this.$emit('groupuiactionclick', { event: $event, item: item });
    }

    /**
     * 操作管理容器
     *
     * @param {*} $event
     * @memberof AppFormGroup
     */
    public doManageContainer(){
        this.$emit('managecontainerclick');
    }
}
</script>