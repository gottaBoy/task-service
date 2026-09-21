import { Component, Emit, Prop, Inject } from 'vue-property-decorator';
import { ViewContainerBase } from './view-container-base';

/**
 * 视图壳
 *
 * @export
 * @class AppViewShell
 * @extends {ViewContainerBase}
 */
@Component({})
export class AppViewShell extends ViewContainerBase {

    /**
    * 数据变化
    *
    * @param {*} val
    * @returns {*}
    * @memberof AppViewShell
    */
    @Emit()
    public viewDatasChange(val: any): any {
        return val;
    }

    /**
     * 视图静态参数
     *
     * @type {string}
     * @memberof AppViewShell
     */
    @Prop() public declare staticProps: any;

    /**
     * 视图动态参数
     *
     * @type {string}
     * @memberof AppViewShell
     */
    @Prop() public declare dynamicProps: any;

    /**
     * Vue声明周期
     *
     * @memberof AppViewShell
     */
    public created() {
        this.ViewContainerInit();
        this.loadPreViewDynamicModelData();
    }

    /**
     * 视图绘制
     *
     * @memberof AppViewShell
     */
    public render(h: any) {
        if(!this.viewContainerName){
            return;
        }
        return h(this.viewContainerName, {
            props: { dynamicProps: this.dynamicProps, staticProps: this.viewContext },
            on: {
                'view-event': this.handleViewEvent.bind(this)
            }
        })
    }

}
