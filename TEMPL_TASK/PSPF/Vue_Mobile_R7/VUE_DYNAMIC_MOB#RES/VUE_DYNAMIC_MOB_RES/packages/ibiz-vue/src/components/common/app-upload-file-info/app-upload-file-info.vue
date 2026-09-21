<template>
  <div class="app-upload-file-info">
      <a class="app-upload-file-info__item" v-for="(file,index) in files" @click="() => onDownload(file)" :key="index">{{file.name}}</a>
  </div>
</template>

<script lang="ts">
import { Component, Vue, Prop, Watch } from 'vue-property-decorator';
import { AppServiceBase, Http } from 'ibiz-core';

@Component({
})
export default class AppUploadFileInfo extends Vue {

    /**
     * 初始化值
     *
     * @type {*}
     * @memberof AppUploadFileInfo
     */
    @Prop() public value?: any;

    /**
     * 数据值变化
     *
     * @param {*} newval
     * @param {*} val
     * @memberof AppUploadFileInfo
     */
    @Watch('value')
    onValueChange(newval: any, val: any) {
        this.dataProcess();
    }

    /**
     * 所属表单项名称
     *
     * @type {string}
     * @memberof AppUploadFileInfo
     */
    @Prop() public name!: string;

    /**
     * 上传文件路径
     *
     * @memberof AppUploadFileInfo
     */
    public uploadUrl = AppServiceBase.getInstance().getAppEnvironment().BaseUrl + AppServiceBase.getInstance().getAppEnvironment().UploadFile;

    /**
     * 下载文件路径
     *
     * @memberof AppUploadFileInfo
     */
    public downloadUrl = AppServiceBase.getInstance().getAppEnvironment().BaseUrl + AppServiceBase.getInstance().getAppEnvironment().ExportFile;

    /**
     * 文件列表
     *
     * @memberof AppUploadFileInfo
     */
    public files:any = [];

    /**
     * 数据处理
     *
     * @private
     * @memberof AppUploadFileInfo
     */
    private dataProcess(): void {
        if(this.value){
            let files = JSON.parse(this.value);
            if(files.length){
                files.forEach((file: any) => {
                    let url = `${this.downloadUrl}/${file.id}`;
                    file.url = url;
                });
            }else{
              files = []
            }
            this.files =files;
        }
    }

    /**
     * vue 生命周期
     *
     * @memberof AppUploadFileInfo
     */
    public created() {
        this.dataProcess();
    }


    /**
     * 下载文件
     *
     * @param {*} file
     * @memberof AppUploadFileInfo
     */
    public onDownload(file: any) {
        this.DownloadFile(file.url, file);
    }

    /**
     * 下载文件
     *
     * @param item AppMobFileList
     * @memberof AppUploadFileInfo
     */
    public DownloadFile(url: string,file: any) {
        // 发送get请求
        Http.getHttp()({
            method: 'get',
            url: url,
            responseType: 'blob'
        }).then((response: any) => {
            if (!response || response.status != 200) {
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
                this.$Notice.error(response)
            }
        }).catch((error: any) => {
            console.error(error);
        });
    }

    /**
     * 计算文件mime类型
     *
     * @param filetype 文件后缀
     * @memberof AppUploadFileInfo
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

}
</script>