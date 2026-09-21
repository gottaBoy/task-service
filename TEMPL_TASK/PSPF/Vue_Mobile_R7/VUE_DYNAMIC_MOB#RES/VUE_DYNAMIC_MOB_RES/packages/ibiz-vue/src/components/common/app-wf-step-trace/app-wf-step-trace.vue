<template>
  <div class="app-wf-step-trace">
    <template v-for="(usertask, usertaskIndex) in data.usertasks">
      <div
        class="app-wf-step-trace__item"
        v-if="usertask.comments.length > 0"
        :key="usertaskIndex"
      >
        <div class="app-wf-step-trace__item__top">
          <div class="item__time">
            {{
              usertask.comments[usertask.comments.length - 1] &&
              formatDate(
                usertask.comments[usertask.comments.length - 1].time,
                "MM月DD日 HH:mm:ss"
              )
            }}
          </div>
          <div class="item__border">
            <div class="item__action-line"></div>
          </div>
          <div class="item__text">
            <span class="name" v-if="usertask.comments && usertask.comments.length>0">{{usertask.comments[0].authorName}} </span>
            <span class="action">执行了 </span>
            <span class="action-name">{{ usertask.userTaskName }} </span>
            <span>操作</span>
          </div>
        </div>
      </div>
      {{data.usertasks.length}}
      <div
        :class="{'app-wf-step-trace__item':true,'app-wf-step-trace__item--action':true}"
        v-if="usertask.identitylinks.length > 0"
        :key="usertaskIndex"
      >
        <div class="app-wf-step-trace__item__top">
          <div class="item__time">
            当前
          </div>
          <div class="item__border">
          </div>
          <div class="item__action-text">
            <span class="action-name">{{ usertask.userTaskName }}</span>
          </div>
        </div>
      </div>
    </template>
  </div>
</template>

<script lang="ts">
import { DataServiceHelp } from "ibiz-core";
import moment from "moment";
import { Vue, Component, Prop } from "vue-property-decorator";

@Component({})
export default class AppWfStepTrace extends Vue {
  /**
   * 数据
   *
   *  @memberof AppWfStepTrace
   */
  public data: any = {};

  /**
   *  初始化memo
   *
   *  @memberof AppWfStepTrace
   */
  public initmemo: string = "";

  /**
   *  子项索引初始值
   *
   *  @memberof AppWfStepTrace
   */
  public usertasksIndex: number = 1;

  /**
   *  子项长度初始值
   *
   *  @memberof AppWfStepTrace
   */
  public usertasksLength: number = 1;

  /**
   * 应用实体名称
   *
   * @memberof AppWfStepTrace
   */
  @Prop() public appEntityCodeName!: string;
  /**
   * 应用实体名称
   *
   * @memberof AppWfStepTrace
   */
  @Prop() public appEntity!: any;

  /**
   *  上下文
   *
   *  @memberof AppWfStepTrace
   */
  @Prop() public context: any;

  /**
   *  视图参数
   *
   *  @memberof AppWfStepTrace
   */
  @Prop() public viewparams: any;

  /**
   * 初始化数据
   *
   *  @memberof AppWfStepTrace
   */
  public created() {
    if (this.appEntityCodeName) {
      DataServiceHelp.getInstance()
        .getService(this.appEntity, this.context)
        .then((service: any) => {
          if (service) {
            service.GetWFHistory(this.context,this.viewparams).then((res: any) => {
              if (res && res.status === 200) {
                this.data = res.data;
                this.initUIStateData();
              }
            });
          }
        });
    }
  }

  /**
   * 初始化数据添加标记
   *
   *  @memberof AppWfStepTrace
   */
  public initUIStateData() {
    if (this.data && this.data.usertasks) {
      this.usertasksIndex = 1;
      for (let i in this.data.usertasks) {
        this.data.usertasks[i].isShow = false;
        this.data.usertasks[i].index = this.usertasksIndex;
        this.usertasksIndex++;
      }
      this.usertasksLength = this.usertasksIndex - 1;
      this.$forceUpdate();
    }
  }

  /**
   * 时间转换
   *
   *  @memberof AppWfStepTrace
   */
  public formatDate(date: string, format: string) {
    return moment(date).format(format);
  }

  /**
   * 点击事件
   *
   *  @memberof AppWfStepTrace
   */
  public changeExpand(usertask: any) {
    usertask.isShow = !usertask.isShow;
    this.$forceUpdate();
  }

  /**
   * 办理人员名称显示去重
   *
   * @param tag 需要去重的名称标识
   * @param datas 需要去重数据集
   * @memberof AppWfStepTrace
   */
  public acceptingOfficerNodup(tag: string, datas: any[]): any[] {
    let tempData: any[] = [];
    if (datas?.length > 0 && tag) {
      datas.forEach((data: any) => {
        tempData.push(data[tag]);
      });
    }
    const nodup = [...new Set(tempData)];
    return nodup;
  }
}
</script>