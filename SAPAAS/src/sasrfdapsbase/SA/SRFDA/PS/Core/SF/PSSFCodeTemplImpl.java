/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.SF.IPSSFCodeTempl;
import SA.SRFDA.PS.Core.SF.IPSSFCodeType;
import SA.SRFDA.PS.Data.PSSFCodeTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFCodeTemplImpl
extends PSObjectImpl
implements IPSSFCodeTempl {
    protected PSSFCodeTempl psSFCodeTempl = null;
    private static final Log log = LogFactory.getLog(PSSFCodeTemplImpl.class);
    protected IPSSFCodeType iPSSFCodeType = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSFCodeType iPSSFCodeType, PSSFCodeTempl psSFCodeTempl) throws Exception {
        this.psSFCodeTempl = psSFCodeTempl;
        this.iPSSFCodeType = iPSSFCodeType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psSFCodeTempl.getPSSFCODETEMPLID());
        this.setName(this.psSFCodeTempl.getPSSFCODETEMPLNAME());
        this.setPSObjectData(this.psSFCodeTempl);
        this.onInit();
    }

    @Override
    public PSSFCodeTempl getPSSFCodeTemplData() {
        return this.psSFCodeTempl;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSSFCodeType.getPSSysModelInstId();
    }

    @Override
    public String getTemplDocUrl() {
        if (StringHelper.IsNullOrEmpty((String)this.iPSSFCodeType.getPSSFStyle().getTemplDocRootUrl())) {
            return "http://www.ibizsys.net";
        }
        String strFileName = null;
        strFileName = StringHelper.IsNullOrEmpty((String)this.iPSSFCodeType.getFileExt()) ? StringHelper.Format((String)"%1$s", (Object)this.getName()) : StringHelper.Format((String)"%1$s.%2$s", (Object)this.getName(), (Object)this.iPSSFCodeType.getFileExt());
        return StringHelper.Format((String)"%1$s%2$s%3$s%2$s%4$s", (Object)this.iPSSFCodeType.getPSSFStyle().getTemplDocRootUrl(), (Object)"/", (Object)this.iPSSFCodeType.getTypeCode(), (Object)strFileName);
    }

    @Override
    public String getTemplDesc() {
        return this.psSFCodeTempl.getTEMPLDESC();
    }

    @Override
    public String getLogicName() {
        return this.psSFCodeTempl.getLOGICNAME();
    }
}

