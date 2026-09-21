/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  net.ibizsys.paas.codelist.ICodeItem
 */
package SA.SRFDA.PS.Core.CodeList;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Data.PSCodeItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeItem;

@PSModelInterfaceMeta(title="\u4ee3\u7801\u8868\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSCodeItem")
public interface IPSCodeItem
extends IPSModelObject,
ICodeItem {
    public void init(ISRFDAGlobalHelper var1, IPSCodeList var2, IPSCodeItem var3, PSCodeItem var4) throws Exception;

    public Iterator<IPSCodeItem> getPSCodeItems() throws Exception;

    @Override
    public String getCodeName();

    public IPSSysCss getPSSysCss();

    public IPSSysImage getPSSysImage();

    @Override
    public BaseDataEntity getModelData();

    public IPSLanguageRes getTextPSLanguageRes();

    public boolean isShowAsEmtpy();

    public String getData();

    public boolean isDefault();

    public IPSLanguageRes getTooltipPSLanguageRes();

    public String getTooltip();

    public String getRealText();

    public String getText();

    public String getValue();

    public String getColor();

    public String getBKColor();

    public String getIconPath();

    public String getIconPathX();

    @Override
    public String getMemo();

    public String getIconCls();

    public String getIconClsX();

    public String getTextCls();

    public String getParentValue();

    public String getUserData();

    public String getUserData2();

    public boolean isDisableSelect();

    public String getTextLanResTag();

    public Double getBeginValue();

    public Double getEndValue();

    public boolean isIncludeBeginValue();

    public boolean isIncludeEndValue();
}

