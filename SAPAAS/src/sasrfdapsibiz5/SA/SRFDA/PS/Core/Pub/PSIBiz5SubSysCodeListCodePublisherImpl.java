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

public abstract class PSIBiz5SubSysCodeListCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psCodeLists = this.iPSSystem.getAllPSCodeLists();
        while (psCodeLists.hasNext()) {
            IPSCodeList iPSCodeList = (IPSCodeList)psCodeLists.next();
            if (!iPSCodeList.getRefFlag() || !iPSCodeList.isSubSysCodeList() || iPSCodeList.isSubSysAsCloud() || !StringHelper.IsNullOrEmpty((String)this.strDEFilter) && StringHelper.Compare((String)iPSCodeList.getPSDataEntity().getName(), (String)this.strDEFilter, (boolean)true) != 0 || iPSCodeList.getExtendMode() != 2) continue;
            this.onGenerateCode(iPSCodeList, null);
        }
    }

    protected abstract void onGenerateCode(IPSCodeList var1, ArrayList<PSSysSFCode> var2) throws Exception;

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSCodeList) {
            IPSCodeList iPSCodeList = (IPSCodeList)iPSObject;
            if (iPSCodeList.isSubSysCodeList() && !iPSCodeList.isSubSysAsCloud()) {
                ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
                this.onGenerateCode(iPSCodeList, list);
                return list;
            }
            return null;
        }
        return null;
    }
}

