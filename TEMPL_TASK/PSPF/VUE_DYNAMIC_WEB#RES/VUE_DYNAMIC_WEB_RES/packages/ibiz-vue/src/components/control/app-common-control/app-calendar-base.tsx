import { Prop, Watch, Emit } from 'vue-property-decorator';
import { CalendarControlBase } from '../../../widgets/calendar-control-base';
import FullCalendar from '@fullcalendar/vue';
import { throttle, Util } from 'ibiz-core';
import { IPSSysCalendar, IPSSysCalendarItem } from '@ibiz/dynamic-model-api';

/**
 * 应用日历部件基类
 *
 * @export
 * @class AppCalendarBase
 * @extends {CalendarControlBase}
 */
export class AppCalendarBase extends CalendarControlBase {

    /**
     * 部件动态参数
     *
     * @memberof AppCalendarBase
     */
    @Prop() public declare dynamicProps: any;

    /**
     * 部件静态参数
     *
     * @memberof AppCalendarBase
     */
    @Prop() public declare staticProps: any;

    /**
     * 监听部件动态参数变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof AppCalendarBase
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
     * @memberof AppCalendarBase
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
     * @memberof AppCalendarBase
     */
    @Emit('ctrl-event')
    public ctrlEvent({ controlname, action, data }: { controlname: string; action: string; data: any }): void { }

    /**
     * 销毁视图回调
     *
     * @memberof AppCalendarBase
     */
    public destroyed() {
        this.ctrlDestroyed();
    }

    /**
     * TODO绘制日历项
     * 
     * @memberof AppCalendarBase
     */
    public renderCalendarItems(calendarItems: IPSSysCalendarItem[]) {
        return calendarItems.map((item: IPSSysCalendarItem) => {
            if (!item.itemType) {
                return null;
            }
            const itemClass = {
                "app-control-calendar__header__legend": true,
                [item.itemType]: true,
                "is-disabled": !this.isShowlegend[item.itemType]
            }
            return (
                <div class={itemClass} on-click={() => { throttle(this.legendTrigger, [item.itemType as string], this) }}>
                    <div class="lengend__icon" style={"background:" + item.bKColor}></div>
                    <span class="lengend__text" style={"color:" + item.color}>{item.name}</span>
                </div>
            );
        })
    }

    /**
     * 绘制日历内容
     * 
     * @memberof AppCalendarBase
     */
    public renderContent() {
        let _this: any = this;
        if (this.ctrlParams) {
            return (
                <app-calendar-timeline
                    ref="appCalendarTimeline"
                    ctrlParams={this.ctrlParams}
                    context={Util.deepCopy(this.context)}
                    viewparams={Util.deepCopy(this.viewparams)}
                    on-eventClick={(tempEvent: any) => {
                        throttle(this.onEventClick, [tempEvent, true], this);
                    }}
                    events={this.load}>
                </app-calendar-timeline>
            )
        }
        return ([
            <FullCalendar
                ref={_this.controlInstance?.codeName}
                locale={_this.$i18n?.locale}
                height="parent"
                firstDay={1}
                eventLimit={true}
                editable={!this.isSelectFirstDefault && true}
                buttonText={this.buttonText}
                header={this.header}
                plugins={this.calendarPlugins}
                events={this.load.bind(this)}
                customButtons={this.customButtons}
                validRange={this.validRange}
                defaultDate={this.defaultDate}
                eventRender={this.eventRender.bind(this)}
                navLinks={this.quickToolbarItems?.length > 0 ? true : false}
                navLinkDayClick={(...params: any[]) => throttle(this.onDayClick, params, this)}
                on-dateClick={(...params: any[]) => throttle(this.onDateClick, params, this)}
                on-eventClick={(...params: any[]) => throttle(this.onEventClick, params, this)}
                on-eventDrop={this.onEventDrop.bind(this)}
                defaultView={this.defaultView}
            >
            </FullCalendar>,
            <modal
                v-model={this.modalVisible}
                width="250px"
                title={this.$t('app.calendar.dateselectmodaltitle')}
                class-name="app-control-calendar__model"
                on-on-ok={() => this.gotoDate()} >
                <el-date-picker style="width: 200px" v-model={this.selectedGotoDate} type="date"></el-date-picker>
            </modal>
        ])
    }

    /**
     * 绘制数据项面板
     * 
     * @param item 数据项
     * @memberof AppCalendarBase
     */
    public renderItemPanel(item: any, calendarItem: any) {
        let { targetCtrlName, targetCtrlParam, targetCtrlEvent }: { targetCtrlName: string, targetCtrlParam: any, targetCtrlEvent: any } = this.computeTargetCtrlData(calendarItem.getPSLayoutPanel(), item);
        return this.$createElement(targetCtrlName, { props: targetCtrlParam, ref: item.id, on: targetCtrlEvent });
    }

    /**
     * 绘制数据项
     * 
     * @param item 数据项
     * @param index 下标
     * @memberof AppCalendarBase
     */
    public renderTimeLineItem(item: any, index: number) {
        const calendarItem = (this.controlInstance as IPSSysCalendar).getPSSysCalendarItems()?.find((_item: any) => {
            return item?.itemType == _item.itemType;
        });
        return (
            <el-timeline-item
                key={`${item.title}${index}`}
                class="timeline__item"
                color={item.color}
                timestamp={item.start}
                placement="top">
                <context-menu
                    contextMenuStyle={{ width: '100%', 'padding-right': '12px' }}
                    data={item}
                    renderContent={this.renderContextMenu.bind(this)}
                    on-showContext={(e: any) => {
                        this.showContext(item, e);
                    }}>
                    <el-card
                        nativeOn-click={() => { throttle(this.onTimeLineClick, [item], this) }}
                        class={{ ...item.className, 'is-active': item.srfchecked ? true : false }}>
                        {calendarItem && calendarItem.getPSLayoutPanel() ?
                            this.renderItemPanel(item, calendarItem) :
                            <div class="timeline__item__content">
                                <h4 class={item.content ? "content__title": "content__title__nodescription"}>{item.title}</h4>
                                <p class="content__description">{item.content}</p>
                            </div>}
                    </el-card>
                </context-menu>
            </el-timeline-item>
        );
    }

    /**
     * 绘制时间轴日历
     * 
     * @memberof AppCalendarBase
     */
    renderCalendarTimeLine() {
        return (
            <el-timeline class="app-control-calendar__content__timeline">
                {
                    this.events.length > 0 ? 
                        this.events.map((event: any, index: number) => {
                            return this.renderTimeLineItem(event, index);
                        }) : 
                        <div class="timeline__empty">
                            {this.renderEmptyDataTip()}
                            {this.renderQuickToolbar()}
                        </div>
                }
            </el-timeline>
        )
    }

    /**
     * 绘制日历
     * 
     * @memberof AppCalendarBase
     */
    renderCalendar() {
        return (
            <context-menu-container class="app-control-calendar__content__calendar">
                {this.renderContent()}
            </context-menu-container>
        )
    }

    /**
     * 绘制
     * 
     * @memberof AppCalendarBase
     */
    public render() {
        if (!this.controlIsLoaded || !this.controlInstance) {
            return null;
        }
        const { controlClassNames } = this.renderOptions;
        const calendarItems: Array<IPSSysCalendarItem> = (this.controlInstance as IPSSysCalendar).getPSSysCalendarItems() || [];
        return (
            <div class={{ ...controlClassNames, "app-control-calendar--select-first": this.isSelectFirstDefault }}>
                {
                    this.controlInstance.calendarStyle !== 'TIMELINE' &&
                    calendarItems.length > 1 &&
                    <div class="control-header app-control-calendar__header">
                        <div class="app-control-calendar__header__legends">
                            {this.renderCalendarItems(calendarItems)}
                        </div>
                    </div>
                }
                <div class="control-content app-control-calendar__content">
                    {
                        this.controlInstance.calendarStyle == 'TIMELINE' ?
                        this.renderCalendarTimeLine() :
                        this.renderCalendar()
                    }
                </div>
            </div>
        )
    }
}