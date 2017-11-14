package com.xgit.qiangmoney.utils;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.widget.Toast;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017-3-8.
 */

public class Util {

    public static void showMsg(Context context, String str){
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
    }

    /**
     * 判断wifi是否打开，如果没打开自动打开
     */
    public static void open_wifi_auto(Context context)
    {//自动打开WIFI
        WifiManager wifimanager;
        wifimanager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        if(wifimanager.isWifiEnabled())
        {
//            showMsg(context,"WIFI已打开");
        }
        else
        {
            wifimanager.setWifiEnabled(true);
            showMsg(context,"检查到WIFI未打开，已自动打开WIFI！");
        }
    }

    /**
     *获取设备唯一标识——网卡的MAC地址
     */
    //根据Wifi信息获取本地Mac
    public static String getLocalMacAddressFromWifiInfo(Context context){
        WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        return info.getMacAddress();
    }

    /**
     *判断当前设备是否连网
     */
    public static boolean isNetworkAvaliable(Activity activity){
        Context context = activity.getApplicationContext();
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager == null) {
            return false;
        } else {
            // 获取NetworkInfo对象
            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();

            if (networkInfo != null && networkInfo.length > 0) {
                for (int i = 0; i < networkInfo.length; i++) {
                    // 判断当前网络状态是否为连接状态
                    if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     *获取设备唯一ID
     */
    public static String getDeviceId(){
        String deviceID = null;
        try {
            deviceID = Util.macAddress();
        } catch (SocketException e) {
            e.printStackTrace();
        }

        deviceID = deviceID.replaceAll(":","");
//        String m_szDevIDShort = "35" + //we make this look like a valid IMEI
//                Build.BOARD.length()%10 +
//                Build.BRAND.length()%10 +
//                Build.CPU_ABI.length()%10 +
//                Build.DEVICE.length()%10 +
//                Build.DISPLAY.length()%10 +
//                Build.HOST.length()%10 +
//                Build.ID.length()%10 +
//                Build.MANUFACTURER.length()%10 +
//                Build.MODEL.length()%10 +
//                Build.PRODUCT.length()%10 +
//                Build.TAGS.length()%10 +
//                Build.TYPE.length()%10 +
//                Build.USER.length()%10 ; //13 digits
        return deviceID;
    }
    //获取蓝牙地址
    public static String getBluetoothID(){
        BluetoothAdapter m_BluetoothAdapter = null; // Local Bluetooth adapter
        m_BluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        String m_szBTMAC = m_BluetoothAdapter.getAddress();
        return m_szBTMAC;
    }





    public static String macAddress() throws SocketException {
        String address = null;
        // 把当前机器上的访问网络接口的存入 Enumeration集合中
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface netWork = interfaces.nextElement();
            // 如果存在硬件地址并可以使用给定的当前权限访问，则返回该硬件地址（通常是 MAC）。
            byte[] by = netWork.getHardwareAddress();
            if (by == null || by.length == 0) {
                continue;
            }
            StringBuilder builder = new StringBuilder();
            for (byte b : by) {
                builder.append(String.format("%02X:", b));
            }
            if (builder.length() > 0) {
                builder.deleteCharAt(builder.length() - 1);
            }
            String mac = builder.toString();
            Log.d("mac", "interfaceName="+netWork.getName()+", mac="+mac);
            // 从路由器上在线设备的MAC地址列表，可以印证设备Wifi的 name 是 wlan0
            if (netWork.getName().equals("wlan0")) {
                Log.d("mac", " interfaceName ="+netWork.getName()+", mac="+mac);
                address = mac;
            }
        }
        return address;
    }


    /**
     * 判断IP地址是否合法
     * */
    public static boolean isIP(String addr) {
        if(addr.length() < 16 || addr.length() > 27 || "".equals(addr))
        {
            return false;
        }
        /**
         * 判断IP格式和范围
         */
        String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
        Pattern pat = Pattern.compile(rexp);
        Matcher mat = pat.matcher(addr);
        boolean ipAddress = mat.find();
        return ipAddress;
    }
}
