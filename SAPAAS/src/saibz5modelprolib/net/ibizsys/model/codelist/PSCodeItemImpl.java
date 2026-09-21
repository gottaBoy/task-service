/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.codelist.IPSCodeItem
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.res.IPSLanguageRes
 *  net.ibizsys.model.res.IPSSysCss
 *  net.ibizsys.model.res.IPSSysImage
 *  net.ibizsys.paas.codelist.ICodeItem
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.codelist;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.codelist.IPSCodeItem;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.entity.PSCodeItem;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSCodeItemImpl
extends PSObjectImpl
implements IPSCodeItem {
    private static final Log log = LogFactory.getLog(PSCodeItemImpl.class);
    private IPSCodeList iPSCodeList = null;
    private IPSCodeItem parentPSCodeItem = null;
    private PSCodeItem psCodeItem = null;
    protected ArrayList<IPSCodeItem> psCodeItemList = new ArrayList();
    protected ArrayList<ICodeItem> codeItemList = new ArrayList();
    private IPSSysCss iPSSysCss = null;
    private IPSSysImage iPSSysImage = null;
    private String strColor = null;
    private boolean bDisableSelect = false;
    private IPSLanguageRes textPSLanguageRes = null;
    private boolean bShowAsEmtpy = false;
    private static final Pattern codeNamePattern = Pattern.compile("[a-zA-Z_$][a-zA-Z0-9_$]*");

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSCodeList iPSCodeList, IPSCodeItem parentPSCodeItem, PSCodeItem psCodeItem) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSCodeList(iPSCodeList);
            this.setParentPSCodeItem(parentPSCodeItem);
            this.setPSCodeItemData(psCodeItem);
            this.setId(this.psCodeItem.getPSCODEITEMID());
            this.setName(this.psCodeItem.getPSCODEITEMNAME());
            this.setPSObjectData(this.psCodeItem);
            if (!StringHelper.isNullOrEmpty((String)this.psCodeItem.getCOLOR())) {
                this.strColor = this.psCodeItem.getCOLOR();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psCodeItem.getPSSYSCSSID())) {
                this.iPSSysCss = this.iPSCodeList.getPSSystem().getPSSysCss(this.psCodeItem.getPSSYSCSSID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psCodeItem.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.iPSCodeList.getPSSystem().getPSSysImage(this.psCodeItem.getPSSYSIMAGEID());
            }
            if (!this.psCodeItem.isDISABLESELECTNull()) {
                this.bDisableSelect = this.psCodeItem.getDISABLESELECT();
            }
            if (!this.psCodeItem.isSHOWASEMPTYNull()) {
                this.bShowAsEmtpy = this.psCodeItem.getSHOWASEMPTY();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psCodeItem.getTEXTPSLANRESID())) {
                this.textPSLanguageRes = this.iPSCodeList.getPSSystem().getPSLanguageRes(this.psCodeItem.getTEXTPSLANRESID());
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
        this.onPreparePSCodeItems();
    }

    protected void onPreparePSCodeItems() throws Exception {
        ArrayList<PSCodeItem> psCodeItemList;
        if (this.psCodeItemList != null) {
            this.psCodeItemList.clear();
        }
        if (this.codeItemList != null) {
            this.codeItemList.clear();
        }
        if ((psCodeItemList = this.psCodeItem.getChildPSCodeItems(false)) == null) {
            return;
        }
        if (this.psCodeItemList == null) {
            this.psCodeItemList = new ArrayList();
        }
        if (this.codeItemList == null) {
            this.codeItemList = new ArrayList();
        }
        for (PSCodeItem psCodeItem : psCodeItemList) {
            PSCodeItemImpl iPSCodeItem = new PSCodeItemImpl();
            iPSCodeItem.init(this.getPSModelStorageContext(), this.iPSCodeList, this, psCodeItem);
            this.psCodeItemList.add(iPSCodeItem);
        }
        this.codeItemList.addAll(this.psCodeItemList);
    }

    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    protected void setPSCodeList(IPSCodeList iPSCodeList) {
        this.iPSCodeList = iPSCodeList;
    }

    public IPSCodeItem getParentPSCodeItem() {
        return this.parentPSCodeItem;
    }

    protected void setParentPSCodeItem(IPSCodeItem parentPSCodeItem) {
        this.parentPSCodeItem = parentPSCodeItem;
    }

    public PSCodeItem getPSCodeItemData() {
        return this.psCodeItem;
    }

    protected void setPSCodeItemData(PSCodeItem psCodeItem) {
        this.psCodeItem = psCodeItem;
    }

    public Iterator<ICodeItem> getCodeItems() throws Exception {
        if (this.codeItemList == null || this.codeItemList.size() == 0) {
            return null;
        }
        return this.codeItemList.iterator();
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u9879\u96c6\u5408", hideempty2=true)
    public Iterator<IPSCodeItem> getPSCodeItems() {
        if (this.psCodeItemList == null || this.psCodeItemList.size() == 0) {
            return null;
        }
        return this.psCodeItemList.iterator();
    }

    public String getRealText() {
        return this.getName();
    }

    @PSModelRTMeta(description="\u6587\u672c")
    public String getText() {
        return this.getName();
    }

    @PSModelRTMeta(description="\u503c")
    public String getValue() {
        return this.psCodeItem.getCODEITEMVALUE();
    }

    public ICodeList getCodeList() {
        return this.getPSCodeList();
    }

    public ICodeItem getParentCodeItem() {
        return this.getParentPSCodeItem();
    }

    @PSModelRTMeta(description="\u6587\u672c\u989c\u8272")
    public String getColor() {
        return this.strColor;
    }

    @PSModelRTMeta(description="\u56fe\u6807\u8def\u5f84")
    public String getIconPath() {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getImagePath();
        }
        return "";
    }

    public String getMemo() {
        return this.psCodeItem.getMEMO();
    }

    @PSModelRTMeta(description="\u56fe\u6807\u6837\u5f0f")
    public String getIconCls() {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getCssClass();
        }
        return null;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.iPSCodeList).getPSSysModelInstId();
    }

    @PSModelRTMeta(description="\u663e\u793a\u6837\u5f0f")
    public IPSSysCss getPSSysCss() {
        return this.iPSSysCss;
    }

    public ICodeItem getCodeItemByText(String strText, boolean bRecursion) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public ICodeItem getCodeItem(String strValue, boolean bRecursion) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @PSModelRTMeta(description="\u6587\u672c\u6837\u5f0f")
    public String getTextCls() {
        if (this.getPSSysCss() != null) {
            return this.getPSSysCss().getCssName();
        }
        return null;
    }

    @PSModelRTMeta(description="\u56fe\u6807\u5bf9\u8c61")
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    public String getParentValue() {
        if (this.parentPSCodeItem != null) {
            return this.parentPSCodeItem.getValue();
        }
        return null;
    }

    @PSModelRTMeta(description="\u56fe\u6807\u8def\u5f84(X)")
    public String getIconPathX() {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getImagePathX();
        }
        return null;
    }

    public String getIconPath(int nX) {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getImagePath(nX);
        }
        return null;
    }

    @PSModelRTMeta(description="\u56fe\u6807\u6837\u5f0f(X)")
    public String getIconClsX() {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getCssClassX();
        }
        return null;
    }

    public String getIconCls(int nX) {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getCssClass(nX);
        }
        return null;
    }

    @PSModelRTMeta(description="\u7528\u6237\u6570\u636e")
    public String getUserData() {
        return this.psCodeItem.getUSERDATA();
    }

    @PSModelRTMeta(description="\u7528\u6237\u6570\u636e2")
    public String getUserData2() {
        return this.psCodeItem.getUSERDATA2();
    }

    @PSModelRTMeta(description="\u7981\u6b62\u9009\u62e9")
    public boolean isDisableSelect() {
        return this.bDisableSelect;
    }

    @PSModelRTMeta(description="\u6587\u672c\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getTextPSLanguageRes() {
        return this.textPSLanguageRes;
    }

    public String getTextLanResTag() {
        if (this.getTextPSLanguageRes() != null) {
            return this.getTextPSLanguageRes().getLanResTag();
        }
        return null;
    }

    @PSModelRTMeta(description="\u663e\u793a\u4e3a\u7a7a\u767d")
    public boolean isShowAsEmtpy() {
        return this.bShowAsEmtpy;
    }

    public ICodeItem getCodeItemByText(String strText) throws Exception {
        return this.getCodeItemByText(strText, true);
    }

    public ICodeItem getCodeItem(String strValue) throws Exception {
        return this.getCodeItem(strValue, true);
    }

    public ObjectNode toJsonObject(ObjectNode objectNode) throws Exception {
        if (objectNode == null) {
            objectNode = JsonNodeHelper.createObjectNode();
        }
        this.onFillJsonObject(objectNode);
        return objectNode;
    }

    protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"value", (Object)this.getValue());
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"text", (Object)this.getText());
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

