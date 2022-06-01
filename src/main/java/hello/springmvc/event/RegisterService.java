package hello.springmvc.event;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private final  ApplicationEventPublisher publisher;

    public RegisterService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    };


    public void register(String name){
        System.out.println("회원 추가 완료");
        publisher.publishEvent(new RegisterdEvent(name));
    }
}
