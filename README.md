# Book Suwon 
- 수원시 도서관 서비스의 정보를 이용해서 책들에 리뷰를 남기는 서비스

# [5. Review CRUD](https://github.com/misolab/book-suwon/issues/5)
1. ~~작성화면으로 이동하면~~
2. ~~(로그인 기반으로)대출 내역을 조회하고~~
3. ~~리뷰를 작성해보자~~
4. Review로 저장하자  
  * Entity & flyway
5. 리뷰를 조회하자 (guest)
  * 메인화면으로 최신 리뷰를 조회 

# [4. User session](https://github.com/misolab/book-suwon/issues/4)
- 로그인 후 세션에 저장하고
- 외부 데이터 조회를 이용하자
  - 외부 세션이 만료되면 우리도 세션 close (목록 조회하면서...)

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