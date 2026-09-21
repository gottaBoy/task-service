/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.WF.IPSWFLinkCond;
import SA.SRFDA.PS.Core.WF.IPSWFLinkCondType;
import SA.SRFDA.PS.Data.PSWFLinkCond;
import SA.SRFDA.PS.Data.PSWFLinkCondType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSWFLinkCondTypeImpl
extends PSObjectImpl
implements IPSWFLinkCondType {
    protected PSWFLinkCondType psWFLinkCondType = null;
    private static final Log log = LogFactory.getLog(PSWFLinkCondTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSWFLinkCondType psWFLinkCondType) throws Exception {
        this.psWFLinkCondType = psWFLinkCondType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psWFLinkCondType.getPSWFLINKCONDTYPEID());
        this.setName(psWFLinkCondType.getPSWFLINKCONDTYPENAME());
        this.setPSObjectData(this.psWFLinkCondType);
        this.onInit();
    }

    @Override
    public IPSWFLinkCond createPSWFLinkCond(PSWFLinkCond psWFLinkCond) throws Exception {
        return (IPSWFLinkCond)ObjectHelper.Create((String)this.psWFLinkCondType.getITEMOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

