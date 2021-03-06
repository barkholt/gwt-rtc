/*
 * Copyright 2013 Xi CHEN
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.seanchenxi.gwt.html.client.event;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.shared.EventHandler;
import com.seanchenxi.gwt.html.client.EventType;

/**
 * User: Xi
 */
public class AbortEvent<E extends NativeEvent> extends FnEvent<E, AbortEvent.Handler<E>> {

    public interface Handler<E extends NativeEvent> extends EventHandler {
        void onAbort(AbortEvent<E> event);
    }

    static Type<Handler<NativeEvent>> TYPE;

    private AbortEvent() {
        super();
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <E extends NativeEvent> Type<Handler<E>> getType() {
        if (TYPE == null) {
            TYPE = new Type<Handler<NativeEvent>>(EventType.ABORT, new AbortEvent<NativeEvent>());
        }
        return (Type) TYPE;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public Type<Handler<E>> getAssociatedType() {
        return (Type) TYPE;
    }

    @Override
    protected void dispatch(Handler<E> handler) {
        handler.onAbort(this);
    }

}
