/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFUtilUIAction;
import SA.SRFDA.PS.Data.PSSysWFSetting;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u5de5\u4f5c\u6d41\u8bbe\u7f6e\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysWFSetting")
public interface IPSSysWFSetting
extends IPSSystemObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysWFSetting var3) throws Exception;

    public String getRemindPSSysMsgTemplId();

    public IPSSysMsgTempl getRemindPSSysMsgTempl() throws Exception;

    public Iterator<IPSWFUtilUIAction> getPSWFUtilUIActions() throws Exception;
}

