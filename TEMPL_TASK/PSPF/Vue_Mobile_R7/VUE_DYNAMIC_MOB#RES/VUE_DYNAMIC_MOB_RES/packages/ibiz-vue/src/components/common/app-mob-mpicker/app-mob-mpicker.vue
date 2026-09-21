<template>
  <div class="app-mob-mpicker">
    <ion-input :disabled="disabled" :value="(curValue.length > 0 ? 'hasValue' : '')" readonly @click="openView" @ionFocus="enter" @ionBlur="leave">
      <div class="app-mob-mpicker__text" >
        <template v-for="(item,index) in curValue">
              {{item.srfmajortext}}
            <span v-if="index < curValue.length-1" :key="index">,</span>
        </template>
      </div>
    </ion-input>
    <app-mob-icon class="right-common-icon" v-if="!(curValue.length > 0)" name="search-outline" @onClick="openView"></app-mob-icon>
    <app-mob-icon  v-else class="right-common-icon" name="close-circle-outline" @onClick="onClear"></app-mob-icon>
  </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from "vue-property-decorator";
import { Subject } from "rxjs";
import { ViewOpenService } from "ibiz-vue";
import { ViewTool } from "ibiz-core";

@Component({})
export default class AppMobMpicker extends Vue {
    /**
     * 表单数据
     *
     * @type {*}
     * @memberof AppMobMpicker
     */
    @Prop() public data!: any;

    /**
     * 是否启用
     *
     * @type {boolean}
     * @memberof AppMobMpicker
     */
    @Prop({default:false}) public disabled?: boolean;

    /**
     * 应用实体主键属性名称
     *
     * @type {string}
     * @memberof AppPicker
     */
    @Prop({ default: 'srfkey' }) public deKeyField!: string;

    /**
     * 值
     *
     * @type {*}
     * @memberof AppMobMpicker
     */
    @Prop() public value?: any;

    /**
     * 属性项名称
     *
     * @type {string}
     * @memberof AppMobMpicker
     */
    @Prop() public name!: string;

    /**
     * 视图上下文
     *
     * @type {*}
     * @memberof AppMobMpicker
     */
    @Prop() public context!: any;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppMobMpicker
     */
    @Prop() public viewparams!: any;

    /**
     * 视图参数（如：视图name，title，width，height）
     *
     * @type {*}
     * @memberof AppMobMpicker
     */
    @Prop() public pickupView?: any;

    /**
     * 导航参数
     *
     * @type {*}
     * @memberof AppSelect
     */
    @Prop() protected navigateParam?: any;

    /**
     * 导航上下文
     *
     * @type {*}
     * @memberof AppSelect
     */
    @Prop() protected navigateContext?: any;

    /**
     * 视图打开服务
     *
     * @type {ViewOpenService}
     * @memberof AppPicker
     */
    public openService: ViewOpenService = ViewOpenService.getInstance();

    /**
     * 源数组
     * @type {any[]}
     * @memberof AppMobMpicker
     */
    public items: any[] = [];

    /**
     * 值
     *
     * @type {*}
     * @memberof AppMobMpicker
     */
    get curValue() {
      if (this.value) {
        return JSON.parse(this.value);
      }
      return [];
    }

    /**
     * 打开视图
     */
    public async openView($event: any) {
      if (this.disabled) {
        return;
      }
      // 公共参数处理
      let data: any = {};
      const bcancel: boolean = this.handlePublicParams(data);
      if (!bcancel) {
        return;
      }
      // 参数处理
      const view = { ...this.pickupView };
      let _context = data.context;
      let _param = data.param;
      let select:any = []
      this.curValue.forEach((temp:any) => {
        select.push({srfmajortext:temp.text,srfkey:temp.value})
      });
      _param = Object.assign(_param,{ selectedData: [...select]});
      // 判断打开方式
      if(!view.viewModelData?.codeName){
          this.$Notice.error(this.$t('app.commonWords.notFoundPickerView'));
          return;
      }
      const openMode = view.viewModelData.openMode;
     if(openMode && openMode.indexOf('DRAWER') != -1){
            this.openDrawer(view, _context, _param);
        } else if(openMode  === 'POPOVER'){
            this.openPopOver(view, _context, _param);
        }else{
           this.openPopupModal(view, _context, _param);
        }
    }

      /**
       * 模态模式打开视图
       *
       * @private
       * @param {*} view
       * @param {*} data
       * @memberof AppMobMpicker
       */
      private async openPopupModal(view: any, context: any, param: any): Promise<any> {
          const result: any = await this.openService.openModal(view, context, param);
          if (result || Object.is(result.ret, 'OK')) {
              this.openViewClose(result);
          }
      }

    /**
     * 抽屉模式打开视图
     *
     * @private
     * @param {*} view
     * @param {*} data
     * @memberof AppMobMpicker
     */
    private async openDrawer(view: any, context: any, param: any): Promise<any> {
      let container: Subject<any> = await this.openService.openDrawer(
        view,
        context,
        param
      );
      container.subscribe((result: any) => {
        if (!result || !Object.is(result.ret, "OK")) {
          return;
        }
        this.openViewClose(result);
      });
    }


    /**
     * 气泡模式打开视图
     *
     * @private
     * @param {*} view
     * @param {*} data
     * @memberof AppPicker
     */
    private async openPopOver(view: any, context: any, param: any,customParam?:any): Promise<any> {
        let result: any = await this.openService.openPopOver(view, context, param,customParam);
        if (result || Object.is(result.ret, 'OK')) {
            this.openViewClose(result);
        }
    }

    /**
     * 公共参数处理
     *
     * @param {*} arg
     * @returns
     * @memberof AppMobMpicker
     */
    public handlePublicParams(arg: any): boolean {
        if (!this.data) {
            return false;
        }
        // 导航参数处理
        const {context, param} = ViewTool.formatNavigateParam( this.navigateContext, this.navigateParam, this.context, this.viewparams, this.data );
        arg.context =  context;
        arg.param = param;
        return true;
    }

    /**
     * 打开页面关闭
     *
     * @param {*} result
     * @memberof AppMobMpicker
     */
    public openViewClose(result: any) {
      let datas: any = [];
      let valueDatas: any = [];
      if (result.datas && Array.isArray(result.datas)) {
        result.datas.forEach((data: any) => {
          datas.push({ srfmajortext: data.srfmajortext, srfkey: data.srfkey });
        });
      }
      if (this.name) {
        this.$emit("formitemvaluechange", {
          name: this.name,
          value: datas.length > 0 ? JSON.stringify(datas) : null,
          event: {}
        });
      }
    }

    /**
     * 清除
     */
    public onClear($event: any): void {  
        if (this.name) {
            this.$emit('formitemvaluechange', { name: this.name, value: '', event:{} });
        }
    }

    /**
     * 有焦点时事件
     *
     * @memberof AppMobMpicker
     */
    public enter(e: any) {
        this.$emit('enter', {name: this.name, value: this.value, event:e});
    }

    /**
     * 失去焦点事件
     *
     * @memberof AppMobMpicker
     */
    public leave(e: any) {
        this.$emit('leave', {name: this.name, value: this.value, event:e});
    }      
}
</script>