/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEMSLogicLinkImpl;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainStateAction;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainStateField;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainStateOPPriv;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDELogicLink;
import SA.SRFDA.PS.Data.PSDELogicNode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEMSLogicNodeImpl
extends PSObjectImpl
implements IPSDEMSLogicNode {
    private static final Log log = LogFactory.getLog(PSDEMSLogicNodeImpl.class);
    protected PSDELogicNode psDELogicNode;
    protected IPSDEMSLogic iPSDEMSLogic;
    protected ArrayList<IPSDEMSLogicLink> psDEMSLogicLinkList = new ArrayList();
    private IPSDEMainState iPSDEMainState = null;
    private boolean bDefaultMode = false;
    private boolean bActionAllowMode = false;
    private boolean bOPPrivAllowMode = false;
    private boolean bFieldAllowMode = false;
    private String strStateValue = null;
    private List<String> actionTagList = null;
    private List<String> opPrivTagList = null;
    private List<String> fieldList = null;
    private int nOrderValue = 99999;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEMSLogic iPSDEMSLogic, PSDELogicNode psDELogicNode) throws Exception {
        try {
            Iterator<IPSDEMainStateField> psDEMainStateFields;
            Iterator<IPSDEMainStateOPPriv> psDEMainStateOPPrivs;
            Iterator<IPSDEMainStateAction> psDEMainStateActions;
            String strField;
            int n;
            int n2;
            String[] stringArray;
            String[] fields;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEMSLogic = iPSDEMSLogic;
            this.psDELogicNode = psDELogicNode;
            this.setId(this.psDELogicNode.getPSDELOGICNODEID());
            this.setName(this.psDELogicNode.getPSDELOGICNODENAME());
            this.setPSObjectData(this.psDELogicNode);
            if (this.getPSDEMainState() == null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDELogicNode.getPSDEMAINSTATEID())) {
                this.iPSDEMainState = this.getPSDEMSLogic().getPSDataEntity().getPSDEMainState(this.psDELogicNode.getPSDEMAINSTATEID());
            }
            if (!this.psDELogicNode.isPARAM9Null()) {
                this.bDefaultMode = this.psDELogicNode.getPARAM9();
            } else if (this.getPSDEMainState() != null) {
                this.bDefaultMode = this.getPSDEMainState().isDefault();
            }
            if (!this.psDELogicNode.isPARAM7Null()) {
                this.bActionAllowMode = this.psDELogicNode.getPARAM7() == 1;
            } else if (this.getPSDEMainState() != null) {
                this.bActionAllowMode = this.getPSDEMainState().isActionAllowMode();
            }
            if (!this.psDELogicNode.isPARAM8Null()) {
                this.bOPPrivAllowMode = this.psDELogicNode.getPARAM8() == 1;
            } else if (this.getPSDEMainState() != null) {
                this.bOPPrivAllowMode = this.getPSDEMainState().isOPPrivAllowMode();
            }
            if (!this.psDELogicNode.isPARAM10Null()) {
                this.bFieldAllowMode = this.psDELogicNode.getPARAM10();
            } else if (this.getPSDEMainState() != null) {
                this.bFieldAllowMode = this.getPSDEMainState().isFieldAllowMode();
            }
            this.strStateValue = psDELogicNode.getPARAM1();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strStateValue)) {
                this.strStateValue = this.getCodeName();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDELogicNode.getPARAM4())) {
                fields = this.psDELogicNode.getPARAM4().toUpperCase().split("[;]");
                this.actionTagList = new ArrayList<String>();
                stringArray = fields;
                n2 = fields.length;
                n = 0;
                while (n < n2) {
                    strField = stringArray[n];
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(strField = strField.trim())) && !this.actionTagList.contains(strField)) {
                        this.actionTagList.add(strField);
                    }
                    ++n;
                }
            } else if (this.getPSDEMainState() != null && (psDEMainStateActions = this.getPSDEMainState().getPSDEMainStateActions()) != null) {
                this.actionTagList = new ArrayList<String>();
                while (psDEMainStateActions.hasNext()) {
                    IPSDEMainStateAction iPSDEMainStateAction = psDEMainStateActions.next();
                    if (iPSDEMainStateAction.getPSDEAction() != null) {
                        this.actionTagList.add(iPSDEMainStateAction.getPSDEAction().getName());
                        continue;
                    }
                    this.actionTagList.add(iPSDEMainStateAction.getName());
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDELogicNode.getPARAM5())) {
                fields = this.psDELogicNode.getPARAM5().toUpperCase().split("[;]");
                this.opPrivTagList = new ArrayList<String>();
                stringArray = fields;
                n2 = fields.length;
                n = 0;
                while (n < n2) {
                    strField = stringArray[n];
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(strField = strField.trim())) && !this.opPrivTagList.contains(strField)) {
                        this.opPrivTagList.add(strField);
                    }
                    ++n;
                }
            } else if (this.getPSDEMainState() != null && (psDEMainStateOPPrivs = this.getPSDEMainState().getPSDEMainStateOPPrivs()) != null) {
                this.opPrivTagList = new ArrayList<String>();
                while (psDEMainStateOPPrivs.hasNext()) {
                    IPSDEMainStateOPPriv iPSDEMainStateOPPriv = psDEMainStateOPPrivs.next();
                    if (iPSDEMainStateOPPriv.getPSDEOPPriv() != null) {
                        this.opPrivTagList.add(iPSDEMainStateOPPriv.getPSDEOPPriv().getName());
                        continue;
                    }
                    this.opPrivTagList.add(iPSDEMainStateOPPriv.getName());
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDELogicNode.getPARAM6())) {
                fields = this.psDELogicNode.getPARAM6().toUpperCase().split("[;]");
                this.fieldList = new ArrayList<String>();
                stringArray = fields;
                n2 = fields.length;
                n = 0;
                while (n < n2) {
                    strField = stringArray[n];
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(strField = strField.trim())) && !this.fieldList.contains(strField)) {
                        this.fieldList.add(strField);
                    }
                    ++n;
                }
            } else if (this.getPSDEMainState() != null && (psDEMainStateFields = this.getPSDEMainState().getPSDEMainStateFields()) != null) {
                this.fieldList = new ArrayList<String>();
                while (psDEMainStateFields.hasNext()) {
                    IPSDEMainStateField iPSDEMainStateField = psDEMainStateFields.next();
                    if (iPSDEMainStateField.getPSDEField() != null) {
                        this.fieldList.add(iPSDEMainStateField.getPSDEField().getName());
                        continue;
                    }
                    this.fieldList.add(iPSDEMainStateField.getName());
                }
            }
            if (!this.psDELogicNode.isORDERVALUENull() && this.psDELogicNode.getORDERVALUE() >= 0) {
                this.nOrderValue = this.psDELogicNode.getORDERVALUE();
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
    protected void onInit() throws Exception {
        super.onInit();
        this.preparePSDEMSLogicLinks();
    }

    protected void preparePSDEMSLogicLinks() throws Exception {
        this.psDEMSLogicLinkList.clear();
        ArrayList<PSDELogicLink> psDEMSLogicLinkList = this.psDELogicNode.getPSDELogicLinks(false);
        if (psDEMSLogicLinkList == null) {
            return;
        }
        for (PSDELogicLink psDELogicLink : psDEMSLogicLinkList) {
            PSDEMSLogicLinkImpl iPSDEMSLogicLink = new PSDEMSLogicLinkImpl();
            iPSDEMSLogicLink.init(this.getDAGlobalHelper(), this.iPSDEMSLogic, psDELogicLink);
            this.psDEMSLogicLinkList.add(iPSDEMSLogicLink);
        }
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u8282\u70b9\u8fde\u51fa\u8fde\u63a5\u96c6\u5408", child=true)
    public Iterator<IPSDEMSLogicLink> getPSDEMSLogicLinks() {
        if (this.psDEMSLogicLinkList == null || this.psDEMSLogicLinkList.size() == 0) {
            return null;
        }
        return this.psDEMSLogicLinkList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u8282\u70b9\u7c7b\u578b", codelist="DELogicNodeType2", fields={"LOGICNODETYPE"})
    public String getLogicNodeType() {
        return this.psDELogicNode.getLOGICNODETYPE();
    }

    @Override
    public IPSDEMSLogic getPSDEMSLogic() {
        return this.iPSDEMSLogic;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psDELogicNode.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u5e73\u884c\u8f93\u51fa", ignoredumpvalues="false")
    public boolean isParallelOutput() {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEMSLogic().getPSSysModelInstId();
    }

    @Override
    public Object getParam(String strParamName, Object objDefault) {
        Object objValue = this.psDELogicNode.getParamValue(strParamName);
        if (objValue == null) {
            return objDefault;
        }
        return objValue;
    }

    @Override
    public String getModelType() {
        return "PSDEMSLOGICNODE";
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEMSLogic().getModelId(), (Object)super.getModelId());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEMSLogic().getPSDataEntity().getPSSystem());
    }

    @Override
    public int getLogicHolder() {
        return 3;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u4e3b\u72b6\u6001", dumpref=true, from="IPSDataEntity")
    public IPSDEMainState getPSDEMainState() {
        return this.iPSDEMainState;
    }

    @Override
    @PSModelRTMeta(description="\u5de6\u4fa7\u4f4d\u7f6e", ignoredumpvalues="0", fields={"LEFTPOS"})
    public int getLeftPos() {
        return this.psDELogicNode.getLEFTPOS();
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u65b9\u4f4d\u7f6e", ignoredumpvalues="0", fields={"TOPPOS"})
    public int getTopPos() {
        return this.psDELogicNode.getTOPPOS();
    }

    @Override
    @PSModelRTMeta(description="\u5bbd\u5ea6", ignoredumpvalues="0")
    public int getWidth() {
        return this.getDefaultWidth();
    }

    @Override
    @PSModelRTMeta(description="\u9ad8\u5ea6", ignoredumpvalues="0")
    public int getHeight() {
        return this.getDefaultHeight();
    }

    protected int getDefaultWidth() {
        return 0;
    }

    protected int getDefaultHeight() {
        return 0;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u72b6\u6001", ignoredumpvalues="false", fields={"PARAM9"})
    public boolean isDefaultMode() {
        return this.bDefaultMode;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u5141\u8bb8\u6a21\u5f0f", ignoredumpvalues="false", fields={"PARAM7"})
    public boolean isActionAllowMode() {
        return this.bActionAllowMode;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u6807\u8bc6\u5141\u8bb8\u6a21\u5f0f", ignoredumpvalues="false", fields={"PARAM8"})
    public boolean isOPPrivAllowMode() {
        return this.bOPPrivAllowMode;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u5141\u8bb8\u6a21\u5f0f", ignoredumpvalues="false", fields={"PARAM10"})
    public boolean isFieldAllowMode() {
        return this.bFieldAllowMode;
    }

    @Override
    @PSModelRTMeta(description="\u72b6\u6001\u503c", fields={"PARAM1"})
    public String getStateValue() {
        return this.strStateValue;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u6807\u8bc6\u96c6\u5408", hideempty=true, child=true, fields={"PARAM5"})
    public Iterator<String> getOPPrivs() {
        if (this.opPrivTagList != null && this.opPrivTagList.size() >= 0) {
            return this.opPrivTagList.iterator();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u6807\u8bc6\u96c6\u5408", hideempty=true, child=true, fields={"PARAM4"})
    public Iterator<String> getActions() {
        if (this.actionTagList != null && this.actionTagList.size() >= 0) {
            return this.actionTagList.iterator();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u6807\u8bc6\u96c6\u5408", hideempty=true, child=true, fields={"PARAM6"})
    public Iterator<String> getFields() {
        if (this.fieldList != null && this.fieldList.size() >= 0) {
            return this.fieldList.iterator();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6837\u5f0f\u8868\u540d\u79f0", hideempty=true, fields={"PARAM11"})
    public String getCssClass() {
        return this.psDELogicNode.getPARAM11();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u666f\u989c\u8272", hideempty=true, fields={"PARAM12"})
    public String getColor() {
        return this.psDELogicNode.getPARAM12();
    }

    @Override
    @PSModelRTMeta(description="\u80cc\u666f\u989c\u8272", hideempty=true, fields={"PARAM13"})
    public String getBKColor() {
        return this.psDELogicNode.getPARAM13();
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", ignoredumpvalues="99999", fields={"ORDERVALUE"})
    public int getOrderValue() {
        return this.nOrderValue;
    }
}

