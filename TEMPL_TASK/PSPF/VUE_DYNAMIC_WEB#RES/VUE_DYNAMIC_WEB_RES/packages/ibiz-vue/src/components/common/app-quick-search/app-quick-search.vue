<template>
    <i-input 
        class='app-quick-search' 
        search 
        @on-search="onSearch($event)"
        v-model="value" 
        :placeholder="placeholder" />
</template>

<script lang="ts">
import { IPSAppDataEntity, IPSAppDEField } from '@ibiz/dynamic-model-api';
import { Vue, Component, Prop, Model } from 'vue-property-decorator';

@Component({})
export default class AppQuickSearch extends Vue {
    /**
     * 应用实体
     *
     * @type {IPSAppDataEntity}
     * @memberof AppQuickSearch
     */
    @Prop() public appDataEntity?: IPSAppDataEntity;

    /**
     * 搜索框值
     * 
     * @memberof AppQuickSearch
     */
    @Model('valueChange', { type: String }) publicValue!: string;

    /**
     * 搜索框值
     * 
     * @memberof AppQuickSearch
     */
    get value():string {
        return this.publicValue;
    }

    /**
     * 设置搜索框值
     * 
     * @memberof AppQuickSearch
     */
    set value(value: string) {
        this.$emit('valueChange', value)
    }

    /**
     *  快速搜索栏空白填充内容
     *
     * @memberof AppQuickSearch
     */
    get placeholder (): string {
        let placeholder = '';
        let _this: any = this;
        const quickSearchFields: Array<IPSAppDEField> = this.appDataEntity?.getQuickSearchPSAppDEFields() || [];
        if (quickSearchFields.length > 0) {
            quickSearchFields.forEach((field: IPSAppDEField, index: number) => {
                const _field: IPSAppDEField | null | undefined = this.appDataEntity?.findPSAppDEField(field.codeName);
                if (_field) {
                    if(_field.quickSearchPlaceHolder){
                        placeholder += (this.$tl(_field.getQSPHPSLanguageRes()?.lanResTag, _field.quickSearchPlaceHolder) + (index === quickSearchFields.length - 1 ? '' : ', '));
                    }else{
                        placeholder += (_this.$tl(_field.getLNPSLanguageRes()?.lanResTag, _field.logicName) + (index === quickSearchFields.length - 1 ? '' : ', '));
                    }
                }
            })
        }
        return placeholder;
    }

    /**
     * 搜索事件
     *
     * @memberof AppQuickSearch
     */
    public onSearch(value: any) {
        this.$emit('search', value);
    }
}
</script>
