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
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCondType;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicLinkCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicLinkCond;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDELogicLinkCond;
import SA.SRFDA.PS.Data.PSDELogicLinkCondType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDELogicLinkCondTypeImpl
extends PSObjectImpl
implements IPSDELogicLinkCondType {
    protected PSDELogicLinkCondType psFDLogicType = null;
    private static final Log log = LogFactory.getLog(PSDELogicLinkCondTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDELogicLinkCondType psFDLogicType) throws Exception {
        this.psFDLogicType = psFDLogicType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psFDLogicType.getPSDELLCONDTYPEID());
        this.setName(psFDLogicType.getPSDELLCONDTYPENAME());
        this.setPSObjectData(this.psFDLogicType);
        this.onInit();
    }

    @Override
    public IPSDELogicLinkCond createPSDELogicLinkCond(PSDELogicLinkCond psDELogicLinkCond) throws Exception {
        return (IPSDELogicLinkCond)ObjectHelper.Create((String)this.psFDLogicType.getITEMOBJ());
    }

    @Override
    public IPSDEUILogicLinkCond createPSDEUILogicLinkCond(PSDELogicLinkCond psDELogicLinkCond) throws Exception {
        String strObj = this.psFDLogicType.getITEMOBJ2();
        if (StringHelper.isNullOrEmpty((String)strObj)) {
            strObj = this.psFDLogicType.getITEMOBJ();
        }
        return (IPSDEUILogicLinkCond)ObjectHelper.Create((String)strObj);
    }

    @Override
    public IPSDEMSLogicLinkCond createPSDEMSLogicLinkCond(PSDELogicLinkCond psDELogicLinkCond) throws Exception {
        String strObj = this.psFDLogicType.getITEMOBJ3();
        if (StringHelper.isNullOrEmpty((String)strObj)) {
            strObj = this.psFDLogicType.getITEMOBJ();
        }
        return (IPSDEMSLogicLinkCond)ObjectHelper.Create((String)strObj);
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

