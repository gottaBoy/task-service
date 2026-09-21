/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel;

import java.util.ArrayList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CodeItemModel;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.sysmodel.UserScopeDynamicCodeListModelBase;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.psrt.srv.common.service.UserDictItemService;

public class UserScopeDictCatCodeListModel
extends UserScopeDynamicCodeListModelBase {
    private String strCat = "";

    public String getCat() {
        return this.strCat;
    }

    public void setCat(String strCat) {
        this.strCat = strCat;
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    @Override
    public String getId() {
        return this.strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public String getName() {
        return this.strName;
    }

    @Override
    public String getCodeListType() {
        return "DYNAMIC";
    }

    @Override
    public void from(ICodeListModel iCodeListModel) throws Exception {
        UserScopeDictCatCodeListModel userScopeDictCatCodeListModel = (UserScopeDictCatCodeListModel)iCodeListModel;
        this.setCat(userScopeDictCatCodeListModel.getCat());
        this.setId(userScopeDictCatCodeListModel.getId());
        this.setName(userScopeDictCatCodeListModel.getName());
        super.from(iCodeListModel);
    }

    @Override
    protected void onPrepareCodeItems() throws Exception {
        String strUserDictId = KeyValueHelper.genUniqueId("USER", this.getCurUserId());
        String strGlobalDictId = KeyValueHelper.genUniqueId("GLOBAL", "DEFAULT");
        String strSQL = "";
        strSQL = WebConfig.getCurrent().isLowCaseSql() ? StringHelper.format("select content,createdate,createman,markflag,memo,reserver,reserver2,reserver3,reserver4,updatedate,updateman,userdictcatid,userdictid,userdictitemid,userdictitemname from (select t1.content,t1.createdate,t1.createman,t1.markflag,t1.memo,t1.reserver,t1.reserver2,t1.reserver3,t1.reserver4,t1.updatedate,t1.updateman,t1.userdictcatid,t1.userdictid,t1.userdictitemid,t1.userdictitemname from t_srfuserdictitem t1  where t1.userdictid='%1$s' and t1.userdictcatid='%2$s' order by markflag desc,userdictitemname )a  union  select content,createdate,createman,markflag,memo,reserver,reserver2,reserver3,reserver4,updatedate,updateman,userdictcatid,userdictid,userdictitemid,userdictitemname from (select t1.content,t1.createdate,t1.createman,t1.markflag,t1.memo,t1.reserver,t1.reserver2,t1.reserver3,t1.reserver4,t1.updatedate,t1.updateman,t1.userdictcatid,t1.userdictid,t1.userdictitemid,t1.userdictitemname from t_srfuserdictitem t1  where t1.userdictid='%3$s' and t1.userdictcatid='%2$s' order by markflag desc ,userdictitemname)a ", strUserDictId, this.getCat(), strGlobalDictId) : StringHelper.format("select * from (select t1.* from t_srfuserdictitem t1  where t1.userdictid='%1$s' and t1.userdictcatid='%2$s' order by markflag desc,USERDICTITEMNAME )a  union  select * from (select t1.* from t_srfuserdictitem t1  where t1.userdictid='%3$s' and t1.userdictcatid='%2$s' order by markflag desc ,USERDICTITEMNAME)a ", strUserDictId, this.getCat(), strGlobalDictId);
        UserDictItemService userDictItemService = (UserDictItemService)ServiceGlobal.getService(UserDictItemService.class, this.getSessionFactory());
        ArrayList<IEntity> entityList = userDictItemService.selectRaw(strSQL, null);
        for (IEntity iEntity : entityList) {
            CodeItemModel codeItemModel = new CodeItemModel();
            codeItemModel.init(this, null, null);
            codeItemModel.setText(DataObject.getStringValue(iEntity.get("USERDICTITEMNAME")));
            codeItemModel.setValue(DataObject.getStringValue(iEntity.get("CONTENT")));
            this.registerCodeItemModel(codeItemModel);
        }
    }

    @Override
    public boolean isUserScope() {
        return true;
    }
}

