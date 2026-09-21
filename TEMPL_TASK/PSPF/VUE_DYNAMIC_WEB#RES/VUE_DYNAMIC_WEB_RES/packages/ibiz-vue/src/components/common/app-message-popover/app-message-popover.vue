<template>
    <!-- 消息弹出框绘制开始 -->
    <el-badge :is-dot="true"  :hidden="!showIsDot" class="app-message-popover" @click="OpenPopover">
        <el-popover
            placement="bottom"
            popper-class="message-popover-container"
            v-model="showPopover"
            trigger="click"
            width="400"
            @show="initTabCnt(true)"
            @hide="initTabCnt(false)"
        >
            <el-tabs :value="default_tab_pane" :stretch="true">
                <!-- 待办　-->
                <el-tab-pane
                    :label="
                        $t('components.appmessagepopover.myTasksLabel') +
                            (myTasks.length == 0 ? '' : '(' + myTasks.length + ')')
                    "
                    name="first"
                    style="height: 300px; overflow: auto"
                    :draggable="false"
                >
                    <template v-for="(myTask, index) in myTasks">
                        <template v-if="index < taskShowCnt">
                            <el-row class="popover__content" :key="index" :draggable="false">
                                <el-col :span="3" class="popover__content__avatar" :draggable="false">
                                    <el-avatar
                                        icon="el-icon-s-check"
                                        size="small"
                                        :draggable="false"
                                        style="color: white; background-color: #409eff"
                                    ></el-avatar>
                                </el-col>
                                <el-col :span="21" class="popover__content__caption" :draggable="false">
                                    <el-row :draggable="false">
                                        <el-col :span="16" :draggable="false" style="width: 65%">
                                            <div
                                                class="process-definition-name"
                                                :draggable="false"
                                                @click="handleTag(myTask)"
                                            >
                                                <strong>{{ myTask.usertaskname }}</strong>
                                            </div>
                                            <!-- <div class="description" :draggable="false">{{myTask.description}}</div>
                                            <div class="createtime" :draggable="false">{{ formatDate(myTask.createTime, 'MM-DD hh:mm') }}</div> -->
                                        </el-col>
                                        <!-- <el-col :span="5" :draggable="false" style="display: flex; align-items: center">
                                            <el-tag
                                                :type="'success'"
                                                size="small"
                                                style="overflow: hidden; text-overflow: ellipsis"
                                                :draggable="false"
                                            >
                                                成功
                                            </el-tag>
                                        </el-col> -->
                                    </el-row>
                                </el-col>
                            </el-row>
                        </template>
                    </template>
                    <template>
                        <div class="popover__show-more" @click="showMore('taskShowCnt')">
                            <label v-if="taskShowCnt < myTasks.length">{{
                                $t('components.appmessagepopover.loadmore')
                            }}</label>
                            <label v-else>{{ $t('components.appmessagepopover.nomore') }}</label>
                        </div>
                    </template>
                </el-tab-pane>
                <!-- 通知　-->
                <el-tab-pane
                    :label="$t('components.appmessagepopover.myNotificationsLabel')"
                    name="second"
                    :style="{ height: '300px', overflow: 'auto' }"
                    :draggable="false"
                >
                    <div v-if="getCurMsgs().length > 0" class="popover__message">
                        <template v-for="(myMsg, index) in getCurMsgs()">
                            <div v-if="index < msgShowCnt" :key="index" @click="openMessageDetail(myMsg)">
                                <el-row class="popover__content" style="position:relative;" :draggable="false">
                                    <el-col :span="3" class="popover__content__avatar" :draggable="false">
                                        <i class="fa fa-tasks" style="color: #409eff;font-size: 24px;"></i>
                                    </el-col>
                                    <el-col :span="21" class="popover__content__caption" :draggable="false">
                                        <el-row :draggable="false">
                                            <el-col :span="24" :draggable="false">
                                                <div
                                                    :draggable="false"
                                                    style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;"
                                                >
                                                    <strong>{{ myMsg.name }}</strong>
                                                </div>
                                                <div
                                                    :draggable="false"
                                                    style="display: flex;justify-content: space-between;align-items: center;"
                                                >
                                                    <div v-if="myMsg.state !== 20">{{ myMsg.begintime }}</div>
                                                    <div v-if="myMsg.state === 20">{{ `${myMsg.stepinfo}（${myMsg.completionrate}%）` }}</div>
                                                    <div>
                                                        <el-tag
                                                            :type="
                                                                myMsg.state === 40
                                                                    ? 'danger'
                                                                    : myMsg.state === 30
                                                                    ? 'success'
                                                                    : myMsg.state === 20
                                                                    ? 'info'
                                                                    : '-'
                                                            "
                                                            size="small"
                                                            style="overflow: hidden;text-overflow: ellipsis;"
                                                            :draggable="false"
                                                        >
                                                            {{ myMsg.stateText }}
                                                        </el-tag>
                                                    </div>
                                                </div>
                                            </el-col>
                                        </el-row>
                                    </el-col>
                                    <div :style="getProgressStyle(myMsg)"></div>
                                </el-row>
                            </div>
                        </template>
                    </div>
                    <template v-else>
                        <div class="control__empty">
                            <img class="empty__img" src="@/assets/img/empty-data.svg" />
                            <span class="empty__text">{{$t('app.warn.nofind')}}</span>
                        </div>
                    </template>
                    <template v-if="myMsgs.length > 0">
                        <div v-if="messageStatus === 'executing'" class="popover__show-more" @click="showMore('msgShowHis')">
                            <label>{{ $t('components.appmessagepopover.showhistory') }}({{ myMsgs.length }})</label>
                        </div>
                        <div v-else class="popover__show-more" @click="showMore('msgShowCnt')">
                            <label v-if="msgShowCnt < myMsgs.length">{{
                                $t('components.appmessagepopover.loadmore')
                            }}({{ myMsgs.length - msgShowCnt }})</label>
                            <label v-else>{{ $t('components.appmessagepopover.nomore') }}</label>
                        </div>
                    </template>
                </el-tab-pane>
            </el-tabs>
            <i slot="reference" class="icon el-icon-bell" />
        </el-popover>
    </el-badge>
    <!-- 消息弹出框绘制结束 -->
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';
import { Subscription } from 'rxjs';
import { AppServiceBase, LogUtil, ViewTool, debounce } from 'ibiz-core';
import { ActionState, AppCenterService, AppNoticeService, NotificationFactory, SubType } from 'ibiz-vue';
import moment from 'moment';

@Component({})
export default class AppMessagePopover extends Vue {
    // 是否显示Popover
    public showPopover: boolean = false;
    // 是否显示小圆点
    public showIsDot: any = false;
    // 默认显示的tab页
    public default_tab_pane: any = 'first';
    // 待办列表
    public myTasks: any = [];
    //  待办面板显示条数
    public taskShowCnt: number = 0;
    // 消息列表
    public myMsgs: any[] = [];
    //  信息面板显示条数
    public msgShowCnt: number = 0;
    // 环境配置对象
    public environment: any = AppServiceBase.getInstance().getAppEnvironment();
    // 应用状态事件
    public appStateEvent: Subscription | undefined;
    // 标记计数器
    public bellTimer: any;
    // 通知消息状态
    public messageStatus: 'executing' | 'all' = 'executing';
    // 当前执行消息
    public curExecutingMsgs: string[] = [];

    /**
     * 获取进度条样式
     * 
     * @param item  
     */
    public getProgressStyle(item: any) {
        const itemStyle = {
            position: 'absolute',
            height: '100%',
            background: 'linear-gradient(to right, #fff, #409eff)',
            opacity: 0.6
        };
        Object.assign(itemStyle, { width: item.state === 20 ? `${item.completionrate}%` : '0' });
        return itemStyle;
    }

    /**
     * vue创建
     */
    created(): void {
        // 全局刷新通知
        if (AppCenterService.getMessageCenter()) {
            this.appStateEvent = AppCenterService.getMessageCenter().subscribe(
                ({ name, action, data }: { name: string; action: string; data: any }) => {
                    if (Object.is(name, 'SysTodo') && Object.is(action, 'appRefresh')) {
                        if (!this.environment.workflow) {
                            return;
                        }
                        this.getMyTasks();
                        return;
                    }
                    if (
                        Object.is(name, 'Notification') &&
                        (Object.is(action, 'AddItem') || Object.is(action, 'InitItem'))
                    ) {
                        this.getMyMsgs();
                        this.handleAsyncActionNotification(name, action, data);
                    }
                },
            );
        }
    }

    /**
     * vue挂载
     */
    mounted(): void {
        if (this.environment.workflow) {
            // 首次获取待办列表
            this.getMyTasks();
            // 定时器:每隔１分钟重新获取待办列表
            const timer = setInterval(() => {
                this.getMyTasks();
            }, 60000);
            // 监听定时器,在vue销毁前清除定时器
            this.$once('hook:beforeDestroy', () => {
                // 清除定时器
                clearInterval(timer);
            });
        }
        this.getMyMsgs();
    }

    /**
     * 处理异步作业通知
     */
    public handleAsyncActionNotification(name: string, action: string, data: any) {
        if (Object.is(action, 'AddItem') && data && data.subtype === SubType.ASYNCACTION) {
            const targetData = data.data;
            if (Object.is(this.messageStatus, 'executing') && !this.curExecutingMsgs.includes(targetData.asyncacitonid)) {
                this.curExecutingMsgs.push(targetData.asyncacitonid)
            }
            // 已经执行完成
            if (targetData.actionstate === ActionState.CREATED) {
                AppNoticeService.getInstance().success(`${targetData.asyncacitonname}异步作业执行成功`, {
                    duration: 0,
                    showClose: true,
                    position: 'top-right',
                });
            }
            // 执行失败
            if (targetData.actionstate === ActionState.FAILED) {
                AppNoticeService.getInstance().error(`${targetData.asyncacitonname}异步作业执行异常`, {
                    duration: 0,
                    showClose: true,
                    position: 'top-right',
                });
            }
            debounce(this.flickerDot, [], this, 500);
        }
    }

    /**
     * 获取待办列表
     */
    public getMyTasks() {
        let url: any = '/wfcore/mytasks';
        this.$http
            .get(url)
            .then((response: any) => {
                if (response && response.status == 200) {
                    const data: any = response.data;
                    if (data && data.length > 0) {
                        this.myTasks = data;
                        this.showIsDot = true;
                    } else {
                        this.myTasks = [];
                        this.showIsDot = false;
                    }
                }
            })
            .catch((error: any) => {
                LogUtil.warn(this.$t('components.appmessagepopover.error'));
            });
    }

    /**
     * 获取消息列表
     */
    public getMyMsgs() {
        this.myMsgs = NotificationFactory.getInstance().getItems(true);
    }

    /**
     * 获取当前消息
     */
    public getCurMsgs() {
        switch(this.messageStatus) {
            case 'executing':
                return this.myMsgs.filter((item: any) => Object.is(item.state, ActionState.CREATING) || this.curExecutingMsgs.includes(item.id));
            case 'all':
                return this.myMsgs;
        }
    }

    /**
     * 点击标签事件
     */
    public handleTag(data: any) {
        if (!data) return this.$throw(this.$t('components.appmessagepopover.geterror'), 'handleTag');
        this.$http
            .post(`/systodos/${data.usertaskid}/getlinkurl`, {
                todourltype: 'RouterUrl',
                todosubtype: 'Todo',
                srfapptype: 'pc',
                srfapp: AppServiceBase.getInstance().getAppModelDataObject().codeName,
            })
            .then((response: any) => {
                if (response && response.status == 200 && response.data && response.data.linkurl) {
                    this.showPopover = false;
                    let targetUrl: string = response.data.linkurl;
                    if (targetUrl.indexOf('/') != 0) {
                        targetUrl = '/' + targetUrl;
                    }
                    targetUrl = `${targetUrl.slice(0, targetUrl.indexOf(';srffullscreen=true'))}`;
                    targetUrl += `;srfwf=Todo`;
                    this.$router.push('/index' + targetUrl);
                } else {
                    if (response) {
                        this.$throw(response);
                    }
                }
            })
            .catch((response: any) => {
                this.$throw(response);
            });
    }

    /**
     * 销毁之前
     */
    beforeDestroy(): void {
        // 清空数据
        this.showIsDot = false;
        this.myTasks = [];
        this.myMsgs = [];
    }

    /**
     * 组件销毁
     */
    destroyed() {
        if (this.appStateEvent) {
            this.appStateEvent.unsubscribe();
        }
    }

    /**
     * 时间格式转换
     */
    public formatDate(date: string, format: string) {
        if (date && format) {
            return moment(date).format(format);
        }
        return date;
    }

    /**
     * 加载更多
     */
    public showMore(cnt: string) {
        if (Object.is('taskShowCnt', cnt)) {
            this.taskShowCnt + 10 < this.myTasks.length
                ? (this.taskShowCnt += 10)
                : (this.taskShowCnt += this.myTasks.length - this.taskShowCnt);
        } else if (Object.is('msgShowCnt', cnt)) {
            this.msgShowCnt + 10 < this.myMsgs.length
                ? (this.msgShowCnt += 10)
                : (this.msgShowCnt += this.myMsgs.length - this.msgShowCnt);
        } else if (Object.is('msgShowHis', cnt)) {
            this.messageStatus = 'all';
        }
    }

    /**
     * 弹出框 显示/隐藏 时显示条数初始化
     */
    public initTabCnt(show: boolean) {
        if (!show) {
            this.messageStatus = 'executing';
        }
        this.taskShowCnt = this.myTasks.length >= 10 ? 10 : this.myTasks.length;
        this.msgShowCnt = this.myMsgs.length >= 10 ? 10 : this.myMsgs.length;
    }

    /**
     * 弹出框显示处理
     */
    public OpenPopover() {
        this.showPopover = !this.showPopover;
    }

    /**
     * 打开消息详情页
     */
    public openMessageDetail(message: any) {
        if (message.state !== ActionState.CREATED && message.state !== ActionState.FAILED) {
            return;
        }
        if (message.actiontype && message.actiontype === 'DEIMPORTDATA2' && message.id) {
            const indexRoutePath = ViewTool.getIndexRoutePath(this.$route);
            const path = `${indexRoutePath}/asyncmessage/${message.id}/preview`;
            this.$router.push(path);
            this.showPopover = false;
        }
    }

    /**
     * 闪烁点
     */
    public flickerDot() {
        this.showIsDot = !this.showIsDot;
        if(this.bellTimer){
            clearTimeout(this.bellTimer);
        }
        this.bellTimer = setTimeout(() => {
            this.showIsDot = !this.showIsDot;
        }, 500);
    }
}
</script>
