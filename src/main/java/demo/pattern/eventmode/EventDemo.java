package demo.pattern.eventmode;

/**
 * User: BigStrong
 * Date: 2021/8/21
 * Description: 事件模式
 */
public class EventDemo {
    public static void main(String[] args) {
        // 事件
        Event event = new Event();
        event.setType("singleclick");

        // 事件监听者
        EventListener singleLister = new SingleClickEventListener();
        EventListener doubleLister = new DoubleClickEventListener();

        // 事件源
        EventSource eventSource = new EventSource();

        // 事件源注册监听者
        eventSource.register(singleLister);
        eventSource.register(doubleLister);

        // 发布事件
        eventSource.publicEvent(event);
    }
}
