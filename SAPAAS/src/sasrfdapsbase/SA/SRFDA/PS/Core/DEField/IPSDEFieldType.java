/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFSearchFormItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEFGridColumn;
import SA.SRFDA.PS.Core.DEField.IPSDEFSearchMode;
import SA.SRFDA.PS.Core.DEField.IPSDEFUIMode;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEFSearchMode;
import SA.SRFDA.PS.Data.PSDEFUIMode;
import SA.SRFDA.PS.Data.PSDEField;
import SA.SRFDA.PS.Data.PSDEFieldType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5c5e\u6027\u7c7b\u578b\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", model="PSSysDEFType")
public interface IPSDEFieldType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSDEFieldType var2) throws Exception;

    public boolean isSupportPSDEField(String var1);

    public IPSDEField createPSDEField(PSDEField var1) throws Exception;

    public String getPSCodeListTemplId();

    public int getStdDataType();

    public int getPrecision();

    public String getUnit();

    public int getUnitWidth();

    public IPSDEFGridColumn createPSDEFGridColumn(PSDEFUIMode var1) throws Exception;

    public IPSDEFFormItem createPSDEFFormItem(PSDEFUIMode var1) throws Exception;

    public IPSDEFUIMode createPSDEFUIMode(PSDEFUIMode var1) throws Exception;

    public IPSDEFSearchMode createPSDEFSearchMode(PSDEFSearchMode var1) throws Exception;

    public IPSDEFSearchFormItem createPSDEFSearchFormItem(PSDEFSearchMode var1) throws Exception;

    public String getEditorType();

    public Integer getEditorWidth();

    public Integer getEditorHeight();

    public String getValueFormat(String var1);

    public int getStringLength();

    public int getMinStringLength();

    public int getLength();

    public String getMBEditorType();

    public Integer getMBEditorWidth();

    public Integer getMBEditorHeight();

    public String getTestDataValue();

    public String getPSUnitId();

    public String getPSValueRuleId();

    public boolean isAutoIncrement();

    public boolean isUnsigned();

    public String getSearchEditorType();

    public Integer getSearchEditorWidth();

    public Integer getSearchEditorHeight();

    public String getSearchMBEditorType();

    public Integer getSearchMBEditorWidth();

    public Integer getSearchMBEditorHeight();

    public String getMaxValueString();

    public String getMinValueString();

    public String getGridColumnAlign();
}

