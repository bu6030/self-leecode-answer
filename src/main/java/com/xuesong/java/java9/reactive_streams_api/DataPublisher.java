package com.xuesong.java.java9.reactive_streams_api;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import java.util.ArrayList;
import java.util.List;

public class DataPublisher implements Publisher<Data> {

    private List<Subscriber<? super Data>> subscribers;

    public DataPublisher() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(Subscriber<? super Data> subscriber) {
        subscribers.add(subscriber);
    }

    public void publishData(Data data) {
        for (Subscriber<? super Data> subscriber : subscribers) {
            subscriber.onNext(data);
        }
    }

    public void complete() {
        for (Subscriber<? super Data> subscriber : subscribers) {
            subscriber.onComplete();
        }
    }

    public void error(Throwable throwable) {
        for (Subscriber<? super Data> subscriber : subscribers) {
            subscriber.onError(throwable);
        }
    }
}
