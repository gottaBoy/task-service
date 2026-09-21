<template>
    <div class="app-async-message view-container view-default">
        <card class="view-card" :disHover="true" :bordered="false">
            <div slot='title' class='view-header' key='view-header'>
                <div class="view-header__left">
                    <div class="view__caption__info">
                        {{ message.name }}
                    </div>
                </div> 
                <div class="view-header__right app-view-toolbar">
                    <i-button :disabled="!errorFile" @click="handleDownload">下载错误文件</i-button>
                    <i-button @click="handleClose">关闭</i-button>
                </div>
            </div>
            <div v-if="loaded" class='app-async-message__content'>
                <div class="app-async-message__describe">
                    <el-form>
                        <el-form-item label="导入时间: ">
                            {{ message.beginTime }} ~ {{ message.endTime }}
                        </el-form-item>
                        <el-col :span="8">
                            <el-form-item label="导入总条数: ">
                                {{ message.total }}
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item label="成功导入数: ">
                                {{ message.success }}
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item label="导入失败数: ">
                                {{ message.error }}
                            </el-form-item>
                        </el-col>
                    </el-form>
                </div>
                <List v-if="items.length > 0" class="app-async-message__list">
                    <ListItem class="app-async-message__item" v-for="(item, index) of items" :key="index">
                        <div class="avatar">{{ item.key }}</div>
                        <div class="content">
                            <div class="title">错误</div>
                            <div class="info">{{ item.value }}</div>
                        </div>
                    </ListItem>
                    <template slot="footer">
                        <div v-if="limit < allItems.length" @click="showMore">加载更多</div>
                        <div v-else>没有更多了...</div>
                    </template>
                    <el-backtop target=".app-async-message__list"></el-backtop>
                </List>
                <div v-else class="control__empty">
                    <img class="empty__img" src="@/assets/img/empty-data.svg" />
                    <span class="empty__text">{{$t('app.warn.nofind')}}</span>
                </div>
                
            </div>
            <div v-else class="control__loading">
                <img class="loading__img" src="@/assets/img/load-data.svg" />
                <span class="loading__text">{{$t('app.warn.load')}}</span>
            </div>
        </card>
    </div>
</template>

<script lang="ts">
import { AppServiceBase, Http, Util } from 'ibiz-core';
import axios from 'axios';
import qs from 'qs';
import { Vue, Component } from 'vue-property-decorator';

@Component({})
export default class AppAsyncMessage extends Vue {

    /**
     * 视图参数
     *
     * @memberof AppAsyncMessage
     */
    public viewParams: any = {};

    /**
     * 导入信息
     *
     * @memberof AppAsyncMessage
     */
    public message: any = {
        name: '数据导入详情'
    };

    /**
     * 数据项
     *
     * @memberof AppAsyncMessage
     */
    public items: any[] = [];

    /**
     * 所有数据项
     *
     * @memberof AppAsyncMessage
     */
    public allItems: any[] = [];

    /**
     * 错误文件
     *
     * @memberof AppAsyncMessage
     */
    public errorFile: any = null;

    /**
     * 是否加载中
     *
     * @memberof AppAsyncMessage
     */
    public loaded: boolean = false;

    /**
     * 显示条数限制
     *
     * @memberof AppAsyncMessage
     */
    public limit: number = 20;

    /**
     * 下载文件路径
     *
     * @memberof AppAsyncMessage
     */
     public downloadUrl = AppServiceBase.getInstance().getAppEnvironment().ExportFile;

    public created() {
        this.resetPageCaption();
        this.setPageCaption();
        this.parseRouteParams();
        this.load();
    }

    /**
     * 设置路由参数
     *
     * @memberof AppAsyncMessage
     */
    public setPageCaption(info: string = '') {
        this.$store.commit("setCurPageCaption", {
            route: this.$route,
            caption: this.$route.meta.caption,
            captionTag: '',
            info: info,
        });
    }

    /**
     * 重置路由参数
     *
     * @memberof AppAsyncMessage
     */
    public resetPageCaption() {
        this.$route.meta.captionTag = '';
        this.$route.meta.caption = '数据导入详情';
        this.$route.meta.imgPath = '';
        this.$route.meta.iconCls = '';
        this.$route.meta.requireAuth = false;
    }

    /**
     * 解析路由参数
     *
     * @memberof AppAsyncMessage
     */
    public parseRouteParams() {
        const route = this.$route;
        const { actionid } = route.params;
        if (actionid) {
            Object.assign(this.viewParams, { id: actionid });
        }
        if (route && route.fullPath && route.fullPath.indexOf("?") > -1) {
            const _viewparams: any = route.fullPath.slice(route.fullPath.indexOf("?") + 1);
            const _viewparamArray: Array<string> = decodeURIComponent(_viewparams).split(";")
            if (_viewparamArray.length > 0) {
                _viewparamArray.forEach((item: any) => {
                    Object.assign(this.viewParams, qs.parse(item));
                })
            }
        }
    }

    /**
     * 解析路由参数
     *
     * @memberof AppAsyncMessage
     */
    public async load() {
        const tempViewParams = Util.deepCopy(this.viewParams);
        if (tempViewParams.id) {
            const url = `/portal/asyncaction/${tempViewParams.id}`;
            delete tempViewParams.id;
            const response = await Http.getInstance().get(url, tempViewParams);
            if (response.status && response.status === 200 && response.data) {
                const data = response.data;
                this.message = {
                    name: `${this.message.name}-${data.asyncacitonname}`,
                    beginTime: data.begintime,
                    endTime: data.endtime,
                }
                this.setPageCaption(data.asyncacitonname);
                try {
                    let actionResult: any = null;
                    if (data.actionresult) {
                        actionResult = JSON.parse(data.actionresult);
                    } else if (data.fullresult) {
                        actionResult = JSON.parse(data.fullresult);
                    }
                    Object.assign(this.message, {
                        total: actionResult.total,
                        success: actionResult.success,
                        error: Number(actionResult.total) - Number(actionResult.success)
                    })
                    if (this.message.error > 0) {
                        this.errorFile = actionResult.errorfile;
                        const errorInfo = actionResult.errorinfo;
                        this.items = [];
                        this.allItems = [];
                        Object.keys(errorInfo).forEach((key: string) => {
                            this.allItems.push({key, value: errorInfo[key].errorInfo})
                        })
                        this.items = this.allItems.slice(0, this.limit);
                    }
                } catch (error) {
                    this.$throw('解析导入信息异常', 'load');
                }
                
            }
            this.loaded = true;
        }
    }

    /**
     * 显示更多
     *
     * @memberof AppAsyncMessage
     */
    public showMore() {
        this.limit += 20;
        this.items = this.allItems.slice(0, this.limit);
    }

    /**
     * 关闭
     *
     * @memberof AppAsyncMessage
     */
    public handleClose() {
        this.$store.commit("deletePage", this.$route.fullPath);
            const length = this.$store.state.historyPathList.length;
            if (length > 0) {
                const path = this.$store.state.historyPathList[length - 1];
                if (Object.is(path, this.$route.fullPath)) {
                    return;
                }
                const index = this.$store.state.pageTagList.findIndex((page: any) =>
                    Object.is(page.fullPath, path)
                );
                if (index >= 0) {
                    const page = this.$store.state.pageTagList[index];
                    this.$router.push({
                        path: page.path,
                        params: page.params,
                        query: page.query
                    });
                }
            } else {
                let path: string | null = window.sessionStorage.getItem(
                    AppServiceBase.getInstance().getAppEnvironment().AppName
                );
                if (path) {
                    this.$router.push({ path: path });
                } else {
                    this.$router.push("/");
                }
            }
    }

    /**
     * 下载错误文件
     *
     * @memberof AppAsyncMessage
     */
    public handleDownload() {
        const url = `${this.downloadUrl}/${this.errorFile.folder}/${this.errorFile.fileid}`;
        // 发送get请求
        axios({
            method: 'get',
            url: url,
            responseType: 'blob'
        }).then((response: any) => {
            if (!response || response.status != 200) {
                this.$throw(this.$t('components.appfileupload.downloaderror'));
                return;
            }
            // 请求成功，后台返回的是一个文件流
            if (response.data) {
                // 获取文件名
                const filename = this.message.name;
                let filetype = 'application/vnd.ms-excel';
                // 用blob对象获取文件流
                let blob = new Blob([response.data], {type: filetype});
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
        }).catch((error: any) => {
            console.error(error);
        });
    }
    
}
</script>

<style lang='less'>
@import './app-async-message.less';
</style>