/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Notify;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.Notify.IPSDENotifyTarget;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgQueue;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Data.PSDENotify;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u901a\u77e5\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDENotify")
public interface IPSDENotify
extends IPSDataEntityObject {
    public static final int TASKMODE_NONE = 0;
    public static final int TASKMODE_TODO = 1;

    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDENotify var3) throws Exception;

    @Override
    public String getCodeName();

    public Iterator<IPSDENotifyTarget> getPSDENotifyTargets();

    public IPSDEDataSet getPSDEDataSet();

    public IPSDEField getBeginTimePSDEField();

    public IPSDEField getEndTimePSDEField();

    public IPSSysMsgQueue getPSSysMsgQueue() throws Exception;

    public IPSSysMsgTempl getPSSysMsgTempl() throws Exception;

    public int getNotifyStart();

    public int getNotifyEnd();

    public int getCheckTimer();

    public String getNotifyTag();

    public String getNotifyTag2();

    public boolean isTimerMode();

    public String getCustomCond();

    public int getMsgType();

    public int getTaskMode();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();

    public String getEvents();

    public String getEventModel();

    public String getFields();

    public String getFilterModel();

    public String getNotifySubType();

    public boolean isIgnoreException();

    public int getThreadMode();

    public boolean isValid();

    public boolean isTemplate();
}

