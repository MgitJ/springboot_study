package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //spring은 해줘야함
public class HelloController {

    @GetMapping("hello")  //웹 어플리케이션에서 /hello라고 들어오면 10-13메소드 호출
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }

    //MVC 방식입니다.
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name,Model model){
        model.addAttribute("name",name);
                return "hello-template";
    }

    //api 방식입니다.
    @GetMapping("hello-string")
    @ResponseBody //http에서 헤더부와 바디부가 있음. 바디부에 이 data를 직접 넣어주겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello" + name; //name에 spring을 넣으면 hello spring , view가 없고 그대로 내려감.
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();

        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
