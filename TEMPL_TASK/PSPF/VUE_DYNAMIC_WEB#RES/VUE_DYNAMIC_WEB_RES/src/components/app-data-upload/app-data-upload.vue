<template>
    <div class="app-data-upload-view" element-loading-background="rgba(57, 57, 57, 0.2)">
        <input
            ref="inputUpLoad"
            type="file"
            style="display: none"
            accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
            @change="fileChange"
        />
        <div class="main-content">
            <template v-if="asyncActionState">
                <div class="data-info-container">
                    <div class="message-container">
                        <div class="upload-progress-container">
                            <el-progress :percentage="dataProgress"></el-progress>
                            <div>{{ dataProgressText }}</div>
                        </div>
                    </div>
                </div>
            </template>
            <template v-else>
                <div v-if="!selectedFile" class="upload-container" @click="handleUpLoad">
                    <img class="icon-import" src="@/assets/img/icon-import.svg" />
                    <span class="select-file-text">{{ $t('components.appdatauploadview.selectfile') }}</span>
                </div>
                <div v-else class="data-info-container">
                    <div v-if="!isUploaded" class="message-container">
                        <div class="success-list" v-if="!isUploading">
                            {{ $t('components.appdatauploadview.selectfilesucess') }}
                        </div>
                        <div class="success-list" v-if="isUploading">
                            <div class="upload-progress-container">
                                <!-- <el-progress :percentage="uploadedProgress"></el-progress> -->
                                <div>正在上传文件，请稍候</div>
                            </div>
                        </div>
                    </div>
                    <div v-else class="message-container">
                        <div class="result-list">
                            <ul v-if="Object.keys(responseResult).length > 0">
                                <template v-if="ignoreError">
                                    <li class="title">
                                        <span>{{ $t('components.appdatauploadview.importresult') }}</span>
                                    </li>
                                    <li>
                                        <span>
                                            {{ $t('components.appdatauploadview.totaldata') }}
                                            {{ responseResult.total }}
                                            {{ $t('components.appdatauploadview.total') }}，{{
                                                $t('app.commonwords.wrong')
                                            }}[{{ responseResult.error }}]，{{ $t('app.commonwords.success') }}[{{
                                                responseResult.success
                                            }}]
                                        </span>
                                    </li>
                                </template>
                                <template v-if="responseResult.errorInfos && responseResult.errorInfos.length !== 0">
                                    <li class="title">
                                        <span>{{ $t('components.appdatauploadview.errorinfo') }}</span>
                                    </li>
                                    <li
                                        class="error-item"
                                        v-for="(item, index) in responseResult.errorInfos"
                                        :key="index"
                                    >
                                        <span v-if="item.index"
                                            >{{ $t('components.appdatauploadview.start') }} {{ item.index }}
                                            {{ $t('components.appdatauploadview.row') }}：</span
                                        ><span v-html="item.errorinfo"></span>
                                    </li>
                                </template>
                            </ul>
                        </div>
                    </div>
                </div>
            </template>
        </div>
        <el-row class="second-content">
            <el-col>
                <div class="import-template-message">{{ $t('components.appdatauploadview.datatemplatemessage') }}</div>
                <div class="import-template">
                    <img class="icon-link" src="@/assets/img/icon-link.svg" />
                    <span style="cursor: pointer" @click="downloadTemp">
                        {{ viewparams.appDeLogicName + $t('components.appdatauploadview.datatemplate') }}</span
                    >
                </div>
            </el-col>
            <div
                class="import-template-download-info"
                v-if="isUploaded && responseResult.errorfile"
                @click="downloadFeedbackMsg"
            >
                {{ $t('components.appdatauploadview.downloadinfo') }}
            </div>
        </el-row>
        <el-row class="button-container">
            <el-button @click="handleCancel">{{
                asyncActionState ? '确认' : $t('components.appdatauploadview.cancel')
            }}</el-button>
            <el-button
                v-if="!asyncActionState"
                :disabled="!selectedFile"
                :loading="isUploading"
                type="primary"
                @click="uploadServer"
                >{{ $t('components.appdatauploadview.uploadserver') }}</el-button
            >
        </el-row>
    </div>
</template>

<script lang="ts">
import axios from 'axios';
import { AppServiceBase, Util } from 'ibiz-core';
import {
    ActionState,
    AppCenterService,
    AppNoticeService,
    NotificationFactory,
    NotificationItem,
    SubType,
} from 'ibiz-vue';
import { Subscription } from 'rxjs';
import { Vue, Component, Prop, Watch } from 'vue-property-decorator';

@Component({})
export default class AppDataUploadView extends Vue {
    /**
     * 传入视图参数
     *
     * @type {string}
     * @memberof AppDataUploadView
     */
    @Prop() public dynamicProps!: string;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppDataUploadView
     */
    public viewparams: any = {};

    /**
     * 视图上下文
     *
     * @type {*}
     * @memberof AppDataUploadView
     */
    public viewdata: any = {};

    /**
     * 是否忽略错误
     *
     * @type {boolean}
     * @memberof AppDataUploadView
     */
    public ignoreError: boolean = false;

    /**
     * 选择文件数据
     *
     * @type {*}
     * @memberof AppDataUploadView
     */
    public selectedFile: any | null = null;

    /**
     * 是否上传完成
     *
     * @type {boolean}
     * @memberof AppDataUploadView
     */
    public isUploaded: boolean = false;

    /**
     * 上传进度
     *
     * @type {number}
     * @memberof AppDataUploadView
     */
    public uploadedProgress: number = 0;

    /**
     * 数据导入进度
     *
     * @type {number}
     * @memberof AppDataUploadView
     */
    public dataProgress: number = 0;

    /**
     * 数据导入进度文本
     *
     * @type {string}
     * @memberof AppDataUploadView
     */
    public dataProgressText: string = '';

    /**
     * 是否上传过程中
     *
     * @type {boolean}
     * @memberof AppDataUploadView
     */
    public isUploading: boolean = false;

    /**
     * 导入结果集合
     *
     * @type {Array<*>}
     * @memberof AppDataUploadView
     */
    public responseResult: any = {};

    /**
     * 是否启用异步导入
     *
     * @type {boolean}
     * @memberof AppDataUploadView
     */
    public enableAsyncImport: boolean = false;

    /**
     * 异步导入状态（true:当前环境存在异步作业/false:当前环境不存在异步作业）
     *
     * @type {boolean}
     * @memberof AppDataUploadView
     */
    public asyncActionState: boolean = false;

    /**
     * 应用状态事件
     *
     * @type {Subscription | undefined}
     * @memberof AppDataUploadView
     */
    public appStateEvent: Subscription | undefined;

    /**
     * vue  生命周期
     *
     * @memberof Breadcrumb
     */
    created() {
        const Environment = AppServiceBase.getInstance().getAppEnvironment();
        this.enableAsyncImport = Environment.enableAsyncImport;
        if (this.enableAsyncImport) {
            this.initAsyncActionState();
            this.handleAsyncAction();
        }
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
     * 视图参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppDataUploadView
     */
    @Watch('dynamicProps', { immediate: true, deep: true })
    onParamData(newVal: any, oldVal: any) {
        if (newVal) {
            this.viewparams = eval('(' + newVal.viewparam + ')');
            this.viewdata = eval('(' + newVal.viewdata + ')');
            this.ignoreError = this.viewparams?.ignoreError;
        }
    }

    /**
     * 初始化异步消息状态
     *
     * @memberof AppDataUploadView
     */
    public initAsyncActionState() {
        const asyncActionService = NotificationFactory.getInstance().getSubInstance(SubType.ASYNCACTION);
        if (asyncActionService) {
            const items = asyncActionService.getItems(true);
            if (items && items.length > 0) {
                const targetItem = items.find((item: NotificationItem) => {
                    return (
                        this.viewparams.serviceName.toUpperCase() === item.actionparam &&
                        this.viewparams.importId === item.actionparam2 &&
                        item.state === ActionState.CREATING
                    );
                });
                if (targetItem) {
                    this.asyncActionState = true;
                    this.dataProgress = targetItem.completionrate ? targetItem.completionrate : 0;
                    this.dataProgressText = '正在导入数据，请稍候';
                }
            }
        }
    }

    /**
     * 处理异步消息
     *
     * @memberof AppDataUploadView
     */
    public handleAsyncAction() {
        this.appStateEvent = AppCenterService.getMessageCenter().subscribe(
            ({ name, action, data }: { name: string; action: string; data: any }) => {
                if (!Object.is(name, 'AsyncAction')) {
                    return;
                }
                if (Object.is(action, 'AddItem')) {
                    if (
                        Object.is(this.viewparams.importId, data.actionparam2) &&
                        Object.is(this.viewparams.serviceName.toUpperCase(), data.actionparam)
                    ) {
                        if (data.state === ActionState.CREATING) {
                            this.dataProgress = data.completionrate ? data.completionrate : 0;
                            this.dataProgressText = '正在导入数据，请稍候';
                        }
                        if (data.state === ActionState.CREATED) {
                            const actionresult = JSON.parse(data.actionresult);
                            this.dataProgress = 100;
                            this.dataProgressText = `数据导入成功，导入数据共计${actionresult.total}条，成功导入${actionresult.success}条`;
                        }
                    }
                }
            },
        );
    }

    /**
     * 选择文件
     *
     * @memberof AppDataUploadView
     */
    public handleUpLoad() {
        (this.$refs.inputUpLoad as any).click();
    }

    /**
     * 取消
     *
     * @memberof AppDataUploadView
     */
    public handleCancel() {
        this.$emit('close', []);
    }

    /**
     * 文件数据变化
     *
     * @memberof AppDataUploadView
     */
    public fileChange($event: any) {
        let obj = $event.target || $event.srcElement;
        if (!obj.files) {
            return;
        }
        this.selectedFile = obj.files?.[0];
    }

    /**
     * 设置UI状态
     *
     * @memberof AppDataUploadView
     */
    public setUIState(uploadedProgress: number, isUploading: boolean, isUploaded: boolean, result: any = {}) {
        this.uploadedProgress = uploadedProgress;
        this.isUploading = isUploading;
        this.isUploaded = isUploaded;
        this.responseResult = result;
    }

    /**
     * 下载导入数据模板
     *
     * @memberof AppDataUploadView
     */
    public downloadTemp() {
        let requestUrl: string = '';
        if (
            this.viewdata &&
            this.viewdata.srfparentkey &&
            this.viewdata.srfparentdename &&
            this.viewdata.srfparentdename !== this.viewdata.appEntityName
        ) {
            requestUrl += `/${Util.srfpluralize(this.viewdata.srfparentdename)}/${this.viewdata.srfparentkey}`;
        }
        requestUrl += `/${Util.srfpluralize(this.viewparams.serviceName)}/importtemplate`;
        if (this.viewparams.importId) {
            requestUrl += `?srfimporttag=${this.viewparams.importId}`;
        }
        axios({
            url: requestUrl,
            method: 'get',
            responseType: 'blob',
        }).then((response: any) => {
            if (response.status == 200) {
                let fileName = response.headers['content-disposition']
                    .split(';')
                    .find((str: string) => str.indexOf('filename=') != -1)
                    ?.slice(9);
                fileName = decodeURIComponent(fileName);
                let blob = new Blob([response.data], { type: 'application/vnd.ms-excel' });
                let elink = document.createElement('a');
                elink.download = fileName;
                elink.style.display = 'none';
                elink.href = URL.createObjectURL(blob);
                document.body.appendChild(elink);
                elink.click();
                URL.revokeObjectURL(elink.href); // 释放URL 对象
                document.body.removeChild(elink);
            }
        });
    }

    /**
     * 下载导入反馈信息
     *
     * @memberof AppDataUploadView
     */
    public downloadFeedbackMsg() {
        if (!this.responseResult || !this.responseResult.errorfile || !this.responseResult.errorfile.fileid) {
            this.$throw(this.$t('components.appdatauploadview.downloaderror'));
            return;
        }
        let downloadUrl: string = `${AppServiceBase.getInstance().getAppEnvironment().ExportFile}/${
            this.responseResult.errorfile.folder
        }/${this.responseResult.errorfile.fileid}`;
        const headers = {};
        axios({
            method: 'get',
            url: downloadUrl,
            headers: headers,
            responseType: 'blob',
        })
            .then((response: any) => {
                if (!response || response.status != 200) {
                    this.$throw(this.$t('components.appdatauploadview.downloaderror'));
                    return;
                }
                // 请求成功，后台返回的是一个文件流
                if (response.data) {
                    // 获取文件名
                    const filename = `导入错误${this.responseResult.errorfile.fileid}.xlsx`;
                    let filetype = this.calcFilemime('xlsx');
                    // 用blob对象获取文件流
                    let blob = new Blob([response.data], { type: filetype });
                    // 通过文件流创建下载链接
                    var href = URL.createObjectURL(blob);
                    // 创建一个a元素并设置相关属性
                    let a = document.createElement('a');
                    a.href = href;
                    a.download = filename;
                    // 添加a元素到当前网页
                    document.body.appendChild(a);
                    // 触发a元素的点击事件，实现下载
                    a.click();
                    // 从当前网页移除a元素
                    document.body.removeChild(a);
                    // 释放blob对象
                    URL.revokeObjectURL(href);
                } else {
                    this.$throw(this.$t('components.appfileupload.downloaderror'));
                }
            })
            .catch((error: any) => {
                console.error(error);
            });
    }

    /**
     * 计算文件mime类型
     *
     * @param filetype 文件后缀
     * @memberof AppDataUploadView
     */
    public calcFilemime(filetype: string): string {
        let mime = 'application/vnd.ms-excel';
        switch (filetype) {
            case '.xlsx':
                mime = 'application/vnd.ms-excel';
                break;
            case '.wps':
                mime = 'application/kswps';
                break;
            case '.doc':
                mime = 'application/msword';
                break;
            case '.docx':
                mime = 'application/vnd.openxmlformats-officedocument.wordprocessingml.document';
                break;
            case '.txt':
                mime = 'text/plain';
                break;
            case '.zip':
                mime = 'application/zip';
                break;
            case '.png':
                mime = 'image/png';
                break;
            case '.gif':
                mime = 'image/gif';
                break;
            case '.jpeg':
                mime = 'image/jpeg';
                break;
            case '.jpg':
                mime = 'image/jpeg';
                break;
            case '.rtf':
                mime = 'application/rtf';
                break;
            case '.avi':
                mime = 'video/x-msvideo';
                break;
            case '.gz':
                mime = 'application/x-gzip';
                break;
            case '.tar':
                mime = 'application/x-tar';
                break;
        }
        return mime;
    }

    /**
     * 上传服务器
     *
     * @memberof AppDataUploadView
     */
    public uploadServer() {
        if (!this.selectedFile) {
            return;
        }
        try {
            let requestUrl: string = '';
            this.setUIState(0, true, false);
            if (this.viewdata && this.viewdata.srfparentkey && this.viewdata.srfparentdename) {
                requestUrl += `/${Util.srfpluralize(this.viewdata.srfparentdename)}/${this.viewdata.srfparentkey}`;
            }
            if (this.enableAsyncImport) {
                requestUrl += `/${Util.srfpluralize(this.viewparams.serviceName)}/asyncimportdata2`;
            } else {
                requestUrl += `/${Util.srfpluralize(this.viewparams.serviceName)}/importdata2`;
            }
            if (this.viewparams.importId) {
                requestUrl += `?srfimporttag=${this.viewparams.importId}`;
            }
            const data = new FormData();
            data.append('file', this.selectedFile);
            axios
                .post(requestUrl, data, {
                    headers: { 'Content-Type': 'multipart/form-data' },
                    onUploadProgress: (progressEvent: any) => {
                        this.uploadedProgress = Math.floor((progressEvent.loaded / progressEvent.total) * 100);
                    },
                })
                .then((res: any) => {
                    // 忽略错误时的提示信息
                    const result: any = {};
                    if (res && res.status && res.status == 200) {
                        if (this.enableAsyncImport) {
                            AppNoticeService.getInstance().success(
                                '正在导入数据，您可以在消息中心中查看数据导入的状态。',
                                { duration: 5000, showClose: true },
                            );
                            this.$emit('close', []);
                        } else {
                            const { data: data } = res;
                            const { errorinfo, success, total, errorfile } = data;
                            result.total = total ? Number(total) : 0;
                            result.success = success ? Number(success) : 0;
                            result.errorfile = errorfile;
                            if (errorinfo && Object.keys(errorinfo).length > 0) {
                                result.error = Object.keys(errorinfo).length;
                                result.errorInfos = [];
                                Object.keys(errorinfo).forEach((item: any) => {
                                    result.errorInfos.push({
                                        index: Number(item) + 1,
                                        errorinfo: errorinfo[item].errorInfo,
                                    });
                                });
                            }
                        }
                    }
                    this.setUIState(0, false, true, result);
                })
                .catch((error: any) => {
                    // 不忽略错误时的提示信息
                    const errorResult: any = {};
                    if (error && error.status && error.status !== 200) {
                        errorResult.errorInfos = [];
                        errorResult.errorInfos.push({
                            errorinfo: error.data?.message || this.$t('app.commonwords.sysexception'),
                        });
                    }
                    this.setUIState(0, false, true, errorResult);
                });
        } catch (error) {
            this.setUIState(0, false, true, {
                errorInfos: [{ errorinfo: error.data || this.$t('app.commonwords.sysexception') }],
            });
        }
    }
}
</script>

<style lang="less">
@import './app-data-upload.less';
</style>
