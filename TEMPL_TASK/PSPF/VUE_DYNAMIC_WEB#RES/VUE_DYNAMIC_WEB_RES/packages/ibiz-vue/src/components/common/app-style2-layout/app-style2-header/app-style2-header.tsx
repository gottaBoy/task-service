import { Vue, Component } from 'vue-property-decorator';
import { VNode } from 'vue';

/**
 * 应用头部
 *
 * @export
 * @class AppStyle2Header
 * @extends {Vue}
 */
@Component({})
export class AppStyle2Header extends Vue {
    /**
     * 绘制内容
     *
     * @returns {VNode}
     * @memberof AppStyle2Header
     */
    public render(h: any): VNode {
        return (
            <div class="app-style2-header">
                <div class="app-style2-header__left">
                    {this.$slots.left}
                    {Object.is(this.$uiState.layoutState.styleMode, 'STYLE2') ? (
                        <app-breadcrumb></app-breadcrumb>
                    ) : null}
                </div>
                <div class="app-style2-header__right">{this.$slots.right}</div>
            </div>
        );
    }
}
