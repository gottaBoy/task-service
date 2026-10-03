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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterAS;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSASBooking;
import net.ibizsys.pscore.srv.paasmgr.service.PSASBookingServiceBase;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSASBookingService
extends PSASBookingServiceBase {
    private static final Log log = LogFactory.getLog(PSASBookingService.class);

    @Override
    protected void onAfterCreate(PSASBooking pSASBooking) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)pSASBooking.getPSDevCenterASId()) && pSASBooking.getBookingState() == 10) {
            this.updatePSDCASReadyTime(pSASBooking.getPSDevCenterASId());
        }
        super.onAfterCreate(pSASBooking);
    }

    @Override
    protected void onAfterUpdate(PSASBooking pSASBooking) throws Exception {
        if (pSASBooking.isBookingStateDirty()) {
            PSASBooking pSASBooking2 = (PSASBooking)this.getLast(pSASBooking);
            this.updatePSDCASReadyTime(pSASBooking2.getPSDevCenterASId());
        }
        super.onAfterUpdate(pSASBooking);
    }

    @Override
    protected void onAfterRemove(PSASBooking pSASBooking) throws Exception {
        PSASBooking pSASBooking2 = (PSASBooking)this.getLast(pSASBooking);
        this.updatePSDCASReadyTime(pSASBooking2.getPSDevCenterASId());
        super.onAfterRemove(pSASBooking);
    }

    @Override
    protected boolean isPrepareLastForRemove() {
        return true;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected void updatePSDCASReadyTime(String string) throws Exception {
        PSDevCenterASService pSDevCenterASService = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)this.getSessionFactory());
        PSDevCenterAS pSDevCenterAS = new PSDevCenterAS();
        pSDevCenterAS.setPSDevCenterASId(string);
        pSDevCenterASService.get(pSDevCenterAS);
        switch (pSDevCenterAS.getResState()) {
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
                selectContext.set("PSDEVCENTERASID", (Object)string);
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
                ArrayList<PSASBooking> bookings = this.select((ISelectCond)selectContext);
                int n = pSDevCenterAS.getResState();
                pSDevCenterAS.reset();
                pSDevCenterAS.setPSDevCenterASId(string);
                if (!bookings.isEmpty()) {
                    ArrayList<JSONObject> arrayList = new ArrayList<JSONObject>();
                    Iterator<PSASBooking> iterator = bookings.iterator();
                    while (iterator.hasNext()) {
                        PSASBooking pSASBooking = iterator.next();
                        Timestamp timestamp = pSASBooking.getBeginTime();
                        Timestamp timestamp2 = pSASBooking.getEndTime();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("begintime", (Object)Long.toString(timestamp.getTime()));
                        jSONObject.put("endtime", (Object)Long.toString(timestamp2.getTime()));
                        String string2 = StringHelper.format((String)"%1$tY-%1$tm-%1$td", (Object)timestamp);
                        String string3 = StringHelper.format((String)"%1$tY-%1$tm-%1$td", (Object)timestamp2);
                        String string4 = null;
                        string4 = StringHelper.compare((String)string2, (String)string3, (boolean)true) == 0 ? StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM \u81f3 %2$tH:%2$tM", (Object)timestamp, (Object)timestamp2) : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM \u81f3 %2$tY-%2$tm-%2$td %2$tH:%2$tM", (Object)timestamp, (Object)timestamp2);
                        jSONObject.put("bkinfo", (Object)string4);
                        arrayList.add(jSONObject);
                    }
                    pSDevCenterAS.setResReadyTime(bookings.get(0).getBeginTime());
                    pSDevCenterAS.setPSASBKLists(JSONArray.fromArray((Object[])arrayList.toArray()).toString());
                } else {
                    pSDevCenterAS.setResReadyTime(null);
                    pSDevCenterAS.setPSASBKLists(null);
                }
                pSDevCenterASService.update(pSDevCenterAS, true);
            }
        }
        if (pSDevCenterAS.getResState() == 20) {
            return;
        }
    }
}
