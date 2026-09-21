<template>
    <div class="app-view-cache" id="app-view-cache">
        <component
            v-for="item in viewCacheService.viewCache"
            :key="item.fullPath"
            :is="'app-view-shell'"
            :staticProps="{
                viewDefaultUsage: false,
                viewModelData: item.appView,
            }"
            v-show="viewCacheService.activeViewCache === item.fullPath"
        ></component>
    </div>
</template>
<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';
import { ViewCache, ViewCacheService } from 'ibiz-vue';

@Component({})
export default class appViewCache extends Vue {
    
    /** 
     * 视图缓存服务
     * 
     */
    public viewCacheService: ViewCache = ViewCacheService;
}
</script>