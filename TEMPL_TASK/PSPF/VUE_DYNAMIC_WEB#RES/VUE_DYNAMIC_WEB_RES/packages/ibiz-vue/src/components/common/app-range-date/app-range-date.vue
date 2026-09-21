<template>
  <div class="app-range-date">
    <span class="app-range-date__caption">{{$t('components.apprangdate.from')}}</span>
    <template v-for="(item, index) in refFormItem">
      <span v-if="index > 0" class="app-range-date__editor-separator" :key="index">{{$t('components.apprangdate.daystart')}}</span>
      <date-picker
        :key="index + '-onlydate'"
        v-if="Object.is(editorType, 'DATEPICKEREX') || Object.is(editorType, 'DATEPICKEREX_NOTIME') && index == 0"
        type="date"
        :transfer="true"
        :format="valFormat"
        :placeholder="$t('components.apprangdate.placeholder')"
        :value="activeData[item]"
        :disabled="disabled"
        :readonly="readonly"
        @on-change="startOnValueChange"
      ></date-picker>

      <date-picker
        :key="index + '-onlydate'"
        v-if="Object.is(editorType, 'DATEPICKEREX') || Object.is(editorType, 'DATEPICKEREX_MINUTE') && index == 0"
        type="datetime"
        :transfer="true"
        :format="valFormat"
        :placeholder="$t('components.apprangdate.placeholder')"
        :value="activeData[item]"
        :disabled="disabled"
        :readonly="readonly"
        @on-change="startOnValueChange"
      ></date-picker>

      <date-picker
        :key="index + '-onlydate'"
        v-if="Object.is(editorType, 'DATEPICKEREX') || Object.is(editorType, 'DATEPICKEREX_NOTIME') && index == 1"
        type="date"
        :transfer="true"
        :format="valFormat"
        :placeholder="$t('components.apprangdate.placeholder')"
        :value="activeData[item]"
        :disabled="disabled"
        :readonly="readonly"
        @on-change="endOnValueChange"
      ></date-picker>

      <date-picker
        :key="index + '-onlydate'"
        v-if="Object.is(editorType, 'DATEPICKEREX') || Object.is(editorType, 'DATEPICKEREX_MINUTE') && index == 1"
        type="datetime"
        :transfer="true"
        :format="valFormat"
        :placeholder="$t('components.apprangdate.placeholder')"
        :value="activeData[item]"
        :disabled="disabled"
        :readonly="readonly"
        @on-change="endOnValueChange"
      ></date-picker>
      <span v-if="index  > 0" :key="index + '-only'" class="app-range-date__editor-separator">{{$t('components.apprangdate.dayend')}}</span>
    </template>
  </div>
</template>

<script lang="ts">
import { Component, Vue, Prop, Model, Watch } from "vue-property-decorator";
import { Subject, Subscription } from "rxjs";
import { debounceTime, distinctUntilChanged } from "rxjs/operators";

@Component({
})
export default class AppRangDate extends Vue {
  /**
   * 编辑项名称
   *
   * @type {string}
   * @memberof AppRangDate
   */
  @Prop() public name!: string;

  /**
   * 是否禁用
   *
   * @type {boolean}
   * @memberof AppRangDate
   */
  @Prop() public disabled!: boolean;

  /**
   * 表单数据对象
   *
   * @type {*}
   * @memberof AppRangDate
   */
  @Prop() public activeData: any;

  /**
   * 值格式
   *
   * @type {string}
   * @memberof AppRangDate
   */
  @Prop() public format!: string;

  /**
   * 编辑器类型
   *
   * @type {string}
   * @memberof AppRangDate
   */
  @Prop() public editorType!: string;

  /**
   * 关系表单项集合
   *
   * @type {string[]}
   * @memberof AppRangDate
   */
  @Prop() public refFormItem!: string[];

  /**
   * 只读模式
   * 
   * @type {boolean}
   */
  @Prop({default: false}) public readonly?: boolean;

  /**
   * 值变化时间
   *
   * @private
   * @type {Subject<any>}
   * @memberof AppRangDate
   */
  private inputDataChang: Subject<any> = new Subject();

  /**
   * 处理值格式
   *
   * @readonly
   * @memberof AppRangDate
   */
  get valFormat() {
    return this.format.replace("YYYY", "yyyy").replace("DD", "dd");
  }

  /**
   * 获取值
   *
   * @param {string} name
   * @returns
   * @memberof AppRangDate
   */
  public getValue(name: string) {
    return this.activeData[name];
  }

  /**
   * 设置值
   *
   * @param {string} name
   * @param {*} val
   * @memberof AppRangDate
   */
  public setValue(name: string, val: any) {
    this.inputDataChang.next({ name: name, value: val });
  }

    /**
     * 表单状态事件
     *
     * @private
     * @type {(Subscription | undefined)}
     * @memberof AppImagePreview
     */
    private formStateEvent: Subscription | undefined;

  /**
   * vue  声明周期 debounceTime
   *
   * @memberof AppRangDate
   */
  public created() {
    this.formStateEvent = this.inputDataChang
      .pipe(debounceTime(500), distinctUntilChanged())
      .subscribe((data: any) => {
        this.$emit("formitemvaluechange", {
          name: data.name,
          value: data.value
        });
      });
  }

  /**
   * @description:组件销毁 
   * 
   * @return {*}
   */  
  public destroyed(){
    if(this.formStateEvent){
      this.formStateEvent.unsubscribe();
    }
  }

  /**
   * 开始时间值改变
   *
   * @param {string} name
   * @param {*} value
   * @memberof AppRangDate
   */
  public startOnValueChange(value: any, name: string) {
    this.$emit("formitemvaluechange", {
      name: this.refFormItem[0],
      value: value
    });
  }

  /**
   * 结束时间值改变
   * @param {string} name
   * @param {*} value
   * @memberof AppRangDate
   */
  public endOnValueChange(value: any, name: string) {
    this.$emit("formitemvaluechange", {
      name: this.refFormItem[1],
      value: value
    });
  }
}
</script>
