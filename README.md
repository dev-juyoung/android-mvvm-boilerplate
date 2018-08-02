Android MVVM Boilerplate
========================

### Project Structure Information


### Android Studio IDE setup

- Android Studio가 실행중인 경우, IDE를 닫는다.

- `ktlint`를 다운로드 받는다.

  `curl -sSLO https://github.com/shyiko/ktlint/releases/download/0.24.0/ktlint && chmod a+x ktlint`
  
  or
  
  `brew install shyiko/ktlint/ktlint`
  
- 프로젝트의 최상위 경로에서 아래 명령어 실행

  `ktlint --apply-to-idea-project --android`
 
- 문법 검사 태스크 실행

  `./gradlew check` or `./gradlew ktlin`
  
- 오류 문법에 대한 자동 포매팅 태스크 실행
  
  `./gradlew ktlintFormat`
  
### Used Libraries

- Code Quality
  
  - [ktlint][ktlint]
  
    > [Kotlin Code Conventions][kotlin-conventions] 및 [Android Kotlin Code Style][kotlin-android-codestyle]이 반영된 Linter

- DI
  
  - [Koin][koin]
  
    > Kotlin을 위한 경량 DI 프레임워크

- Network

  - [OkHttp3][okhttp]
  
    > HTTP / HTTP2 네트워크 클라이언트
  
  - [Retrofit2][retrofit]
  
    > REST API 네트워크 클라이언트
  
  - [Glide][glide]
  
    > 이미지 로드 및 캐싱

- Reactive Programming

  - [RxJava2][rxjava]
    
    > 비동기 및 이벤트 기반 프로그래밍을 위한 라이브러리
  
  - [RxAndroid][rxandroid]
  
    > RxJava2를 위한 안드로이드 특정 바인딩 라이브러리

- Development Helper Tools

  - [Timber][timber]
  
    > Log 출력을 위한 라이브러리
  
  - [Stetho][stetho]
  
    > Chrome Inspect 와 연계한 디버깅 툴
  
  - [LeakCanary][leakcanary]
  
    > Memory Leak 확인을 위한 라이브러리

[koin]: https://github.com/InsertKoinIO/koin
[ktlint]: https://github.com/shyiko/ktlint
[android-ktx]: https://github.com/android/android-ktx
[retrofit]: https://github.com/square/retrofit
[okhttp]: https://github.com/square/okhttp
[glide]: https://github.com/bumptech/glide
[rxjava]: https://github.com/ReactiveX/RxJava
[rxandroid]: https://github.com/ReactiveX/RxAndroid
[timber]: https://github.com/JakeWharton/timber
[stetho]: https://github.com/facebook/stetho
[leakcanary]: https://github.com/square/leakcanary

[kotlin-conventions]: https://kotlinlang.org/docs/reference/coding-conventions.html
[kotlin-android-codestyle]: https://android.github.io/kotlin-guides/style.html
