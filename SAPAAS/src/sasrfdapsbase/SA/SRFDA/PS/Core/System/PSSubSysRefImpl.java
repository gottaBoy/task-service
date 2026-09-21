/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.System;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.SubSys.IPSSubSys;
import SA.SRFDA.PS.Core.SubSys.IPSSubSysSF;
import SA.SRFDA.PS.Core.SubSys.IPSSubSysVer;
import SA.SRFDA.PS.Core.System.IPSSubSysRef;
import SA.SRFDA.PS.Core.System.IPSSysRefDE;
import SA.SRFDA.PS.Data.PSSysRef;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSSubSysRefImpl
extends PSSystemObjectImpl
implements IPSSubSysRef {
    private static final Log log = LogFactory.getLog(PSSubSysRefImpl.class);
    protected PSSysRef psSysRef = null;
    protected HashMap<String, IPSSysRefDE> psSysRefDEMap = new HashMap();
    protected IPSSubSys iPSSubSys = null;
    protected IPSSubSysVer iPSSubSysVer = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysRef psSysRef) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSSystem(iPSSystem);
        this.psSysRef = psSysRef;
        this.setId(this.psSysRef.getPSSYSREFID());
        this.setName(this.psSysRef.getPSSYSREFNAME());
        this.setPSObjectData(this.psSysRef);
        if (this.psSysRef.getVERSION() > 0) {
            this.setVersion(this.psSysRef.getVERSION());
        }
        if (!StringHelper.IsNullOrEmpty((String)psSysRef.getPSSUBSYSID())) {
            this.iPSSubSys = this.getPSModelStorage().getPSSubSys(psSysRef.getPSSUBSYSID());
            if (this.getVersion() > 0) {
                this.iPSSubSysVer = this.iPSSubSys.getPSSubSysVerByVer(this.getVersion());
            }
        }
        this.onInit();
    }

    @Override
    public IPSSubSys getPSSubSys() {
        return this.iPSSubSys;
    }

    @Override
    public String getPKGCodeName(String strPSSFStyleId) throws Exception {
        IPSSubSysSF iPSSubSysSF = this.getPSSubSys().getPSSubSysSFBySFStyle(strPSSFStyleId, false);
        return StringHelper.Format((String)"%1$s.srv", (Object)iPSSubSysSF.getPKGCodeName()).toLowerCase();
    }

    @Override
    public IPSSubSysVer getPSSubSysVer() {
        return this.iPSSubSysVer;
    }

    @Override
    public String getModelType() {
        return "PSSYSREF";
    }
}

