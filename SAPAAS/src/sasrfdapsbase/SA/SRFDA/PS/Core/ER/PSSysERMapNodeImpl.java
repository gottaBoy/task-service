/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.ER;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.ER.IPSERMap;
import SA.SRFDA.PS.Core.ER.IPSSysERMap;
import SA.SRFDA.PS.Core.ER.IPSSysERMapNode;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSSysERMapNode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysERMapNodeImpl
extends PSObjectImpl
implements IPSSysERMapNode {
    private static final Log log = LogFactory.getLog(PSSysERMapNodeImpl.class);
    protected PSSysERMapNode psSysERMapNode = null;
    private IPSSysERMap iPSSysERMap = null;
    private int nLeftPos = 100;
    private int nTopPos = 100;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysERMap iPSSysERMap, PSSysERMapNode psSysERMapNode) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSSysERMap = iPSSysERMap;
            this.psSysERMapNode = psSysERMapNode;
            this.setId(this.psSysERMapNode.getPSSYSERMAPNODEID());
            this.setName(this.psSysERMapNode.getPSSYSERMAPNODENAME());
            this.setPSObjectData(this.psSysERMapNode);
            if (!this.psSysERMapNode.isLEFTPOSNull() && this.psSysERMapNode.getLEFTPOS() > 0) {
                this.nLeftPos = this.psSysERMapNode.getLEFTPOS();
            }
            if (!this.psSysERMapNode.isTOPPOSNull() && this.psSysERMapNode.getTOPPOS() > 0) {
                this.nTopPos = this.psSysERMapNode.getTOPPOS();
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    public IPSSysERMap getPSSysERMap() {
        return this.iPSSysERMap;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysERMap().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", dumpref=true)
    public IPSDataEntity getPSDataEntity() throws Exception {
        return this.getPSSysERMap().getPSSystem().getPSDataEntity2(this.psSysERMapNode.getPSDEID());
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u65b9\u4f4d\u7f6e")
    public int getLeftPos() {
        return this.nLeftPos;
    }

    @Override
    @PSModelRTMeta(description="\u5de6\u4fa7\u4f4d\u7f6e")
    public int getTopPos() {
        return this.nTopPos;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysERMap().getPSSystem());
    }

    @Override
    public IPSERMap getPSERMap() {
        return this.getPSSysERMap();
    }

    @Override
    public String getModelType() {
        return "PSSYSERMAPNODE";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysERMap().getModelId(), (Object)super.getModelId());
    }
}

