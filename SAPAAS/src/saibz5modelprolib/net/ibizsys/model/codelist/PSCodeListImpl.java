/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.IPSSystemObject
 *  net.ibizsys.model.codelist.IPSCodeItem
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.ds.IPSDEDataSet
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.res.IPSLanguageRes
 *  net.ibizsys.model.res.IPSSysCss
 *  net.ibizsys.model.res.IPSSysImage
 *  net.ibizsys.model.sys.IPSSystemModule
 *  net.ibizsys.paas.codelist.ICodeItem
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.core.ISystem
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.codelist;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.IPSSystemSetting;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.codelist.IPSCodeItem;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.codelist.PSCodeItemImpl;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.entity.PSCodeItem;
import net.ibizsys.model.entity.PSCodeList;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.model.sys.IPSSystemModule;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSCodeListImpl
extends PSCodeItemImpl
implements IPSCodeList,
IPSSystemObject {
    private static final Log log = LogFactory.getLog(PSCodeListImpl.class);
    protected PSCodeList psCodeList = null;
    protected String strCodeName = "";
    private IPSDataEntity iPSDataEntity = null;
    private IPSDEDataSet iPSDEDataSet = null;
    private String strValueSeparator = "";
    private String strTextSeparator = "";
    private String strEmptyText = "";
    private String strOrMode = "";
    private boolean bUserRefFlag = false;
    private boolean bSysRefFlag = false;
    private boolean bCodeItemValueNumber = false;
    private String strPredefinedType = null;
    private String strCLType = null;
    private IPSSystem iPSSystem = null;
    private IPSSystemModule iPSSystemModule = null;
    private boolean bSubSysCodeList = false;
    private IPSDEField textPSDEField = null;
    private IPSDEField valuePSDEField = null;
    protected IPSDEField minorPSDEField = null;
    private IPSDEField iconClsPSDEField = null;
    private IPSDEField iconClsXPSDEField = null;
    private IPSDEField iconPathPSDEField = null;
    private IPSDEField iconPathXPSDEField = null;
    private boolean bUserScope = false;
    private IPSDEField pValuePSDEField = null;
    private IPSDEField disablePSDEField = null;
    private int nExtendMode = 0;
    private IPSLanguageRes emptyTextPSLanguageRes = null;
    private boolean bDynamicCodeList = false;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSystem iPSSystem, PSCodeList psCodeList) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSSystem(iPSSystem);
            this.psCodeList = psCodeList;
            this.setId(this.psCodeList.getPSCODELISTID());
            this.setName(this.psCodeList.getPSCODELISTNAME());
            this.setPSObjectData(this.psCodeList);
            if (!StringHelper.isNullOrEmpty((String)this.psCodeList.getORMODE())) {
                if (StringHelper.compare((String)this.psCodeList.getORMODE(), (String)"NUMBERORMODE", (boolean)true) == 0) {
                    this.strOrMode = "NUM";
                    this.bCodeItemValueNumber = true;
                } else {
                    this.strOrMode = "STR";
                }
            }
            if (StringHelper.compare((String)this.strOrMode, (String)"STR", (boolean)true) == 0) {
                this.strValueSeparator = ";";
                this.strTextSeparator = "\u3001";
                if (!StringHelper.isNullOrEmpty((String)this.psCodeList.getSEPERATOR())) {
                    this.strTextSeparator = this.psCodeList.getSEPERATOR();
                }
                if (!StringHelper.isNullOrEmpty((String)this.psCodeList.getVALUESEPERATOR())) {
                    this.strValueSeparator = this.psCodeList.getVALUESEPERATOR();
                }
            } else if (StringHelper.compare((String)this.strOrMode, (String)"NUM", (boolean)true) == 0) {
                this.strValueSeparator = "";
                this.strTextSeparator = "\u3001";
                if (!StringHelper.isNullOrEmpty((String)this.psCodeList.getSEPERATOR())) {
                    this.strTextSeparator = this.psCodeList.getSEPERATOR();
                }
            } else {
                this.strValueSeparator = "";
                this.strTextSeparator = "";
            }
            if (!StringHelper.isNullOrEmpty((String)psCodeList.getPSDEID())) {
                this.bUserRefFlag = true;
            }
            if (!this.psCodeList.isUSERREFFLAGNull() || !this.psCodeList.isSYSREFFLAGNull()) {
                boolean bl = this.bUserRefFlag = this.psCodeList.getUSERREFFLAG() || this.psCodeList.getSYSREFFLAG();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psCodeList.getPREDEFINEDTYPE())) {
                this.strPredefinedType = this.psCodeList.getPREDEFINEDTYPE();
            }
            this.strCLType = StringHelper.isNullOrEmpty((String)this.getPredefinedType()) ? this.psCodeList.getCLTYPE() : "DYNAMIC";
            if (StringHelper.compare((String)this.strCLType, (String)"PREDEFINED", (boolean)true) == 0) {
                this.strCLType = "DYNAMIC";
            }
            if (StringHelper.compare((String)this.strCLType, (String)"DYNAMIC", (boolean)true) == 0 && !this.psCodeList.isUSERSCOPENull()) {
                this.bUserScope = this.psCodeList.getUSERSCOPE();
            }
            if (!this.psCodeList.isEXTENDMODENull()) {
                this.nExtendMode = this.psCodeList.getEXTENDMODE();
            }
            if (!this.psCodeList.isENABLEDYNASYSNull()) {
                this.bDynamicCodeList = this.psCodeList.getENABLEDYNASYS();
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!this.psCodeList.getNOVALUEEMPTY()) {
            String strEmptyTextPSLanguageId;
            this.strEmptyText = this.psCodeList.getEMPTYTEXT();
            if (StringHelper.isNullOrEmpty((String)this.strEmptyText)) {
                for (IPSCodeItem iPSCodeItem : this.psCodeItemList) {
                    if (!iPSCodeItem.isShowAsEmtpy()) continue;
                    this.strEmptyText = iPSCodeItem.getText();
                    break;
                }
            }
            if (StringHelper.isNullOrEmpty((String)this.strEmptyText)) {
                this.strEmptyText = ((IPSSystemSetting)this.getPSSystem()).getCLEmptyText();
            }
            if (StringHelper.isNullOrEmpty((String)this.strEmptyText)) {
                this.strEmptyText = "\u672a\u5b9a\u4e49";
            }
            if (StringHelper.isNullOrEmpty((String)(strEmptyTextPSLanguageId = this.psCodeList.getEMPTYTEXTPSLANRESID()))) {
                strEmptyTextPSLanguageId = ((IPSSystemSetting)this.getPSSystem()).getCLEmptyTextPSLanguageResId();
            }
            if (!StringHelper.isNullOrEmpty((String)strEmptyTextPSLanguageId)) {
                this.emptyTextPSLanguageRes = this.getPSSystem().getPSLanguageRes(strEmptyTextPSLanguageId);
            }
        }
    }

    @Override
    protected void onPreparePSCodeItems() throws Exception {
        this.psCodeItemList.clear();
        this.codeItemList.clear();
        Vector<PSCodeItem> psCodeItemList = new Vector<PSCodeItem>();
        CallResult callResult = this.getPSModelQueryHelper().getPSCodeItems(this.getId(), psCodeItemList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u4ee3\u7801\u8868\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        int nOrderValue = 1;
        for (PSCodeItem psCodeItem : psCodeItemList) {
            psCodeItem.setORDERVALUE(nOrderValue);
            ++nOrderValue;
        }
        HashMap<String, PSCodeItem> psCodeItemMap = new HashMap<String, PSCodeItem>();
        for (PSCodeItem psCodeItem : psCodeItemList) {
            if (!psCodeItem.isVALIDFLAGNull() && !psCodeItem.getVALIDFLAG()) continue;
            psCodeItemMap.put(psCodeItem.getPSCODEITEMID(), psCodeItem);
        }
        for (PSCodeItem psCodeItem : psCodeItemList) {
            PSCodeItem parentPSCodeItem;
            if (!psCodeItem.isVALIDFLAGNull() && !psCodeItem.getVALIDFLAG() || StringHelper.isNullOrEmpty((String)psCodeItem.getPPSCODEITEMID()) || (parentPSCodeItem = (PSCodeItem)((Object)psCodeItemMap.get(psCodeItem.getPPSCODEITEMID()))) == null) continue;
            parentPSCodeItem.getChildPSCodeItems(true).add(psCodeItem);
        }
        for (PSCodeItem psCodeItem : psCodeItemList) {
            if (!psCodeItem.isVALIDFLAGNull() && !psCodeItem.getVALIDFLAG() || !StringHelper.isNullOrEmpty((String)psCodeItem.getPPSCODEITEMID())) continue;
            PSCodeItemImpl iPSCodeItem = new PSCodeItemImpl();
            iPSCodeItem.init(this.getPSModelStorageContext(), this, null, psCodeItem);
            this.psCodeItemList.add(iPSCodeItem);
        }
        this.codeItemList.addAll(this.psCodeItemList);
    }

    public String getCodeListText(String strValue, boolean bRecursion) throws Exception {
        return this.getCodeListText(strValue, bRecursion, null, null);
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u7c7b\u578b", codelist="CodeListType")
    public String getCodeListType() {
        return this.strCLType;
    }

    public String getHandler() {
        return null;
    }

    @PSModelRTMeta(description="\u7528\u6237\u8303\u56f4")
    public boolean isUserScope() {
        return this.bUserScope;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", hideempty=true)
    public IPSDataEntity getPSDataEntity() throws Exception {
        if (this.iPSDataEntity != null) {
            return this.iPSDataEntity;
        }
        if (!StringHelper.isNullOrEmpty((String)this.psCodeList.getPSDEID())) {
            this.iPSDataEntity = this.getPSSystem().getPSDataEntity(this.psCodeList.getPSDEID());
        }
        return this.iPSDataEntity;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61", hideempty=true)
    public IPSDEDataSet getPSDEDataSet() throws Exception {
        if (this.iPSDEDataSet != null) {
            return this.iPSDEDataSet;
        }
        if (this.getPSDataEntity() != null && !StringHelper.isNullOrEmpty((String)this.psCodeList.getPSDEDSID())) {
            this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.psCodeList.getPSDEDSID());
        }
        return this.iPSDEDataSet;
    }

    @PSModelRTMeta(description="\u591a\u9879\u4ee3\u7801\u8868\u6216\u6a21\u5f0f", hideempty2=true, codelist="CodeListOrMode")
    public String getOrMode() {
        return this.strOrMode;
    }

    @PSModelRTMeta(description="\u503c\u5206\u9694\u7b26", hideempty2=true)
    public String getValueSeparator() {
        return this.strValueSeparator;
    }

    @PSModelRTMeta(description="\u6587\u672c\u5206\u9694\u7b26", hideempty2=true)
    public String getTextSeparator() {
        return this.strTextSeparator;
    }

    @PSModelRTMeta(description="\u7a7a\u767d\u663e\u793a\u6587\u672c")
    public String getEmptyText() {
        return this.strEmptyText;
    }

    @PSModelRTMeta(description="\u9884\u7f6e\u4ee3\u7801\u8868\u7c7b\u578b", codelist="PredefinedCLType", hideempty2=true)
    public String getPredefinedType() {
        return this.strPredefinedType;
    }

    public String getGlobalId() {
        return "";
    }

    public String getCodeListText(String strValue, boolean bRecursion, Object activeData, IWebContext iWebContext) throws Exception {
        return null;
    }

    @PSModelRTMeta(description="\u7cfb\u7edf\u5bf9\u8c61")
    public IPSSystem getPSSystem() {
        return this.iPSSystem;
    }

    protected void setPSSystem(IPSSystem iPSSystem) {
        this.iPSSystem = iPSSystem;
    }

    public ISystem getSystem() {
        return this.getPSSystem();
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.getPSSystem()).getPSSysModelInstId();
    }

    @PSModelRTMeta(description="\u663e\u793a\u6587\u672c\u5c5e\u6027", hideempty=true)
    public IPSDEField getTextPSDEField() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psCodeList.getPSDEID()) && !StringHelper.isNullOrEmpty((String)this.psCodeList.getTEXTPSDEFID())) {
            if (this.textPSDEField != null) {
                return this.textPSDEField;
            }
            this.textPSDEField = this.getPSDataEntity().getPSDEField(this.psCodeList.getTEXTPSDEFID());
            return this.textPSDEField;
        }
        return null;
    }

    @PSModelRTMeta(description="\u503c\u5c5e\u6027", hideempty=true)
    public IPSDEField getValuePSDEField() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psCodeList.getPSDEID()) && !StringHelper.isNullOrEmpty((String)this.psCodeList.getVALUEPSDEFID())) {
            if (this.valuePSDEField != null) {
                return this.valuePSDEField;
            }
            this.valuePSDEField = this.getPSDataEntity().getPSDEField(this.psCodeList.getVALUEPSDEFID());
            return this.valuePSDEField;
        }
        return null;
    }

    @PSModelRTMeta(description="\u9ed8\u8ba4\u6392\u5e8f\u5c5e\u6027", hideempty=true)
    public IPSDEField getMinorSortPSDEField() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psCodeList.getPSDEID()) && !StringHelper.isNullOrEmpty((String)this.psCodeList.getMINORSORTPSDEFID())) {
            if (this.minorPSDEField != null) {
                return this.minorPSDEField;
            }
            this.minorPSDEField = this.getPSDataEntity().getPSDEField(this.psCodeList.getMINORSORTPSDEFID());
            return this.minorPSDEField;
        }
        return null;
    }

    @PSModelRTMeta(description="\u9ed8\u8ba4\u6392\u5e8f\u65b9\u5411", hideempty2=true)
    public String getMinorSortDir() {
        return this.psCodeList.getMINORSORTDIR();
    }

    @PSModelRTMeta(description="\u56fe\u6807\u6837\u5f0f\u5c5e\u6027", hideempty2=true)
    public IPSDEField getIconClsPSDEField() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psCodeList.getPSDEID()) && !StringHelper.isNullOrEmpty((String)this.psCodeList.getICONCLSPSDEFID())) {
            if (this.iconClsPSDEField != null) {
                return this.iconClsPSDEField;
            }
            this.iconClsPSDEField = this.getPSDataEntity().getPSDEField(this.psCodeList.getICONCLSPSDEFID());
            return this.iconClsPSDEField;
        }
        return null;
    }

    @PSModelRTMeta(description="\u56fe\u6807\u8def\u5f84\u5c5e\u6027", hideempty2=true)
    public IPSDEField getIconPathPSDEField() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psCodeList.getPSDEID()) && !StringHelper.isNullOrEmpty((String)this.psCodeList.getICONPATHPSDEFID())) {
            if (this.iconPathPSDEField != null) {
                return this.iconPathPSDEField;
            }
            this.iconPathPSDEField = this.getPSDataEntity().getPSDEField(this.psCodeList.getICONPATHPSDEFID());
            return this.iconPathPSDEField;
        }
        return null;
    }

    @PSModelRTMeta(description="\u56fe\u6807\u6837\u5f0f(x)\u5c5e\u6027", hideempty2=true)
    public IPSDEField getIconClsXPSDEField() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psCodeList.getPSDEID()) && !StringHelper.isNullOrEmpty((String)this.psCodeList.getICONCLSXPSDEFID())) {
            if (this.iconClsXPSDEField != null) {
                return this.iconClsXPSDEField;
            }
            this.iconClsXPSDEField = this.getPSDataEntity().getPSDEField(this.psCodeList.getICONCLSXPSDEFID());
            return this.iconClsXPSDEField;
        }
        return null;
    }

    @PSModelRTMeta(description="\u56fe\u6807\u8def\u5f84(x)\u5c5e\u6027", hideempty2=true)
    public IPSDEField getIconPathXPSDEField() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psCodeList.getPSDEID()) && !StringHelper.isNullOrEmpty((String)this.psCodeList.getICONPATHXPSDEFID())) {
            if (this.iconPathXPSDEField != null) {
                return this.iconPathXPSDEField;
            }
            this.iconPathXPSDEField = this.getPSDataEntity().getPSDEField(this.psCodeList.getICONPATHXPSDEFID());
            return this.iconPathXPSDEField;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6570\u636e", hideempty2=true)
    public String getUserData() {
        return this.psCodeList.getUSERDATA();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6570\u636e2", hideempty2=true)
    public String getUserData2() {
        return this.psCodeList.getUSERDATA2();
    }

    @PSModelRTMeta(description="\u67e5\u8be2\u9644\u52a0\u6761\u4ef6", hideempty2=true)
    public String getFetchCondition() {
        return this.psCodeList.getDSCONDITIONS();
    }

    @PSModelRTMeta(description="\u7236\u503c\u5c5e\u6027", hideempty2=true)
    public IPSDEField getPValuePSDEField() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psCodeList.getPSDEID()) && !StringHelper.isNullOrEmpty((String)this.psCodeList.getPVALUEPSDEFID())) {
            if (this.pValuePSDEField != null) {
                return this.pValuePSDEField;
            }
            this.pValuePSDEField = this.getPSDataEntity().getPSDEField(this.psCodeList.getPVALUEPSDEFID());
            return this.pValuePSDEField;
        }
        return null;
    }

    @PSModelRTMeta(description="\u7981\u7528\u503c\u5c5e\u6027", hideempty2=true)
    public IPSDEField getDisablePSDEField() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psCodeList.getPSDEID()) && !StringHelper.isNullOrEmpty((String)this.psCodeList.getDISABLEPSDEFID())) {
            if (this.disablePSDEField != null) {
                return this.disablePSDEField;
            }
            this.disablePSDEField = this.getPSDataEntity().getPSDEField(this.psCodeList.getDISABLEPSDEFID());
            return this.disablePSDEField;
        }
        return null;
    }

    @PSModelRTMeta(description="\u7a7a\u767d\u663e\u793a\u6587\u672c\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getEmptyTextPSLanguageRes() {
        return this.emptyTextPSLanguageRes;
    }

    @Override
    public IPSCodeList getPSCodeList() {
        return super.getPSCodeList();
    }

    @Override
    public IPSCodeItem getParentPSCodeItem() {
        return super.getParentPSCodeItem();
    }

    @Override
    public PSCodeItem getPSCodeItemData() {
        return super.getPSCodeItemData();
    }

    @Override
    public String getRealText() {
        return super.getRealText();
    }

    @Override
    public String getText() {
        return super.getText();
    }

    @Override
    public String getValue() {
        return super.getValue();
    }

    @Override
    public ICodeItem getParentCodeItem() {
        return super.getParentCodeItem();
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public String getIconPath() {
        return super.getIconPath();
    }

    @Override
    public String getMemo() {
        return super.getMemo();
    }

    @Override
    public String getIconCls() {
        return super.getIconCls();
    }

    @Override
    public IPSSysCss getPSSysCss() {
        return super.getPSSysCss();
    }

    @Override
    public String getTextCls() {
        return super.getTextCls();
    }

    @Override
    public IPSSysImage getPSSysImage() {
        return super.getPSSysImage();
    }

    @Override
    public String getParentValue() {
        return super.getParentValue();
    }

    @Override
    public String getIconPathX() {
        return super.getIconPathX();
    }

    @Override
    public String getIconPath(int nX) {
        return super.getIconPath(nX);
    }

    @Override
    public String getIconClsX() {
        return super.getIconClsX();
    }

    @Override
    public String getIconCls(int nX) {
        return super.getIconCls(nX);
    }

    @Override
    public boolean isDisableSelect() {
        return super.isDisableSelect();
    }

    @Override
    public IPSLanguageRes getTextPSLanguageRes() {
        return super.getTextPSLanguageRes();
    }

    @Override
    public String getTextLanResTag() {
        return super.getTextLanResTag();
    }

    @PSModelRTMeta(description="\u662f\u5426\u652f\u6301\u52a8\u6001\u7cfb\u7edf")
    public boolean isEnableDynaSys() {
        return this.bDynamicCodeList;
    }

    @Override
    protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"id", (Object)this.getId());
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"name", (Object)this.getName());
        Iterator<IPSCodeItem> psCodeItems = this.getPSCodeItems();
        if (psCodeItems != null) {
            ArrayList<ObjectNode> itemList = new ArrayList<ObjectNode>();
            while (psCodeItems.hasNext()) {
                IPSCodeItem iPSCodeItem = psCodeItems.next();
                ObjectNode psCodeItemObjectNode = iPSCodeItem.toJsonObject(null);
                itemList.add(psCodeItemObjectNode);
            }
            JsonNodeHelper.put((ObjectNode)objectNode, (String)"items", itemList);
        }
    }
}

