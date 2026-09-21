/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.codelist;

import java.util.Vector;
import net.ibizsys.model.PSSystemGlobalModelBase;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.codelist.PSCodeListImpl;
import net.ibizsys.model.entity.PSCodeList;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSCodeListGlobalModel
extends PSSystemGlobalModelBase<String, PSCodeList, IPSCodeList> {
    private static final Log log = LogFactory.getLog(PSCodeListGlobalModel.class);

    @Override
    protected PSCodeList getObject(String strPSCodeListId) {
        PSCodeList psCodeList = new PSCodeList();
        CallResult callResult = this.getPSModelQueryHelper().getPSCodeList(strPSCodeListId, psCodeList);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u4ee3\u7801\u8868[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSCodeListId, (Object)callResult.getErrorInfo()));
            return null;
        }
        if (StringHelper.compare((String)this.getPSSystem().getId(), (String)psCodeList.getPSSYSTEMID(), (boolean)false) != 0) {
            return null;
        }
        return psCodeList;
    }

    @Override
    protected IPSCodeList onCreateModelHelper(PSCodeList vt) throws Exception {
        PSCodeListImpl iPSCodeList = null;
        iPSCodeList = new PSCodeListImpl();
        iPSCodeList.init(this.getPSModelStorageContext(), this.getPSSystem(), vt);
        return iPSCodeList;
    }

    @Override
    protected Boolean testObjectRenew(PSCodeList obj) {
        return false;
    }

    @Override
    protected IPSCodeList registerModel(PSCodeList vt) throws Exception {
        IPSCodeList iIPSCodeList = (IPSCodeList)this.internalGetModelHelper(vt.getPSCODELISTID());
        if (iIPSCodeList != null) {
            return iIPSCodeList;
        }
        this.setModel(vt.getPSCODELISTID(), vt, null);
        return (IPSCodeList)this.findModelHelper(vt.getPSCODELISTID());
    }

    @Override
    protected Vector<PSCodeList> getAllModels() throws Exception {
        Vector<PSCodeList> list = new Vector<PSCodeList>();
        CallResult callResult = this.getPSModelQueryHelper().getAllPSCodeLists(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u4ee3\u7801\u8868\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSCodeList vt) {
        return vt.getPSCODELISTID();
    }
}

