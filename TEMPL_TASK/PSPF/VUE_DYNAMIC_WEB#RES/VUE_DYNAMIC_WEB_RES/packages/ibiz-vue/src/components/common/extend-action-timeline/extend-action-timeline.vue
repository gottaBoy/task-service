<template>
    <div class="extend-action-timeline">
        <div class="extend-action-timeline-table">
            <div class="extend-action-timeline-thead"></div>
            <div class="extend-action-timeline-body" v-if="data && data.usertasks">
                <div class="timeline-draw extend-action-timeline-body__timeline timeline-head">
                    <div class="timeline-wrapper">
                        <div class="timeline-wrapper__timeline-index">{{ $t('components.timeline.index') }}</div>
                        <div class="timeline-wrapper__usertaskname">{{ $t('components.timeline.node') }}</div>
                        <div class="timeline-wrapper__authorname">{{ $t('components.timeline.author') }}</div>
                        <div class="timeline-wrapper__type">{{ $t('components.timeline.type') }}</div>
                        <div class="timeline-wrapper__last-time">{{ $t('components.timeline.lasttime') }}</div>
                        <div class="timeline-wrapper__fullmessage">{{ $t('components.timeline.opinion') }}</div>
                    </div>
                    <div class="timeline-arrow"></div>
                </div>
                <template v-for="(usertask, usertaskIndex) in data.usertasks">
                    <div v-if="usertask.comments.length > 0" class="timeline-content" :key="usertaskIndex">
                        <div class="extend-action-timeline-body__timeline">
                            <div class="timeline-wrapper">
                                <div class="timeline-wrapper__timeline-index">
                                    <span>{{ usertask.index }}</span>
                                    <div class="icon-bottom" v-if="usertask.index != 1">
                                        <i class="el-icon-bottom"></i>
                                    </div>
                                    <div class="icon-top" v-if="usertask.index < usertasksLength"></div>
                                </div>
                                <div class="timeline-wrapper__usertaskname">{{ usertask.userTaskName }}</div>
                                <div class="timeline-wrapper__authorname">
                                    <Tooltip
                                        placement="bottom"
                                        theme="light"
                                        :disabled="
                                            acceptingOfficerNodup('authorName', usertask.comments).length > 1
                                                ? false
                                                : true
                                        "
                                    >
                                        {{
                                            acceptingOfficerNodup('authorName', usertask.comments)
                                                .map(item => item)
                                                .toString()
                                        }}
                                        <div slot="content">
                                            <div class="timeline-wrapper__authorname__tooltips">
                                                <div
                                                    class="tooltips-content"
                                                    v-for="(item, toolindex) in acceptingOfficerNodup(
                                                        'authorName',
                                                        usertask.comments,
                                                    )"
                                                    :key="toolindex"
                                                >
                                                    {{ item }}
                                                </div>
                                            </div>
                                        </div>
                                    </Tooltip>
                                </div>
                                <div class="timeline-wrapper__type">
                                    <div
                                        v-if="
                                            usertask.comments[usertask.comments.length - 1] &&
                                            usertask.comments[usertask.comments.length - 1].type
                                        "
                                        class="dot"
                                    ></div>
                                    <span>{{
                                        usertask.comments[usertask.comments.length - 1] &&
                                        usertask.comments[usertask.comments.length - 1].type
                                    }}</span>
                                </div>
                                <div class="timeline-wrapper__last-time">
                                    {{
                                        usertask.comments[usertask.comments.length - 1] &&
                                        formatDate(
                                            usertask.comments[usertask.comments.length - 1].time,
                                            'MM月DD日 HH:mm:ss',
                                        )
                                    }}
                                </div>
                                <el-popover class="timeline-wrapper__tooltip" placement="top" :width="500" trigger="hover">
                                    <div slot="reference">
                                        {{
                                            usertask.comments[usertask.comments.length - 1] &&
                                            usertask.comments[usertask.comments.length - 1].fullMessage
                                        }}
                                    </div>
                                    <div class="fullmessage">
                                        {{
                                            usertask.comments[usertask.comments.length - 1] &&
                                            usertask.comments[usertask.comments.length - 1].fullMessage
                                        }}
                                    </div>
                                </el-popover>
                            </div>
                            <div
                                v-if="usertask.comments.length > 1 || usertask.identitylinks.length > 0"
                                class="timeline-arrow"
                                @click="changeExpand(usertask)"
                            >
                                <i :class="usertask.isShow ? 'el-icon-minus' : 'el-icon-plus'" />
                            </div>
                        </div>
                        <div v-if="usertask.isShow">
                            <template v-for="(comment, index) in usertask.comments">
                                <div class="timeline-draw extend-action-timeline-body__timeline" :key="index">
                                    <div class="timeline-wrapper">
                                        <div class="timeline-wrapper__timeline-index">
                                            <div v-if="usertask.index < usertasksLength" class="icon-line"></div>
                                        </div>
                                        <div class="timeline-wrapper__usertaskname"></div>
                                        <div class="timeline-wrapper__authorname">
                                            {{ comment.authorName }}
                                        </div>
                                        <div class="timeline-wrapper__type">
                                            <div class="dot"></div>
                                            <span>{{ comment.type }}</span>
                                        </div>
                                        <div class="timeline-wrapper__last-time">
                                            {{ formatDate(comment.time, 'MM月DD日 HH:mm:ss') }}
                                        </div>
                                        <div class="timeline-wrapper__fullmessage">{{ comment.fullMessage }}</div>
                                    </div>
                                    <div class="timeline-arrow"></div>
                                </div>
                            </template>
                            <div
                                v-if="usertask.identitylinks.length > 0"
                                class="timeline-draw extend-action-timeline-body__timeline"
                            >
                                <div class="timeline-wrapper">
                                    <div class="timeline-wrapper__timeline-index">
                                        <div v-if="usertask.index < usertasksLength" class="icon-line"></div>
                                    </div>
                                    <div class="timeline-wrapper__usertaskname">
                                        {{ $t('components.timeline.inhand') }}
                                    </div>
                                    <div
                                        class="timeline-wrapper__authorname">
                                        <div
                                            v-for="(identitylink, index) in usertask.identitylinks"
                                            :key="index"
                                        >
                                            {{ identitylink.displayname }}
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div v-else class="timeline-content" :key="usertaskIndex">
                        <div class="extend-action-timeline-body__timeline">
                            <div class="timeline-wrapper">
                                <div class="timeline-wrapper__timeline-index">
                                    <span>{{ usertask.index }}</span>
                                    <div class="icon-bottom" v-if="usertask.index != 1">
                                        <i class="el-icon-bottom"></i>
                                    </div>
                                    <div class="icon-top" v-if="usertask.index < usertasksLength"></div>
                                </div>
                                <div class="timeline-wrapper__usertaskname">{{ usertask.userTaskName }}</div>
                                <div class="timeline-wrapper__authorname">
                                    <Tooltip
                                        placement="bottom"
                                        theme="light"
                                        :disabled="
                                            acceptingOfficerNodup('displayname', usertask.identitylinks).length > 1
                                                ? false
                                                : true
                                        "
                                    >
                                        {{
                                            acceptingOfficerNodup('displayname', usertask.identitylinks)
                                                .map(item => item)
                                                .toString()
                                        }}
                                        <div slot="content">
                                            <div class="tooltips">
                                                <div
                                                    class="tooltips-content"
                                                    v-for="(item, toolindex) in acceptingOfficerNodup(
                                                        'displayname',
                                                        usertask.identitylinks,
                                                    )"
                                                    :key="toolindex"
                                                >
                                                    {{ item }}
                                                </div>
                                            </div>
                                        </div>
                                    </Tooltip>
                                </div>
                            </div>
                            <div v-if="usertask.identitylinks.length > 1" class="timeline-arrow" @click="changeExpand(usertask)">
                                <i :class="usertask.isShow ? 'el-icon-minus' : 'el-icon-plus'" />
                            </div>
                        </div>
                        <div v-if="usertask.isShow">
                            <template v-for="(identitylink, index) in usertask.identitylinks">
                                <div class="timeline-draw extend-action-timeline-body__timeline" :key="index">
                                    <div class="timeline-wrapper">
                                        <div class="timeline-wrapper__timeline-index">
                                            <div v-if="usertask.index < usertasksLength" class="icon-line"></div>
                                        </div>
                                        <div class="timeline-wrapper__usertaskname"></div>
                                        <div class="timeline-wrapper__authorname">
                                            {{ identitylink.displayname }}
                                        </div>
                                    </div>
                                    <div class="timeline-arrow"></div>
                                </div>
                            </template>
                        </div>
                    </div>
                </template>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator';
import moment from 'moment';
import { DataServiceHelp, Util } from 'ibiz-core';

@Component({})
export default class ExtendActionTimeline extends Vue {
    /**
     * 数据
     *
     *  @memberof ExtendActionTimeline
     */
    public data: any = {};

    /**
     *  初始化memo
     *
     *  @memberof ExtendActionTimeline
     */
    public initmemo: string = '';

    /**
     *  子项索引初始值
     *
     *  @memberof ExtendActionTimeline
     */
    public usertasksIndex: number = 1;

    /**
     *  子项长度初始值
     *
     *  @memberof ExtendActionTimeline
     */
    public usertasksLength: number = 1;

    /**
     * 应用实体名称
     *
     * @memberof ExtendActionTimeline
     */
    @Prop() public appEntityCodeName!: string;

    /**
     * 应用实体
     *
     * @memberof ExtendActionTimeline
     */
    @Prop() public appEntity!: any;

    /**
     *  上下文
     *
     *  @memberof ExtendActionTimeline
     */
    @Prop() public context: any;

    /**
     *  视图参数
     *
     *  @memberof ExtendActionTimeline
     */
    @Prop() public viewparams: any;

    /**
     * 初始化数据
     *
     *  @memberof ExtendActionTimeline
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
     *  @memberof ExtendActionTimeline
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
     *  @memberof ExtendActionTimeline
     */
    public formatDate(date: string, format: string) {
        return moment(date).format(format);
    }

    /**
     * 点击事件
     *
     *  @memberof ExtendActionTimeline
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
     * @memberof ExtendActionTimeline
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
