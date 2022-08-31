package cn.chenzw.alipay;

import cn.chenzw.toolkit.commons.ProjectUtils;
import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayOpenOperationOpenbizmockBizQueryModel;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.request.AlipayOpenOperationOpenbizmockBizQueryRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayOpenOperationOpenbizmockBizQueryResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;

@Slf4j
@RunWith(JUnit4.class)
public class AlipayTests {

    /**
     * 验证密钥
     *
     * @throws AlipayApiException
     */
    @Test
    public void testCert() throws AlipayApiException {
        // 1. 创建AlipayClient实例
        AlipayClient alipayClient = new DefaultAlipayClient(getClientParams());
        // 2. 创建使用的Open API对应的Request请求对象
        AlipayOpenOperationOpenbizmockBizQueryRequest request = getRequest();
        // 3. 发起请求并处理响应
        AlipayOpenOperationOpenbizmockBizQueryResponse response = alipayClient.certificateExecute(request);
        if (response.isSuccess()) {
            log.info(" => {}", response.getResult());
        } else {
            log.error("调用失败，原因：" + response.getMsg() + "，" + response.getSubMsg());
        }
    }

    /**
     * 当面付
     */
    @Test
    public void testTrade() throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(getClientParams());

        // 当面付请求
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
        // 订单描述
        model.setBody("我是测试数据");
        // 订单标题
        model.setSubject("App支付测试Java");
        // 商户订单号 就是商户后台生成的订单号
        model.setOutTradeNo("201503200101010013232222231");
        // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天 (屁股后面的字母一定要带，不然报错)
        model.setTimeoutExpress("30m");
        // 订单总金额 ，默认单位为元，精确到小数点后两位，取值范围[0.01,100000000]
        model.setTotalAmount("0.01");
        // request.setNotifyUrl("商户外网可以访问的异步地址，不写就是不回调");

        request.setBizModel(model);
        AlipayTradePrecreateResponse response = alipayClient.certificateExecute(request);
        if (response.isSuccess()) {
            log.info("qrCode => {}, outTradeNo => {}, shareCode => {}", response.getQrCode(), response.getOutTradeNo(), response.getShareCode());
        } else {
            log.error("生成异常 => {}", response);
        }
    }

    @Test
    public void testQuery() throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(getClientParams());

        AlipayTradeQueryModel model = new AlipayTradeQueryModel();
        // 订单ID
        model.setOutTradeNo("220718010710699734510");
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.setBizModel(model);
        AlipayTradeQueryResponse response = alipayClient.certificateExecute(request);
        if (response.isSuccess()) {
            log.info(" => {}", JSON.toJSONString(response));
        } else {
            log.error("查询异常 => {}", JSON.toJSONString(response));
        }

    }

    private CertAlipayRequest getClientParams() {
        CertAlipayRequest certParams = new CertAlipayRequest();
        certParams.setServerUrl("https://openapi.alipay.com/gateway.do");
        //请更换为您的AppId
        certParams.setAppId("2021001160609550");
        //请更换为您的PKCS8格式的应用私钥
        certParams.setPrivateKey("MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDTm4jqH+hziLoH0ugfXgpptPViPMA6wd+pMt5XGrW2xnuDPZOOj8+bDf6ncKuYi5Ng/GjS2VzrRh9nmyJhqcrxROJwAiEaFjO97BafIcyI2rYJYHe6z+uO/D4fZXDhAi8c7yun3evdlz59FjmqLFSfunDAbWZ35Wn0Ous8CbX+Y9DWwflSij3ySB+MwsRLSSGUfWJA/gHzb9fy5A5uaptjGvmp7gaHtconOiCekeL5Bf7cDpwtuebZiyGQGLbRWI8oY++LpLeHXgIb9Jkzdf/TneineWWz3rfjuKeQzzv1V5PrYDDVNT5OahRC8PgBzduCfU1hfYwUct2sqTJXcLU1AgMBAAECggEATOXQs4Q07Qda000JnZyHHDLumWyKTs/1f39E3VKPhoRKjj7qSHxqbWaAjEidkynlvPD9BuKGqdkpwHTX4bXaUiM+RoX/kYNP+ky5S8r0kScpz+6GlBTK/YMc8Dvk8V/hzxn7O12iQTydMMfK3NSPTBxsrQEUo61y+5YNthuxT2g9Zl5ywFrK7BotKQU7DpJwUwfDTF///PkEzEdD2Tre86CNNqtS211YnHalfwJfQiUwKM7vdgdpN/Okn+IWegd/UXgq3zaK9pmuQ68Ut4wo0SefgMt3dySZlqmVNngc7g8OWgAbaq27teeky7EB2dVCxjIXawt2CA/RmrLsn0quYQKBgQDsDOi/ASi2eyi+YPou76sqDBZSs36FNrwUjm6WK56GoYSNS9ew6t35ftBuBgh7d4q9rGEn0v8tM0i5dNCxkCdFQF5rGhTaGPNv0No8Hqu5fe9DsoWD6i+Ab8gySFEzy46+OmFk7BuDhTq4p4SIjJyIdPHa9Us5jDo2b3Cx+y75IwKBgQDlfcoqxB8bjnUvxuN0jccVUD+brRuaWeLIPK/FehqtJrhhoHe/Zc46Jr53HTmJKpTFCNGRid2PbxX8O+LpLUOXNAtneIMdWsKTWoYxq3CUnelIxK3Lkt0K9asFO/dUt18aN1UTKyFmeVkJBLO/6pUGvYTv6qknEWcSRdt29p75xwKBgQC5R5S0wAMl4NvlOxeFGeg/E8e92Ff51jGg7P+ObeR7hnIVui8uFdxwBoMxqRilWPqU0KZd7PcQko2FzFQ225CHgfPam1k8q5MA9G0n/WcLLPdOKuUz2vC4HoWEOlFKl3+OfyKNZepevIeQAyU7TStczHY+SIVoQVI8AhLyENgZAwKBgQCGByACOAY+7sUsAQkoMgE6RmLPxZrgW2yiKycwuu5Hf9yhT7l/87IsriIAqPXIUTEPneXfDNh0A5mgdU1Bh2j5LrEWXgCdLTuEGZNUAN9APLVZBVzHDt+/ndiitvHs7SdCxVwPVNot4eMI7FEaXaNpi1fPUoo1wekjd98DrGcOUwKBgAsjmfPhBylhQdt+bBXw8Dp1MyfS5U1ahrf0RLsJZWgvFCokbp/7J56J8aZuDDeUObF1u2inTpMpfjlTkGdNtz5l8hgN6PvFv3ymlB4y79ZWd6WfWlUaeaWCMExN9kIcR9S7bN4DwbXKfDJWAxihHmfXyybJBVmu3xOb7QrwpL7r");
        //请更换为您使用的字符集编码，推荐采用utf-8
        certParams.setCharset("utf-8");
        certParams.setFormat("json");
        certParams.setSignType("RSA2");
        //请更换为您的应用公钥证书文件路径
        //certParams.setCertPath("/home/foo/appCertPublicKey_2019091767145019.crt");
        certParams.setCertPath(new File(ProjectUtils.getClassPath() + "appCertPublicKey.crt").getAbsolutePath());
        //请更换您的支付宝公钥证书文件路径
        // certParams.setAlipayPublicCertPath("/home/foo/alipayCertPublicKey_RSA2.crt");
        certParams.setAlipayPublicCertPath(new File(ProjectUtils.getClassPath() + "alipayCertPublicKey_RSA2.crt").getAbsolutePath());
        //更换为支付宝根证书文件路径
        // certParams.setRootCertPath("/home/foo/alipayRootCert.crt");
        certParams.setRootCertPath(new File(ProjectUtils.getClassPath() + "alipayRootCert.crt").getAbsolutePath());
        return certParams;
    }

    private AlipayOpenOperationOpenbizmockBizQueryRequest getRequest() {
        // 初始化Request，并填充Model属性。实际调用时请替换为您想要使用的API对应的Request对象。
        AlipayOpenOperationOpenbizmockBizQueryRequest request = new AlipayOpenOperationOpenbizmockBizQueryRequest();
        AlipayOpenOperationOpenbizmockBizQueryModel model = new AlipayOpenOperationOpenbizmockBizQueryModel();
        model.setBizNo("test");
        request.setBizModel(model);
        return request;
    }
}
