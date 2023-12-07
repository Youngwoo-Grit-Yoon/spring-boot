package com.example.demo.repository;

import com.example.demo.domain.Agent;
import org.springframework.data.repository.CrudRepository;

/**
 * 정의된 두 가지 타입은 저장할 객체 타입인 Agent와 고유 ID를 담을 String 타입입니다.
 */
public interface AgentRepository extends CrudRepository<Agent, String> {

}
