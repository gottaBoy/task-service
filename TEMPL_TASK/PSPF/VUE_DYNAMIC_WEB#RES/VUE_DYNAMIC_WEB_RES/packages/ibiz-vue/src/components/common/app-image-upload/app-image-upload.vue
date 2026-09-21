<template>
  <div :class="{'app-picture-upload': true, 'is-single': !multiple}">
    <ul class='el-upload-content picture-upload__card'>
<!-- 绘制缩略图 Start -->
        <li v-for="(file,index) in files" :key="index" class='el-upload-content__item is-success'>
          <el-image :src="file.url" class='el-upload-content__item__thumbnail'>
              <div slot='error' class='item__image'>
                  <i class='el-icon-picture-outline'></i>
              </div>
          </el-image>
          <a class='el-upload-content__item__caption'>
              <i class='el-icon-document'></i> {{file.name}}
          </a>
          <i class='el-icon-close'></i>
          <label class='el-upload-content__item__status-label'>
              <i class='el-icon-upload-success el-icon-check'></i>
          </label>
          <span class='el-upload-content__item__action'>
              <span class='item__action__preview'>
                  <i class='el-icon-zoom-in' @click="onPreview(file)"></i>
              </span>
              <span class='item__action__download'>
                  <i class='el-icon-download' @click="onDownload(file)"></i>
              </span>
              <span :style="{ 'display': disabled || readonly? 'none' : 'inline-block' }" class='item__action__delete'>
                  <i class='el-icon-delete' @click="onRemove(file, files)"></i>
              </span>
          </span>
        </li>
            <!-- 绘制缩略图 end -->
    </ul>
    <!-- 文件上传 -->
    <el-upload 
      v-if="!readonly && (multiple || files.length === 0)" 
      :class="{'is-disabled':disabled}"
      :limit="multiple ? limit: 1"
      :disabled="disabled"
      :action="uploadUrl"
      :multiple="multiple"
      :headers="headers"
      :show-file-list="false"
      list-type="picture-card"
      :file-list="files"
      :accept="accept"
      :before-upload="beforeUpload"
      :on-success="onSuccess"
      :before-remove="onRemove"
      :on-error="onError"
      :on-preview="onDownload"
      :on-exceed="handleExceed"
      >
      <i class="el-icon-plus"></i>
    </el-upload>
    <!-- 预览 -->
    <modal v-model="dialogVisible" footer-hide class-name='app-picture-upload-model'>
      <el-image :src="dialogImageUrl">
          <div slot='error' class='upload-model__image'>
              <i class='el-icon-picture-outline'></i>
          </div>
      </el-image>
    </modal>
  </div>
</template>
<script lang = 'ts'>
import { Vue, Component, Prop, Watch, Provide } from 'vue-property-decorator';
import { AppServiceBase, getSessionStorage, Http, Util } from 'ibiz-core';
import { getCookie } from 'qx-util';
import { Subject, Subscription } from 'rxjs';

@Component({})
export default class AppImageUpload extends Vue {

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof AppImageUpload
     */
    @Prop() public formState?: Subject<any>

    /**
     * 是否忽略表单项书香值变化
     *
     * @type {boolean}
     * @memberof AppImageUpload
     */
    @Prop() public ignorefieldvaluechange?: boolean;

    /**
     * 表单状态事件
     *
     * @private
     * @type {(Subscription | undefined)}
     * @memberof AppImageUpload
     */
    private formStateEvent: Subscription | undefined;

    /**
     * 表单数据
     *
     * @type {string}
     * @memberof AppImageUpload
     */
    @Prop() public data!: string;

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof AppFormDRUIPart
     */
    @Prop() public viewparams!: any;

    /**
     * 视图上下文
     *
     * @type {*}
     * @memberof AppAutocomplete
     */
    @Prop() public context!: any;

    /**
     * 初始化值
     *
     * @type {*}
     * @memberof AppImageUpload
     */
    @Prop() public value?: any;

    /**
     * 数据值变化
     *
     * @param {*} newval
     * @param {*} val
     * @returns
     * @memberof AppImageUpload
     */
    @Watch('value')
    onValueChange(newval: any, val: any) {
        if (this.ignorefieldvaluechange) {
            return;
        }
        this.getParams();
        this.setFiles(newval)
        this.dataProcess();
    }

    /**
     * 所属表单项名称
     *
     * @type {string}
     * @memberof AppImageUpload
     */
    @Prop() public name!: string;

    /**
     * 是否禁用
     *
     * @type {boolean}
     * @memberof AppImageUpload
     */
    @Prop() public disabled?: boolean;

    /**
     * 只读模式
     * 
     * @type {boolean}
     */
    @Prop({default: false}) public readonly?: boolean;

    /**
     * 最大允许上传个数
     *
     * @type {*}
     * @memberof AppImageUpload
     */
    @Prop({default: 9999}) public limit!: number;

    /**
     * 接受上传的文件类型
     *
     * @type {*}
     * @memberof AppImageUpload
     */
    @Prop({default: 'image/*'}) public accept!: string;

    /**
     * 上传参数
     *
     * @type {*}
     * @memberof AppImageUpload
     */
    @Prop() public uploadparams?: any;

    /**
     * 下载参数
     *
     * @type {*}
     * @memberof AppImageUpload
     */
    @Prop() public exportparams?: any;

    /**
     * 自定义参数
     *
     * @type {*}
     * @memberof AppImageUpload
     */
    @Prop() public customparams?: any;

    /**
     * 上传文件路径
     *
     * @memberof AppImageUpload
     */
    public uploadUrl = AppServiceBase.getInstance().getAppEnvironment().BaseUrl + AppServiceBase.getInstance().getAppEnvironment().UploadFile;

    /**
     * 下载文件路径
     *
     * @memberof AppImageUpload
     */
    public downloadUrl = AppServiceBase.getInstance().getAppEnvironment().BaseUrl + AppServiceBase.getInstance().getAppEnvironment().ExportFile;

    /**
     * 文件列表
     *
     * @memberof AppImageUpload
     */
    @Provide() public files = [];

    /**
     * 上传params
     *
     * @type {Array<any>}
     * @memberof AppImageUpload
     */
    public upload_params: Array<any> = [];

    /**
     * 导出params
     *
     * @type {Array<any>}
     * @memberof AppImageUpload
     */
    public export_params: Array<any> = [];

    /**
     * 自定义数组
     *
     * @type {Array<any>}
     * @memberof AppImageUpload
     */
    public custom_arr: Array<any> = [];

    /**
     * 请求头
     * 
     * @type {*}
     * @memberof AppImageUpload 
     */
    public headers: any = {};

    /**
     * 应用参数
     *
     * @type {*}
     * @memberof AppImageUpload
     */
    public appData: any="";

    /**
     * 设置files
     *
     * @private
     * @memberof AppImageUpload
     */
    private setFiles(value:any): void {
        if (!value) {
            this.files = [];
            return
        }
        let _files = JSON.parse(value);
        if (value && Object.prototype.toString.call(_files)=='[object Array]') {
            this.files = _files;
        } else {
            this.files = [];
        }
    }

    /**
     * 数据处理
     *
     * @private
     * @memberof AppImageUpload
     */
    private dataProcess(): void {
        let _url = `${AppServiceBase.getInstance().getAppEnvironment().BaseUrl}${AppServiceBase.getInstance().getAppEnvironment().UploadFile}`;
        if (this.upload_params.length > 0 ) {
            _url +='?';
            this.upload_params.forEach((item:any,i:any)=>{
                _url += `${Object.keys(item)[0]}=${Object.values(item)[0]}`;
                if(i<this.upload_params.length-1){
                    _url += '&';
                }
            })
            
        }
        
        this.uploadUrl = _url;
        
        this.files.forEach((file: any) => {
            let url = `${this.downloadUrl}/${file.id}`;
            if (this.export_params.length > 0) {
                url +='?';
                this.export_params.forEach((item:any,i:any)=>{
                    url += `${Object.keys(item)[0]}=${Object.values(item)[0]}`;
                    if(i<this.export_params.length-1){
                        url += '&';
                    }
                })
            }
            file.url = url;
        });
    }

    /**
     * vue 生命周期
     *
     * @memberof AppImageUpload
     */
    public created() {
        this.setHeaders();
        if (this.formState) {
            this.formStateEvent = this.formState.subscribe(($event: any) => {
                // 表单加载完成
                if (Object.is($event.type, 'load')) {
                    this.getParams();
                    this.setFiles(this.value);
                    this.dataProcess();
                }
            });
        }
    }

    /**
     * vue 生命周期
     *
     * @memberof AppImageUpload
     */
    public mounted() {
        this.getParams();
        this.setFiles(this.value);
        this.dataProcess();
    }

    /**
     * 设置请求头
     * 
     * @memberof AppFileUpload
     */
    public setHeaders(){
        this.appData = this.$store.getters.getAppData();
        this.headers['srfappdata'] = this.appData;
        if (AppServiceBase.getInstance().getAppEnvironment().SaaSMode) {
            let activeOrgData = getSessionStorage('activeOrgData');
            this.headers['srforgid'] = activeOrgData?.orgid;
            this.headers['srfsystemid'] = activeOrgData?.systemid;
            if(getSessionStorage("srfdynaorgid")){
                this.headers['srfdynaorgid'] = getSessionStorage("srfdynaorgid");
            }
        } else {
            if(getSessionStorage("srfdynaorgid")){
                this.headers['srfdynaorgid'] = getSessionStorage("srfdynaorgid");
            }
        }
        if (getCookie('ibzuaa-token')) {
            this.headers['Authorization'] = `Bearer ${getCookie('ibzuaa-token')}`;
        } else {
            // 第三方应用打开免登
            if (sessionStorage.getItem("srftoken")) {
                const token = sessionStorage.getItem('srftoken');
                this.headers['Authorization'] = `Bearer ${token}`;
            }
        }
    }

    /**
     *获取上传，导出参数
     *
     *@memberof AppImageUpload
     */
    public getParams(){
        let uploadparams: any = this.uploadparams ? JSON.parse(JSON.stringify(this.uploadparams)) : {};
        let exportparams: any = this.exportparams ? JSON.parse(JSON.stringify(this.exportparams)) : {};

        let upload_params: Array<string> = [];
        let export_params: Array<string> = [];

        let param:any = this.viewparams;
        let context:any = this.context;
        let _data:any = JSON.parse(this.data);

        if (uploadparams && Object.keys(uploadparams).length > 0) {
            upload_params = Util.computedNavData(_data,param,context,uploadparams);    
        }
        if (exportparams && Object.keys(exportparams).length > 0) {
            export_params = Util.computedNavData(_data,param,context,exportparams);
        }
        
        this.upload_params = [];
        this.export_params = [];

        for (const item in upload_params) {
            this.upload_params.push({
                [item]:upload_params[item]
            })
        }
        for (const item in export_params) {
            this.export_params.push({
                [item]:export_params[item]
            })
        }
    }

    /**
     * 组件销毁
     *
     * @memberof AppImageUpload
     */
    public destroyed(): void {
        if (this.formStateEvent) {
            this.formStateEvent.unsubscribe();
        }
    }

    /**
     * 上传之前
     *
     * @param {*} file
     * @memberof AppImageUpload
     */
    public beforeUpload(file: any) {
        // console.log('上传之前');
    }

    /**
     * 上传成功回调
     *
     * @param {*} response
     * @param {*} file
     * @param {*} fileList
     * @returns
     * @memberof AppImageUpload
     */
    public onSuccess(response: any, file: any, fileList: any) {
        if (!response) {
            return;
        }
        let arr: Array<any> = [];
        this.files.forEach((_file: any) => {
            arr.push({ name: _file.name, id: _file.id })
        });
        if(response?.length > 0){
            for (let index = 0; index < response.length; index++) {
              const file = response[index];
              arr.push({ name: file.filename, id: file.fileid });
            }
        }else{
            arr.push({ name: response.filename, id: response.fileid });
        }
        let value: any = arr.length > 0 ? JSON.stringify(arr) : null;
        this.$emit('formitemvaluechange', { name: this.name, value: value });
    }

    /**
     * 上传失败回调
     *
     * @param {*} error
     * @param {*} file
     * @param {*} fileList
     * @memberof AppImageUpload
     */
    public onError(error: any, file: any, fileList: any) {
        this.$throw(error,'onError');
    }

    /**
     * 删除文件
     *
     * @param {*} file
     * @param {*} fileList
     * @memberof AppImageUpload
     */
    public onRemove(file: any, fileList: any) {
        let arr: Array<any> = [];
        fileList.forEach((f: any) => {
            if (f.id != file.id) {
                arr.push({ name: f.name, id: f.id });
            }
        });
        let value: any = arr.length > 0 ? JSON.stringify(arr) : null;
        this.$emit('formitemvaluechange', { name: this.name, value: value });
    }

    /**
     * 下载文件
     *
     * @param {*} file
     * @memberof AppImageUpload
     */
    public onDownload(file: any) {
        this.DownloadFile(file.url, file);
    }

    /**
     * 下载文件
     *
     * @param item 下载文件
     * @memberof AppImageUpload
     */
    public DownloadFile(url: string,file: any) {
        let downloadUrl: string = url;
        const BaseUrl = AppServiceBase.getInstance().getAppEnvironment().BaseUrl;
        if (url.startsWith(BaseUrl)) {
            downloadUrl = url.replace(BaseUrl, '');
        }
        // 发送get请求
        Http.getHttp()({
            method: 'get',
            url: downloadUrl,
            responseType: 'blob'
        }).then((response: any) => {
            if (!response || response.status != 200) {
                this.$throw(this.$t('components.appfileupload.downloaderror'));
                return;
            }
            // 请求成功，后台返回的是一个文件流
            if (response.data) {
                // 获取文件名
                const filename = file.name;
                const ext = '.' + filename.split('.').pop();
                let filetype = this.calcFilemime(ext);
                // 用blob对象获取文件流
                let blob = new Blob([response.data], {type: filetype});
                // 通过文件流创建下载链接
                var href = URL.createObjectURL(blob);
                // 创建一个a元素并设置相关属性
                let a = document.createElement('a');
                a.href = href;
                a.download = filename;
                // 添加a元素到当前网页
                document.body.appendChild(a);
                // 触发a元素的点击事件，实现下载
                a.click();
                // 从当前网页移除a元素
                document.body.removeChild(a);
                // 释放blob对象
                URL.revokeObjectURL(href);
            } else {
                this.$throw(this.$t('components.appfileupload.downloaderror'));
            }
        }).catch((error: any) => {
            console.error(error);
        });
    }

    /**
     * 计算文件mime类型
     *
     * @param filetype 文件后缀
     * @memberof AppImageUpload
     */
    public calcFilemime(filetype: string): string {
        let mime = "image/png";
        switch(filetype) {
            case ".wps":
            mime = "application/kswps";
            break;
            case ".doc":
            mime = "application/msword";
            break;
            case ".docx":
            mime = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
            break;
            case ".txt":
            mime = "text/plain";
            break;
            case ".zip":
            mime = "application/zip";
            break;
            case ".png":
            mime = "imgage/png";
            break;
            case ".gif":
            mime = "image/gif";
            break;
            case ".jpeg":
            mime = "image/jpeg";
            break;
            case ".jpg":
            mime = "image/jpeg";
            break;
            case ".rtf":
            mime = "application/rtf";
            break;
            case ".avi": 
            mime = "video/x-msvideo";
            break;
            case ".gz": 
            mime = "application/x-gzip";
            break;
            case ".tar": 
            mime = "application/x-tar";
            break;
        }
        return mime; 
    }

    /**
     * 预览图片地址
     *
     * @type {string}
     * @memberof AppImageUpload
     */
    public dialogImageUrl: string = '';

    /**
     * 是否显示预览界面
     *
     * @type {boolean}
     * @memberof AppImageUpload
     */
    public dialogVisible: boolean = false;

    /**
     * 是否支持多个上传
     *
     * @type {boolean}
     * @memberof AppImageUpload
     */
    @Prop({ default: true }) public multiple?: boolean;

    /**
     * 预览
     *
     * @param {*} file
     * @memberof AppImageUpload
     */
    public onPreview(file: any) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
    }

    /**
     * 处理多选超出
     *
     * @memberof AppImageUpload
     */
    public handleExceed(files: any, fileList: any) {
      this.$warning(`${this.$t('components.appfileupload.limitselect')} ${this.limit}`);
    }
}
</script>