# Book Suwon 
- 수원시 도서관 서비스의 정보를 이용해서 책들에 리뷰를 남기는 서비스

# [3.Login UI & DB](https://github.com/misolab/book-suwon/issues/3)
- 우선 UI를 만들어서 통신이 되는지
  - Controller
  - login.html
- 수신된 파라미터를 이용해서 도서관 인증받고 정보 저장
  - User CRUD

# [2.OutDataService](https://github.com/misolab/book-suwon/issues/2)
- 외부 서비스와 통신으로 인증 및 데이터를 가져온다

# [1.프로젝트 생성](https://github.com/misolab/book-suwon/issues/1)
```mvn archetype:generate \
-DarchetypeCatalog=local \
-DarchetypeGroupId=com.misolab \
-DarchetypeArtifactId=springboot-webapp-archetype \
-DarchetypeVersion=0.0.3 \
-DgroupId=com.misolab \
-Dversion=0.1 \
-DartifactId=book-suwon