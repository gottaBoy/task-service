/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.ISelectField
 *  net.ibizsys.paas.db.ISelectFilter
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
 *  net.ibizsys.paas.db.SelectFieldFilter
 *  net.ibizsys.paas.db.SelectGroupFilter
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.paasmgr.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.ISelectFilter;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
import net.ibizsys.paas.db.SelectFieldFilter;
import net.ibizsys.paas.db.SelectGroupFilter;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterServer;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterServerService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDSBooking;
import net.ibizsys.pscore.srv.paasmgr.service.PSDSBookingServiceBase;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDSBookingService
extends PSDSBookingServiceBase {
    private static final Log log = LogFactory.getLog(PSDSBookingService.class);

    @Override
    protected void onAfterCreate(PSDSBooking pSDSBooking) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)pSDSBooking.getPSDevCenterServerId()) && pSDSBooking.getBookingState() == 10) {
            this.updatePSDCDSReadyTime(pSDSBooking.getPSDevCenterServerId());
        }
        super.onAfterCreate(pSDSBooking);
    }

    @Override
    protected void onAfterUpdate(PSDSBooking pSDSBooking) throws Exception {
        if (pSDSBooking.isBookingStateDirty()) {
            PSDSBooking pSDSBooking2 = (PSDSBooking)this.getLast(pSDSBooking);
            this.updatePSDCDSReadyTime(pSDSBooking2.getPSDevCenterServerId());
        }
        super.onAfterUpdate(pSDSBooking);
    }

    @Override
    protected void onAfterRemove(PSDSBooking pSDSBooking) throws Exception {
        PSDSBooking pSDSBooking2 = (PSDSBooking)this.getLast(pSDSBooking);
        this.updatePSDCDSReadyTime(pSDSBooking2.getPSDevCenterServerId());
        super.onAfterRemove(pSDSBooking);
    }

    @Override
    protected boolean isPrepareLastForRemove() {
        return true;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected void updatePSDCDSReadyTime(String string) throws Exception {
        PSDevCenterServerService pSDevCenterServerService = (PSDevCenterServerService)ServiceGlobal.getService(PSDevCenterServerService.class, (SessionFactory)this.getSessionFactory());
        PSDevCenterServer pSDevCenterServer = new PSDevCenterServer();
        pSDevCenterServer.setPSDevCenterServerId(string);
        pSDevCenterServerService.get(pSDevCenterServer);
        switch (pSDevCenterServer.getResState()) {
            case 10: 
            case 20: 
            case 40: 
            case 41: 
            case 42: {
                SelectContext selectContext = new SelectContext();
                selectContext.setMaxRowCount(10);
                SelectField selectField = new SelectField();
                selectField.setName("BEGINTIME");
                selectContext.addSelectField((ISelectField)selectField);
                selectField = new SelectField();
                selectField.setName("ENDTIME");
                selectContext.addSelectField((ISelectField)selectField);
                selectContext.set("PSDEVCENTERSERVERID", (Object)string);
                SelectGroupFilter groupFilter = new SelectGroupFilter();
                groupFilter.setCondOp("AND");
                SelectFieldFilter fieldFilter = new SelectFieldFilter();
                fieldFilter.setDEFName("BEGINTIME");
                fieldFilter.setCondOp("GT");
                fieldFilter.setCondObjectValue((Object)new Timestamp(new Date().getTime()));
                groupFilter.getSelectFilterList(true).add(fieldFilter);
                fieldFilter = new SelectFieldFilter();
                fieldFilter.setDEFName("BOOKINGSTATE");
                fieldFilter.setCondOp("LT");
                fieldFilter.setCondObjectValue((Object)20);
                groupFilter.getSelectFilterList(true).add(fieldFilter);
                selectContext.setSelectFilter((ISelectFilter)groupFilter);
                selectContext.setOrderInfo(" ORDER BY BEGINTIME ASC");
                ArrayList<PSDSBooking> bookings = this.select((ISelectCond)selectContext);
                int n = pSDevCenterServer.getResState();
                pSDevCenterServer.reset();
                pSDevCenterServer.setPSDevCenterServerId(string);
                if (!bookings.isEmpty()) {
                    ArrayList<JSONObject> arrayList = new ArrayList<JSONObject>();
                    Iterator<PSDSBooking> iterator = bookings.iterator();
                    while (iterator.hasNext()) {
                        PSDSBooking pSDSBooking = iterator.next();
                        Timestamp timestamp = pSDSBooking.getBeginTime();
                        Timestamp timestamp2 = pSDSBooking.getEndTime();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("begintime", (Object)Long.toString(timestamp.getTime()));
                        jSONObject.put("endtime", (Object)Long.toString(timestamp2.getTime()));
                        String string2 = StringHelper.format((String)"%1$tY-%1$tm-%1$td", (Object)timestamp);
                        String string3 = StringHelper.format((String)"%1$tY-%1$tm-%1$td", (Object)timestamp2);
                        String string4 = null;
                        string4 = StringHelper.compare((String)string2, (String)string3, (boolean)true) == 0 ? StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM \u81f3  %2$tH:%2$tM", (Object)timestamp, (Object)timestamp2) : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM \u81f3 %2$tY-%2$tm-%2$td %2$tH:%2$tM", (Object)timestamp, (Object)timestamp2);
                        jSONObject.put("bkinfo", (Object)string4);
                        arrayList.add(jSONObject);
                    }
                    pSDevCenterServer.setResReadyTime(bookings.get(0).getBeginTime());
                    pSDevCenterServer.setPSDSBKLists(JSONArray.fromArray((Object[])arrayList.toArray()).toString());
                } else {
                    pSDevCenterServer.setResReadyTime(null);
                    pSDevCenterServer.setPSDSBKLists(null);
                }
                pSDevCenterServerService.update(pSDevCenterServer, true);
            }
        }
        if (pSDevCenterServer.getResState() == 20) {
            return;
        }
    }
}
