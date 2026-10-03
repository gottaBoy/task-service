/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.exception.ErrorException
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.PSCoreSysModel;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.DCLevelCodeListModel;
import net.ibizsys.pscore.srv.codelist.StudioVerCodeListModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserService;
import net.ibizsys.pscore.srv.util.IPSDevUser;
import net.ibizsys.pscore.srv.util.PSDevCenterHelper;
import net.ibizsys.pscore.srv.util.PSDevUser;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDevUserUserGlobal
implements Serializable {
    public static final String SESSIONKEY = "SRF_PSDEVUSERUSERGLOBAL";
    private static final Log log = LogFactory.getLog(PSDevUserUserGlobal.class);
    protected HashMap<String, IPSDevUser> psDevUserMap = new HashMap();
    private static ThreadLocal<IPSDevUser> currentUser = new ThreadLocal();

    public static IPSDevUser getCurrentUser() {
        return currentUser.get();
    }

    public static void setCurrentUser(IPSDevUser iPSDevUser) {
        currentUser.set(iPSDevUser);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public IPSDevUser getPSDevUser(String string) {
        IPSDevUser iPSDevUser = null;
        HashMap<String, IPSDevUser> hashMap = this.psDevUserMap;
        synchronized (hashMap) {
            iPSDevUser = this.psDevUserMap.get(string);
            return iPSDevUser;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void registerPSDevUser(String string, IPSDevUser iPSDevUser) throws Exception {
        HashMap<String, IPSDevUser> hashMap = this.psDevUserMap;
        synchronized (hashMap) {
            this.psDevUserMap.put(string, iPSDevUser);
        }
    }

    public static PSDevUserUserGlobal getCurrent() throws Exception {
        return PSDevUserUserGlobal.getCurrent(null);
    }

    public static PSDevUserUserGlobal getCurrent(IWebContext iWebContext) throws Exception {
        if (iWebContext == null) {
            iWebContext = WebContext.getCurrent();
        }
        if (iWebContext == null) {
            throw new Exception(StringHelper.format((String)"\u7528\u6237\u4e0a\u4e0b\u6587\u5bf9\u8c61\u65e0\u6548"));
        }
        Object object = iWebContext.getSessionValue(SESSIONKEY, false);
        if (object == null) {
            object = new PSDevUserUserGlobal();
            iWebContext.setSessionValue(SESSIONKEY, object, false);
        }
        return (PSDevUserUserGlobal)object;
    }

    public static void resetCurrent(IWebContext iWebContext) {
        if (iWebContext == null) {
            iWebContext = WebContext.getCurrent();
        }
        if (iWebContext == null) {
            return;
        }
        iWebContext.setSessionValue(SESSIONKEY, null);
    }

    public static IPSDevUser getPSDevUser(IWebContext iWebContext, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)iWebContext.getCurUserId()) && !PSCoreSysModel.isShareSysMode()) {
            throw new ErrorException(2, StringHelper.format((String)"\u5f53\u524d\u7528\u6237\u8fd8\u672a\u767b\u5f55"));
        }
        IPSDevUser iPSDevUser = null;
        PSDevUserUserGlobal pSDevUserUserGlobal = PSDevUserUserGlobal.getCurrent(iWebContext);
        iPSDevUser = pSDevUserUserGlobal.getPSDevUser(string);
        if (iPSDevUser != null) {
            if (iPSDevUser == PSDevUser.ACCESSDENY) {
                throw new ErrorException(2, StringHelper.format((String)"\u5f53\u524d\u7528\u6237\u65e0\u6cd5\u8bbf\u95ee\u6307\u5b9a\u5e94\u7528\u4e2d\u5fc3"));
            }
            if (iPSDevUser.isExpired()) {
                throw new ErrorException(2, StringHelper.format((String)"\u5e94\u7528\u4e2d\u5fc3\u5df2\u8fc7\u671f"));
            }
            if (StringHelper.compare((String)PSCoreSysModel.getStudioVer(), (String)"S0500", (boolean)false) == 0 && (StringHelper.isNullOrEmpty((String)iPSDevUser.getStudioVer()) || StringHelper.compare((String)iPSDevUser.getStudioVer(), (String)"S0500", (boolean)false) == 0 || StringHelper.compare((String)iPSDevUser.getStudioVer(), (String)"S0600M1", (boolean)false) == 0)) {
                return iPSDevUser;
            }
            if (StringHelper.compare((String)PSCoreSysModel.getStudioVer(), (String)"S0600", (boolean)false) == 0 && (StringHelper.isNullOrEmpty((String)iPSDevUser.getStudioVer()) || StringHelper.compare((String)iPSDevUser.getStudioVer(), (String)"S0600", (boolean)false) == 0 || StringHelper.compare((String)iPSDevUser.getStudioVer(), (String)"S0600M1", (boolean)false) == 0)) {
                return iPSDevUser;
            }
            String string2 = StudioVerCodeListModel.getInstance().getCodeListText(iPSDevUser.getStudioVer(), true);
            throw new ErrorException(2, StringHelper.format((String)"\u5e94\u7528\u4e2d\u5fc3\u65e0\u6cd5\u6253\u5f00\uff0c\u9700\u8981Studio\u7248\u672c[%1$s]", (Object)string2));
        }
        boolean bl = false;
        PSDevUserService pSDevUserService = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSDEVCENTERID", (Object)string);
        selectCond.set("FROMPSDEVUSERID", (Object)iWebContext.getCurUserId());
        selectCond.set("VALIDFLAG", (Object)1);
        selectCond.setFetchFirst(true);
        ArrayList arrayList = pSDevUserService.select((ISelectCond)selectCond);
        if (arrayList == null || arrayList.size() == 0) {
            selectCond.reset();
            selectCond.set("PSDEVCENTERID", (Object)string);
            selectCond.set("PSDEVUSERID", (Object)iWebContext.getCurUserId());
            selectCond.set("VALIDFLAG", (Object)1);
            selectCond.setFetchFirst(true);
            arrayList = pSDevUserService.select((ISelectCond)selectCond);
            if (arrayList == null || arrayList.size() == 0) {
                pSDevUserUserGlobal.registerPSDevUser(string, PSDevUser.ACCESSDENY);
                throw new ErrorException(2, StringHelper.format((String)"\u5f53\u524d\u7528\u6237\u65e0\u6cd5\u8bbf\u95ee\u6307\u5b9a\u5e94\u7528\u4e2d\u5fc3"));
            }
            bl = true;
        }
        PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevCenter pSDevCenter = new PSDevCenter();
        pSDevCenter.setPSDevCenterId(string);
        if (!pSDevCenterService.get(pSDevCenter, true)) {
            throw new ErrorException(2, StringHelper.format((String)"\u5e94\u7528\u4e2d\u5fc3\u4e0d\u5b58\u5728"));
        }
        if (!StringHelper.isNullOrEmpty((String)PSSysModelInstGlobal.getCurrentPSSvrDomainId()) && !StringHelper.isNullOrEmpty((String)pSDevCenter.getPSSvrDomainId()) && StringHelper.compare((String)pSDevCenter.getPSSvrDomainId(), (String)PSSysModelInstGlobal.getCurrentPSSvrDomainId(), (boolean)false) != 0) {
            throw new ErrorException(2, StringHelper.format((String)"\u65e0\u6cd5\u8bbf\u95ee\u8de8\u670d\u52a1\u57df\u5e94\u7528\u4e2d\u5fc3"));
        }
        Object var10_11 = null;
        net.ibizsys.pscore.srv.devcenter.entity.PSDevUser pSDevUser = (net.ibizsys.pscore.srv.devcenter.entity.PSDevUser)arrayList.get(0);
        PSDevUser pSDevUser2 = new PSDevUser();
        if (DataObject.getBoolValue((Integer)pSDevUser.getAliasUserMode(), (boolean)false)) {
            pSDevUser2.setPSDevUserId(pSDevUser.getAliasPSDevUserId());
            pSDevUser2.setPSDevUserName(pSDevUser.getAliasPSDevUserName());
        } else {
            pSDevUser2.setPSDevUserId(pSDevUser.getPSDevUserId());
            pSDevUser2.setPSDevUserName(pSDevUser.getPSDevUserName());
        }
        pSDevUser2.setPSDevCenterId(pSDevUser.getPSDevCenterId());
        pSDevUser2.setPSDevCenterName(pSDevUser.getPSDevCenterName());
        pSDevUser2.setDefaultMode(bl);
        if (!StringHelper.isNullOrEmpty((String)pSDevCenter.getPSDCInstId())) {
            pSDevUser2.setPSDCInstId(pSDevCenter.getPSDCInstId());
        }
        Integer n = DataObject.getIntegerValue((Object)pSDevCenter.getDCLevel(), (Integer)DCLevelCodeListModel.PROFESSIONAL);
        String string3 = DataObject.getStringValue((Object)pSDevCenter.getDCType(), (String)"DEVCENTER");
        pSDevUser2.setPSDCType(string3);
        pSDevUser2.setPSDCLevel(n);
        pSDevUser2.setStudioVer(pSDevCenter.getStudioVer());
        pSDevUser2.setStudioTag(pSDevCenter.getStudioTag());
        pSDevUser2.setStudioTag2(pSDevCenter.getStudioTag2());
        if ((PSDevCenterHelper.isLabDC(pSDevCenter) || n >= DCLevelCodeListModel.PROFESSIONAL) && DataObject.getBoolValue((Integer)pSDevUser.getAdminMode(), (boolean)false)) {
            pSDevUser2.setAdminMode(true);
        }
        pSDevUserUserGlobal.registerPSDevUser(string, pSDevUser2);
        if (pSDevUser2.isExpired()) {
            throw new ErrorException(2, StringHelper.format((String)"\u5e94\u7528\u4e2d\u5fc3\u5df2\u8fc7\u671f"));
        }
        if (StringHelper.compare((String)PSCoreSysModel.getStudioVer(), (String)"S0500", (boolean)false) == 0 && (StringHelper.isNullOrEmpty((String)pSDevUser2.getStudioVer()) || StringHelper.compare((String)pSDevUser2.getStudioVer(), (String)"S0500", (boolean)false) == 0 || StringHelper.compare((String)pSDevUser2.getStudioVer(), (String)"S0600M1", (boolean)false) == 0)) {
            return pSDevUser2;
        }
        if (StringHelper.compare((String)PSCoreSysModel.getStudioVer(), (String)"S0600", (boolean)false) == 0 && (StringHelper.isNullOrEmpty((String)pSDevUser2.getStudioVer()) || StringHelper.compare((String)pSDevUser2.getStudioVer(), (String)"S0600", (boolean)false) == 0 || StringHelper.compare((String)pSDevUser2.getStudioVer(), (String)"S0600M1", (boolean)false) == 0)) {
            return pSDevUser2;
        }
        String string4 = StudioVerCodeListModel.getInstance().getCodeListText(pSDevUser2.getStudioVer(), true);
        throw new ErrorException(2, StringHelper.format((String)"\u5e94\u7528\u4e2d\u5fc3\u65e0\u6cd5\u6253\u5f00\uff0c\u9700\u8981Studio\u7248\u672c[%1$s]", (Object)string4));
    }
}

