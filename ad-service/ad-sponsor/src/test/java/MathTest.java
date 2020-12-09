import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.best.javaSdk.Client;
import com.best.javaSdk.kdTraceQuery.request.KdTraceQueryReq;
import com.best.javaSdk.kdTraceQuery.request.MailNos;
import com.best.javaSdk.kdTraceQuery.response.KdTraceQueryRsp;
import com.best.javaSdk.kdWaybillApplyNotify.request.Auth;
import com.best.javaSdk.kdWaybillApplyNotify.request.EDIPrintDetailList;
import com.best.javaSdk.kdWaybillApplyNotify.request.KdWaybillApplyNotifyReq;
import com.best.javaSdk.kdWaybillApplyNotify.response.KdWaybillApplyNotifyRsp;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.imooc.ad.sto.StoResponse;
import com.imooc.ad.sto.request.*;
import com.imooc.ad.sto.response.StoTraceQueryResponse;
import com.imooc.ad.utils.FileUtil;
import com.imooc.ad.utils.MD5Util;
import com.imooc.ad.utils.ZipUtils;
import com.imooc.ad.yunda.request.*;
import com.sto.link.request.LinkRequest;
import com.yundasys.api.DefaultOpenapiClient;
import com.yundasys.api.OpenapiConstants;
import com.yundasys.api.request.OpenApiDefaultRequest;
import com.yundasys.api.response.OpenApiDefaultResponse;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.sto.link.util.LinkUtils.request;


/**
 * @ClassName MathTest
 * @description:
 * @author: qsong
 * @create: 2020-11-17 14:45
 * @Version 1.
 **/
@SpringBootTest
public class MathTest {


    /**
     * 下单服务接口(测试环境)
     */
    private static final String NEW_ORDER_URL = "https://devkyweixin.yundasys.com/openapi-api/v1/accountOrder/createBmOrder";

    //日
    private static final long day = 1000 * 24 * 60 * 60;
    //时
    private static final long hour= 1000 * 60 * 60;
    //分
    private static final long minute = 1000 * 60;

    @Test
    public void managerTest(){
        float x=100;
        long y=242;
        System.out.println((x/y));
        System.out.println((int) ((x/y)*242));
        DecimalFormat df = new DecimalFormat("0.00");
        String s = df.format(x / y);
        System.out.println(s);
    }

    @Test
    public void fileTest() throws IOException {
        //打包
        String path=System.getProperty("user.dir")+ File.separator +"2020112011072910025";
        boolean fileToZip = ZipUtils.fileToZip(path, System.getProperty("user.dir"), "2020112011072910025");
        if(fileToZip){
            System.out.println("压缩成功");
        }
        //删除文件夹
        Boolean directory = FileUtil.removeDirectory(new File("2020112011072910025"));
        if(directory){
            System.out.println("文件删除成功");
        }
        //获取文件大小
        File file=new File("2020112011072910025.zip");
        if(file.exists()&&file.isFile()){
            String fileName = file.getName();
            System.out.println("文件"+fileName+"的大小是："+file.length()/1024+"KB");
        }

        //        FileUtil.removeDirectory(new File())
    }


    @Test
    public void dateTest() {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        //格式化当前系统日期
        SimpleDateFormat dateFm = new SimpleDateFormat("yyyyMMddHHmmss");
        Date crtTime=new Date();
        System.out.println(crtTime);
        System.out.println(crtTime.getTime());
        System.out.println(dateFm.format(crtTime));
        for (Integer i=0;i<9999;i++){
            for (Integer i1 = 1;i1<999;i1++){
                System.out.print("");
            }
        }
        System.out.println();
        Date endTime=new Date();
        System.out.println(endTime);
        System.out.println(endTime.getTime());
        //获取执行耗时
        long execTime = endTime.getTime() - crtTime.getTime();
        System.out.println(execTime);
        // 计算差多少分钟
        float min = execTime % nd % nh / nm;
        System.out.println(min);
        DecimalFormat decimalFormat=new DecimalFormat("##0.00");
        String min2 = decimalFormat.format(min);
        System.out.println(min2);

//        BigDecimal b = new BigDecimal(min);
//        float f1 = b.setScale(2, BigDecimal.ROUND_HALF_DOWN).floatValue();
//        System.out.println(f1);
    }


    @Test
    public void yundaTest() throws Exception {
//        String appSecret="04d4ad40eeec11e9bad2d962f53dda9d";
//        String params="jsonReqBody_"+appSecret;
//        String md5 = MD5(params);
//        System.out.println(md5);
        String appKey="999999";
        //创建应用分配的appsecret
        //签名
        String appSecret="04d4ad40eeec11e9bad2d962f53dda9d";
        //默认的Openapi客户端
        DefaultOpenapiClient defaultOpenapiClient = new DefaultOpenapiClient(NEW_ORDER_URL, appKey, appSecret);
        //打开Api默认请求
        OpenApiDefaultRequest openApiDefaultRequest = new OpenApiDefaultRequest();
        //请求参数body, 指定JSON格式
        YunDaOrderModel yunda = new YunDaOrderModel();
        yunda.setAppid(appKey);
        yunda.setPartner_id("201700101001");
        yunda.setSecret("123456789");

        YunDaOrder yunDaOrder = new YunDaOrder();
        yunDaOrder.setCollect_branch("");//false
        yunDaOrder.setCollection_value(126.5);//false
        yunDaOrder.setCus_area1("");//false
        yunDaOrder.setCus_area2("");//false
        yunDaOrder.setIsProtectPrivacy("");//false
        //商品
        List<Item> items= new ArrayList<>();
        Item item=new Item();//false
        item.setName("衣服");
        item.setNumber("1");
        item.setRemark("袜子");

        items.add(item);
        yunDaOrder.setItems(items);
        //大客户系统订单的订单号//true
        yunDaOrder.setKhddh("2012121715004");
        //350 默认 true、
        yunDaOrder.setNode_id("350");
        //订单号 true
        yunDaOrder.setOrder_serial_no("2012121715004");
        //订单类型
        yunDaOrder.setOrder_type("common");
        //平台来源 false
        yunDaOrder.setPlatform_source("");
        //收件人信息
        Receiver receiver = new Receiver();
        receiver.setAddress("上海市，青浦区，盈港东路 6679 号");
        receiver.setCity("上海市");
        receiver.setCompany("");
        receiver.setCounty("青浦区");
        receiver.setName("李四");
        receiver.setMobile("17601206977");
        receiver.setProvince("上海市");
        yunDaOrder.setReceiver(receiver);

        //备注
        yunDaOrder.setRemark("");
        //发件人信息
        Sender sender=new Sender();
        sender.setAddress("上海市，青浦区，盈港东路 7766 号");
        sender.setCity("上海市");
        sender.setCompany("");
        sender.setCounty("青浦区");
        sender.setMobile("17601206977");
        sender.setName("张三");
        sender.setProvince("上海市");
        yunDaOrder.setSender(sender);
        //大小 false
        yunDaOrder.setSize("0.12,0.23,0.11");
        yunDaOrder.setSpecial("0");
        yunDaOrder.setValue(126.5);
        yunDaOrder.setWeight(0.0);

        List<YunDaOrder> yunDaOrderList=new ArrayList<>();
        yunDaOrderList.add(yunDaOrder);
        yunda.setOrders(yunDaOrderList);

//        System.out.println(yunda.toString());
        //java对象转json对象
        String sourceContent = JSONObject.toJSONString(yunda);
        System.out.println(sourceContent);


//        String sourceContent ="{ \"appid\": \"999999\", \"partner_id\": \"201700101001\",\"backparam\": \"测试\", \"backurl\": \"http://www\", \"freight\": 10, \"items\": [ { \"name\": \"衣服\", \"number\": 1, \"remark\": \"袜子\" } ], \"orderid\": \"2333098766\", \"other_charges\": 0, \"premium\": 1, \"receiver\": { \"address\": \"青浦区盈港东路 6679 号\", \"city\": \"上海市\", \"company\": \"string\", \"county\": \"青浦区\", \"mobile\": \"0553-9876542\", \"name\": \"李四\", \"phone\": 17601205970, \"postcode\": \"string\", \"province\": \"上海市\" }, \"remark\": \"string\", \"sendendtime\": \"2019-09-03 11:00:00\", \"sender\": { \"address\": \"盈港东路 7766 号\", \"city\": \"上海市\", \"company\": \"string\", \"county\": \"青浦区\", \"mobile\": \"0553-9876542\", \"name\": \"张三\", \"phone\": 17601205970, \"postcode\": \"string\", \"province\": \"上海市\" }, \"sendstarttime\": \"2019-09-03 10:00:00\", \"size\": \"0.12,0.23,0.11\", \"special\": 0, \"value\": 126.5, \"weight\": 0 }";
        openApiDefaultRequest.setBizContent(sourceContent);
        //生成的SIGN签名串
        String sign = defaultOpenapiClient.getSigner().sign(sourceContent, OpenapiConstants.SIGN_TYPE_MD5, OpenapiConstants.CHARSET_UTF8);
        openApiDefaultRequest.setHeadersMap(appKey, sign, String.valueOf(System.currentTimeMillis()));
        OpenApiDefaultResponse openApiDefaultResponse = defaultOpenapiClient.excute(openApiDefaultRequest);
        System.out.println(openApiDefaultResponse.toString());
        System.out.println(openApiDefaultResponse.getData());
//        System.out.println(openApiDefaultResponse.getData());
//        String str = openApiDefaultResponse.getData().substring(1, openApiDefaultResponse.getData().length() - 1);
//        System.out.println(str);
//        String str2 = openApiDefaultResponse.getData().replaceAll("=", ":");
//        System.out.println(str2);
        System.out.println(System.currentTimeMillis());
//        JSONObject jsonObject = JSONObject.parseObject(str2);
//        List<ResponseData> responseData = JSON.parseArray(openApiDefaultResponse.getData(), ResponseData.class);
//        System.out.println(responseData1.toString());
//        char[] chars = openApiDefaultResponse.getData().toCharArray();

        System.out.println();

        if(openApiDefaultResponse.isSuccess()){
            System.out.println("调用成功");
        }else{
            System.out.println("调用失败");
        }
//        String responseData= openApiDefaultResponse.getData();
//        ResponseData responseData1 = JSON.parseObject(responseData, ResponseData.class);
////        ResponseData responseData = JSONObject.toJavaObject(jsonObject, ResponseData.class);
//        System.out.println(responseData.toString());
//        System.out.println(openApiDefaultResponse.toString());

    }


    private String MD5(String data) throws Exception {
        java.security.MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }
    //申通快递下单
    @Test
    public void stoTest(){
        StoOrderModel stoOrderModel=new StoOrderModel();
        stoOrderModel.setOrderNo("8885452261")
                    .setOrderSource("VIPEO")
                    .setBillType("00")
                    .setOrderType("00");
        SenderDO sender=new SenderDO();
        sender.setName("小米")
                .setProvince("江苏")
                .setCity("苏州")
                .setArea("吴江")
                .setAddress("三里桥");
        stoOrderModel.setSender(sender);
        ReceiverDO receiver=new ReceiverDO();
        receiver.setName("小明").setProvince("河南").setCity("南阳").setArea("南召").setAddress("南召小学");
        stoOrderModel.setReceiver(receiver);
        StoCargo cargo=new StoCargo();
        cargo.setBattery("10").setGoodsType("大件").setGoodsName("电动车");
        stoOrderModel.setCargo(cargo);
        CustomerDO customer=new CustomerDO();
        customer.setCustomerName("900000000004").setSiteCode("900000").setSitePwd("abc123");
        stoOrderModel.setCustomer(customer);
        String content = JSONObject.toJSONString(stoOrderModel);
//        String content="{\"orderNo\":\"8885452262\",\"orderSource\":\"VIPEO\",\"billType\":\"01\",\"orderType\":\"01\",\"sender\":{\"name\":\"测试名称\",\"tel\":\"18775487548\",\"mobile\":\"0558-45778586\",\"postCode\":\"100001\",\"country\":\"中国\",\"province\":\"安徽\",\"city\":\"合肥\",\"area\":\"泸州\",\"town\":\"测试镇\",\"address\":\"XX街道XX小区XX楼888\"},\"receiver\":{\"name\":\"测试名称\",\"tel\":\"15575487548\",\"mobile\":\"0556-45778586\",\"postCode\":\"100001\",\"country\":\"中国\",\"province\":\"河北\",\"city\":\"湖州\",\"area\":\"江汉\",\"town\":\"收件镇\",\"address\":\"XX街道XX小区XX楼666\"},\"cargo\":{\"battery\":\"10\",\"goodsType\":\"大件\",\"goodsName\":\"XX物\",\"goodsCount\":10,\"spaceX\":10,\"spaceY\":10,\"spaceZ\":10,\"weight\":10,\"goodsAmount\":\"100\",\"cargoItemList\":[{\"CargoItemDO\":{\"serialNumber\":\"8451234\",\"referenceNumber\":\"88838783634\",\"productId\":\"001\",\"name\":\"小商品\",\"qty\":10,\"unitPrice\":1,\"amount\":10,\"currency\":\"美元\",\"weight\":10,\"remark\":\"无备注\"}}]},\"customer\":{\"siteCode\":\"900000\",\"customerName\":\"900000000004\",\"sitePwd\":\"abc123\"},\"insuredAnnex\":{\"insuredValue\":\"100\",\"goodsValue\":\"2000\"},\"codValue\":\"2000\",\"freightCollectValue\":\"20\",\"timelessType\":\"01\",\"productType\":\"01\",\"serviceTypeList\":[{\"listItem\":\"DELIVER_CONTACT\"}, {\"listItem\":\"TRACE_PUSH\"}],\"remark\":\"无备注\",\"createChannel\":\"01\"}";
        LinkRequest data = new LinkRequest();
        data.setFromAppkey("CAKcBiMhfuSLeXN");
        data.setFromCode("CAKcBiMhfuSLeXN");
        data.setToAppkey("sto_oms");
        data.setToCode("sto_oms");
        data.setApiName("OMS_EXPRESS_ORDER_CREATE");
        data.setContent(content);
//        data.setContent("{\"orderNo\":\"8885452262\",\"orderSource\":\"VIPEO\",\"billType\":\"01\",\"orderType\":\"01\",\"sender\":{\"name\":\"测试名称\",\"tel\":\"18775487548\",\"mobile\":\"0558-45778586\",\"postCode\":\"100001\",\"country\":\"中国\",\"province\":\"安徽\",\"city\":\"合肥\",\"area\":\"泸州\",\"town\":\"测试镇\",\"address\":\"XX街道XX小区XX楼888\"},\"receiver\":{\"name\":\"测试名称\",\"tel\":\"15575487548\",\"mobile\":\"0556-45778586\",\"postCode\":\"100001\",\"country\":\"中国\",\"province\":\"河北\",\"city\":\"湖州\",\"area\":\"江汉\",\"town\":\"收件镇\",\"address\":\"XX街道XX小区XX楼666\"},\"cargo\":{\"battery\":\"10\",\"goodsType\":\"大件\",\"goodsName\":\"XX物\",\"goodsCount\":10,\"spaceX\":10,\"spaceY\":10,\"spaceZ\":10,\"weight\":10,\"goodsAmount\":\"100\",\"cargoItemList\":[{\"CargoItemDO\":{\"serialNumber\":\"8451234\",\"referenceNumber\":\"88838783634\",\"productId\":\"001\",\"name\":\"小商品\",\"qty\":10,\"unitPrice\":1,\"amount\":10,\"currency\":\"美元\",\"weight\":10,\"remark\":\"无备注\"}}]},\"customer\":{\"siteCode\":\"900000\",\"customerName\":\"900000000004\",\"sitePwd\":\"abc123\"},\"insuredAnnex\":{\"insuredValue\":\"100\",\"goodsValue\":\"2000\"},\"codValue\":\"2000\",\"freightCollectValue\":\"20\",\"timelessType\":\"01\",\"productType\":\"01\",\"serviceTypeList\":[{\"listItem\":\"DELIVER_CONTACT\"}, {\"listItem\":\"TRACE_PUSH\"}],\"remark\":\"无备注\",\"createChannel\":\"01\"}");
        String url = "http://cloudinter-linkgatewaytest.sto.cn/gateway/link.do";
        String secretKey = "1sbjJiNSXjlydjIJmolw0pwTNK7q36hG";
        String request = request(data, url, secretKey);
        StoResponse stoResponse = JSON.parseObject(request, StoResponse.class);

        System.out.println(request);
        System.out.println(stoResponse.toString());

    }
//    申通物流查询
    @Test
    public void stoTraceQueryCommon(){
        String waybillNo="6606002284014";
        List<String> waybillNoList=new ArrayList<>();
        waybillNoList.add(waybillNo);
//        String content = JSON.toJSONString(waybillNoList);
        StoTraceQueryRequest stoTraceQueryRequest=new StoTraceQueryRequest();
        stoTraceQueryRequest.setOrder("asc");
        stoTraceQueryRequest.setWaybillNoList(waybillNoList);
        String content = JSONObject.toJSONString(stoTraceQueryRequest);


        LinkRequest data = new LinkRequest();
        data.setFromAppkey("CAKcBiMhfuSLeXN");
        data.setFromCode("CAKcBiMhfuSLeXN");
        data.setToAppkey("sto_trace_query");
        data.setToCode("sto_trace_query");
        data.setApiName("STO_TRACE_QUERY_COMMON");
        data.setContent(content);
//        data.setContent("{\"orderNo\":\"8885452262\",\"orderSource\":\"VIPEO\",\"billType\":\"01\",\"orderType\":\"01\",\"sender\":{\"name\":\"测试名称\",\"tel\":\"18775487548\",\"mobile\":\"0558-45778586\",\"postCode\":\"100001\",\"country\":\"中国\",\"province\":\"安徽\",\"city\":\"合肥\",\"area\":\"泸州\",\"town\":\"测试镇\",\"address\":\"XX街道XX小区XX楼888\"},\"receiver\":{\"name\":\"测试名称\",\"tel\":\"15575487548\",\"mobile\":\"0556-45778586\",\"postCode\":\"100001\",\"country\":\"中国\",\"province\":\"河北\",\"city\":\"湖州\",\"area\":\"江汉\",\"town\":\"收件镇\",\"address\":\"XX街道XX小区XX楼666\"},\"cargo\":{\"battery\":\"10\",\"goodsType\":\"大件\",\"goodsName\":\"XX物\",\"goodsCount\":10,\"spaceX\":10,\"spaceY\":10,\"spaceZ\":10,\"weight\":10,\"goodsAmount\":\"100\",\"cargoItemList\":[{\"CargoItemDO\":{\"serialNumber\":\"8451234\",\"referenceNumber\":\"88838783634\",\"productId\":\"001\",\"name\":\"小商品\",\"qty\":10,\"unitPrice\":1,\"amount\":10,\"currency\":\"美元\",\"weight\":10,\"remark\":\"无备注\"}}]},\"customer\":{\"siteCode\":\"900000\",\"customerName\":\"900000000004\",\"sitePwd\":\"abc123\"},\"insuredAnnex\":{\"insuredValue\":\"100\",\"goodsValue\":\"2000\"},\"codValue\":\"2000\",\"freightCollectValue\":\"20\",\"timelessType\":\"01\",\"productType\":\"01\",\"serviceTypeList\":[{\"listItem\":\"DELIVER_CONTACT\"}, {\"listItem\":\"TRACE_PUSH\"}],\"remark\":\"无备注\",\"createChannel\":\"01\"}");
        String url = "http://cloudinter-linkgatewaytest.sto.cn/gateway/link.do";
        String secretKey = "1sbjJiNSXjlydjIJmolw0pwTNK7q36hG";
        String request = request(data, url, secretKey);
        StoTraceQueryResponse stoTraceQueryResponse = JSON.parseObject(request, StoTraceQueryResponse.class);
        System.out.println(stoTraceQueryResponse.toString());
    }


    //百世下单
    @Test
    public void kdApiTest(){
        String url = "http://openapi.800best.com/api-server/kd/api/process";//对应的地址
        String partnerKey = "GW4L28GU";//根据实际partnerKey
        String format = "JSON";//如果是JSON的数据格式，填JSON
        String partnerID = "4052";//根据实际的partnerID
        Client client = new Client(url,  partnerID, partnerKey, format);

        KdWaybillApplyNotifyReq billPrintRequestReq  = new KdWaybillApplyNotifyReq();
        billPrintRequestReq.setDeliveryConfirm(false);
        billPrintRequestReq.setMsgId("111222233355656");
        Auth auth = new Auth();
        auth.setPass("800best");
        auth.setUsername("DZMD");
        billPrintRequestReq.setAuth(auth);
        List<EDIPrintDetailList> lists = new ArrayList<>();

        EDIPrintDetailList ediPrintDetailList = new EDIPrintDetailList();


//        ediPrintDetailList.setSendMan("张三");
//        ediPrintDetailList.setSendManPhone("88888888");
//        ediPrintDetailList.setSendManAddress("教工路一号");
//        ediPrintDetailList.setSendPostcode("400000");
//        ediPrintDetailList.setSendProvince("浙江省");
//        ediPrintDetailList.setSendCity("杭州市");
//        ediPrintDetailList.setSendCounty("西湖区");
//        ediPrintDetailList.setReceiveMan("李四");
//        ediPrintDetailList.setReceiveManPhone("99999999");
//        ediPrintDetailList.setReceiveManAddress("文三路一号");
//        ediPrintDetailList.setReceivePostcode("400000");
//        ediPrintDetailList.setReceiveProvince("浙江省");
//        ediPrintDetailList.setReceiveCity("杭州市");
//        ediPrintDetailList.setReceiveCounty("西湖区");
//        ediPrintDetailList.setItemCount(1);
//        ediPrintDetailList.setItemName("书");
//        ediPrintDetailList.setItemWeight(10.0);
//        ediPrintDetailList.setRemark("remark");
//        lists.add(ediPrintDetailList);
        billPrintRequestReq.setEDIPrintDetailList(lists);

        //billPrintRequestRsp即为百世的响应
        KdWaybillApplyNotifyRsp billPrintRequestRsp = client.executed(billPrintRequestReq);
        System.out.println(billPrintRequestRsp.toString());
    }

    /**
     * 百世订单轨迹查询
     */
    @Test
    public void bestQueryTest(){
        String url = "http://openapi.800best.com/api-server/kd/api/process";//对应的地址
        String partnerKey = "GW4L28GU";//根据实际partnerKey
        String format = "JSON";//如果是JSON的数据格式，填JSON
        String partnerID = "4052";//根据实际的partnerID
        Client client = new Client(url,  partnerID, partnerKey, format);
        //创建请求对象
        KdTraceQueryReq kdTraceQueryReq = new KdTraceQueryReq();
        MailNos mailNos = new MailNos();
        List<String> mailNo = new ArrayList<>();
        mailNo.add("51606702499896");
        mailNos.setMailNo(mailNo);
        kdTraceQueryReq.setMailNos(mailNos);
        //kdTraceQueryRsp即为百世的响应
        KdTraceQueryRsp kdTraceQueryRsp = client.executed(kdTraceQueryReq);
        System.out.println(kdTraceQueryRsp);
    }

    /**
     * md5加密
     */
    @Test
    public void md5Test(){
        String str = MD5Util.encrypt("admin" + 123456);
        //a66abb5684c45962d887564f08346e8d
        System.out.println(str);
        String str2 = MD5Util.encrypt("admin" + 123456);
        System.out.println(str2);
    }

    @Test
    public void strTest(){
        String str="数据备份222222222222221555";
        String str2 = str.replace("数据备份", "");
        System.out.println(str2);
    }



    /**
     * @Author qsong
     * @Description 时间计算
     * @Date 下午4:32 2020/12/7
     * @Param
     * @return
     **/
    @Test
    public void test3() {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date now = df.parse("2019-03-26 13:31:40");//当前时间
            Date date = df.parse("2019-03-26 13:30:41");//过去
            long l = now.getTime() - date.getTime();
            long day = l / (24 * 60 * 60 * 1000);
            long hour = (l / (60 * 60 * 1000) - day * 24);
            long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            System.out.println("" + min + "分" + s + "秒");
        } catch (Exception e) {

        }

    }

    /**
     * @Author qsong
     * @Description 二维码生成
     * @Date 下午4:57 2020/12/9
     * @Param
     * @return
     **/
    private static final String QR_CODE_IMAGE_PATH = "/Users/administrator/Desktop/MyQRCode.png";
    private static void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);

        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }
    /**
     * @Author qsong
     * @Description 生成二维码
     * @Date 下午5:00 2020/12/9
     * @Param
     * @return
     **/
    @Test
    public void QRCodeGeneratorTest(){
        try {
            generateQRCodeImage("www.xiaobustudy.cn", 350, 350, QR_CODE_IMAGE_PATH);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }
    }

}


