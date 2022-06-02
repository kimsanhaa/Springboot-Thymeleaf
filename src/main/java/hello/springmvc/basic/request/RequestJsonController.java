
package hello.springmvc.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 *
 *
 */
@Slf4j
@Controller
public class RequestJsonController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/request-body-json-v1")
    public void requestBodyJsonV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messagebody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}", messagebody);
        HelloData helloData = objectMapper.readValue(messagebody, HelloData.class);
        log.info("uesername={}, age={}", helloData.getUsername(),helloData.getAge());

        response.getWriter().write("ok");
    }
    @ResponseBody
    @PostMapping("/request-body-json-v2")
    public String requestBodyJsonV1(@RequestBody String messageBody) throws IOException {


        log.info("messageBody={}", messageBody);
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info("uesername={}, age={}", helloData.getUsername(),helloData.getAge());

        return "okSan";
    }

    @ResponseBody
    @PostMapping("/request-body-json-v3")
    public String requestBodyJsonV1(@RequestBody HelloData hellodata){

        log.info("uesername={}, age={}", hellodata.getUsername(),hellodata.getAge());
        return "okSan";
    }


    @ResponseBody
    @PostMapping("/request-body-json-v5")
    public HelloData requestBodyJsonV5(@RequestBody HelloData data){

        log.info("uesername={}, age={}", data.getUsername(),data.getAge());
        return data;
    }
}
