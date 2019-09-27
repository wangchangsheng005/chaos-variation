package com.chaos.variation.auth.service;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.chaos.variation.auth.entity.AlipayUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * @ClassName:AlipayLoginService
 * @Description:TODO
 * @Author:SH-WANGCS2
 * @Date:2019/9/26/0026 16:33
 * @Version 1.0
 **/
@Slf4j
@Service
public class AlipayLoginService implements InitializingBean {

    /**Alipay客户端*/
    private AlipayClient alipayClient;

    /**支付宝网关*/
    private static final String ALIPAY_BORDER_DEV = "https://openapi.alipaydev.com/gateway.do";
    private static final String ALIPAY_BORDER_PROD = "https://openapi.alipay.com/gateway.do";
    /**appID**/
    private static final String APP_ID_DEV = "xxxxxx";
    private static final String APP_ID_PROD = "2019092667826266";
    /**私钥*/
    private static final String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCJIiab63YJHSs34QXKDhJ/cfEet9jpGQd+qEwabYgfN7+nAqzf1sHpyI+YpGIEUd7Lvwbuuubhh8cz1M/yX247D4bbAqPPze5ZfDo9v38tohZmCWgLw2XAutnHZbfMquDW+XNY373Fq9y4OZ3twjq2BnLzkm2Tsge+93/ZqO7oegmh4Egle18PRKhrw8o3V20yPnwzliXk4mvCZQR0d2B+C90A99sQ5lz59KNL5xjztttzTvCs/MWDK36vvGa/Tv8fv6tjFptOY+ZdfLqB2cIdVSbJHBAtN/LZr0j9YuOJOClT9FmigiOv4ynh4aiy0ZM/EagVHvera9qYfP+DayMfAgMBAAECggEAMMXpr3jucU1jiqtI0NVydMuEs6U1y6nwRXb8IkYkrN26F19XNwF91HVVxTdp+RlZQWP+xjfJWBtfmSqujwir/uuFzi1BL+6RQFhzqnSKeiN1DfN4gv6LGSIbxNSDq5J3B16PTOO+7igzB37OkbqMASOIDONef7JJGP2UBkkUN7Bv7LFYINrQtgcKi7FGgkIgBxLc7MfRS3tE18gqDjkgG2zC1JIIG+iPs48TGGI21fT1ApDL98mVsRoRO4Eep/sZN+n4nkppsbqsqrVr+tQrUY51BH+1e4WC8GVi+sJ3u7V1BhGsoBoHX9PZUr2Whz1mJRlhIk1Oj+p3X2S629weUQKBgQDlTGszSQ4z76kDIwoOUB4n+cxG0CXQjdiNGN8qWupEFRh/0m2Cj1/H2Ptk+nF1Isktlgclwv0zfmCmG2Rq2RbF37ORJLU507jz08Y4z81UikxD5N1W2VUcFYsZmw54N9LvNoD83cVBSujebJ56NayKz8Yqw4eOJt7SIqtK8r77twKBgQCZGjZ1hOpbKhEAnuNg/fZZOqemuYaEmJbU3Wq53F0URs5qLpBbXLb3Zv3v2fkt8io3mE9gPexmZe14q7B+Rqbq/GxwQjwrwqVBAaUfx8Vjnaspvh2OS1HLPwOmUO2PIZW4KOi6k2VB+BR57l8kHKZc9uqvEE3qjZ9ZbXXGnVBj2QKBgGL/Xl0zEm278EWJcEMDtjFeOSLtpRXo1/D7Jwa7X99rGDu/l0ZCLoEzHj7XnfqLvT3wQz+7cuQzkPjGZNF4zss5rOZiadgAoB6tdSx8E1OHriu1+RYRGRzZ9Edm2ZVvzKM47fG+sfZhqC63yKhM2iTIVe+KodDu2U7yZvAh4/D7AoGBAJH+9BWm1NBwUdxUp6FTLDq0ezC60/LXi2Wbau2nnL78MlQA6TmmNPfBJ8A0DLDqr6VqQa8V/bs70XLzzg7skrmcUk/OaZCVQX628d5XYvx2WsUofQi2/F2jTninzZFixmHh6OQaMEHzLpuDWwiVpXMbJnogQxy7RkxB3EC0vPcpAoGBAL/6MCs/6NoTcMUjW74hVZQJIcSqHk+Z/kCw7QIrIydlhMef649oKBRrITgdmOdLbx/c/TLEJsEchmHcsL3P9ZSAymbW2YdICN8g6+VAg4evr85IDum4MmB5vG1TFF61Gm8c2TXSFPn79PMVNqtlCnZxGfBSrG/bl7b0lOG06qq9";
    /**公钥*/
    private static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiSImm+t2CR0rN+EFyg4Sf3HxHrfY6RkHfqhMGm2IHze/pwKs39bB6ciPmKRiBFHey78G7rrm4YfHM9TP8l9uOw+G2wKjz83uWXw6Pb9/LaIWZgloC8NlwLrZx2W3zKrg1vlzWN+9xavcuDmd7cI6tgZy85Jtk7IHvvd/2aju6HoJoeBIJXtfD0Soa8PKN1dtMj58M5Yl5OJrwmUEdHdgfgvdAPfbEOZc+fSjS+cY87bbc07wrPzFgyt+r7xmv07/H7+rYxabTmPmXXy6gdnCHVUmyRwQLTfy2a9I/WLjiTgpU/RZooIjr+Mp4eGostGTPxGoFR73q2vamHz/g2sjHwIDAQAB";

    @Override
    public void afterPropertiesSet() throws Exception {
        alipayClient = new DefaultAlipayClient(ALIPAY_BORDER_PROD, APP_ID_PROD, APP_PRIVATE_KEY, "json", "UTF-8", ALIPAY_PUBLIC_KEY, "RSA2");
    }

    /**
     * 根据auth_code获取用户的user_id和access_token
     * @param authCode
     * @return
     */
    public String getAccessToken(String authCode) {
        AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
        request.setCode(authCode);
        request.setGrantType("authorization_code");
        try {
            AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient.execute(request);
            return oauthTokenResponse.getAccessToken();
        } catch (Exception e) {

            log.error("使用authCode获取信息失败！", e);
            return null;
        }
    }

    /**
     * 根据access_token获取用户信息
     * @param token
     * @return
     */
    public AlipayUser getUserInfoByToken(String token) {
        AlipayUserInfoShareRequest request = new AlipayUserInfoShareRequest ();
        try {
            AlipayUserInfoShareResponse response =  alipayClient.execute(request, token);
            if (response.isSuccess()) {
                //打印响应信息
//                System.out.println(ReflectionToStringBuilder.toString(response));
                //封装支付宝对象信息
                AlipayUser alipayUser = new AlipayUser();
                alipayUser.setAddress(response.getAddress());
                alipayUser.setCertNo(response.getCertNo());
                alipayUser.setCity(response.getCity());
                alipayUser.setCollegeName(response.getCollegeName());
                alipayUser.setDegree(response.getDegree());
                alipayUser.setMobile(response.getMobile());
                alipayUser.setPhone(response.getPhone());
                alipayUser.setProvince(response.getProvince());
                alipayUser.setUserName(response.getUserName());
                alipayUser.setNickName(response.getNickName());
                return alipayUser;
            }
            log.error("根据 access_token获取用户信息失败!");
            return null;

        } catch (Exception e) {
            log.error("根据 access_token获取用户信息抛出异常！", e);
            return null;
        }
    }
}