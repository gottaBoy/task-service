<template>
    <div v-if="mode === 'POPOVER'" :class="['app-wf-opinion', isShow ? 'is-show' : '']" ref='wf-opinion'>
        <el-button v-popover:popover type="primary" size="small" @click="click">{{ $t('components.appwfopinion.title') }}</el-button>
        <el-popover ref="popover" popper-class="wf-opinion-popover" v-model="isShow" :width="width" :visible-arrow="false" trigger="manual" placement="left">
            <div v-show="isShow" ref="wf-opinion-container" class="wf-opinion-container" :style="{ 'height': containerHeight + 'px' }">
                <div class="opinion-container__header">
                    <span class="opinion-container__header__title">{{ $t('components.appwfopinion.title') }}</span>
                    <div class="opinion-container__header__icon-container">
                        <i v-if="false" :class="['icon', enableClick ? 'el-icon-lock' : 'el-icon-unlock' ]" @click="enableClick = !enableClick;"/>
                        <i :class="['icon', 'el-icon-minus', enableClick ? 'enable' : '']" @click="minusClick"/>
                    </div>
                </div>
                <div class="opinion-container__content">
                    <div :class="['opinion-container__content__textarea', error ? 'error' : '']">
                        <form-item :rules="rules" :error="error" :ref="name" :prop="name">
                            <input-box v-model="currentVal" @change="valueChange" :placeholder="placeholder || $t('components.appwfopinion.placeholder')" type="textarea"/>
                        </form-item>
                    </div>
                    <div class="opinion-container__content__navbar">
                        <div v-if="false" class="navbar__header">
                            <i-input search :placeholder="$t('components.appwfopinion.search')" @on-search="onSearch" />
                        </div>
                        <div class="navbar__items">
                            <template v-for="(filter, index) in filterItems">
                                <span :class="getClass(filter)" :key="index" @click="filterItemDBClick(filter, $event)">{{ filter }}</span>
                            </template>
                        </div>
                    </div>
                </div>
            </div>
        </el-popover>
    </div>
    <div v-else ref="wf-opinion-container" class="wf-opinion-container wf-opinion-nobutton">
        <div class="opinion-container__content">
            <div :class="['opinion-container__content__textarea', error ? 'error' : '']">
                <form-item :rules="rules" :error="error" :ref="name" :prop="name">
                    <input-box v-model="currentVal" @change="valueChange" :placeholder="placeholder || $t('components.appwfopinion.placeholder')" type="textarea"/>
                </form-item>
            </div>
            <div class="opinion-container__content__navbar">
                <div class="navbar__items">
                    <template v-for="(filter, index) in filterItems">
                        <span :class="getClass(filter)" :key="index" @click="filterItemDBClick(filter, $event)">{{ filter }}</span>
                    </template>
                </div>
            </div>
        </div>
    </div>
</template>


<script lang="ts">
import { Vue, Prop, Component, Model, Watch } from 'vue-property-decorator';

@Component({})
export default class AppWFOpinion extends Vue {
    
    /**
     * 项名称
     * 
     * @type {string}
     * @memberof AppWFOpinion
     */
    @Prop() public name!: string;

    /**
     * 值
     * 
     * @type {*}
     * @memberof AppWFOpinion
     */
    @Prop() itemValue!: any;

    /**
     * 是否禁用
     * 
     * @type {boolean}
     * @memberof AppWFOpinion
     */
    @Prop({ default: false }) public disabled?: boolean;

    /**
     * 空白提示内容
     * 
     * @type {string}
     * @memberof AppWFOpinion
     */
    @Prop() public placeholder: any;

    /**
     * 应用上下文
     * 
     * @type {*}
     * @memberof AppWFOpinion
     */
    @Prop() public context: any;

    /**
     * 视图参数
     * 
     * @type {*}
     * @memberof AppWFOpinion
     */
    @Prop() public viewparams: any;

    /**
     * 输入框id
     * 
     * @type {*}
     * @memberof AppWFOpinion
     */
    @Prop() public textareaId: any;

    /**
     * 父容器
     * 
     * @type {*}
     * @memberof AppWFOpinion
     */
    @Prop() public parentContainer: any;

    /**
     * 容器高度
     * 
     * @type {number}
     * @memberof AppWFOpinion
     */
    @Prop({ default: 220 }) public containerHeight?: number;

    /**
     * 模式 
     * 
     * @type {"POPOVER" | "DEFAULT"}
     * @memberof AppWFOpinion
     */
    @Prop({ default: 'DEFAULT' }) public mode!: "POPOVER" | "DEFAULT";

    /**
     * 自定义过滤项
     * 
     * @type {string[]}
     * @memberof AppWFOpinion
     */
    @Prop() public customFilter?: string[];

    /**
     * 是否显示详情框
     * 
     * @type {boolean}
     * @memberof AppWFOpinion
     */
    public isShow: boolean = false;

    /**
     * 过滤选中项
     * 
     * @type {*}
     * @memberof AppWFOpinion
     */
    public selectItem: any = null;

    /**
     * 过滤项
     * 
     * @type {Array<any>}
     * @memberof AppWFOpinion
     */
    public filterItems: Array<any> = [];

    /**
     * 是否禁用缩小点击
     * 
     * @type {boolean}
     * @memberof AppWFOpinion
     */
    public enableClick: boolean = false;

    /**
     * 容器宽度
     * 
     * @type {number}
     * @memberof AppWFOpinion
     */
    public width: number = 700;

    /**
     * 配置
     * 
     * @type {number}
     * @memberof AppWFOpinion
     */
    public options = {
        'append-to-body': false
    }

    /**
     * 获取输入框绑定值
     * 
     * @type {*}
     * @memberof AppWFOpinion
     */
    get currentVal() {
        return this.itemValue;
    }

    /**
     * 设置输入框绑定值
     * 
     * @type {*}
     * @memberof AppWFOpinion
     */
    set currentVal(value: any) {
        this.initData(value);
        this.$emit('change', value);
    }

    /**
     * 值规则
     * 
     * @type {any[]}
     * @memberof AppWFOpinion
     */
    get rules() {
        if (this.parentContainer) {
            return [...this.parentContainer.rules?.[this.name]] || [];
        } else {
            return [];
        }
    }

    /**
     * 错误消息提示
     * 
     * @type {*}
     * @memberof AppWFOpinion
     */
    get error() {
        if (this.parentContainer) {
            return this.parentContainer.detailsModel?.[this.name]?.error || "";
        } else {
            return "";
        }
    }

    /**
     * 监听值变化
     * 
     * @type {*}
     * @memberof AppWFOpinion
     */
    @Watch('itemValue')
    public onValueChange(newVal: any, oldVal: any) {
        if (newVal !== oldVal) {
            this.currentVal = this.itemValue;
        }
    }

    /**
     * Vue生命周期 -- created
     * 
     * @memberof AppWFOpinion
     */
    public created() {
        this.handleFilterItems();
        this.initData();
    }

    /**
     * Vue生命周期 -- mounted
     * 
     * @memberof AppWFOpinion
     */
    public mounted() {
        if (this.mode === 'POPOVER') {
            this.$nextTick(() => {
                this.isShow = true;
                this.computePosition();
            })
            //窗口变化重新计算容器宽度
            window.addEventListener('resize', () => {
                this.computePosition();
            })
            this.watchDisplay();
        }
    }

    /**
     * 监听父容器显示变化，实现悬浮框显示状态切换
     * 
     * @memberof AppWFOpinion
     */
    public watchDisplay() {
        if (!this.parentContainer || !this.parentContainer.$el) {
            return;
        }
        let MutationObserver: any = window.MutationObserver;
        let element: any = this.parentContainer.$el.parentNode;
        let observer = new MutationObserver((mutations: any) => {
            mutations.forEach((mutation: any) => {
                if (mutation.type == "attributes") {
                    if (mutation.target.style.display == 'none' && mutation.target.style.visibility == 'hidden') {
                        this.isShow = false;
                    } else {
                        this.isShow = true;
                    }
                }
            });
        });
        observer.observe(element, {
            attributes: true,
            attributeFilter: ['style']
        });
    }

    /**
     * 数据初始化
     * 
     * @memberof AppWFOpinion
     */
    public initData(value: any = this.itemValue) {
        if (value && this.filterItems.find((item: any) => { return Object.is(item, value); })) {
            this.selectItem = value;
        } else {
            this.selectItem = null;
        }
    }

    /**
     * 位置计算
     * 
     * @memberof AppWFOpinion
     */
    public computePosition() {
        if (this.mode === 'POPOVER') {
            const dom: any = this.$refs['wf-opinion'];
            if (this.parentContainer && dom) {
                this.width = this.parentContainer.$el.offsetWidth;
                dom.style.height = this.isShow ? `${this.containerHeight}px` : '0px';
            }
        }
    }

    /**
     * 处理过滤项
     * 
     * @memberof AppWFOpinion
     */
    public handleFilterItems() {
        if (this.customFilter && this.customFilter.length) {
            this.customFilter = [...this.customFilter];
        } else {
            this.filterItems = ['同意', '不同意', '已阅'];
        }
    }

    /**
     * 过滤项点击
     * 
     * @param item 过滤项
     * @param event 点击事件
     * @memberof AppWFOpinion
     */
    public filterItemClick(item: any, event: any) {
        if (!item || Object.is(this.selectItem, item)) {
            return;
        }
        this.selectItem = item;
    }

    /**
     * 过滤项双击
     * 
     * @memberof AppWFOpinion
     */
    public filterItemDBClick(item: any, event: any) {
        if (!item) {
            return;
        }
        this.valueChange(item);
    }

    /**
     * 获取过滤项样式
     * 
     * @param item 过滤项
     * @memberof AppWFOpinion
     */
    public getClass(item: any) {
        if (this.selectItem && Object.is(this.selectItem, item)) {
            return ['filter-item', 'select-item'];
        }
        return ["filter-item"];
    }

    /**
     * 搜索
     * 
     * @param item 搜索值
     * @memberof AppWFOpinion
     */
    public onSearch(value: any) {
        //TODO
    }

    /**
     * 缩小按钮点击
     * 
     * @memberof AppWFOpinion
     */
    public minusClick() {
        if (!this.enableClick) {
            this.isShow = false;
            this.computePosition();
        }
    }

    /**
     * 按钮点击事件
     * 
     * @memberof AppWFOpinion
     */
    public click() {
        this.isShow = true;
        this.initData();
        this.computePosition();
        // this.scrollToContainer();
    }

    /**
     * 滚动到容器位置
     * 
     * @memberof AppWFOpinion
     */
    public scrollToContainer() {
        const cubic = (value: any) => Math.pow(value, 3);
        const easeInOutCubic = (value: any) => value > 0.5
            ? 1 - cubic((1 - value) * 2) / 2
            : cubic(value * 2) / 2;
        const el = this.parentContainer?.$el;
        if (!el) {
            return;
        }
        const beginTime = Date.now();
        const beginValue = el.scrollTop;
        const endValue = el.scrollHeight + this.containerHeight;
        const rAF = window.requestAnimationFrame || (func => setTimeout(func, 16));
        const frameFunc = () => {
            const progress = (Date.now() - beginTime) / 500;
            if (progress < 1) {
                el.scrollTop = (endValue - beginValue) * (easeInOutCubic(progress)) + beginValue;
                rAF(frameFunc);
            } else {
                el.scrollTop = endValue;
            }
        };
        rAF(frameFunc);
    }

    /**
     * 值变更
     * 
     * @memberof AppWFOpinion
     */
    public valueChange(value: any) {
        this.currentVal = value;
    }

    /**
     * 销毁
     * 
     * @memberof AppWFOpinion
     */
    public destroyed() {
        if (this.mode === 'POPOVER') {
            window.removeEventListener('resize', () => {});
        }
    }

}    
</script>