<template>
    <div class="app-lock-scren">
        <span><Icon type="md-lock" size="15" @click="handleLock"/></span>
        <span class="app-lock-scren__caption" @click="handleLock">{{$t('components.lockscren.lock')}}</span>
        <el-dialog :title="$t('components.lockscren.title')"
            :visible.sync="box"
            width="30%"
            custom-class="lockscren-body"
            append-to-body>
            <el-form :model="form"
                ref="form"
                label-width="82px">
                <el-form-item :label="$t('components.lockscren.label')"
                    prop="passwd"
                    :rules="[{ required: true, message: $t('components.lockscren.message')}]">
                    <el-input v-model="form.passwd"
                        :placeholder="$t('components.lockscren.placeholder')"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer">
                <el-button class="lock-scren-footer-btn" type="primary" @click="handleSetLock">{{$t('components.lockscren.confirmbuttontext')}}</el-button>
            </span>
        </el-dialog>
    </div>
</template>
<script lang = 'ts'>
import { getCookie } from 'qx-util';
import { Vue, Component, Prop, Model, Watch } from 'vue-property-decorator';

@Component({})
export default class AppLockScren extends Vue{
    
    /**
     * 对话框状态
     */
    public box: boolean = false;

    /**
     * 锁屏密码
     */
    public form: any = {passwd: ''};

    /**
     * 用户名
     */
    public user: any = {name: ''};

    /**
     * 点击锁屏图表展示对话框
     */
    public handleLock(){
        this.box = true;
    }

    /**
     * 锁屏确认
     */
    public handleSetLock(){
        (this.$refs["form"] as any).validate((valid: any )=> {
            if (valid) {
                const username = this.user.name == '' ? 'visitor' : this.user.name;
                const password = window.btoa(this.form.passwd);
                const routerPath = window.btoa(this.$route.path);
                sessionStorage.setItem('lockPassword',password);
                sessionStorage.setItem('lockState','true');
                sessionStorage.setItem('userName',username);
                sessionStorage.setItem('routerPath',routerPath);
                this.$router.push({ path: "/lock" });
            }
        });
    }

    /**
     * 获取当前用户名
     *
     * @memberof AppUser
     */
    public mounted() {
        let _user:any = {};
        if(this.$store.getters.getAppData() && this.$store.getters.getAppData().context && this.$store.getters.getAppData().context.srfusername){
            _user.name = this.$store.getters.getAppData().context.srfusername;
        }
        if(getCookie('ibzuaa-user')){
            let user:any = JSON.parse(getCookie('ibzuaa-user') as string);
            if(user && user.personname){
                _user.name = user.personname;
            }
        }
        Object.assign(this.user,_user);
    }
}

</script>