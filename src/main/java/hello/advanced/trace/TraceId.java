package hello.advanced.trace;

import java.util.UUID;

public class TraceId {
    private String id;
    private int level;

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    private String createId() {
        //생성된 uuid의 앞 8자리만 사용 -> 로그 중 어떤 요청인지 파악하기 위함 + 깊이 또한 판단.
        return UUID.randomUUID().toString().substring(0,8);
    }

    private TraceId(String id, int level) { //생성자로 생성 불가능
        this.id = id;
        this.level = level;
    }

    public TraceId createNextId(){  //im on the next level~
        return new TraceId(id, level+1);
    }

    public TraceId createPreviousId(){  //다시 되돌아간다.
        return new TraceId(id, level-1);
    }

    public boolean isFirstLevel(){  //true일 시 그냥 삭제 false일 시 previousId 생성
        return level == 0;
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }
}
