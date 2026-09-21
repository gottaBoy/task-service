import { Prop, Watch, Emit } from 'vue-property-decorator';
import { MobCalendarControlBase } from '../../../widgets/mob-calendar-control-base';
import { Util, ModelTool } from 'ibiz-core';
import { IPSSysCalendar, IPSSysCalendarItem } from '@ibiz/dynamic-model-api';

/**
 * 日历部件基类
 *
 * @export
 * @class AppMobCalendarBase
 * @extends {MobCalendarControlBase}
 */
export class AppMobCalendarBase extends MobCalendarControlBase {

    /**
     * 部件动态参数
     *
     * @memberof AppMobCalendarBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 部件静态参数
     *
     * @memberof AppMobCalendarBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听部件动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppMobCalendarBase
     */
    @Watch('dynamicProps', {
        immediate: true,
    })
    public onDynamicPropsChange(newVal: any, oldVal: any) {
        if (newVal && !Util.isFieldsSame(newVal, oldVal)) {
            super.onDynamicPropsChange(newVal, oldVal);
        }
    }

    /**
     * 监听部件静态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppMobCalendarBase
     */
    @Watch('staticProps', {
        immediate: true,
    })
    public onStaticPropsChange(newVal: any, oldVal: any) {
        if (newVal && !Util.isFieldsSame(newVal, oldVal)) {
            super.onStaticPropsChange(newVal, oldVal);
        }
    }

    /**
     * 部件事件
     *
     * @param {{ controlname: string; action: string; data: any }} { controlname 部件名称, action 事件名称, data 事件参数 }
     * @memberof AppMobCalendarBase
     */
    @Emit('ctrl-event')
    public ctrlEvent({ controlname, action, data }: { controlname: string; action: string; data: any }): void { }


    /**
     * 绘制日历样式----月
     *
     * @memberof AppMobCalendarBase
     */
    public renderMonthCalendar() {
        return <app-calendar
            ref="calendar2"
            class="app-control-calendar__header__calendar"
            on-prev={this.prev.bind(this)}
            on-next={this.next.bind(this)}
            value={this.calendarParam.value}
            markDate={this.calendarParam.markDate}
            responsive={true}
            isChangeStyle={true}
            illustration={this.calendarParam.illustration}
            on-select={this.clickDay.bind(this)}
            on-selectYear={this.selectYear.bind(this)}
            on-selectMonth={this.selectMonth.bind(this)}
            sign={this.calendarParam.sign}
            events={this.calendarParam.eventsDate}
            tileContent={this.calendarParam.tileContent} />
    }

    /**
     * 绘制日历样式----天
     *
     * @memberof AppMobCalendarBase
     */
    public renderDayCalendar() {
        return <div class="app-control-calendar__header__calendar app-control-calendar__header__daycalendar">
            <div class="calendar__prev" on-click={this.prevDate}><app-mob-icon name="chevron-back-outline"></app-mob-icon></div>
            <div class="calendar__next" on-click={this.nextDate}><app-mob-icon name="chevron-forward-outline"></app-mob-icon></div>
            <div class="calendar__info">
                {`${this.dateParam.year}年${this.dateParam.month + 1}月${this.dateParam.day}日`}
            </div>
        </div>
    }

    /**
     * 绘制日历样式----周
     *
     * @memberof AppMobCalendarBase
     */
    public renderWeekCalendar() {
        return <app-calendar
            ref="calendar2"
            class="app-control-calendar__header__calendar"
            weekSwitch={true}
            value={this.calendarParam.value}
            on-prev={this.prev.bind(this)}
            on-next={this.next.bind(this)}
            markDate={this.calendarParam.markDate}
            illustration={this.calendarParam.illustration}
            responsive={true}
            on-select={this.clickDay.bind(this)}
            sign={this.calendarParam.sign}
            on-selectYear={this.selectYear.bind(this)}
            on-selectMonth={this.selectMonth.bind(this)}
            tileContent={this.calendarParam.tileContent} />
    }


    /**
     * 输出分页头部
     *
     * @memberof AppMobCalendarBase
     */
    public renderSegment(calendarItems: IPSSysCalendarItem[]) {
        return <ion-toolbar class="app-control-calendar__content__toolbar">
                <ion-segment class="toolbar__segment" scrollable={true} value={this.activeItem} on-ionChange={this.segmentChange.bind(this)}>
                {calendarItems.map((calendarItem: IPSSysCalendarItem) => {
                    return <ion-segment-button class="toolbar__segment__item" value={calendarItem?.itemType?.toLowerCase()}>
                        <ion-label>{calendarItem.name}</ion-label>
                    </ion-segment-button>
                })}
            </ion-segment>
        </ion-toolbar>
    }

    /**
     * 绘制日历样式----时间轴
     *
     * @memberof AppMobCalendarBase
     */
    public renderTimelineCalendar(calendarStyle: any) {
        switch (calendarStyle) {
            case 'TIMELINE':
                return this.renderTimeline()
            case 'MONTH_TIMELINE':
            case 'WEEK_TIMELINE':
                return this.renderWMTimeline()
            default:
                return this.renderDataList()
        }

    }


    /**
     * 绘制时间轴
     *
     * @memberof AppMobCalendarBase
     */
    public renderTimeline() {
        return <van-steps active-icon="passed" inactive-icon="passed" direction="vertical">
            {this.count.map((i: any) => {
                return <van-step>
                    <p>{`${this.dateParam.year}-${this.dateParam.month + 1}-${i}`}</p>
                    {this.calendarParam.sign.map((it: any) => {
                        if (it.time == this.dateParam.year + '-' + (this.dateParam.month + 1) + '-' + i || it.time == this.dateParam.year + '-' + '0' + (this.dateParam.month + 1) + '-' + i) {
                            return <div class="even-box">
                                {it.evens.map((item: any) => {
                                    return [this.renderEventContent(item),
                                    <app-mob-icon on-onClick={() => this.remove([item])} class="event-delete right-common-icon" name="close-outline"></app-mob-icon>
                                    ]
                                })}
                            </div>
                        }
                    })}
                </van-step>
            })}
        </van-steps>
    }

    /**
     * 绘制月-周时间轴
     *
     * @memberof AppMobCalendarBase
     */
    public renderWMTimeline() {
        return <van-steps active-icon="passed" inactive-icon="passed" direction="vertical">
            {this.calendarParam.sign.map((i: any) => {
                return <van-step>
                    <p>{i.time}</p>
                    {i.evens.map((item: any) => {
                        return <div class="touch">
                            {this.isChoose && <ion-checkbox class="touch-checkbox" on-click={() => this.checkboxSelect(item)}></ion-checkbox>}
                            <div class="even-box">
                                {this.renderEventContent(item)}
                                {!this.isChoose && <app-mob-icon on-onClick={() => this.remove([item])} class="event-delete right-common-icon" name="close-outline"></app-mob-icon>}
                            </div>
                        </div>
                    })}
                </van-step>
            })}
        </van-steps>
    }

    /**
     * 绘制事件内容
     *
     * @memberof AppMobCalendarBase
     */
    public renderEventContent(item: any) {
        const calendarItems = (this.controlInstance as IPSSysCalendar).getPSSysCalendarItems() || [];
        const appDataEntity = this.controlInstance.getPSAppDataEntity();
        const renderTempJSX = (calendarItem: IPSSysCalendarItem) => {
            if (calendarItem.getTextPSAppDEField()) {
                return <div class="evenname">{item['title']}</div>
            } else if (calendarItem.getContentPSAppDEField()) {
                return <div class="evenname">{item[calendarItem?.getContentPSAppDEField()?.name?.toLowerCase() as string]}</div>
            } else if (calendarItem.getIconPSAppDEField()) {
                return <div class="evenname">{item[calendarItem?.getIconPSAppDEField()?.name?.toLowerCase() as string]}</div>
            } else {
                const majorField = ModelTool.getAppEntityMajorField(appDataEntity);
                return <div class="evenname">{majorField ? majorField?.codeName?.toLowerCase() : ''}</div>
            }
        }
        return calendarItems.map((calendarItem: IPSSysCalendarItem) => {
            if (this.activeItem == calendarItem.itemType.toLowerCase()) {
                return <div on-click={() => this.onEventClick(item)}>
                    {renderTempJSX(calendarItem)}
                </div>
            }
        })
    }

    /**
     * 绘制分页底部内容
     *
     * @memberof AppMobCalendarBase
     */
    public renderDataList() {
        let arr = this.calendarItems[this.activeItem];
        const content = <ion-list>
            {arr && arr.map((item: any) => {
                return <ion-item class="datalist__item" on-click={() => this.onEventClick(item)}>
                    <ion-label class="datalist__text">{item.title}</ion-label>
                </ion-item>
            })}
        </ion-list>
        return <div class="app-control-calendar__content__datalist">{content}</div>
    }

    /**
     * 绘制
     * 
     * @memberof AppMobCalendarBase
     */
    public render() {
        if (!this.controlIsLoaded) {
            return null;
        }
        const { controlClassNames } = this.renderOptions;
        const { calendarStyle } = this.controlInstance;
        const calendarItems = (this.controlInstance as IPSSysCalendar).getPSSysCalendarItems() || [];
        return (
            this.show && <div class={controlClassNames} >
                <div class='control-header app-control-calendar__header'>
                    {(calendarStyle == "MONTH" || calendarStyle == 'MONTH_TIMELINE') ? this.renderMonthCalendar() : null}
                    {calendarStyle == "DAY" ? this.renderDayCalendar() : null}
                    {(calendarStyle == "WEEK" || calendarStyle == 'WEEK_TIMELINE') ? this.renderWeekCalendar() : null}
                </div>
                <div class='control-content app-control-calendar__content'>
                    {calendarItems ? this.renderSegment(calendarItems) : null}
                    {this.renderTimelineCalendar(calendarStyle)}
                </div>
            </div>
        );
    }
}