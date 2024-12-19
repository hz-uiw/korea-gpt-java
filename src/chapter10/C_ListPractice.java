package chapter10;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

/*
    이벤트 관리 시스템
    - 이벤트 참가자 명단 대기열 관리를 위한 시스템
    - 참가자는 사전 등록된 명단을 통해 이벤트에 참가
    - 명단이 꽉 차면 대기열로 추가, 참가자가 떠나면 대기열에 다음 사람이 추가

    1) 이벤트 참가자 명단 관리
        사전에 등록, 이벤트 당일에는 추가적인 참가자 등록이 안됨
        ArrayList (목록 추가, 삭제 X 참가자 조회 O)

    2) 대기열 관리
        이벤트에는 한정된 좌석, 좌석이 모두 차면 추가 도착 참가자들은 대기열에 등록
        LinkedList (목록 추가, 삭제 O 참가자 조회 X)
 */
class EventManagement {
    // 필드
    // 이벤트 참가자 명단
    ArrayList<String> participantList = new ArrayList<>();
    // 대기열 명단
    LinkedList<String> waitingQueue = new LinkedList<>();

    // 메서드
    void addParticipant(String name) {
        participantList.add(name);
    }

    void addToWaitingQueue(String name) {
            waitingQueue.add(name);
    }

    void leaveParticipant(String name) {
        if (waitingQueue.size() > 0) {
            String nextParticipant = waitingQueue.remove(0);
            addParticipant(nextParticipant);
        }
    }

    boolean checkParticipant(String name) {
        return participantList.contains(name);
    }
}
public class C_ListPractice {
    public static void main(String[] args) {
        EventManagement eventManagement = new EventManagement();

        eventManagement.addParticipant("권민창");
        eventManagement.addParticipant("김민성");
        eventManagement.addParticipant("백가민");
        eventManagement.addParticipant("정현영");
        eventManagement.addParticipant("허신신");

        eventManagement.addToWaitingQueue("장준환");
        eventManagement.addToWaitingQueue("고현영");
        eventManagement.addToWaitingQueue("박수지");
        eventManagement.addToWaitingQueue("권민");

        System.out.println(eventManagement.participantList); // [권민창, 김민성, 백가민, 정현영, 허신신]
        System.out.println(eventManagement.waitingQueue); // [장준환, 고현영, 박수지, 권민]

        eventManagement.leaveParticipant("권민창");
        System.out.println(eventManagement.participantList); // [권민창, 김민성, 백가민, 정현영, 허신신, 장준환]

        eventManagement.leaveParticipant("정현영");
        System.out.println(eventManagement.participantList); // [권민창, 김민성, 백가민, 정현영, 허신신, 장준환, 고현영]

        System.out.println(eventManagement.checkParticipant("정현영"));
        System.out.println(eventManagement.checkParticipant("홍길동"));

        System.out.println(eventManagement.waitingQueue); // [박수지, 권민]



    }
}
