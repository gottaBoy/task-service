<template>
    <div class="app-map-picker">
        <el-input
            size="small"
            @focus="handleMapShow"
            @blur="handleBlur"
            v-model="value"
            :placeholder="placeholder ? placeholder : $t('components.appmappicker.title')">
        </el-input>
        <el-dialog
            :title="$t('components.appmappicker.title')"
            class="map-modal"
            :visible.sync="dialogShow">
            <div class="search-toolbar">
                <el-input id="map__search" size="small" @change="handleSearch" v-model="searchAddress" />
                <div id="map__result" class="content-result" v-show="resultShow"></div>
            </div>
            <div class="map__content">
                <el-amap
                    :center="center" 
                    :amap-manager="amapManager"
                    zoom="12"
                    :events="events"
                    ref="map">
                    <el-amap-marker
                        class="map-marker"
                        vid="component-marker"
                        :position="marker.position">
                        <div>
                            <img src="//a.amap.com/jsapi_demos/static/demo-center/icons/poi-marker-default.png">
                            <span class="input-map__marker">{{ marker.address }}</span>
                        </div>
                    </el-amap-marker>
                </el-amap>
                
            </div>
            <template slot="footer">
                <el-button
                    type="primary"
                    size="small"
                    @click="handleSubmit">
                    {{ $t('components.appmappicker.submit') }}
                </el-button>
            </template>
        </el-dialog>
    </div>
</template>

<script lang='tsx'>
import { Vue, Component, Prop, Model, Emit } from 'vue-property-decorator';
import { Subject, Subscription } from 'rxjs';
import { AMapManager } from 'vue-amap';
import { LogUtil } from 'ibiz-core';

@Component({})
export default class AppMapPicker extends Vue  {
    
    /**
     * 双向绑定表单项值
     *
     * @type {*}
     * @memberof AppMapPicker
     */  
    @Model('change') public value: any;

    /**
     * 名称
     *
     * @type {string}
     * @memberof AppMapPicker
     */ 
    @Prop() public name!: string;

    /**
     * 占位内容
     *
     * @type {*}
     * @memberof AppMapPicker
     */ 
    @Prop() public placeholder?: string;

    /**
     * 值项
     *
     * @type {string}
     * @memberof AppMapPicker
     */ 
    @Prop() public valueItemNames?: string;

    /**
     * 表单数据
     *
     * @type {*}
     * @memberof AppMapPicker
     */
    @Prop() public data: any;

    /**
     * 表单通讯对象
     *
     * @type {*}
     * @memberof AppMapPicker
     */
    @Prop() public formState!: Subject<any>;

    /**
     * 输入框失焦
     * @param e
     */
    public handleBlur(e: any): void {
        this.$emit('blur', this.value);
    }

    /**
     * 输入框聚焦
     * @param e
     */
    public handleFocus(e: any): void {
        this.$emit('focus', this.value);
    }

    /**
     * 获取经度
     *
     * @type {*}
     * @memberof AppMapPicker
     */
    get longitude() {
        if (this.valueItemNames) {
            return this.valueItemNames.split(',')[0];
        }
    }

    /**
     * 获取纬度
     *
     * @type {*}
     * @memberof AppMapPicker
     */
    get latitude() {
        if (this.valueItemNames) {
            return this.valueItemNames.split(',')[1];
        }
    }

    /**
     * 搜索框显示值
     *
     * @type {*}
     * @memberof AppMapPicker
     */
    public searchAddress: string = '';

    /**
     * AMap SDK对象
     *
     * @type {*}
     * @memberof AppMapPicker
     */
    public amapManager: any = new AMapManager();

    /**
     * 地图中心点
     *
     * @type {*}
     * @memberof AppMapPicker
     */
    public center: any[] = [104.09427199999999, 30.660396];

    /**
     * 地图模态框显示状态
     *
     * @type {*}
     * @memberof AppMapPicker
     */
    public dialogShow: boolean = false;

    /**
     * 地图标点信息
     *
     * @type {*}
     * @memberof AppMapPicker
     */
    public marker: any = {};

    /**
     * 初始化地图标点
     *
     * @type {*}
     * @memberof AppMapPicker
     */
    public markerResult: any = {};

    /**
     * 事件集合
     *
     * @type {*}
     * @memberof AppMapPicker
     */
    public events: any = {};

    /**
     * 获取地址需求AMap插件对象
     *
     * @type {*}
     * @memberof AppMapPicker
     */
    public geocoder: any;

    /**
     * 当前 window
     *
     * @type {*}
     * @memberof AppMapPicker
     */
    public win: any;

    /**
     * 搜索结果显示框状态
     *
     * @type {*}
     * @memberof AppMapPicker
     */
    public resultShow: boolean = false;

    /**
     * 表单状态事件
     *
     * @private
     * @type {(Subscription | undefined)}
     * @memberof AppImagePreview
     */
    private formStateEvent: Subscription | undefined;

    /**
     * Vue生命周期
     *
     * @memberof AppMapPicker
     */
    public created() {
        this.win = window as any;
        if(this.formState) {
            this.formStateEvent = this.formState.subscribe(({ type, data }) => {
                if(Object.is('load', type)) {
                    this.initMap();
                }
            })
        }
    }

    /**
     * Vue生命周期
     *
     * @memberof AppMapPicker
     */
    public mounted() {
        let amap: any = this.win.AMap;
        amap.plugin(["AMap.Geocoder"], () => {
            this.geocoder = new amap.Geocoder({
                extensions: "all",
            })
        })
        this.initlocation();
        this.initMapEvents();
    }

    /**
     * 获取城市定位
     *
     * @memberof AppMapPicker
     */
    public  initlocation(){
        let amap: any = this.win.AMap;
        amap.plugin(["AMap.Geolocation"], () => {
            const geolocation = new amap.Geolocation({
                enableHighAccuracy:true,
                timeout:10000,
                buttonOffset:new amap.Pixel(10,20),
                zoomToAccuracy:true
            })
            geolocation.getCityInfo((status:string,result:any)=>{
                if(status === 'complete'){
                    this.center = result.center;
                }else{
                    console.warn('获取城市定位信息失败：',result)
                }
            })
        })
    }

    /**
     * @description: 组件销毁
     * 
     * @return {*}
     */    
    public destroyed(){
        if (this.formStateEvent) {
            this.formStateEvent.unsubscribe();
        }
    }

    /**
     * 根据当前模式初始化地图
     *
     * @memberof AppMapPicker
     */
    public initMap() {
        this.initByAddress();
    }

    /**
     * mode = address，初始化地图
     *
     * @memberof AppMapPicker
     */
    public initByAddress() {
        if(this.longitude && this.latitude && this.data && this.value) {
            const position = [this.data[this.longitude], this.data[this.latitude]];
            Object.assign(this.marker, {
                position: position,
                address: this.value,
                visible: true
            });
            this.center = position;
            this.searchAddress = this.marker.address;
            Object.assign(this.markerResult, this.marker);
        } else {
            Object.assign(this.marker, {
                position: this.center,
                address: "",
                visible: true
            })
            this.searchAddress = this.marker.address;
        }
    }

    /**
     * 初始化地图事件
     *
     * @memberof AppMapPicker
     */
    public initMapEvents() {
        const that: any = this;
        that.events = {
            click($event: any) {
                that.mapClick($event);
            },
            init($event: any) {
                that.map = $event;
            }
        };
    }

    /**
     * 展开模态框
     *
     * @memberof AppMapPicker
     */
    public handleMapShow($event: any) {
        this.handleFocus($event);
        this.resultShow = false;
        this.dialogShow = true;
        if(!this.markerResult || JSON.stringify(this.markerResult) == "{}") {
            return;
        }
        this.searchAddress = this.markerResult.address;
        Object.assign(this.marker, this.markerResult);
        this.center = this.markerResult.position;
    }
    
    /**
     * 处理地图标点
     * 
     * @param {*} lng 经度
     * @param {*} lat 纬度
     * @param {*} that this指针
     * @param {boolean} flag 是否更新结果集
     * @memberof AppMapPicker
     */
    public async handleMarker(lng: any, lat: any, that: any, flag: boolean = true) {
        const address = await this.getAddress(lng, lat).catch((error) => {
            LogUtil.warn(error);
        });
        if(!address) {
            return;
        }
        Object.assign(that.marker, { position: [lng, lat], address: address, visible: true });
        that.searchAddress = address;
        that.center = [lng, lat];
        if(flag) {
            Object.assign(this.markerResult, this.marker);
        }
    }

    /**
     * 搜索地址
     * 
     * @memberof AppMapPicker
     */
    public handleSearch() {
        const that = this;
        let placeSearch: any;
        //  调用服务搜索结果
        that.win.AMap.service(["AMap.PlaceSearch"], () => {
            placeSearch = new this.win.AMap.PlaceSearch({
                pageSize: 5,
                city: this.$t('components.appmappicker.city'),
                citylimit: false,
                panel: 'map__result',
            })
            placeSearch.search(that.searchAddress, (status: any, result: any) => {
                if (status == 'complete' && result.info == 'OK') {
                    this.resultShow = true;
                    if(result.poiList.pois) {
                        that.handleMarker(result.poiList.pois[0].location.R, result.poiList.pois[0].location.Q, that, false);
                    }
                }
            })
        })
        //  监听搜索结果列表点击事件
        that.win.AMap.event.addListener(placeSearch,"listElementClick", (e: any) => {
            if(e.data.location) {
                that.handleMarker(e.data.location.R, e.data.location.Q, that, false);
            }
        })
    }

    /**
     * 地图点击事件
     * 
     * @memberof AppMapPicker
     */
    public mapClick($event: any) {
        if(!$event && !$event.lnglat) {
            return;
        }
        const that = this;
        that.handleMarker($event.lnglat.lng, $event.lnglat.lat, that, false);
    }

    /**
     * 调用服务，根据经纬度获取地址信息
     * 
     * @param {*} lng 经度
     * @param {*} lat 纬度
     * @memberof AppMapPicker
     */
    public getAddress(lng: any, lat: any) {
        return new Promise((resolve, reject) => {
            this.geocoder.getAddress([lng,lat],(status:any,result: any) => {
                if (status === 'complete' && result.info === 'OK') {
                    if (result && result.regeocode) {
                        const address = result.regeocode.formattedAddress;
                        resolve(address);
                    }
                }
            })
        })
    }

    /**
     * 点击模态确认按钮，提交数据
     * 
     * @memberof AppMapPicker
     */
    public handleSubmit() {
        this.dialogShow = false;
        Object.assign(this.markerResult, this.marker);
        if(!this.markerResult) {
            return;
        }
        this.$emit('change', this.markerResult.address);
        if (this.longitude) {
            this.$emit('itemChange', { name: this.longitude, value: this.markerResult.position[0].toString() });
        }
        if (this.latitude) {
            this.$emit('itemChange', { name: this.latitude, value: this.markerResult.position[1].toString() });
        }
    }

}
</script>