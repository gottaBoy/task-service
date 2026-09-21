import { Vue, Component } from 'vue-property-decorator';
import { VNode, CreateElement } from 'vue';
import { FooterItemsService } from '../../../../app-service';
import { Subscription } from 'rxjs';

/**
 * 应用头部
 *
 * @export
 * @class AppStyle2Footer
 * @extends {Vue}
 */
@Component({})
export class AppStyle2Footer extends Vue {
    /**
     * 底部项绘制服务
     *
     * @private
     * @memberof AppStyle2Footer
     */
    private footerItemsService = new FooterItemsService();

    /**
     * @description 组件事件
     * @type {(Subscription | undefined)}
     * @memberof AppStyle2Footer
     */
    public footerEvent: Subscription | undefined;

    /**
     * 组件创建完毕
     *
     * @memberof AppStyle2Footer
     */
    public created(): void {
        this.footerEvent = this.footerItemsService.tickTrigger().subscribe(() => {
            this.$nextTick();
        });
    }

    public destroyed() {
        if (this.footerEvent) {
            this.footerEvent.unsubscribe();
        }
    }

    /**
     * 绘制内容
     *
     * @returns {VNode}
     * @memberof AppStyle2Footer
     */
    public render(h: CreateElement): VNode {
        return (
            <div class="app-style2-footer">
                <div class="app-style2-footer__left">
                    {this.footerItemsService.leftItemsRenders.map((item) => {
                        return <div class="app-style2-footer__item">{item(h)}</div>;
                    })}
                </div>
                <div class="app-style2-footer__content">
                    {this.footerItemsService.centerItemsRenders.map((item) => {
                        return <div class="app-style2-footer__item">{item(h)}</div>;
                    })}
                </div>
                <div class="app-style2-footer__right">
                    {this.footerItemsService.rightItemsRenders.map((item) => {
                        return <div class="app-style2-footer__item">{item(h)}</div>;
                    })}
                </div>
            </div>
        );
    }
}
