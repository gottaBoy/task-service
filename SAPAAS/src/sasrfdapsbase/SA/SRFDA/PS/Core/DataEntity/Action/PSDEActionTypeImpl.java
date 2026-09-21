/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionType;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEAction;
import SA.SRFDA.PS.Data.PSDEActionType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Properties;

@PSModelIgnoreMeta
public class PSDEActionTypeImpl
extends PSObjectImpl
implements IPSDEActionType {
    protected PSDEActionType psDEActionType = null;
    private Properties typeParams = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDEActionType psDEActionType) throws Exception {
        this.psDEActionType = psDEActionType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDEActionType.getPSDEACTIONTYPEID());
        this.setName(psDEActionType.getPSDEACTIONTYPENAME());
        this.setPSObjectData(this.psDEActionType);
        this.typeParams = PropertiesHelper.Load((String)psDEActionType.getTYPEPARAM());
        this.onInit();
    }

    @Override
    public IPSDEAction createPSDEAction(PSDEAction psDEAction) throws Exception {
        return (IPSDEAction)ObjectHelper.Create((String)this.psDEActionType.getPROCESSOBJ());
    }

    @Override
    public Properties getTypeParams() {
        return this.typeParams;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

