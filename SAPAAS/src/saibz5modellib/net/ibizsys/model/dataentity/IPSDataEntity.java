/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDataEntity
 */
package net.ibizsys.model.dataentity;

import java.util.Iterator;
import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.dataentity.ac.IPSDEACMode;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.dataexport.IPSDEDataExport;
import net.ibizsys.model.dataentity.dr.IPSDEDRGroup;
import net.ibizsys.model.dataentity.dr.IPSDEDRItem;
import net.ibizsys.model.dataentity.dr.IPSDEDataRelation;
import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.field.IPSPickupDEField;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.dataentity.mainstate.IPSDEMainState;
import net.ibizsys.model.dataentity.print.IPSDEPrint;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIAction;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup;
import net.ibizsys.model.dataentity.util.IPSDEUtil;
import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.model.der.IPSDER11;
import net.ibizsys.model.der.IPSDER1N;
import net.ibizsys.model.der.IPSDERBase;
import net.ibizsys.model.der.IPSDERIndex;
import net.ibizsys.model.der.IPSDERInherit;
import net.ibizsys.model.der.IPSDERMultiInherit;
import net.ibizsys.model.der.IPSDERNN;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.paas.core.IDataEntity;

public interface IPSDataEntity
extends IDataEntity,
IPSSystemObject {
    public static final int DETYPE_MAJOR = 1;
    public static final int DETYPE_ATTACHED = 2;
    public static final int DETYPE_RELATED = 3;
    public static final int EXTENDMODE_NONE = 0;
    public static final int EXTENDMODE_SUBSYS = 2;
    public static final int ENABLEUIACTION_CREATE = 1;
    public static final int ENABLEUIACTION_UPDATE = 2;
    public static final int ENABLEUIACTION_REMOVE = 4;
    public static final int ENABLEUIACTION_VIEW = 8;
    public static final int VIRTUALMODE_NONE = 0;
    public static final int VIRTUALMODE_MINHERIT = 1;
    public static final int VIRTUALMODE_INHERIT = 2;

    public Iterator<IPSDEField> getPSDEFields() throws Exception;

    public Iterator<IPSDEField> getAllPSDEFields() throws Exception;

    public IPSDEField getPSDEField(String var1) throws Exception;

    public IPSDEField getPSDEField(String var1, boolean var2) throws Exception;

    public String getFullName();

    public boolean isLogicValid();

    public Object getLogicValidValue(boolean var1);

    public String getLogicValidStringValue(boolean var1);

    public int getVersion();

    public IPSDEField getKeyPSDEField();

    public IPSDEField getMajorPSDEField();

    public IPSDEField getLogicValidPSDEField() throws Exception;

    public IPSPickupDEField getPSPickupDEField(String var1) throws Exception;

    public IPSDataEntity getInheritPSDataEntity() throws Exception;

    public IPSDERInherit getPSDERInherit() throws Exception;

    public IPSDEField getPSDEFieldByPDT(String var1, boolean var2) throws Exception;

    public Iterator<IPSDEField> getPSDEFieldsByDER(String var1) throws Exception;

    public IPSDEUIAction getPSDEUIAction(String var1) throws Exception;

    public IPSDEUIAction getPSDEUIAction(String var1, boolean var2) throws Exception;

    public IPSDEUIActionGroup getPSDEUIActionGroup(String var1) throws Exception;

    public IPSDEUIActionGroup getPSDEUIActionGroup(String var1, boolean var2) throws Exception;

    public IPSDERBase getPSDER(boolean var1, String var2) throws Exception;

    public IPSDERBase getPSDER(boolean var1, String var2, boolean var3) throws Exception;

    public Iterator<IPSDERBase> getPSDERs(boolean var1);

    public Iterator<IPSDERBase> getMajorPSDERs();

    public Iterator<IPSDERBase> getMinorPSDERs();

    public IPSDEDataQuery getPSDEDataQuery(String var1) throws Exception;

    public IPSDEDataSet getPSDEDataSet(String var1) throws Exception;

    public Iterator<IPSDEDataSet> getAllPSDEDataSets() throws Exception;

    public Iterator<IPSDataEntity> getAllMasterPSDataEntities() throws Exception;

    public IPSDEAction getPSDEAction(String var1) throws Exception;

    public IPSDEAction getPSDEAction(String var1, boolean var2) throws Exception;

    public IPSDEField getIndexTypePSDEField();

    public Iterator<IPSDEACMode> getAllPSDEACModes() throws Exception;

    public IPSDEACMode getPSDEACMode(String var1) throws Exception;

    public IPSDEDataRelation getPSDEDataRelation(String var1) throws Exception;

    public IPSDEDRGroup getPSDEDRGroup(String var1) throws Exception;

    public IPSDEDRItem getPSDEDRItem(String var1) throws Exception;

    public Iterator<IPSDEDataQuery> getAllPSDEDataQueries() throws Exception;

    public String getCodeName();

    public Iterator<IPSDEField> getUnionKeyValuePSDEFields();

    public Iterator<IPSDER1N> getPSDER1Ns(boolean var1, boolean var2);

    public Iterator<IPSDER1N> getPSDER1Ns(boolean var1);

    public Iterator<IPSDER1N> getRemovePSDER1Ns();

    public Iterator<IPSDER1N> getClonePSDER1Ns();

    public Iterator<IPSDERIndex> getPSDERIndexs(boolean var1);

    public String getIndexDEType();

    public String getLogicName(String var1);

    public String getLNLanResTag();

    public IPSLanguageRes getLNPSLanguageRes();

    public IPSDELogic getPSDELogic(String var1) throws Exception;

    public boolean isEnableTempData();

    public boolean isEnableMultiForm();

    public IPSDEField getFormTypePSDEField();

    public int getDEType();

    public IPSDERNN getPSDERNN() throws Exception;

    public Iterator<IPSDEWF> getAllPSDEWFs() throws Exception;

    public IPSDEWF getPSDEWF(String var1) throws Exception;

    public boolean hasPSDEWF() throws Exception;

    public IPSDEWF getDefaultPSDEWF() throws Exception;

    public IPSDEOPPriv getPSDEOPPriv(String var1) throws Exception;

    public Iterator<IPSDEMainState> getAllPSDEMainStates() throws Exception;

    public IPSDEMainState getPSDEMainState(String var1) throws Exception;

    public IPSDEMainState getPSDEMainState(String var1, boolean var2) throws Exception;

    public boolean isEnableDEMainState();

    public boolean isEnableOrgModel();

    public Iterator<IPSDEField> getDEMainStateDEFields();

    public IPSDEFValueRule getPSDEFValueRule(String var1) throws Exception;

    public Iterator<IPSDEFValueRule> getAllPSDEFValueRules() throws Exception;

    public IPSSysImage getPSSysImage();

    public String getPSDEViewIdByPDT(String var1) throws Exception;

    public Iterator<IPSDEPrint> getAllPSDEPrints() throws Exception;

    public IPSDEPrint getPSDEPrint(String var1) throws Exception;

    public IPSDEPrint getPSDEPrint(String var1, boolean var2) throws Exception;

    public IPSDEPrint getDefaultPSDEPrint() throws Exception;

    public boolean hasPSDEPrint() throws Exception;

    public IPSDER11 getPSDER11() throws Exception;

    public Iterator<IPSDER11> getPSDER11s() throws Exception;

    public boolean isVirtual();

    public Iterator<IPSDERMultiInherit> getPSDERMultiInherits(boolean var1) throws Exception;

    public Iterator<IPSDEDataExport> getAllPSDEDataExports() throws Exception;

    public IPSDEDataExport getPSDEDataExport(String var1) throws Exception;

    public IPSDEDataExport getPSDEDataExport(String var1, boolean var2) throws Exception;

    public String getServiceCodeName();

    public int getEnableUIActions();

    public IPSDEUtil getPSDEUtil(String var1, boolean var2) throws Exception;

    public boolean isEnableDynaStorage();

    public int getVirtualMode();

    public String getPSDynaDETemplId();

    public Iterator<String> getPDTViewNames();
}

