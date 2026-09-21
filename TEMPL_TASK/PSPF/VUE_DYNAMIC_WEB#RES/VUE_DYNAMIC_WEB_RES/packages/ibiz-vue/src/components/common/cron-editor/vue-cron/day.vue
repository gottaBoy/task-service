<template>
    <div :val="value_">
        <div>
            <el-radio v-model="type" label="1" size="mini" border>{{ $t('components.croneditor.day.daily') }}</el-radio>
        </div>
        <div>
            <el-radio v-model="type" label="5" size="mini" border>{{
                $t('components.croneditor.public.notspecify')
            }}</el-radio>
        </div>
        <div>
            <el-radio v-model="type" label="2" size="mini" border>{{
                $t('components.croneditor.public.cycle')
            }}</el-radio>
            <span style="margin-left: 10px; margin-right: 5px">{{ $t('components.croneditor.public.from') }}</span>
            <el-input-number
                @change="type = '2'"
                v-model="cycle.start"
                :min="1"
                :max="31"
                size="mini"
                style="width: 100px"
            ></el-input-number>
            <span style="margin-left: 5px; margin-right: 5px">{{ $t('components.croneditor.public.to') }}</span>
            <el-input-number
                @change="type = '2'"
                v-model="cycle.end"
                :min="2"
                :max="31"
                size="mini"
                style="width: 100px"
            ></el-input-number>
            {{ $t('components.croneditor.day.title') }}
        </div>
        <div>
            <el-radio v-model="type" label="3" size="mini" border>{{
                $t('components.croneditor.public.loop')
            }}</el-radio>
            <span style="margin-left: 10px; margin-right: 5px">{{ $t('components.croneditor.public.from') }}</span>
            <el-input-number
                @change="type = '3'"
                v-model="loop.start"
                :min="1"
                :max="31"
                size="mini"
                style="width: 100px"
            ></el-input-number>
            <span style="margin-left: 5px; margin-right: 5px">{{ $t('components.croneditor.day.daystart') }}</span>
            <el-input-number
                @change="type = '3'"
                v-model="loop.end"
                :min="1"
                :max="31"
                size="mini"
                style="width: 100px"
            ></el-input-number>
            {{ $t('components.croneditor.day.onceaday') }}
        </div>
        <div>
            <el-radio v-model="type" label="8" size="mini" border>{{
                $t('components.croneditor.day.workday')
            }}</el-radio>
            <span style="margin-left: 10px; margin-right: 5px">{{ $t('components.croneditor.day.thismonth') }}</span>
            <el-input-number
                @change="type = '8'"
                v-model="work"
                :min="1"
                :max="7"
                size="mini"
                style="width: 100px"
            ></el-input-number>
            {{ $t('components.croneditor.day.lastworkday') }}
        </div>
        <div>
            <el-radio v-model="type" label="6" size="mini" border>{{
                $t('components.croneditor.day.lastdayofmonth')
            }}</el-radio>
        </div>
        <div>
            <el-radio v-model="type" label="4" size="mini" border>{{
                $t('components.croneditor.public.specify')
            }}</el-radio>
            <el-checkbox-group v-model="appoint">
                <div v-for="i in 4" :key="i" style="margin-left: 10px; line-height: 25px">
                    <template v-for="j in 10">
                        <el-checkbox
                            @change="type = '4'"
                            v-if="parseInt(i - 1 + '' + (j - 1)) < 32 && !(i === 1 && j === 1)"
                            :key="j"
                            :label="i - 1 + '' + (j - 1)"
                        ></el-checkbox>
                    </template>
                </div>
            </el-checkbox-group>
        </div>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Watch } from 'vue-property-decorator';

@Component({})
export default class Day extends Vue {
    /**
     * Cron表达式
     *
     * @type {any}
     * @memberof Day
     */
    @Prop() value: any;

    /**
     * 数据值变化
     *
     * @returns
     * @memberof Day
     */
    @Watch('value')
    public updateVal(newVal: string) {
        if (newVal) {
            if (newVal === '?') {
                this.type = '5';
                this.appoint = [];
            } else if (newVal.indexOf('-') !== -1) {
                // 2周期
                if (newVal.split('-').length === 2) {
                    this.type = '2';
                    this.cycle.start = newVal.split('-')[0];
                    this.cycle.end = newVal.split('-')[1];
                }
            } else if (newVal.indexOf('/') !== -1) {
                // 3循环
                if (newVal.split('/').length === 2) {
                    this.type = '3';
                    this.loop.start = newVal.split('/')[0];
                    this.loop.end = newVal.split('/')[1];
                }
            } else if (newVal.indexOf('*') !== -1) {
                // 1每
                this.type = '1';
            } else if (newVal.indexOf('L') !== -1) {
                // 6最后
                this.type = '6';
                this.last = Number(newVal.replace('L', ''));
            } else if (newVal.indexOf('#') !== -1) {
                // 7指定周
                if (newVal.split('#').length === 2) {
                    this.type = '7';
                    this.week.start = newVal.split('#')[0];
                    this.week.end = newVal.split('#')[1];
                }
            } else if (newVal.indexOf('W') !== -1) {
                // 8工作日
                this.type = '8';
                this.work = Number(newVal.replace('W', ''));
            } else {
                // *
                this.type = '4';
                this.appoint = newVal.split(',');
            }
        }
    }

    /**
     * 标签类型标识
     *
     * @type {any}
     * @memberof Day
     */
    public type: string = '5';

    /**
     * 周期
     *
     * @type {any}
     * @memberof Day
     */
    public cycle: any = {
        start: 0,
        end: 0,
    };

    /**
     * 循环
     *
     * @type {any}
     * @memberof Day
     */
    public loop: any = {
        start: 0,
        end: 0,
    };

    /**
     * 指定周
     *
     * @type {any}
     * @memberof Day
     */
    public week: any = {
        start: 0,
        end: 0,
    };

    /**
     * 工作日
     *
     * @type {any}
     * @memberof Day
     */
    public work: number = 0;

    /**
     * 最后
     *
     * @type {any}
     * @memberof Day
     */
    public last: number = 0;

    /**
     * 指定
     *
     * @type {any}
     * @memberof Day
     */
    public appoint: any = [];

    /**
     * 获取Cron表达式
     *
     * @returns
     * @memberof Day
     */
    get value_() {
        let result: any = [];
        switch (this.type) {
            case '1': // 每日
                result.push('*');
                this.appoint = [];
                break;
            case '2': // 周期
                result.push(`${this.cycle.start}-${this.cycle.end}`);
                this.appoint = [];
                break;
            case '3': // 循环
                result.push(`${this.loop.start}/${this.loop.end}`);
                this.appoint = [];
                break;
            case '4': // 指定
                if (this.appoint.length > 0) {
                    result.push(this.appoint.join(','));
                } else {
                    result.push('*');
                }
                break;
            case '6': // 最后
                result.push(`${this.last === 0 ? '' : this.last}L`);
                this.appoint = [];
                break;
            case '7': // 指定周
                result.push(`${this.week.start}#${this.week.end}`);
                this.appoint = [];
                break;
            case '8': // 工作日
                result.push(`${this.work}W`);
                this.appoint = [];
                break;
            default:
                // 不指定
                result.push('?');
                break;
        }
        const value: string = result.join('');
        this.$emit('input', value);
        if (!Object.is(value, '?')) {
            this.$emit('cronChange', value, 'dVal');
        }
        return value;
    }
}
</script>

<style lang="css">
.el-checkbox + .el-checkbox {
    margin-left: 10px;
}
</style>
