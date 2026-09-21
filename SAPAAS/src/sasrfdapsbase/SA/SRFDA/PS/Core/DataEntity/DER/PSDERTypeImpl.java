/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERType;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDER;
import SA.SRFDA.PS.Data.PSDERType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDERTypeImpl
extends PSObjectImpl
implements IPSDERType {
    protected PSDERType psDERType = null;
    private static final Log log = LogFactory.getLog(PSDERTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDERType psDERType) throws Exception {
        this.psDERType = psDERType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDERType.getPSDERTYPEID());
        this.setName(psDERType.getPSDERTYPENAME());
        this.setPSObjectData(this.psDERType);
        this.onInit();
    }

    @Override
    public IPSDERBase createPSDER(PSDER psDER) throws Exception {
        IPSDERBase iPSDER = (IPSDERBase)ObjectHelper.Create((String)this.psDERType.getDEROBJ());
        return iPSDER;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

