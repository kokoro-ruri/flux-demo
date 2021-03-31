package com.example.fluxdemo.controller;

import com.example.fluxdemo.domain.AgBimProject;
import com.example.fluxdemo.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Package: com.example.fluxdemo.controller
 * @ClassName: MyController
 * @Description:
 * @UpdateDate: 2021/3/25 17:24
 */
@RestController
@RequestMapping("/agBimProject")
public class MyController {
    private final MyService myService;

    //推荐使用构造器注入（强制依赖，不可为null）或者setter方法注入（非强制依赖，可为null）
    @Autowired
    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/getByProjectName")
    public Mono<AgBimProject> getByProjectName(){
        String projectName = "中山一院南沙院区（10栋）";
        return myService.getByProjectName(projectName);
    }

    @GetMapping(value = "/getPage/{limit}/{offset}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<AgBimProject> getPage(@PathVariable("limit") String limit, @PathVariable("offset") String offset){
        return myService.getPage(Integer.parseInt(limit), Integer.parseInt(offset));
    }
}
