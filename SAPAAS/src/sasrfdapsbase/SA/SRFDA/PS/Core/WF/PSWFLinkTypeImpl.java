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
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import SA.SRFDA.PS.Core.WF.IPSWFLinkType;
import SA.SRFDA.PS.Data.PSWFLink;
import SA.SRFDA.PS.Data.PSWFLinkType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSWFLinkTypeImpl
extends PSObjectImpl
implements IPSWFLinkType {
    protected PSWFLinkType psWFLinkType = null;
    private static final Log log = LogFactory.getLog(PSWFLinkTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSWFLinkType psWFLinkType) throws Exception {
        this.psWFLinkType = psWFLinkType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psWFLinkType.getPSWFLINKTYPEID());
        this.setName(psWFLinkType.getPSWFLINKTYPENAME());
        this.setPSObjectData(this.psWFLinkType);
        this.onInit();
    }

    @Override
    public IPSWFLink createPSWFLink(PSWFLink psWFLink) throws Exception {
        return (IPSWFLink)ObjectHelper.Create((String)this.psWFLinkType.getITEMOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

