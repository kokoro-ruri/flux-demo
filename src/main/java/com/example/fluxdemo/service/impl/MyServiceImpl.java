package com.example.fluxdemo.service.impl;

import com.example.fluxdemo.domain.AgBimProject;
import com.example.fluxdemo.mapper.MyMapper;
import com.example.fluxdemo.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * @Package: com.example.fluxdemo.service.impl
 * @ClassName: MyServiceImpl
 * @Description:
 * @UpdateDate: 2021/3/25 17:12
 */
@Service
public class MyServiceImpl implements MyService {
    @Autowired
    MyMapper myMapper;

    @Override
    public Mono<AgBimProject> getByProjectName(String projectName) {
        Mono<AgBimProject> agBimProjectMono = Mono.justOrEmpty(myMapper.getByProjectName(projectName));
        return agBimProjectMono;
    }

    @Override
    public Flux<AgBimProject> getPage(int limit, int offset){
//        Flux<AgBimProject> agBimProjectFlux = Flux.fromIterable(myMapper.getPage(limit, offset));
        Flux<AgBimProject> agBimProjectFlux1 = Flux.fromStream(myMapper.getPage(limit, offset).stream().peek(x -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        return agBimProjectFlux1;
    }
}
