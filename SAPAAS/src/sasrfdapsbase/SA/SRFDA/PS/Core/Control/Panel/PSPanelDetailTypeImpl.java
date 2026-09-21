/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelDetailType;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelItem;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSPanelDetailType;
import SA.SRFDA.PS.Data.PSSysPanelItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPanelDetailTypeImpl
extends PSObjectImpl
implements IPSPanelDetailType {
    protected PSPanelDetailType psPanelDetailType = null;
    private static final Log log = LogFactory.getLog(PSPanelDetailTypeImpl.class);
    private HashMap<String, String> parentPITypeMap = new HashMap();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSPanelDetailType psPanelDetailType) throws Exception {
        this.psPanelDetailType = psPanelDetailType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psPanelDetailType.getPSPANELDETAILTYPEID());
        this.setName(psPanelDetailType.getPSPANELDETAILTYPENAME());
        this.onInit();
    }

    @Override
    public IPSSysPanelItem createPSSysPanelItem(PSSysPanelItem psSysPanelItem) throws Exception {
        return (IPSSysPanelItem)ObjectHelper.Create((String)this.psPanelDetailType.getDETAILOBJ());
    }

    @Override
    public boolean isRootPIType() {
        return this.parentPITypeMap.size() == 0;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public boolean isSupportPPIType(String strPPIType) {
        return this.parentPITypeMap.containsKey(strPPIType);
    }
}

