<template>
    <drawer
        class="app-drawer"
        :placement="placement"
        :closable="false"
        v-model="isShow"
        :width="width"
        :before-close="beforeClose"
        @on-visible-change="onVisibleChange($event)"
        @on-close="close(tempResult)"
    >
        <component
            :is="viewname"
            class="view-container2"
            :staticProps="{ ...this.staticProps, viewDefaultUsage:false}"
            :dynamicProps="{ ...this.dynamicProps }"
            @viewdataschange="dataChange($event)"
            @viewdatasactivated="viewDatasActivated($event)"
            @close="close($event)"
            :ref="viewname">
        </component>
    </drawer>
</template>
<script lang="ts">
import { Vue, Component, Prop } from "vue-property-decorator";
import { Subject } from "rxjs";
import { AppDrawer } from './app-drawer';
import { Util } from 'ibiz-core'
@Component({
    components: {}
})
export default class AppDrawerCompponent extends Vue {

    /**
     * 视图UI参数
     *
     * @type {any}
     * @memberof AppDrawerCompponent
     */ 
    @Prop() public view !:any;

    /**
     * 视图动态参数
     *
     * @type {any}
     * @memberof AppDrawerCompponent
     */ 
    @Prop({default:{}}) public dynamicProps?:any;

    /**
     * 视图静态参数
     *
     * @type {any}
     * @memberof AppDrawerCompponent
     */ 
    @Prop({default:{}}) public staticProps?:any;

    /**
     * 数据传递对象
     *
     * @type {any}
     * @memberof AppDrawerCompponent
     */ 
    public subject: null | Subject<any> = new Subject<any>();

    /**
     * 抽屉弹出位置
     *
     * @type {string}
     * @memberof AppDrawerCompponent
     */
    public placement:string = '';

    /**
     * 是否显示
     *
     * @type {boolean}
     * @memberof AppDrawerCompponent
     */
    public isShow:boolean = false;

    /**
     * 零时结果
     *
     * @type {any}
     * @memberof AppDrawerCompponent
     */  
    public tempResult:any = { ret: '' };

    /**
     * 视图名称
     *
     * @type {string}
     * @memberof AppDrawerCompponent
     */ 
    public viewname:string = '';

    /**
     * 视图宽度
     *
     * @type {number}
     * @memberof AppDrawerCompponent
     */ 
    public width:number = 256;

    /**
     * 视图层级
     *
     * @type {any}
     * @memberof AppDrawerCompponent
     */ 
    public zIndex:any = null;

    /**
     * 是否在抽屉区按下鼠标
     *
     * @type {any}
     * @memberof AppDrawerCompponent
     */ 
    public isMouseDown: boolean = false;

    /**
     * 获取数据传递对象
     *
     * @memberof AppDrawerCompponent
     */ 
    public getSubject(){
        return this.subject;
    }

    /**
     * Vue生命周期created
     *
     * @memberof AppDrawerCompponent
     */ 
    public created() {
        this.viewname = this.view.viewname;
        this.placement = this.view.placement === 'DRAWER_LEFT' ? 'left' : 'right';
        if (this.view.width) {
            if (this.view.width.toString().indexOf('px') > 0) {
                if (!Object.is(this.view.width, '0px')) {
                    this.width = parseInt(this.view.width.toString().slice(0, this.view.width.toString().length - 2));
                } else {
                    this.width = 800;
                }
            } else {
                if (this.view.width !== 0) {
                    this.width = this.view.width;
                } else {
                    this.width = 800;
                }
            }
        } else {
            this.width = 800;
        }
        document.onkeydown = (e: any) => {
            var keyCode = e.keyCode || e.which || e.charCode;
            if (keyCode == 27) {
                const zIndex = this.$store.getters.getZIndex();
                if (zIndex !== this.zIndex) {
                    return;
                }
                this.isShow = false;
            }
        }
        // 监听鼠标是否在抽屉内容区按下
        document.onmousedown = (e: any) => {
            const documentPaths = e.path;
            this.isMouseDown = false;
            if (documentPaths?.length > 0) {
                documentPaths.forEach((path: any) => {
                    if (path.className == 'ivu-drawer-content') {
                        this.isMouseDown = true;
                    }
                })
            }
        }
    }

    /**
     * Vue生命周期mounted
     *
     * @memberof AppDrawerCompponent
     */ 
    public mounted() {
        this.isShow = true;
        this.handleZIndex('ivu-drawer-mask', 'ivu-drawer-wrap');
    }

    /**
     * Vue生命周期beforeDestroy
     *
     * @memberof AppDrawerCompponent
     */ 
    public beforeDestroy() {
        if (this.zIndex) {
            const zIndex: any = this.zIndex;
            this.$store.commit('updateZIndex', zIndex - 100);
        }
    }

    /**
     * 处理 z-index
     *
     * @memberof AppDrawerCompponent
     */ 
    public handleZIndex(mask: string, wrap: string) {
        const zIndex = this.$store.getters.getZIndex();
        if (zIndex) {
            this.zIndex = zIndex + 100;
            this.$store.commit('updateZIndex', this.zIndex);
        }
        const element: Element = this.$el;
        const maskTag: any = element.getElementsByClassName(mask)[0];
        const warpTag: any = element.getElementsByClassName(wrap)[0];
        maskTag.style.zIndex = this.zIndex;
        warpTag.style.zIndex = this.zIndex;
    }

    /**
     * 关闭之前
     * 在内容区按下鼠标，在其他地方松开鼠标时不关闭抽屉
     * @memberof AppDrawerCompponent
     */ 
    public beforeClose() {
        return new Promise((resolve: any, reject: any) => {
            if (this.isMouseDown) {
                this.isMouseDown = false;
                return
            }
            resolve(true)
        })
    }

    /**
     * 关闭回调
     *
     * @memberof AppDrawerCompponent
     */ 
    public close(result: any) {
        if (result && Array.isArray(result)) {
            Object.assign(this.tempResult, { ret: 'OK' }, { datas: Util.deepCopy(result) });
        }
        this.isShow = false;
    }

    /**
     * 数据变化回调
     *
     * @memberof AppDrawerCompponent
     */ 
    public dataChange(result: any) {
        this.tempResult = { ret: '' };
        if (result && Array.isArray(result) && result.length > 0) {
            Object.assign(this.tempResult, { ret: 'OK' }, { datas: Util.deepCopy(result) });
        }
    }

    /**
     * 激活数据回调
     *
     * @memberof AppDrawerCompponent
     */ 
    public viewDatasActivated(result: any) {
        if (result && Array.isArray(result) && result.length > 0) {
            this.close(result);
        }
    }

    /**
     * 抽屉显示隐藏回调
     *
     * @memberof AppDrawerCompponent
     */ 
    public onVisibleChange($event: any) {
        const component: any = this.$refs[this.viewname];
        if (component) {
            const viewInstance = component.$children[0];
            const viewDataChange = this.$store.getters["viewAction/getStateByViewTag"](viewInstance?.viewtag);
            if (viewDataChange) {
                this.isShow = true;
                const title: any = this.$t('app.tabpage.sureclosetip.title');
                const contant: any = this.$t('app.tabpage.sureclosetip.content');
                this.$Modal.confirm({
                    title: title,
                    content: contant,
                    onOk: () => {
                        this.$store.commit('viewAction/removeViewByViewTag', viewInstance.viewtag);
                        this.isShow = false;
                    },
                    onCancel: () => {
                        this.isShow = true;
                    }
                });
            } else {
              this.handleShowState($event);
            } 
        }
    }

    /**
     * 处理显示隐藏状态
     *
     * @memberof AppDrawerCompponent
     */ 
    public handleShowState($event: any) {
        if ($event) {
            return;
        }
        
        setTimeout(() => {
            if (this.subject) {
                if (this.tempResult && Object.is(this.tempResult.ret, 'OK')) {
                    this.subject.next(this.tempResult);
                }
            }
            document.body.removeChild(this.$el);
            this.$destroy();
            AppDrawer.getInstance().destroyVueExample();
            this.subject = null;
        }, 500)
    }

}
</script>
<style lang="less">
@import './app-drawer.less';
</style>