package hello.springmvc.event;


import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SmsEventHandler {


    @Async
    @EventListener
    public void sendSms(RegisterdEvent event) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(event.getName()+"님에게 가입 축하 메세지를 전송했습니다.");
    }

    @EventListener
    @Async
    public void makeCoupon(RegisterdEvent event) throws InterruptedException {
        Thread.sleep(8000);
        System.out.println(event.getName()+"님에게 쿠폰을 전송했습니다.");
    }

}
