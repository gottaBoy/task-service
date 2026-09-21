/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEJoinType;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEJoinType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDEJoinTypeImpl
extends PSObjectImpl
implements IPSDEJoinType {
    protected PSDEJoinType psDEJoinType = null;
    private static final Log log = LogFactory.getLog(PSDEJoinTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDEJoinType psDEJoinType) throws Exception {
        this.psDEJoinType = psDEJoinType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDEJoinType.getPSDEJOINTYPEID());
        this.setName(psDEJoinType.getPSDEJOINTYPENAME());
        this.setPSObjectData(this.psDEJoinType);
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

