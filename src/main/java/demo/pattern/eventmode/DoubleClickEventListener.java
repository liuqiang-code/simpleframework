package demo.pattern.eventmode;

/**
 * User: BigStrong
 * Date: 2021/8/21
 * Description: No Description
 */
public class DoubleClickEventListener implements EventListener{
    @Override
    public void processEvent(Event event) {
        if ("doubleclick".equals(event.getType())) {
            System.out.println("双击被触发了");
        }
    }
}
