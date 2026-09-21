import { FooterItemsService } from '../app-service/common-service/footer-items-service';
import { UIStateService } from '../app-service/common-service/ui-state-service';
import { TopItemsService } from '../app-service/common-service/top-items-service';
import { Notice } from '../utils';
import { Store } from 'vuex';

declare module 'vue/types/vue' {
    interface Vue {
        $Notice: Notice,
        $store: Store<any>,
        $util: any,
        $t: any,
        $tl: Function,        
        $message:any,
        $appmodal: any,
        $appdrawer: any,
        $footerRenderService: FooterItemsService;
        $topRenderService: TopItemsService;
        $uiState: UIStateService;
    }
}
declare global {
    interface Object {
        /**
         * 清除所有属性，不改变内存地址
         *
         * @memberof Object
         */
        clearAll(): void;
    }

    /**
     * 判断对象是否存在，判断是否为undefined或null，避免数值型0误判
     *
     * @param {*} obj
     * @returns {boolean}
     */
    function isExist(obj: any): boolean;

    /**
     * 判断字符串是否为空
     *
     * @param {string | undefined | null} str
     * @returns {boolean}
     */
    function isEmpty(str: string | undefined | null): boolean;

    /**
     * 判断字符串，存在并且不为空
     *
     * @param {string | undefined | null} str
     * @returns {boolean}
     */
    function isExistAndNotEmpty(str: string | undefined | null): boolean;
}
