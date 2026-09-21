/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Toolbar;

import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarItem;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEToolbarItem;
import SA.SRFDA.PS.Data.PSToolbarItemType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSToolbarItemType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSToolbarItemType var2) throws Exception;

    public IPSDEToolbarItem createPSDEToolbarItem(PSDEToolbarItem var1) throws Exception;
}

