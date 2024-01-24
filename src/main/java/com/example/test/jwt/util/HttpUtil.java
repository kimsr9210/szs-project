package com.example.test.jwt.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Slf4j
@UtilityClass
public class HttpUtil {
    public static String post(String urlStr, String body, String authen) {
        return post(urlStr, body, authen, null);
    }

    public static String get(String urlStr, String body, String authen) {
        return get(urlStr, body, authen, null);
    }

    public static String post(String urlStr, String body, String authen, String referer) {
        BufferedReader br = null;
        // 메소드 호출 결과값을 반환하기 위한 변수
        String returnData = "";
        try {
            // 파라미터로 들어온 url을 사용해 connection 실시
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // http 요청에 필요한 타입 정의 실시
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", authen);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"); //post body json으로 던지기 위함
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36");
            if (referer != null) {
                conn.setRequestProperty("Referer", referer);
            }
            conn.setUseCaches(false);
            try (OutputStream os = conn.getOutputStream()) {
                byte request_data[] = body.getBytes("utf-8");
                os.write(request_data);
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            //http 요청 실시
            conn.connect();
            log.info("http 요청 데이터 : {}", body);

            //http 요청 후 응답 받은 데이터를 버퍼에 쌓는다
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuffer sb = new StringBuffer();
            String tempLine = "";
            while ((tempLine = br.readLine()) != null) {
                sb.append(tempLine); //StringBuffer에 응답받은 데이터 순차적으로 저장 실시
            }

            //메소드 호출 완료 시 반환하는 변수에 버퍼 데이터 삽입 실시
            returnData = sb.toString();

            //http 요청 응답 코드 확인 실시
            String responseCode = String.valueOf(conn.getResponseCode());
            log.info("http 응답 데이터 : {}", returnData);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //http 요청 및 응답 완료 후 BufferedReader를 닫아줍니다
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return returnData;
    }

    public static String get(String urlData, String body, String authen, String referer) {

        String m_cookies = "";

        //http 요청 시 url 주소와 파라미터 데이터를 결합하기 위한 변수 선언
        String totalUrl = "";
        if (body != null && body.length() > 0 &&
                !body.equals("") && !body.contains("null")) { //파라미터 값이 널값이 아닌지 확인
            totalUrl = urlData.trim().toString() + "?" + body.trim().toString();
        } else {
            totalUrl = urlData.trim().toString();
        }

        //http 통신을 하기위한 객체 선언 실시
        URL url = null;
        HttpURLConnection conn = null;

        //http 통신 요청 후 응답 받은 데이터를 담기 위한 변수
        String responseData = "";
        BufferedReader br = null;
        StringBuffer sb = null;

        //메소드 호출 결과값을 반환하기 위한 변수
        String returnData = "";

        try {
            //파라미터로 들어온 url을 사용해 connection 실시
            url = new URL(totalUrl);
            conn = (HttpURLConnection) url.openConnection();

            //http 요청에 필요한 타입 정의 실시
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", authen);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;"); //post body json으로 던지기 위함
            conn.setRequestProperty("user-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36");
            if (referer != null) {
                conn.setRequestProperty("Referer", referer);
            }
            //http 요청 실시
            conn.connect();

            //http 요청 후 응답 받은 데이터를 버퍼에 쌓는다
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            sb = new StringBuffer();
            while ((responseData = br.readLine()) != null) {
                sb.append(responseData); //StringBuffer에 응답받은 데이터 순차적으로 저장 실시
            }

            //메소드 호출 완료 시 반환하는 변수에 버퍼 데이터 삽입 실시
            returnData = sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //http 요청 및 응답 완료 후 BufferedReader를 닫아줍니다
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return returnData;
        }
    }
}
