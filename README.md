# Spring Boot
Spring Boot 공부
- 의존성 관리
- 배포
- 자동 설정
## JPA 사용을 위한 Database 접속 정보
application.properties 참고
```text
# Database
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://127.0.0.1:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=password

# JPA
spring.jpa.hibernate.ddl-auto=create
```
## Spring Boot를 *.war 파일로 빌드하여 외부 톰캣에 배포하기
### 1. SpringBootServletInitializer 상속
```text
package com.thehecklers.planefinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PlanefinderApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PlanefinderApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(PlanefinderApplication.class);
	}

}
```
### 2. pom.xml 파일에 war 추가
```text
<groupId>com.thehecklers</groupId>
<artifactId>planefinder</artifactId>
<version>0.0.1-SNAPSHOT</version>
<packaging>war</packaging>
<name>planefinder</name>
<description>Data feed for Spring Boot Up and Running</description>
```
### 3. 빌드 후 톰캣의 webapps 디렉토리에 ROOT.war 파일로 저장
```text
11567441 -rw-r--r--   1 youngwooyoon  staff    45M 12 21 13:46 ROOT.war
11555433 drwxr-x---@ 61 youngwooyoon  staff   1.9K 12  8 08:31 docs
11555624 drwxr-x---@  8 youngwooyoon  staff   256B 12  8 08:31 examples
11556076 drwxr-x---@  7 youngwooyoon  staff   224B 12  8 08:31 host-manager
11555602 drwxr-x---@  9 youngwooyoon  staff   288B 12  8 08:31 manager
```
### 4. 톰캣 실행하여 ROOT 디렉토리 생성 확인
```text
11567677 drwxr-x---   5 youngwooyoon  staff   160B 12 21 13:47 ROOT
11567441 -rw-r--r--   1 youngwooyoon  staff    45M 12 21 13:46 ROOT.war
11555433 drwxr-x---@ 61 youngwooyoon  staff   1.9K 12  8 08:31 docs
11555624 drwxr-x---@  8 youngwooyoon  staff   256B 12  8 08:31 examples
11556076 drwxr-x---@  7 youngwooyoon  staff   224B 12  8 08:31 host-manager
11555602 drwxr-x---@  9 youngwooyoon  staff   288B 12  8 08:31 manager
```
### 5. 외부 라이브러리(gson)를 jar 파일로 직접 의존성 주입
pom.xml
```text
... 내용 생략 ...
<dependency>
    <groupId>gson</groupId>
    <artifactId>gson</artifactId>
    <version>1.0</version>
    <scope>system</scope>
    <systemPath>${project.basedir}/gson-2.10.1.jar</systemPath>
</dependency>
... 내용 생략 ...
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-war-plugin</artifactId>
            <configuration>
                <webResources>
                    <resource>
                        <directory>${project.basedir}</directory>
                        <includes>
                            <include>gson-2.10.1.jar</include>
                        </includes>
                        <targetPath>WEB-INF/lib</targetPath>
                    </resource>
                </webResources>
            </configuration>
        </plugin>
    </plugins>
</build>
```