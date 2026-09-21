/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFInteractiveProcessModel
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFProcessRole;
import java.util.Iterator;
import net.ibizsys.pswf.core.IWFInteractiveProcessModel;

@PSModelExtendMeta(title="\u5de5\u4f5c\u6d41\u4ea4\u4e92\u5904\u7406\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", extend="IPSWFProcess", typevalue={"INTERACTIVE"})
public interface IPSWFInteractiveProcess
extends IPSWFProcess,
IWFInteractiveProcessModel {
    public static final String PREDEFINEDACTION_SENDBACK = "SENDBACK";
    public static final String PREDEFINEDACTION_SUPPLYINFO = "SUPPLYINFO";
    public static final String PREDEFINEDACTION_ADDSTEPBEFORE = "ADDSTEPBEFORE";
    public static final String PREDEFINEDACTION_ADDSTEPAFTER = "ADDSTEPAFTER";
    public static final String PREDEFINEDACTION_TAKEADVICE = "TAKEADVICE";
    public static final String PREDEFINEDACTION_SENDCOPY = "SENDCOPY";
    public static final String PREDEFINEDACTION_USERACTION = "USERACTION";
    public static final String PREDEFINEDACTION_USERACTION2 = "USERACTION2";
    public static final String PREDEFINEDACTION_USERACTION3 = "USERACTION3";
    public static final String PREDEFINEDACTION_USERACTION4 = "USERACTION4";
    public static final String PREDEFINEDACTION_USERACTION5 = "USERACTION5";
    public static final String PREDEFINEDACTION_USERACTION6 = "USERACTION6";
    public static final String PREDEFINEDACTION_REASSIGN = "REASSIGN";
    public static final int EDITMODE_NONE = 0;
    public static final int EDITMODE_EXCLUDE = 1;
    public static final int EDITMODE_INCLUDE = 2;

    public Iterator<IPSWFProcessRole> getPSWFProcessRoles();

    public IPSWFProcessRole getPSWFProcessRole(String var1) throws Exception;

    public Iterator<String> getPredefinedActions();

    public boolean isEnablePredefinedAction(String var1);

    @Override
    public IPSSysMsgTempl getPSSysMsgTempl();

    public String getPSDEFormId();

    public String getFormCodeName();

    public String getFormName();

    public String getMobPSDEFormId();

    public String getMobFormCodeName();

    public String getMobFormName();

    public String getUtilPSDEFormId();

    public String getUtilFormCodeName();

    public String getMobUtilPSDEFormId();

    public String getMobUtilFormCodeName();

    public String getUtil2PSDEFormId();

    public String getUtil2FormCodeName();

    public String getMobUtil2PSDEFormId();

    public String getMobUtil2FormCodeName();

    public String getUtil3PSDEFormId();

    public String getUtil3FormCodeName();

    public String getMobUtil3PSDEFormId();

    public String getMobUtil3FormCodeName();

    public String getUtil4PSDEFormId();

    public String getUtil4FormCodeName();

    public String getMobUtil4PSDEFormId();

    public String getMobUtil4FormCodeName();

    public String getUtil5PSDEFormId();

    public String getUtil5FormCodeName();

    public String getMobUtil5PSDEFormId();

    public String getMobUtil5FormCodeName();

    public String getUtilFormName();

    public String getMobUtilFormName();

    public String getUtil2FormName();

    public String getMobUtil2FormName();

    public String getUtil3FormName();

    public String getMobUtil3FormName();

    public String getUtil4FormName();

    public String getMobUtil4FormName();

    public String getUtil5FormName();

    public String getMobUtil5FormName();

    public boolean isEditable();

    public int getEditMode();

    public Iterator<String> getEditFields();

    public String getMemoField();

    public boolean isSendInform();

    public String getMsgTemplateId();

    public int getMsgType();

    public boolean isActorIAActionControl();

    public Iterator<String> getUDActors();

    public String getMultiInstMode();

    public String getPSDEUAGroupId();

    public String getUAGroupCodeName();

    public String getMobPSDEUAGroupId();

    public String getMobUAGroupCodeName();

    public IPSDataEntity getPSDataEntity();
}

