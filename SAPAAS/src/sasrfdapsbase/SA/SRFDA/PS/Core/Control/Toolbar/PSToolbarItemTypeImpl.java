/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Toolbar;

import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSToolbarItemType;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEToolbarItem;
import SA.SRFDA.PS.Data.PSToolbarItemType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSToolbarItemTypeImpl
extends PSObjectImpl
implements IPSToolbarItemType {
    protected PSToolbarItemType psToolbarItemType = null;
    private static final Log log = LogFactory.getLog(PSToolbarItemTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSToolbarItemType psToolbarItemType) throws Exception {
        this.psToolbarItemType = psToolbarItemType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psToolbarItemType.getPSTBITEMTYPEID());
        this.setName(psToolbarItemType.getPSTBITEMTYPENAME());
        this.onInit();
    }

    @Override
    public IPSDEToolbarItem createPSDEToolbarItem(PSDEToolbarItem psDEToolbarItem) throws Exception {
        IPSDEToolbarItem iPSToolbarItem = (IPSDEToolbarItem)ObjectHelper.Create((String)this.psToolbarItemType.getITEMOBJ());
        return iPSToolbarItem;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

