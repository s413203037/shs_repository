package com.shs.nxstudy.no5_core.guava.eventbus;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * @author 奈学-肖秋平老师 Eric
 * 观察者模式，类似消息中间件
 **/
public class EventBusTest {

    static class MessageEvent {
        //Message Header
        //RocketMQ flag 1byte
        //TOPIC 1byte
        //Secret  1byte

        //Message Body
        private String payload;
        private long id;
        private String name;

        //Message footer

        public MessageEvent(String payload) {
            this.payload = payload;
        }
    }

    static class MessageSubscriber {

        @Subscribe
        public void sub(MessageEvent event) {
            System.out.println("consume event >>> " + event.payload);
        }
    }

    static class MessagePub {
        // Queue  store thousands of messages 消息过多时，消费不过来，需要缓冲队列存储，

        private EventBus eventBus;

        public MessagePub() {
            eventBus = new EventBus();
            eventBus.register(new MessageSubscriber());
        }

        public void pubEvent(MessageEvent event) {
            eventBus.post(event);
        }
    }

    public static void main(String[] args) {
        MessagePub pub = new MessagePub();
        for(int i =0; i<10000000; i++) {
            pub.pubEvent(new MessageEvent("小片片"));
        }
    }
}
