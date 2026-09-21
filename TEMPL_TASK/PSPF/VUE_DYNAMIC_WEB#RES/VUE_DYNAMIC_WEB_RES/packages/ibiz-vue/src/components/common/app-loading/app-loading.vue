<template>
  <div class="el-loading-mask app-loading">
    <div class="app-loading__icon">
        <div class="app-loading__icon__content">
            <div class="content__item is-active"></div>
            <div class="content__item"></div>
        </div>
        <div class="app-loading__icon__content">
            <div class="content__item"></div>
            <div class="content__item"></div>
        </div>
    </div>
  </div>
</template>
<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';

@Component({})
export default class AppLoading extends Vue {}
</script>
