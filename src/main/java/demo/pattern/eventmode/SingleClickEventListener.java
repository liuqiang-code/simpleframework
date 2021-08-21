package demo.pattern.eventmode;

/**
 * User: BigStrong
 * Date: 2021/8/21
 * Description: No Description
 */
public class SingleClickEventListener implements EventListener{
    @Override
    public void processEvent(Event event) {
        if ("singleclick".equals(event.getType())) {
            System.out.println("单机被触发");
        }
    }
}
