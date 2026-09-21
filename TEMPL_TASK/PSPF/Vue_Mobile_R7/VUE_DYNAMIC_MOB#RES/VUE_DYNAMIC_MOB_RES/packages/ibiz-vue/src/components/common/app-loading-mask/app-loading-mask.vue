<template>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator';

@Component({})
export default class AppLoadingMask extends Vue {

    /**
     * 加载效果key
     * 
     * @private
     * @type {HTMLElement}
     * @memberof AppLoadingMask
     */
    @Prop() maskElement?: string;

    /**
     * Vue生命周期 --- created
     * 
     * @memberof AppLoadingMask
     */
    created() {
        this.beginLoading();
    }

    /**
     * Vue生命周期 --- destoryed
     * 
     * @memberof AppLoadingMask
     */
    destroyed() {
        this.endLoading();
    }

    /**
     * 开始加载
     * 
     * @private
     * @memberof AppLoadingMask
     */
    private beginLoading() {
        if (!this.maskElement) {
            return;
        }
        const userEle = document.createElement('div');
        userEle.setAttribute('id', `${this.maskElement}_cover`);
        const innerDiv = document.createElement('div');
        innerDiv.classList.add('loading');
        for (let i = 0; i < 4; i++) {
            const dot = document.createElement('span');
            innerDiv.appendChild(dot);
        }
        userEle.appendChild(innerDiv);
        const element = document.querySelector(`.${this.maskElement}`);
        // 挂载
        if (element) {
            element.appendChild(userEle);
        }
    }

    /**
     * 结束加载
     * 
     * @private
     * @memberof AppLoadingMask
     */
    private endLoading() {
        const element: any = document.querySelector(`.${this.maskElement}`);
        if (element) {
            const cover = element.querySelector(`#${this.maskElement}_cover`);
            if (cover) {
                element.removeChild(cover);
            }
        }
    }
}
</script>