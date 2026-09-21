import { throttle, Util } from 'ibiz-core';
import { Emit, Prop, Watch } from 'vue-property-decorator';
import { DrbarControlBase } from '../../../widgets/drbar-control-base';

/**
 * 数据关系栏部件基类
 *
 * @export
 * @class AppDrbarBase
 * @extends {TabExpPanelBase}
 */
export class AppDrbarBase extends DrbarControlBase {

    /**
     * 部件静态参数
     *
     * @memberof AppDrbarBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 部件动态参数
     *
     * @memberof AppDrbarBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 监听动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppDrbarBase
     */
    @Watch('dynamicProps', {
        immediate: true,
    })
    public onDynamicPropsChange(newVal: any, oldVal: any) {
        if (newVal && !Util.isFieldsSame(newVal, oldVal)) {
            super.onDynamicPropsChange(newVal, oldVal);
        }
    }

    /**
     * 监听静态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppDrbarBase
     */
    @Watch('staticProps', {
        immediate: true,
    })
    public onStaticPropsChange(newVal: any, oldVal: any) {
        if (newVal && !Util.isFieldsSame(newVal, oldVal)) {
            super.onStaticPropsChange(newVal, oldVal);
        }
    }

    /**
     * 销毁视图回调
     *
     * @memberof AppDrbarBase
     */
    public destroyed() {
        this.ctrlDestroyed();
    }

    /**
     * 部件事件
     *
     * @param {{ controlname: string; action: string; data: any }} { controlname 部件名称, action 事件名称, data 事件参数 }
     * @memberof AppDrbarBase
     */
    @Emit('ctrl-event')
    public ctrlEvent({ controlname, action, data }: { controlname: string; action: string; data: any }): void { }

    /**
     * @description 获取GroupTitle
     * @param {*} item
     * @memberof AppDrbarBase
     */
     public getGroupTitle(item: any): string {
        if (this.showMode == 'DEFAULT') {
            return this.$tl(item.getCapPSLanguageRes?.()?.lanResTag, item.caption);
        }
        if (this.selection && this.selection.groupCodeName == item.id) {
            return this.$tl(item.getCapPSLanguageRes?.()?.lanResTag, item.caption) + '-' + this.selection.caption;
        } else {
            return this.$tl(item.getCapPSLanguageRes?.()?.lanResTag, item.caption);
        }
    }

    /**
     * @description 绘制icon图标
     * @param {*} item
     * @return {*} 
     * @memberof AppDrbarBase
     */
    public renderIcon(item: any) {
        const itemPSSysImage = (item as any).getPSSysImage?.()
        return (
            itemPSSysImage?.imagePath ? <img src={itemPSSysImage.imagePath} class="item__icon"></img> :
            itemPSSysImage?.cssClass ? <i class={[itemPSSysImage.cssClass, {'item__icon': true}]}></i> : null
        )
    }

    /**
     * @description 渲染菜单项
     * @param {any[]} items
     * @return {*} 
     * @memberof AppDrbarBase
     */
    public renderMenuItems(items: any[]) {
        return items.map((item: any, index: number) => {
            if (this.showMode == 'INDEXMODE' && item.id == this.formName) {
                return null;
            }
            if (item.items && item.items.length > 0) {
                return (
                    <el-submenu key={index} index={item.id} disabled={item.disabled}>
                        <span class="app-control-drbar__item__title" slot="title">
                            {this.renderIcon(item)}
                            {this.getGroupTitle(item)}
                        </span>
                        {this.renderMenuItems(item.items)}
                    </el-submenu>
                )
            } else {
                return (
                    <el-popover
                        content={this.$t("components.appformdruipart.blockuitipinfo")}
                        width="150"
                        popper-class="app-control-drbar__popover"
                        disabled={!item.disabled}
                        placement="right"
                        trigger="hover">
                        <el-menu-item slot="reference" class="app-control-drbar__popover__item" key={index} index={item.id} disabled={item.disabled}>
                            <span class="item__title" slot="title">
                                { this.renderIcon(item) }
                                {this.$tl(item.getCapPSLanguageRes?.()?.lanResTag, item.caption)}
                            </span>
                            {item.counter && (item.counter.count || item.counter.count == 0) ?
                                <span v-badge={item.counter} class="item__badge"></span> : null}
                        </el-menu-item>
                    </el-popover>
                )
            }
        })
    }

    /**
     * 绘制关系栏部件
     *
     * @returns {*}
     * @memberof AppDrbarBase
     */
    public render() {
        if (!this.controlIsLoaded) {
            return null;
        }
        const { controlClassNames } = this.renderOptions;
        return (
            <div class={{ ...controlClassNames, [`app-control-drbar--${this.showMode.toLowerCase()}`]: true }} style={{ width: `${this.width}px` }}>
                <el-menu
                    mode={this.menuDir}
                    class="app-control-drbar__content control-content"
                    default-openeds={this.defaultOpeneds}
                    default-active={this.selection?.id}
                    on-select={(event: any) => throttle(this.select, [event], this)}>
                    {this.renderMenuItems(this.menuItems)}
                </el-menu>
            </div>
        )
    }
}