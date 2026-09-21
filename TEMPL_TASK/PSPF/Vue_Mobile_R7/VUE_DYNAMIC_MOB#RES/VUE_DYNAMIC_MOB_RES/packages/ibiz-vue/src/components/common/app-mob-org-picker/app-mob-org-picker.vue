<template>
  <div class="app-mob-org-picker">
    <van-dropdown-menu class="app-mob-org-picker__dropdown" :overlay="false">
      <van-dropdown-item v-model="selectedOrgId" :options="selectedOrgArray">
        <van-cell v-if="selectedOrgArray.length < 1" title="暂无数据"></van-cell>
      </van-dropdown-item>
    </van-dropdown-menu>
  </div>
</template>
<script lang = 'ts'>
import { AppServiceBase, getSessionStorage, Http, setSessionStorage } from 'ibiz-core';
import { getCookie } from 'qx-util';
import { Vue, Component } from 'vue-property-decorator';

@Component({})
export default class AppMobOrgPicker extends Vue {
  /**
   * 选中组织部门id
   *
   * @type {string}
   * @memberof AppMobOrgPicker
   */
  public selectedOrgId: string = '';

  /**
   * 选中组织部门名称
   *
   * @type {string}
   * @memberof AppMobOrgPicker
   */
  public selectedOrgName: string = '';

  /**
   * 组织部门名称数组
   *
   * @type {Array<any>}
   * @memberof AppMobOrgPicker
   */
  public selectedOrgArray: Array<any> = [];

  /**
   * 是否为Sass模式
   *
   * @type {Array<any>}
   * @memberof AppMobOrgPicker
   */
  public isSaasMode: boolean = false;

  /**
   * 组件初始化数据，vue生命周期
   *
   * @memberof AppMobOrgPicker
   */
  public created() {
    let appEnvironment = AppServiceBase.getInstance().getAppEnvironment();
    this.isSaasMode = appEnvironment.SaaSMode;
    this.getOrgData();
  }

  /**
   * 选择组织部门回调
   *
   * @memberof AppMobOrgPicker
   */
  public orgSelect(data: string) {
    if (Object.is(data, this.selectedOrgId)) {
      return;
    }
    let item: any = this.selectedOrgArray.find((_item: any) => {
      return _item.srforgsectorid === data;
    });
    if (!this.isSaasMode) {
      this.switchDepartment(data)
        .then((response: any) => {
          if (response.status == 200) {
            if (item.srforgsectorid && item.srforgsectorname) {
              this.selectedOrgId = item.srforgsectorid;
              this.selectedOrgName = item.srforgsectorname;
            }
            this.updateStoreOrgData(item);
          } else {
            console.log('没有相关数据');
          }
        })
        .catch((error: any) => {
          console.log(error);
        });
    } else {
      let beforeActiveOrgData: any = this.selectedOrgArray.find((_item: any) => {
        return _item.srforgsectorid === this.selectedOrgId;
      });
      setSessionStorage('activeOrgData', item);
      if (item.srforgsectorid && item.srforgsectorname) {
        this.selectedOrgId = item.srforgsectorid;
        this.selectedOrgName = item.srforgsectorname;
      }
      window.location.href = window.location.origin;
    }
  }

  /**
   * 获取数据
   *
   * @memberof AppMobOrgPicker
   */
  public getOrgData() {
    let storeGetter = this.$store.getters;
    if (!this.isSaasMode) {
      if (storeGetter.getAppData()) {
        let _context = storeGetter.getAppData().context;
        let _srforgname = storeGetter.getAppData().context.srforgname;
        let _srforgsectorname = storeGetter.getAppData().context.srforgsectorname;
        if (_context && storeGetter.getAppData().context.srforgsectorid) {
          this.selectedOrgId = storeGetter.getAppData().context.srforgsectorid;
        } else {
          return false;
        }
        if (_context && _srforgname && _srforgsectorname) {
          this.selectedOrgName = _srforgname + '-' + _srforgsectorname;
        } else if (_context && _srforgname) {
          this.selectedOrgName = _srforgname;
        } else if (_context && _srforgsectorname) {
          this.selectedOrgName = _srforgsectorname;
        }
        if (storeGetter.getAppData().srforgsections) {
          this.selectedOrgArray = storeGetter.getAppData().srforgsections;
        }
      }
    } else {
      if (getSessionStorage('activeOrgData')) {
        this.selectedOrgName = getSessionStorage('activeOrgData')?.orgname;
        this.selectedOrgId = getSessionStorage('activeOrgData')?.orgid;
      }
      if (getSessionStorage('orgsData')) {
        this.selectedOrgArray = getSessionStorage('orgsData');
        if (this.selectedOrgArray?.length > 0) {
          this.selectedOrgArray.forEach((item: any) => {
            Object.assign(item, { srforgsectorid: item.orgid, srforgsectorname: item.orgname });
          });
        }
      }
    }
  }

  /**
   * 调用远端切换部门接口
   *
   * @memberof AppMobOrgPicker
   */
  public async switchDepartment(data: any) {
    return await Http.getInstance().post(`/oumaps/switch`, data, false);
  }

  /**
   * 重置应用数据
   *
   * @returns {Promise<boolean>} 是否通过
   * @memberof AuthGuard
   */
  public resetAppData(): Promise<boolean> {
    return new Promise((resolve: any, reject: any) => {
      const get: Promise<any> = Http.getInstance().get('/appdata');
      get
        .then((response: any) => {
          if (response && response.status === 200) {
            let { data }: { data: any } = response;
            if (data) {
              // token认证把用户信息放入应用级数据
              if (getCookie('ibzuaa-user')) {
                let user: any = JSON.parse(getCookie('ibzuaa-user') as string);
                let localAppData: any = {};
                if (user.sessionParams) {
                  localAppData = { context: user.sessionParams };
                  Object.assign(localAppData, data);
                }
                data = JSON.parse(JSON.stringify(localAppData));
              }
              if (localStorage.getItem('localdata')) {
                this.$store.commit('addLocalData', JSON.parse(localStorage.getItem('localdata') as string));
              }
              this.$store.commit('addAppData', data);
              // 提交权限数据
              this.$store.dispatch('authresource/commitAuthData', data);
              resolve(true);
            }
          }
        })
        .catch((error: any) => {
          resolve(false);
          console.log('没有相关数据');
        });
    });
  }

  /**
   * 更新仓库部门信息
   *
   * @memberof AppMobOrgPicker
   */
  public updateStoreOrgData(data: any) {
    let _appdata: any = this.$store.getters.getAppData();
    let _context: any = _appdata.context;
    Object.assign(_context, data);
    Object.assign(_appdata, { context: _context });
    this.$store.commit('updateAppData', _appdata);
  }
}
</script>