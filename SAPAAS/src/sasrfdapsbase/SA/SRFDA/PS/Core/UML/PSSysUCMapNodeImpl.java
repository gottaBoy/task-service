/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.UML;

import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.UML.IPSSysActor;
import SA.SRFDA.PS.Core.UML.IPSSysUCMap;
import SA.SRFDA.PS.Core.UML.IPSSysUCMapNode;
import SA.SRFDA.PS.Core.UML.IPSSysUseCase;
import SA.SRFDA.PS.Data.PSSysUCMapNode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysUCMapNodeImpl
extends PSObjectImpl
implements IPSSysUCMapNode {
    private static final Log log = LogFactory.getLog(PSSysUCMapNodeImpl.class);
    protected PSSysUCMapNode psSysUCMapNode = null;
    private IPSSysUCMap iPSSysUCMap = null;
    private int nLeftPos = 100;
    private int nTopPos = 100;
    private String strNodeType = null;
    private IPSSysActor iPSSysActor = null;
    private IPSSysUseCase iPSSysUseCase = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysUCMap iPSSysUCMap, PSSysUCMapNode psSysUCMapNode) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSSysUCMap = iPSSysUCMap;
            this.psSysUCMapNode = psSysUCMapNode;
            this.setId(this.psSysUCMapNode.getPSSYSUCMAPNODEID());
            this.setName(this.psSysUCMapNode.getPSSYSUCMAPNODENAME());
            this.setPSObjectData(this.psSysUCMapNode);
            if (!this.psSysUCMapNode.isLEFTPOSNull() && this.psSysUCMapNode.getLEFTPOS() > 0) {
                this.nLeftPos = this.psSysUCMapNode.getLEFTPOS();
            }
            if (!this.psSysUCMapNode.isTOPPOSNull() && this.psSysUCMapNode.getTOPPOS() > 0) {
                this.nTopPos = this.psSysUCMapNode.getTOPPOS();
            }
            this.setNodeType(this.psSysUCMapNode.getNODETYPE());
            if (StringHelper.compare((String)"\u64cd\u4f5c\u8005", (String)this.getNodeType(), (boolean)false) == 0) {
                this.setNodeType("ACTOR");
            } else if (StringHelper.compare((String)"\u7528\u4f8b", (String)this.getNodeType(), (boolean)false) == 0) {
                this.setNodeType("USECASE");
            }
            if (StringHelper.compare((String)this.getNodeType(), (String)"ACTOR", (boolean)false) == 0) {
                if (StringHelper.isNullOrEmpty((String)this.psSysUCMapNode.getPSSYSACTORID())) {
                    throw new Exception("\u672a\u6307\u5b9a\u64cd\u4f5c\u8005");
                }
            } else if (StringHelper.compare((String)this.getNodeType(), (String)"USECASE", (boolean)false) == 0) {
                if (StringHelper.isNullOrEmpty((String)this.psSysUCMapNode.getPSSYSUSERCASEID())) {
                    throw new Exception("\u672a\u6307\u5b9a\u7528\u4f8b");
                }
            } else {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u8282\u70b9\u7c7b\u578b[%1$s]", (Object)this.getNodeType()));
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
    public IPSSysUCMap getPSSysUCMap() {
        return this.iPSSysUCMap;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysUCMap().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u7c7b\u578b", codelist="UCMapNodeType")
    public String getNodeType() {
        return this.strNodeType;
    }

    protected void setNodeType(String strNodeType) {
        this.strNodeType = strNodeType;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u64cd\u4f5c\u8005", hideempty=true, dumpref=true)
    public IPSSysActor getPSSysActor() throws Exception {
        if (this.iPSSysActor != null) {
            return this.iPSSysActor;
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysUCMapNode.getPSSYSACTORID())) {
            this.iPSSysActor = this.getPSSysUCMap().getPSSystem().getPSSysActor(this.psSysUCMapNode.getPSSYSACTORID());
        }
        return this.iPSSysActor;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u7528\u4f8b", hideempty=true, dumpref=true)
    public IPSSysUseCase getPSSysUseCase() throws Exception {
        if (this.iPSSysUseCase != null) {
            return this.iPSSysUseCase;
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysUCMapNode.getPSSYSUSERCASEID())) {
            this.iPSSysUseCase = this.getPSSysUCMap().getPSSystem().getPSSysUseCase(this.psSysUCMapNode.getPSSYSUSERCASEID());
        }
        return this.iPSSysUseCase;
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
        return (IPSSystemUtil)((Object)this.getPSSysUCMap().getPSSystem());
    }

    @Override
    public String getModelType() {
        return "PSSYSUCMAPNODE";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysUCMap().getModelId(), (Object)super.getModelId());
    }
}

