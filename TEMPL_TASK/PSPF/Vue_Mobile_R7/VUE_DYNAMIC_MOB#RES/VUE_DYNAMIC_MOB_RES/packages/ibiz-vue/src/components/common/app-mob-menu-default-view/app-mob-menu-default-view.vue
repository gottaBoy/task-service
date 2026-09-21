<template>
  <van-tabbar :fixed="false" v-model="activeIndex">
    <template v-for="item,index in items">
      <template v-if="!item.hidden">
        <van-tabbar-item :key="item.name" :class="{'menu__item':true,'menu__item--active':index == activeIndex}">
          <ion-icon slot="icon" :name="getIconName(item)"></ion-icon>
          <ion-label>{{ item.caption }}</ion-label>
        </van-tabbar-item>
      </template>
    </template>
  </van-tabbar>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator';
import { ViewTool } from 'ibiz-core';
@Component({
  components: {},
})
export default class AppMobMenuDefaultView extends Vue {
  /**
   * 菜单数据项
   *
   * @type {Array<any>}
   * @memberof AppMobMenuDefaultView
   */
  @Prop() public items!: Array<any>;

  /**
   * 计数器名称
   *
   * @type {string}
   * @memberof AppMobMenuDefaultView
   */
  @Prop() public counterName!: string;

  /**
   * 当前激活的菜单项
   *
   * @type {string}
   * @memberof AppMobMenuDefaultView
   */
  @Prop() public value?: number;

  /**
   * 当前激活的菜单项
   *
   * @type {string}
   * @memberof AppMobMenuDefaultView
   */
  get activeIndex() {
    let index = this.items.findIndex((temp: any) => {
      return temp.name === this.value;
    });
    return index;
  }

  /**
   * 激活的菜单项变更
   *
   * @param {*} item
   * @returns
   * @memberof AppMobMenuDefaultView
   */
  set activeIndex(index:any) {
    if(!this.value){
      return;
    }
    this.$emit('select', this.items[index].name);
    if(this.items[index].getPSAppFunc?.appFuncType =='APPVIEW'){
      sessionStorage.setItem('selectmenu',this.items[index]?.name || '');
    }
  }


  /**
   * 计数器数据
   *
   * @type {*}
   * @memberof AppMobMenuDefaultView
   */
  public counterdata: any = {};

  /**
   * 计数器
   *
   * @memberof AppMobMenuDefaultView
   */
  public counterServide: any = null;

  /**
   * 图标
   *
   * @type {string}
   * @memberof AppMobMenuDefaultView
   */
  public getIconName(item: any) {
    if (item.getPSSysImage?.cssClass) {
      return ViewTool.setIcon(item.getPSSysImage?.cssClass);
    } else {
      return 'home';
    }
  }

  /**
   * 解析菜单模型数据
   *
   * @memberof AppMobMenuDefaultView
   */
  public parseMenuData() {
    const selectName =  sessionStorage.getItem('selectmenu');
    if(selectName){
      this.$emit('default-select', selectName);
      return;
    }
    let index = this.items.findIndex((temp: any) => {
      return temp.opendefault;
    });
    if (index != -1) {
      this.activeIndex = index;
      this.$emit('default-select', this.items[index].name);
    } else {
      this.$emit('default-select', this.items?.[0]?.name);
    }
  }

  /**
   * 生命周期
   *
   * @memberof AppMobMenuDefaultView
   */
  public mounted() {
    this.parseMenuData();
  }


  /**
   * vue 生命周期
   *
   * @memberof AppMobMenuDefaultView
   */
  public destroyed() {
    if (this.counterServide) {
      this.counterServide.destroyCounter();
    }
  }

  /**
   * 加载计数器数据
   *
   * @returns {Promise<any>}
   * @memberof AppMobMenuDefaultView
   */
  public async loadCounterData(): Promise<any> {
    // todo
    // const counterServiceConstructor = window.counterServiceConstructor;
    // this.counterServide = await counterServiceConstructor.getService(this.counterName);
  }
}
</script>