/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.sysmodel;

import java.util.ArrayList;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CodeItemModel;
import net.ibizsys.paas.sysmodel.DynamicCodeListModelBase;
import net.ibizsys.paas.sysmodel.SysModelGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.psrt.srv.common.entity.User;
import net.ibizsys.psrt.srv.common.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class SysOperatorCodeListModelBase
extends DynamicCodeListModelBase {
    private static final Log log = LogFactory.getLog(SysOperatorCodeListModelBase.class);

    @Override
    protected IService getService() {
        try {
            return ServiceGlobal.getService(UserService.class);
        }
        catch (Exception ex) {
            return null;
        }
    }

    @Override
    protected void onPrepareCodeItems() throws Exception {
        try {
            UserService userService = (UserService)ServiceGlobal.getService(UserService.class);
            SelectCond selectCond = new SelectCond();
            ArrayList userList = userService.select(selectCond);
            for (User user : userList) {
                CodeItemModel codeItemModel = new CodeItemModel();
                codeItemModel.setText(user.getUserName());
                codeItemModel.setValue(user.getUserId());
                this.registerCodeItemModel(codeItemModel);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    public String getCodeListText(String strValue, boolean bRecursion, Object activeData, IWebContext iWebContext) throws Exception {
        CodeItemModel iCodeItem;
        this.prepareCodeItems();
        if (StringHelper.isNullOrEmpty(strValue)) {
            strValue = "";
        }
        if ((iCodeItem = this.getCodeItemModel(strValue)) != null) {
            return iCodeItem.getText();
        }
        if (StringHelper.isNullOrEmpty(strValue)) {
            CodeItemModel codeItemModel = new CodeItemModel();
            codeItemModel.setText(StringHelper.format("UID:%1$s", strValue));
            codeItemModel.setValue(strValue);
            this.registerCodeItemModel(codeItemModel);
            return codeItemModel.getText();
        }
        try {
            UserService userService = (UserService)ServiceGlobal.getService(UserService.class);
            User user = new User();
            user.setUserId(strValue);
            if (userService.get(user, true)) {
                CodeItemModel codeItemModel = new CodeItemModel();
                codeItemModel.setText(user.getUserName());
                codeItemModel.setValue(user.getUserId());
                this.registerCodeItemModel(codeItemModel);
                return user.getUserName();
            }
            CodeItemModel codeItemModel = new CodeItemModel();
            if (SysModelGlobal.isUseLoginNameAsOperator()) {
                codeItemModel.setText(strValue);
            } else {
                codeItemModel.setText(StringHelper.format("UID:%1$s", strValue));
            }
            codeItemModel.setValue(user.getUserId());
            this.registerCodeItemModel(codeItemModel);
            return codeItemModel.getText();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            CodeItemModel codeItemModel = new CodeItemModel();
            if (SysModelGlobal.isUseLoginNameAsOperator()) {
                codeItemModel.setText(strValue);
            } else {
                codeItemModel.setText(StringHelper.format("UID:%1$s", strValue));
            }
            codeItemModel.setValue(strValue);
            this.registerCodeItemModel(codeItemModel);
            return codeItemModel.getText();
        }
    }
}

