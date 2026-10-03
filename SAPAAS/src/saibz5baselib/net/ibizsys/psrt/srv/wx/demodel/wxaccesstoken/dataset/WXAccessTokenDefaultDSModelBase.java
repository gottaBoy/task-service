/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wx.demodel.wxaccesstoken.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="7c0817a9156329b7eed4a878988f31cc",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="D14A2FA5-7250-4DC0-A0D2-0C5358FCB44C",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class WXAccessTokenDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WXAccessTokenDefaultDSModelBase() {
        super();

        this.initAnnotation(WXAccessTokenDefaultDSModelBase.class);
    }




}