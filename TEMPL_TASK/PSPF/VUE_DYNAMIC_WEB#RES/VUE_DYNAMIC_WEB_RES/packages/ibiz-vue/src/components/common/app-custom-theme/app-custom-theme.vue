<template>
    <div class="app-custom-theme" @click="showDrawer = true">
        <span>
            <icon class='app-theme-icon' :title="$t('components.apptheme.config')" type='md-settings' :size="15" />
        </span>
        <span class="title">
            {{$t('components.apptheme.config')}}
        </span>
        <el-drawer append-to-body :title="$t('components.apptheme.customtheme')" :show-close="true"
            :visible.sync="showDrawer" :with-header="false" custom-class="app-custom-theme__drawer" @open="drawerOpen">
            <div class="app-custom-theme__color">
                <h3>{{$t('components.apptheme.color')}}</h3>
                <span v-for="(theme, index) in defaultThemes" :key="index" :class="{ 
                    'color-item': true,
                    [theme.codeName]: true,
                    'is-active': selectTheme && selectTheme == theme.codeName ? true : false
                }" :title="theme.title" :style="{ 'background-color': theme.color }"
                    @click="themeChange(theme.codeName)"/>
            </div>
            <div class="app-custom-theme__split"></div>
            <div class="app-custom-theme__theme-vars">
                <template v-for="(type, index) in themeTypes" >
                    <div class="theme-vars-group" v-if="!type.disabled" :key="type.value">
                        <span class="theme-vars-group__title">{{ type.label }}</span>
                        <div class="theme-vars-group__items">
                            <template v-for="(item, index) in type.items">
                                <div v-if="!item.disabled" :key="index" class="theme-vars-item">
                                    <span class="theme-vars-item__title">{{ item.label }}</span>
                                    <el-color-picker v-model="themeOptions[item.cssName]" :show-alpha="item.showAlpha" size="small" />
                                </div>
                            </template>
                            <div v-if="type.value === 'other' && fontsFamily && fontsFamily.length > 0" class="theme-vars-item theme-vars-item__font">
                                <span class="theme-vars-item__title">{{ $t('components.apptheme.caption.font') }}</span>
                                <el-select v-model="selectFont" size="small">
                                    <el-option v-for="font in fontsFamily" :key="font.value"
                                        :label="$t(`components.apptheme.fontfamilys.${font.label}`)"
                                        :value="font.value">
                                        <span :style="{ fontFamily: font.value }">{{$t(`components.apptheme.fontfamilys.${font.label}`)}}</span>
                                    </el-option>
                                </el-select>
                            </div>
                        </div>
                    </div>
                    <div v-if="!type.disabled && index < themeTypes.length" class="app-custom-theme__split" :key="index"></div>
                </template>
            </div>
            <div class="app-custom-theme__buttons">
                <app-button class="preview" @onClick="previewTheme">{{$t('components.apptheme.preview')}}</app-button>
                <app-button @onClick="saveThemeOptions(false)">{{$t('components.apptheme.save')}}</app-button>
                <app-button @onClick="reset">{{$t('components.apptheme.reset')}}</app-button>
                <app-button @onClick="share">{{$t('components.apptheme.share')}}</app-button>
            </div>
        </el-drawer>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator';
import { themeConfig, fontsConfig } from '@/config/themeConfig';
import { appConfig } from '@/config/appConfig';
import { AppServiceBase, textCopy } from 'ibiz-core';
import qs from 'qs';

@Component({})
export default class AppCustomTheme extends Vue {

    /**
     * 视图样式
     * 
     * @type {string}
     * @memberof AppCustomTheme
     */
    @Prop({ default: 'DEFAULT' }) public viewStyle!: string;

    /**
     * 系统-应用标识
     * 
     * @type {string}
     * @memberof AppCustomTheme
     */
    public AppTag: any;

    /**
     * 主题配置标识
     * 
     * @type {string}
     * @memberof AppCustomTheme
     */
    public themeOptionId: string = '';

    /**
     * 主题css变量配置
     * 
     * @type {string}
     * @memberof AppCustomTheme
     */
    public themeTypes: Array<any> = [];

    /**
     * 默认样式集合
     * 
     * @type {any[]}
     * @memberof AppCustomTheme
     */
    public defaultThemes: any[] = [];

    /**
     * 默认字体集合
     * 
     * @type {any[]}
     * @memberof AppCustomTheme
     */
    public fontsFamily: any[] = fontsConfig;

    /**
     * 环境配置
     * 
     * @type {any}
     * @memberof AppCustomTheme
     */
    public Environment: any = AppServiceBase.getInstance().getAppEnvironment();

    /**
     * 当前选中样式
     * 
     * @type {string}
     * @memberof AppCustomTheme
     */
    public selectTheme: string = '';

    /**
     * 当前选中字体
     * 
     * @type {any}
     * @memberof AppCustomTheme
     */
    public selectFont: any = {};

    /**
     * 是否显示抽屉
     * 
     * @type {boolean}
     * @memberof AppCustomTheme
     */
    public showDrawer: boolean = false;

    /**
     * 当前激活分页
     * 
     * @type {string}
     * @memberof AppCustomTheme
     */
    public activeSetting: string = '';

    /**
     * 主题配置
     * 
     * @type {any}
     * @memberof AppCustomTheme
     */
    public themeOptions: any = {};

    /**
     * 状态管理对象
     * 
     * @type {any}
     * @memberof AppCustomTheme
     */
    public store: any;

    /**
     * vue生命周期 -- created
     * 
     * @memberof AppCustomTheme
     */
    public created() {
        this.store = AppServiceBase.getInstance().getAppStore();
        this.AppTag = `${this.Environment.SysName}-${this.Environment.AppName}`;
        this.selectTheme = this.getSelectTheme();
        this.selectFont = this.getSelectFont();
        this.init();
        this.applyLess();
    }

    /**
     * 初始化
     * 
     * @memberof AppCustomTheme
     */
    private init(reload: boolean = true) {
        if (themeConfig && themeConfig.length > 0) {
            const themeTypes: string[] = [];
            themeConfig.forEach((theme: any) => {
                if (!theme.disabled) {
                    themeTypes.push(theme);
                    if (theme.codeName === this.selectTheme) {
                        this.themeTypes = theme.vars;
                        this.activeSetting = theme.vars[0].value;
                        this.initDefaultOptions(theme.vars, reload);
                    }
                }
            });
            this.$set(this, 'defaultThemes', themeTypes);
        }
    }

    /**
     * 初始化默认配置
     * 
     * @memberof AppCustomTheme
     */
    private initDefaultOptions(cssVars: any[], reload: boolean = true) {
        if (!cssVars || cssVars.length === 0) {
            return;
        }
        const themeOptions: any = {};
        cssVars.forEach((item: any) => {
            if (!item.disabled && item.items && item.items.length > 0) {
                item.items.forEach((child: any) => {
                    if (reload) {
                        if (child.default) {
                            Object.assign(themeOptions, { [child.cssName]: child.default });
                        }
                    } else {
                        if (this.themeOptions && this.themeOptions.hasOwnProperty(child.cssName)) {
                            Object.assign(themeOptions, { [child.cssName]: this.themeOptions[child.cssName] });
                        }
                    }
                })
            }
        });
        this.$set(this, 'themeOptions', themeOptions);
    }

    /**
     * 获取分享主题配置
     * 
     * @memberof AppCustomTheme
     */
    public async getShareThemeOptions(themeOptionId: any) {
        try {
            const res = await this.$http.get(`/configs/share/${themeOptionId}`);
            if (res.status == 200 && res.data && res.data.model) {
                return res.data.model;
            } else {
                return null;
            }
        } catch (error: any) {
            this.$throw(this.$t('components.apptheme.error.getshareurl'));
            return null;
        }
    }

    /**
     * 获取选中主题
     * 
     * @memberof AppCustomTheme
     */
    private getSelectTheme() {
        if (this.store && this.store.state && this.store.state.selectTheme) {
            return this.store.state.selectTheme;
        } else if (localStorage.getItem('theme-class')) {
            return localStorage.getItem('theme-class');
        } else {
            return appConfig.defaultTheme || 'app-theme-default';
        }
    }

    /**
     * 获取选中字体
     * 
     * @memberof AppCustomTheme
     */
    private getSelectFont() {
        if (this.store && this.store.state && this.store.state.selectFont) {
            return this.store.state.selectFont;
        } else if (localStorage.getItem('font-family')) {
            return localStorage.getItem('font-family');
        } else {
            return appConfig.defaultFont || 'Microsoft YaHei';
        }
    }

    /**
     * 处理主题配置
     * 
     * @memberof AppCustomTheme
     */
    public handleThemeOptions() {
        this.init(false);
    }

    /**
     * 切换主题
     * 
     * @memberof AppCustomTheme
     */
    public themeChange(tag: string) {
        if (tag && this.selectTheme != tag) {
            this.selectTheme = tag;
            this.init(true);
        }
    }

    /**
     * 主题应用
     * 
     * @memberof AppCustomTheme
     */
    public previewTheme() {
        this.applyLess();
    }

    /**
     * 应用less变量
     * 
     * @memberof AppCustomTheme
     */
    private applyLess() {
        const less: any = (window as any).less;
        if (!less) {
            return;
        }
        less.modifyVars(this.getVars()).then((res: any) => {
            localStorage.setItem('theme-class', this.selectTheme);
            localStorage.setItem('font-family', this.selectFont);
            if (this.store) {
                this.store.commit('setCurrentSelectTheme', this.selectTheme);
                this.store.commit('setCurrentSelectFont', this.selectFont);
            }
        })
    }

    /**
     * 获取变量
     * 
     * @memberof AppCustomTheme
     */
    private getVars(): any {
        const select = this.defaultThemes.find((item: any) => item.codeName === this.selectTheme);
        const vars = {
            "@primary": select.color,
            "@font-family": this.selectFont
        };
        if (this.themeOptions && Object.keys(this.themeOptions).length > 0) {
            Object.keys(this.themeOptions).forEach((key: string) => {
                Object.assign(vars, { [`@${key}`]: this.themeOptions[key] });
            })
        }
        return vars;
    }

    /**
     * 抽屉打开回调
     * 
     * @memberof AppCustomTheme
     */
    public drawerOpen() {
        this.selectTheme = this.getSelectTheme();
        const themeOptions = localStorage.getItem(`${this.AppTag}-theme-options`);
        if (themeOptions) {
            this.themeOptions = JSON.parse(themeOptions);
        } else {
            this.init(false);
        }
    }

    /**
     * 保存主题配置
     * 
     * @memberof AppCustomTheme
     */
    public saveThemeOptions(isShare: boolean = false) {
        if (this.themeOptions) {
            this.$http.put(`/configs/${this.AppTag}/theme-setting`,
                { model: { cssValue: JSON.stringify(this.themeOptions), fontFamily: this.selectFont } }).then((res: any) => {
                    if (res) {
                        const _this: any = this;
                        _this.$success(isShare ? this.$t('components.apptheme.applytheme') : this.$t('components.apptheme.success.savethemeoption'));
                        this.previewTheme();
                    }
                });
        }
    }

    /**
     * 重置主题配置
     * 
     * @memberof AppCustomTheme
     */
    public reset() {
        if (this.selectTheme) {
            this.init();
        }
    }

    /**
     * 分享主题
     * 
     * @memberof AppCustomTheme
     */
    public share() {
        this.saveThemeOptions();
        try {
            this.$http.get(`/configs/share/${this.AppTag}/theme-setting`).then((res: any) => {
                if (res.status == 200 && res.data) {
                    const shareUrl = this.generateShareUrl(res.data);
                    const _this: any = this;
                    const h = this.$createElement('el-input', {
                        props: {
                            value: shareUrl,
                            disabled: true,
                            size: 'small'
                        }
                    })
                    _this.$alert(h, this.$t('components.apptheme.createurl'), {
                        confirmButtonText: this.$t('components.apptheme.configbutton'),
                        customClass: 'share-theme-box',
                        callback: (action: any) => {
                            _this.copyShareUrl(action, shareUrl);
                        }
                    })
                } else {
                    this.$throw(this.$t('components.apptheme.error.generateshareurl'));
                }
            })
        } catch (error: any) {
            this.$throw(this.$t('components.apptheme.error.generateshareurl'));
        }
    }

    /**
     * 生成分享链接
     * 
     * @memberof AppCustomTheme
     */
    public generateShareUrl(themeOptionId: any) {
        const href: string = window.location.href;
        const userName = this.$store.getters.getAppData().context?.srfusername;
        const baseStr = window.btoa(`applyThemeOption=true&themeOptionId=${themeOptionId}`);
        const param = `#/appsharepage?theme=${baseStr}&shareUserName=${encodeURIComponent(userName)}`;
        return href.replace(/#\/\S*/, param);
    }

    /**
     * 拷贝分享链接
     * 
     * @memberof AppCustomTheme
     */
    public copyShareUrl(action: string, shareUrl: any) {
        if (action == 'cancel') {
            return;
        }
        textCopy.copy(shareUrl);
        this.$success(this.$t('components.apptheme.success.copyurl'), 'saveShareThemeUrlSuccess');
    }

    /**
     * 处理链接参数
     * 
     * @memberof AppCustomTheme
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
     * 是否是分享链接打开
     * 
     * @memberof AppCustomTheme
     */
    public isShare(): boolean {
        const urlParams = this.parseViewParam(window.location.href);
        if (Object.keys(urlParams).length == 0) {
            return false;
        }
        if (urlParams.hasOwnProperty('theme') && urlParams['theme']) {
            try {
                const tempParam: any = this.parseViewParam(window.atob(urlParams['theme']));
                if (tempParam.hasOwnProperty('applyThemeOption')
                    && tempParam['applyThemeOption'] == 'true'
                    && tempParam.hasOwnProperty('themeOptionId')
                    && tempParam['themeOptionId'] != ''
                    && tempParam['themeOptionId'] != null) {
                    this.themeOptionId = tempParam['themeOptionId'];
                    return true;
                }
            } catch (error: any) {
                return false;
            }
        }
        return false;
    }

    /**
     * vue生命周期 -- destroyed
     * 
     * @memberof AppCustomTheme
     */
    public destroyed() {
        localStorage.removeItem(`${this.AppTag}-theme-options`);
    }

}

</script>