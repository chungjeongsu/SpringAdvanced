package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;

public interface LogTrace {

    //traceStatus를 반환(처음 추적 시작 시 사용)
    TraceStatus begin(String message);

    //trace가 끝났을 때, 사용
    void end(TraceStatus status);

    //trace에서 예외 처리를 위한 메소드
    void exception(TraceStatus status, Exception e);
}
