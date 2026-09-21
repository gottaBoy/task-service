/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import java.sql.Timestamp;
import net.ibizsys.paas.ctrlhandler.ICalendarItemFetchContext;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;

public class CalendarItemFetchContext
implements ICalendarItemFetchContext {
    private Timestamp beginTime = null;
    private Timestamp endTime = null;

    public CalendarItemFetchContext() {
    }

    public CalendarItemFetchContext(ICalendarItemFetchContext iCalendarItemFetchContext) {
        this.beginTime = iCalendarItemFetchContext.getBeginTime();
        this.endTime = iCalendarItemFetchContext.getEndTime();
    }

    public CalendarItemFetchContext(IWebContext iWebContext) throws Exception {
        String strEndTime;
        String strBeginTime = iWebContext.getPostValue("srfbegintime");
        if (!StringHelper.isNullOrEmpty(strBeginTime)) {
            this.beginTime = new Timestamp(DateHelper.parse(strBeginTime).getTime());
        }
        if (!StringHelper.isNullOrEmpty(strEndTime = iWebContext.getPostValue("srfendtime"))) {
            this.endTime = new Timestamp(DateHelper.parse(strEndTime).getTime());
        }
    }

    @Override
    public Timestamp getBeginTime() {
        return this.beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    @Override
    public Timestamp getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }
}

