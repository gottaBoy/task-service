/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wx.demodel.wxaccount.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="a807f4b43d86fbcad55c58e4621a8c80",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="AF7FA7D0-D44C-4AA5-BC41-79CF578892B4",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class WXAccountDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WXAccountDefaultDSModelBase() {
        super();

        this.initAnnotation(WXAccountDefaultDSModelBase.class);
    }




}