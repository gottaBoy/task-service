<template>
    <div class="app-mob-menu-list-view">
        <ion-card-content class="app-mob-menu-list-view__content">
            <ion-list>
                <template v-for="(item,index) in items">
                    <ion-item :key="index" @click="selectItem(item.name)" :class="item.textcls?item.textcls:''">
                            <!-- 图片-->
                           <app-ps-sys-image slot="start" :imageModel="item.getPSSysImage" ></app-ps-sys-image>
                        <ion-label>
                            {{item.caption}}
                        </ion-label>
                        <template v-if="counterdata[item.counterid]">
                            <ion-badge color="danger" slot="end">{{counterdata[item.counterid]}}</ion-badge>
                        </template>
                    </ion-item>
                </template>
            </ion-list>
        </ion-card-content>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Emit } from 'vue-property-decorator';
@Component({
    components: {
    }
})
export default class AppMobMenuListView extends Vue {

    /**
     * 菜单名称
     *
     * @type {string}
     * @memberof AppMobMenuListView
     */
    @Prop() public menuName!: string;

    /**
     * 菜单数据项
     *
     * @type {Array<any>}
     * @memberof AppMobMenuListView
     */
    @Prop() public items!: Array<any>;

    /**
     * 计数器名称
     *
     * @type {string}
     * @memberof AppMobMenuListView
     */
    @Prop() public counterName!: string;

    /**
     * 菜单选中事件
     *
     * @param {*} val
     * @returns
     * @memberof AppMobMenuListView
     */
    @Emit()
    select(val: any) {
        return val;
    }

    /**
     * 选中菜单项
     *
     * @param {string} name
     * @memberof AppMobMenuListView
     */
    public selectItem(name: string): void {
        this.select(name);
    }

    /**
     * 计数器数据
     *
     * @type {*}
     * @memberof AppMobMenuListView
     */
    public counterdata: any = {};

    /**
     * vue 生命周期
     *
     * @memberof AppMobMenuListView
     */
    public created() {
        this.loadCounterData();
    }

    /**
     * vue 生命周期
     *
     * @memberof AppMobMenuListView
     */
    public destroyed() {
        this.counterdata = null;
    }

    /**
     * 加载计数器数据
     *
     * @returns {Promise<any>}
     * @memberof AppMobMenuListView
     */
    public async loadCounterData(): Promise<any> {
        // todo 计数器
        // const counterServiceConstructor = window.counterServiceConstructor;
        // const counterServide = await counterServiceConstructor.getService(this.counterName);
        // if (counterServide) {
        //     this.counterdata = counterServide.counterData;
        // }
    }
}
</script>