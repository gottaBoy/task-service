/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Menu;

import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItem;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItemType;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSAppMenuItem;
import SA.SRFDA.PS.Data.PSAppMenuItemType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSAppMenuItemTypeImpl
extends PSObjectImpl
implements IPSAppMenuItemType {
    protected PSAppMenuItemType psAppMenuItemType = null;
    private static final Log log = LogFactory.getLog(PSAppMenuItemTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSAppMenuItemType psAppMenuItemType) throws Exception {
        this.psAppMenuItemType = psAppMenuItemType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psAppMenuItemType.getPSAMITEMTYPEID());
        this.setName(psAppMenuItemType.getPSAMITEMTYPENAME());
        this.onInit();
    }

    @Override
    public IPSAppMenuItem createPSAppMenuItem(PSAppMenuItem psDEAppMenuItem) throws Exception {
        IPSAppMenuItem iPSAppMenuItem = (IPSAppMenuItem)ObjectHelper.Create((String)this.psAppMenuItemType.getITEMOBJ());
        if (iPSAppMenuItem == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u5efa\u7acb\u5e94\u7528\u83dc\u5355\u9879\uff0c\u7c7b\u578b\u4e3a[%1$s]", (Object)this.psAppMenuItemType.getPSAMITEMTYPENAME()));
        }
        return iPSAppMenuItem;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

