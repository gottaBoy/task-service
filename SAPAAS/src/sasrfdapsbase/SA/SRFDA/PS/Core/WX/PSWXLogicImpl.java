/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswx.core.IWXEntApp
 */
package SA.SRFDA.PS.Core.WX;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.WX.IPSWXAccount;
import SA.SRFDA.PS.Core.WX.IPSWXEntApp;
import SA.SRFDA.PS.Core.WX.IPSWXLogic;
import SA.SRFDA.PS.Core.WX.IPSWXMenuFunc;
import SA.SRFDA.PS.Core.WX.PSWXAccountObjectImpl;
import SA.SRFDA.PS.Data.PSWXLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswx.core.IWXEntApp;

public class PSWXLogicImpl
extends PSWXAccountObjectImpl
implements IPSWXLogic {
    protected PSWXLogic psWXLogic = null;
    private IPSDataEntity iPSDataEntity = null;
    private IPSDEAction iPSDEAction = null;
    private IPSWXMenuFunc iPSWXMenuFunc = null;
    private String strCodeName = null;
    private String strEventType = null;
    private IPSWXEntApp iPSWXEntApp = null;
    private String strUserTag = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSWXAccount iPSWXAccount, IPSWXEntApp iPSWXEntApp, PSWXLogic psWXLogic) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSWXAccount(iPSWXAccount);
        this.iPSWXEntApp = iPSWXEntApp;
        this.psWXLogic = psWXLogic;
        this.setId(this.psWXLogic.getPSWXLOGICID());
        this.setName(this.psWXLogic.getPSWXLOGICNAME());
        this.setPSObjectData(this.psWXLogic);
        this.strCodeName = this.psWXLogic.getCODENAME();
        this.strEventType = this.psWXLogic.getEVENTTYPE();
        this.strUserTag = this.psWXLogic.getUSERTAG();
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        String strPSSysSFPluginId = this.psWXLogic.getPSSYSSFPLUGINID();
        if (!StringHelper.isNullOrEmpty((String)strPSSysSFPluginId)) {
            this.iPSSysSFPlugin = this.getPSWXAccount().getPSSystem().getPSSysSFPlugin(strPSSysSFPluginId);
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSWXAccount().getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSWXAccount().getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        this.iPSDataEntity = this.getPSWXAccount().getPSSystem().getPSDataEntity2(this.psWXLogic.getPSDEID());
        this.iPSDEAction = this.getPSDataEntity().getPSDEAction(this.psWXLogic.getPSDEACTIONID());
        if (!StringHelper.isNullOrEmpty((String)this.psWXLogic.getPSWXMENUFUNCID())) {
            this.iPSWXMenuFunc = this.getPSWXEntApp() != null ? this.getPSWXEntApp().getPSWXMenuFunc(this.psWXLogic.getPSWXMENUFUNCID()) : this.getPSWXAccount().getPSWXMenuFunc(this.psWXLogic.getPSWXMENUFUNCID());
        }
        super.onInit();
    }

    @PSModelRTMeta(description="\u4e8b\u4ef6\u7c7b\u578b")
    public String getEventType() {
        return this.strEventType;
    }

    public String getDEName() {
        return this.getPSDataEntity().getName();
    }

    public String getDEActionName() {
        return this.getPSDEAction().getName();
    }

    public String getWXFunc() {
        if (this.getPSWXMenuFunc() != null) {
            return this.getPSWXMenuFunc().getWXMenuFuncType();
        }
        return null;
    }

    @PSModelRTMeta(description="\u70b9\u51fb\u6807\u8bb0")
    public String getClickTag() {
        if (this.getPSWXMenuFunc() != null) {
            return this.getPSWXMenuFunc().getClickTag();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.calcCodeName();
    }

    protected String calcCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u6240\u5728\u5b9e\u4f53", dumpref=true)
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u884c\u4e3a", dumpref=true, from="IPSDataEntity")
    public IPSDEAction getPSDEAction() {
        return this.iPSDEAction;
    }

    @Override
    public IPSWXMenuFunc getPSWXMenuFunc() {
        return this.iPSWXMenuFunc;
    }

    @Override
    public IPSWXEntApp getPSWXEntApp() {
        return this.iPSWXEntApp;
    }

    public IWXEntApp getWXEntApp() {
        return this.getPSWXEntApp();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb0")
    public String getUserTag() {
        if (StringHelper.isNullOrEmpty((String)this.strUserTag)) {
            return this.getCodeName();
        }
        return this.strUserTag;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }
}

