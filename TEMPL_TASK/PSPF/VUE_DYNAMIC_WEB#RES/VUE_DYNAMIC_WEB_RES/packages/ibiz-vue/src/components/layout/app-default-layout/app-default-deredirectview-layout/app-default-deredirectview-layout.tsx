import { AppDefaultViewLayout } from "../app-default-view-layout/app-default-view-layout";
import { Component } from 'vue-property-decorator';

@Component({})
export class AppDefaultDeRedirectViewLayout extends AppDefaultViewLayout {

    /**
     * 绘制内容
     * 
     * @memberof AppDefaultDeRedirectViewLayout
     */
     public renderContent() {
        return [
            <div class='view-content'>
                <div class="view-content__body">
                    <img src={`${__webpack_public_path__}./assets/img/redirect.svg`} />
                    <div class="text">页面跳转中~</div>
                </div>
            </div>
        ]
    }
}