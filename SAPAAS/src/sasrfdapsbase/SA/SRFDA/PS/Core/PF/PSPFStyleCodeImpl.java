/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFStyleCode;
import SA.SRFDA.PS.Core.PF.PSPFObjectImpl;
import SA.SRFDA.PS.Data.PSPFStyleCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFStyleCodeImpl
extends PSPFObjectImpl
implements IPSPFStyleCode {
    protected PSPFStyleCode psPFStyleCode = null;
    protected IPSPFStyle iPSPFStyle = null;
    private static final Log log = LogFactory.getLog(PSPFStyleCodeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPFStyle iPSPFStyle, PSPFStyleCode psPFStyleCode) throws Exception {
        this.psPFStyleCode = psPFStyleCode;
        this.iPSPFStyle = iPSPFStyle;
        this.setPSPF(this.iPSPFStyle.getPSPF());
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psPFStyleCode.getPSPFSTYLECODEID());
        this.setName(this.psPFStyleCode.getPSPFSTYLECODENAME());
        this.setPSObjectData(this.psPFStyleCode);
        this.onInit();
    }

    @Override
    public String getStyleCode() {
        return this.psPFStyleCode.getSTYLECODE();
    }

    @Override
    public IPSPFStyle getPSPFStyle() {
        return this.iPSPFStyle;
    }

    @Override
    public String getTemplDocUrl() {
        if (StringHelper.IsNullOrEmpty((String)this.getPSPFStyle().getTemplDocRootUrl())) {
            return "http://www.ibizsys.net";
        }
        String strPSPFStyleCodeFolder = StringHelper.Format((String)"%1$s%2$smacro", (Object)this.getPSPFStyle().getTemplDocRootUrl(), (Object)"/");
        String strFileName = StringHelper.Format((String)"%1$s.txt", (Object)this.getName().toUpperCase());
        return StringHelper.Format((String)"%1$s%2$s%3$s", (Object)strPSPFStyleCodeFolder, (Object)"/", (Object)strFileName);
    }
}

