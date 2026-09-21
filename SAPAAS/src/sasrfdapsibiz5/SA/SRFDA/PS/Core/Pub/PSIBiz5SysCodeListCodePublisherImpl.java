/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.CodeList.IPSCodeList
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class PSIBiz5SysCodeListCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psCodeLists = this.iPSSystem.getAllPSCodeLists();
        if (psCodeLists != null) {
            while (psCodeLists.hasNext()) {
                IPSCodeList iPSCodeList = (IPSCodeList)psCodeLists.next();
                if (!this.getPSSysSFPub().isDocMode() && (!iPSCodeList.getRefFlag() || iPSCodeList.isSubSysCodeList() && !iPSCodeList.isSubSysAsCloud()) || iPSCodeList.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.Compare((String)iPSCodeList.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0 || !StringHelper.IsNullOrEmpty((String)this.strDEFilter) && iPSCodeList.getPSDataEntity() != null && StringHelper.Compare((String)iPSCodeList.getPSDataEntity().getId(), (String)this.strDEFilter, (boolean)true) != 0) continue;
                this.onGenerateCode(iPSCodeList, null);
            }
        }
    }

    protected abstract void onGenerateCode(IPSCodeList var1, ArrayList<PSSysSFCode> var2) throws Exception;

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSCodeList) {
            IPSCodeList iPSCodeList = (IPSCodeList)iPSObject;
            if (!iPSCodeList.isSubSysCodeList() || iPSCodeList.isSubSysAsCloud()) {
                if (iPSCodeList.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.Compare((String)iPSCodeList.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                    return null;
                }
                ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
                this.onGenerateCode(iPSCodeList, list);
                return list;
            }
            return null;
        }
        return null;
    }
}

