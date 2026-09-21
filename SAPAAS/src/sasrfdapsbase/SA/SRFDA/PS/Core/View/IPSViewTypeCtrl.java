/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFDA.PS.Data.PSViewTypeCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSViewTypeCtrl
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, IPSViewType var2, PSViewTypeCtrl var3) throws Exception;

    public String getCtrlType();

    public String getPSSysToolbarId();

    public String getPSSysACHandlerId();

    public String getCtrlParam();

    public String getCtrlParam2();

    public String getCtrlParam3();

    public String getCtrlParam4();

    public Integer getCtrlParam5();

    public Integer getCtrlParam6();

    public Integer getCtrlParam7();

    public Integer getCtrlParam8();

    public Double getCtrlParam9();

    public Double getCtrlParam10();

    public Integer getCtrlParam11();

    public Integer getCtrlParam12();
}

