package net.ibizsys.paas.sysmodel;

import java.util.ArrayList;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.psrt.srv.common.entity.UserDictItem;
import net.ibizsys.psrt.srv.common.service.UserDictItemService;

/**
 * 用户范围词条类别
 * 
 * @author Administrator
 *
 */
public class UserScopeDictCatCodeListModel extends UserScopeDynamicCodeListModelBase {
	/**
	 * 词条类别
	 */
	private String strCat = "";

	/**
	 * 获取类别
	 * 
	 * @return the strCat
	 */
	public String getCat() {
		return strCat;
	}

	/**
	 * 设置类别
	 * 
	 * @param strCat the strCat to set
	 */
	public void setCat(String strCat) {
		this.strCat = strCat;
	}

	/**
	 * 设置标识
	 * 
	 * @param strId
	 */
	public void setId(String strId) {
		this.strId = strId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.CodeListModelBase#getId()
	 */
	@Override
	public String getId() {
		return this.strId;
	}

	/**
	 * 设置名称
	 * 
	 * @param strName
	 */
	public void setName(String strName) {
		this.strName = strName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.CodeListModelBase#getName()
	 */
	@Override
	public String getName() {
		return this.strName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.CodeListModelBase#getCodeListType()
	 */
	@Override
	public String getCodeListType() {
		return ICodeList.CLTYPE_DYNAMIC;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.CodeListModelBase#from(net.ibizsys.paas.sysmodel.ICodeListModel)
	 */
	@Override
	public void from(ICodeListModel iCodeListModel) throws Exception {
		UserScopeDictCatCodeListModel userScopeDictCatCodeListModel = (UserScopeDictCatCodeListModel) iCodeListModel;
		this.setCat(userScopeDictCatCodeListModel.getCat());
		this.setId(userScopeDictCatCodeListModel.getId());
		this.setName(userScopeDictCatCodeListModel.getName());

		super.from(iCodeListModel);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.DynamicCodeListModelBase#onPrepareCodeItems()
	 */
	@Override
	protected void onPrepareCodeItems() throws Exception {
		String strUserDictId = KeyValueHelper.genUniqueId("USER", this.getCurUserId());
		String strGlobalDictId = KeyValueHelper.genUniqueId("GLOBAL", "DEFAULT");

		// 查询
		String strSQL = "";
		if(WebConfig.getCurrent().isLowCaseSql()) {
			strSQL = StringHelper.format("select content,createdate,createman,markflag,memo,reserver,reserver2,reserver3,reserver4,updatedate,updateman,userdictcatid,userdictid,userdictitemid,userdictitemname from (select t1.content,t1.createdate,t1.createman,t1.markflag,t1.memo,t1.reserver,t1.reserver2,t1.reserver3,t1.reserver4,t1.updatedate,t1.updateman,t1.userdictcatid,t1.userdictid,t1.userdictitemid,t1.userdictitemname from t_srfuserdictitem t1  where t1.userdictid='%1$s' and t1.userdictcatid='%2$s' order by markflag desc,userdictitemname )a " + " union " + " select content,createdate,createman,markflag,memo,reserver,reserver2,reserver3,reserver4,updatedate,updateman,userdictcatid,userdictid,userdictitemid,userdictitemname from (select t1.content,t1.createdate,t1.createman,t1.markflag,t1.memo,t1.reserver,t1.reserver2,t1.reserver3,t1.reserver4,t1.updatedate,t1.updateman,t1.userdictcatid,t1.userdictid,t1.userdictitemid,t1.userdictitemname from t_srfuserdictitem t1  where t1.userdictid='%3$s' and t1.userdictcatid='%2$s' order by markflag desc ,userdictitemname)a ", strUserDictId, this.getCat(), strGlobalDictId);
		}else {
			strSQL = StringHelper.format("select * from (select t1.* from t_srfuserdictitem t1  where t1.userdictid='%1$s' and t1.userdictcatid='%2$s' order by markflag desc,USERDICTITEMNAME )a " + " union " + " select * from (select t1.* from t_srfuserdictitem t1  where t1.userdictid='%3$s' and t1.userdictcatid='%2$s' order by markflag desc ,USERDICTITEMNAME)a ", strUserDictId, this.getCat(), strGlobalDictId);
		}
		UserDictItemService userDictItemService = (UserDictItemService) ServiceGlobal.getService(UserDictItemService.class, this.getSessionFactory());
		ArrayList<IEntity> entityList = userDictItemService.selectRaw(strSQL, null);
		for (IEntity iEntity : entityList) {
			CodeItemModel codeItemModel = new CodeItemModel();
			codeItemModel.init(this, null, null);
			codeItemModel.setText(DataObject.getStringValue(iEntity.get(UserDictItem.FIELD_USERDICTITEMNAME)));
			codeItemModel.setValue(DataObject.getStringValue(iEntity.get(UserDictItem.FIELD_CONTENT)));
			this.registerCodeItemModel(codeItemModel);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.CodeListModelBase#isUserScope()
	 */
	@Override
	public boolean isUserScope() {
		return true;
	}

}
