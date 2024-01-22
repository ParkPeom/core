package hello.core.singleton;

public class SingletonService {

    // 싱글톤 패턴
    private static final SingletonService instance = new SingletonService();

    // new 키워드로 객체 인스턴스가 생성되는 것을 막는다
    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService(){

    }

   public void logic(){
       System.out.println("싱글톤 객체 로직 호출");
   }
}
