/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.UIAction;

import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionType;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEUIActionType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDEUIActionTypeImpl
extends PSObjectImpl
implements IPSDEUIActionType {
    protected PSDEUIActionType psDEUIActionType = null;
    private static final Log log = LogFactory.getLog(PSDEUIActionTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDEUIActionType psDEUIActionType) throws Exception {
        this.psDEUIActionType = psDEUIActionType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDEUIActionType.getPSDEUIACTIONTYPEID());
        this.setName(psDEUIActionType.getPSDEUIACTIONTYPENAME());
        this.setPSObjectData(this.psDEUIActionType);
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

