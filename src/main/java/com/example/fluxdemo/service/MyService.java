package com.example.fluxdemo.service;

import com.example.fluxdemo.domain.AgBimProject;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Package: com.example.fluxdemo.service
 * @ClassName: MyService
 * @Description:
 * @UpdateDate: 2021/3/25 17:12
 */
public interface MyService {
    Mono<AgBimProject> getByProjectName(String projectName);
    Flux<AgBimProject> getPage(int limit, int offset);
}
