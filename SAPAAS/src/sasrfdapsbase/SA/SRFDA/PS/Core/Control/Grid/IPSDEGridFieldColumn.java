/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumn;
import SA.SRFDA.PS.Core.Control.IPSEditor;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u5b9e\u4f53\u8868\u683c\u5c5e\u6027\u5217\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DEFGRIDCOLUMN"})
public interface IPSDEGridFieldColumn
extends IPSDEGridColumn {
    public static final int ENABLELINK_NO = 0;
    public static final int ENABLELINK_YES = 1;
    public static final int ENABLELINK_AUTO = 2;

    public IPSDEField getPSDEField();

    public IPSCodeList getPSCodeList();

    public String getPSCodeListId();

    public IPSAppCodeList getPSAppCodeList();

    public String getValueFormat();

    public String[] getFields();

    public boolean isEnableItemPriv();

    public String getItemPrivId();

    public String getGroupItem();

    public IPSDEUIAction getPSDEUIAction();

    public String getCLConvertMode();

    public boolean isGenerateDataItems();

    public boolean isTreeNodeColumn();

    public int getTreeColumnMode();

    public IPSAppDEField getPSAppDEField();

    public boolean isEnableLinkView();

    public int getEnableLink();

    public String getLinkValueItem();

    public IPSAppView getLinkPSAppView() throws Exception;

    public String getUnitName();

    public int getUnitNameWidth();

    public boolean isEnableUnitName();

    public IPSEditor getFilterPSEditor() throws Exception;

    public String getObjectNameField();

    public String getObjectIdField();

    public String getObjectValueField();

    public String getValueSeparator();

    public String getTextSeparator();

    public String getValueType();

    public IPSDEUIActionGroup getPSDEUIActionGroup();
}

