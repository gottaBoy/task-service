/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wx.demodel.wxmedia.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="6e265a32be682141a452a8832bc78530",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="3BC17A20-6E4B-49A9-84A7-0ACA5DAFE51E",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class WXMediaDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WXMediaDefaultDSModelBase() {
        super();

        this.initAnnotation(WXMediaDefaultDSModelBase.class);
    }




}