/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicParam;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u6d88\u606f\u5f39\u7a97\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"MSGBOX"})
public interface IPSDEUIMsgBoxLogic
extends IPSDEUILogicNode {
    public static final String BUTTONSTYPE_YESNO = "YESNO";
    public static final String BUTTONSTYPE_YESNOCANCEL = "YESNOCANCEL";
    public static final String BUTTONSTYPE_OK = "OK";
    public static final String BUTTONSTYPE_OKCANCEL = "OKCANCEL";
    public static final String MSGBOXTYPE_INFO = "INFO";
    public static final String MSGBOXTYPE_QUESTION = "QUESTION";
    public static final String MSGBOXTYPE_WARNING = "WARNING";
    public static final String MSGBOXTYPE_ERROR = "ERROR";
    public static final String MSGBOXTYPE_PROMPT = "PROMPT";
    public static final String MSGBOXPARAM_TITLE = "title";
    public static final String MSGBOXPARAM_MESSAGE = "message";
    public static final String MSGBOXPARAM_RESULT = "result";
    public static final String MSGBOXPARAM_INPUT = "input";
    public static final String MSGBOXRESULT_OK = "OK";
    public static final String MSGBOXRESULT_CANCEL = "CANCEL";
    public static final String MSGBOXRESULT_YES = "YES";
    public static final String MSGBOXRESULT_NO = "NO";

    public String getTitle();

    public String getMessage();

    public String getMsgBoxType();

    public String getButtonsType();

    public String getShowMode();

    public IPSDEUILogicParam getMsgBoxParam() throws Exception;
}

