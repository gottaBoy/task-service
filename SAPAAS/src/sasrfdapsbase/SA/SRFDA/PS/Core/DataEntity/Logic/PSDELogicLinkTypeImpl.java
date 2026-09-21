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

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkType;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicLink;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDELogicLink;
import SA.SRFDA.PS.Data.PSDELogicLinkType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDELogicLinkTypeImpl
extends PSObjectImpl
implements IPSDELogicLinkType {
    protected PSDELogicLinkType psFDLogicType = null;
    private static final Log log = LogFactory.getLog(PSDELogicLinkTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDELogicLinkType psFDLogicType) throws Exception {
        this.psFDLogicType = psFDLogicType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psFDLogicType.getPSDELLTYPEID());
        this.setName(psFDLogicType.getPSDELLTYPENAME());
        this.setPSObjectData(this.psFDLogicType);
        this.onInit();
    }

    @Override
    public IPSDELogicLink createPSDELogicLink(PSDELogicLink psDELogicLink) throws Exception {
        return (IPSDELogicLink)ObjectHelper.Create((String)this.psFDLogicType.getITEMOBJ());
    }

    @Override
    public IPSDEUILogicLink createPSDEUILogicLink(PSDELogicLink psDELogicLink) throws Exception {
        String strObj = this.psFDLogicType.getITEMOBJ2();
        if (StringHelper.isNullOrEmpty((String)strObj)) {
            strObj = this.psFDLogicType.getITEMOBJ();
        }
        return (IPSDEUILogicLink)ObjectHelper.Create((String)strObj);
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

