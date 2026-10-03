/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectContext
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.paasmgr.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWSBooking;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWSBookingBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSWSBookingServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSWSBookingService
extends PSWSBookingServiceBase {
    private static final Log log = LogFactory.getLog(PSWSBookingService.class);

    @Override
    protected void onAutoCreate(PSWSBooking pSWSBooking) throws Exception {
        PSDCWorkspace pSDCWorkspace = pSWSBooking.getPSDCWorkspace();
        if (pSDCWorkspace == null) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u9884\u7ea6\u7684\u4e2d\u5fc3\u751f\u4ea7\u7ebf");
        }
        if (DataObject.getIntegerValue((Object)pSWSBooking.getDuration(), Integer.valueOf(-1)) <= 0) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u9884\u7ea6\u65f6\u957f");
        }
        if (pSDCWorkspace.getWorkspaceType().indexOf("T") != 0) {
            throw new Exception(StringHelper.format((String)"\u4e2d\u5fc3\u751f\u4ea7\u7ebf[%1$s]\u4e0d\u662f\u5206\u65f6\u7c7b\u578b", (Object)pSDCWorkspace.getPSDCWorkspaceName()));
        }
        PSWSBookingBase pSWSBookingBase = null;
        long l = System.currentTimeMillis();
        SelectContext selectContext = new SelectContext();
        selectContext.set("PSDCWORKSPACEID", (Object)pSDCWorkspace.getPSDCWorkspaceId());
        selectContext.set("BOOKINGTYPE", (Object)"DCRES");
        selectContext.setOrderInfo("ORDER BY BEGINTIME");
        ArrayList<PSWSBooking> arrayList = this.selectEx((ISelectContext)selectContext);
        for (PSWSBooking pSWSBooking2 : arrayList) {
            int n;
            if (pSWSBooking2.getBeginTime() == null || pSWSBooking2.getEndTime() == null || l > pSWSBooking2.getEndTime().getTime() || (n = DataObject.getIntegerValue((Object)pSWSBooking2.getBookingState(), (Integer)20).intValue()) < 10) continue;
            if (n <= 20) {
                pSWSBookingBase = pSWSBooking2;
                break;
            }
            if (pSWSBooking2.getEndTime().getTime() <= System.currentTimeMillis()) continue;
            if (pSWSBooking.getBeginTime() == null) {
                pSWSBooking.setBeginTime(pSWSBooking2.getEndTime());
                continue;
            }
            if (pSWSBooking2.getEndTime().getTime() <= pSWSBooking.getBeginTime().getTime()) continue;
            pSWSBooking.setBeginTime(pSWSBooking2.getEndTime());
        }
        if (pSWSBookingBase != null) {
            PSWSBooking pSWSBooking3 = new PSWSBooking();
            pSWSBooking3.setPSWSBookingId(pSWSBookingBase.getPSWSBookingId());
            pSWSBooking3.setDuration(pSWSBookingBase.getDuration() + pSWSBooking.getDuration());
            pSWSBooking3.setEndTime(new Timestamp(pSWSBookingBase.getEndTime().getTime() + (long)(pSWSBooking.getDuration() * 60000)));
            this.update(pSWSBooking3, true);
            pSWSBooking3.copyTo((IDataObject)pSWSBooking, true);
        } else {
            if (pSWSBooking.getBeginTime() == null) {
                pSWSBooking.setBeginTime(new Timestamp(System.currentTimeMillis()));
            }
            pSWSBooking.setEndTime(new Timestamp(pSWSBooking.getBeginTime().getTime() + (long)(pSWSBooking.getDuration() * 60000)));
            pSWSBooking.setBookingType("DCRES");
            if (StringHelper.isNullOrEmpty((String)pSWSBooking.getPSWSBookingName())) {
                pSWSBooking.setPSWSBookingName(StringHelper.format((String)"[%1$s]\u81f3[%2$s]", (Object)DateHelper.toDateTimeString((Date)pSWSBooking.getBeginTime()), (Object)DateHelper.toDateTimeString((Date)pSWSBooking.getEndTime())));
            }
            pSWSBooking.setPSDevCenterId(pSDCWorkspace.getPSDevCenterId());
            pSWSBooking.setPSDevCenterName(pSDCWorkspace.getPSDevCenterName());
            pSWSBooking.setPSDCWorkspaceName(pSDCWorkspace.getPSDCWorkspaceName());
            if (pSDCWorkspace.getPSWorkspace() != null) {
                pSWSBooking.setPSSvrDomainId(pSDCWorkspace.getPSWorkspace().getPSSvrDomainId());
                pSWSBooking.setPSSvrDomainName(pSDCWorkspace.getPSWorkspace().getPSSvrDomainName());
                pSWSBooking.setPSWorkspaceId(pSDCWorkspace.getPSWorkspace().getPSWorkspaceId());
                pSWSBooking.setPSWorkspaceName(pSDCWorkspace.getPSWorkspace().getPSWorkspaceName());
            }
            this.create(pSWSBooking);
        }
    }
}
