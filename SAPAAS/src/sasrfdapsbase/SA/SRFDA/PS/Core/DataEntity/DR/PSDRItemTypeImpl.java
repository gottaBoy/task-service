/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DR;

import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRItem;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDRItemType;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEDRItem;
import SA.SRFDA.PS.Data.PSDRItemType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDRItemTypeImpl
extends PSObjectImpl
implements IPSDRItemType {
    protected PSDRItemType psDRItemType = null;
    private static final Log log = LogFactory.getLog(PSDRItemTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDRItemType psDRItemType) throws Exception {
        this.psDRItemType = psDRItemType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDRItemType.getPSDRITEMTYPEID());
        this.setName(psDRItemType.getPSDRITEMTYPENAME());
        this.setPSObjectData(this.psDRItemType);
        this.onInit();
    }

    @Override
    public IPSDEDRItem createPSDEDRItem(PSDEDRItem psDEDRItem) throws Exception {
        IPSDEDRItem iPSDRItem = (IPSDEDRItem)ObjectHelper.Create((String)this.psDRItemType.getITEMOBJ());
        return iPSDRItem;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

