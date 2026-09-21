/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFPluginTempl;
import SA.SRFDA.PS.Data.PSSFPluginTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFPluginTemplImpl
extends PSObjectImpl
implements IPSSFPluginTempl {
    protected PSSFPluginTempl psSFPluginTempl = null;
    private static final Log log = LogFactory.getLog(PSSFPluginTemplImpl.class);
    private IPSSF iPSSF = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSSFPluginTempl psSFPluginTempl) throws Exception {
        this.psSFPluginTempl = psSFPluginTempl;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psSFPluginTempl.getPSSFPLUGINTEMPLID());
        this.setName(this.psSFPluginTempl.getPSSFPLUGINTEMPLNAME());
        this.setPSObjectData(this.psSFPluginTempl);
        this.iPSSF = this.getPSModelStorage().getPSSF(this.psSFPluginTempl.getPSSFID());
        this.onInit();
    }

    @Override
    public String getCode(String strCodeTag) {
        String strCodeTag2 = StringHelper.format((String)"TEMPL%1$s", (Object)strCodeTag);
        return this.psSFPluginTempl.getParamStringValue(strCodeTag2, "");
    }

    @Override
    public String getModelType() {
        return "PSSFPLUGINTEMPL";
    }

    @Override
    public IPSSF getPSSF() {
        return this.iPSSF;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public BaseDataEntity getPSSFPluginTemplData() {
        return this.psSFPluginTempl;
    }
}

