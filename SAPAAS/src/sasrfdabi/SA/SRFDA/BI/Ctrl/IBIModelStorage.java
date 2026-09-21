/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.IBICatalogHelper;
import SA.SRFDA.BI.Ctrl.IBICubeHelper;
import SA.SRFDA.BI.Ctrl.IBIRepFITypeHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPLHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPTHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPanelHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPartHelper;
import SA.SRFDA.BI.Ctrl.IBIReportExHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IBIModelStorage {
    public void Init(ISRFDAGlobalHelper var1) throws Exception;

    public IBIReportExHelper FindBIReportEx(String var1) throws Exception;

    public IBICubeHelper FindBICube(String var1) throws Exception;

    public IBICatalogHelper FindBICatalog(String var1) throws Exception;

    public IBIRepPanelHelper FindBIRepPanel(String var1) throws Exception;

    public IBIRepPTHelper FindBIRepPT(String var1) throws Exception;

    public IBIRepPartHelper FindBIRepPart(String var1) throws Exception;

    public IBIRepPLHelper FindBIRepPL(String var1) throws Exception;

    public IBIRepFITypeHelper FindBIRepFIType(String var1) throws Exception;
}

