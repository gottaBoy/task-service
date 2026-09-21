/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.codelist.ICodeItem
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.CodeList;

import SA.SRFDA.PS.Core.CodeList.IPSCodeItem;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Data.PSCodeItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.ICodeList;
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
    protected String strCodeName = "";
    protected ArrayList<IPSCodeItem> psCodeItemList = new ArrayList();
    protected ArrayList<ICodeItem> codeItemList = new ArrayList();
    private IPSSysCss iPSSysCss = null;
    private IPSSysImage iPSSysImage = null;
    private String strColor = null;
    private String strBKColor = null;
    private boolean bDisableSelect = false;
    private IPSLanguageRes textPSLanguageRes = null;
    private boolean bShowAsEmtpy = false;
    private String strData = null;
    private boolean bDefault = false;
    private String strTooltip = null;
    private IPSLanguageRes tooltipPSLanguageRes = null;
    private Double fBeginValue = null;
    private Double fEndValue = null;
    private boolean bIncludeBeginValue = true;
    private boolean bIncludeEndValue = false;
    private static final Pattern codeNamePattern = Pattern.compile("[a-zA-Z_$][a-zA-Z0-9_$]*");

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSCodeList iPSCodeList, IPSCodeItem parentPSCodeItem, PSCodeItem psCodeItem) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSCodeList(iPSCodeList);
            this.setParentPSCodeItem(parentPSCodeItem);
            this.setPSCodeItemData(psCodeItem);
            this.setId(this.psCodeItem.getPSCODEITEMID());
            this.setName(this.psCodeItem.getPSCODEITEMNAME());
            this.setPSObjectData(this.psCodeItem);
            this.strCodeName = this.psCodeItem.getCODENAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.psCodeItem.getCODEITEMVALUE().toLowerCase();
                this.strCodeName = this.strCodeName.replace("%", "_");
                this.strCodeName = this.strCodeName.replace("+", "_ADD_");
                this.strCodeName = this.strCodeName.replace("-", "_SUB_");
                this.strCodeName = this.strCodeName.replace("/", "_");
                this.strCodeName = this.strCodeName.replace(".", "_");
                this.strCodeName = this.strCodeName.replace("|", "_");
                this.strCodeName = this.strCodeName.replace("::", "_");
                this.strCodeName = this.strCodeName.replace(":", "_");
                this.strCodeName = this.strCodeName.replace(" ", "_");
                this.strCodeName = this.strCodeName.replace("=", "EQ");
                this.strCodeName = this.strCodeName.replace(">", "GT");
                this.strCodeName = this.strCodeName.replace(">=", "GTANDEQ");
                this.strCodeName = this.strCodeName.replace("<", "LT");
                this.strCodeName = this.strCodeName.replace("<=", "LTANDEQ");
                this.strCodeName = this.strCodeName.replace("<>", "NOTEQ");
                try {
                    int nValue = Integer.parseInt(this.strCodeName);
                    this.strCodeName = "item_" + this.strCodeName;
                }
                catch (Exception nValue) {
                    // empty catch block
                }
                Matcher m = codeNamePattern.matcher(this.strCodeName);
                boolean b = m.matches();
                if (!b) {
                    this.strCodeName = SA.SRFramework.Utility.StringHelper.Format((String)"item_%1$s", (Object)psCodeItem.getORDERVALUE());
                }
            }
            if (!(SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName) || iPSCodeList != null && iPSCodeList.getPSSystem().getPSSystemSetting().isFixCodeNameAutoCapitalize())) {
                String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
                this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeItem.getCOLOR())) {
                this.strColor = this.psCodeItem.getCOLOR();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeItem.getBKCOLOR())) {
                this.strBKColor = this.psCodeItem.getBKCOLOR();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeItem.getPSSYSCSSID())) {
                this.iPSSysCss = this.iPSCodeList.getPSSystem().getPSSysCss(this.psCodeItem.getPSSYSCSSID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeItem.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.iPSCodeList.getPSSystem().getPSSysImage(this.psCodeItem.getPSSYSIMAGEID());
            }
            if (!this.psCodeItem.isDISABLESELECTNull()) {
                this.bDisableSelect = this.psCodeItem.getDISABLESELECT();
            }
            if (!this.psCodeItem.isSHOWASEMPTYNull()) {
                this.bShowAsEmtpy = this.psCodeItem.getSHOWASEMPTY();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeItem.getTEXTPSLANRESID())) {
                this.textPSLanguageRes = this.iPSCodeList.getPSSystem().getPSLanguageRes(this.psCodeItem.getTEXTPSLANRESID());
            }
            if (!this.psCodeItem.isDEFAULTFLAGNull()) {
                this.bDefault = this.psCodeItem.getDEFAULTFLAG();
            }
            this.strData = this.psCodeItem.getDATA();
            if (this.getPSCodeList().isThresholdGroup()) {
                if (!this.psCodeItem.isBEGINVALUENull()) {
                    this.fBeginValue = this.psCodeItem.getBEGINVALUE();
                }
                if (!this.psCodeItem.isENDVALUENull()) {
                    this.fEndValue = this.psCodeItem.getENDVALUE();
                }
                if (!this.psCodeItem.isINCBEGINVALUENull()) {
                    this.bIncludeBeginValue = this.psCodeItem.getINCBEGINVALUE();
                }
                if (!this.psCodeItem.isINCENDVALUENull()) {
                    this.bIncludeEndValue = this.psCodeItem.getINCENDVALUE();
                }
            }
            this.strTooltip = this.psCodeItem.getTOOLTIPINFO();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeItem.getTIPPSLANRESID())) {
                this.tooltipPSLanguageRes = this.iPSCodeList.getPSSystem().getPSLanguageRes(this.psCodeItem.getTIPPSLANRESID());
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
        this.onPreparePSCodeItems();
    }

    @Override
    public String getName() {
        return super.getName();
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
            iPSCodeItem.init(this.getDAGlobalHelper(), this.iPSCodeList, this, psCodeItem);
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

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u9879\u96c6\u5408", hideempty2=true, child=true, outputdoc="false")
    public Iterator<IPSCodeItem> getPSCodeItems() {
        if (this.psCodeItemList == null || this.psCodeItemList.size() == 0) {
            return null;
        }
        return this.psCodeItemList.iterator();
    }

    @Override
    public String getRealText() {
        return this.getName();
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c", group="\u57fa\u672c", order=102, fields={"PSCODEITEMNAME"})
    public String getText() {
        return this.getName();
    }

    @Override
    @PSModelRTMeta(description="\u503c", group="\u57fa\u672c", order=104, fields={"CODEITEMVALUE"})
    public String getValue() {
        if (this.psCodeItem != null) {
            return this.psCodeItem.getCODEITEMVALUE();
        }
        return null;
    }

    public ICodeList getCodeList() {
        return this.getPSCodeList();
    }

    public ICodeItem getParentCodeItem() {
        return this.getParentPSCodeItem();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u989c\u8272", fields={"COLOR"})
    public String getColor() {
        return this.strColor;
    }

    @Override
    @PSModelRTMeta(description="\u80cc\u666f\u989c\u8272", fields={"BKCOLOR"})
    public String getBKColor() {
        return this.strBKColor;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u8def\u5f84")
    public String getIconPath() {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getImagePath();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u6837\u5f0f")
    public String getIconCls() {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getCssClass();
        }
        return null;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSCodeList.getPSSysModelInstId();
    }

    @Override
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

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u6837\u5f0f")
    public String getTextCls() {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psCodeItem.getCSSCLASS())) {
            return this.psCodeItem.getCSSCLASS();
        }
        if (this.getPSSysCss() != null) {
            return this.getPSSysCss().getCssName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u5bf9\u8c61")
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    public String getParentValue() {
        if (this.parentPSCodeItem != null) {
            return this.parentPSCodeItem.getValue();
        }
        return null;
    }

    @Override
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

    @Override
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

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u9879\u6570\u636e", fields={"USERDATA"})
    public String getUserData() {
        if (this.psCodeItem != null) {
            return this.psCodeItem.getUSERDATA();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u9879\u6570\u636e2", fields={"USERDATA2"})
    public String getUserData2() {
        if (this.psCodeItem != null) {
            return this.psCodeItem.getUSERDATA2();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7981\u6b62\u9009\u62e9", ignoredumpvalues="false", fields={"DISABLESELECT"})
    public boolean isDisableSelect() {
        return this.bDisableSelect;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getTextPSLanguageRes() {
        return this.textPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e", hideempty=true, fields={"DATA"})
    public String getData() {
        return this.strData;
    }

    @Override
    public String getTextLanResTag() {
        if (this.getTextPSLanguageRes() != null) {
            return this.getTextPSLanguageRes().getLanResTag();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u4e3a\u7a7a\u767d", ignoredumpvalues="false", fields={"SHOWASEMPTY"})
    public boolean isShowAsEmtpy() {
        return this.bShowAsEmtpy;
    }

    @Override
    public String getModelType() {
        return "PSCODEITEM";
    }

    @Override
    public String getModelName() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s(%2$s)", (Object)this.getText(), (Object)this.getValue());
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSCodeList().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSCodeList().getPSSystem());
    }

    public ICodeItem getCodeItemByText(String strText) throws Exception {
        return this.getCodeItemByText(strText, true);
    }

    public ICodeItem getCodeItem(String strValue) throws Exception {
        return this.getCodeItem(strValue, true);
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u4ee3\u7801\u9879", ignoredumpvalues="false", fields={"DEFAULTFLAG"})
    public boolean isDefault() {
        return this.bDefault;
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u793a\u4fe1\u606f\u8bed\u8a00\u8d44\u6e90", hideempty=true)
    public IPSLanguageRes getTooltipPSLanguageRes() {
        return this.tooltipPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u793a\u4fe1\u606f", hideempty2=true, fields={"TOOLTIPINFO"})
    public String getTooltip() {
        return this.strTooltip;
    }

    @Override
    @PSModelRTMeta(description="\u5f00\u59cb\u503c")
    public Double getBeginValue() {
        return this.fBeginValue;
    }

    @Override
    @PSModelRTMeta(description="\u7ed3\u675f\u503c")
    public Double getEndValue() {
        return this.fEndValue;
    }

    @Override
    @PSModelRTMeta(description="\u5305\u542b\u5f00\u59cb\u503c", ignoredumpvalues="false", outputdoc="item.isThresholdGroup()")
    public boolean isIncludeBeginValue() {
        return this.bIncludeBeginValue;
    }

    @Override
    @PSModelRTMeta(description="\u5305\u542b\u7ed3\u675f\u503c", ignoredumpvalues="false", outputdoc="item.isThresholdGroup()")
    public boolean isIncludeEndValue() {
        return this.bIncludeEndValue;
    }

    @Override
    public String getModelRefId() {
        return null;
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
        if (this.getPSCodeList() != null && !this.getPSCodeList().isThresholdGroup()) {
            objectNode.remove("includeBeginValue");
            objectNode.remove("includeEndValue");
        }
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSCodeList();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        if (this.getParentPSCodeItem() != null) {
            return this.getParentPSCodeItem();
        }
        return this.getPSCodeList();
    }
}

