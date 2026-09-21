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
import SA.SRFDA.ND.Data.NDFSObject;
import SA.SRFDA.ND.Data.NDShare;
import SA.SRFDA.ND.Web.SRFDANDWebCTXHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NDShareFolderDataGridActionHelper
extends NDDataGridActionHelper {
    private static final Log log = LogFactory.getLog(NDShareFolderDataGridActionHelper.class);
    protected NDShare ndShare = null;

    protected boolean OnBeforeProcess() {
        return super.OnBeforeProcess();
    }

    public void setNDShare(NDShare ndShare) {
        this.ndShare = ndShare;
    }

    public NDShare getNDShare() {
        return this.ndShare;
    }

    @Override
    protected String OnGetRootFSObjectIdCondition(BaseDAQueryModelHelper daQueryModelHelper) {
        IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper("ROOTNDFSOBJECTID");
        String strValue = this.ndShare.getROOTNDFSOBJECTID();
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            strValue = "INVALID_ROOTFSOBJECT";
        }
        String strCondition = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, iDEFHelper, "", "=", strValue);
        return strCondition;
    }

    @Override
    protected String OnGetPFSObjectIdCondition(BaseDAQueryModelHelper daQueryModelHelper) {
        IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper("PNDFSOBJECTID");
        String strValue = SRFDANDWebCTXHelper.GetNDFolderPath((ISRFDAWebContext)this.getWebContext());
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            String strPNDFSObjectId = this.ndShare.getNDFSOBJECTID();
            String strCondition = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, iDEFHelper, "", "=", strPNDFSObjectId);
            return strCondition;
        }
        try {
            String strRootNDFSObjectId = this.ndShare.getROOTNDFSOBJECTID();
            if (StringHelper.IsNullOrEmpty((String)strRootNDFSObjectId)) {
                strRootNDFSObjectId = "INVALID_ROOTFSOBJECT";
            }
            NDFSObject pNDFSObject = SRFDANDWebCTXHelper.GetNDUserModelStorage((ISRFDAWebContext)this.getWebContext()).FindNDFSObject(strRootNDFSObjectId, this.ndShare.getNDFSOBJECTID(), strValue, false);
            strValue = pNDFSObject.getNDFSOBJECTID();
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            strValue = "INVALID_PFSOBJECT";
        }
        String strCondition = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, iDEFHelper, "", "=", strValue);
        return strCondition;
    }
}

