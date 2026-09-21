/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxControlHandler;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.PS.Data.PSControlType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;

@PSModelIgnoreMeta
public interface IPSControlType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSControlType var2) throws Exception;

    public String getControlDEId();

    public boolean isAjaxControl();

    public IPSControl createPSControl(IPSControlParam var1) throws Exception;

    public IPSControlParam createPSControlParam(BaseDataEntity var1) throws Exception;

    public IPSAjaxControlHandler createPSAjaxControlHandler(PSACHandler var1) throws Exception;
}

