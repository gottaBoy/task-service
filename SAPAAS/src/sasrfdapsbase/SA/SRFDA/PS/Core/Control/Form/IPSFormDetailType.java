/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEFormDetail;
import SA.SRFDA.PS.Data.PSFormDetailType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSFormDetailType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSFormDetailType var2) throws Exception;

    public IPSDEFormDetail createPSDEFormDetail(PSDEFormDetail var1) throws Exception;

    public boolean isRootFDType();

    public boolean isSupportPFDType(String var1);
}

