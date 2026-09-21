/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQPDCondType;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQPDCondition;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEDQPDCond;
import SA.SRFDA.PS.Data.PSDEDataQueryCond;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDEDQPDCondTypeImpl
extends PSObjectImpl
implements IPSDEDQPDCondType {
    protected PSDEDQPDCond psDEDQPDCondType = null;
    private static final Log log = LogFactory.getLog(PSDEDQPDCondTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDEDQPDCond psDEDQPDCondType) throws Exception {
        this.psDEDQPDCondType = psDEDQPDCondType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDEDQPDCondType.getPSDEDQPDCONDID());
        this.setName(psDEDQPDCondType.getPSDEDQPDCONDNAME());
        this.setPSObjectData(this.psDEDQPDCondType);
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public IPSDEDQPDCondition createPSDEDQPDCondition(PSDEDataQueryCond psDEDataQueryCond) throws Exception {
        return (IPSDEDQPDCondition)ObjectHelper.Create((String)this.psDEDQPDCondType.getCONDOBJ());
    }
}

