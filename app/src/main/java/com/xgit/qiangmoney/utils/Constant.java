package com.xgit.qiangmoney.utils;

/**
 * Created by Administrator on 2017-4-18.
 */

public class Constant {

    //ip地址
//    public static final String DOMAIN_NAME = "http://10.3.1.35:8081/";
//    public static final String DOMAIN_NAME = "http://10.3.0.246:8095/";//服务器，王玉

//    public static final String DOMAIN_NAME = "http://192.168.133.1:8098/";//胡中亚

//    public static final String DOMAIN_NAME = "http://10.3.1.78:86/";//马陀

//    public static final String DOMAIN_NAME = "http://192.188.22.100:8095/";//服务器,富通正式

//    public static String DOMAIN_NAME = "http://10.100.2.11:8095/";//家里连富通外网
    public static String DOMAIN_NAME = "";//家里连富通外网

    /**
     * 查看用户权限
     */
//    public static final String QUANXIAN_URL = DOMAIN_NAME+"TagEnd/GetTagEndZSFilber?callback=callback";
    public static final String QUANXIAN_URL = "TagEnd/GetTagEndZSFilber?callback=callback";

    /**
     * 查看仓储权限
     */
    public static final String STORAGE_QX_URL = "TagEnd/GetTagEndStorage?callback=callback";


    /**
     *  系统升级URL常量
     */
//    public  static final String UPDATE_URL = DOMAIN_NAME+"Upgrade/GetUpgradeinfo?callback=callback&devicetype=pi";
    public  static final String UPDATE_URL = "Upgrade/GetUpgradeinfo?callback=callback&devicetype=pi";


    /**
     * 登录URL常量
     */
//    public static final String LOGIN_URL = DOMAIN_NAME+"Account/LogOn?callback=callback&usercode=";
    public static final String LOGIN_URL = "Account/LogOn?callback=callback&usercode=";


    /**
     * 根据设备id获取设备列表接口
     */
//    public static final String DEVICE_LIST_URL = DOMAIN_NAME+"TagEnd/GetIsZSFiber?callback=callback";
    public static final String DEVICE_LIST_URL = "TagEnd/GetIsZSFiber?callback=callback";

    /**
     * 着色常量
     */
    public static final String ZHUOSE_DEVICE_URL = DOMAIN_NAME+"SheathExec/GetSheathEquipment?callback=callback&mactype=sys001";



    /**
     * 束管常量
     */
    public static final String SHUGUAN_DEVICE_URL = DOMAIN_NAME+"SheathExec/GetSheathEquipment?callback=callback&mactype=sys003";




    /**
     * 成缆常量
     */




    /**
     * 护套常量
     */
    public static final String HUTAO_DEVICE_URL = DOMAIN_NAME+"SheathExec/GetSheathEquipment?callback=ABCDE&mactype=sys005";





    /**
     * 仓储常量
     */

    public static final String STORAGE_AREA_SUKP_URL = "WmsTubePlate/GetShelf?callback=callback";//束管空盘库区列表

    public static final String STORAGE_POSITION_SUKP_URL = "WmsTubePlate/GetShelfDetail?callback=callback";//束管空盘库位列表

    public static final String STORAGE_AREA_SUBCP_URL = "WmsTube/GetShelf?callback=callback";//束管半成品库区列表

    public static final String STORAGE_POSITION_SGBCP_URL = "WmsTube/GetShelfDetail?callback=callback";


    public  static  final String STORAGE_AREA_JQJ_URL = "JqjWMS/GetShelfNameList?callback=callback&shelftype=加强件";//加强件入库获取库区列表

    public  static  final String STORAGE_POSITION_JQJ_URL = "JqjWMS/GetShelfDetailList?callback=callback";//加强件入库获取库位列表

    public  static  final String STORAGE_AREA_TCS_URL = "WmsTcs/GetShelf?callback=callback";//填充绳入库获取库区列表

    public  static  final String STORAGE_POSITION_TCS_URL = "Wmstcs/GetShelfDetail?callback=callback";//填充绳入库获取库位列表

    public  static  final String STORAGE_AREA_CL_URL = "WmsLx/GetShelf?callback=callback";//成缆入库获取库区列表

    public  static  final String STORAGE_POSITION_CL_URL = "WmsLx/GetShelfDetail?callback=callback";//成缆入库获取库位列表

}
