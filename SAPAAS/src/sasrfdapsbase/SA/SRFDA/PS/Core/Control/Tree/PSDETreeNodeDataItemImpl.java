/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTO;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTOField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodReturn;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETree;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeColumn;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeDEFColumn;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeDataSetNode;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeDataItem;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.Data.PSDataItemImpl;
import SA.SRFDA.PS.Core.IPSSystemSetting;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSDETreeNodeColumn;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDETreeNodeDataItemImpl
extends PSDataItemImpl
implements IPSDETreeNodeDataItem {
    private static final Log log = LogFactory.getLog(PSDETreeNodeDataItemImpl.class);
    private IPSDETreeNode iPSDETreeNode = null;
    private PSDETreeNodeColumn psDETreeNodeColumn = null;
    private boolean bDataAccessAction = false;
    private String strPrivilegeId = null;
    private IPSDETreeColumn iPSDETreeColumn = null;
    private IPSDEField iPSDEField = null;
    private IPSAppDEField iPSAppDEField = null;
    private String strCLConvertMode = null;
    private String strPSCodeListId = null;
    private boolean bEnableItemPriv = false;
    private String strItemPrivId = null;
    private IPSCodeList frontPSCodeList = null;
    private boolean bCustomCode = false;
    private String strScriptCode = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDETreeNode iPSDETreeNode, PSDETreeNodeColumn psDETreeNodeColumn) throws Exception {
        try {
            String strValueFormat;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDETreeNode = iPSDETreeNode;
            this.psDETreeNodeColumn = psDETreeNodeColumn;
            this.setId(this.psDETreeNodeColumn.getPSDETREENODECOLID());
            this.setName(this.psDETreeNodeColumn.getPSDETREENODECOLNAME().toLowerCase());
            if (!StringHelper.isNullOrEmpty((String)this.psDETreeNodeColumn.getPSDETREECOLID())) {
                this.iPSDETreeColumn = this.getPSDETree().getPSDETreeColumn(this.psDETreeNodeColumn.getPSDETREECOLID());
                if (!this.getPSDETreeNode().getPSDETree().getPSAppView().getPSApplication().isEnableUIModelEx()) {
                    this.setName(this.iPSDETreeColumn.getName().toLowerCase());
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDETreeNodeColumn.getPSDEFID())) {
                if (this.getPSDETreeNode().getPSDataEntity() == null) {
                    throw new Exception("\u6811\u8282\u70b9\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5bf9\u8c61");
                }
                this.iPSDEField = this.getPSDETreeNode().getPSDataEntity().getPSDEField(this.psDETreeNodeColumn.getPSDEFID());
                if (this.iPSDEField != null && this.getPSDETreeNode().getPSAppDataEntity() != null) {
                    this.iPSAppDEField = this.getPSDETreeNode().getPSAppDataEntity().getPSAppDEField(this.iPSDEField.getId(), true);
                }
            }
            if (this.getPSDEField() == null) {
                if (this.getPSDETreeNode().getPSDataEntity() == null) {
                    throw new Exception("\u6811\u8282\u70b9\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5bf9\u8c61");
                }
                this.iPSDEField = this.getPSDETreeNode().getPSDataEntity().getPSDEField(this.getName(), true);
                if (this.iPSDEField != null && this.getPSDETreeNode().getPSAppDataEntity() != null) {
                    this.iPSAppDEField = this.getPSDETreeNode().getPSAppDataEntity().getPSAppDEField(this.iPSDEField, true);
                }
            }
            boolean bUseDTO = false;
            if (this.getPSDETree() != null && this.getPSDETree().getPSAppView().getPSApplication() != null) {
                bUseDTO = this.getPSDETree().getPSAppView().getPSApplication().isUseServiceApi();
            }
            if (this.getPSDEField() != null) {
                this.setDataType(this.getPSDEField().getStdDataType());
                this.bEnableItemPriv = this.getPSDEField().isEnablePrivilege();
                if (!this.psDETreeNodeColumn.isENABLEITEMPRIVNull()) {
                    this.bEnableItemPriv = this.psDETreeNodeColumn.getENABLEITEMPRIV();
                }
                if (this.bEnableItemPriv) {
                    this.strItemPrivId = StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEField().getPSDataEntity().getName(), (Object)this.getPSDEField().getName());
                }
            }
            if (!bUseDTO) {
                if (this.getPSSystemSetting() != null) {
                    this.setFormat(this.getPSSystemSetting().getValueFormat());
                }
            } else {
                this.setFormat("");
            }
            if (!StringHelper.isNullOrEmpty((String)(strValueFormat = this.psDETreeNodeColumn.getVALUEFORMAT()))) {
                this.setFormat(strValueFormat);
            }
            IPSCodeList iPSCodeList = null;
            this.strPSCodeListId = this.psDETreeNodeColumn.getPSCODELISTID();
            this.strCLConvertMode = this.psDETreeNodeColumn.getCLCONVERTMODE();
            if (StringHelper.compare((String)this.getCLConvertMode(), (String)"NONE", (boolean)true) == 0) {
                this.strPSCodeListId = "";
            }
            if (!StringHelper.isNullOrEmpty((String)this.getPSCodeListId())) {
                iPSCodeList = this.getPSDETree().getPSDataEntity().getPSSystem().getPSCodeList(this.getPSCodeListId());
                if (iPSCodeList != null) {
                    iPSCodeList = this.getPSDETree().getPSAppView().getPSApplication().getPSCodeList(iPSCodeList, true);
                }
                if (StringHelper.isNullOrEmpty((String)this.getCLConvertMode())) {
                    this.strCLConvertMode = this.getPSDETree().getPSAppView().getPSApplication().isUseServiceApi() ? "FRONT" : (iPSCodeList.isEnableDynaSys() || StringHelper.compare((String)iPSCodeList.getCodeListType(), (String)"DYNAMIC", (boolean)true) == 0 ? "BACKEND" : "FRONT");
                }
            }
            if (iPSCodeList == null) {
                this.strCLConvertMode = "NONE";
            } else if (StringHelper.compare((String)this.getCLConvertMode(), (String)"BACKEND", (boolean)true) == 0) {
                this.setPSCodeList(iPSCodeList);
            } else if (StringHelper.compare((String)this.getCLConvertMode(), (String)"FRONT", (boolean)true) == 0) {
                this.setFrontPSCodeList(iPSCodeList);
            }
            if (this.isEnableItemPriv()) {
                this.setPrivilegeId(this.getItemPrivId());
            }
            if (!this.psDETreeNodeColumn.isCUSTOMMODENull()) {
                this.setCustomCode(this.psDETreeNodeColumn.getCUSTOMMODE());
                if (this.isCustomCode()) {
                    this.setScriptCode(this.psDETreeNodeColumn.getCUSTOMCODE());
                }
            }
            this.onInit();
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            throw ex;
        }
    }

    @PSModelRTMeta(description="\u6570\u636e\u8bbf\u95ee\u63a7\u5236\u6570\u636e\u9879", ignoredumpvalues="false")
    public boolean isDataAccessAction() {
        return this.bDataAccessAction;
    }

    public void setDataAccessAction(boolean bDataAccessAction) {
        this.bDataAccessAction = bDataAccessAction;
    }

    @PSModelRTMeta(description="\u9879\u6743\u9650\u6807\u8bc6", hideempty2=true)
    public String getPrivilegeId() {
        return this.strPrivilegeId;
    }

    public void setPrivilegeId(String strPrivilegeId) {
        this.strPrivilegeId = strPrivilegeId;
    }

    @Override
    public String getModelId() {
        if (this.getPSDETreeNode() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDETreeNode().getModelId(), (Object)this.getName());
        }
        return super.getModelId();
    }

    @Override
    public String getModelType() {
        return "PSDETREENODEDATAITEM";
    }

    @Override
    public IPSDETreeNode getPSDETreeNode() {
        return this.iPSDETreeNode;
    }

    public IPSDETree getPSDETree() {
        return this.getPSDETreeNode().getPSDETree();
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.getPSDETree() != null) {
            return this.getPSDETree().getPSSysModelInstId();
        }
        return super.getPSSysModelInstId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDETree().getPSAppView().getPSApplication().getPSSystem());
    }

    protected IPSSystemSetting getPSSystemSetting() {
        return (IPSSystemSetting)((Object)this.getPSSystemUtil());
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDETreeNode().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    @PSModelRTMeta(description="\u6811\u89c6\u56fe\u5217", dumpref=true, from="IPSDETree", fields={"PSDETREECOLID"})
    public IPSDETreeColumn getPSDETreeColumn() {
        return this.iPSDETreeColumn;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027")
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSDETreeNode", from_method="getPSAppDataEntityMust().getPSAppDEField", fields={"PSDEFID"})
    public IPSAppDEField getPSAppDEField() {
        return this.iPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u8f93\u51fa\u6a21\u5f0f", codelist="CLConvertModes", hideempty2=true)
    public String getCLConvertMode() {
        return this.strCLConvertMode;
    }

    @Override
    public String getPSCodeListId() {
        return this.strPSCodeListId;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u9879\u6743\u9650\u63a7\u5236", ignoredumpvalues="false")
    public boolean isEnableItemPriv() {
        return this.bEnableItemPriv;
    }

    protected void setEnableItemPriv(boolean bEnableItemPriv) {
        this.bEnableItemPriv = bEnableItemPriv;
    }

    @Override
    public String getItemPrivId() {
        return this.strItemPrivId;
    }

    protected void setItemPrivId(String strItemPrivId) {
        this.strItemPrivId = strItemPrivId;
    }

    @Override
    public String getOriginDefaultValue() {
        return this.psDETreeNodeColumn.getDEFAULTVALUE();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c", hideempty2=true)
    public String getDefaultValue() {
        if (!StringHelper.isNullOrEmpty((String)this.getOriginDefaultValue())) {
            return this.getOriginDefaultValue();
        }
        if (this.getPSDETreeColumn() != null && this.getPSDETreeColumn() instanceof IPSDETreeDEFColumn) {
            return ((IPSDETreeDEFColumn)this.getPSDETreeColumn()).getDefaultValue();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u4ee3\u7801\u8868", hideempty=true, dumpref=true)
    public IPSCodeList getFrontPSCodeList() {
        return this.frontPSCodeList;
    }

    public void setFrontPSCodeList(IPSCodeList iPSCodeList) {
        this.frontPSCodeList = iPSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801\u6a21\u5f0f", ignoredumpvalues="false")
    public boolean isCustomCode() {
        return this.bCustomCode;
    }

    public void setCustomCode(boolean bCustomCode) {
        this.bCustomCode = bCustomCode;
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801")
    public String getScriptCode() {
        return this.strScriptCode;
    }

    public void setScriptCode(String strScriptCode) {
        this.strScriptCode = strScriptCode;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u7c7b\u578b", codelist="EditorValueType", ignoredumpvalues="SIMPLE")
    public String getValueType() {
        block7: {
            IPSAppDEMethodDTOField iPSAppDEMethodDTOField;
            block10: {
                block9: {
                    block8: {
                        if (this.getPSAppDEField() == null) {
                            return null;
                        }
                        IPSAppDEMethodDTO iPSAppDEMethodDTO;
                        try {
                           iPSAppDEMethodDTO = this.getPSAppDEMethodDTO();
                           if (iPSAppDEMethodDTO == null || (iPSAppDEMethodDTOField = iPSAppDEMethodDTO.getPSAppDEMethodDTOField(this.getPSAppDEField(), true)) == null) break block7;
                        }
                        catch (Exception ex) {
                           log.error((Object)ex);
                           break block7;
                        }
                        if (!"SIMPLE".equals(iPSAppDEMethodDTOField.getType())) break block8;
                        return "SIMPLE";
                    }
                    if (!"SIMPLES".equals(iPSAppDEMethodDTOField.getType())) break block9;
                    return "SIMPLES";
                }
                if (!"DTOS".equals(iPSAppDEMethodDTOField.getType())) break block10;
                return "OBJECTS";
            }
            try {
                if ("DTO".equals(iPSAppDEMethodDTOField.getType())) {
                    return "OBJECT";
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        return null;
    }

    protected IPSAppDEMethodDTO getPSAppDEMethodDTO() throws Exception {
        IPSAppDEMethodReturn iPSAppDEMethodReturn;
        IPSDETreeDataSetNode iPSDETreeDataSetNode;
        if (this.getPSDETreeNode() instanceof IPSDETreeDataSetNode && (iPSDETreeDataSetNode = (IPSDETreeDataSetNode)this.getPSDETreeNode()).getPSAppDEDataSet() != null && ("DTO".equals((iPSAppDEMethodReturn = iPSDETreeDataSetNode.getPSAppDEDataSet().getPSAppDEMethodReturn()).getType()) || "DTOS".equals(iPSAppDEMethodReturn.getType()) || "PAGE".equals(iPSAppDEMethodReturn.getType()))) {
            return iPSAppDEMethodReturn.getPSAppDEMethodDTO();
        }
        return null;
    }
}

