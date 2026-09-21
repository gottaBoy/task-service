import { AppCommunicationsCenter } from '../modules/message-center/app-communications-center';
declare global {
    interface IBz {
        // 全局消息服务
        acc?: AppCommunicationsCenter;
        // 实体服务实例缓存
        sc?: Map<string, any>;
    }
    interface Window {
        ___ibz___: IBz;
        ___ibz___api_init: boolean;
        ___ibz___GlobalHeaders: Headers;
    }
    const ___ibz___: IBz;
}
