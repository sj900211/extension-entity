# Extension > Entity
> Entity 설계 및 기능 정의
> - ## [EntityAutoConfiguration](./src/main/java/run/freshr/common/configurations/EntityAutoConfiguration.java)
>> EntityProperties 에 설정한 값으로 EntityData 를 빌드한다.
> - ## [EntityProperties](./src/main/java/run/freshr/common/properties/EntityProperties.java)
>> 프로젝트에 따라 변경되는 데이터 설정 항목의 정보를 변경할 수 있는 Properties 정의  
>> 프로젝트에서 사용할 때에는 application.yml 에서 각 정보를 변경할 수 있다.
>> ``` yaml
>> freshr:
>>   entity:
>>     access-expiration: 900
>> ```
> - ## [EntityData](./src/main/java/run/freshr/common/data/EntityData.java)
>> EntityProperties 에 설정한 값으로 빌드되는 Class.  
>> 이 Class 로 데이터 설정 값을 설정하거나 프로젝트에서 사용
> - ## [EntityValidateUtil](./src/main/java/run/freshr/common/utils/EntityValidateUtil.java)
>> Entity 공통 검증 기능 정의
> - ## common/enumerations
>> 공통 ENUM 데이터를 정의
> - ## domain/*
>> 도메인 단위 모델의 schema
>> - ### domain/**/dto
>>> DTO 모델을 정의
>>> DTO 에는 세 가지 유형을 관리
>>> - #### request
>>>> 요청 모델 관리
>>> - #### response
>>> 반환 모델 관리
>>> - #### data
>>>> 요청이나 반환이 아닌 서비스에서 서비스로 전달하는 모델이나, 다른 서비스의 요청 & 반환 모델에서 공통으로 사용되는 해당 서비스의 모델을 관리
>> - ### domain/**/entity
>>> Entity 관리
>>> - #### embedded
>>>> 다중 PK 모델 관리
>>> - #### inherit
>>>> 상속 전략 모델 관리
>> - ### domain/**/redis
>>> Redis hash 관리
>> - ### domain/**/elasticsearch
>>> Elasticsearch index 관리
>> - ### domain/**/enumerations
>>> ENUM 관리
>> - ### domain/**/repository
>>> Repository 관리  
>>> Repository 에는 세 가지 유형을 관리
>>> - #### jpa
>>>> Entity repository 관리
>>> - #### redis
>>>> Redis repository 관리
>>> - #### elasticsearch
>>>> Elasticsearch repository 관리
>> - ### domain/**/unit
>>> Unit 기능 관리  
>>> Unit 에는 세 가지 유형을 관리
>>> - #### jpa
>>>> Entity unit 관리
>>> - #### redis
>>>> Redis unit 관리
>>> - #### elasticsearch
>>>> Elasticsearch unit 관리