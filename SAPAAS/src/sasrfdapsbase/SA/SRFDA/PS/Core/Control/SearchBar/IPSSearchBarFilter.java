/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.SearchBar;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.Control.IPSEditorContainer;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSearchBarItem;
import SA.SRFDA.PS.Core.DEField.IPSDEFInputTip;
import SA.SRFDA.PS.Core.DEField.IPSDEFSearchMode;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysEditorStyle;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import net.sf.json.JSONObject;

public interface IPSSearchBarFilter
extends IPSSearchBarItem,
IPSEditorContainer {
    public String getLabelPos();

    public int getLabelWidth();

    public boolean isHidden();

    @Override
    public String getEditorType();

    @Override
    public IPSEditorType getPSEditorType();

    @Override
    public IPSSysEditorStyle getPSSysEditorStyle();

    @Override
    public String getEditorStyle();

    @Override
    public double getEditorWidth();

    @Override
    public double getEditorHeight();

    public boolean isAllowEmpty();

    public double getItemWidth();

    public double getItemHeight();

    public String getPSCodeListId();

    @Override
    public IPSAppView getRefLinkPSAppView() throws Exception;

    @Override
    public IPSAppView getRefPickupPSAppView() throws Exception;

    @Override
    public IPSDEDataSet getRefPSDEDataSet() throws Exception;

    public IPSDELogic getRefActiveDataPSDELogic() throws Exception;

    @Override
    public IPSDEACMode getRefPSDEACMode() throws Exception;

    public IPSDERBase getRefPSDER() throws Exception;

    @Override
    public String getItemHandlerType();

    @Override
    public IPSCodeList getPSCodeList();

    public boolean isEditable();

    @Override
    public JSONObject getItemParam() throws Exception;

    @Override
    public Properties getEditorParams();

    public String getPSSysValueRuleId();

    public boolean isConvertToCodeItemText();

    public boolean isNeedCodeListConfig();

    public int getOutputCodeListConfigMode();

    @Override
    public String getLabelCssStyle();

    @Override
    public String getLabelDynaClass();

    public String getCtrlCssStyle();

    @Override
    public String getEditorCssStyle();

    public String getResetItemName();

    public Iterator<String> getResetItemNames();

    public boolean isEmptyCaption();

    @Override
    public String getPlaceHolder();

    public boolean isEnableItemPriv();

    public boolean isEnableUnitName();

    public String getUnitName();

    public int getUnitNameWidth();

    public IPSDEFInputTip getPSDEFInputTip();

    public IPSLanguageRes getPHPSLanguageRes();

    public String getPHLanResTag();

    @Override
    public IPSAjaxHandler getItemPSAjaxHandler();

    @Override
    public String[] getValueItemNames();

    public boolean isRefTempData();

    public int getStdDataType();

    public int getDataType();

    public IPSDEFSearchMode getPSDEFSearchMode();

    @Override
    public String getCaption();

    @Override
    public IPSLanguageRes getCapPSLanguageRes();

    @Override
    public String getCapLanResTag();

    public boolean isShowCaption();

    public double getWidth();

    @Override
    public IPSSysImage getPSSysImage();

    @Override
    public IPSSysCss getPSSysCss();

    public void fillRelatedPSAppViews(ArrayList<IPSAppView> var1) throws Exception;

    public String getCreateDVT();

    public String getCreateDV();

    public boolean isAddSeparator();
}

