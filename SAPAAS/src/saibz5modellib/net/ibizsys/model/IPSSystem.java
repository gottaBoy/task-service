/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.ISystem
 */
package net.ibizsys.model;

import java.util.Iterator;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIAction;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup;
import net.ibizsys.model.der.IPSDERBase;
import net.ibizsys.model.dynasys.IPSDynaInst;
import net.ibizsys.model.res.IPSLanguageItem;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysDBValueFunc;
import net.ibizsys.model.res.IPSSysEditorStyle;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.model.res.IPSSysLan;
import net.ibizsys.model.res.IPSSysPDTView;
import net.ibizsys.model.res.IPSSysPortlet;
import net.ibizsys.model.security.IPSSysUniRes;
import net.ibizsys.model.valuerule.IPSSysValueRule;
import net.ibizsys.model.wf.IPSWFRole;
import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.paas.core.ISystem;

public interface IPSSystem
extends IPSModelObject,
ISystem {
    public IPSDataEntity getPSDataEntity(String var1) throws Exception;

    public IPSDataEntity getPSDataEntity(String var1, boolean var2) throws Exception;

    public IPSApplication getPSApplication(String var1) throws Exception;

    public IPSSysUniRes getPSSysUniRes(String var1) throws Exception;

    public IPSSysImage getPSSysImage(String var1) throws Exception;

    public IPSSysCss getPSSysCss(String var1) throws Exception;

    public IPSSysCounter getPSSysCounter(String var1, boolean var2) throws Exception;

    public IPSCodeList getPSCodeList(String var1) throws Exception;

    public IPSSysEditorStyle getPSSysEditorStyle(String var1) throws Exception;

    public IPSSysEditorStyle getDefaultPSSysEditorStyle(String var1);

    public IPSSysDBValueFunc getPSSysDBValueFunc(String var1) throws Exception;

    public IPSSysPortlet getPSSysPortlet(String var1) throws Exception;

    public IPSLanguageRes getPSLanguageRes(String var1) throws Exception;

    public int getVersion();

    public IPSDEUIActionGroup getPSDEUIActionGroup(String var1, boolean var2) throws Exception;

    public IPSDEOPPriv getPSDEOPPriv(String var1) throws Exception;

    public IPSDEUIAction getPSDEUIAction(String var1, boolean var2) throws Exception;

    public boolean isNoViewMode();

    public IPSWorkflow getPSWorkflow(String var1) throws Exception;

    public IPSWorkflow getPSWorkflow(String var1, boolean var2) throws Exception;

    public IPSSysPDTView getPSSysPDTView(String var1) throws Exception;

    public IPSDERBase getPSDER(String var1) throws Exception;

    public IPSSysValueRule getPSSysValueRule(String var1) throws Exception;

    public String getSFType();

    public IPSCodeList getPSCodeListByTempl(String var1) throws Exception;

    public IPSLanguageItem getPSLanguageItem(String var1, boolean var2) throws Exception;

    public String getLogicName();

    public IPSWFRole getPSWFRole(String var1) throws Exception;

    public String getPSSFId();

    public String getPSSFName();

    public Iterator<IPSSysLan> getAllPSSysLans() throws Exception;

    public String getDefaultLanguage();

    public boolean isEnableMultiLan();

    public boolean hasPSWFEngineType(String var1) throws Exception;

    public Iterator<IPSWorkflow> getAllPSWorkflows() throws Exception;

    public Iterator<IPSWFRole> getAllPSWFRoles() throws Exception;

    public int getDBVersion();

    public boolean isEnableDynaSys();

    public String getPSSysModelInstId();

    public Iterator<IPSApplication> getAllPSApps() throws Exception;

    public IPSDynaInst getPSDynaInst(String var1) throws Exception;

    public void resetAllPSDynaInsts();

    public void resetPSDynaInst(String var1);
}

