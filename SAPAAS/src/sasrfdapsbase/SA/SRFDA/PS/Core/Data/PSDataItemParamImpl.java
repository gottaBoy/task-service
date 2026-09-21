/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDAModelHelper
 *  SA.SRFDA.Ctrl.IDAModelStorage
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.data.impl.DataItemParamImpl
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Data;

import SA.SRFDA.Ctrl.IDAModelHelper;
import SA.SRFDA.Ctrl.IDAModelStorage;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.Data.IPSDataItem;
import SA.SRFDA.PS.Core.Data.IPSDataItemParam;
import SA.SRFDA.PS.Core.DynaModel.IPSDynaModel;
import SA.SRFDA.PS.Core.IPSModel;
import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.IPSModelInfo;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelStorage;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.data.impl.DataItemParamImpl;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDataItemParamImpl
extends DataItemParamImpl
implements IPSDataItemParam {
    private static final Log log = LogFactory.getLog(PSDataItemParamImpl.class);
    private int nPSObjVersion = 0;
    private ISRFDAGlobalHelper iDAGlobalHelper = null;
    private BaseDataEntity dataEntity = null;
    private Properties userParams = null;
    private IPSCodeList iPSCodeList = null;
    private IPSDEField iPSDEField = null;
    private IPSAppDEField iPSAppDEField = null;
    private IPSDataItem iPSDataItem = null;

    @Override
    @PSModelRTMeta(description="\u683c\u5f0f\u5316", hideempty2=true)
    public String getFormat() {
        return super.getFormat();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868", hideempty=true)
    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    public void setPSCodeList(IPSCodeList iPSCodeList) {
        this.iPSCodeList = iPSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027", hideempty=true)
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    public void setPSDEField(IPSDEField iPSDEField) {
        this.iPSDEField = iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty=true)
    public IPSAppDEField getPSAppDEField() {
        return this.iPSAppDEField;
    }

    public void setPSAppDEField(IPSAppDEField iPSAppDEField) {
        this.iPSAppDEField = iPSAppDEField;
    }

    public void setPSDataItem(IPSDataItem iPSDataItem) {
        this.iPSDataItem = iPSDataItem;
    }

    public IPSDataItem getPSDataItem() {
        return this.iPSDataItem;
    }

    @Override
    @PSModelRTMeta(description="\u540d\u79f0", order=100)
    public String getName() {
        return super.getName();
    }

    @Override
    public int getVersion() {
        return this.nPSObjVersion;
    }

    protected void setId(String strPSObjectId) {
        this.strId = strPSObjectId;
    }

    protected void setVersion(int nPSObjVersion) {
        this.nPSObjVersion = nPSObjVersion;
    }

    public ISRFDAGlobalHelper getDAGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    public void setDAGlobalHelper(ISRFDAGlobalHelper iDAGlobalHelper) {
        this.iDAGlobalHelper = iDAGlobalHelper;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    protected boolean isAlwaysActivePSSysModelInst() {
        return false;
    }

    protected IPSModelHelper getPSModelHelper() throws Exception {
        return PSObjectFactory.getPSModelHelper(this.iDAGlobalHelper, this.getPSSysModelInstId(), this.isAlwaysActivePSSysModelInst());
    }

    protected IPSModelHelper getPSModelHelper(String strPSSysModelInstId) throws Exception {
        return PSObjectFactory.getPSModelHelper(this.iDAGlobalHelper, strPSSysModelInstId, this.isAlwaysActivePSSysModelInst());
    }

    protected IPSModelStorage getPSModelStorage() throws Exception {
        return PSObjectFactory.getPSModelStorage(this.iDAGlobalHelper);
    }

    protected IDAModelHelper getDAModelHelper() {
        return this.getDAGlobalHelper().getDAModelHelper();
    }

    protected IDAModelStorage getDAModelStorage() {
        return this.getDAGlobalHelper().getDAModelStorage();
    }

    @Override
    public String getMemo() {
        if (this.getPSObjectData() != null) {
            return this.getPSObjectData().getParamStringValue("MEMO", "");
        }
        return "";
    }

    protected void setPSObjectData(BaseDataEntity baseDataEntity) {
        try {
            this.dataEntity = baseDataEntity;
            if (this.dataEntity == null) {
                this.userParams = null;
            } else {
                String strUserParams = this.dataEntity.getParamStringValue("USERPARAMS", "");
                if (!StringHelper.isNullOrEmpty((String)strUserParams)) {
                    this.userParams = PropertiesHelper.load((String)strUserParams);
                }
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    protected BaseDataEntity getPSObjectData() {
        return this.dataEntity;
    }

    @Override
    public Object getPSObjectParam(String strKey, Object objDefault) {
        if (this.getPSObjectData() == null) {
            return objDefault;
        }
        Object objValue = this.getPSObjectData().getParamValue(strKey);
        if (objValue == null) {
            return objDefault;
        }
        return objValue;
    }

    @Override
    public Object getUserParam(String strParamName) {
        if (this.userParams == null) {
            return null;
        }
        return PropertiesHelper.getProperty((Properties)this.userParams, (String)strParamName);
    }

    @Override
    public boolean containsUserParam(String strParamName) {
        if (this.userParams == null) {
            return false;
        }
        return PropertiesHelper.getProperty((Properties)this.userParams, (String)strParamName, null) != null;
    }

    @Override
    public String getUserParam(String strParamName, String strDefault) {
        return PropertiesHelper.getProperty((Properties)this.userParams, (String)strParamName, (String)strDefault);
    }

    @Override
    public boolean getUserParam(String strParamName, boolean bDefault) {
        return PropertiesHelper.getProperty((Properties)this.userParams, (String)strParamName, (boolean)bDefault);
    }

    @Override
    public int getUserParam(String strParamName, int nDefault) {
        return PropertiesHelper.getProperty((Properties)this.userParams, (String)strParamName, (int)nDefault);
    }

    @Override
    public Enumeration<Object> getUserParamNames() {
        if (this.userParams == null) {
            return null;
        }
        return this.userParams.keys();
    }

    @Override
    public BaseDataEntity getModelData() {
        return this.getPSObjectData();
    }

    @Override
    public IPSModel getPSModel() {
        return null;
    }

    @Override
    public String getModelName() {
        return this.getName();
    }

    @Override
    public String getModelType(String strModelType) {
        return this.getModelType();
    }

    @Override
    public String getModelId(String strModelType) {
        return this.getModelId();
    }

    @Override
    public String getModelName(String strModelType) {
        return this.getModelName();
    }

    @Override
    public Class<?> getModelClass(String strModelType) {
        return null;
    }

    @Override
    public IPSDynaModel getPSDynaModel() {
        return null;
    }

    @Override
    public int check() throws Exception {
        return 0;
    }

    @Override
    public String getFullModelName() {
        return this.getModelName();
    }

    @Override
    public String getUserTag() {
        return "";
    }

    @Override
    public String getUserTag2() {
        return "";
    }

    @Override
    public String getUserTag3() {
        return "";
    }

    @Override
    public String getUserTag4() {
        return "";
    }

    @Override
    public String getUserCat() {
        return "";
    }

    @Override
    public boolean isAutoModel() {
        return false;
    }

    @Override
    public String getDeployId() {
        return this.getId();
    }

    @Override
    public String getModelType() {
        if (this.getPSDataItem() != null) {
            return "PSDATAITEMPARAM$" + this.getPSDataItem().getModelType();
        }
        return null;
    }

    @Override
    public String getModelId() {
        if (this.getPSDataItem() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDataItem().getModelId(), (Object)this.getName());
        }
        String strModelId = this.getName();
        if (strModelId == null) {
            return "";
        }
        return strModelId;
    }

    @Override
    public String getModelInterface() {
        return "net.ibizsys.model.data.IPSDataItemParam";
    }

    @Override
    public IPSModelObject getParentModel() {
        return this.getPSDataItem();
    }

    @Override
    public IPSModelInfo getPSModelInfo(String strTag) {
        return null;
    }

    @Override
    public Iterator<IPSModelInfo> getPSModelInfos() {
        return null;
    }

    @Override
    public String getFullName() {
        return this.getName();
    }

    @Override
    public ObjectNode getModel() {
        if (!this.isEnableExportModel()) {
            return null;
        }
        return this.toModelNode(null);
    }

    @Override
    public ObjectNode toModel(String strType) {
        if (!this.isEnableExportModel()) {
            return null;
        }
        if (StringHelper.isNullOrEmpty((String)strType)) {
            return this.getModel();
        }
        return this.toModelNode(strType);
    }

    @Override
    public ObjectNode getRuntimeModel() {
        if (!this.isEnableExportModel()) {
            return null;
        }
        return this.toModelNode("RUNTIME");
    }

    protected boolean isEnableExportModel() {
        return !StringHelper.isNullOrEmpty((String)this.getPSSysModelInstId());
    }

    protected ObjectNode toModelNode(String strType) {
        try {
            ObjectNode objectNode = JsonNodeHelper.createObjectNode();
            this.onFillModelNode(objectNode, strType);
            return objectNode;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u5bfc\u51fa\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            ObjectNode objectNode = JsonNodeHelper.createObjectNode();
            objectNode.put("error", 1);
            objectNode.put("msg", ex.getMessage());
            return objectNode;
        }
    }

    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        PSObjectImpl.fillModelNode(this, objectNode, strModelType);
    }

    @Override
    public ObjectNode getModelRef() {
        if (!this.isEnableExportModelRef()) {
            return null;
        }
        return this.toModelRefNode(null);
    }

    @Override
    public ObjectNode toModelRef(String strType) {
        if (!this.isEnableExportModelRef()) {
            return null;
        }
        if (StringHelper.isNullOrEmpty((String)strType)) {
            return this.getModelRef();
        }
        return this.toModelRefNode(strType);
    }

    protected boolean isEnableExportModelRef() {
        return true;
    }

    protected ObjectNode toModelRefNode(String strType) {
        try {
            ObjectNode objectNode = JsonNodeHelper.createObjectNode();
            this.onFillModelRefNode(objectNode, strType);
            return objectNode;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u5bfc\u51fa\u6a21\u578b\u53d1\u751f\u5f02\u5e38\u5f15\u7528\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            ObjectNode objectNode = JsonNodeHelper.createObjectNode();
            objectNode.put("error", 1);
            objectNode.put("msg", ex.getMessage());
            return objectNode;
        }
    }

    protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
        objectNode.put("modelref", true);
        objectNode.put("type", this.getDumpModelType());
        objectNode.put("id", this.getId());
        objectNode.put("name", this.getName());
        if (!StringHelper.isNullOrEmpty((String)this.getCodeName())) {
            objectNode.put("codeName", this.getCodeName());
        }
    }

    @Override
    public String getDumpModelType() {
        return this.getModelType();
    }

    @Override
    public String getCodeName() {
        return null;
    }

    @Override
    public String getPSDynaInstId() {
        return null;
    }

    @Override
    public String getModelRefId() {
        return this.getId();
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    public String getMOSFilePath() {
        return null;
    }

    @Override
    public String getRTMOSFilePath() {
        return null;
    }

    @Override
    public String getWiki() {
        return null;
    }

    @Override
    public IPSModelObject getScopeModel() {
        return null;
    }
}

