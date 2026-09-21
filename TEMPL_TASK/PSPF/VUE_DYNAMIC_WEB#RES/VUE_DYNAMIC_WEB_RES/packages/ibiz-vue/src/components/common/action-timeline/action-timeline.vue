<template>
    <div class="action-timeline">
        <table class="action-timeline-table">
            <thead class="action-timeline-thead">
                <tr>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody class="action-timeline-tbody">
                <template v-for="(usertask, usertaskIndex) in data.usertasks">
                    <tr :key="usertaskIndex">
                        <td align="right" valign="top">
                            <div class="action-timeline-tbody__date">
                                <div class="tbody__date__caption">{{ usertask.userTaskName }}</div>
                                <div class="tbody__date__arrow" @click="changeExpand(usertask)">
                                    <i :class="usertask.isShow ? 'el-icon-arrow-down' : 'el-icon-arrow-up'" />
                                </div>
                            </div>
                        </td>
                        <td>
                            <div class="action-timeline-tbody__timeline">
                                <template v-if="usertask.identitylinks && usertask.identitylinks.length > 0">
                                    {{ $t('components.appwfapproval.wait') }}
                                    <strong>
                                        <template v-for="(identitylink, len) in usertask.identitylinks">
                                            <template v-if="identitylink.displayname">
                                                {{ identitylink.displayname }}
                                                <template v-if="len != usertask.identitylinks.length - 1">
                                                    、
                                                </template>
                                            </template>
                                        </template>
                                    </strong>
                                    {{ $t('components.appwfapproval.handle') }}
                                </template>
                                <template v-else>
                                    <ul class="action-timeline-tbody__timeline__wrapper">
                                        <template v-if="!usertask.isShow">
                                            <li
                                                v-if="usertask.comments && usertask.comments.length > 0"
                                                class="action-timeline-item"
                                            >
                                                <div class="action-timeline-item__time">
                                                    {{
                                                        formatDate(usertask.comments[0].time, 'MM月DD日 HH:mm')
                                                    }}&nbsp;{{ usertask.comments[0].authorName }}
                                                </div>
                                                <div class="action-timeline-item__content">
                                                    {{ usertask.comments[0].type }}&nbsp;{{
                                                        usertask.comments[0].fullMessage
                                                    }}
                                                </div>
                                            </li>
                                        </template>
                                        <template v-else>
                                            <template v-for="(comment, commentIndex) in usertask.comments">
                                                <li :key="commentIndex" class="action-timeline-item">
                                                    <div class="action-timeline-item__time">
                                                        {{ formatDate(comment.time, 'MM月DD日 HH:mm') }} &nbsp;{{
                                                            comment.authorName
                                                        }}
                                                    </div>
                                                    <div class="action-timeline-item__content">
                                                        {{ comment.type }}&nbsp;{{ comment.fullMessage }}
                                                    </div>
                                                </li>
                                            </template>
                                        </template>
                                    </ul>
                                </template>
                            </div>
                        </td>
                    </tr>
                </template>
            </tbody>
        </table>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator';
import moment from 'moment';
import { DataServiceHelp, Util } from 'ibiz-core';

@Component({})
export default class ActionTimeline extends Vue {
    /**
     * 数据
     *
     *  @memberof ActionTimeline
     */
    public data: any = {};

    /**
     *  初始化memo
     *
     *  @memberof ActionTimeline
     */
    public initmemo: string = '';

    /**
     * 应用实体名称
     *
     * @memberof ActionTimeline
     */
    @Prop() public appEntityCodeName!: string;

    /**
     * 应用实体
     *
     * @memberof ActionTimeline
     */
    @Prop() public appEntity!: any;

    /**
     *  上下文
     *
     *  @memberof ActionTimeline
     */
    @Prop() public context: any;

    /**
     *  视图参数
     *
     *  @memberof ActionTimeline
     */
    @Prop() public viewparams: any;

    /**
     * 初始化数据
     *
     *  @memberof ActionTimeline
     */
    public created() {
        if (this.appEntityCodeName) {
            const tempContext = Util.deepCopy(this.context);
            if (this.viewparams && this.viewparams.hasOwnProperty('srfprocessinstanceid')) {
                Object.assign(tempContext, { srfprocessinstanceid: this.viewparams['srfprocessinstanceid'] });
            }
            DataServiceHelp.getInstance()
                .getService(this.appEntity, { context: tempContext })
                .then((service: any) => {
                    if (service) {
                        service
                            .execute('GetWFHistory', tempContext)
                            .then((res: any) => {
                                if (res && res.status === 200) {
                                    this.data = res.data;
                                    this.initUIStateData();
                                } else {
                                    this.$throw(res, 'created');
                                }
                            })
                            .catch((error: any) => {
                                this.$throw(error, 'created');
                            });
                    }
                });
        }
    }

    /**
     * 初始化数据添加标记
     *
     *  @memberof ActionTimeline
     */
    public initUIStateData() {
        if (this.data && this.data.usertasks) {
            for (let i in this.data.usertasks) {
                this.data.usertasks[i].isShow = false;
            }
        }
    }

    /**
     * 时间转换
     *
     *  @memberof ActionTimeline
     */
    public formatDate(date: string, format: string) {
        return moment(date).format(format);
    }

    /**
     * 点击事件
     *
     *  @memberof ActionTimeline
     */
    public changeExpand(usertask: any) {
        usertask.isShow = !usertask.isShow;
        this.$forceUpdate();
    }
}
</script>