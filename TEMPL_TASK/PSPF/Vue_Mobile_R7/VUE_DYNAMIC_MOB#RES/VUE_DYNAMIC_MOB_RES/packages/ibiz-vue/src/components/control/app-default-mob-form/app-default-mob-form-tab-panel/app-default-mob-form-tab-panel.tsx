import { IPSDEFormTabPanel } from '@ibiz/dynamic-model-api';
import { throttle } from 'ibiz-core';
import { Vue, Component, Prop, Inject, Watch } from 'vue-property-decorator';
import { AppDefaultMobFormDetail } from '../app-default-mob-form-detail/app-default-mob-form-detail';

/**
 * 表单UI组件
 *
 * @export
 * @class AppDefaultMobFormTabPanel
 * @extends {Vue}
 */
@Component({})
export class AppDefaultMobFormTabPanel extends AppDefaultMobFormDetail {
    /**
     * 表单成员实例对象
     *
     * @type {*}
     * @memberof AppDefaultMobFormTabPanel
     */
     @Prop() public declare detailsInstance: IPSDEFormTabPanel;

    /**
     * 表单数据
     *
     * @type {*}
     * @memberof AppDefaultMobFormTabPanel
     */
    @Prop() public data: any;

    /**
     * 绘制内容
     *
     * @returns {*}
     * @memberof AppDefaultMobFormTabPanel
     */
    public render(): any {
        const { detailClassNames } = this.renderOptions;
        let { codeName, caption, contentHeight, contentWidth } = this.detailsInstance;
        let style = { 
            height: contentHeight ? contentHeight + 'px' : false,
            width: contentWidth ? contentWidth + 'px' : false,
        };
        // 设置默认值
        let layoutmode = this.detailsInstance.getPSLayout()?.layout || 'TABLE_24COL';
        caption = caption || codeName;
        if(this.detailsInstance.dynaClass){
            const context = this.context;
            const viewparams = this.viewparams;
            const data = this.data;
            Object.assign(detailClassNames,...eval(this.detailsInstance.dynaClass))
        }  
        return (
            <van-tabs
                type="card"
                v-show={this.runtimeModel.visible}
                style={style}
                name={codeName.toLowerCase()}
                class={{...detailClassNames}}
                value={this.runtimeModel.activatedPage}
                on-click={(e: any) => {
                  throttle(this.runtimeModel?.clickPage,[e],this);
                }}
            >
                {this.$slots.default}
            </van-tabs>
        );
    }
}
