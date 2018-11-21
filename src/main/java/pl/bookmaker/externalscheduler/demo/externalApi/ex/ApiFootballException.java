package pl.bookmaker.externalscheduler.demo.externalApi.ex;

public class ApiFootballException extends RuntimeException{

  public ApiFootballException(){
    super();
  }

  public ApiFootballException(String message) {
    super(message);
  }

  public ApiFootballException(String message, Throwable throwable) {
    super(message, throwable);
  }

  public ApiFootballException(Throwable throwable) {
    super(throwable);
  }
}
