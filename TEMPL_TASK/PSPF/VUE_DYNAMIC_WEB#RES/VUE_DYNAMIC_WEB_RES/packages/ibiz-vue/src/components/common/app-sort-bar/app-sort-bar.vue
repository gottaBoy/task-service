<template>
    <div :class="['app-sort-bar', isSort ? 'app-sort-bar--visible' : 'app-sort-bar--hidden']">
        <row v-if="sortModel && sortModel.length>0" class="app-sort-bar__content" :gutter="60" type="flex" justify="start">
            <template v-for="(item, index) in sortModel">
                <i-col v-show="isSort" :key="index" :class="getSortClass(item)">
                    <div @click="sortItemClick(item)" class="sort__item_content">
                        <span class="item__caption">{{item.caption}}</span>
                        <span class="item__icon">
                            <Icon type="md-arrow-dropup" />
                            <Icon type="md-arrow-dropdown" />
                        </span>
                    </div>
                </i-col>
            </template>
        </row>
    </div>
</template>

<script lang='ts'>
import { Component, Vue, Prop } from "vue-property-decorator";

@Component({})
export default class AppSortBar extends Vue {
    
    @Prop() public sortModel!: any[];

    @Prop() public sortField!: any;

    @Prop() public sortDir!: any;

    @Prop() public entityName!: string;

    public isSort: boolean = true;

    public getSortClass(item: any) {
        if(this.sortField !== item.codeName || this.sortDir === ''){
            return 'sort__item';
        }else if(this.sortDir === 'asc'){
            return 'sort__item sort__item--ascending is-active'
        }else if(this.sortDir === 'desc'){
            return 'sort__item sort__item--descending is-active'
        }
    }

    public sortItemClick(item: any) {
        this.$emit('clickSort', item.codeName);
    }

    public handleSort() {
        this.isSort = !this.isSort;
    }
}
</script>