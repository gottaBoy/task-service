/**
 * 应用加载服务类
 *
 * @export
 * @class AppLoadingService
 * @extends {LoadingServiceBase}
 */
 export class AppLoadingService {

    /**
     * 唯一实例
     *
     * @private
     * @static
     * @memberof AppLoadingService
     */
     private static readonly instance = new AppLoadingService();

    /**
     * 获取唯一实例
     *
     * @static
     * @returns {AppLoadingService}
     * @memberof AppLoadingService
     */
    public static getInstance(): AppLoadingService {
        return AppLoadingService.instance;
    }

    /**
     * 视图loading计数器
     *
     * @type {number}
     * @memberof AppLoadingService
     */
     public loadingCounter: number = 0
    
     /**
      * 视图loading状态变量，true时正在loading
      *
      * @type {boolean}
      * @memberof AppLoadingService
      */
     public isLoading:boolean = false;
 
     /**
      * 开启视图loading
      *
      * @memberof AppLoadingService
      */
     public beginLoading(){
         this.loadingCounter++;
         if(!this.isLoading){
            this.isLoading = true;
         }
     }
 
     /**
      * 关闭视图loading
      *
      * @memberof AppLoadingService
      */
     public endLoading(){
         this.loadingCounter--;
         if(this.isLoading && this.loadingCounter == 0){
            this.isLoading = false;
         }
     }

}

