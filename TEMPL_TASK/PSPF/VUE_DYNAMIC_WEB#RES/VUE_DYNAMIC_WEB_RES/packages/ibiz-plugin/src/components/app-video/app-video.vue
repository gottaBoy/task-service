<template>
    <div :id="uuid" class="render-video"></div>
</template>

<script lang="ts">
import Player from 'xgplayer';
import { Util } from 'ibiz-core';
import { Component, Vue, Prop } from 'vue-property-decorator';
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
        let defaultHeight = 337.5;
        let defaultwidth = 600;
        if(this.$el){
          defaultHeight = this.$el.clientHeight;
          defaultwidth = this.$el.clientWidth;
        }
        let player = new Player({
            id: this.uuid,
            fluid: true,
            height: defaultHeight,
            width: defaultwidth,
            url: this.videoParmas?.path,
            volume: this.Params?.mute ? 0 : 0.8,
            autoplay: this.Params?.autoplay ? true : false,
            loop: this.Params?.replay ? true : false,
            controls: this.Params?.showcontrols ? true : false,
        });
    }
}
</script>

<style lang='less'>
@import "./app-video.less";
</style>
