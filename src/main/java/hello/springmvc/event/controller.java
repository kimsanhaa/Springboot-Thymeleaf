package hello.springmvc.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {


    @Autowired
    private  final RegisterService registerService;

    public controller(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping("event")
    public void eventController(){
      registerService.register("sanha");
        System.out.println("회원가입 완료!!");
    }

}
