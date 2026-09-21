/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDAQueryModelUserContext
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.ND.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.IDAQueryModelUserContext;
import SA.SRFDA.ND.Ctrl.DataGrid.NDDataGridActionHelper;
import SA.SRFDA.ND.Data.NDDisk;
import SA.SRFDA.ND.Data.NDFSObject;
import SA.SRFDA.ND.Web.SRFDANDWebCTXHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NDShareDataGridActionHelper
extends NDDataGridActionHelper {
    private static final Log log = LogFactory.getLog(NDShareDataGridActionHelper.class);
    protected NDDisk ndDisk = null;

    public NDShareDataGridActionHelper() {
        this.bRemoveFlagCondition = true;
        this.bRootFSObjectIdCondition = true;
        this.bPFSObjectIdCondition = true;
        this.bFSObjectTypeCondition = true;
    }

    protected boolean OnBeforeProcess() {
        return super.OnBeforeProcess();
    }

    public void setNDDisk(NDDisk ndDisk) {
        this.ndDisk = ndDisk;
    }

    public NDDisk getNDDisk() {
        return this.ndDisk;
    }

    @Override
    protected void FillDAQueryModelHelperCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
        super.FillDAQueryModelHelperCondition(userConditions, daQueryModelHelper);
    }

    @Override
    protected String OnGetRootFSObjectIdCondition(BaseDAQueryModelHelper daQueryModelHelper) {
        IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper("ROOTNDFSOBJECTID");
        String strValue = this.ndDisk.getNDDISKID();
        String strCondition = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, iDEFHelper, "", "=", strValue);
        return strCondition;
    }

    @Override
    protected String OnGetPFSObjectIdCondition(BaseDAQueryModelHelper daQueryModelHelper) {
        IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper("PNDFSOBJECTID");
        String strValue = SRFDANDWebCTXHelper.GetNDFolderPath((ISRFDAWebContext)this.getWebContext());
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            return "";
        }
        try {
            String strRootNDFSObjectId = this.ndDisk.getNDDISKID();
            NDFSObject pNDFSObject = SRFDANDWebCTXHelper.GetNDUserModelStorage((ISRFDAWebContext)this.getWebContext()).FindNDFSObject(strRootNDFSObjectId, strValue, true, false);
            strValue = pNDFSObject.getNDFSOBJECTID();
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            strValue = "INVALID_PFSOBJECT";
        }
        String strCondition = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, iDEFHelper, "", "=", strValue);
        return strCondition;
    }

    @Override
    protected String OnGetFSObjectTypeCondition(BaseDAQueryModelHelper daQueryModelHelper) {
        String strValue = SRFDANDWebCTXHelper.GetNDFolderPath((ISRFDAWebContext)this.getWebContext());
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper("NDFSOBJECTTYPE");
            String strCondition1 = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, iDEFHelper, "", "=", "SHARE");
            return StringHelper.Format((String)"%1$s", (Object)strCondition1);
        }
        return super.OnGetFSObjectTypeCondition(daQueryModelHelper);
    }
}

