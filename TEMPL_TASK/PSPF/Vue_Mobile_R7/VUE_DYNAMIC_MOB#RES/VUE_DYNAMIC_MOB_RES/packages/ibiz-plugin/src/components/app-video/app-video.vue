<template>
  <div :id="uuid"></div>
</template>

<script lang="ts">
import Player from "xgplayer";
import { Util } from "ibiz-core";
import { Component, Vue, Prop } from "vue-property-decorator";
@Component({})
export default class AppVideo extends Vue {
    /**
     * 播放器唯一标识
     */
    public uuid: string = Util.createUUID();

    /**
     * 视频播放数据
     */
    @Prop() public videoParmas?: any;

    get Params() {
      return this.videoParmas ? this.videoParmas : {};
    }

    /**
     * 生命周期
     */
    public mounted() {
      let player = new Player({
        id: this.uuid,
        url: this.videoParmas?.path,
        fluid: true,
        volume: this.videoParmas?.mute ? 0 : 0.8,
        autoplay: this.videoParmas?.autoplay ? true : false,
        loop: this.videoParmas?.replay ? true : false,
        controls: this.videoParmas?.showcontrols ? true : false,
      });
    }
}
</script>
