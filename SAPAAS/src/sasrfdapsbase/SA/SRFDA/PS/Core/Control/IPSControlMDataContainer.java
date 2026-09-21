/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.Control.IPSControlXDataContainer;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u754c\u9762\u90e8\u4ef6\u591a\u9879\u6570\u636e\u5bb9\u5668\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSControlMDataContainer
extends IPSControlXDataContainer {
    public static final String NEWDATAMODE_NORMAL = "NORMAL";
    public static final String NEWDATAMODE_WIZARD = "WIZARD";
    public static final String NEWDATAMODE_MULTIFORM = "MULTIFORM";
    public static final String NEWDATAMODE_ENABATADD = "ENABATADD";
    public static final String NEWDATAMODE_BATADDONLY = "BATADDONLY";
    public static final String NEWDATAMODE_INDEXDE = "INDEXDE";
    public static final String EDITDATAMODE_NORMAL = "NORMAL";
    public static final String EDITDATAMODE_MULTIFORM = "MULTIFORM";
    public static final String EDITDATAMODE_INDEXDE = "INDEXDE";
    public static final String NEWDATAMODE_WIZARD2 = "WIZARD2";
    public static final String VIEWREFMODE_NEWDATA = "NEWDATA";
    public static final String VIEWREFMODE_EDITDATA = "EDITDATA";
    public static final String VIEWREFMODE_EDITDATAX = "EDITDATAX";
    public static final String VIEWREFMODE_OPENDATA = "OPENDATA";
    public static final String VIEWREFMODE_NEWDATAWIZARD = "NEWDATAWIZARD";
    public static final String VIEWREFMODE_MPICKUPVIEW = "MPICKUPVIEW";
    public static final String VIEWLOGIC_NEWDATA = "newdata";
    public static final String VIEWLOGIC_EDITDATA = "editdata";
    public static final String VIEWLOGIC_OPENDATA = "opendata";

    public String getNewDataMode();

    public String getEditDataMode();

    @Override
    public boolean isLoadDefault();

    public boolean isEnableBatchAdd();

    public boolean isBatchAddOnly();

    public boolean isPickupMode();

    public boolean isEnableViewData();

    public boolean isEnableImport();

    public boolean isEnableExport();

    public boolean isEnableFilter();

    public boolean isEnableQuickSearch();

    public boolean isEnableSearch();

    public boolean isEnableQuickCreate();

    public String getActionAfterNewDataWizard();

    public Iterator<IPSDEDQCondition> getADPSDEDQConditions() throws Exception;

    public IPSAppViewRef getPSAppViewRef(String var1, boolean var2) throws Exception;

    public Iterator<IPSAppViewRef> getPSAppViewRefs();

    public Iterator<IPSAppViewRef> getPSAppViewRefs(String var1) throws Exception;
}

