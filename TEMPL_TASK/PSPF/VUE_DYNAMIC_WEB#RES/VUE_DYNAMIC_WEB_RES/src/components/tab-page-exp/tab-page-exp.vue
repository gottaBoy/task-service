<template>
    <div class="app-page-tag">
        <div class="app-page-tag__left">
            <el-tabs type="card" @tab-click="changePage" v-model="editableTabsValue" closable @tab-remove="onClose">
                <el-tab-pane v-for="(meta, index) of $store.state.pageMetas" :name="index + ''" :key="index + ''">
                    <span slot="label"
                        ><span class="ivu-tag-dot-inner"></span
                        >{{ getCaption(meta.caption, meta.captionTag, meta.info) }}</span
                    >
                </el-tab-pane>
            </el-tabs>
        </div>
        <div v-show="$store.state.pageMetas.length > 0" class="app-page-tag__right">
            <el-dropdown @command="handlerClose">
                <el-button size="mini" type="primary">
                    {{ $t('components.tabpageexp.more') }}<i class="el-icon-arrow-down el-icon--right"></i>
                </el-button>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item
                        class="app-page-tag__popover-item"
                        :command="item"
                        v-for="(item, index) in actions"
                        :key="index"
                        >{{ $t(item.text) }}</el-dropdown-item
                    >
                </el-dropdown-menu>
            </el-dropdown>
        </div>
    </div>
</template>

<script lang="ts">
import { AppServiceBase } from 'ibiz-core';
import { Vue, Component, Provide, Prop, Watch } from 'vue-property-decorator';
import { Environment } from '../../environments/environment';
import { ViewCacheService } from 'ibiz-vue';

@Component({})
export default class TabPageExp extends Vue {
    @Provide()
    public styleLeft: number = 0;

    @Provide()
    public actions: any[] = [
        { text: 'app.tabpage.closeall', value: 'closeAll' },
        { text: 'app.tabpage.closeother', value: 'closeOther' },
    ];

    /**
     * 模型服务对象
     *
     * @memberof TabPageExp
     */
    @Prop() public modelService!: any;

    /**
     * 关闭tab页方法
     */
    public handlerClose(item: any) {
        this.doTagAction(item.value);
    }

    public editableTabsValue: any = ''; //tabs页绑定值

    /**
     * 微应用状态订阅对象
     *
     */
    private MicroAppStateEvent: any;

    @Watch('$route')
    public onRouteChange(newVal: any) {
        this.moveToView(newVal);
        this.$emit('change', newVal);
    }

    public created() {
        Vue.prototype.$tabPageExp = this;
        const microAppService = AppServiceBase.getInstance().getMicroAppService();
        if (microAppService && microAppService.getAppState() && microAppService.getIsMicroApp()) {
            this.MicroAppStateEvent = microAppService.getAppState().subscribe((state: any) => {
                const { tag, action, data } = state;
                if (Object.is(tag, Environment.microAppName)) {
                    if (Object.is(action, 'REMOVE_ALL')) {
                        this.doTagAction('closeAll');
                    }
                    if (Object.is(action, 'REMOVE_OTHER')) {
                        this.doTagAction('closeOther');
                    }
                    if (Object.is(action, 'TABCLICK')) {
                        if (this.$store.state.pageMetas && this.$store.state.pageMetas.length > 0) {
                            const activeIndex = this.$store.state.pageMetas.findIndex((page: any) => {
                                return page.fullPath === data.fullPath;
                            });
                            this.changePage({ index: `${activeIndex}`, tabName: data.fullPath });
                        }
                    }
                    if (Object.is(action, 'REMOVE_PAGE')) {
                        if (this.$store.state.pageMetas && this.$store.state.pageMetas.length > 0) {
                            const activeIndex = this.$store.state.pageMetas.findIndex((page: any) => {
                                return page.fullPath === data.fullPath;
                            });
                            if (activeIndex !== -1) {
                                this.onClose(`${activeIndex}`);
                            }
                        }
                    }
                }
            });
        }
    }

    public destroyed() {
        if (this.MicroAppStateEvent) {
            this.MicroAppStateEvent.unsubscribe();
        }
    }

    public getCaption(caption: any, captionTag: any, info: any): any {
        return info && !Object.is(info, '')
            ? `${this.$tl(captionTag, caption)} - ${info}`
            : this.$tl(captionTag, caption);
    }

    /**
     * 向左移动
     *
     * @memberof TabPageExp
     */
    public leftMove() {
        const scrollBody: any = this.$refs.scrollBody;
        const scrollChild: any = this.$refs.scrollChild;
        if (scrollBody && scrollChild && scrollChild.offsetWidth > scrollBody.offsetWidth) {
            if (scrollChild.offsetWidth - scrollBody.offsetWidth + this.styleLeft > 100) {
                this.styleLeft -= 100;
            } else {
                this.styleLeft = scrollBody.offsetWidth - scrollChild.offsetWidth;
            }
        }
    }

    /**
     * 向右移动
     *
     * @memberof TabPageExp
     */
    public rightMove() {
        if (this.styleLeft < 0) {
            if (this.styleLeft + 100 > 0) {
                this.styleLeft = 0;
            } else {
                this.styleLeft += 100;
            }
        }
    }

    /**
     * 是否选中
     *
     * @param {(string | number)} index
     * @returns
     * @memberof TabPageExp
     */
    public isActive(index: string | number) {
        const page = this.$store.state.pageTagList[index];
        if (Object.is(page.fullPath, this.$route.fullPath)) {
            return true;
        }
        return false;
    }

    /**
     * 关闭
     *
     * @param {*} event
     * @param {*} name
     * @memberof TabPageExp
     */
    public onClose(name: any) {
        const page = this.$store.getters.getPage(name);
        const viewDataChange = this.$store.getters['viewAction/getStateByPath'](page.fullPath);
        this.setActiveViewCache(name, 'onClose');
        if (viewDataChange) {
            const title: any = this.$t('app.tabpage.sureclosetip.title');
            const content: any = this.$t('app.tabpage.sureclosetip.content');
            this.$Modal.confirm({
                title: title,
                content: content,
                onOk: () => {
                    this.$store.commit('viewAction/removeViewByPath', page.fullPath);
                    this.$store.commit('deletePage', name);
                    this.gotoPage();
                },
                onCancel: () => {},
            });
        } else {
            this.$store.commit('deletePage', name);
            this.gotoPage();
        }
    }

    /**
     * 是否显示关闭
     *
     * @returns
     * @memberof TabPageExp
     */
    public isClose() {
        const pageTagList = this.$store.state.pageTagList;
        if (pageTagList.length > 1) {
            return true;
        }
        return false;
    }

    /**
     * 切换分页
     *
     * @param {*} index
     * @memberof TabPageExp
     */
    public changePage(tab: any, event?: any) {
        this.editableTabsValue = tab.index;
        this.$store.commit('setCurPage', tab.index);
        this.setActiveViewCache(Number(this.editableTabsValue), 'tabClick')
        this.gotoPage();
    }

    /**
     * 跳转页面
     *
     * @returns
     * @memberof TabPageExp
     */
    public gotoPage() {
        const length = this.$store.state.historyPathList.length;
        if (length > 0) {
            const path = this.$store.state.historyPathList[length - 1];
            
            if (Object.is(path, this.$route.fullPath)) {
                return;
            }
            const index = this.$store.state.pageTagList.findIndex((page: any) => Object.is(page.fullPath, path));
            if (index >= 0) {
                const page = this.$store.state.pageTagList[index];
                this.$router.push({
                    path: page.path,
                    params: page.params,
                    query: page.query,
                });
            }
        } else {
            let path: string | null = window.sessionStorage.getItem(Environment.AppName);
            if (path) {
                this.$router.push({ path: path });
            } else {
                this.$router.push('/');
            }
        }
    }

    /**
     * 设置当前页标题
     *
     * @param {*} caption
     * @memberof TabPageExp
     */
    public setCurPageCaption(opts: any) {
        const { caption, title, info, cacheRoutePath } = opts;
        // if (
        //   this.$route.meta &&
        //   !Object.is(this.$t(this.$route.meta.caption), caption)
        // ) {
        //   return;
        // }
        this.$store.commit('setCurPageCaption', {
            route: this.$route,
            caption: title,
            info: info,
            cacheRoutePath: cacheRoutePath,
        });
        setTimeout(() => {
            this.moveToView(this.$route);
        }, 1);
    }

    /**
     * 设置当前激活缓存视图
     */
    public setActiveViewCache(activeIndex: number, action: any) {
        const { pageMetas , historyPathList } = this.$store.state;
        const curPageMeta = pageMetas[activeIndex];
        if (Object.is(action, 'tabClick')) {
            ViewCacheService.setActiveViewCache(curPageMeta?.fullPath)
        } else if (Object.is(action, 'onClose')) {
            if (historyPathList.length > 1) {
                ViewCacheService.setActiveViewCache(historyPathList[historyPathList.length - 2]);
            } else {
                ViewCacheService.setActiveViewCache('');
            }
            ViewCacheService.removeViewCache(curPageMeta?.fullPath);
        } else if (Object.is(action, 'closeOther')) {
            ViewCacheService.removeOtherViewCache(curPageMeta?.fullPath);
        }
    }

    /**
     * 移动至指定页面标签
     *
     * @param {*} to
     * @memberof TabPageExp
     */
    public moveToView(to: any) {
        let that: any = this;
        const pages: any[] = this.$store.state.pageTagList;
        let leftWidth: number = 0;
        this.$nextTick(() => {
            let _index: any = '';
            pages.forEach((page, index) => {
                if (Object.is(page.path, to.path)) {
                    _index = index + '';
                }
            });
            if (_index !== '') {
                that.editableTabsValue = _index + '';
            }
        });
    }

    /**
     * 设置左侧边距
     *
     * @param {{ offsetWidth: number; }} tag
     * @param {number} leftWidth
     * @memberof TabPageExp
     */
    public setLeft(tag: { offsetWidth: number }, leftWidth: number) {
        if (tag) {
            const scrollBody: any = this.$refs.scrollBody;
            if (leftWidth < -this.styleLeft) {
                this.styleLeft = -leftWidth;
            } else if (leftWidth + tag.offsetWidth > scrollBody.offsetWidth - this.styleLeft) {
                this.styleLeft -= leftWidth + tag.offsetWidth - (scrollBody.offsetWidth - this.styleLeft);
            }
        }
    }

    /**
     * 执行行为操作
     *
     * @param {string} name
     * @memberof TabPageExp
     */
    public doTagAction(name: string) {
        if (Object.is(name, 'closeAll')) {
            this.$store.commit('removeAllPage');
            ViewCacheService.clearViewCache();
            this.gotoPage();
        } else if (Object.is(name, 'closeOther')) {
            this.setActiveViewCache(Number(this.editableTabsValue), name)
            this.$store.commit('removeOtherPage');
            this.moveToView(this.$route);
        }
    }
}
</script>

<style lang="less">
@import './tab-page-exp.less';
</style>
