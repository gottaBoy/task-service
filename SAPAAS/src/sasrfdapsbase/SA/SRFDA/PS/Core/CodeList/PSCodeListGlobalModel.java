/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.CodeList;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.CodeList.PSCodeListImpl;
import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Core.PSSystemException;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSCodeList;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSCodeListGlobalModel
extends PSSystemGlobalModelBase<String, PSCodeList, IPSCodeList> {
    private static final Log log = LogFactory.getLog(PSCodeListGlobalModel.class);
    protected IPSModelHelper iPSModelHelper = null;

    @Override
    protected CallResult OnInit() {
        this.bEnableEmptyMap = true;
        CallResult callResult = super.OnInit();
        if (callResult.isError()) {
            return callResult;
        }
        try {
            this.iPSModelHelper = PSObjectFactory.getPSModelHelper(this.iDAGlobalHelper, this.getPSSystem().getPSSysModelInstId());
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u7cfb\u7edf\u4ee3\u7801\u8868\u5168\u5c40\u6a21\u578b\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    @Override
    protected PSCodeList GetObject(String strPSCodeListId) {
        PSCodeList psCodeList = new PSCodeList();
        CallResult callResult = this.iPSModelHelper.getPSCodeList(strPSCodeListId, psCodeList);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u4ee3\u7801\u8868[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSCodeListId, (Object)callResult.getErrorInfo()));
            return null;
        }
        if (StringHelper.Compare((String)this.getPSSystem().getId(), (String)psCodeList.getPSSYSTEMID(), (boolean)false) != 0) {
            return null;
        }
        return psCodeList;
    }

    @Override
    protected IPSCodeList OnCreateModelHelper(PSCodeList vt) throws Exception {
        PSCodeListImpl iPSCodeList = null;
        iPSCodeList = new PSCodeListImpl();
        iPSCodeList.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSCodeList;
    }

    @Override
    protected Boolean TestObjectRenew(PSCodeList obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSCodeList registerModel(PSCodeList vt) throws Exception {
        IPSCodeList iIPSCodeList = (IPSCodeList)this.InternalGetModelHelper(vt.getPSCODELISTID());
        if (iIPSCodeList != null) {
            return iIPSCodeList;
        }
        this.setModel(vt.getPSCODELISTID(), vt, null);
        return (IPSCodeList)this.FindModelHelper(vt.getPSCODELISTID());
    }

    @Override
    protected Vector<PSCodeList> getAllModels() throws Exception {
        Vector<PSCodeList> list = new Vector<PSCodeList>();
        CallResult callResult = this.iPSModelHelper.getAllPSCodeLists(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u4ee3\u7801\u8868\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSCodeList> codeListMap = new HashMap<String, PSCodeList>();
        for (PSCodeList psCodeList : list) {
            this.setModel(psCodeList.getPSCODELISTID(), psCodeList, null);
            codeListMap.put(psCodeList.getPSCODELISTID(), psCodeList);
        }
        for (PSCodeList psCodeList : list) {
            String strPSCodeListId;
            if (StringHelper.IsNullOrEmpty((String)psCodeList.getPSCODELISTTEMPLID()) || StringHelper.Compare((String)(strPSCodeListId = KeyValueHelper.genUniqueId((String)psCodeList.getPSSYSTEMID(), (String)psCodeList.getPSCODELISTTEMPLID())), (String)psCodeList.getPSCODELISTID(), (boolean)false) == 0 || codeListMap.containsKey(strPSCodeListId)) continue;
            this.setModel(strPSCodeListId, psCodeList, null);
            codeListMap.put(strPSCodeListId, psCodeList);
        }
        return list;
    }

    @Override
    protected String getObjectId(PSCodeList vt) {
        return vt.getPSCODELISTID();
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSSystemException.create(this.getPSSystem(), 10001, objObjectId);
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModels();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSCodeList vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            String strId;
            if (!StringHelper.IsNullOrEmpty((String)vt.getPSCODELISTTEMPLID()) && StringHelper.Compare((String)(strId = KeyValueHelper.genUniqueId((String)this.getPSSystem().getId(), (String)vt.getPSCODELISTTEMPLID())), (String)vt.getPSCODELISTID(), (boolean)false) != 0) {
                return new String[]{strId.toUpperCase(), vt.getCODENAME().toUpperCase()};
            }
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

