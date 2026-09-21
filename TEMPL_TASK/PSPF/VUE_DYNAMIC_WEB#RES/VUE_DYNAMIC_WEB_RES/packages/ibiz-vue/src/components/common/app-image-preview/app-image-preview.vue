<template>
  <div class='app-picture-preview'>
    <ul class="app-picture-preview__content">
      <li v-for="(file,index) in files" :key="index" class="app-picture-preview__content__item">
        <div>
          <el-image :src="file.dynaImgUrl">
              <div slot='error' class='item__img'>
                  <img src="@/assets/img/picture.png">
              </div>
          </el-image>
          <div class='item__action'>
              <span class='item__action__preview'>
                  <i class='el-icon-zoom-in' @click="onPreview(file)"></i>
              </span>
              <span class='item__action__download'>
                  <i class='el-icon-download' @click="onDownload(file)"></i>
              </span>
          </div>
        </div>
      </li>
    </ul>
    <!-- 预览 -->
    <modal v-model="dialogVisible" footer-hide width="auto" class-name='app-picture-preview__model'>
      <el-image :src="dialogImageUrl">
          <div slot='error' class='model__img'>
              <img src="@/assets/img/picture.png">
          </div>
      </el-image>
    </modal>
  </div>
</template>
<script lang = 'ts'>
import { Vue, Component, Prop, Watch, Provide } from 'vue-property-decorator';
import { Environment } from '@/environments/environment';
import { Subject, Subscription } from 'rxjs';
import { AppServiceBase, Http, ImgurlBase64 } from 'ibiz-core';

@Component({})
export default class AppImagePreview extends Vue {

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof AppImagePreview
     */
    @Prop() public formState?: Subject<any>


    /**
     * 表单状态事件
     *
     * @private
     * @type {(Subscription | undefined)}
     * @memberof AppImagePreview
     */
    private formStateEvent: Subscription | undefined;

    /**
     * 初始化值
     *
     * @type {*}
     * @memberof AppImagePreview
     */
    @Prop() public value?: any;

    /**
     * 数据值变化
     *
     * @param {*} newval
     * @param {*} val
     * @returns
     * @memberof AppImagePreview
     */
    @Watch('value')
    onValueChange(newval: any, val: any) {
        this.setFiles(newval)
    }

    /**
     * 所属表单项名称
     *
     * @type {string}
     * @memberof AppImagePreview
     */
    @Prop() public name!: string;

    /**
     * 上传文件路径
     *
     * @memberof AppImagePreview
     */
    public uploadUrl = Environment.BaseUrl + Environment.UploadFile;

    /**
     * 下载文件路径
     *
     * @memberof AppImagePreview
     */
    public downloadUrl = Environment.BaseUrl + Environment.ExportFile;

    /**
     * 文件列表
     *
     * @memberof AppImagePreview
     */
    @Provide() public files = [];

    /**
     * 设置files
     *
     * @private
     * @memberof AppImagePreview
     */
    private setFiles(value:any): void {
        let _files = JSON.parse(value);
        if (value && Object.prototype.toString.call(_files)=='[object Array]') {
            this.files = _files;
            this.files.forEach((file: any) => {
            let url = `${this.downloadUrl}/${file.id}`;
            ImgurlBase64.getInstance()
                .getImgURLOfBase64(url)
                .then((res: any) => {
                    file.dynaImgUrl = res;
                });            
            file.url = url;
        });
        } else {
            this.files = [];
        }
    }

    /**
     * vue 生命周期
     *
     * @memberof AppImagePreview
     */
    public created() {
        if (this.formState) {
            this.formStateEvent = this.formState.subscribe(($event: any) => {
                // 表单加载完成
                if (Object.is($event.type, 'load')) {
                    this.setFiles(this.value);
                }
            });
        }
    }

    /**
     * vue 生命周期
     *
     * @memberof AppImagePreview
     */
    public mounted() {
        this.setFiles(this.value);
    }

    /**
     * 组件销毁
     *
     * @memberof AppImagePreview
     */
    public destroyed(): void {
        if (this.formStateEvent) {
            this.formStateEvent.unsubscribe();
        }
    }

    /**
     * 下载文件
     *
     * @param {*} file
     * @memberof AppImagePreview
     */
    public onDownload(file: any) {
        let downloadUrl: string = file.url;
        const BaseUrl = AppServiceBase.getInstance().getAppEnvironment().BaseUrl;
        if (downloadUrl.startsWith(BaseUrl)) {
            downloadUrl = downloadUrl.replace(BaseUrl, '');
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
     * @memberof AppImagePreview
     */
    public dialogImageUrl: string = '';

    /**
     * 是否显示预览界面
     *
     * @type {boolean}
     * @memberof AppImagePreview
     */
    public dialogVisible: boolean = false;

    /**
     * 预览
     *
     * @param {*} file
     * @memberof AppImagePreview
     */
    public onPreview(file: any) {
        this.dialogImageUrl = file.dynaImgUrl;
        this.dialogVisible = true;
    }

}
</script>