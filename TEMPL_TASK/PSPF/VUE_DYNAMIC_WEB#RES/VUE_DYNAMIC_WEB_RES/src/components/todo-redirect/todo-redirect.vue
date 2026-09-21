<template>
    <div class="todo-redirect">
        <img src="@/assets/img/redirect.svg" />
        <div class="context">页面跳转中~</div>
    </div>
</template>

<script lang="ts">
import { AppServiceBase, Http, Util } from 'ibiz-core';
import qs from 'qs';
import { Vue, Component } from 'vue-property-decorator';

@Component({})
export default class TodoRedirectView extends Vue {
    /**
     * vue生命周期
     *
     * @type {*}
     * @memberof TodoRedirectView
     */
    public created() {
        let tempViewParam = this.parseViewParam(window.location.href);
        this.executeRedirectLogic(tempViewParam);
    }

    /**
     * 处理路径数据
     *
     * @param {*} [urlStr] 路径
     *
     * @memberof TodoRedirectView
     */
    public parseViewParam(urlStr: string): any {
        let tempViewParam: any = {};
        const tempViewparam: any = urlStr.slice(urlStr.lastIndexOf('?') + 1);
        const viewparamArray: Array<string> = decodeURIComponent(tempViewparam).split(';');
        if (viewparamArray.length > 0) {
            viewparamArray.forEach((item: any) => {
                Object.assign(tempViewParam, qs.parse(item));
            });
        }
        return tempViewParam;
    }

    /**
     * 执行数据重定向数据逻辑
     *
     *
     * @memberof TodoRedirectView
     */
    public async executeRedirectLogic(viewparam: any) {
        try {
            let { apptype, todotype, todoid } = viewparam;
            const tempData = { todosubtype: todotype };
            if (!apptype) {
                Object.assign(tempData, { todourltype: 'RouterUrl' });
            }
            Object.assign(tempData, {
                srfapptype: 'pc',
                srfapp: AppServiceBase.getInstance().getAppModelDataObject().codeName,
            });
            const response = await Http.getInstance().post(
                `/systodos/${encodeURIComponent(todoid)}/getlinkurl`,
                tempData,
            );
            if (response && response.status == 200 && response.data && response.data.linkurl) {
                let targetUrl: string = response.data.linkurl;
                // apptype存在，带ip、端口等完整数据
                if (apptype) {
                    window.location.href = targetUrl;
                } else {
                    if (targetUrl.indexOf('/') != 0) {
                        targetUrl = '/' + targetUrl;
                    }
                    // targetUrl = `${targetUrl.slice(0, targetUrl.indexOf(';srffullscreen=true'))}`;
                    targetUrl += `;srfwf=${todotype}`;
                    this.$router.push('/appindexview' + targetUrl);
                }
            } else {
                if (response) {
                    this.$throw(response);
                }
            }
        } catch (error) {
            this.$throw(error);
        }
    }
}
</script>

<style lang='less'>
@import './todo-redirect.less';
</style>