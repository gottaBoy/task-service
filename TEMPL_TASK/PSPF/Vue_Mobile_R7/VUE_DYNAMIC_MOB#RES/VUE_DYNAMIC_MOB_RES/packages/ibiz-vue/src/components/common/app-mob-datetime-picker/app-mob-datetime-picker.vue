<template>
  <div class="app-mob-datetime-picker">
    <ion-datetime
      class="form-value-content"
      :max="max"
      :min="min"
      :display-format="displayFormat"
      :value="curValue"
      :placeholder="placeholder"
      :readonly="readOnly"
      :disabled="disabled"
      :cancel-text="$t('cancel_text')"
      :done-text="$t('done_text')"
      @ionChange="valueChange($event)"
      @ionCancel="clear"
      @ionFocus="enter"
      @ionBlur="leave"
    ></ion-datetime>
  </div>
</template>
<script lang="ts">
import { Vue, Component, Prop, Watch } from "vue-property-decorator";
const moment = require("moment");
@Component({
  i18n: {
    messages: {
      "ZH-CN": {
        cancel_text: "取消",
        done_text: "完成",
      },
      "EN-US": {
        cancel_text: "cancel",
        done_text: "submit",
      },
    },
  }
})
export default class AppDateTimePicker extends Vue {
  /**
   * 传入值
   *
   * @type {string}
   * @memberof AppDateTimePicker
   */
  @Prop() public value!: string;

  /**
   * 编辑器名称
   *
   * @type {string}
   * @memberof AppDateTimePicker
   */
  @Prop() public name?: string;

  /**
   * 是否禁用
   *
   * @type {boolean}
   * @memberof AppDateTimePicker
   */
  @Prop() public disabled?: boolean;

  /**
   * 是否只读
   *
   * @type {boolean}
   * @memberof AppDateTimePicker
   */
  @Prop() public readOnly?: boolean;

  /**
   * placeholder
   *
   * @type {boolean}
   * @memberof AppDateTimePicker
   */
  @Prop() public placeholder?: string;

  /**
   * 时间精度
   * @memberof AppDateTimePicker
   */
  @Prop({ default: "YYYY-MM-DD" }) public displayFormat?: string;

  /**
   * 当前选中值
   * @memberof AppDateTimePicker
   */
  public curValue: any = "";

  /**
   * 当前日期
   * @type {*}
   * @memberof MOBILEENTITY3Canlen
   */
  protected currentDate: any = new Date().getFullYear();

  /**
   * 最小值
   * @memberof AppDateTimePicker
   */
  public min: any = this.currentDate - 100;

  /**
   * 最大值
   * @memberof AppDateTimePicker
   */
  public max: any = this.currentDate + 100;

  /**
   * 监控值变化
   * @memberof AppDateTimePicker
   */
  @Watch("value", { immediate: true })
  public on_value_change(newVal: string, oldVal: any) {
    if (!newVal) {
      this.curValue = null;
      return;
    }
    this.curValue = moment(newVal).format(this.displayFormat);
  }

  /**
   * 时间选择改变
   *
   * @param event{*}
   * @memberof AppDateTimePicker
   */
  public valueChange(event: any) {
    this.curValue = moment(event.detail.value).format(this.displayFormat);
    const tempTime = moment(this.value).format(this.displayFormat);
    if (Object.is("Invalid date", this.curValue)) {
      this.curValue = null;
    }
    if (Object.is(this.curValue, tempTime)) {
      return;
    }
    this.$emit("change", {
      name: this.name,
      value: this.curValue,
      event: event,
    });
  }

  /**
   * 清空值
   * @memberof AppDateTimePicker
   */
  public clear(event: any) {
    this.curValue = null;
    this.$emit("change", { name: this.name, value: "", event: event });
  }

  /**
   * 有焦点时事件
   *
   * @memberof AppDateTimePicker
   */
  public enter(e: any) {
    this.$emit("enter", { name: this.name, value: this.curValue, event: e });
  }

  /**
   * 失去焦点事件
   *
   * @memberof AppDateTimePicker
   */
  public leave(e: any) {
    this.$emit("leave", { name: this.name, value: this.curValue, event: e });
  }
}
</script>
