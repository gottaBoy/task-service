/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.SecurityEx.Web.DefaultUserPrivilegeMgr
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.ISRFExWebContext
 *  SA.SRFramework.WebEx.SRFExHttpServletContext
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Security;

import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAHttpServletContext;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.SecurityEx.Web.DefaultUserPrivilegeMgr;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ISRFExWebContext;
import SA.SRFramework.WebEx.SRFExHttpServletContext;
import SA.SRFramework.WebEx.SRFExWebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DAUserPrivilegeMgr
extends DefaultUserPrivilegeMgr {
    private static final Log log = LogFactory.getLog(DAUserPrivilegeMgr.class);

    protected synchronized boolean InternalTest(SRFExWebContext webContext, String strResourceId) {
        if (StringHelper.Compare((String)"NONE", (String)strResourceId, (boolean)true) == 0) {
            return true;
        }
        if (StringHelper.Compare((String)webContext.getCurUserId(), (String)"SYSTEM", (boolean)true) == 0) {
            return true;
        }
        SRFDAWebContext daWebContext = (SRFDAWebContext)webContext;
        String[] parts = strResourceId.split("[:]");
        if (parts.length == 1) {
            CallResult callResult = daWebContext.GetUserRoleHelper().GetUserRoleRes("CUSTOM", strResourceId);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u89d2\u8272\u8d44\u6e90[%1$s]\u6743\u9650\u5931\u8d25\uff0c%2$s", (Object)strResourceId, (Object)callResult.getErrorInfo()));
                return false;
            }
            return (Boolean)callResult.getUserObject();
        }
        if (parts.length == 2) {
            String strResType = parts[0];
            if (StringHelper.Compare((String)strResType, (String)"PAGERESID", (boolean)true) == 0) {
                CallResult callResult = daWebContext.GetUserRoleHelper().GetUserRoleRes("PAGE", parts[1]);
                if (callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u89d2\u8272\u8d44\u6e90[%1$s]\u6743\u9650\u5931\u8d25\uff0c%2$s", (Object)strResourceId, (Object)callResult.getErrorInfo()));
                    return false;
                }
                return (Boolean)callResult.getUserObject();
            }
            if (StringHelper.Compare((String)strResType, (String)"REPORTRESID", (boolean)true) == 0) {
                CallResult callResult = daWebContext.GetUserRoleHelper().GetUserRoleRes("REPORT", parts[1]);
                if (callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u89d2\u8272\u8d44\u6e90[%1$s]\u6743\u9650\u5931\u8d25\uff0c%2$s", (Object)strResourceId, (Object)callResult.getErrorInfo()));
                    return false;
                }
                return (Boolean)callResult.getUserObject();
            }
            return false;
        }
        if (parts.length == 3) {
            String strResType = parts[0];
            if (StringHelper.Compare((String)strResType, (String)"DEDATARESID", (boolean)true) == 0) {
                CallResult callResult = daWebContext.GetUserRoleHelper().TestUserRoleDataAction(parts[1], parts[2]);
                if (callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u89d2\u8272\u8d44\u6e90[%1$s]\u6743\u9650\u5931\u8d25\uff0c%2$s", (Object)strResourceId, (Object)callResult.getErrorInfo()));
                    return false;
                }
                return (Boolean)callResult.getUserObject();
            }
            return false;
        }
        return false;
    }

    protected synchronized boolean InternalTest(SRFExHttpServletContext servletContext, String strResourceId) {
        if (StringHelper.Compare((String)"NONE", (String)strResourceId, (boolean)true) == 0) {
            return true;
        }
        if (StringHelper.Compare((String)servletContext.getCurUserId(), (String)"SYSTEM", (boolean)true) == 0) {
            return true;
        }
        SRFDAHttpServletContext daWebContext = (SRFDAHttpServletContext)servletContext;
        String[] parts = strResourceId.split("[:]");
        if (parts.length == 1) {
            CallResult callResult = daWebContext.GetUserRoleHelper().GetUserRoleRes("CUSTOM", strResourceId);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u89d2\u8272\u8d44\u6e90[%1$s]\u6743\u9650\u5931\u8d25\uff0c%2$s", (Object)strResourceId, (Object)callResult.getErrorInfo()));
                return false;
            }
            return (Boolean)callResult.getUserObject();
        }
        if (parts.length == 2) {
            String strResType = parts[0];
            if (StringHelper.Compare((String)strResType, (String)"PAGERESID", (boolean)true) == 0) {
                CallResult callResult = daWebContext.GetUserRoleHelper().GetUserRoleRes("PAGE", parts[1]);
                if (callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u89d2\u8272\u8d44\u6e90[%1$s]\u6743\u9650\u5931\u8d25\uff0c%2$s", (Object)strResourceId, (Object)callResult.getErrorInfo()));
                    return false;
                }
                return (Boolean)callResult.getUserObject();
            }
            if (StringHelper.Compare((String)strResType, (String)"REPORTRESID", (boolean)true) == 0) {
                CallResult callResult = daWebContext.GetUserRoleHelper().GetUserRoleRes("REPORT", parts[1]);
                if (callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u89d2\u8272\u8d44\u6e90[%1$s]\u6743\u9650\u5931\u8d25\uff0c%2$s", (Object)strResourceId, (Object)callResult.getErrorInfo()));
                    return false;
                }
                return (Boolean)callResult.getUserObject();
            }
            return false;
        }
        if (parts.length == 3) {
            String strResType = parts[0];
            if (StringHelper.Compare((String)strResType, (String)"DEDATA", (boolean)true) == 0) {
                CallResult callResult = daWebContext.GetUserRoleHelper().TestUserRoleDataAction(parts[1], parts[2]);
                if (callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u89d2\u8272\u8d44\u6e90[%1$s]\u6743\u9650\u5931\u8d25\uff0c%2$s", (Object)strResourceId, (Object)callResult.getErrorInfo()));
                    return false;
                }
                return (Boolean)callResult.getUserObject();
            }
            return false;
        }
        return false;
    }

    protected synchronized void InternalLogTest(SRFExWebContext webContext, Object object, String strResourceId) {
    }

    protected int InternalTestColumn(ISRFExWebContext webContext, String strResourceId) {
        if (StringHelper.Compare((String)webContext.getCurUserId(), (String)"SYSTEM", (boolean)true) == 0) {
            return 3;
        }
        String[] parts = strResourceId.split("[|]");
        if (parts.length == 2) {
            CallResult callResult = ((ISRFDAWebContext)webContext).GetUserRoleHelper().GetUserRoleDEField(parts[0], parts[1]);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u89d2\u8272\u5b9e\u4f53\u5c5e\u6027[%1$s]\u6743\u9650\u5931\u8d25\uff0c%2$s", (Object)strResourceId, (Object)callResult.getErrorInfo()));
                return 0;
            }
            return (Integer)callResult.getUserObject();
        }
        log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5b9e\u4f53\u5c5e\u6027\u8d44\u6e90\u6807\u8bc6[%1$s]", (Object)strResourceId));
        return 0;
    }
}

